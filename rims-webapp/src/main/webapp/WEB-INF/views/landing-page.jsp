<%@ include file="/WEB-INF/views/fragments/taglib-import.jsp"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:th="http://www.thymeleaf.org"
    xmlns:sec="http://www.thymeleaf.org/extras/spring-security" lang="en">

<head>
    <c:import url="/WEB-INF/views/fragments/common-head.jsp"></c:import>
    <link href="/assets/icon_fonts_assets/font-awesome/css/font-awesome.min.css" rel="stylesheet">
</head>

<body class="auth-wrapper">
    <div class="all-wrapper menu-side with-pattern">
        <div class="auth-box-w">
            <div class="logo-w">
                <a href="index.html"><img alt="" src="/assets/img/logo-big.png"></a>
                <div class="text-center h3">
                    <fmt:message key="application.name" />
                </div>
                <div id="messageHolder">
                    <c:if test="${param.logout eq 'true'}">
                        <div class='alert alert-success alert-dismissible fade show' role='alert'> <button
                                aria-label='Close' class='close' data-dismiss='alert' type='button'><span
                                    aria-hidden='true'>
                                    &times;</span></button>You've been logged out
                            successfully..</div>
                    </c:if>
                </div>
            </div>
            <h4 class="auth-header">
                Login Form
            </h4>
            <form action="/auth/login" name="loginForm" method="post">
                <div class="form-group">
                    <label for="">Username</label><input class="form-control" name="username"
                        placeholder="Enter your username" type="text">
                    <div class="pre-icon os-icon os-icon-user-male-circle"></div>
                </div>
                <div class="form-group">
                    <label for="">Password</label><input class="form-control" name="password"
                        placeholder="Enter your password" type="password">
                    <div class="pre-icon os-icon os-icon-fingerprint"></div>
                </div>
                <div class="form-group">
                    <label class="form-check-label"><input class="form-check-input" type="checkbox"
                            name="remember-me">Remember
                        Me</label>
                </div>
                <div class="buttons-w text-center">
                    <button class="btn btn-primary" id="loginSubmit">Login</button>
                </div>
            </form>
        </div>
    </div>

    <script src="/assets/bower_components/jquery/dist/jquery.min.js" type="text/javascript"></script>
    <script src="/assets/bower_components/bootstrap/js/dist/util.js"></script>
    <script src="/assets/bower_components/bootstrap/js/dist/alert.js"></script>
    <script type="text/javascript">
        $(document)
            .ready(
                function () {
                    $("form[name='loginForm'] button[id=loginSubmit]")
                        .click(
                            function (event) {
                                event.preventDefault();
                                var submitButton = $(this);
                                submitButton.html('<i class="fa fa-spinner fa-spin"></i>&nbsp;Logging in..');
                                var formElement = $("form[name='loginForm']");
                                submitButton.attr("disabled", "disabled");
                                var dangerMessageDiv = "<div class='alert alert-danger alert-dismissible fade show' role='alert'>  <button aria-label='Close' class='close' data-dismiss='alert' type='button'><span aria-hidden='true'> x</span></button><strong>Login Failed!</strong> {message}  </div>";
                                $.ajax({
                                    url: formElement
                                        .attr('action'),
                                    type: formElement
                                        .attr('method'),
                                    data: formElement
                                        .serialize(),
                                    success: function (data,
                                        status) {
                                        if (data) {
                                            window.location
                                                .replace(location.pathname);
                                        } else {
                                            var loginFailedMessage = "Try again with correct username and password combination.";
                                            $("#messageHolder").html(dangerMessageDiv.replace("{message}", loginFailedMessage));
                                        }
                                    },
                                    error: function (e) {
                                        console.log("ERROR: ",
                                            e);
                                        var loginFailedMessage = "Unable to reach server, Check your internet connection and try again.";
                                        $("#messageHolder").html(dangerMessageDiv.replace("{message}", loginFailedMessage));
                                    },
                                    done: function (e) {
                                        console.log("DONE");
                                    }
                                });
                                submitButton.removeAttr("disabled");
                                submitButton.html('Login');
                            });
                });</script>

</body>

</html>
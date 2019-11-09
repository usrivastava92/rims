<%@ include file="/WEB-INF/views/fragments/taglib-import.jsp"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml"  lang="en">
  <head>
<c:import url="/WEB-INF/views/fragments/common-head.jsp"></c:import>
  </head>
  <body class="auth-wrapper">
    <div class="all-wrapper menu-side with-pattern">
      <div class="auth-box-w">
        <div class="logo-w">
          <a href="index.html"><img alt="" src="/assets/img/logo-big.png"></a>
          <div class="text-center h3"><fmt:message key="application.name" /></div>
        </div>
        <h4 class="auth-header">
          Login Form
        </h4>
        <form action="">
          <div class="form-group">
            <label for="">Username</label><input class="form-control" placeholder="Enter your username" type="text">
            <div class="pre-icon os-icon os-icon-user-male-circle"></div>
          </div>
          <div class="form-group">
            <label for="">Password</label><input class="form-control" placeholder="Enter your password" type="password">
            <div class="pre-icon os-icon os-icon-fingerprint"></div>
          </div>
          <div class="buttons-w">
            <button class="btn btn-primary">Log me in</button>
            <div class="form-check-inline">
              <label class="form-check-label"><input class="form-check-input" type="checkbox">Remember Me</label>
            </div>
          </div>
        </form>
      </div>
    </div>
  </body>
</html>

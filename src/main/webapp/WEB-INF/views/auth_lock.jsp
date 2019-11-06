<%@ include file="/WEB-INF/views/fragments/taglib-import.jsp"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml"  lang="en">
  <head>
<th:block th:include="fragments/common-head.html :: common-head">
  </th:block>
  </head>
  <body class="auth-wrapper">
    <div class="all-wrapper menu-side with-pattern">
      <div class="auth-box-w wider centered">
        <div class="logo-w">
          <a href="index.html"><img alt="" src="/assets/img/logo-big.png"></a>
          <div class="text-center h3"><fmt:message key="application.name" /></div>
        </div>
        <h5 class="auth-header">
          Welcome Back
        </h5>
        <div class="logged-user-w">
          <div class="avatar-w">
            <security:authentication var="profilePicUrl" property="principal.userAdditionalInfoPo.profileImageLink">
          <img alt="" src="${profilePicUrl}" onerror="this.src='img/avatar1.jpg'">
        </security:authentication>
          </div>
          <div class="logged-user-name">
            <span class="text-capitalize" sec:authentication="name">Anonymous</span>
          </div>
          <div class="logged-user-role">
            Administrator
          </div>
        </div>
        <form action="">
          <div class="form-group">
            <label for="">Enter your password to access admin</label><input class="form-control" placeholder="Enter your password" type="password">
            <div class="pre-icon os-icon os-icon-fingerprint"></div>
          </div>
          <div class="buttons-w">
            <button class="btn btn-primary">Log me in</button><a class="btn btn-link" href="/auth/login.html">Login as different user</a>
          </div>
        </form>
      </div>
    </div>
  </body>
</html>

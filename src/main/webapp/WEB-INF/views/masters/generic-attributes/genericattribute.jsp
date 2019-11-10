<%@ include file="/WEB-INF/views/fragments/taglib-import.jsp"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:th="http://www.thymeleaf.org"
  xmlns:sec="http://www.thymeleaf.org/extras/spring-security" lang="en">

<head>
  <c:import url="/WEB-INF/views/fragments/common-head.jsp"></c:import>
</head>

<body class="menu-position-side menu-side-left full-screen">
  <div class="all-wrapper solid-bg-all">
    <c:import url="/WEB-INF/views/fragments/top-menu-search.jsp"></c:import>
    <div class="layout-w">
      <!--------------------
        START - Mobile Menu
        -------------------->
      <c:import url="/WEB-INF/views/fragments/mobile-menu.jsp"></c:import>
      <!--------------------
        END - Mobile Menu
        -------------------->
      <!--------------------
        START - Main Menu
        -------------------->
      <c:import url="/WEB-INF/views/fragments/side-menu.jsp"></c:import>
      <!--------------------
        END - Main Menu
        -------------------->
      <div class="content-w">
        <!--------------------
          START - Top Bar
          -------------------->
        <c:import url="/WEB-INF/views/fragments/top-menu.jsp"></c:import>
        <!--------------------
          END - Top Bar
          -------------------->
        <!--------------------
          START - Breadcrumbs
          -------------------->
        <ul class="breadcrumb">
          <li class="breadcrumb-item">
            <a href="index.html">Home</a>
          </li>
          <li class="breadcrumb-item">
            <a href="index.html">Products</a>
          </li>
          <li class="breadcrumb-item">
            <span>Laptop with retina screen</span>
          </li>
        </ul>
        <!--------------------
          END - Breadcrumbs
          -------------------->
        <div class="content-i">
          <div class="content-box">
            <div class="element-wrapper">
              <h6 class="element-header">
                Users
              </h6>
              <div class="element-box">
                <h5 class="form-header">
                </h5>
                <div class="form-desc">
                </div>
                <div class="table-responsive">
                  <table id="genericAttributesTable" width="100%" class="table table-striped table-lightfont">
                    <thead>
                      <tr>
                        <th>Sno.</th>
                        <th>Username</th>
                        <th>First Name</th>
                        <th>Last Name</th>
                        <th>Creation Time</th>
                        <th>Approval Status</th>
                      </tr>
                    </thead>
                    <tfoot>
                      <tr>
                        <th>Sno.</th>
                        <th>Username</th>
                        <th>First Name</th>
                        <th>Last Name</th>
                        <th>Creation Time</th>
                        <th>Approval Status</th>
                      </tr>
                    </tfoot>
                    <!--<tbody>
                      <tr th:each="user,iter : ${users}">
                        <td th:text="${iter.count}">1</td>
                        <td><a th:text="${user.username}" th:href="@{'/users/get/'+${user.id}}">Edinburgh</a></td>
                        <td class="text-capitalize" th:text="${user.userAdditionalInfoPo.firstname}">Tiger</td>
                        <td class="text-capitalize" th:text="${user.userAdditionalInfoPo.lastname}">Nixon</td>
                        <td th:text="${user.creationTimeStamp}">2019-10-05 15:32:27.395</td>
                        <td th:text="${user.userEnabled}">true</td>
                      </tr>-->
                    </tbody>
                  </table>
                </div>
              </div>
            </div>
            <c:import url="/WEB-INF/views/fragments/overdraw-elements.jsp"></c:import>
          </div>
        </div>
      </div>
    </div>
    <div class="display-type"></div>
  </div>
  <c:import url="/WEB-INF/views/fragments/common-scripts.jsp"></c:import>
  <script>
    (function (i, s, o, g, r, a, m) {
      i['GoogleAnalyticsObject'] = r; i[r] = i[r] || function () {
        (i[r].q = i[r].q || []).push(arguments)
      }, i[r].l = 1 * new Date(); a = s.createElement(o),
        m = s.getElementsByTagName(o)[0]; a.async = 1; a.src = g; m.parentNode.insertBefore(a, m)
    })(window, document, 'script', 'https://www.google-analytics.com/analytics.js', 'ga');

    ga('create', 'UA-XXXXXXX-9', 'auto');
    ga('send', 'pageview');
  </script>
  <script>
    $(document).ready(function () {
      $.ajax({
        'url': "/genericattributes/all",
        'method': "GET",
        'contentType': 'application/json'
      }).done(function (data) {
        console.log(data);
        $('#genericAttributesTable').dataTable({
          "aaData": data,
          "columns": [
            { "data": "id" },
            { "data": "name" },
            { "data": "detail_alias" },
            { "data": "points" }
          ]
        })
      })
    })
  </script>
</body>

</html>
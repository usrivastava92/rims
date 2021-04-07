<%@ include file="/WEB-INF/views/fragments/taglib-import.jsp"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:th="http://www.thymeleaf.org"
  xmlns:sec="http://www.thymeleaf.org/extras/spring-security" lang="en">

<head>
  <c:import url="/WEB-INF/views/fragments/common-head.jsp"></c:import>
  <link href="/assets/icon_fonts_assets/font-awesome/css/font-awesome.min.css" rel="stylesheet">
</head>

<body class="menu-position-side menu-side-left full-screen">
  <div class="all-wrapper solid-bg-all">
    <div class="search-with-suggestions-w">
      <div class="search-with-suggestions-modal">
        <div class="element-search">
          <input class="search-suggest-input" placeholder="Start typing to search..." type="text">
          <div class="close-search-suggestions">
            <i class="os-icon os-icon-x"></i>
          </div>
          </input>
        </div>
        <div class="search-suggestions-group">
          <div class="ssg-header">
            <div class="ssg-icon">
              <div class="os-icon os-icon-box"></div>
            </div>
            <div class="ssg-name">
              Projects
            </div>
            <div class="ssg-info">
              24 Total
            </div>
          </div>
          <div class="ssg-content">
            <div class="ssg-items ssg-items-boxed">
              <a class="ssg-item" href="users_profile_big.html">
                <div class="item-media" style="background-image: url(/assets/img/company6.png)"></div>
                <div class="item-name">
                  Integ<span>ration</span> with API
                </div>
              </a><a class="ssg-item" href="users_profile_big.html">
                <div class="item-media" style="background-image: url(/assets/img/company7.png)"></div>
                <div class="item-name">
                  Deve<span>lopm</span>ent Project
                </div>
              </a>
            </div>
          </div>
        </div>
        <div class="search-suggestions-group">
          <div class="ssg-header">
            <div class="ssg-icon">
              <div class="os-icon os-icon-users"></div>
            </div>
            <div class="ssg-name">
              Customers
            </div>
            <div class="ssg-info">
              12 Total
            </div>
          </div>
          <div class="ssg-content">
            <div class="ssg-items ssg-items-list">
              <a class="ssg-item" href="users_profile_big.html">
                <div class="item-media" style="background-image: url(/assets/img/avatar1.jpg)"></div>
                <div class="item-name">
                  John Ma<span>yer</span>s
                </div>
              </a><a class="ssg-item" href="users_profile_big.html">
                <div class="item-media"
                  style="background-image: url(	https://scontent.fdel30-1.fna.fbcdn.net/v/t31.0-8/1397349_535172419912359_1425229961_o.jpg?_nc_cat=102&_nc_oc=AQlpiXvh8txfpfmk7p_oHv5FK1h7B02lVuRyxfRGomqI0h_iblvOrZgM2zw54h1-c70&_nc_ht=scontent.fdel30-1.fna&oh=70c3d1de4e57f3ae5ab5845fb71f8912&oe=5E2C25CD)">
                </div>
                <div class="item-name">
                  Th<span>omas</span> Mullier
                </div>
              </a><a class="ssg-item" href="users_profile_big.html">
                <div class="item-media"
                  style="background-image: url(	https://scontent.fdel30-1.fna.fbcdn.net/v/t1.0-9/22489690_1344309625681439_8014554153500542429_n.jpg?_nc_cat=102&_nc_oc=AQmrIwHzIAvf6QF8df52qYZn50YJdiT4yBg_Oh167unhwLvT0WMZ2skf7vVQxA4GMt8&_nc_ht=scontent.fdel30-1.fna&oh=c6b3e2056b4aa936f9858e284c810e1d&oe=5DF0A06F)">
                </div>
                <div class="item-name">
                  Kim C<span>olli</span>ns
                </div>
              </a>
            </div>
          </div>
        </div>
        <div class="search-suggestions-group">
          <div class="ssg-header">
            <div class="ssg-icon">
              <div class="os-icon os-icon-folder"></div>
            </div>
            <div class="ssg-name">
              Files
            </div>
            <div class="ssg-info">
              17 Total
            </div>
          </div>
          <div class="ssg-content">
            <div class="ssg-items ssg-items-blocks">
              <a class="ssg-item" href="#">
                <div class="item-icon">
                  <i class="os-icon os-icon-file-text"></i>
                </div>
                <div class="item-name">
                  Work<span>Not</span>e.txt
                </div>
              </a><a class="ssg-item" href="#">
                <div class="item-icon">
                  <i class="os-icon os-icon-film"></i>
                </div>
                <div class="item-name">
                  V<span>ideo</span>.avi
                </div>
              </a><a class="ssg-item" href="#">
                <div class="item-icon">
                  <i class="os-icon os-icon-database"></i>
                </div>
                <div class="item-name">
                  User<span>Tabl</span>e.sql
                </div>
              </a><a class="ssg-item" href="#">
                <div class="item-icon">
                  <i class="os-icon os-icon-image"></i>
                </div>
                <div class="item-name">
                  wed<span>din</span>g.jpg
                </div>
              </a>
            </div>
            <div class="ssg-nothing-found">
              <div class="icon-w">
                <i class="os-icon os-icon-eye-off"></i>
              </div>
              <span>No files were found. Try changing your query...</span>
            </div>
          </div>
        </div>
      </div>
    </div>
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
            <a href="/users">Reports</a>
          </li>
        </ul>
        <!--------------------
          END - Breadcrumbs
          -------------------->
        <div class="content-i">
          <div class="content-box">
            <div class="element-wrapper">
              <h6 class="element-header">
                Reports
              </h6>
              <div class="element-box">
                <h5 class="form-header">
                </h5>
                <div class="form-desc">
                </div>
                <div class="table-responsive">
                  <table id="dataTable1" width="100%" class="table table-striped table-lightfont">
                    <thead>
                      <tr>
                        <th>Sno.</th>
                        <th>Report</th>
                        <th>Code</th>
                        <th>Creation Time</th>
                        <th>Approval Status</th>
                        <th>Actions</th>
                      </tr>
                    </thead>
                    <tfoot>
                      <tr>
                        <th>Sno.</th>
                        <th>Report</th>
                        <th>Code</th>
                        <th>Creation Time</th>
                        <th>Approval Status</th>
                        <th>Actions</th>
                      </tr>
                    </tfoot>
                    <tbody>
                      <c:forEach var="report" items="${reports}" varStatus="iter">
                        <tr>
                          <td>${iter.count}</td>
                          <td>
                            <a href="/reports/get/${report.id}">${report.id}</a>
                          </td>
                          <td class="text-capitalize">${report.name}</td>
                          <td class="text-capitalize">${report.code}</td>
                          <td>${user.creationTimeStamp}</td>
                          <td>${user.approvalStatus}</td>
                          <td><a href="/reports/get/${report.id}"><i data-placement="top" data-toggle="tooltip"
                                title="Edit record" class="fa text--green fa-pencil-square fa-2x"></i></a>&nbsp;<a
                              data-placement="top" data-toggle="tooltip" title="Mark for deletion"
                              href="/reports/remove/${report.id}"><i
                                class="text--orange fa fa-times-circle fa-2x"></i></a>
                          </td>
                        </tr>
                      </c:forEach>
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
</body>

</html>
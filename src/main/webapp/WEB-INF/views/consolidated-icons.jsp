<%@ include file="/WEB-INF/views/fragments/taglib-import.jsp"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:th="http://www.thymeleaf.org"
  xmlns:sec="http://www.thymeleaf.org/extras/spring-security" lang="en">

<head>
  <c:import url="/WEB-INF/views/fragments/common-head.jsp"></c:import>
  <link href="icon_fonts_assets/entypo/style.css" rel="stylesheet">
  <link href="icon_fonts_assets/batch-icons/style.css" rel="stylesheet">
  <link href="icon_fonts_assets/dashicons/dashicons.css" rel="stylesheet">
  <link href="icon_fonts_assets/dripicons/webfont.css" rel="stylesheet">
  <link href="icon_fonts_assets/eightyshades/style.css" rel="stylesheet">
  <link href="icon_fonts_assets/feather/style.css" rel="stylesheet">
  <link href="/assets/icon_fonts_assets/font-awesome/css/font-awesome.min.css" rel="stylesheet">
  <link href="icon_fonts_assets/foundation-icon-font/foundation-icons.css" rel="stylesheet">
  <link href="icon_fonts_assets/metrize-icons/style.css" rel="stylesheet">
  <link href="icon_fonts_assets/picons-social/style.css" rel="stylesheet">
  <link href="icon_fonts_assets/picons-thin/style.css" rel="stylesheet">
  <link href="icon_fonts_assets/simple-line-icons/css/simple-line-icons.css" rel="stylesheet">
  <link href="icon_fonts_assets/themefy/themify-icons.css" rel="stylesheet">
  <link href="icon_fonts_assets/typicons/typicons.css" rel="stylesheet">
  <link href="icon_fonts_assets/weather-icons/css/weather-icons.min.css" rel="stylesheet">
</head>

<body class="menu-position-side menu-side-left full-screen">
  <div class="all-wrapper with-side-panel solid-bg-all">
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
            <a href="/index.html">Home</a>
          </li>
          <li class="breadcrumb-item">
            <a href="/icons">Icons</a>
          </li>
        </ul>
        <!--------------------
              END - Breadcrumbs
              -------------------->
        <div class="content-i">
          <div class="content-box">
            <div class="element-wrapper">
              <h6 class="element-header">
                Icons
              </h6>
              <div class="element-box">
                <fieldset class="form-group">
                  <legend><span>Search Icons</span></legend>
                </fieldset>
                <div class="table-responsive">
                  <table id="icons" width="100%" class="table table-striped table-lightfont">
                    <thead>
                      <tr>
                        <th>Sno.</th>
                        <th>Icon</th>
                        <th>Html</th>
                        <th>Css Link</th>
                      </tr>
                    </thead>
                    <tr th:each="iconStub : ${iconStubs}">
                      <td th:text="${iconStub.sno}"></td>
                      <td th:text="${iconStub.iconTag}"></td>
                      <td th:text="${iconStub.iconTag}"></td>
                      <td th:text="${iconStub.cssLink}"></td>
                    </tr>
                    <tfoot>
                      <tr>
                        <th>Sno.</th>
                        <th>Icon</th>
                        <th>Html</th>
                        <th>Css Link</th>
                      </tr>
                    </tfoot>
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
  <script src="/assets/bower_components/jquery/dist/jquery.min.js"></script>
  <script src="/assets/bower_components/popper-js/dist/umd/popper.min.js"></script>
  <script src="/assets/bower_components/moment/moment.js"></script>
  <script src="/assets/bower_components/chart-js/dist/Chart.min.js"></script>
  <script src="/assets/bower_components/select2/dist/js/select2.full.min.js"></script>
  <script src="/assets/bower_components/jquery-bar-rating/dist/jquery.barrating.min.js"></script>
  <script src="/assets/bower_components/ckeditor/ckeditor.js"></script>
  <script src="/assets/bower_components/bootstrap-validator/dist/validator.min.js"></script>
  <script src="/assets/bower_components/bootstrap-daterangepicker/daterangepicker.js"></script>
  <script src="/assets/bower_components/ion-rangeslider/js/ion-rangeslider.min.js"></script>
  <script src="/assets/bower_components/dropzone/dist/dropzone.js"></script>
  <script src="/assets/bower_components/editable-table/mindmup-editabletable.js"></script>
  <script src="/assets/bower_components/datatables-net/js/jquery.dataTables.min.js"></script>
  <script src="/assets/bower_components/datatables-net-bs/js/dataTables.bootstrap.min.js"></script>
  <script src="/assets/bower_components/fullcalendar/dist/fullcalendar.min.js"></script>
  <script src="/assets/bower_components/perfect-scrollbar/js/perfect-scrollbar.jquery.min.js"></script>
  <script src="/assets/bower_components/tether/dist/js/tether.min.js"></script>
  <script src="/assets/bower_components/slick-carousel/slick/slick.min.js"></script>
  <script src="/assets/bower_components/bootstrap/js/dist/util.js"></script>
  <script src="/assets/bower_components/bootstrap/js/dist/alert.js"></script>
  <script src="/assets/bower_components/bootstrap/js/dist/button.js"></script>
  <script src="/assets/bower_components/bootstrap/js/dist/carousel.js"></script>
  <script src="/assets/bower_components/bootstrap/js/dist/collapse.js"></script>
  <script src="/assets/bower_components/bootstrap/js/dist/dropdown.js"></script>
  <script src="/assets/bower_components/bootstrap/js/dist/modal.js"></script>
  <script src="/assets/bower_components/bootstrap/js/dist/tab.js"></script>
  <script src="/assets/bower_components/bootstrap/js/dist/tooltip.js"></script>
  <script src="/assets/bower_components/bootstrap/js/dist/popover.js"></script>
  <script src="/assets/js/dataTables.bootstrap4.min.js"></script>
  <script src="/assets/js/demo_customizer.js?version=4.4.0"></script>
  <script src="/assets/js/main.js?version=4.4.0"></script>
  <script>
    (function (i, s, o, g, r, a, m) {
      i["GoogleAnalyticsObject"] = r;
      (i[r] =
        i[r] ||
        function () {
          (i[r].q = i[r].q || []).push(arguments);
        }),
        (i[r].l = 1 * new Date());
      (a = s.createElement(o)), (m = s.getElementsByTagName(o)[0]);
      a.async = 1;
      a.src = g;
      m.parentNode.insertBefore(a, m);
    })(
      window,
      document,
      "script",
      "https://www.google-analytics.com/analytics.js",
      "ga"
    );

    ga("create", "UA-XXXXXXX-9", "auto");
    ga("send", "pageview");
  </script>
  <script>
    $(document).ready(function () {

      populateRecords();

      var datatable = $("#icons").DataTable({
        "scrollX": true,
        aoColumns: [
          {
            mDataProp: "sno",
            bSortable: true,
            sWidth: "5%"
          },
          {
            mDataProp: "iconTag",
            bSortable: true,
            mRender: function (data, type, row) {
              return (
                "<a href='#'>" + data + "</a>"
              );
            },
            sWidth: "5%"
          },
          {
            mDataProp: "iconTag",
            bSortable: true,
            mRender: function (data, type, row) {
              return (
                "&lt;" + data.substr(1)
              );
            },
            sWidth: "30%"
          },
          {
            mDataProp: "cssLink",
            bSortable: true,
            mRender: function (data, type, row) {
              return (
                "&lt;" + data.substr(1)
              );
            },
            sWidth: "60%"
          }
        ]
      });

      function populateRecords() {
        $.ajax({
          type: "GET",
          contentType: "application/json",
          url: "/get/icons",
          dataType: "json",
          timeout: 100000,
          success: function (data) {
            populateDataTable(data);
          },
          error: function (e) {
            console.log("ERROR: ", e);
          },
          done: function (e) {
            console.log("DONE");
          }
        });
      }

      function populateDataTable(data) {
        datatable.clear().draw();
        datatable.rows.add(data);
        datatable.columns.adjust().draw();
      }

    });
  </script>
</body>

</html>
<%@ include file="/WEB-INF/views/fragments/taglib-import.jsp"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:th="http://www.thymeleaf.org"
  xmlns:sec="http://www.thymeleaf.org/extras/spring-security" lang="en">

<head>
  <c:import url="/WEB-INF/views/fragments/common-head.jsp"></c:import>
  <link href="/assets/icon_fonts_assets/font-awesome/css/font-awesome.min.css" rel="stylesheet" />
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
            <a href="/products">Product</a>
          </li>
        </ul>
        <!--------------------
              END - Breadcrumbs
              -------------------->
        <div class="content-i">
          <div class="content-box">
            <div class="element-wrapper">
              <h6 class="element-header">
                Product
              </h6>
              <div class="element-box">
                <form th:object="${product}">
                  <fieldset class="form-group">
                    <legend><span>Product Category</span></legend>
                    <div class="row">
                      <div class="col-sm-12 text-center">
                        <span th:text="*{productClassification.parentCategory1}"></span>
                        <span class="font-weight-bold text--red">&nbsp;>>&nbsp;</span>
                        <span th:text="*{productClassification.parentCategory2}"></span>
                        <span class="font-weight-bold text--red">&nbsp;>>&nbsp;</span>
                        <span th:text="*{productClassification.subCategory1}"></span>
                        <span class="font-weight-bold text--red">&nbsp;>>&nbsp;</span>
                        <span th:text="*{productClassification.subCategory2}"></span>
                      </div>
                    </div>
                  </fieldset>
                  <fieldset class="form-group">
                    <legend><span>Product Details</span></legend>
                    <div class="row">
                      <div class="col-sm-6">
                        <div class="form-group">
                          <label for="">Code</label><input class="form-control" type="text" th:field="*{code}">
                        </div>
                      </div>
                      <div class="col-sm-6">
                        <div class="form-group">
                          <label for="">Name</label><input class="form-control" type="text" th:field="*{name}">
                        </div>
                      </div>
                    </div>
                    <div class="row">
                      <div class="col-sm-6">
                        <div class="form-group">
                          <label for="">Creation Time</label><input class="form-control" type="text"
                            th:field="*{creationTimeStamp}">
                        </div>
                      </div>
                      <div class="col-sm-6">
                        <div class="form-group">
                          <label for="">Approval Status</label><input class="form-control" type="text"
                            th:field="*{approvalStatus}">
                        </div>
                      </div>
                    </div>
                    <div class="row">
                      <div class="form-group col-lg-12">
                        <label for="">Attributes</label><select class="form-control select2" multiple="true">
                          <option th:each="genericAttribute : ${product.genericAttributes}"
                            th:text="${genericAttribute.name}" selected="true" th:value="${genericAttribute.id}">
                            Generic Attribute
                          </option>
                        </select>
                      </div>
                    </div>
                    <div class="row">
                      <div class="form-group col-lg-12">
                        <label for="">Vendors</label><select class="form-control select2">
                          <option th:each="vendor : ${product.vendors}" th:text="${vendor.name}" selected="true"
                            th:value="${vendor.id}">
                            Vendor
                          </option>
                        </select>
                      </div>
                    </div>
                  </fieldset>
                </form>
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

</body>

</html>
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
            <a href="/genericattributes">Generic Attributes</a>
          </li>
        </ul>
        <!--------------------
          END - Breadcrumbs
          -------------------->
        <div class="content-i">
          <div class="content-box">
            <div class="element-wrapper">
              <h6 class="element-header">
                Generic Attributes
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
                        <th>Id</th>
                        <th>Code</th>
                        <th>Dtype</th>
                        <th>Name</th>
                        <th>Creation Time</th>
                        <th>Approval Status</th>
                        <th>Actions</th>
                      </tr>
                    </thead>
                    <tfoot>
                      <tr>
                        <th>Id</th>
                        <th>Code</th>
                        <th>Dtype</th>
                        <th>Name</th>
                        <th>Creation Time</th>
                        <th>Approval Status</th>
                        <th>Actions</th>
                      </tr>
                    </tfoot>
                    <!--<tbody>
                      <tr th:each="genericAttribute,iter : ${genericAttributes}">
                        <td th:text="${iter.count}">1</td>
                        <td><a th:text="${genericAttribute.code}"
                            th:href="@{'/genericattributes/get/'+${genericAttribute.id}}">Edinburgh</a></td>
                        <td th:text="${genericAttribute.dtype}">dtype</td>
                        <td th:text="${genericAttribute.name}">name</td>
                        <td th:text="${genericAttribute.description}">Nixon</td>
                        <td th:text="${genericAttribute.creationTimeStamp}">2019-10-05 15:32:27.395</td>
                        <td th:text="${genericAttribute.approvalStatus}">0</td>
                        <td><a th:href="@{'/genericattributes/get/'+${genericAttribute.id}}"><i data-placement="top"
                              data-toggle="tooltip" title="Edit record"
                              class="fa text--green fa-pencil-square fa-2x"></i></a>&nbsp;<a data-placement="top"
                            data-toggle="tooltip" title="Mark for deletion"
                            th:href="@{'/genericattributes/remove/'+${genericAttribute.id}}"><i
                              class="text--orange fa fa-times-circle fa-2x"></i></a>
                        </td>
                      </tr>
                    </tbody>-->
                  </table>
                </div>
              </div>
            </div>
            <!--Large modal--><button class="mr-2 mb-2 btn btn-primary" data-target=".bd-example-modal-lg"
              data-toggle="modal"> Large modal</button>
            <div aria-hidden="true" aria-labelledby="myLargeModalLabel" class="modal fade bd-example-modal-lg"
              role="dialog" tabindex="-1">
              <div class="modal-dialog modal-lg">
                <div class="modal-content">
                  <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">
                      Modal title
                    </h5>
                    <button aria-label="Close" class="close" data-dismiss="modal" type="button"><span
                        aria-hidden="true"> &times;</span></button>
                  </div>
                  <div class="modal-body">
                    <form>
                      <div class="form-group">
                        <label for=""> Email address</label><input class="form-control" placeholder="Enter email"
                          type="email">
                      </div>
                      <div class="row">
                        <div class="col-sm-6">
                          <div class="form-group">
                            <label for=""> Password</label><input class="form-control" placeholder="Password"
                              type="password">
                          </div>
                        </div>
                        <div class="col-sm-6">
                          <div class="form-group">
                            <label for="">Confirm Password</label><input class="form-control" placeholder="Password"
                              type="password">
                          </div>
                        </div>
                      </div>
                    </form>
                  </div>
                  <div class="modal-footer">
                    <button class="btn btn-secondary" data-dismiss="modal" type="button"> Close</button><button
                      class="btn btn-primary" type="button"> Save changes</button>
                  </div>
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

      var datatable = $("#genericAttributesTable").DataTable({
        aoColumns: [
          {
            mDataProp: "id",
            sWidth: "5%",
            bSortable: true
          },
          {
            mDataProp: "code",
            bSortable: true,
            sWidth: "20%",
            mRender: function (data, type, row) {
              return (
                "<a href='/genericattributes/get/" + row.id + "'>" + data + "</a>"
              );
            }
          },
          {
            mDataProp: "dtype",
            sWidth: "12%",
            bSortable: true
          },
          {
            mDataProp: "name",
            bSortable: true,
            sWidth: "20%",
            mRender: function (data, type, row) {
              return (
                data
              );
            }
          },
          {
            mDataProp: "creationTimeStamp",
            sWidth: "18%",
            bSortable: true
          },
          {
            mDataProp: "approvalStatus",
            bSortable: true,
            sWidth: "15%"
          },
          {
            mDataProp: "id",
            bSortable: false,
            sWidth: "10%",
            mRender: function (data, type, full) {
              return (
                "<a href='/genericattributes/get/" +
                data +
                "'><i data-placement='top' data-toggle='tooltip' title='Edit record' class='fa text--green fa-pencil-square fa-2x'></i></a>&nbsp;<a data-placement='top' data-toggle='tooltip' title='Mark for deletion' href='/genericattributes/remove/" +
                data +
                "'><i class='text--orange fa fa-times-circle fa-2x'></i></a>"
              );
            }
          }
        ]
      });


      $.ajax({
        'url': "/genericattributes/all",
        'method': "GET",
        'contentType': 'application/json'
      }).done(function (data) {
        datatable.clear().draw();
        datatable.rows.add(data);
        datatable.columns.adjust().draw();
      })
    })
  </script>
</body>

</html>
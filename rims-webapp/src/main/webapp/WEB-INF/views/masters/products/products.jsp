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
            <a href="/products">Products</a>
          </li>
        </ul>
        <!--------------------
              END - Breadcrumbs
              -------------------->
        <div class="content-i">
          <div class="content-box">
            <div class="element-wrapper">
              <h6 class="element-header">
                Products
              </h6>
              <div class="element-box">
                <form id="formValidate">
                  <fieldset class="form-group">
                    <legend><span>Filter Products
                    </legend>
                    <div class="row">
                      <div class="form-group col-md-2 col-lg-3">
                        <label for="parentCategory1">Category-1</label>
                        <select class="ajax-dropdown form-control select2" id="parentCategory1">
                        </select>
                      </div>
                      <div class="form-group col-md-2 col-lg-3">
                        <label for="parentCategory2">Category-2</label>
                        <select class="ajax-dropdown form-control select2" id="parentCategory2">
                        </select>
                      </div>
                      <div class="form-group col-md-2 col-lg-3">
                        <label for="subCategory1">Category-3</label>
                        <select class="ajax-dropdown form-control select2" id="subCategory1">
                        </select>
                      </div>
                      <div class="form-group col-md-2 col-lg-3">
                        <label for="subCategory2">Category-4</label>
                        <select class="ajax-dropdown form-control select2" id="subCategory2">
                        </select>
                      </div>
                    </div>
                  </fieldset>
                </form>
                <fieldset class="form-group">
                  <legend><span>Product Records</span></legend>
                </fieldset>
                <div class="table-responsive">
                  <table id="productRecords" width="100%" class="table table-striped table-lightfont">
                    <thead>
                      <tr>
                        <th>Sno.</th>
                        <th>Code</th>
                        <th>Name</th>
                        <th>Creation Time</th>
                        <th>Approval Status</th>
                        <th>Actions</th>
                      </tr>
                    </thead>
                    <tfoot>
                      <tr>
                        <th>Sno.</th>
                        <th>Code</th>
                        <th>Name</th>
                        <th>Creation Time</th>
                        <th>Approval Status</th>
                        <th>Actions</th>
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
  <c:import url="/WEB-INF/views/fragments/common-scripts.jsp"></c:import>
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

      var elementId = "parentCategory1";
      var filterJson = {};
      filterJson["element"] = elementId;

      populateDropdown(elementId, filterJson);

      $(".ajax-dropdown").change(function () {
        var requestJson = {};
        var nextElementIndex = $(".ajax-dropdown").index(this) + 1;
        var nextElementId = null;
        var filterJson = {};
        $(".ajax-dropdown").each(function (index, value) {
          if (index < nextElementIndex) {
            filterJson[this.id] = this.value;
          } else {
            $(this).html("");
            if (index == nextElementIndex) {
              nextElementId = this.id;
            }
          }
        });
        if (nextElementId != null) {
          requestJson["element"] = nextElementId;
          requestJson["filterJson"] = filterJson;
          populateDropdown(nextElementId, requestJson);
        } else {
          populateProductRecords(filterJson);
        }
      });

      function populateDropdown(elementId, requestJson) {
        console.log(requestJson);
        $.ajax({
          url: "/products/populatefilter",
          type: "post",
          data: JSON.stringify(requestJson),
          dataType: "json",
          contentType: "application/json",
          success: function (data) {
            addOptionsToElement(elementId, data);
          },
          error: function (e) {
            console.log(e);
          }
        });
      }

      function addOptionsToElement(elementId, data) {
        var element = $("#" + elementId);
        element.html("<option value='choose'>-- select --</option>");
        $.each(data, function (key, value) {
          element.append(
            '<option value="' + value + '">' + value + "</option>"
          );
        });
        element.focus();
      }

      var datatable = $("#productRecords").DataTable({
        aoColumns: [
          {
            mDataProp: "id",
            sWidth: "5%",
            bSortable: true
          },
          {
            mDataProp: "code",
            bSortable: true,
            sWidth: "10%",
            mRender: function (data, type, row) {
              return (
                "<a href='/products/get/" + row.id + "'>" + data + "</a>"
              );
            }
          },
          {
            mDataProp: "name",
            sWidth: "45%",
            bSortable: true
          },
          {
            mDataProp: "creationTimeStamp",
            bSortable: true,
            sWidth: "20%",
            mRender: function (data, type, row) {
              return (
                data
              );
            }
          },
          {
            mDataProp: "approvalStatus",
            sWidth: "10%",
            bSortable: true
          },
          {
            mDataProp: "id",
            bSortable: false,
            sWidth: "10%",
            mRender: function (data, type, full) {
              return (
                "<a href='/product/get/" +
                data +
                "'><i data-placement='top' data-toggle='tooltip' title='Edit record' class='fa text--green fa-pencil-square fa-2x'></i></a>&nbsp;<a data-placement='top' data-toggle='tooltip' title='Mark for deletion' href='/product/remove/" +
                data +
                "'><i class='text--orange fa fa-times-circle fa-2x'></i></a>"
              );
            }
          }
        ]
      });

      /*datatable.on('click', 'tr', function () {
        var data = datatable.row(this).data();
      });*/

      function populateProductRecords(filterJson) {
        $.ajax({
          type: "POST",
          contentType: "application/json",
          url: "/products/filter",
          data: JSON.stringify(filterJson),
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

      $.ajax({
        'url': "/products/get/all",
        'method': "GET",
        'contentType': 'application/json'
      }).done(function (data) {
        populateDataTable(data);
      })


    });
  </script>
</body>

</html>
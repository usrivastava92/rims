<%@ include file="/WEB-INF/views/fragments/taglib-import.jsp"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml"  lang="en">
  <head>
<th:block th:include="fragments/common-head.html :: common-head">
  </th:block>
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
                  <div class="item-media" style="background-image: url(	https://scontent.fdel30-1.fna.fbcdn.net/v/t31.0-8/1397349_535172419912359_1425229961_o.jpg?_nc_cat=102&_nc_oc=AQlpiXvh8txfpfmk7p_oHv5FK1h7B02lVuRyxfRGomqI0h_iblvOrZgM2zw54h1-c70&_nc_ht=scontent.fdel30-1.fna&oh=70c3d1de4e57f3ae5ab5845fb71f8912&oe=5E2C25CD)"></div>
                  <div class="item-name">
                    Th<span>omas</span> Mullier
                  </div>
                </a><a class="ssg-item" href="users_profile_big.html">
                  <div class="item-media" style="background-image: url(	https://scontent.fdel30-1.fna.fbcdn.net/v/t1.0-9/22489690_1344309625681439_8014554153500542429_n.jpg?_nc_cat=102&_nc_oc=AQmrIwHzIAvf6QF8df52qYZn50YJdiT4yBg_Oh167unhwLvT0WMZ2skf7vVQxA4GMt8&_nc_ht=scontent.fdel30-1.fna&oh=c6b3e2056b4aa936f9858e284c810e1d&oe=5DF0A06F)"></div>
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
        --------------------><!--------------------
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
          <div class="top-bar color-scheme-light">
            <div class="fancy-selector-w">
              <div class="fancy-selector-current">
                <div class="fs-img shadowless">
                  <img alt="" src="/assets/img/company5.png">
                </div>
                <div class="fs-main-info">
                  <div class="fs-name">
                    Mail Sender Product
                  </div>
                  <div class="fs-sub">
                    <span>New Tickets:</span><strong>14</strong>
                  </div>
                </div>
                <div class="fs-selector-trigger">
                  <i class="os-icon os-icon-arrow-down4"></i>
                </div>
              </div>
              <div class="fancy-selector-options">
                <div class="fancy-selector-option">
                  <div class="fs-img shadowless">
                    <img alt="" src="/assets/img/company1.png">
                  </div>
                  <div class="fs-main-info">
                    <div class="fs-name">
                      CMS Product
                    </div>
                    <div class="fs-sub">
                      <span>New Tickets:</span><strong>32</strong>
                    </div>
                  </div>
                </div>
                <div class="fancy-selector-option active">
                  <div class="fs-img shadowless">
                    <img alt="" src="/assets/img/company5.png">
                  </div>
                  <div class="fs-main-info">
                    <div class="fs-name">
                      Server Product
                    </div>
                    <div class="fs-sub">
                      <span>New Tickets:</span><strong>17</strong>
                    </div>
                  </div>
                </div>
                <div class="fancy-selector-option">
                  <div class="fs-img shadowless">
                    <img alt="" src="/assets/img/company3.png">
                  </div>
                  <div class="fs-main-info">
                    <div class="fs-name">
                      Compute Engine
                    </div>
                    <div class="fs-sub">
                      <span>New Tickets:</span><strong>11</strong>
                    </div>
                  </div>
                </div>
              </div>
            </div>
            <!--------------------
            START - Top Menu Controls
            -------------------->
            <div class="top-menu-controls">
              <div class="element-search autosuggest-search-activator">
                <input placeholder="Start typing to search..." type="text">
              </div>
              <!--------------------
              START - Messages Link in secondary top menu
              -------------------->
              <div class="messages-notifications os-dropdown-trigger os-dropdown-position-left">
                <i class="os-icon os-icon-mail-14"></i>
                <div class="new-messages-count">
                  12
                </div>
                <div class="os-dropdown light message-list">
                  <ul>
                    <li>
                      <a href="#">
                        <div class="user-avatar-w">
                          <security:authentication var="profilePicUrl" property="principal.userAdditionalInfoPo.profileImageLink">
          <img alt="" src="${profilePicUrl}" onerror="this.src='img/avatar1.jpg'">
        </security:authentication>
                        </div>
                        <div class="message-content">
                          <h6 class="message-from">
                            <span class="text-capitalize" sec:authentication="name">Anonymous</span>
                          </h6>
                          <h6 class="message-title">
                            Account Update
                          </h6>
                        </div>
                      </a>
                    </li>
                    <li>
                      <a href="#">
                        <div class="user-avatar-w">
                          <img alt="" src="	https://scontent.fdel30-1.fna.fbcdn.net/v/t31.0-8/1397349_535172419912359_1425229961_o.jpg?_nc_cat=102&_nc_oc=AQlpiXvh8txfpfmk7p_oHv5FK1h7B02lVuRyxfRGomqI0h_iblvOrZgM2zw54h1-c70&_nc_ht=scontent.fdel30-1.fna&oh=70c3d1de4e57f3ae5ab5845fb71f8912&oe=5E2C25CD">
                        </div>
                        <div class="message-content">
                          <h6 class="message-from">
                            Phil Jones
                          </h6>
                          <h6 class="message-title">
                            Secutiry Updates
                          </h6>
                        </div>
                      </a>
                    </li>
                    <li>
                      <a href="#">
                        <div class="user-avatar-w">
                          <img alt="" src="	https://scontent.fdel30-1.fna.fbcdn.net/v/t1.0-9/22489690_1344309625681439_8014554153500542429_n.jpg?_nc_cat=102&_nc_oc=AQmrIwHzIAvf6QF8df52qYZn50YJdiT4yBg_Oh167unhwLvT0WMZ2skf7vVQxA4GMt8&_nc_ht=scontent.fdel30-1.fna&oh=c6b3e2056b4aa936f9858e284c810e1d&oe=5DF0A06F">
                        </div>
                        <div class="message-content">
                          <h6 class="message-from">
                            Bekky Simpson
                          </h6>
                          <h6 class="message-title">
                            Vacation Rentals
                          </h6>
                        </div>
                      </a>
                    </li>
                    <li>
                      <a href="#">
                        <div class="user-avatar-w">
                          <img alt="" src="/assets/img/avatar4.jpg">
                        </div>
                        <div class="message-content">
                          <h6 class="message-from">
                            Alice Priskon
                          </h6>
                          <h6 class="message-title">
                            Payment Confirmation
                          </h6>
                        </div>
                      </a>
                    </li>
                  </ul>
                </div>
              </div>
              <!--------------------
              END - Messages Link in secondary top menu
              --------------------><!--------------------
              START - Settings Link in secondary top menu
              -------------------->
              <div class="top-icon top-settings os-dropdown-trigger os-dropdown-position-left">
                <i class="os-icon os-icon-ui-46"></i>
                <div class="os-dropdown">
                  <div class="icon-w">
                    <i class="os-icon os-icon-ui-46"></i>
                  </div>
                  <ul>
                    <li>
                      <a href="users_profile_small.html"><i class="os-icon os-icon-ui-49"></i><span>Profile Settings</span></a>
                    </li>
                    <li>
                      <a href="users_profile_small.html"><i class="os-icon os-icon-grid-10"></i><span>Billing Info</span></a>
                    </li>
                    <li>
                      <a href="users_profile_small.html"><i class="os-icon os-icon-ui-44"></i><span>My Invoices</span></a>
                    </li>
                    <li>
                      <a href="users_profile_small.html"><i class="os-icon os-icon-ui-15"></i><span>Cancel Account</span></a>
                    </li>
                  </ul>
                </div>
              </div>
              <!--------------------
              END - Settings Link in secondary top menu
              --------------------><!--------------------
              START - User avatar and menu in secondary top menu
              -------------------->
              <div class="logged-user-w">
                <div class="logged-user-i">
                  <div class="avatar-w">
                    <security:authentication var="profilePicUrl" property="principal.userAdditionalInfoPo.profileImageLink">
          <img alt="" src="${profilePicUrl}" onerror="this.src='img/avatar1.jpg'">
        </security:authentication>
                  </div>
                  <div class="logged-user-menu color-style-bright">
                    <div class="logged-user-avatar-info">
                      <div class="avatar-w">
                        <security:authentication var="profilePicUrl" property="principal.userAdditionalInfoPo.profileImageLink">
          <img alt="" src="${profilePicUrl}" onerror="this.src='img/avatar1.jpg'">
        </security:authentication>
                      </div>
                      <div class="logged-user-info-w">
                        <div class="logged-user-name">
                          <span class="text-capitalize" sec:authentication="name">Anonymous</span>
                        </div>
                        <div class="logged-user-role">
                          Administrator
                        </div>
                      </div>
                    </div>
                    <div class="bg-icon">
                      <i class="os-icon os-icon-wallet-loaded"></i>
                    </div>
                    <ul>
                      <li>
                        <a href="apps_email.html"><i class="os-icon os-icon-mail-01"></i><span>Incoming Mail</span></a>
                      </li>
                      <li>
                        <a href="users_profile_big.html"><i class="os-icon os-icon-user-male-circle2"></i><span>Profile Details</span></a>
                      </li>
                      <li>
                        <a href="users_profile_small.html"><i class="os-icon os-icon-coins-4"></i><span>Billing Details</span></a>
                      </li>
                      <li>
                        <a href="#"><i class="os-icon os-icon-others-43"></i><span>Notifications</span></a>
                      </li>
                      <li>
                        <a href="/auth/logout"><i class="os-icon os-icon-signs-11"></i><span>Logout</span></a>
                      </li>
                    </ul>
                  </div>
                </div>
              </div>
              <!--------------------
              END - User avatar and menu in secondary top menu
              -------------------->
            </div>
            <!--------------------
            END - Top Menu Controls
            -------------------->
          </div>
          <!--------------------
          END - Top Bar
          -------------------->
          <div class="content-i">
            <div class="content-box">
              <div class="row pt-4">
                <div class="col-sm-12">
                  <!--START - Grid of tablo statistics-->
                  <div class="element-wrapper">
                    <div class="element-actions">
                      <form class="form-inline justify-content-sm-end">
                        <select class="form-control form-control-sm rounded">
                          <option value="Pending">
                            Today
                          </option>
                          <option value="Active">
                            Last Week 
                          </option>
                          <option value="Cancelled">
                            Last 30 Days
                          </option>
                        </select>
                      </form>
                    </div>
                    <h6 class="element-header">
                      Support Service Dashboard
                    </h6>
                    <div class="element-content">
                      <div class="tablo-with-chart">
                        <div class="row">
                          <div class="col-sm-5 col-xxl-4">
                            <div class="tablos">
                              <div class="row mb-xl-2 mb-xxl-3">
                                <div class="col-sm-6">
                                  <a class="element-box el-tablo centered trend-in-corner padded bold-label" href="apps_support_index.html">
                                    <div class="value">
                                      24
                                    </div>
                                    <div class="label">
                                      New Tickets
                                    </div>
                                    <div class="trending trending-up-basic">
                                      <span>12%</span><i class="os-icon os-icon-arrow-up2"></i>
                                    </div>
                                  </a>
                                </div>
                                <div class="col-sm-6">
                                  <a class="element-box el-tablo centered trend-in-corner padded bold-label" href="apps_support_index.html">
                                    <div class="value">
                                      12
                                    </div>
                                    <div class="label">
                                      Closed Today
                                    </div>
                                    <div class="trending trending-down-basic">
                                      <span>12%</span><i class="os-icon os-icon-arrow-down"></i>
                                    </div>
                                  </a>
                                </div>
                              </div>
                              <div class="row">
                                <div class="col-sm-6">
                                  <a class="element-box el-tablo centered trend-in-corner padded bold-label" href="apps_support_index.html">
                                    <div class="value">
                                      52
                                    </div>
                                    <div class="label">
                                      Agent Replies
                                    </div>
                                    <div class="trending trending-up-basic">
                                      <span>12%</span><i class="os-icon os-icon-arrow-up2"></i>
                                    </div>
                                  </a>
                                </div>
                                <div class="col-sm-6">
                                  <a class="element-box el-tablo centered trend-in-corner padded bold-label" href="apps_support_index.html">
                                    <div class="value">
                                      7
                                    </div>
                                    <div class="label">
                                      New Replies
                                    </div>
                                    <div class="trending trending-down-basic">
                                      <span>12%</span><i class="os-icon os-icon-arrow-down"></i>
                                    </div>
                                  </a>
                                </div>
                              </div>
                            </div>
                          </div>
                          <div class="col-sm-7 col-xxl-8">
                            <!--START - Chart Box-->
                            <div class="element-box pl-xxl-5 pr-xxl-5">
                              <div class="el-tablo bigger highlight bold-label">
                                <div class="value">
                                  12,537
                                </div>
                                <div class="label">
                                  Unique Visitors
                                </div>
                              </div>
                              <div class="el-chart-w">
                                <canvas height="170px" id="lineChart" width="600px"></canvas>
                              </div>
                            </div>
                            <!--END - Chart Box-->
                          </div>
                        </div>
                      </div>
                    </div>
                  </div>
                  <!--END - Grid of tablo statistics-->
                </div>
              </div>
              <div class="row">
                <div class="col-sm-7 col-xxl-6">
                  <!--START - Customers with most tickets-->
                  <div class="element-wrapper">
                    <div class="element-actions">
                      <form class="form-inline justify-content-sm-end">
                        <select class="form-control form-control-sm rounded">
                          <option value="Pending">
                            Today
                          </option>
                          <option value="Active">
                            Last Week 
                          </option>
                          <option value="Cancelled">
                            Last 30 Days
                          </option>
                        </select>
                      </form>
                    </div>
                    <h6 class="element-header">
                      Customers with most tickets
                    </h6>
                    <div class="element-box">
                      <div class="table-responsive">
                        <table class="table table-lightborder">
                          <thead>
                            <tr>
                              <th>
                                Customer Name
                              </th>
                              <th>
                                Tickets
                              </th>
                              <th>
                                Location
                              </th>
                              <th class="text-center">
                                Status
                              </th>
                              <th class="text-right">
                                Last Reply
                              </th>
                            </tr>
                          </thead>
                          <tbody>
                            <tr>
                              <td>
                                <div class="user-with-avatar">
                                  <security:authentication var="profilePicUrl" property="principal.userAdditionalInfoPo.profileImageLink">
          <img alt="" src="${profilePicUrl}" onerror="this.src='img/avatar1.jpg'">
        </security:authentication><span class="d-none d-xl-inline-block"><span class="text-capitalize" sec:authentication="name">Anonymous</span></span>
                                </div>
                              </td>
                              <td class="text-center">
                                15
                              </td>
                              <td class="text-center">
                                <img alt="" src="/assets/img/flags-icons/us.png" width="25px">
                              </td>
                              <td class="text-center">
                                <div class="status-pill green" data-title="Complete" data-toggle="tooltip"></div>
                              </td>
                              <td class="text-right">
                                <span>Today </span><span class="smaller lighter">1:52pm</span>
                              </td>
                            </tr>
                            <tr>
                              <td>
                                <div class="user-with-avatar">
                                  <img alt="" src="	https://scontent.fdel30-1.fna.fbcdn.net/v/t31.0-8/1397349_535172419912359_1425229961_o.jpg?_nc_cat=102&_nc_oc=AQlpiXvh8txfpfmk7p_oHv5FK1h7B02lVuRyxfRGomqI0h_iblvOrZgM2zw54h1-c70&_nc_ht=scontent.fdel30-1.fna&oh=70c3d1de4e57f3ae5ab5845fb71f8912&oe=5E2C25CD"><span class="d-none d-xl-inline-block">Kelly Brans</span>
                                </div>
                              </td>
                              <td class="text-center">
                                12
                              </td>
                              <td class="text-center">
                                <img alt="" src="/assets/img/flags-icons/ca.png" width="25px">
                              </td>
                              <td class="text-center">
                                <div class="status-pill red" data-title="Cancelled" data-toggle="tooltip"></div>
                              </td>
                              <td class="text-right">
                                <span>Yesterday </span><span class="smaller lighter">5:34pm</span>
                              </td>
                            </tr>
                            <tr>
                              <td>
                                <div class="user-with-avatar">
                                  <img alt="" src="	https://scontent.fdel30-1.fna.fbcdn.net/v/t1.0-9/22489690_1344309625681439_8014554153500542429_n.jpg?_nc_cat=102&_nc_oc=AQmrIwHzIAvf6QF8df52qYZn50YJdiT4yBg_Oh167unhwLvT0WMZ2skf7vVQxA4GMt8&_nc_ht=scontent.fdel30-1.fna&oh=c6b3e2056b4aa936f9858e284c810e1d&oe=5DF0A06F"><span class="d-none d-xl-inline-block">Tim Howard</span>
                                </div>
                              </td>
                              <td class="text-center">
                                8
                              </td>
                              <td class="text-center">
                                <img alt="" src="/assets/img/flags-icons/uk.png" width="25px">
                              </td>
                              <td class="text-center">
                                <div class="status-pill green" data-title="Complete" data-toggle="tooltip"></div>
                              </td>
                              <td class="text-right">
                                <span>Jan 15th </span><span class="smaller lighter">3:14pm</span>
                              </td>
                            </tr>
                          </tbody>
                        </table>
                      </div>
                    </div>
                  </div>
                  <!--END - Customers with most tickets-->
                </div>
                <div class="col-sm-5 col-xxl-6">
                  <!--START - Questions per Product-->
                  <div class="element-wrapper">
                    <div class="element-actions">
                      <form class="form-inline justify-content-sm-end">
                        <select class="form-control form-control-sm rounded">
                          <option value="Pending">
                            Today
                          </option>
                          <option value="Active">
                            Last Week 
                          </option>
                          <option value="Cancelled">
                            Last 30 Days
                          </option>
                        </select>
                      </form>
                    </div>
                    <h6 class="element-header">
                      Questions per Product
                    </h6>
                    <div class="element-box">
                      <div class="os-progress-bar primary">
                        <div class="bar-labels">
                          <div class="bar-label-left">
                            <span class="bigger">MailGun</span>
                          </div>
                          <div class="bar-label-right">
                            <span class="info">25 Tickets / 10 Pending</span>
                          </div>
                        </div>
                        <div class="bar-level-1" style="width: 100%">
                          <div class="bar-level-2" style="width: 70%">
                            <div class="bar-level-3" style="width: 40%"></div>
                          </div>
                        </div>
                      </div>
                      <div class="os-progress-bar primary">
                        <div class="bar-labels">
                          <div class="bar-label-left">
                            <span class="bigger">PhotoBook</span>
                          </div>
                          <div class="bar-label-right">
                            <span class="info">18 Tickets / 7 Pending</span>
                          </div>
                        </div>
                        <div class="bar-level-1" style="width: 100%">
                          <div class="bar-level-2" style="width: 40%">
                            <div class="bar-level-3" style="width: 20%"></div>
                          </div>
                        </div>
                      </div>
                      <div class="os-progress-bar primary">
                        <div class="bar-labels">
                          <div class="bar-label-left">
                            <span class="bigger">Transferra</span>
                          </div>
                          <div class="bar-label-right">
                            <span class="info">15 Tickets / 12 Pending</span>
                          </div>
                        </div>
                        <div class="bar-level-1" style="width: 100%">
                          <div class="bar-level-2" style="width: 60%">
                            <div class="bar-level-3" style="width: 30%"></div>
                          </div>
                        </div>
                      </div>
                      <div class="os-progress-bar primary">
                        <div class="bar-labels">
                          <div class="bar-label-left">
                            <span class="bigger">Versioner</span>
                          </div>
                          <div class="bar-label-right">
                            <span class="info">12 Tickets / 4 Pending</span>
                          </div>
                        </div>
                        <div class="bar-level-1" style="width: 100%">
                          <div class="bar-level-2" style="width: 30%">
                            <div class="bar-level-3" style="width: 10%"></div>
                          </div>
                        </div>
                      </div>
                    </div>
                  </div>
                  <!--END - Questions per product-->
                </div>
              </div>
              <div class="row pt-4">
                <div class="col-sm-12">
                  <!--START - Recent Ticket Comments-->
                  <div class="element-wrapper">
                    <h6 class="element-header">
                      Recent Ticket Comments
                    </h6>
                    <div class="element-box-tp">
                      <div class="table-responsive">
                        <table class="table table-padded">
                          <thead>
                            <tr>
                              <th></th>
                              <th>
                                Assigned Agent
                              </th>
                              <th>
                                Last Comment
                              </th>
                              <th class="text-center">
                                Ticket Category
                              </th>
                              <th>
                                Last Reply Date
                              </th>
                              <th>
                                Ticket Status
                              </th>
                              <th>
                                Actions
                              </th>
                            </tr>
                          </thead>
                          <tbody>
                            <tr>
                              <td class="text-center">
                                <input class="form-control" type="checkbox">
                              </td>
                              <td>
                                <div class="user-with-avatar">
                                  <security:authentication var="profilePicUrl" property="principal.userAdditionalInfoPo.profileImageLink">
          <img alt="" src="${profilePicUrl}" onerror="this.src='img/avatar1.jpg'">
        </security:authentication><span><span class="text-capitalize" sec:authentication="name">Anonymous</span></span>
                                </div>
                              </td>
                              <td>
                                <div class="smaller lighter">
                                  I have enabled the software for you, you can try now...
                                </div>
                              </td>
                              <td>
                                <span>Today</span><span class="smaller lighter">1:52am</span>
                              </td>
                              <td class="text-center">
                                <a class="badge badge-success-inverted" href="">Shopping</a>
                              </td>
                              <td class="nowrap">
                                <span class="status-pill smaller green"></span><span>Active</span>
                              </td>
                              <td class="row-actions">
                                <a href="#"><i class="os-icon os-icon-grid-10"></i></a><a href="#"><i class="os-icon os-icon-ui-44"></i></a><a class="danger" href="#"><i class="os-icon os-icon-ui-15"></i></a>
                              </td>
                            </tr>
                            <tr>
                              <td class="text-center">
                                <input class="form-control" type="checkbox">
                              </td>
                              <td>
                                <div class="user-with-avatar">
                                  <img alt="" src="	https://scontent.fdel30-1.fna.fbcdn.net/v/t31.0-8/1397349_535172419912359_1425229961_o.jpg?_nc_cat=102&_nc_oc=AQlpiXvh8txfpfmk7p_oHv5FK1h7B02lVuRyxfRGomqI0h_iblvOrZgM2zw54h1-c70&_nc_ht=scontent.fdel30-1.fna&oh=70c3d1de4e57f3ae5ab5845fb71f8912&oe=5E2C25CD"><span>Mike Bishop</span>
                                </div>
                              </td>
                              <td>
                                <div class="smaller lighter">
                                  Please approve this request so we can move...
                                </div>
                              </td>
                              <td>
                                <span>Jan 19th</span><span class="smaller lighter">3:22pm</span>
                              </td>
                              <td class="text-center">
                                <a class="badge badge-danger-inverted" href="">Cafe</a>
                              </td>
                              <td class="nowrap">
                                <span class="status-pill smaller red"></span><span>Closed</span>
                              </td>
                              <td class="row-actions">
                                <a href="#"><i class="os-icon os-icon-grid-10"></i></a><a href="#"><i class="os-icon os-icon-ui-44"></i></a><a class="danger" href="#"><i class="os-icon os-icon-ui-15"></i></a>
                              </td>
                            </tr>
                            <tr>
                              <td class="text-center">
                                <input class="form-control" type="checkbox">
                              </td>
                              <td>
                                <div class="user-with-avatar">
                                  <img alt="" src="	https://scontent.fdel30-1.fna.fbcdn.net/v/t1.0-9/22489690_1344309625681439_8014554153500542429_n.jpg?_nc_cat=102&_nc_oc=AQmrIwHzIAvf6QF8df52qYZn50YJdiT4yBg_Oh167unhwLvT0WMZ2skf7vVQxA4GMt8&_nc_ht=scontent.fdel30-1.fna&oh=c6b3e2056b4aa936f9858e284c810e1d&oe=5DF0A06F"><span>Terry Crews</span>
                                </div>
                              </td>
                              <td>
                                <div class="smaller lighter">
                                  We will need some login credentials to make...
                                </div>
                              </td>
                              <td>
                                <span>Yesterday</span><span class="smaller lighter">7:45am</span>
                              </td>
                              <td class="text-center">
                                <a class="badge badge-warning-inverted" href="">Restaurants</a>
                              </td>
                              <td class="nowrap">
                                <span class="status-pill smaller yellow"></span><span>Pending</span>
                              </td>
                              <td class="row-actions">
                                <a href="#"><i class="os-icon os-icon-grid-10"></i></a><a href="#"><i class="os-icon os-icon-ui-44"></i></a><a class="danger" href="#"><i class="os-icon os-icon-ui-15"></i></a>
                              </td>
                            </tr>
                            <tr>
                              <td class="text-center">
                                <input class="form-control" type="checkbox">
                              </td>
                              <td>
                                <div class="user-with-avatar">
                                  <security:authentication var="profilePicUrl" property="principal.userAdditionalInfoPo.profileImageLink">
          <img alt="" src="${profilePicUrl}" onerror="this.src='img/avatar1.jpg'">
        </security:authentication><span>Phil Collins</span>
                                </div>
                              </td>
                              <td>
                                <div class="smaller lighter">
                                  I have enabled the software for you, you can try now...
                                </div>
                              </td>
                              <td>
                                <span>Jan 23rd</span><span class="smaller lighter">2:12pm</span>
                              </td>
                              <td class="text-center">
                                <a class="badge badge-primary-inverted" href="">Shopping</a>
                              </td>
                              <td class="nowrap">
                                <span class="status-pill smaller yellow"></span><span>Pending</span>
                              </td>
                              <td class="row-actions">
                                <a href="#"><i class="os-icon os-icon-grid-10"></i></a><a href="#"><i class="os-icon os-icon-ui-44"></i></a><a class="danger" href="#"><i class="os-icon os-icon-ui-15"></i></a>
                              </td>
                            </tr>
                            <tr>
                              <td class="text-center">
                                <input class="form-control" type="checkbox">
                              </td>
                              <td>
                                <div class="user-with-avatar">
                                  <img alt="" src="/assets/img/avatar4.jpg"><span>Katy Pilsner</span>
                                </div>
                              </td>
                              <td>
                                <div class="smaller lighter">
                                  I have tried this solution but it does not open...
                                </div>
                              </td>
                              <td>
                                <span>Jan 12th</span><span class="smaller lighter">9:51am</span>
                              </td>
                              <td class="text-center">
                                <a class="badge badge-danger-inverted" href="">Groceries</a>
                              </td>
                              <td class="nowrap">
                                <span class="status-pill smaller green"></span><span>Active</span>
                              </td>
                              <td class="row-actions">
                                <a href="#"><i class="os-icon os-icon-grid-10"></i></a><a href="#"><i class="os-icon os-icon-ui-44"></i></a><a class="danger" href="#"><i class="os-icon os-icon-ui-15"></i></a>
                              </td>
                            </tr>
                            <tr>
                              <td class="text-center">
                                <input class="form-control" type="checkbox">
                              </td>
                              <td>
                                <div class="user-with-avatar">
                                  <img alt="" src="	https://scontent.fdel30-1.fna.fbcdn.net/v/t31.0-8/1397349_535172419912359_1425229961_o.jpg?_nc_cat=102&_nc_oc=AQlpiXvh8txfpfmk7p_oHv5FK1h7B02lVuRyxfRGomqI0h_iblvOrZgM2zw54h1-c70&_nc_ht=scontent.fdel30-1.fna&oh=70c3d1de4e57f3ae5ab5845fb71f8912&oe=5E2C25CD"><span>Wes Morgan</span>
                                </div>
                              </td>
                              <td>
                                <div class="smaller lighter">
                                  I have enabled the software for you, you can try now...
                                </div>
                              </td>
                              <td>
                                <span>Jan 9th</span><span class="smaller lighter">12:45pm</span>
                              </td>
                              <td class="text-center">
                                <a class="badge badge-primary-inverted" href="">Business</a>
                              </td>
                              <td class="nowrap">
                                <span class="status-pill smaller yellow"></span><span>Pending</span>
                              </td>
                              <td class="row-actions">
                                <a href="#"><i class="os-icon os-icon-grid-10"></i></a><a href="#"><i class="os-icon os-icon-ui-44"></i></a><a class="danger" href="#"><i class="os-icon os-icon-ui-15"></i></a>
                              </td>
                            </tr>
                          </tbody>
                        </table>
                      </div>
                    </div>
                  </div>
                  <!--END - Recent Ticket Comments-->
                </div>
              </div><!--------------------
              START - Color Scheme Toggler
              -------------------->
              <div class="floated-colors-btn second-floated-btn">
                <div class="os-toggler-w">
                  <div class="os-toggler-i">
                    <div class="os-toggler-pill"></div>
                  </div>
                </div>
                <span>Dark </span><span>Colors</span>
              </div>
              <!--------------------
              END - Color Scheme Toggler
              --------------------><!--------------------
              START - Demo Customizer
              -------------------->
              <div class="floated-customizer-btn third-floated-btn">
                <div class="icon-w">
                  <i class="os-icon os-icon-ui-46"></i>
                </div>
                <span>Customizer</span>
              </div>
              <div class="floated-customizer-panel">
                <div class="fcp-content">
                  <div class="close-customizer-btn">
                    <i class="os-icon os-icon-x"></i>
                  </div>
                  <div class="fcp-group">
                    <div class="fcp-group-header">
                      Menu Settings
                    </div>
                    <div class="fcp-group-contents">
                      <div class="fcp-field">
                        <label for="">Menu Position</label><select class="menu-position-selector">
                          <option value="left">
                            Left
                          </option>
                          <option value="right">
                            Right
                          </option>
                          <option value="top">
                            Top
                          </option>
                        </select>
                      </div>
                      <div class="fcp-field">
                        <label for="">Menu Style</label><select class="menu-layout-selector">
                          <option value="compact">
                            Compact
                          </option>
                          <option value="full">
                            Full
                          </option>
                          <option value="mini">
                            Mini
                          </option>
                        </select>
                      </div>
                      <div class="fcp-field with-image-selector-w">
                        <label for="">With Image</label><select class="with-image-selector">
                          <option value="yes">
                            Yes
                          </option>
                          <option value="no">
                            No
                          </option>
                        </select>
                      </div>
                      <div class="fcp-field">
                        <label for="">Menu Color</label>
                        <div class="fcp-colors menu-color-selector">
                          <div class="color-selector menu-color-selector color-bright selected"></div>
                          <div class="color-selector menu-color-selector color-dark"></div>
                          <div class="color-selector menu-color-selector color-light"></div>
                          <div class="color-selector menu-color-selector color-transparent"></div>
                        </div>
                      </div>
                    </div>
                  </div>
                  <div class="fcp-group">
                    <div class="fcp-group-header">
                      Sub Menu
                    </div>
                    <div class="fcp-group-contents">
                      <div class="fcp-field">
                        <label for="">Sub Menu Style</label><select class="sub-menu-style-selector">
                          <option value="flyout">
                            Flyout
                          </option>
                          <option value="inside">
                            Inside/Click
                          </option>
                          <option value="over">
                            Over
                          </option>
                        </select>
                      </div>
                      <div class="fcp-field">
                        <label for="">Sub Menu Color</label>
                        <div class="fcp-colors">
                          <div class="color-selector sub-menu-color-selector color-bright selected"></div>
                          <div class="color-selector sub-menu-color-selector color-dark"></div>
                          <div class="color-selector sub-menu-color-selector color-light"></div>
                        </div>
                      </div>
                    </div>
                  </div>
                  <div class="fcp-group">
                    <div class="fcp-group-header">
                      Other Settings
                    </div>
                    <div class="fcp-group-contents">
                      <div class="fcp-field">
                        <label for="">Full Screen?</label><select class="full-screen-selector">
                          <option value="yes">
                            Yes
                          </option>
                          <option value="no">
                            No
                          </option>
                        </select>
                      </div>
                      <div class="fcp-field">
                        <label for="">Show Top Bar</label><select class="top-bar-visibility-selector">
                          <option value="yes">
                            Yes
                          </option>
                          <option value="no">
                            No
                          </option>
                        </select>
                      </div>
                      <div class="fcp-field">
                        <label for="">Above Menu?</label><select class="top-bar-above-menu-selector">
                          <option value="yes">
                            Yes
                          </option>
                          <option value="no">
                            No
                          </option>
                        </select>
                      </div>
                      <div class="fcp-field">
                        <label for="">Top Bar Color</label>
                        <div class="fcp-colors">
                          <div class="color-selector top-bar-color-selector color-bright selected"></div>
                          <div class="color-selector top-bar-color-selector color-dark"></div>
                          <div class="color-selector top-bar-color-selector color-light"></div>
                          <div class="color-selector top-bar-color-selector color-transparent"></div>
                        </div>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
              <!--------------------
              END - Demo Customizer
              --------------------><!--------------------
              START - Chat Popup Box
              -------------------->
              <div class="floated-chat-btn">
                <i class="os-icon os-icon-mail-07"></i><span>Demo Chat</span>
              </div>
              <div class="floated-chat-w">
                <div class="floated-chat-i">
                  <div class="chat-close">
                    <i class="os-icon os-icon-close"></i>
                  </div>
                  <div class="chat-head">
                    <div class="user-w with-status status-green">
                      <div class="user-avatar-w">
                        <div class="user-avatar">
                          <security:authentication var="profilePicUrl" property="principal.userAdditionalInfoPo.profileImageLink">
          <img alt="" src="${profilePicUrl}" onerror="this.src='img/avatar1.jpg'">
        </security:authentication>
                        </div>
                      </div>
                      <div class="user-name">
                        <h6 class="user-title">
                          <span class="text-capitalize" sec:authentication="name">Anonymous</span>
                        </h6>
                        <div class="user-role">
                          Account Manager
                        </div>
                      </div>
                    </div>
                  </div>
                  <div class="chat-messages">
                    <div class="message">
                      <div class="message-content">
                        Hi, how can I help you?
                      </div>
                    </div>
                    <div class="date-break">
                      Mon 10:20am
                    </div>
                    <div class="message">
                      <div class="message-content">
                        Hi, my name is Mike, I will be happy to assist you
                      </div>
                    </div>
                    <div class="message self">
                      <div class="message-content">
                        Hi, I tried ordering this product and it keeps showing me error code.
                      </div>
                    </div>
                  </div>
                  <div class="chat-controls">
                    <input class="message-input" placeholder="Type your message here..." type="text">
                    <div class="chat-extra">
                      <a href="#"><span class="extra-tooltip">Attach Document</span><i class="os-icon os-icon-documents-07"></i></a><a href="#"><span class="extra-tooltip">Insert Photo</span><i class="os-icon os-icon-others-29"></i></a><a href="#"><span class="extra-tooltip">Upload Video</span><i class="os-icon os-icon-ui-51"></i></a>
                    </div>
                  </div>
                </div>
              </div>
              <!--------------------
              END - Chat Popup Box
              -------------------->
            </div>
          </div>
        </div>
      </div>
      <div class="display-type"></div>
    </div>
      <c:import url="/WEB-INF/views/fragments/common-scripts.jsp"></c:import>
    <script>
      (function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){
      (i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),
      m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)
      })(window,document,'script','https://www.google-analytics.com/analytics.js','ga');
      
      ga('create', 'UA-XXXXXXX-9', 'auto');
      ga('send', 'pageview');
    </script>
  </body>
</html>

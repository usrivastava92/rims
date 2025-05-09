<%@ include file="/WEB-INF/views/fragments/taglib-import.jsp"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:th="http://www.thymeleaf.org"
  xmlns:sec="http://www.thymeleaf.org/extras/spring-security" lang="en">

<head>
<c:import url="/WEB-INF/views/fragments/common-head.jsp"></c:import>
</head>

<body class="menu-position-side menu-side-left full-screen with-content-panel">
  <div class="all-wrapper with-side-panel solid-bg-all">
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
            <a href="index.html">Products</a>
          </li>
          <li class="breadcrumb-item">
            <span>Laptop with retina screen</span>
          </li>
        </ul>
        <!--------------------
          END - Breadcrumbs
          -------------------->
        <div class="content-panel-toggler">
          <i class="os-icon os-icon-grid-squares-22"></i><span>Sidebar</span>
        </div>
        <div class="content-i">
          <div class="content-box">
            <div class="row">
              <div class="col-sm-5">
                <div class="user-profile compact">
                  <div class="up-head-w" style="background-image:url(/assets/img/profile_bg1.jpg)">
                    <div class="up-social">
                      <a href="#"><i class="os-icon os-icon-twitter"></i></a><a href="#"><i
                          class="os-icon os-icon-facebook"></i></a>
                    </div>
                    <div class="up-main-info">
                      <h2 class="up-header">
                        <span class="text-capitalize" >${userPo.username}</span>
                      </h2>
                      <h6 class="up-sub-header">
                        Product Designer at Facebook
                      </h6>
                    </div>
                    <svg class="decor" width="842px" height="219px" viewBox="0 0 842 219"
                      preserveAspectRatio="xMaxYMax meet" version="1.1" xmlns="http://www.w3.org/2000/svg"
                      xmlns:xlink="http://www.w3.org/1999/xlink">
                      <g transform="translate(-381.000000, -362.000000)" fill="#FFFFFF">
                        <path class="decor-path"
                          d="M1223,362 L1223,581 L381,581 C868.912802,575.666667 1149.57947,502.666667 1223,362 Z">
                        </path>
                      </g>
                    </svg>
                  </div>
                  <div class="up-controls">
                    <div class="row">
                      <div class="col-sm-6">
                        <div class="value-pair">
                          <div class="label">
                            Status:
                          </div>
                          <div class="value badge badge-pill badge-success">
                            Online
                          </div>
                        </div>
                      </div>
                      <div class="col-sm-6 text-right">
                        <a class="btn btn-primary btn-sm" href=""><i class="os-icon os-icon-link-3"></i><span>Add to
                            Friends</span></a>
                      </div>
                    </div>
                  </div>
                  <div class="up-contents">
                    <div class="m-b">
                      <div class="row m-b">
                        <div class="col-sm-6 b-r b-b">
                          <div class="el-tablo centered padded-v">
                            <div class="value">
                              25
                            </div>
                            <div class="label">
                              Products Sold
                            </div>
                          </div>
                        </div>
                        <div class="col-sm-6 b-b">
                          <div class="el-tablo centered padded-v">
                            <div class="value">
                              315
                            </div>
                            <div class="label">
                              Friends
                            </div>
                          </div>
                        </div>
                      </div>
                      <div class="padded">
                        <div class="os-progress-bar primary">
                          <div class="bar-labels">
                            <div class="bar-label-left">
                              <span>Profile Completion</span><span class="positive">+10</span>
                            </div>
                            <div class="bar-label-right">
                              <span class="info">72/100</span>
                            </div>
                          </div>
                          <div class="bar-level-1" style="width: 100%">
                            <div class="bar-level-2" style="width: 80%">
                              <div class="bar-level-3" style="width: 30%"></div>
                            </div>
                          </div>
                        </div>
                        <div class="os-progress-bar primary">
                          <div class="bar-labels">
                            <div class="bar-label-left">
                              <span>Status Unlocked</span><span class="positive">+5</span>
                            </div>
                            <div class="bar-label-right">
                              <span class="info">45/100</span>
                            </div>
                          </div>
                          <div class="bar-level-1" style="width: 100%">
                            <div class="bar-level-2" style="width: 30%">
                              <div class="bar-level-3" style="width: 10%"></div>
                            </div>
                          </div>
                        </div>
                        <div class="os-progress-bar primary">
                          <div class="bar-labels">
                            <div class="bar-label-left">
                              <span>Followers</span><span class="negative">-12</span>
                            </div>
                            <div class="bar-label-right">
                              <span class="info">74/100</span>
                            </div>
                          </div>
                          <div class="bar-level-1" style="width: 100%">
                            <div class="bar-level-2" style="width: 80%">
                              <div class="bar-level-3" style="width: 60%"></div>
                            </div>
                          </div>
                        </div>
                      </div>
                    </div>
                  </div>
                </div>
                <div class="element-wrapper">
                  <div class="element-box">
                    <h6 class="element-header">
                      User Activity
                    </h6>
                    <div class="timed-activities compact">
                      <div class="timed-activity">
                        <div class="ta-date">
                          <span>21st Jan, 2017</span>
                        </div>
                        <div class="ta-record-w">
                          <div class="ta-record">
                            <div class="ta-timestamp">
                              <strong>11:55</strong> am
                            </div>
                            <div class="ta-activity">
                              Created a post called <a href="#">Register new symbol</a> in Rogue
                            </div>
                          </div>
                          <div class="ta-record">
                            <div class="ta-timestamp">
                              <strong>2:34</strong> pm
                            </div>
                            <div class="ta-activity">
                              Commented on story <a href="#">How to be a leader</a> in <a href="#">Financial</a>
                              category
                            </div>
                          </div>
                          <div class="ta-record">
                            <div class="ta-timestamp">
                              <strong>7:12</strong> pm
                            </div>
                            <div class="ta-activity">
                              Added <a href="#">John Silver</a> as a friend
                            </div>
                          </div>
                        </div>
                      </div>
                      <div class="timed-activity">
                        <div class="ta-date">
                          <span>3rd Feb, 2017</span>
                        </div>
                        <div class="ta-record-w">
                          <div class="ta-record">
                            <div class="ta-timestamp">
                              <strong>9:32</strong> pm
                            </div>
                            <div class="ta-activity">
                              Added <a href="#">John Silver</a> as a friend
                            </div>
                          </div>
                          <div class="ta-record">
                            <div class="ta-timestamp">
                              <strong>5:14</strong> pm
                            </div>
                            <div class="ta-activity">
                              Commented on story <a href="#">How to be a leader</a> in <a href="#">Financial</a>
                              category
                            </div>
                          </div>
                        </div>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
              <div class="col-sm-7">
                <div class="element-wrapper">
                  <div class="element-box">
                    <form id="formValidate">
                      <div class="element-info">
                        <div class="element-info-with-icon">
                          <div class="element-info-icon">
                            <div class="os-icon os-icon-wallet-loaded"></div>
                          </div>
                          <div class="element-info-text">
                            <h5 class="element-inner-header">
                              Profile Settings
                            </h5>
                            <div class="element-inner-desc">
                              Validation of the form is made possible using powerful validator plugin for bootstrap. <a
                                href="http://1000hz.github.io/bootstrap-validator/" target="_blank">Learn more about
                                Bootstrap Validator</a>
                            </div>
                          </div>
                        </div>
                      </div>
                      <div class="form-group">
                        <label for=""> Email address</label><input class="form-control"
                          data-error="Your email address is invalid" placeholder="Enter email" required="required"
                          type="email">
                        <div class="help-block form-text with-errors form-control-feedback"></div>
                      </div>
                      <div class="row">
                        <div class="col-sm-6">
                          <div class="form-group">
                            <label for=""> Password</label><input class="form-control" data-minlength="6"
                              placeholder="Password" required="required" type="password">
                            <div class="help-block form-text text-muted form-control-feedback">
                              Minimum of 6 characters
                            </div>
                          </div>
                        </div>
                        <div class="col-sm-6">
                          <div class="form-group">
                            <label for="">Confirm Password</label><input class="form-control"
                              data-match-error="Passwords don&#39;t match" placeholder="Confirm Password"
                              required="required" type="password">
                            <div class="help-block form-text with-errors form-control-feedback"></div>
                          </div>
                        </div>
                      </div>
                      <div class="form-group">
                        <label for=""> Regular select</label><select class="form-control">
                          <option value="New York">
                            New York
                          </option>
                          <option value="California">
                            California
                          </option>
                          <option value="Boston">
                            Boston
                          </option>
                          <option value="Texas">
                            Texas
                          </option>
                          <option value="Colorado">
                            Colorado
                          </option>
                        </select>
                      </div>
                      <div class="form-group">
                        <label for=""> Multiselect</label><select class="form-control select2" multiple="true">
                          <option selected="true">
                            New York
                          </option>
                          <option selected="true">
                            California
                          </option>
                          <option>
                            Boston
                          </option>
                          <option>
                            Texas
                          </option>
                          <option>
                            Colorado
                          </option>
                        </select>
                      </div>
                      <fieldset class="form-group">
                        <legend><span>Section Example</span></legend>
                        <div class="row">
                          <div class="col-sm-6">
                            <div class="form-group">
                              <label for=""> First Name</label><input class="form-control"
                                data-error="Please input your First Name" placeholder="First Name" required="required"
                                type="text">
                              <div class="help-block form-text with-errors form-control-feedback"></div>
                            </div>
                          </div>
                          <div class="col-sm-6">
                            <div class="form-group">
                              <label for="">Last Name</label><input class="form-control"
                                data-error="Please input your Last Name" placeholder="Last Name" required="required"
                                type="text">
                              <div class="help-block form-text with-errors form-control-feedback"></div>
                            </div>
                          </div>
                        </div>
                        <div class="row">
                          <div class="col-sm-6">
                            <div class="form-group">
                              <label for=""> Date of Birth</label><input class="single-daterange form-control"
                                placeholder="Date of birth" type="text" value="04/12/1978">
                            </div>
                          </div>
                          <div class="col-sm-6">
                            <div class="form-group">
                              <label for="">Twitter Username</label>
                              <div class="input-group">
                                <div class="input-group-prepend">
                                  <div class="input-group-text">
                                    @
                                  </div>
                                </div>
                                <input class="form-control" placeholder="Twitter Username" type="text">
                              </div>
                            </div>
                          </div>
                        </div>
                        <div class="form-group">
                          <label for="">Date Range Picker</label><input class="multi-daterange form-control" type="text"
                            value="03/31/2017 - 04/06/2017">
                        </div>
                        <div class="form-group">
                          <label> Example textarea</label><textarea class="form-control" rows="3"></textarea>
                        </div>
                      </fieldset>
                      <div class="form-check">
                        <label class="form-check-label"><input class="form-check-input" type="checkbox">I agree to terms
                          and conditions</label>
                      </div>
                      <div class="form-buttons-w">
                        <button class="btn btn-primary" type="submit"> Submit</button>
                      </div>
                    </form>
                  </div>
                </div>
              </div>
            </div>
            <!--------------------
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
              -------------------->
            <!--------------------
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
              -------------------->
            <!--------------------
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
          <img alt="" src="${userPo.userAdditionalInfoPo.profileImageLink}" onerror="this.src='img/avatar1.jpg'">
        </security:authentication>
                        </div>
                      </div>
                      <div class="user-name">
                        <h6 class="user-title">
                          <span class="text-capitalize" >${userPo.username}</span>
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
            <!--------------------
            START - Sidebar
            -------------------->
            <div class="content-panel">
              <div class="content-panel-close">
                <i class="os-icon os-icon-close"></i>
              </div>
              <!--------------------
              START - Support Agents
              -------------------->
              <div class="element-wrapper">
                <h6 class="element-header">
                  Support Agents
                </h6>
                <div class="element-box-tp">
                  <div class="profile-tile">
                    <a class="profile-tile-box" href="users_profile_small.html">
                      <div class="pt-avatar-w">
                        <security:authentication var="profilePicUrl" property="principal.userAdditionalInfoPo.profileImageLink">
          <img alt="" src="${userPo.userAdditionalInfoPo.profileImageLink}" onerror="this.src='img/avatar1.jpg'">
        </security:authentication>
                      </div>
                      <div class="pt-user-name">
                        <span class="text-capitalize" >${userPo.username}</span>
                      </div>
                    </a>
                    <div class="profile-tile-meta">
                      <ul>
                        <li>
                          Last Login:<strong>Online Now</strong>
                        </li>
                        <li>
                          Tickets:<strong><a href="apps_support_index.html">12</a></strong>
                        </li>
                        <li>
                          Response Time:<strong>2 hours</strong>
                        </li>
                      </ul>
                      <div class="pt-btn">
                        <a class="btn btn-success btn-sm" href="apps_full_chat.html">Send Message</a>
                      </div>
                    </div>
                  </div>
                  <div class="profile-tile">
                    <a class="profile-tile-box" href="users_profile_small.html">
                      <div class="pt-avatar-w">
                        <img alt="" src="	https://scontent.fdel30-1.fna.fbcdn.net/v/t1.0-9/22489690_1344309625681439_8014554153500542429_n.jpg?_nc_cat=102&_nc_oc=AQmrIwHzIAvf6QF8df52qYZn50YJdiT4yBg_Oh167unhwLvT0WMZ2skf7vVQxA4GMt8&_nc_ht=scontent.fdel30-1.fna&oh=c6b3e2056b4aa936f9858e284c810e1d&oe=5DF0A06F">
                      </div>
                      <div class="pt-user-name">
                        Shashwat Rastogi
                      </div>
                    </a>
                    <div class="profile-tile-meta">
                      <ul>
                        <li>
                          Last Login:<strong>Offline</strong>
                        </li>
                        <li>
                          Tickets:<strong><a href="apps_support_index.html">9</a></strong>
                        </li>
                        <li>
                          Response Time:<strong>3 hours</strong>
                        </li>
                      </ul>
                      <div class="pt-btn">
                        <a class="btn btn-secondary btn-sm" href="apps_full_chat.html">Send Message</a>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
              <!--------------------
              END - Support Agents
              -------------------->
              <div class="element-wrapper">
                <h6 class="element-header">
                  Team Members
                </h6>
                <div class="element-box-tp">
                  <div class="input-search-w">
                    <input class="form-control rounded bright" placeholder="Search team members..." type="search">
                  </div>
                  <div class="users-list-w">
                    <div class="user-w with-status status-green">
                      <div class="user-avatar-w">
                        <div class="user-avatar">
                          <security:authentication var="profilePicUrl" property="principal.userAdditionalInfoPo.profileImageLink">
          <img alt="" src="${userPo.userAdditionalInfoPo.profileImageLink}" onerror="this.src='img/avatar1.jpg'">
        </security:authentication>
                        </div>
                      </div>
                      <div class="user-name">
                        <h6 class="user-title">
                          <span class="text-capitalize" >${userPo.username}</span>
                        </h6>
                        <div class="user-role">
                          Account Manager
                        </div>
                      </div>
                      <div class="user-action">
                        <div class="os-icon os-icon-email-forward"></div>
                      </div>
                    </div>
                    <div class="user-w with-status status-green">
                      <div class="user-avatar-w">
                        <div class="user-avatar">
                          <img alt="" src="	https://scontent.fdel30-1.fna.fbcdn.net/v/t31.0-8/1397349_535172419912359_1425229961_o.jpg?_nc_cat=102&_nc_oc=AQlpiXvh8txfpfmk7p_oHv5FK1h7B02lVuRyxfRGomqI0h_iblvOrZgM2zw54h1-c70&_nc_ht=scontent.fdel30-1.fna&oh=70c3d1de4e57f3ae5ab5845fb71f8912&oe=5E2C25CD">
                        </div>
                      </div>
                      <div class="user-name">
                        <h6 class="user-title">
                          Shashwat Rastogi
                        </h6>
                        <div class="user-role">
                          Administrator
                        </div>
                      </div>
                      <div class="user-action">
                        <div class="os-icon os-icon-email-forward"></div>
                      </div>
                    </div>
                    <div class="user-w with-status status-red">
                      <div class="user-avatar-w">
                        <div class="user-avatar">
                          <img alt="" src="	https://scontent.fdel30-1.fna.fbcdn.net/v/t1.0-9/22489690_1344309625681439_8014554153500542429_n.jpg?_nc_cat=102&_nc_oc=AQmrIwHzIAvf6QF8df52qYZn50YJdiT4yBg_Oh167unhwLvT0WMZ2skf7vVQxA4GMt8&_nc_ht=scontent.fdel30-1.fna&oh=c6b3e2056b4aa936f9858e284c810e1d&oe=5DF0A06F">
                        </div>
                      </div>
                      <div class="user-name">
                        <h6 class="user-title">
                          Vishal Trivedi
                        </h6>
                        <div class="user-role">
                          HR Manger
                        </div>
                      </div>
                      <div class="user-action">
                        <div class="os-icon os-icon-email-forward"></div>
                      </div>
                    </div>
                    <div class="user-w with-status status-green">
                      <div class="user-avatar-w">
                        <div class="user-avatar">
                          <img alt="" src="/assets/img/avatar4.jpg">
                        </div>
                      </div>
                      <div class="user-name">
                        <h6 class="user-title">
                          Jenny Miksa
                        </h6>
                        <div class="user-role">
                          Lead Developer
                        </div>
                      </div>
                      <div class="user-action">
                        <div class="os-icon os-icon-email-forward"></div>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
            </div>
            <!--------------------
            END - Sidebar
            -------------------->
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
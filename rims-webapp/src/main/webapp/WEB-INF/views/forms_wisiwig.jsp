<%@ include file="/WEB-INF/views/fragments/taglib-import.jsp"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" lang="en">

<head>
  <c:import url="/WEB-INF/views/fragments/common-head.jsp"></c:import>
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
        <div th:replace="fragments/top-menu :: top-menu">
          top-menu
        </div>
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
                Simple Wisiwig Editor
              </h6>
              <div class="element-box">
                <h5 class="form-header">
                  Powered by CKEditor
                </h5>
                <div class="form-desc">
                  Create captivating content with multiple features available in CKEditor thanks to its plugin-based
                  architecture. <a href="http://ckeditor.com/" target="_blank">Learn More about CKEditor</a>
                </div>
                <textarea cols="80" id="ckeditor1" name="ckeditor1" rows="10"></textarea>
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
                        <security:authentication var="profilePicUrl"
                          property="principal.userAdditionalInfoPo.profileImageLink">
                          <img alt="" src="${userPo.userAdditionalInfoPo.profileImageLink}"
                            onerror="this.src='img/avatar1.jpg'">
                        </security:authentication>
                      </div>
                    </div>
                    <div class="user-name">
                      <h6 class="user-title">
                        <span class="text-capitalize">${userPo.username}</span>
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
                    <a href="#"><span class="extra-tooltip">Attach Document</span><i
                        class="os-icon os-icon-documents-07"></i></a><a href="#"><span class="extra-tooltip">Insert
                        Photo</span><i class="os-icon os-icon-others-29"></i></a><a href="#"><span
                        class="extra-tooltip">Upload Video</span><i class="os-icon os-icon-ui-51"></i></a>
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
<%@ include file="/WEB-INF/views/fragments/taglib-import.jsp"%>
<div
  class="menu-w color-scheme-light color-style-transparent menu-position-side menu-side-left menu-layout-compact sub-menu-style-over sub-menu-color-bright selected-menu-color-light menu-activated-on-hover menu-has-selected-link">
  <div class="logo-w">
    <a class="logo" href="/index.html">
      <div class="logo-element"></div>
      <div class="logo-label">
        <fmt:message key="application.name" />
      </div>
    </a>
  </div>
  <div class="logged-user-w avatar-inline">
    <div class="logged-user-i">
      <div class="avatar-w">
        <img alt="" src="${userPo.userAdditionalInfoPo.profileImageLink}" onerror="this.src='/assets/img/avatar1.jpg'">
      </div>
      <div class="logged-user-info-w">
        <div class="logged-user-name">
          <span class="text-capitalize">${userPo.username}</span>
        </div>
        <div class="logged-user-role">
          Administrator
        </div>
      </div>
      <div class="logged-user-toggler-arrow">
        <div class="os-icon os-icon-chevron-down"></div>
      </div>
      <div class="logged-user-menu color-style-bright">
        <div class="logged-user-avatar-info">
          <div class="avatar-w">
            <img alt="" src="${userPo.userAdditionalInfoPo.profileImageLink}">
          </div>
          <div class="logged-user-info-w">
            <div class="logged-user-name">
              <span class="text-capitalize">${userPo.username}</span>
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
            <a href="users_profile_big.html"><i class="os-icon os-icon-user-male-circle2"></i><span>Profile
                Details</span></a>
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
  <div class="menu-actions">
    <!--------------------
    START - Messages Link in secondary top menu
    -------------------->
    <div class="messages-notifications os-dropdown-trigger os-dropdown-position-right">
      <i class="os-icon os-icon-mail-14"></i>
      <div class="new-messages-count">
        12
      </div>
      <div class="os-dropdown light message-list">
        <ul>
          <li>
            <a href="#">
              <div class="user-avatar-w">
                <img alt="" src="${userPo.userAdditionalInfoPo.profileImageLink}"
                  onerror="this.src='/assets/img/avatar1.jpg'">
              </div>
              <div class="message-content">
                <h6 class="message-from">
                  <span class="text-capitalize">${userPo.username}</span>
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
                <img alt=""
                  src="	https://scontent.fdel30-1.fna.fbcdn.net/v/t31.0-8/1397349_535172419912359_1425229961_o.jpg?_nc_cat=102&_nc_oc=AQlpiXvh8txfpfmk7p_oHv5FK1h7B02lVuRyxfRGomqI0h_iblvOrZgM2zw54h1-c70&_nc_ht=scontent.fdel30-1.fna&oh=70c3d1de4e57f3ae5ab5845fb71f8912&oe=5E2C25CD">
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
                <img alt=""
                  src="	https://scontent.fdel30-1.fna.fbcdn.net/v/t1.0-9/22489690_1344309625681439_8014554153500542429_n.jpg?_nc_cat=102&_nc_oc=AQmrIwHzIAvf6QF8df52qYZn50YJdiT4yBg_Oh167unhwLvT0WMZ2skf7vVQxA4GMt8&_nc_ht=scontent.fdel30-1.fna&oh=c6b3e2056b4aa936f9858e284c810e1d&oe=5DF0A06F">
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
    -------------------->
    <!--------------------
    START - Settings Link in secondary top menu
    -------------------->
    <div class="top-icon top-settings os-dropdown-trigger os-dropdown-position-right">
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
    -------------------->
    <!--------------------
    START - Messages Link in secondary top menu
    -------------------->
    <div class="messages-notifications os-dropdown-trigger os-dropdown-position-right">
      <i class="os-icon os-icon-zap"></i>
      <div class="new-messages-count">
        4
      </div>
      <div class="os-dropdown light message-list">
        <div class="icon-w">
          <i class="os-icon os-icon-zap"></i>
        </div>
        <ul>
          <li>
            <a href="#">
              <div class="user-avatar-w">
                <img alt="" src="${userPo.userAdditionalInfoPo.profileImageLink}"
                  onerror="this.src='/assets/img/avatar1.jpg'">
              </div>
              <div class="message-content">
                <h6 class="message-from">
                  <span class="text-capitalize">${userPo.username}</span>
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
                <img alt=""
                  src="	https://scontent.fdel30-1.fna.fbcdn.net/v/t31.0-8/1397349_535172419912359_1425229961_o.jpg?_nc_cat=102&_nc_oc=AQlpiXvh8txfpfmk7p_oHv5FK1h7B02lVuRyxfRGomqI0h_iblvOrZgM2zw54h1-c70&_nc_ht=scontent.fdel30-1.fna&oh=70c3d1de4e57f3ae5ab5845fb71f8912&oe=5E2C25CD">
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
                <img alt=""
                  src="	https://scontent.fdel30-1.fna.fbcdn.net/v/t1.0-9/22489690_1344309625681439_8014554153500542429_n.jpg?_nc_cat=102&_nc_oc=AQmrIwHzIAvf6QF8df52qYZn50YJdiT4yBg_Oh167unhwLvT0WMZ2skf7vVQxA4GMt8&_nc_ht=scontent.fdel30-1.fna&oh=c6b3e2056b4aa936f9858e284c810e1d&oe=5DF0A06F">
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
    -------------------->
  </div>
  <div class="element-search autosuggest-search-activator">
    <input placeholder="Start typing to search..." type="text">
  </div>
  <h1 class="menu-page-header">
    Page Header
  </h1>




  <span sec:authorize="isAuthenticated()">
    <ul class="main-menu">
      <li class="sub-header">
        <span>Menu</span>
      </li>
      <li class="selected">
        <a href="/inventory">
          <div class="icon-w">
            <div class="os-icon os-icon-layout"></div>
          </div>
          <span>Inventory</span>
        </a>
      </li>
      <li class="selected">
        <a href="/sales">
          <div class="icon-w">
            <div class="os-icon os-icon-layout"></div>
          </div>
          <span>Sales</span>
        </a>
      </li>
    </ul>
  </span>

  <span sec:authorize="hasRole('ROLE_USER')">
    <ul class="main-menu">
      <li class="sub-header">
        <span>Admin</span>
      </li>
      <li class="selected">
        <a href="/index.html">
          <div class="icon-w">
            <div class="os-icon os-icon-layout"></div>
          </div>
          <span>Dashboard</span>
        </a>
      </li>
      <li class="selected">
        <a href="/reports">
          <div class="icon-w">
            <div class="os-icon os-icon-layout"></div>
          </div>
          <span>Reports</span>
        </a>
      </li>
      <li class="selected">
        <a href="/inventory/dashboard">
          <div class="icon-w">
            <div class="os-icon os-icon-layout"></div>
          </div>
          <span>Inventory</span>
        </a>
      </li>
      <li class="selected">
        <a href="/sales/dashboard">
          <div class="icon-w">
            <div class="os-icon os-icon-layout"></div>
          </div>
          <span>Sales</span>
        </a>
      </li>
      <li class="has-sub-menu">
        <a>
          <div class="icon-w">
            <div class="os-icon os-icon-layers"></div>
          </div>
          <span>Masters</span>
        </a>
        <div class="sub-menu-w">
          <div class="sub-menu-header">
            Masters
          </div>
          <div class="sub-menu-icon">
            <i class="os-icon os-icon-layers"></i>
          </div>
          <div class="sub-menu-i">
            <ul class="sub-menu">
              <li>
                <a href="/users">Users</a>
              </li>
              <li>
                <a href="/roles">Roles</a>
              </li>
              <li>
                <a href="/authorities">Authorities</a>
              </li>
            </ul>
            <ul class="sub-menu">
              <li>
                <a href="/vendors">Vendors</a>
              </li>
              <li>
                <a href="/products">Products</a>
              </li>
              <li>
                <a href="/genericattributes">Generic Attributes</a>
              </li>
            </ul>
          </div>
        </div>
      </li>
    </ul>
  </span>
  <span sec:authorize="hasRole('ROLE_DEVELOPER')">
    <ul class="main-menu">
      <li class="sub-header">
        <span>Layouts</span>
      </li>

      <li class="has-sub-menu">
        <a href="/layouts_menu_top_image.html">
          <div class="icon-w">
            <div class="os-icon os-icon-layers"></div>
          </div>
          <span>Menu Styles</span>
        </a>
        <div class="sub-menu-w">
          <div class="sub-menu-header">
            Menu Styles
          </div>
          <div class="sub-menu-icon">
            <i class="os-icon os-icon-layers"></i>
          </div>
          <div class="sub-menu-i">
            <ul class="sub-menu">
              <li>
                <a href="/layouts_menu_side_full.html">Side Menu Light</a>
              </li>
              <li>
                <a href="/layouts_menu_side_full_dark.html">Side Menu Dark</a>
              </li>
              <li>
                <a href="/layouts_menu_side_transparent.html">Side Menu Transparent <strong
                    class="badge badge-danger">New</strong></a>
              </li>
              <li>
                <a href="/apps_pipeline.html">Side &amp; Top Dark</a>
              </li>
              <li>
                <a href="/apps_projects.html">Side &amp; Top</a>
              </li>
              <li>
                <a href="/layouts_menu_side_mini.html">Mini Side Menu</a>
              </li>
            </ul>
            <ul class="sub-menu">
              <li>
                <a href="/layouts_menu_side_mini_dark.html">Mini Menu Dark</a>
              </li>
              <li>
                <a href="/layouts_menu_side_compact.html">Compact Side Menu</a>
              </li>
              <li>
                <a href="/layouts_menu_side_compact_dark.html">Compact Menu Dark</a>
              </li>
              <li>
                <a href="/layouts_menu_right.html">Right Menu</a>
              </li>
              <li>
                <a href="/layouts_menu_top.html">Top Menu Light</a>
              </li>
              <li>
                <a href="/layouts_menu_top_dark.html">Top Menu Dark</a>
              </li>
            </ul>
            <ul class="sub-menu">
              <li>
                <a href="/layouts_menu_top_image.html">Top Menu Image <strong
                    class="badge badge-danger">New</strong></a>
              </li>
              <li>
                <a href="/layouts_menu_sub_style_flyout.html">Sub Menu Flyout</a>
              </li>
              <li>
                <a href="/layouts_menu_sub_style_flyout_dark.html">Sub Flyout Dark</a>
              </li>
              <li>
                <a href="/layouts_menu_sub_style_flyout_bright.html">Sub Flyout Bright</a>
              </li>
              <li>
                <a href="/layouts_menu_side_compact_click.html">Menu Inside Click</a>
              </li>
            </ul>
          </div>
        </div>
      </li>
      <li class="sub-header">
        <span>Options</span>
      </li>
      <li class=" has-sub-menu">
        <a href="/apps_bank.html">
          <div class="icon-w">
            <div class="os-icon os-icon-package"></div>
          </div>
          <span>Applications</span>
        </a>
        <div class="sub-menu-w">
          <div class="sub-menu-header">
            Applications
          </div>
          <div class="sub-menu-icon">
            <i class="os-icon os-icon-package"></i>
          </div>
          <div class="sub-menu-i">
            <ul class="sub-menu">
              <li>
                <a href="/apps_email.html">Email Application</a>
              </li>
              <li>
                <a href="/apps_support_dashboard.html">Support Dashboard</a>
              </li>
              <li>
                <a href="/apps_support_index.html">Tickets Index</a>
              </li>
              <li>
                <a href="/apps_crypto.html">Crypto Dashboard <strong class="badge badge-danger">New</strong></a>
              </li>
              <li>
                <a href="/apps_projects.html">Projects List</a>
              </li>
              <li>
                <a href="/apps_bank.html">Banking <strong class="badge badge-danger">New</strong></a>
              </li>
            </ul>
            <ul class="sub-menu">
              <li>
                <a href="/apps_full_chat.html">Chat Application</a>
              </li>
              <li>
                <a href="/apps_todo.html">To Do Application <strong class="badge badge-danger">New</strong></a>
              </li>
              <li>
                <a href="/misc_chat.html">Popup Chat</a>
              </li>
              <li>
                <a href="/apps_pipeline.html">CRM Pipeline</a>
              </li>
              <li>
                <a href="/rentals_index_grid.html">Property Listing <strong class="badge badge-danger">New</strong></a>
              </li>
              <li>
                <a href="/misc_calendar.html">Calendar</a>
              </li>
            </ul>
          </div>
        </div>
      </li>
      <li class=" has-sub-menu">
        <a href="#">
          <div class="icon-w">
            <div class="os-icon os-icon-file-text"></div>
          </div>
          <span>Pages</span>
        </a>
        <div class="sub-menu-w">
          <div class="sub-menu-header">
            Pages
          </div>
          <div class="sub-menu-icon">
            <i class="os-icon os-icon-file-text"></i>
          </div>
          <div class="sub-menu-i">
            <ul class="sub-menu">
              <li>
                <a href="/misc_invoice.html">Invoice</a>
              </li>
              <li>
                <a href="/rentals_index_grid.html">Property Listing <strong class="badge badge-danger">New</strong></a>
              </li>
              <li>
                <a href="/misc_charts.html">Charts</a>
              </li>
              <li>
                <a href="/auth_login.html">Login</a>
              </li>
              <li>
                <a href="/auth_register.html">Register</a>
              </li>
            </ul>
            <ul class="sub-menu">
              <li>
                <a href="/auth_lock.html">Lock Screen</a>
              </li>
              <li>
                <a href="/misc_pricing_plans.html">Pricing Plans</a>
              </li>
              <li>
                <a href="/misc_error_404.html">Error 404</a>
              </li>
              <li>
                <a href="/misc_error_500.html">Error 500</a>
              </li>
            </ul>
          </div>
        </div>
      </li>
      <li class=" has-sub-menu">
        <a href="#">
          <div class="icon-w">
            <div class="os-icon os-icon-life-buoy"></div>
          </div>
          <span>UI Kit</span>
        </a>
        <div class="sub-menu-w">
          <div class="sub-menu-header">
            UI Kit
          </div>
          <div class="sub-menu-icon">
            <i class="os-icon os-icon-life-buoy"></i>
          </div>
          <div class="sub-menu-i">
            <ul class="sub-menu">
              <li>
                <a href="/uikit_modals.html">Modals <strong class="badge badge-danger">New</strong></a>
              </li>
              <li>
                <a href="/uikit_alerts.html">Alerts</a>
              </li>
              <li>
                <a href="/uikit_grid.html">Grid</a>
              </li>
              <li>
                <a href="/uikit_progress.html">Progress</a>
              </li>
              <li>
                <a href="/uikit_popovers.html">Popover</a>
              </li>
            </ul>
            <ul class="sub-menu">
              <li>
                <a href="/uikit_tooltips.html">Tooltips</a>
              </li>
              <li>
                <a href="/uikit_buttons.html">Buttons</a>
              </li>
              <li>
                <a href="/uikit_dropdowns.html">Dropdowns</a>
              </li>
              <li>
                <a href="/uikit_typography.html">Typography</a>
              </li>
            </ul>
          </div>
        </div>
      </li>
      <li class="sub-header">
        <span>Elements</span>
      </li>
      <li class=" has-sub-menu">
        <a href="#">
          <div class="icon-w">
            <div class="os-icon os-icon-mail"></div>
          </div>
          <span>Emails</span>
        </a>
        <div class="sub-menu-w">
          <div class="sub-menu-header">
            Emails
          </div>
          <div class="sub-menu-icon">
            <i class="os-icon os-icon-mail"></i>
          </div>
          <div class="sub-menu-i">
            <ul class="sub-menu">
              <li>
                <a href="/emails_welcome.html">Welcome Email</a>
              </li>
              <li>
                <a href="/emails_order.html">Order Confirmation</a>
              </li>
              <li>
                <a href="/emails_payment_due.html">Payment Due</a>
              </li>
              <li>
                <a href="/emails_forgot.html">Forgot Password</a>
              </li>
              <li>
                <a href="/emails_activate.html">Activate Account</a>
              </li>
            </ul>
          </div>
        </div>
      </li>
      <li class=" has-sub-menu">
        <a href="#">
          <div class="icon-w">
            <div class="os-icon os-icon-users"></div>
          </div>
          <span>Users</span>
        </a>
        <div class="sub-menu-w">
          <div class="sub-menu-header">
            Users
          </div>
          <div class="sub-menu-icon">
            <i class="os-icon os-icon-users"></i>
          </div>
          <div class="sub-menu-i">
            <ul class="sub-menu">
              <li>
                <a href="/users_profile_big.html">Big Profile</a>
              </li>
              <li>
                <a href="/users_profile_small.html">Compact Profile</a>
              </li>
            </ul>
          </div>
        </div>
      </li>
      <li class=" has-sub-menu">
        <a href="#">
          <div class="icon-w">
            <div class="os-icon os-icon-edit-32"></div>
          </div>
          <span>Forms</span>
        </a>
        <div class="sub-menu-w">
          <div class="sub-menu-header">
            Forms
          </div>
          <div class="sub-menu-icon">
            <i class="os-icon os-icon-edit-32"></i>
          </div>
          <div class="sub-menu-i">
            <ul class="sub-menu">
              <li>
                <a href="/forms_regular.html">Regular Forms</a>
              </li>
              <li>
                <a href="/forms_validation.html">Form Validation</a>
              </li>
              <li>
                <a href="/forms_wizard.html">Form Wizard</a>
              </li>
              <li>
                <a href="/forms_uploads.html">File Uploads</a>
              </li>
              <li>
                <a href="/forms_wisiwig.html">Wisiwig Editor</a>
              </li>
            </ul>
          </div>
        </div>
      </li>
      <li class=" has-sub-menu">
        <a href="#">
          <div class="icon-w">
            <div class="os-icon os-icon-grid"></div>
          </div>
          <span>Tables</span>
        </a>
        <div class="sub-menu-w">
          <div class="sub-menu-header">
            Tables
          </div>
          <div class="sub-menu-icon">
            <i class="os-icon os-icon-grid"></i>
          </div>
          <div class="sub-menu-i">
            <ul class="sub-menu">
              <li>
                <a href="/tables_regular.html">Regular Tables</a>
              </li>
              <li>
                <a href="/tables_datatables.html">Data Tables</a>
              </li>
              <li>
                <a href="/tables_editable.html">Editable Tables</a>
              </li>
            </ul>
          </div>
        </div>
      </li>
      <li class=" has-sub-menu">
        <a href="#">
          <div class="icon-w">
            <div class="os-icon os-icon-zap"></div>
          </div>
          <span>Icons</span>
        </a>
        <div class="sub-menu-w">
          <div class="sub-menu-header">
            Icons
          </div>
          <div class="sub-menu-icon">
            <i class="os-icon os-icon-zap"></i>
          </div>
          <div class="sub-menu-i">
            <ul class="sub-menu">
              <li>
                <a href="/icons">Consolidated Icons</a>
              </li>
            </ul>
          </div>
        </div>
      </li>
    </ul>
    <div class="side-menu-magic">
      <h4>
        Light Admin
      </h4>
      <p>
        Clean Bootstrap 4 Template
      </p>
      <div class="btn-w">
        <a class="btn btn-white btn-rounded"
          href="https://themeforest.net/item/light-admin-clean-bootstrap-dashboard-html-template/19760124?ref=Osetin"
          target="_blank">Purchase Now</a>
      </div>
    </div>
</div>
</span>
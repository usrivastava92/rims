<%@ include file="/WEB-INF/views/fragments/taglib-import.jsp"%>
<div class="top-bar color-scheme-transparent">
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
    -------------------->
    <!--------------------
    START - User avatar and menu in secondary top menu
    -------------------->
    <div class="logged-user-w">
      <div class="logged-user-i">
        <div class="avatar-w">
          <img alt="" src="${userPo.userAdditionalInfoPo.profileImageLink}"
            onerror="this.src='/assets/img/avatar1.jpg'">
        </div>
        <div class="logged-user-menu color-style-bright">
          <div class="logged-user-avatar-info">
            <div class="avatar-w">
              <img alt="" src="${userPo.userAdditionalInfoPo.profileImageLink}"
                onerror="this.src='/assets/img/avatar1.jpg'">
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
              <a href="users_profile_small.html"><i class="os-icon os-icon-coins-4"></i><span>Billing
                  Details</span></a>
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
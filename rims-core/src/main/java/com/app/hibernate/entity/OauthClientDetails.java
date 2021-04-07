package com.app.hibernate.entity;

import com.app.hibernate.entity.core.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="OAUTH_CLIENT_DETAILS")
public class OauthClientDetails extends BaseEntity {

    @Column(name = "CLIENT_ID" ,unique = true)
    private String clientId;
    @Column(name = "RESOURCE_IDS" )
    private String resourceIds;
    @Column(name = "CLIENT_SECRET" )
    private String clientSecret;
    @Column(name = "SCOPE" )
    private String scope;
    @Column(name = "AUTHORIZED_GRANT_TYPES" )
    private String authorizedGrantTypes;
    @Column(name = "WEB_SERVER_REDIRECT_URI" )
    private String webServerRedirectUri;
    @Column(name = "AUTHORITIES" )
    private String authorities;
    @Column(name = "ACCESS_TOKEN_VALIDITY" )
    private int accessTokenValidity;
    @Column(name = "REFRESH_TOKEN_VALIDITY" )
    private int refreshTokenValidity;
    @Column(name = "ADDITIONAL_INFORMATION" )
    private String additionalInformation;
    @Column(name = "AUTOAPPROVE" )
    private String autoApprove;


    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getResourceIds() {
        return resourceIds;
    }

    public void setResourceIds(String resourceIds) {
        this.resourceIds = resourceIds;
    }

    public String getClientSecret() {
        return clientSecret;
    }

    public void setClientSecret(String clientSecret) {
        this.clientSecret = clientSecret;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public String getAuthorizedGrantTypes() {
        return authorizedGrantTypes;
    }

    public void setAuthorizedGrantTypes(String authorizedGrantTypes) {
        this.authorizedGrantTypes = authorizedGrantTypes;
    }

    public String getWebServerRedirectUri() {
        return webServerRedirectUri;
    }

    public void setWebServerRedirectUri(String webServerRedirectUri) {
        this.webServerRedirectUri = webServerRedirectUri;
    }

    public String getAuthorities() {
        return authorities;
    }

    public void setAuthorities(String authorities) {
        this.authorities = authorities;
    }

    public int getAccessTokenValidity() {
        return accessTokenValidity;
    }

    public void setAccessTokenValidity(int accessTokenValidity) {
        this.accessTokenValidity = accessTokenValidity;
    }

    public int getRefreshTokenValidity() {
        return refreshTokenValidity;
    }

    public void setRefreshTokenValidity(int refreshTokenValidity) {
        this.refreshTokenValidity = refreshTokenValidity;
    }

    public String getAdditionalInformation() {
        return additionalInformation;
    }

    public void setAdditionalInformation(String additionalInformation) {
        this.additionalInformation = additionalInformation;
    }

    public String getAutoApprove() {
        return autoApprove;
    }

    public void setAutoApprove(String autoApprove) {
        this.autoApprove = autoApprove;
    }

    @Override
    public String toString() {
        return "OauthClientDetails{" +
                "clientId='" + clientId + '\'' +
                ", resourceIds='" + resourceIds + '\'' +
                ", clientSecret='" + clientSecret + '\'' +
                ", scope='" + scope + '\'' +
                ", authorizedGrantTypes='" + authorizedGrantTypes + '\'' +
                ", webServerRedirectUri='" + webServerRedirectUri + '\'' +
                ", authorities='" + authorities + '\'' +
                ", accessTokenValidity='" + accessTokenValidity + '\'' +
                ", refreshTokenValidity='" + refreshTokenValidity + '\'' +
                ", additionalInformation='" + additionalInformation + '\'' +
                ", autoApprove='" + autoApprove + '\'' +
                '}';
    }
}

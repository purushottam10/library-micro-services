package io.dz.librarydb.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class PropertiesConfig {
    @Value("${REST_CLIENT_MEMBER_URL}")
    private String memberServiceUrl;

    @Value("${REST_CLIENT_USER_LIMIT}")
    private String userLimitUrl;

    public String getUserLimitUrl() {
        return userLimitUrl;
    }

    public void setUserLimitUrl(String userLimitUrl) {
        this.userLimitUrl = userLimitUrl;
    }

    public String getMemberServiceUrl() {
        return memberServiceUrl;
    }

    public void setMemberServiceUrl(String memberServiceUrl) {
        this.memberServiceUrl = memberServiceUrl;
    }
}

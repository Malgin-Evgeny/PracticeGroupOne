package api.testBase.token;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SuccessReg {
    private TokenDetails accessToken;
    private TokenDetails refreshToken;

    public SuccessReg() {
    }

    @JsonProperty("accessToken")
    public TokenDetails getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(TokenDetails accessToken) {
        this.accessToken = accessToken;
    }

    @JsonProperty("refreshToken")
    public TokenDetails getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(TokenDetails refreshToken) {
        this.refreshToken = refreshToken;
    }
}
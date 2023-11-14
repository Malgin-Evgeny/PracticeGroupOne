package api.testBase.token;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TokenDetails {
    private String token;
    private long expiredAt;

    public TokenDetails() {
    }
    @JsonProperty("token")
    public String getToken() {
        return token;
    }
    @JsonProperty("expiredAt")
    public long getExpiredAt() {
        return expiredAt;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public void setExpiredAt(long expiredAt) {
        this.expiredAt = expiredAt;
    }
}
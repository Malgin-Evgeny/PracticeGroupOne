package api;

public class SuccessReg {
    private String token;
    private Integer expiredAt;

    public SuccessReg() {
    }

    public SuccessReg(String token, Integer expiredAt) {
        this.token = token;
        this.expiredAt = expiredAt;
    }

    public String getToken() {
        return token;
    }

    public Integer getExpiredAt() {
        return expiredAt;
    }
}

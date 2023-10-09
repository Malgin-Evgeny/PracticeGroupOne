package api.testBase.token;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Register {
    public String login;
    public String password;

    public Register(String login, String password) {
        this.login = login;
        this.password = password;
    }

    @JsonProperty("login")
    public String getLogin() {
        return login;
    }

    @JsonProperty("password")
    public String getPassword() {
        return password;
    }

    @JsonProperty("login")
    public void setLogin(String login) {
        this.login = login;
    }

    @JsonProperty("password")
    public void setPassword(String password) {
        this.password = password;
    }
}

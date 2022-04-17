package pt.bmo.restaurant.ordering.auth.model;

public class LoginRequest {
    Integer userId;
    String pwd;

    public LoginRequest() {
    }

    public LoginRequest(Integer userId, String pwd) {
        this.userId = userId;
        this.pwd = pwd;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
}

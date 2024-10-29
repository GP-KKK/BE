package com.example.car2.user.data.login;

/*    */ public class LoginRequest {
    private String email;
    /*    */   private String username;
    /*    */   private String source;

    /*    */
    /*  6 */
    public void setEmail(String email) {
        this.email = email;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setSource(String source) {
        this.source = source;
    }

    /*    */
    /*  8 */
    public LoginRequest() {
    }

    public LoginRequest(String email, String username, String source) {
        this.email = email;
        this.username = username;
        this.source = source;
    }



    public String toString() {
        return "LoginRequest(email=" + getEmail() + ", username=" + getUsername() + ", source=" + getSource() + ")";
    }

    /*    */
    /* 12 */
    public String getEmail() {
        return this.email;
    }

    /* 13 */
    public String getUsername() {
        return this.username;
    }

    public String getSource() {
        /* 14 */
        return this.source;
        /*    */
    }
}


/* Location:              C:\Users\kimseongmin\Desktop\car-spring-0.0.1-SNAPSHOT.jar!\BOOT-INF\classes\car\car_sprin\\user\data\login\LoginRequest.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */
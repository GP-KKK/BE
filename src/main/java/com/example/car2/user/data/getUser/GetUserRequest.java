package com.example.car2.user.data.getUser;

/*   */ public class GetUserRequest {
    private String email;

    /*   */
    /* 4 */
    public String toString() {
        return "GetUserRequest(email=" + getEmail() + ")";
    }


    public void setEmail(String email) {
        this.email = email;
    }

    /*   */
    public String getEmail() {
        /* 6 */
        return this.email;
        /*   */
    }
}


/* Location:              C:\Users\kimseongmin\Desktop\car-spring-0.0.1-SNAPSHOT.jar!\BOOT-INF\classes\car\car_sprin\\user\data\getUser\GetUserRequest.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */
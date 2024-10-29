package com.example.car2.user.data.evaluate;

/*    */ public class EvaluateRequest {
    /*    */   private Long id;
    /*    */   private String email;
    /*    */   private int score;

    /*    */
    /*  7 */
    public void setId(Long id) {
        this.id = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public EvaluateRequest() {
    }

    public EvaluateRequest(Long id, String email, int score) {
        this.id = id;
        this.email = email;
        this.score = score;
    }


    public String toString() {
        return "EvaluateRequest(id=" + getId() + ", email=" + getEmail() + ", score=" + getScore() + ")";
    }

    /*    */
    /* 13 */
    public Long getId() {
        return this.id;
    }

    /* 14 */
    public String getEmail() {
        return this.email;
    }

    public int getScore() {
        /* 15 */
        return this.score;
        /*    */
    }
    /*    */
}


/* Location:              C:\Users\kimseongmin\Desktop\car-spring-0.0.1-SNAPSHOT.jar!\BOOT-INF\classes\car\car_sprin\\user\data\evaluate\EvaluateRequest.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */
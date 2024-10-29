package com.example.car2.user.data.getUser;

import com.example.car2.user.enum_package.FeelState;
import lombok.Builder;

/*    */
@Builder
/*    */ public class GetUserResponse {
    /*    */   private String email;
    /*    */   private String name;
    /*    */   private String source;
    /*    */   private String feel;

    /*    */
    /*  9 */
    public void setEmail(String email) {
        this.email = email;
    }

    private FeelState feelState;
    private String profileImage;
    private double emotionDegree;
    private String qrcode;

    public void setName(String name) {
        this.name = name;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public void setFeel(String feel) {
        this.feel = feel;
    }

    public void setFeelState(FeelState feelState) {
        this.feelState = feelState;
    }

    public void setProfileImage(String profileImage) {
        this.profileImage = profileImage;
    }

    public void setEmotionDegree(double emotionDegree) {
        this.emotionDegree = emotionDegree;
    }

    public void setQrcode(String qrcode) {
        this.qrcode = qrcode;
    }

    /*    */
    public GetUserResponse() {
    }

    /* 11 */
    public GetUserResponse(String email, String name, String source, String feel, FeelState feelState, String profileImage, double emotionDegree, String qrcode) {
        this.email = email;
        this.name = name;
        this.source = source;
        this.feel = feel;
        this.feelState = feelState;
        this.profileImage = profileImage;
        this.emotionDegree = emotionDegree;
        this.qrcode = qrcode;
    }


    /* 14 */
    public String getEmail() {
        return this.email;
    }

    /* 15 */
    public String getName() {
        return this.name;
    }

    /* 16 */
    public String getSource() {
        return this.source;
    }

    /* 17 */
    public String getFeel() {
        return this.feel;
    }

    /* 18 */
    public FeelState getFeelState() {
        return this.feelState;
    }

    /* 19 */
    public String getProfileImage() {
        return this.profileImage;
    }

    /* 20 */
    public double getEmotionDegree() {
        return this.emotionDegree;
    }

    public String getQrcode() {
        /* 21 */
        return this.qrcode;
        /*    */
    }
    /*    */
}


/* Location:              C:\Users\kimseongmin\Desktop\car-spring-0.0.1-SNAPSHOT.jar!\BOOT-INF\classes\car\car_sprin\\user\data\getUser\GetUserResponse.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */
package com.example.car2.user.data.modify;

import com.example.car2.user.enum_package.FeelState;
import lombok.Builder;

@Builder
/*    */ public class ModifyResponse {
    private String email;
    /*    */   private String name;
    /*    */   private String source;
    /*    */   private String profileImage;

    /*    */
    /*  7 */
    public void setEmail(String email) {
        this.email = email;
    }

    private FeelState feelState;
    private String feel;
    private double emotionDegree;
    private String qrcode;

    public void setName(String name) {
        this.name = name;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public void setProfileImage(String profileImage) {
        this.profileImage = profileImage;
    }

    public void setFeelState(FeelState feelState) {
        this.feelState = feelState;
    }

    public void setFeel(String feel) {
        this.feel = feel;
    }

    public void setEmotionDegree(double emotionDegree) {
        this.emotionDegree = emotionDegree;
    }

    public void setQrcode(String qrcode) {
        this.qrcode = qrcode;
    }



    public String toString() {
        return "ModifyResponse(email=" + getEmail() + ", name=" + getName() + ", source=" + getSource() + ", profileImage=" + getProfileImage() + ", feelState=" + getFeelState() + ", feel=" + getFeel() + ", emotionDegree=" + getEmotionDegree() + ", qrcode=" + getQrcode() + ")";
    }

    /*  8 */   ModifyResponse(String email, String name, String source, String profileImage, FeelState feelState, String feel, double emotionDegree, String qrcode) {
        this.email = email;
        this.name = name;
        this.source = source;
        this.profileImage = profileImage;
        this.feelState = feelState;
        this.feel = feel;
        this.emotionDegree = emotionDegree;
        this.qrcode = qrcode;
    }


    public String getEmail() {
        return this.email;
    }

    /* 11 */
    public String getName() {
        return this.name;
    }

    /* 12 */
    public String getSource() {
        return this.source;
    }

    /* 13 */
    public String getProfileImage() {
        return this.profileImage;
    }

    /* 14 */
    public FeelState getFeelState() {
        return this.feelState;
    }

    /* 15 */
    public String getFeel() {
        return this.feel;
    }

    /* 16 */
    public double getEmotionDegree() {
        return this.emotionDegree;
    }

    public String getQrcode() {
        /* 17 */
        return this.qrcode;
        /*    */
    }
}


/* Location:              C:\Users\kimseongmin\Desktop\car-spring-0.0.1-SNAPSHOT.jar!\BOOT-INF\classes\car\car_sprin\\user\data\modify\ModifyResponse.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */
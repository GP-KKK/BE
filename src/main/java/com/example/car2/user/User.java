package com.example.car2.user;

/*    */

import com.example.car2.user.enum_package.FeelState;
import jakarta.persistence.*;

/*    */
/*    */
@Entity
/*    */ public class User {
    /*    */
    @Id
    /*    */
    @GeneratedValue(strategy = GenerationType.AUTO)
    /*    */ private Long id;
    /*    */
    @Column(nullable = false, unique = true)
    /*    */ private String email;

    /*    */
    /* 13 */
    public void setId(Long id) {
        this.id = id;
    }

    @Column(nullable = false)
    private String name;
    @Column
    private String source;
    @Column(name = "profile_image")
    private String profileImage;

    public void setEmail(String email) {
        this.email = email;
    }

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

    /*    */
    /*    */
    /*    */
    /*    */
    /*    */
    public Long getId() {
        /* 19 */
        return this.id;
        /*    */
    }

    /*    */
    public String getEmail() {
        /* 22 */
        return this.email;
        /*    */
    }

    /*    */
    public String getName() {
        /* 25 */
        return this.name;
        /*    */
    }

    /*    */
    public String getSource() {
        /* 28 */
        return this.source;
        /*    */
    }

    /*    */
    /* 31 */
    public String getProfileImage() {
        return this.profileImage;
    }

    @Enumerated(EnumType.STRING)
    /*    */
    @Column(name = "feel_state", nullable = false)
    /* 33 */ private FeelState feelState = FeelState.UNKNOWN;

    /*    */
    public FeelState getFeelState() {
        /* 35 */
        return this.feelState;
        /*    */
    }

    @Column(nullable = false)
    /* 37 */ private String feel = "";

    public String getFeel() {
        /* 38 */
        return this.feel;
        /*    */
    }

    @Column(nullable = false)
    /* 40 */ private double emotionDegree = 36.5D;
    @Column(columnDefinition = "LONGTEXT")
    /* 41 */ private String qrcode;

    public double getEmotionDegree() {
        return this.emotionDegree;
    }

    /*    */
    /*    */
    public String getQrcode() {
        /* 44 */
        return this.qrcode;
        /*    */
    }
    /*    */
}

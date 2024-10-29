package com.example.car2.user.data.qr;

/*   */
/*   */ public class QrResponse {
    /*   */   private String qrcode;

    /*   */
    /* 6 */
    public String toString() {
        return "QrResponse(qrcode=" + getQrcode() + ")";
    }



    public void setQrcode(String qrcode) {
        this.qrcode = qrcode;
    }

    /*   */
    public String getQrcode() {
        /* 8 */
        return this.qrcode;
        /*   */
    }
    /*   */
}


/* Location:              C:\Users\kimseongmin\Desktop\car-spring-0.0.1-SNAPSHOT.jar!\BOOT-INF\classes\car\car_sprin\\user\data\qr\QrResponse.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */
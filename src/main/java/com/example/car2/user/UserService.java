package com.example.car2.user;

/*     */

import com.example.car2.user.data.evaluate.EvaluateRequest;
import com.example.car2.user.data.getUser.GetUserRequest;
import com.example.car2.user.data.getUser.GetUserResponse;
import com.example.car2.user.data.login.LoginDto;
import com.example.car2.user.data.modify.ModifyRequest;
import com.example.car2.user.data.modify.ModifyResponse;
import com.example.car2.user.data.qr.QrResponse;
import com.google.zxing.BarcodeFormat;
/*     */ import com.google.zxing.WriterException;
/*     */ import com.google.zxing.client.j2se.MatrixToImageWriter;
/*     */ import com.google.zxing.common.BitMatrix;
/*     */ import com.google.zxing.qrcode.QRCodeWriter;
/*     */ import java.awt.image.BufferedImage;
/*     */ import java.io.ByteArrayOutputStream;
/*     */ import java.io.IOException;
/*     */ import java.util.Base64;
/*     */ import java.util.Optional;
/*     */ import javax.imageio.ImageIO;
/*     */ import org.springframework.stereotype.Service;
/*     */ import org.springframework.transaction.annotation.Transactional;

/*     */
/*     */
@Service
/*     */
@Transactional
/*     */ public class UserService {
    /*     */
    public UserService(UserRepository userRepository) {
        /*  35 */
        this.userRepository = userRepository;
        /*     */
    }

    private final UserRepository userRepository;

    /*     */
    /*     */
    /*     */
    public LoginDto login(String email, String username, String source) throws IOException, WriterException {
        /*  43 */
        Optional<User> findUser = this.userRepository.findByEmail(email);
        /*     */
        /*     */
        /*  46 */
        if (findUser.isEmpty()) {
            /*  47 */
            User newUser = new User();
            /*  48 */
            newUser.setEmail(email);
            /*  49 */
            newUser.setName(username);
            /*  50 */
            newUser.setSource(source);
            /*  51 */
            QrResponse qrResponse = generateQR(email);
            /*  52 */
            newUser.setQrcode(qrResponse.getQrcode());
            /*  53 */
            this.userRepository.save(newUser);
            /*  54 */
            return LoginDto.builder().email(newUser.getEmail()).source(newUser.getSource()).qrcode(newUser.getQrcode())
/*  55 */.name(newUser.getName()).feel(newUser.getFeel()).feelState("FeelState." + newUser.getFeelState()).profileImage(newUser.getProfileImage()).emotionDegree(newUser.getEmotionDegree()).build();
            /*     */
        }
        /*  57 */
        return LoginDto.builder().email(((User) findUser.get()).getEmail()).source(((User) findUser.get()).getSource()).qrcode(((User) findUser.get()).getQrcode())
/*  58 */.name(((User) findUser.get()).getName()).feel(((User) findUser.get()).getFeel()).feelState("FeelState." + ((User) findUser.get()).getFeelState()).profileImage(((User) findUser.get()).getProfileImage()).emotionDegree(((User) findUser.get()).getEmotionDegree()).build();
        /*     */
    }

    /*     */
    /*     */
    /*     */
    public GetUserResponse getUser(GetUserRequest getUserRequest) {
        /*  63 */
        User user = (User) this.userRepository.findByEmail(getUserRequest.getEmail()).orElseThrow(() -> new RuntimeException("User not found"));
        /*     */
        /*     */
        /*  66 */
        return GetUserResponse.builder()
/*  67 */.email(user.getEmail())
/*  68 */.name(user.getName())
/*  69 */.source(user.getSource())
/*  70 */.feel(user.getFeel())
/*  71 */.feelState(user.getFeelState())
/*  72 */.profileImage(user.getProfileImage())
/*  73 */.emotionDegree(user.getEmotionDegree())
/*  74 */.qrcode(user.getQrcode())
/*  75 */.build();
        /*     */
    }

    /*     */
    /*     */
    public QrResponse generateQR(String email) throws WriterException, IOException {
        /*  79 */
        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        /*     */
        /*  81 */
        BitMatrix bitMatrix = qrCodeWriter.encode("finder_id: " + email, BarcodeFormat.QR_CODE, 300, 300);
        /*     */
        /*     */
        /*     */
        /*  85 */
        BufferedImage qrCodeImage = MatrixToImageWriter.toBufferedImage(bitMatrix);
        /*     */
        /*  87 */
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        /*  88 */
        ImageIO.write(qrCodeImage, "png", baos);
        /*     */
        /*  90 */
        byte[] imageBytes = baos.toByteArray();
        /*     */
        /*  92 */
        QrResponse qrcode = new QrResponse();
        /*     */
        /*  94 */
        qrcode.setQrcode(Base64.getEncoder().encodeToString(imageBytes));
        /*     */
        /*  96 */
        return qrcode;
        /*     */
    }

    /*     */
    /*     */
    @Transactional
    /*     */ public ModifyResponse modify(ModifyRequest modifyRequest) {
        /* 101 */
        User user = (User) this.userRepository.findByEmail(modifyRequest.getEmail()).orElseThrow(() -> new RuntimeException("User not found"));
        /*     */
        /*     */
        /* 104 */
        if (modifyRequest.getName() != null && !modifyRequest.getName().equals(user.getName())) {
            /* 105 */
            user.setName(modifyRequest.getName());
            /*     */
        }
        /* 107 */
        if (modifyRequest.getSource() != null && !modifyRequest.getSource().equals(user.getSource())) {
            /* 108 */
            user.setSource(modifyRequest.getSource());
            /*     */
        }
        /* 110 */
        if (modifyRequest.getProfileImage() != null && !modifyRequest.getProfileImage().equals(user.getProfileImage())) {
            /* 111 */
            user.setProfileImage(modifyRequest.getProfileImage());
            /*     */
        }
        /* 113 */
        if (modifyRequest.getFeelState() != null && !modifyRequest.getFeelState().equals(user.getFeelState())) {
            /* 114 */
            user.setFeelState(modifyRequest.getFeelState());
            /*     */
        }
        /* 116 */
        if (modifyRequest.getFeel() != null && !modifyRequest.getFeel().equals(user.getFeel())) {
            /* 117 */
            user.setFeel(modifyRequest.getFeel());
            /*     */
        }
        /* 119 */
        if (modifyRequest.getQrcode() != null && !modifyRequest.getQrcode().equals(user.getQrcode())) {
            /* 120 */
            user.setQrcode(modifyRequest.getQrcode());
            /*     */
        }
        /*     */
        /*     */
        /* 124 */
        this.userRepository.save(user);
        /*     */
        /*     */
        /* 127 */
        return ModifyResponse.builder()
/* 128 */.email(user.getEmail())
/* 129 */.name(user.getName())
/* 130 */.source(user.getSource())
/* 131 */.profileImage(user.getProfileImage())
/* 132 */.feelState(user.getFeelState())
/* 133 */.feel(user.getFeel())
/* 134 */.emotionDegree(user.getEmotionDegree())
/* 135 */.qrcode(user.getQrcode())
/* 136 */.build();
        /*     */
    }

    /*     */
    /*     */
    public void evaluate(EvaluateRequest evaluateRequest) {
        /* 163 */
        int score = evaluateRequest.getScore();
        /* 164 */
        User user = (User) this.userRepository.findByEmail(evaluateRequest.getEmail()).orElseThrow(() -> new RuntimeException("User not found"));
        /* 165 */
        if (score < 1 || score > 5) {
            /* 166 */
            throw new IllegalArgumentException("Score must be between 1 and 5");
            /*     */
        }
        /* 168 */
        double newEmotionDegree = calculateEmotionDegree(user.getEmotionDegree(), score);
        /* 169 */
        user.setEmotionDegree(newEmotionDegree);
        /* 170 */
        this.userRepository.save(user);
        /*     */
    }

    /*     */
    /*     */
    private double calculateEmotionDegree(double currentEmotionDegree, int score) {
        /* 174 */
        double adjustment = 0.0D;
        /* 175 */
        switch (score) {
            /*     */
            case 1:
                /* 177 */
                adjustment = -1.5D;
                /*     */
                break;
            /*     */
            case 2:
                /* 180 */
                adjustment = -0.9D;
                /*     */
                break;
            /*     */
            case 3:
                /* 183 */
                adjustment = 1.1D;
                /*     */
                break;
            /*     */
            case 4:
                /* 186 */
                adjustment = 1.9D;
                /*     */
                break;
            /*     */
            case 5:
                /* 189 */
                adjustment = 2.4D;
                /*     */
                break;
            /*     */
        }
        /*     */
        /*     */
        /* 194 */
        return currentEmotionDegree + adjustment;
        /*     */
    }
    /*     */
}

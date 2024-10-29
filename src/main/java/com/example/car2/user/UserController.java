package com.example.car2.user;

/*    */ import com.example.car2.user.data.evaluate.EvaluateRequest;
import com.example.car2.user.data.getUser.GetUserRequest;
import com.example.car2.user.data.getUser.GetUserResponse;
import com.example.car2.user.data.login.LoginDto;
import com.example.car2.user.data.login.LoginRequest;
import com.example.car2.user.data.modify.ModifyRequest;
import com.example.car2.user.data.modify.ModifyResponse;
import com.google.zxing.WriterException;
/*    */ import java.io.IOException;
/*    */ import java.util.List;
/*    */ import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
/*    */ import org.springframework.web.bind.annotation.*;
/*    */
/*    */
/*    */

/*    */
/*    */ @RestController
/*    */ public class UserController {
    /*    */   public UserController(UserService userService) {
        /* 20 */     this.userService = userService;
        /*    */   }
    /*    */
    /*    */   private final UserService userService;
    /*    */
    /*    */   @PostMapping({"/login"})
    /*    */   public ResponseEntity<LoginDto> login(@RequestBody LoginRequest loginRequest) throws IOException, WriterException {
        /* 27 */     return ResponseEntity.ok(this.userService.login(loginRequest.getEmail(), loginRequest.getUsername(), loginRequest.getSource()));
        /*    */   }
    /*    */
    /*    */
    /*    */   @PutMapping({"/modify"})
    /*    */   public ResponseEntity<ModifyResponse> modifyUserName(@RequestBody ModifyRequest modifyRequest) {
        /* 33 */     return ResponseEntity.ok(this.userService.modify(modifyRequest));
        /*    */   }
    /*    */   @GetMapping({"/getUser"})
    /*    */   public ResponseEntity<GetUserResponse> getUser(@RequestBody GetUserRequest getUserRequest) {
        /* 44 */     return ResponseEntity.ok(this.userService.getUser(getUserRequest));
        /*    */   }
    /*    */
    /*    */   @PostMapping({"/evaluate"})
    /*    */   public ResponseEntity<Void> evaluate(@RequestBody EvaluateRequest evaluateRequest) {
        /*    */     try {
            /* 50 */       this.userService.evaluate(evaluateRequest);
            /* 51 */       return ResponseEntity.ok().build();
            /* 52 */     } catch (Exception e) {
            /*    */
            /* 54 */       return ResponseEntity.status((HttpStatusCode) HttpStatus.INTERNAL_SERVER_ERROR).build();
            /*    */     }
        /*    */   }
    /*    */ }

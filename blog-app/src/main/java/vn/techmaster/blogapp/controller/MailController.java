package vn.techmaster.blogapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import vn.techmaster.blogapp.entity.User;
import vn.techmaster.blogapp.exception.NotFoundException;
import vn.techmaster.blogapp.repository.UserRepository;
import vn.techmaster.blogapp.service.MailService;

@RestController
public class MailController {
    public JavaMailSender emailSender;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private MailService mailService;

    public MailController(JavaMailSender emailSender) {
        this.emailSender = emailSender;
    }

    @PostMapping("/{id}/reset-password")
    public ResponseEntity<?> resetPassword(@PathVariable Integer id) {

        User user = userRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Khong tim thay user voi id = " + id));

        String newPassword = mailService.generateRandomPassword();
        user.setPassword(newPassword);
        userRepository.save(user);

        String emailSubject = "Password Reset";
        String emailBody = "Your new password is: " + newPassword;
        mailService.sendEmail(user.getEmail(), emailSubject, emailBody);

        return ResponseEntity.ok("Password reset successfully.");
    }
}

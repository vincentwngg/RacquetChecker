package org.example.Passwords;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.OneToOne;
import org.example.Users.User;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.util.Base64;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

public class Password {


    private String hashedPassword;

    private String salt;


    @OneToOne(mappedBy = "password")
    @JsonBackReference
    private User user;

    public Password(String rawPassword) throws NoSuchAlgorithmException, InvalidKeySpecException {
        this.salt = generateSalt();
        this.hashedPassword = hashPassword(rawPassword, salt);
    }

    public Password(){

    }

    public static String generateSalt() {
        byte[] salt = new byte[16];
        new SecureRandom().nextBytes(salt);
        return Base64.getEncoder().encodeToString(salt);
    }

    public static String hashPassword(String password, String salt) throws NoSuchAlgorithmException, InvalidKeySpecException{
        int iterations = 1000;
        int keyLength = 128;
        char[] passwordChars = password.toCharArray();
        byte[] saltBytes = Base64.getDecoder().decode(salt);

        PBEKeySpec spec = new PBEKeySpec(passwordChars, saltBytes, iterations, keyLength);
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
        byte[] hashedBytes = keyFactory.generateSecret(spec).getEncoded();

        return Base64.getEncoder().encodeToString(hashedBytes);
    }

    public User getUser(){
        return user;
    }
    public void setUser(User user){
        this.user = user;
    }

    public String getHashedPassword() {
        return hashedPassword;
    }

    public String getSalt() {
        return salt;
    }

    @Override
    public String toString() {
        return "Password{user=" + (user != null ? user.getUsername() : "null") + "}";
    }

}

package org.example.Users;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import org.example.Passwords.Password;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;
    private String username;
    private String location;
    private String securityWord;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "password_id")


    @JsonManagedReference
    private Password password;

    public User(){

    }

    private User(String email, String username, String location, String securityWord, Password password){
        this.email = email;
        this.username = username;
        this.location = location;
        this.securityWord = securityWord;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getSecurityWord() {
        return securityWord;
    }

    public void setSecurityWord(String securityWord) {
        this.securityWord = securityWord;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Password getPassword() {
        return password;
    }

    public void setPassword(Password password) {
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    @Override
    public String toString(){
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", username='" + username + '\'' +
                ", location='" + location + '\'' +
                ", securityWord='" + securityWord + '\'' +
                '}';
    }



}

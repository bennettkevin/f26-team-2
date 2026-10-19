package com.example.LocalGuide.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity 
@Table (name = "guides")
public class Guide {
    @Id 
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank 
    @Column (name = "f_name")
    private String firstName;

    @NotBlank 
    @Column (name = "l_name")
    private String lastName;

    @NotBlank 
    private String email;

    @NotBlank
    private String password;

    @NotBlank 
    private String city;

    @NotBlank 
    private String state;

    @NotBlank
    private String bio;

    @Lob
    private byte[] profile_picture;

    public Guide() {
    }
    // Getters and Setters 
    public Long getId() {
        return id;
    }

    public String getFName() {
        return firstName;
    }
    
    public void setFName(String firstName) {
        this.firstName = firstName;
    }

    public String getLName() {
        return lastName;
    }

    public void setLName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    } 

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public byte[] getProfilePicture() {
        return profile_picture;
    }

    public void setProfilePicture(byte[] profile_picture) {
        this.profile_picture = profile_picture;
    }
}

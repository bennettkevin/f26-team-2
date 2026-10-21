package com.example.LocalGuide.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity 
@Table (name = "guides")
public class Guide {
    @Id 
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank 
    @Column (name = "f_name", nullable = false, length = 50)
    private String firstName;

    @NotBlank 
    @Column (name = "l_name", nullable = false, length = 50)
    private String lastName;

    @NotBlank 
    @Column (nullable = false, length = 100)
    private String email;

    @NotBlank
    @Column (nullable = false, length = 100)
    private String password;

    @NotBlank 
    @Column (nullable = false, length = 50)
    private String city;
    
    @NotBlank 
    @Column (nullable = false, length = 50)
    private String state;

    @NotBlank
    @Column (nullable = false, length = 300)
    private String bio;

    @Lob
    @Column (name = "profile_picture")
    private byte[] profilePicture;

    @OneToMany (mappedBy = "guide", orphanRemoval = true, cascade = jakarta.persistence.CascadeType.ALL)
    @JsonIgnore
    private List<GuideTour> guideTours;


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
        return profilePicture;
    }

    public void setProfilePicture(byte[] profilePicture) {
        this.profilePicture = profilePicture;
    }
}

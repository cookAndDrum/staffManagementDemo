package com.teamcs.entities;

import com.teamcs.repositories.UserProfileRepository;
import jakarta.persistence.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * The private member : profile and role forms an unique
 */
@Component
@Entity
@Table(name = "UserProfiles", uniqueConstraints = @UniqueConstraint(columnNames = {"profile", "role"}))
public class UserProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "profile_id")
    private Integer profileId;
    @Column(name = "profile", nullable = false)
    private String profile;
    @Column(name = "role")
    private String role;

    @Autowired
    @Transient
    private UserProfileRepository userProfileRepository;

    public UserProfile() {super();}

    public UserProfile(String profile, String role) {
        this.profile = profile;
        this.role = role;
    }

    public UserProfile(Integer profileId, String profile, String role) {
        this.profileId = profileId;
        this.profile = profile;
        this.role = role;
    }

    /////////////////////////////////////////////////////////////////////////////////////
    //                                  SERVICE                                        //
    /////////////////////////////////////////////////////////////////////////////////////





    /////////////////////////////////////////////////////////////////////////////////////
    //                       Getter And Setter, ToString                               //
    /////////////////////////////////////////////////////////////////////////////////////

    public Integer getProfileId() {
        return profileId;
    }

    public void setProfileId(Integer profileId) {
        this.profileId = profileId;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "UserProfile{" +
                "profileId=" + profileId +
                ", profile='" + profile + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}

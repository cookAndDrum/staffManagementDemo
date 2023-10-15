package com.teamcs.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "UserProfiles")
public class UserProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "profile_id")
    private Integer profileId;
    @Column(unique = true)
    private String profile;
    private String role;

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

package com.teamcs.entities;

import com.teamcs.repositories.UserAccountRepository;
import com.teamcs.repositories.UserProfileRepository;
import com.teamcs.utils.LoginRequest;
import com.teamcs.utils.UserAccountDAO;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "UserAccounts")
public class UserAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private Integer userId;
    @Column(unique = true, nullable = false)
    private String name;
    @Column(unique = true, nullable = false)
    private String username;
    @Column(unique = true, nullable = false)
    private String email;
    @Column(nullable = false)
    private String password;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "profile_id")
    private UserProfile userProfile;
    @Column(nullable = false)
    private boolean accountSuspended;

    public UserAccount () {
        super();
    }

    public UserAccount(Integer userId, String name, String username, String email, String password, UserProfile userProfile) {
        this.userId = userId;
        this.name = name;
        this.username = username;
        this.email = email;
        this.password = password;
        this.userProfile = userProfile;
        this.accountSuspended = false;
    }

    public UserAccount(String name, String username, String email, String password, UserProfile profile) {
        this.name = name;
        this.username = username;
        this.email = email;
        this.password = password;
        this.userProfile = profile;
        this.accountSuspended = false;
    }

    /////////////////////////////////////////////////////////////////////////////////////
    //                                  SERVICE                                        //
    /////////////////////////////////////////////////////////////////////////////////////
    public static UserAccount userAccountLogin(
            UserAccountRepository userAccountRepository,
            UserProfileRepository userProfileRepository,
            LoginRequest loginRequest
    ) {
          return userAccountRepository.findByUsernameAndPassword(
                loginRequest.getUsername(), loginRequest.getPassword()).
                  orElseThrow(() -> new IllegalStateException("Invalid username or password"));
    }

    public static List<UserAccountDAO> allUserAccountsView(UserAccountRepository userAccountRepository) {
        List<UserAccount> userAccountList = userAccountRepository.findAll();
        return  userAccountList.stream().map(UserAccountDAO::new).toList();
    }

    public static UserAccountDAO userAccountView(UserAccountRepository userAccountRepository, String username) {
        return new UserAccountDAO(userAccountRepository.findByUsername(username).orElseThrow(
                // Should be no error
                () -> new IllegalStateException("Invalid username")
        ));
    }

    /////////////////////////////////////////////////////////////////////////////////////
    //                       Getter And Setter, ToString                               //
    /////////////////////////////////////////////////////////////////////////////////////
    public boolean isAccountSuspended() {
        return accountSuspended;
    }

    public void setAccountSuspended(boolean accountSuspended) {
        this.accountSuspended = accountSuspended;
    }

    public UserProfile getUserProfile() {
        return userProfile;
    }

    public void setUserProfile(UserProfile userProfile) {
        this.userProfile = userProfile;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    @Override
    public String toString() {
        return "UserAccount{" +
                "userId=" + userId +
                ", name='" + name + '\'' +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", userProfile=" + userProfile +
                ", accountSuspended=" + accountSuspended +
                '}';
    }
}

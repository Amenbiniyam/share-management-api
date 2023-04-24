package com.share.sharemanagementapi.domains;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Collections;

@Getter
@Setter
@Entity(name = "tbl_userAccount")
@Data
public class UserAccount implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(max = 15, min = 3)
    @Column(nullable = false)
    @NotBlank(message = "First Name cannot be empty")
    private String firstName;

    @Size(max = 15, min = 3)
    @Column(nullable = false)
    @NotBlank(message = "Middle name cannot be empty")
    private String middleName;

    @Size(max = 15, min = 3)
    @Column(nullable = false)
    @NotBlank(message = "Last name cannot be empty")
    private String lastName;

    @Size(max = 15, min = 3)
    @Column(nullable = false)
    @NotBlank(message = "OwnerShip type cannot be empty")
    private String username;

    @Column(nullable = false)
    @NotNull(message = "Password must be set")
    //@Size(min = 4, max =8 , message = "Password must be between 4 and 8 characters")
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).+$",
            message = "Password must contain at least one uppercase letter, one lowercase letter, and one digit")
    //@JsonProperty("*****")
    private String password;

    @Enumerated(EnumType.STRING)
    private AppUserRole appUserRole;

    @Column(nullable = false)
    private LocalDate createdDate = LocalDate.now();




    public UserAccount(String username, String password, String firstName, String middleName, String lastName, AppUserRole appUserRole) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.appUserRole = appUserRole;
    }

    public UserAccount() {

    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        SimpleGrantedAuthority authority =
                new SimpleGrantedAuthority(appUserRole.name());
        return Collections.singletonList(authority);
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }








//    public UserAccount() {
//
//    }


//    @OneToOne(fetch = FetchType.EAGER, orphanRemoval = true)
//    @JoinColumn(name = "firstName")
//    private User user;
}

// EXAMPLE OF SETTER AND GETTER METHODS
//    public String getFirstName() {
//        return firstName.toUpperCase();
//    }
//    public void setFirstName(String firstName) {
//        //validation
//        this.firstName = firstName;
//    }
//    Account myAccount = new Account();
//FAIL myAccount.firstName = "Biniam";
//CORRECT myAccount.setFirstName("Biniam");


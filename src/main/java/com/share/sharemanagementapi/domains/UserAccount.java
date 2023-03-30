package com.share.sharemanagementapi.domains;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDate;

@Entity(name = "tbl_userAccount")
@Data
public class UserAccount {

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

    @Column(nullable = false)
    @NotBlank(message = "User Role cannot be empty")
    private String role;

    @Column(nullable = false)
    private LocalDate createdDate = LocalDate.now();

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


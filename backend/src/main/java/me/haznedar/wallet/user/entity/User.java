package me.haznedar.wallet.user.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

/*
 These are all lombok annotations which makes creates every repetitive entity methods with
 one corresponding annotation. @Builder makes creation of the object easier.
*/
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_Name")
    private String lastName;

    // Every email must be unique
    @Column(unique = true, name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "profile_picture_url")
    private String profilePictureUrl = "/static/images/default-logo.jpg";

    // BigDecimal is the industry standard
    // A balance with 19 digits is allowed with 2 numbers after the decimal point.
    // We make user to start 0.00 balance instead of null
    @Column(precision = 19,scale = 2, name = "balance", nullable = false)
    private BigDecimal balance = BigDecimal.ZERO;

}

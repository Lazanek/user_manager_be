package com.platform.usermanager.model;

import com.platform.usermanager.enums.UserType;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.util.Date;

@Entity
@Table(name = "users")
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    @NotBlank(message = "Username is required")
    private String username;

    @Column(unique = true)
    @NotBlank(message = "Password is required")
    private String password;

    @Column
    @NotBlank(message = "E-mail address is required")
    private String email;

    @Column
    @Enumerated(EnumType.STRING)
    private UserType userType = UserType.NORMAL;

    @Column(name = "created_at")
    @CreatedDate
    private Date createdAt = new Date();

    @Column(name = "updated_at")
    @LastModifiedDate
    private Date updatedAt;
}

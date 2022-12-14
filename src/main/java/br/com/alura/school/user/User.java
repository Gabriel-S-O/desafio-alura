package br.com.alura.school.user;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import static br.com.alura.school.user.UserRole.STUDENT;
import static javax.persistence.GenerationType.IDENTITY;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @Size(max=20)
    @NotBlank
    @Column(nullable = false, unique = true)
    private String username;

    @NotBlank
    @Email
    @Column(nullable = false, unique = true)
    private String email;

    @Enumerated(EnumType.STRING)
    private UserRole role = STUDENT;

    @Deprecated
    protected User() {}

    User(String username, String email) {
        this.username = username;
        this.email = email;
    }

    String getUsername() {
        return username;
    }

    String getEmail() {
        return email;
    }

}

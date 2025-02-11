package com.easyinterviewtracker.domain;

import com.easyinterviewtracker.dto.UserDTO;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<JobApplication> jobApplications;

    public User(UserDTO userDTO){
        this.email = userDTO.email();
        this.password = userDTO.password();
    }
}

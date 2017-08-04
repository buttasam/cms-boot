package app.persistence.entity.auth;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

/**
 * @author Samuel Butta
 */
@Entity
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Long id;

    @Column
    private String email;

    @Column
    private String password;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @Column
    private boolean active;


    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Role> roles;
}

package app.persistence.entity.auth;

import lombok.Data;

import javax.persistence.*;

/**
 * @author Samuel Butta
 */
@Entity
@Data
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique = true)
    @Enumerated(EnumType.STRING)
    private RoleType role;
}

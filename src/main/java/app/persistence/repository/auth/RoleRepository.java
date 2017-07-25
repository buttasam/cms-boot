package app.persistence.repository.auth;

import app.persistence.entity.auth.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Samuel Butta
 */
@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
}

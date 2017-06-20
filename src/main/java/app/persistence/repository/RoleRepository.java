package app.persistence.repository;

import app.persistence.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Samuel Butta
 */
@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
}

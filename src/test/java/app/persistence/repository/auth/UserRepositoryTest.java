package app.persistence.repository.auth;

import app.persistence.entity.auth.Role;
import app.persistence.entity.auth.RoleType;
import app.persistence.entity.auth.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Samuel Butta
 */

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testSaveUserWithRole() {

        Role admin = new Role();
        admin.setRole(RoleType.ROLE_ADMIN);
        Set<Role> roles = new HashSet<>();
        roles.add(admin);

        String email = "sam@jones.cz";

        User user = new User();
        user.setFirstName("Sam");
        user.setLastName("Jones");
        user.setEmail(email);
        user.setRoles(roles);

        userRepository.save(user);

        User resultUser = userRepository.findByEmail(email);

        Assert.assertEquals(email, resultUser.getEmail());
        Assert.assertEquals(1, resultUser.getRoles().size());
        Assert.assertEquals(RoleType.ROLE_ADMIN, resultUser.getRoles().iterator().next().getRole());
    }


}

package app.persistence.repository;

import app.persistence.entity.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.jws.soap.SOAPBinding;

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
    public void testSaveUser() {
        String email = "sam@jones.cz";

        User user = new User();
        user.setFirstName("Sam");
        user.setLastName("Jones");
        user.setEmail(email);

        userRepository.save(user);

        User resultUser = userRepository.findByEmail(email);

        Assert.assertEquals(email, resultUser.getEmail());
    }


}

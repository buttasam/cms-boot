package app;

import app.front.controller.HomepageController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
class SmokeTest {

    @Autowired
    private HomepageController homepageController;

    @Test
    void contextLoads() throws Exception {
        assertThat(homepageController).isNotNull();
    }
}
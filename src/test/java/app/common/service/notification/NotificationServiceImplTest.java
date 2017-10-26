package app.common.service.notification;

import app.common.service.notification.api.NotificationService;
import app.persistence.entity.message.Notification;
import app.persistence.entity.message.NotificationStatus;
import app.persistence.repository.message.NotificationRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.mockito.BDDMockito.given;

/**
 * @author Samuel Butta
 */
/*@RunWith(SpringRunner.class)
@SpringBootTest*/
public class NotificationServiceImplTest {

/*    @MockBean
    private NotificationRepository notificationRepository;

    @Autowired
    private NotificationService notificationService;

    @Before
    public void init() {
        Notification mockNotification = new Notification();
        mockNotification.setId(1L);
        mockNotification.setMessage("test message");
        mockNotification.setStatus(NotificationStatus.NEW);

        given(notificationRepository.getOne(1L)).willReturn(mockNotification);
    }

    @Test
    public void testNotify() {
        notificationService.notify("message");
    }*/
}
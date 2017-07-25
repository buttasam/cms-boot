package app.persistence.repository.cms;

import app.persistence.entity.cms.Page;
import app.persistence.entity.cms.PageText;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author Samuel Butta
 */
@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class PageRepositoryTest {


    @Autowired
    private PageRepository pageRepository;

    @Autowired
    private PageImageRepository pageImageRepository;

    @Autowired
    private PageTextRepository pageTextRepository;

    @Test
    public void testCreatePage() {
        Page page = new Page();
        page.setUrl("test-url");

        pageRepository.save(page);

        Page resultPage = pageRepository.findByUrl("test-url");
        Assert.assertNotNull(resultPage);
        Assert.assertNull(pageRepository.findByUrl("url-not-exist"));
    }

}

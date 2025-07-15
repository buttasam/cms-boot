package app.persistence.repository.cms;

import app.persistence.entity.cms.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * @author Samuel Butta
 */
@Repository
public interface PageRepository extends JpaRepository<Page, Long> {

    Optional<Page> getByUrl(String url);

    List<Page> findByParentPage(Page parentPage);
}

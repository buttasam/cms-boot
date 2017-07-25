package app.persistence.repository.cms;

import app.persistence.entity.cms.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Samuel Butta
 */
@Repository
public interface PageRepository extends JpaRepository<Page, Long> {

    public Page findByUrl(String url);

}

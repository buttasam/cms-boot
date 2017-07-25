package app.persistence.repository.cms;

import app.persistence.entity.cms.PageImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Samuel Butta
 */
@Repository
public interface PageImageRepository extends JpaRepository<PageImage, Long>{
}

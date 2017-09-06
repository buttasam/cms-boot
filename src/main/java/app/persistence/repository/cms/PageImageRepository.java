package app.persistence.repository.cms;

import app.persistence.entity.cms.PageImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author Samuel Butta
 */
@Repository
public interface PageImageRepository extends JpaRepository<PageImage, Long> {


    public Optional<PageImage> getByIdentity(String identity);

}

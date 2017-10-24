package app.persistence.repository.cms;

import app.persistence.entity.cms.PageText;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author Samuel Butta
 */
@Repository
public interface PageTextRepository extends JpaRepository<PageText, Long> {

    public Optional<PageText> findByIdentity(String identity);

}

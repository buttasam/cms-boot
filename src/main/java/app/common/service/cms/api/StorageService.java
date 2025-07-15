package app.common.service.cms.api;

import app.persistence.entity.cms.Page;
import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;

/**
 * @author Samuel Butta
 */
public interface StorageService {

    void store(MultipartFile file, String identity, Page page);

    Resource loadAsResource(String fileName);

    void setUploadPath(Path path);
}

package app.common.service.cms.api;

import app.persistence.entity.cms.Page;
import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author Samuel Butta
 */
public interface StorageService {

    public void store(MultipartFile file, String identity, Page page);


    public Resource loadAsResource(String fileName);
}

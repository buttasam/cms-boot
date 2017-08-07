package app.service.cms.api;

import org.springframework.web.multipart.MultipartFile;

/**
 * @author Samuel Butta
 */
public interface StorageService {

    public void store(MultipartFile file);

}

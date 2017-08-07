package app.service.cms.api;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author Samuel Butta
 */
@Service
public class StorageServiceImpl implements StorageService {

    @Override
    public void store(MultipartFile file) {
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());

        System.out.println(fileName);
    }

}

package app.service.cms.api;

import groovy.lang.Singleton;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author Samuel Butta
 */
@Service
@Singleton
public class StorageServiceImpl implements StorageService {


    @Value("${upload.work-dir}")
    private String uploadWorkdir;

    private static final String WORK_IMAGE = "image";

    private Path uploadPath;

    @PostConstruct
    private void init() {
        this.uploadPath = Paths.get(uploadWorkdir).resolve(WORK_IMAGE);
    }

    @Override
    public void store(MultipartFile file) {
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());

        if(file.isEmpty() || fileName.contains("..")) {
            // TODO invalid file exception
        }

        try {
            Files.copy(file.getInputStream(), uploadPath.resolve(fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}

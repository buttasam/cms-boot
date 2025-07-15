package app.common.service.cms;


import app.common.service.cms.api.StorageService;
import app.persistence.entity.cms.Page;
import app.persistence.entity.cms.PageImage;
import app.persistence.repository.cms.PageImageRepository;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

/**
 * @author Samuel Butta
 */
@Service
@Slf4j
public class StorageServiceImpl implements StorageService {

    private static final String WORK_IMAGE = "image";

    @Value("${upload.work-dir}")
    private String uploadWorkdir;
    private Path uploadPath;

    private final PageImageRepository pageImageRepository;

    @Autowired
    public StorageServiceImpl(PageImageRepository pageImageRepository) {
        this.pageImageRepository = pageImageRepository;
    }

    @PostConstruct
    private void init() {
        this.uploadPath = Paths.get(uploadWorkdir).resolve(WORK_IMAGE);
    }

    @Override
    public void store(MultipartFile file, String identity, Page page) {
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());

        if (file.isEmpty()) {
            throw new IllegalArgumentException("Uploaded file is empty");
        }

        if (fileName.contains("..")) {
            throw new IllegalArgumentException("Invalid file name: " + fileName);
        }

        PageImage pageImage = pageImageRepository
                .getByIdentity(identity)
                .orElseGet(PageImage::new);

        pageImage.setFileName(fileName);
        pageImage.setIdentity(identity);
        pageImage.setPage(page);

        pageImageRepository.save(pageImage);

        try {
            Files.copy(
                    file.getInputStream(),
                    uploadPath.resolve(fileName),
                    StandardCopyOption.REPLACE_EXISTING
            );
            log.info("File with name '{}' was successfully stored", fileName);
        } catch (IOException e) {
            log.error("Failed to store file '{}'", fileName, e);
            throw new RuntimeException("Failed to store file", e);
        }
    }

    @Override
    public Resource loadAsResource(String fileName) {
        try {
            Path file = uploadPath.resolve(fileName);
            return new UrlResource(file.toUri());
        } catch (MalformedURLException e) {
            log.error("resource was not loaded", e);
        }
        return null;
    }

    @Override
    public void setUploadPath(Path path) {
        this.uploadPath = path;
    }

}

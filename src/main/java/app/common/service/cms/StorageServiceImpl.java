package app.common.service.cms;

import app.common.service.cms.api.StorageService;
import app.persistence.entity.cms.Page;
import app.persistence.entity.cms.PageImage;
import app.persistence.repository.cms.PageImageRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Optional;

/**
 * @author Samuel Butta
 */
@Service
public class StorageServiceImpl implements StorageService {

    private static final Logger LOG = LoggerFactory.getLogger(StorageServiceImpl.class);

    @Value("${upload.work-dir}")
    private String uploadWorkdir;

    private static final String WORK_IMAGE = "image";

    private Path uploadPath;

    private PageImageRepository pageImageRepository;

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

        // PageImage pageImage = PageImage.builder().name(fileName).page(page).build(); FIXME

        Optional<PageImage> pageImageOpt = pageImageRepository.getByIdentity(identity);

        // update existujiciho obrazku, pripadne vytvoreni noveho
        PageImage pageImage = pageImageOpt.orElseGet(PageImage::new);
        pageImage.setFileName(fileName);
        pageImage.setIdentity(identity);
        pageImage.setPage(page);

        pageImageRepository.save(pageImage);

        if (file.isEmpty() || fileName.contains("..")) {
            // TODO invalid file exception
        }

        try {
            Files.copy(file.getInputStream(), uploadPath.resolve(fileName), StandardCopyOption.REPLACE_EXISTING);
            LOG.info("file with name {} was stored", fileName);
        } catch (IOException e) {
            LOG.error("file was not stored", e);
        }

    }

    // TODO Optional
    @Override
    public Resource loadAsResource(String fileName) {
        try {
            Path file = uploadPath.resolve(fileName);
            Resource resource = new UrlResource(file.toUri());

            return resource;
        } catch (MalformedURLException e) {
            LOG.error("resource was not loaded", e);
        }
        return null;
    }

}

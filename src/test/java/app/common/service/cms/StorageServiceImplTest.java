package app.common.service.cms;

import app.persistence.entity.cms.Page;
import app.persistence.entity.cms.PageImage;
import app.persistence.repository.cms.PageImageRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.io.TempDir;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class StorageServiceImplTest {

    @InjectMocks
    private StorageServiceImpl storageService;

    @Mock
    private PageImageRepository pageImageRepository;

    @TempDir
    Path tempUploadPath;

    @BeforeEach
    void setUp() {
        storageService.setUploadPath(tempUploadPath);
    }

    @Test
    void testStore_ShouldStoreFileAndPersist() {
        String identity = "sample-img";
        String fileName = "image.png";
        Page page = new Page();

        byte[] fileContent = "hello".getBytes();
        MultipartFile file = new MockMultipartFile(
                "file", fileName, "image/png", fileContent);

        when(pageImageRepository.getByIdentity(identity)).thenReturn(Optional.empty());

        storageService.store(file, identity, page);

        Mockito.verify(pageImageRepository).save(Mockito.any(PageImage.class));
        assertTrue(Files.exists(tempUploadPath.resolve(fileName)));
    }
}
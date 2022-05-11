package dia20.example.dia20.Controllers.Service;

import java.nio.file.Path;
import java.util.stream.Stream;

import javax.annotation.Resource;
import org.springframework.web.multipart.MultipartFile;

public interface FilesStorageService {
    public void init();
    public void save(MultipartFile file);
    public void deleteAll();
    public Resource load(String filename);
    public Stream<Path> loadAll();

}
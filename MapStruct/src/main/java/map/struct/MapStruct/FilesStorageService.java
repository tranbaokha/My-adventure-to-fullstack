package map.struct.MapStruct;

import java.nio.file.Path;
import java.util.stream.Stream;

import javax.annotation.Resource;

import org.springframework.core.io.UrlResource;
import org.springframework.web.multipart.MultipartFile;

public interface FilesStorageService {
	public void init();
	public void save(MultipartFile file);
	public void deleteAll();
	public UrlResource load(String fileName);
	public Stream<Path> loadAll();
}

package map.struct.MapStruct;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

import javax.annotation.Resource;

import org.springframework.core.io.AbstractFileResolvingResource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;
import org.springframework.web.multipart.MultipartFile;
@Service
public class FilesStorageServiceImp implements FilesStorageService{
	private final Path root = Paths.get("uploads");
	@Override
	public void init() {
		try {
			Files.createDirectory(root);
		} catch (IOException e) {
			throw new RuntimeException("Couln't initialize folder for upload");
		}
	}

	@Override
	public void save(MultipartFile file) {
		try {
			Files.copy(file.getInputStream(), this.root.resolve(file.getOriginalFilename()));
		} catch(Exception e) {
			throw new RuntimeException("Couldn't store the file. Error: " + e.getMessage());
		}
	}

	@Override
	public void deleteAll() {
		FileSystemUtils.deleteRecursively(root.toFile());
	}

	@Override
	public UrlResource load(String fileName) {
		try {
			Path file = root.resolve(fileName);
		      UrlResource resource = new UrlResource(file.toUri());
		      return resource;
		} catch (MalformedURLException e) {
		      throw new RuntimeException("Error: " + e.getMessage());
	    }
	}

	@Override
	public Stream<Path> loadAll() {
		try {
		      return Files.walk(this.root, 1).filter(path -> !path.equals(this.root)).map(this.root::relativize);
		    } catch (IOException e) {
		      throw new RuntimeException("Could not load the files!");
		    }
	}	
}

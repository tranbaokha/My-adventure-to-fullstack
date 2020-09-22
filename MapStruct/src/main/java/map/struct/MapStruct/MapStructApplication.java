package map.struct.MapStruct;

import javax.annotation.Resource;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MapStructApplication implements CommandLineRunner{

	@Resource
	FilesStorageService storageService;
	public static void main(String[] args) {
		SpringApplication.run(MapStructApplication.class, args);
	}
	@Override
	  public void run(String... arg) throws Exception {
	    storageService.deleteAll();
	    storageService.init();
	  }
}

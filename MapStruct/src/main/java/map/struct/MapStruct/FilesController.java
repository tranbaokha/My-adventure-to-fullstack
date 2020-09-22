package map.struct.MapStruct;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

@Controller
public class FilesController {
	@Autowired
	FilesStorageService storageService;
	@PostMapping("/upload")
	public ResponseEntity<ResponseMessage> uploadFile(@RequestParam("file") MultipartFile file){
		storageService.save(file);
		String message = "Upload Successfully " + file.getOriginalFilename();
		return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseMessage(message));
	}
	@GetMapping("/files")
	public ResponseEntity<List<FileInfo>> getFiles(){
		 List<FileInfo> fileInfos = storageService.loadAll().map(path -> {
		      String filename = path.getFileName().toString();
		      String url = MvcUriComponentsBuilder
		          .fromMethodName(FilesController.class, "getFile", path.getFileName().toString()).build().toString();

		      return new FileInfo(filename, url);
		    }).collect(Collectors.toList());

		    return ResponseEntity.status(HttpStatus.OK).body(fileInfos);
	}
	@GetMapping("/files/{fileName}")
	public ResponseEntity<Resource> getFile(@PathVariable String fileName){
		Resource file = (Resource) storageService.load(fileName);
		return ResponseEntity.status(HttpStatus.OK).body(file);
	}
}

package dia20.example.dia20.Controllers;

import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import dia20.example.dia20.Controllers.Service.FilesStorageServiceImpl;
import dia20.example.dia20.Models.FileInfo;

@Controller
@RequestMapping("/uploads")
public class FilesController {
    @Autowired
    FilesStorageServiceImpl storageService;

    @GetMapping()
    public String index() {
        return "upload";
    }

    @PostMapping("/store")
    public String uploadFile(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttrs) {
        String message = "";
        try {
            storageService.save(file);
            message = "Archivo añadido " + file.getOriginalFilename();
            redirectAttrs
                    .addFlashAttribute("mensaje", message)
                    .addFlashAttribute("clase", "success");
            return "redirect:/uploads";
        } catch (Exception e) {
            message = "Error al cargar el archivo: " + file.getOriginalFilename() + "!";
            redirectAttrs
                    .addFlashAttribute("mensaje", message)
                    .addFlashAttribute("clase", "success");
            return "redirect:/uploads";
        }
    }

    @GetMapping("/list")
	  public String getListFiles(Model model) {
	    List<FileInfo> fileInfos = storageService.loadAll().map(path -> {
	      String filename = path.getFileName().toString();
	      String url = MvcUriComponentsBuilder
	          .fromMethodName(FilesController.class, "getFile", path.getFileName().toString()).build().toString();
	      return new FileInfo(filename, url);
	    }).collect(Collectors.toList());
        model.addAttribute("imagesUrl", fileInfos); 
        return "redirect:/uploads";
	  }
	  
	  @GetMapping("/files/{filename:.+}")
	  @ResponseBody
	  public ResponseEntity<Resource> getFile(@PathVariable String filename) {
	    Resource file = storageService.load(filename);
	    return ResponseEntity.ok()
	        .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"").body(file);
	  }

}	   


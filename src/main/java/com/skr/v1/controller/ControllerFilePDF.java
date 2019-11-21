package com.skr.v1.controller;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
@CrossOrigin(origins = "*", methods = {RequestMethod.POST})
public class ControllerFilePDF {

	@PostMapping(value="/upload/PDF") 
    public @ResponseBody ResponseEntity<String> handleFileUpload(@RequestParam("name") String name, 
      @RequestParam("file") MultipartFile file) throws Exception{

		if (file == null || file.isEmpty()) {
			
			return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body("Debe Seleccionar un archivo");
		}
		else
		{
			StringBuilder builder = new StringBuilder();
			builder.append(System.getProperty("user.home"));
			builder.append(File.separator);
			builder.append("Desktop");
			builder.append(File.separator);
			builder.append("PDF");
			builder.append(File.separator);
			builder.append(file.getOriginalFilename());			
			try { 
				byte[] fileBytes = file.getBytes();
			       Path path = Paths.get(builder.toString());
					Files.write(path, fileBytes); 
					String p=path.toString();
					return ResponseEntity.ok(p); 
			} catch (Exception e) { 
			       return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(e.getMessage()); 
			      }
		}

	}
}

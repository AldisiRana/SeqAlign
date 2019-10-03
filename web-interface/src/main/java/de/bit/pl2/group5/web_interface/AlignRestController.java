package de.bit.pl2.group5.web_interface;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * This class implement a rest api 
 * @author Rana Aldisi
 * @version 1.0
 *
 */
@RestController
public class AlignRestController {
	public static String uploadDirectory = System.getProperty("user.dir")+"/";

	/**
	 * this functions takes a fasta file and optional alignment queries then outputs the align object with all information
	 * @param file
	 * @param alignQuery
	 * @return align object containing all information
	 */
	@PostMapping("/align/api")
    public Align uploadFile(@RequestParam("file") MultipartFile file,
    		@RequestParam Map<String, String> alignQuery) {
		Align align = new Align();
		if (alignQuery.containsKey("type"))
			align.setAlignment(alignQuery.get("type"));
		if (alignQuery.containsKey("matrix"))	
			align.setScoringMatrix(alignQuery.get("matrix"));
		else
			align.setScoringMatrix("BLOSUM62");
		if (alignQuery.containsKey("gap"))	
			align.setGap(Integer.parseInt(alignQuery.get("gap")));
		if (alignQuery.containsKey("mismatch"))	
			align.setMismatch(Integer.parseInt(alignQuery.get("mismatch")));
		Path fileNameAndPath = Paths.get(uploadDirectory, file.getOriginalFilename());
    	File fasta = new File(uploadDirectory + file.getOriginalFilename());
		try {
			Files.write(fileNameAndPath, file.getBytes());
			AlignmentFunctions.AddAlignment(align, fasta);
		} catch (IOException e) {
			if (fasta.exists()){
	    		fasta.delete();
	    	}
			e.printStackTrace();
		}
		if (fasta.exists()){
    		fasta.delete();
    	}
		return align;
    }
}

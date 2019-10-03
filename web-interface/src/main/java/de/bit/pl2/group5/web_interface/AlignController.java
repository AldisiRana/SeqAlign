package de.bit.pl2.group5.web_interface;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 * This is a class that maps the html pages and gets the parameters from the web interface
 * @author RanaAldisi
 *
 */

@Controller
public class AlignController {
	public static String uploadDirectory = System.getProperty("user.dir")+"/";
	
	/**
	 * 
	 * @return the home page
	 */
	@GetMapping("/")
	public String homePage() {
		return "home";	
	}
	
	private static Align align = new Align();

	/**
	 * 
	 * @param model
	 * @return the page with alignment parameters
	 */
	@GetMapping("/align")
	public String alignmentForm(Model model) {
        model.addAttribute("align", align);
        return "align";
    }
	
	/**
	 * 
	 * @return info page
	 */
	@GetMapping("/info")
    public String getInfo() {
        return "info";
    }
	
	/**
	 * This function takes the uploaded file and the align class and does the alignment
	 * @param align
	 * @param file
	 * @return the page with the alignment results
	 */
	@RequestMapping(value = "/align", method= RequestMethod.POST)
    public String resultsSubmit(@ModelAttribute Align align, @RequestParam(value = "file") MultipartFile file) {
    	Path fileNameAndPath = Paths.get(uploadDirectory, file.getOriginalFilename());
    	File fasta = new File(uploadDirectory + file.getOriginalFilename());
    	String results = "result";
    	if (file.isEmpty()) {
    		results="FileError";
    	}
    	else {
    		try {
        		Files.write(fileNameAndPath, file.getBytes());
        		if (checkFileFormat(fasta))
        			results="FileError";
        		else
        			AlignmentFunctions.AddAlignment(align, fasta);
    		} catch (IOException e) {
    			results="FileError";
    		}
    	}
    	
    	if (fasta.exists()){
    		fasta.delete();
    	}
    	 
		return results;
    }
    
	/**
	 * this method takes a fasta File and checks if its valid for alignment
	 * @param fasta
	 * @return boolean, true is invalid, false is valid
	 */
	public boolean checkFileFormat(File fasta) {
		try {
			boolean check=false;
			Scanner sc = new Scanner(fasta);
			if (!fasta.isFile() || !fasta.canRead()) {
				check = true;
			}
			else if (!sc.hasNextLine()) {
				check = true;
			}
			else if (!sc.nextLine().startsWith(">")) {
				check = true;
			}
			sc.close();
			return check;
		} catch (FileNotFoundException e) {
			return true;
		}
	}

}
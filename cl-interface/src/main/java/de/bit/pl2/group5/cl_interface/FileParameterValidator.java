package de.bit.pl2.group5.cl_interface;

import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.beust.jcommander.*;

public class FileParameterValidator implements IParameterValidator {
	public void validate(String name, String value) throws ParameterException {
		Path pathToFile = Paths.get(value);
		if(!Files.exists(pathToFile, LinkOption.NOFOLLOW_LINKS)) {
			String mes = String.format("[%s] does not exist: ", value);
			throw new ParameterException(mes);
		}
		if(!Files.isRegularFile(pathToFile, LinkOption.NOFOLLOW_LINKS)) {
			String mes = String.format("[%s] is not a file: ", value);
			throw new ParameterException(mes);
		}
	}
}

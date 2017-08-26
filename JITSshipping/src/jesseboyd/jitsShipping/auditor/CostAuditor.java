package jesseboyd.jitsShipping.auditor;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Observable;
import java.util.Observer;

public class CostAuditor implements Observer {
	// listens to the calculation builder
	@Override
	public void update(Observable arg0, Object arg1) {

		File directory = new File("output2");
		if (!directory.exists()) {
			directory.mkdirs();
		}
		try (Writer writer = new BufferedWriter(new FileWriter("output2/jitsCostAudit.txt", true))) {

			writer.write(arg1.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws UnsupportedEncodingException, FileNotFoundException, IOException {
		// will create file if it doesn't exist, see true in file writer
		try (Writer writer = new BufferedWriter(new FileWriter("filename.txt", true))) {
			writer.write("something\n");
		}

		// file must already exist, will create folder and file
		Path filePath = Paths.get("output/file1.bin");
		if (!Files.exists(filePath)) {
			Files.createDirectory(filePath.getParent()); // creates folder output
			Files.createFile(filePath); // creates file file.bin
		}
		Files.write(filePath, "jesse \n".getBytes(), StandardOpenOption.APPEND); // the simplest way!

		// using ternary operators
		Path filePath2 = Paths.get("ternary.txt");
		Files.write(filePath2, "hey hey \n".getBytes(),
				Files.exists(filePath2) ? StandardOpenOption.APPEND : StandardOpenOption.CREATE);
	}

}

package jesseboyd.jitsShipping.auditor;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Observable;
import java.util.Observer;

public class CostAuditor implements Observer{
// listens to the calculation builder
	@Override
	public void update(Observable arg0, Object arg1) {
System.out.println("update called");

Path path = Paths.get("jitsCostAuditLog.txt");
try {
	Files.createFile(path);
//	Files.write(path, arg1.toString()., StandardCharsets.UTF_8);
} catch (IOException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}

//try (File file = new File("jitsCostAuditLog.txt");
//		
//		Files files = new OutputStreamWriter("jitsCostAuditLog.txt") ;
//		
//	try {
//		System.out.println(arg1);
//		//fstream
//		buffy.write(arg1.toString() + "\n");
//	} catch (IOException e) {
//		e.printStackTrace();
//	}
//	} catch (IOException e1) {
//		e1.printStackTrace();
//	}
}
	
	public static void main(String[] args) throws UnsupportedEncodingException, FileNotFoundException, IOException {
		try (Writer writer = new BufferedWriter(new OutputStreamWriter(
	              new FileOutputStream("filename.txt"), "utf-8"))) {
	   writer.write("something");
	}
		
		    Files.write(Paths.get("file1.bin"), "jesse".getBytes());
		
	}

}

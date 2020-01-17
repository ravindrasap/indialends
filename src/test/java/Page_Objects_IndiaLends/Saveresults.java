package Page_Objects_IndiaLends;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;

import com.google.common.io.Files;
public class Saveresults {

	public void reportverification() {
    //public static void main(String args[]) throws IOException {
    	
    	File from = new File("C:\\Users\\ravindrakumar\\eclipse-workspace\\IndiaLends_Sanity\\test-output\\Result\\report.html");
      //  File from = new File("D:\\Workspace\\appiumdemo\\test-output\\emailable-report.html");
 
    	   DateFormat df = new SimpleDateFormat("yyyyMMddhhmmss");
    	  File to = new File("C:\\Users\\ravindrakumar\\eclipse-workspace\\Resultsbackup\\"+df.format(new Date())+".html");
    	  
    	  
        try {
			copy(from, to);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
       
        System.out.println("Test result copied to backup folder");    
    
    }
        public static void copyFile(String from, String to) throws IOException{
            Path src = Paths.get(from);
            Path dest = Paths.get(to);
            Files.copy(src.toFile(), dest.toFile());
        }
        public static void copyFileUsingApache(File from, File to) throws IOException{
            FileUtils.copyFile(from, to);
        }
        @SuppressWarnings("resource")
		private static void copy(File src, File dest) throws IOException {
            InputStream is = null;
            OutputStream os = null;
            try {
               is = new FileInputStream(src);
                os = new FileOutputStream(dest);

                // buffer size 1K
                byte[] buf = new byte[1024];

                int bytesRead;
                while ((bytesRead = is.read(buf)) > 0) {
                    os.write(buf, 0, bytesRead);
                }
            } finally {
              //  is.close();
              //  os.close();
            }
        }

    }
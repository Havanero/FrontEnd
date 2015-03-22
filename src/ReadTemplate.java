
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author cubanguy
 */
public class ReadTemplate {
    
    private String fileName;
    
    public ReadTemplate(String pFileName){
        this.fileName = pFileName;
        
    }
  
    
    public String getTemplate() throws FileNotFoundException, IOException{
        
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        try {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                line = br.readLine();
                }
            String everything = sb.toString();
            return everything;
            } finally {
                br.close();
                }
        }
}
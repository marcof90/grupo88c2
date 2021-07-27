package view;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Properties;

public class Files {
    
    public static void main(String[] args) {
        
        try {
            
            OutputStream output = new FileOutputStream("./data/data.properties");
            Properties prop = new Properties();

            prop.setProperty("nombre", "Marco");
            prop.setProperty("edad", "31");

            prop.store(output, null);
            System.out.println(prop);

        } catch (Exception e) {
            //TODO: handle exception
        }
    }
}

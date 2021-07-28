package view;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
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
            output.close();
        } catch (Exception e) {
            //TODO: handle exception
        }

        try {
            
            InputStream ins = new FileInputStream("./data/data.properties");
            Properties prop = new Properties();

            prop.load(ins);

            System.out.println(prop.getProperty("nombre"));
            System.out.println(prop.getProperty("edad"));

            ins.close();

        } catch (Exception e) {
            //TODO: handle exception
        }
    }
}

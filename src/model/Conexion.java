package model;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.Properties;

public class Conexion {
    private Connection connect;
    private String url;
    private String user;
    private String password;
    private ArrayList<String> sql =new ArrayList<String>();

    public Conexion() {
        super();
        getDBProperties();
        connectDB();
    }

    public void getDBProperties() {
        try {
            InputStream ins = new FileInputStream("./data/db.properties");
            Properties prop=new Properties();
            prop.load(ins);  
            url=prop.getProperty("url");
            user=prop.getProperty("user");
            password=prop.getProperty("password");
            ins.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }             
    }

    public void connectDB() {
        try {
            connect=DriverManager.getConnection(url, user, password);
            boolean valid=connect.isValid(50000);
            System.out.println(valid ? "Connected":"Failed");
            Statement miStatemen=connect.createStatement();
            ResultSet miResulset = miStatemen.executeQuery("SELECT SUM(Cantidad) AS total, ID_Proyecto, Pagado, Proveedor"+
            " FROM `Compra` WHERE Pagado = 'No' GROUP BY ID_Proyecto HAVING SUM(Cantidad)>50 ORDER BY Proveedor");
            while (miResulset.next())
            System.out.println(miResulset.getString("Pagado")+" "+ miResulset.getString("total"));           
       } catch (Exception e) {
           System.out.println("no conecta");
           e.printStackTrace();            
       }
   }

   public void consult() {
       sql.add("SELECT SUM(Cantidad) AS total, ID_Proyecto, Pagado, Proveedor FROM `Compra` WHERE Pagado = 'No' GROUP BY ID_Proyecto HAVING SUM(Cantidad)>50 ORDER BY Proveedor");
       sql.add("SELECT SUM(Compra.Cantidad) AS compras, Lider.Nombre, Lider.Primer_Apellido, Proyecto.ID_Proyecto AS proyecto FROM `Compra`, `Proyecto` ,`Lider` WHERE Proyecto.ID_Lider=Lider.ID_Lider AND Compra.ID_Proyecto=Proyecto.ID_Proyecto GROUP BY Proyecto.ID_Proyecto HAVING SUM(Compra.Cantidad)>50 ORDER BY SUM(Compra.Cantidad) DESC LIMIT 0,101");
       sql.add("SELECT Proyecto.ID_Proyecto, Proyecto.Fecha_Inicio, Proyecto.Constructora FROM `Lider`,`Proyecto`, `Tipo` WHERE (Proyecto.ID_Lider= Lider.ID_Lider AND Tipo.ID_Tipo=Proyecto.ID_Tipo) AND Tipo.Financiable=1 AND Lider.Salario<1000000 AND Proyecto.Clasificacion='Casa' AND Tipo.Estrato<4 AND Tipo.Area_Max>300 AND Proyecto.Acabados='Si' GROUP BY Proyecto.ID_Proyecto ORDER BY Proyecto.ID_Proyecto ASC");
       sql.add("SELECT Proyecto.Fecha_Inicio AS inicio, Tipo.Financiable, Tipo.Estrato, Proyecto.Porcentaje_Cuota_Inicial*100 FROM `Tipo`, `Proyecto` WHERE (Proyecto.ID_Tipo=Tipo.ID_Tipo) AND Tipo.Estrato>5 AND Tipo.Financiable=0 AND Proyecto.Porcentaje_Cuota_Inicial>0.2 AND DATE(Proyecto.Fecha_Inicio)>'2021-1-1' GROUP BY Proyecto.Fecha_Inicio ORDER BY Tipo.Estrato ASC");
       sql.add("SELECT Proyecto.ID_Proyecto, Compra.Pagado, Proyecto.Clasificacion FROM `Proyecto`, `Compra`, `MaterialConstruccion` WHERE Proyecto.ID_Proyecto=Compra.ID_Proyecto AND MaterialConstruccion.ID_MaterialConstruccion=Compra.ID_MaterialConstruccion AND MaterialConstruccion.Importado='Si' AND Compra.Pagado IN('NO','Parcialmente') AND Proyecto.Clasificacion IN('Apartamento','Apartaestudio') AND Proyecto.Acabados='No' GROUP BY Proyecto.ID_Proyecto ORDER BY Proyecto.ID_Proyecto ASC");
       
    try {
        Statement stmt = connect.createStatement();
        for (String string : sql) {
            stmt.executeQuery(string);
            //ResultSet miResulset = stmt.executeQuery(string);
            //while (miResulset.next())
            //System.out.println(miResulset.getString("Pagado")+" "+ miResulset.getString("total"));
        }           
    } catch (SQLException e) {        
        e.printStackTrace();
         }       
    }

   public static void main(String[] args) {
       Conexion conexion=new Conexion();
       conexion.connectDB();
       conexion.consult();
   }       
}

    
    /*public static void main(String[] args) {
        try {
             // 1creando la conexion
             Connection miConexion=DriverManager.getConnection("jdbc:mysql://localhost:3306/Proyectos","root","");
             //2 creando statement
             Statement miStatemen=miConexion.createStatement();
             //3 ejecutar la instruccion SQL
             ResultSet miResulset = miStatemen.executeQuery("SELECT SUM(Cantidad) AS total, ID_Proyecto, Pagado, Proveedor"+
             " FROM `Compra` WHERE Pagado = 'No' GROUP BY ID_Proyecto HAVING SUM(Cantidad)>50 ORDER BY Proveedor");
             //4 LEER EL RESULSET QUE ES UNA TABLA CREADA DE LA CONSULTA
            // ResultSet miResulset1 = miStatemen.executeQuery("SELECT SUM(Compra.Cantidad) AS compras, Lider.Nombre, Lider.Primer_Apellido, Proyecto.ID_Proyecto AS proyecto FROM 'compra', 'proyecto','lider' WHERE Proyecto.ID_Lider, Lider.ID_Lider AND Compra.ID_Proyecto, Proyecto.ID_Proyecto GROUP BY proyecto HAVING compras>80 ORDER by compras ");

            // ResultSet miResulset2 = miStatemen.executeQuery("");

             //ResultSet miResulset3 = miStatemen.executeQuery("");

            // ResultSet miResulset4 = miStatemen.executeQuery("");
 
             while (miResulset.next())
             System.out.println(miResulset.getString("Pagado")+" "+ miResulset.getString("total"));           
        } catch (Exception e) {
            System.out.println("no conecta");
            e.printStackTrace();            
        }
    }*/
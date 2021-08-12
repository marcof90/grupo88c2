import model.Conexion;

public class Controller {
    private Conexion dbservice;
   
    public Controller() {
        super();
        dbservice=new Conexion();
    }
}

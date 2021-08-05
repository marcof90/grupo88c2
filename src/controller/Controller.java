package controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Owner;
import services.JavaMySQLService;

public class Controller {
    
    private JavaMySQLService dbService;
    private ArrayList<Owner> owners;

    public Controller() {
        super();
        owners = new ArrayList<>();
        dbService = new JavaMySQLService();
        checkDBConnection();
    }

    public ArrayList<Owner> getOwners() {
        return owners;
    }

    public void checkDBConnection() {
        try {
            if (dbService.getConnect().isValid(30)) {
                fillUsersData(dbService.getUsersDB());
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void fillUsersData(ResultSet rs) {
        try {
            while (rs.next()) {
                Owner owner = new Owner(rs.getString("name"));
                owners.add(owner);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void addOwner(String nombre) {
        Owner cliente = new Owner(nombre);        
        owners.add(cliente);
        dbService.insertUser(nombre);
    }

    public String listarClientes(){
        String listado = "";
        for (Owner cliente : owners) {
            listado += "Nombre: "+cliente.getNombre() + "\n";
        }
        return listado;
    }
    
    public String[] getListClientes() {
        String[] listado = new String[owners.size()];
        for (int i = 0; i < listado.length; i++) {
            listado[i] = owners.get(i).toString();
        }
        return listado;
    }


}

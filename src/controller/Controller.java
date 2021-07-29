package controller;

import java.util.ArrayList;

import model.Owner;

public class Controller {
    
    private ArrayList<Owner> owners;

    public Controller() {
        super();
        owners = new ArrayList<>();
    }

    public ArrayList<Owner> getOwners() {
        return owners;
    }

    public void addOwner(String nombre) {
        Owner cliente = new Owner(nombre);
        owners.add(cliente);
    }

    public String listarClientes(){
        String listado = "";
        for (Owner cliente : owners) {
            listado += "Nombre: "+cliente.getNombre() + "\n";
        }
        return listado;
    }
    

}

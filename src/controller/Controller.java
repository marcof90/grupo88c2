package controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Owner;
import model.Transaction;
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
            e.printStackTrace();
        }
    }

    public void fillUsersData(ResultSet rs) {
        try {
            while (rs.next()) {
                Owner owner = new Owner(rs.getString("name"));
                owner.setId(rs.getInt("id"));
                owners.add(owner);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void fillTransactionsData(int id) {
        ResultSet rs = dbService.getTransactionsWallet(id);
        owners.get(id).getWallet().setTransactions(new ArrayList<>());
        try {
            while (rs.next()) {
                Transaction t = new Transaction(rs.getInt("saldo"), "hoy", rs.getInt("tipo_transaccion"));
                owners.get(id).getWallet().getTransactions().add(t);
            }
        } catch (SQLException e) {
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

    public String[] getDataTransactions(int id) {
        String[] dataTransactions = new String[owners.get(id).getWallet().getTransactions().size()];
        for (int i = 0; i < dataTransactions.length; i++) {
            dataTransactions[i] = owners.get(id).getWallet().getTransactions().get(i).toString();
        }
        return dataTransactions;
    }

    public Owner getWalletUser(int id) {
        ResultSet rs = dbService.getWalletUser(owners.get(id).getId());
        try {
            while (rs.next()) {
                owners.get(id).getWallet().setId(rs.getInt("id"));
                owners.get(id).getWallet().setSaldo(rs.getInt("saldo"));
            }
            return owners.get(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}

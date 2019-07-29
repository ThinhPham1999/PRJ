/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

/**
 *
 * @author Thinh
 */
public class ProductManagerImp extends UnicastRemoteObject implements ProductManagerInterface , Serializable{
    ArrayList<Product> list = new ArrayList<>();

    public ProductManagerImp() throws RemoteException {
        super();
    }

    @Override
    public ArrayList<Product> getAll() throws RemoteException {
        list = ProductDB.getAll();
        return list;
    }

    @Override
    public String addProduct(Product pr) throws RemoteException {
        ProductDB.newProduct(pr.getId(), pr.getName(), pr.getUnit(), pr.getPrice());
        return "";
    }

    @Override
    public String getProduct(String newid) throws RemoteException {
        ProductDB.getProduct(newid);
        return "";
    }
  
    
    
    
}


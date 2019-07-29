/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi;

import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 *
 * @author Thinh
 */
public interface ProductManagerInterface {
    public ArrayList<Product> getAll() throws RemoteException;
    public String addProduct(Product pr) throws RemoteException;
    public String getProduct(String newid) throws RemoteException;
}

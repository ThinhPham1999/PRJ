/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Thinh
 */
public class ProductMangerServer {
    public ProductMangerServer(){
        
    }
    
    
    public static void main(String[] args){
        try{
            System.out.println("Server starting...");
            // Create port 1088
            Registry registry = LocateRegistry.createRegistry(1088);
            // Create remote object and register it
            registry.rebind("ProductManager", new ProductManagerImp());
            System.out.println("Server started...");
        }catch(RemoteException ex){
            Logger.getLogger(ProductMangerServer.class.getName()).log(Level.SEVERE, null, ex);
        }catch(Exception ex){
            Logger.getLogger(ProductManagerImp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

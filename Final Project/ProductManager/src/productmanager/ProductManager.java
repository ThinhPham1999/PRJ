/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package productmanager;

import rmi.Product;
import rmi.ProductDB;
import java.util.ArrayList;
import model.*;


/**
 *
 * @author Thinh
 */
public class ProductManager {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayList<Product> list = new ArrayList<>();
        list = ProductDB.getAll();
        
        Product product = new Product("P0009", "Oppo", "Set", 2000000);
        System.out.println(product);
        System.out.println(list);
        //StudentDB.addNewStudent("S0009", "Long", doB, 2);
    }
    
}

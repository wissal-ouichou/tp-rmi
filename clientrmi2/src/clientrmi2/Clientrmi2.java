/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientrmi2;

import dao.IDao;
import entities.Machine;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author WISSAL
 */
public class Clientrmi2 {

    public static void main(String[] args) {
        try {
            IDao<Machine> dao = (IDao<Machine>) Naming.lookup("rmi://localhost:1099/dao");
            dao.create(new Machine("EE1", "Dell", 1900));
            dao.create(new Machine("EE2", "hp", 1200));
            for(Machine m : dao.findAll())
                System.out.println(m);
        } catch (NotBoundException ex) {
            Logger.getLogger(Clientrmi2.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(Clientrmi2.class.getName()).log(Level.SEVERE, null, ex);
        } catch (RemoteException ex) {
            Logger.getLogger(Clientrmi2.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}

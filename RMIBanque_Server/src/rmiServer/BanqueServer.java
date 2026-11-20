package rmiServer;

import java.rmi.registry.LocateRegistry;
import javax.naming.InitialContext;

import rmiService.BanqueImpl;

public class BanqueServer {
    public static void main(String[] args) {
        try {
            LocateRegistry.createRegistry(1099);

            BanqueImpl banque = new BanqueImpl();

            InitialContext contexte = new InitialContext();
            contexte.rebind("BanqueService", banque);

            System.out.println("Serveur RMI/JNDI prêt sur le port 1099.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
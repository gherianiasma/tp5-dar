package rmiServer;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import rmiService.ConversionImpl;

public class ConversionServer {

    public static void main(String[] args) {

        try {
            // 1. Activer le registre RMI
            Registry registry = LocateRegistry.createRegistry(1099);

            // 2. Créer l'objet distant
            ConversionImpl service = new ConversionImpl();

            // 3. Publier l'objet dans le registre
            registry.rebind("ConversionService", service);

            System.out.println("Serveur RMI démarré !");
            System.out.println("Service publié sous le nom : ConversionService");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

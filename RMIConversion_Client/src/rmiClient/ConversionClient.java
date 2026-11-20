package rmiClient;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import rmiService.IConversion;

public class ConversionClient {

    public static void main(String[] args) {

        try {
            // 1. Se connecter au registre RMI
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);

            // 2. Rechercher l'objet distant
            IConversion service =
                    (IConversion) registry.lookup("ConversionService");

            // 3. Invoquer la méthode distante
            double resultat = service.convertirMontant(500);

            // 4. Afficher le résultat
            System.out.println("Montant en euros : 500");
            System.out.println("Montant en dinars : " + resultat);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

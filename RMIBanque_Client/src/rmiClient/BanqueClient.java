package rmiClient;

import java.util.Date;
import java.util.Scanner;

import javax.naming.InitialContext;

import metier.Compte;
import rmiService.IBanque;

public class BanqueClient {
    public static void main(String[] args) {
        try {
            InitialContext contexte = new InitialContext();

            IBanque banque = (IBanque) contexte.lookup("BanqueService");

            Scanner scanner = new Scanner(System.in);

            System.out.print("Code du compte : ");
            int code = scanner.nextInt();

            System.out.print("Solde initial : ");
            double solde = scanner.nextDouble();

            Compte compte = new Compte(code, solde);
            System.out.println(banque.creerCompte(compte));

            System.out.println("\nInformations du compte :");
            System.out.println(banque.getInfoCompte(code));

            scanner.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
package rmiService;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.Map;

import metier.Compte;

public class BanqueImpl extends UnicastRemoteObject implements IBanque {
    private static final long serialVersionUID = 1L;

    private Map<Integer, Compte> comptes;

    public BanqueImpl() throws RemoteException {
        super();
        comptes = new HashMap<>();
    }

    @Override
    public synchronized String creerCompte(Compte compte) throws RemoteException {
        if (compte == null) {
            return "Erreur : le compte fourni est vide.";
        }

        if (comptes.containsKey(compte.getCode())) {
            return "Un compte avec ce code existe déjà.";
        }

        comptes.put(compte.getCode(), compte);
        return "Compte créé avec succès.";
    }

    @Override
    public synchronized String getInfoCompte(int code) throws RemoteException {
        Compte compte = comptes.get(code);

        if (compte == null) {
            return "Aucun compte trouvé avec le code " + code + ".";
        }

        return compte.toString();
    }
}
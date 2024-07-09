package pres;

import dao.DaoImpl;
import metier.MetierImpl;

public class PresentationV1 {
    public static void main(String[] args) {
        /*
        Injection des dépendances par instanciation statique
         */
        DaoImpl daoImpl = new DaoImpl();
        MetierImpl metier =  new MetierImpl(daoImpl); // Injection via le constructeur
        // metier.setDao(daoImpl); // Injection via le setter
        System.out.println("RES="+metier.calcul());
    }
}

package pres;

import dao.IDao;
import metier.IMetier;

import java.io.File;
import java.lang.reflect.Method;
import java.util.Scanner;

public class PresentationV2 {
    public static void main(String[] args) {
        /*
        Injection des dépendances par instanciation dynamic
         */
        try {
            Scanner scanner = new Scanner(new File("config.txt"));
            String daoClassName = scanner.nextLine();
            Class cDao = Class.forName(daoClassName);
            IDao dao = (IDao) cDao.getConstructor().newInstance();

            // MetierImpl metier =  new MetierImpl();
            String metierClassName = scanner.nextLine();
            Class cMetier = Class.forName(metierClassName);
            IMetier metier = (IMetier) cMetier.getConstructor().newInstance();

            // metier.setDao(dao);
            Method setDao = cMetier.getDeclaredMethod("setDao",IDao.class);
            setDao.invoke(metier,dao);

            System.out.println("Res = " + metier.calcul());

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

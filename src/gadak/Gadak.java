
package gadak;

import java.util.Scanner;

/**
 *
 * @author szymon
 */
public class Gadak {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        SlownikPrzejsc sp = new SlownikPrzejsc(3,"/home/szymon/NetBeansProjects/Gadak/src/gadak/alamakota.txt");
        Scanner konsola = new Scanner (System.in);
        System.out.println("PISZ!");
        String uzytkownik;
       //sp.sprawdz();
                 System.out.println(new Klucz(2));
        for (int i = 0 ; i < 10 ; i++){
            uzytkownik = konsola.nextLine();
            //sp.Aktualizuj(uzytkownik);
            System.out.println("Lul : "+sp.GenerujTekst(10, sp.getNgram(uzytkownik, 3)));
        }
        
        /* Klucz cos = new Klucz (2);
        cos.Add("a");
        cos.Add("a");
        System.out.println(cos.toString().hashCode());
        System.out.println(cos.toString().hashCode());
        System.out.println(cos);
        System.out.println(cos.toString());*/
        
        
    }
    
}

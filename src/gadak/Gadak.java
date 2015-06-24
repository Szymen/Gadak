
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
        
        SlownikPrzejsc sp = new SlownikPrzejsc(3,"/home/szymon/NetBeansProjects/Gadak/src/gadak/Iliada.txt");
        Scanner konsola = new Scanner (System.in);

        String uzytkownik;
        for (int i = 0 ; i < 10 ; i++){        System.out.println("PISZ!");
            uzytkownik = konsola.nextLine();
            System.out.println("Odpowiedz: "+sp.Odpowiedz(uzytkownik));
        }
        

        
    }
    
}

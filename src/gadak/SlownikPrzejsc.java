/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gadak;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

/**
 *
 * @author szymon
 */
public class SlownikPrzejsc {
    
    private final HashMap< String , ArrayList < String > > Przejscia = new HashMap<  >();
    private Klucz pierwszy ;
    private final int grams ;
    private final Random rand = new Random();
    
    public SlownikPrzejsc(int grams, String nazwaPliku){
        this.grams = grams;
        pierwszy = new Klucz(grams); 
        CzytajZPliku(nazwaPliku);
    }   
    private void CzytajZPliku( String nazwaPliku ){
    String [] words;
    String everything = new String();
    Klucz roboczy = new Klucz(this.grams);
        try(BufferedReader br = new BufferedReader(new FileReader(nazwaPliku))) {
        
        StringBuilder sb = new StringBuilder();
        String line = br.readLine();

        while (line != null) {
            sb.append(line);
            sb.append(" ");
            line = br.readLine();
        }
        everything = sb.toString();
    }catch(Exception e){
        System.out.println("Error in \"CzytajZPliku\"!"); 
    }
        words = everything.split(" "); // todo male pliki
     for ( int  i = 0 ; i < this.grams ; i++ ){ 
        pierwszy.Add(words[i]);
        }
     for ( String s : words ){

         if(Przejscia.get(roboczy.toString()) == null){
             Przejscia.put(roboczy.toString(), new ArrayList <String>());
         }
         //System.out.println("Dodano w kluczu : " + roboczy.toString() + " - " + s );
         Przejscia.get(roboczy.toString()).add(s);
         roboczy.Add(s);
     }
     
     
    }
    private void Aktualizuj(String tekst){
        String[] podzielone  = tekst.split(" ");
        Klucz roboczy = new Klucz(this.grams);
        for(String s : podzielone){
            if(Przejscia.get(roboczy.toString()) == null){
             Przejscia.put(roboczy.toString(), new ArrayList <String>());
         }
         Przejscia.get(roboczy.toString()).add(s);
         roboczy.Add(s);
        }
    
    }
    private String GenerujTekst(int docelowe, Klucz poczatek){
         Klucz roboczy = poczatek;

         int dlugosc = 0;
         Random rm = new Random();
         int wylosowany_indeks = 0;
         String wylosowane_slowo = new String();
         String wynik = new String();
         
         while(dlugosc < docelowe){

                if (Przejscia.get(roboczy.toString()) == null){wynik += "..."; break;}
                wylosowany_indeks = rm.nextInt(Przejscia.get(roboczy.toString()).size());
                wylosowane_slowo =  Przejscia.get(roboczy.toString()).get(wylosowany_indeks);
                wynik+= wylosowane_slowo + " ";
                roboczy.Add(wylosowane_slowo);
                dlugosc ++;
         }         
         return wynik;

     }
    private Klucz getNgram(String text, int gram){  
       String[] podzielony = text.split(" ");
       Klucz wynik = new Klucz (gram);
              if (podzielony.length < gram ){return wynik;}
       int index = podzielony.length-gram;
       for (int i = 0; i < gram ; i++){
           wynik.Add(podzielony[index+i].toString());
       }
       return wynik;
    }
    public void sprawdz(){
        for (String s : Przejscia.keySet()){
            System.out.print("->"+s+"<-" + " : ");
            for(String x : Przejscia.get(s)){
                System.out.print(x+" ");
            }
            System.out.println();
            System.out.println();
        }
    }
    public String Odpowiedz(String wiadomosc){
        Aktualizuj(wiadomosc);
        int dlugosc_tekstu = wiadomosc.split(" ").length;
        return GenerujTekst(dlugosc_tekstu,getNgram(wiadomosc,grams));
    }
}

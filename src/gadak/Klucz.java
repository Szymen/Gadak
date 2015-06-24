/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gadak;

import java.util.ArrayList;
import java.lang.Object;
/**
 *
 * @author szymon
 */
public class Klucz {
    private final ArrayList< String > ArrList = new ArrayList<  >();
    private final int size; 
    public Klucz( int size ){
        for ( int i = 0 ; i < size ; i++ ){
            ArrList.add("");
        }
        this.size = size ;
    }
    
    public void Add( String slowo ){
        
        for ( int i = 1 ; i < size ; i++ ){
            ArrList.set(i-1, ArrList.get(i)) ;
        }
        ArrList.set(this.size-1,slowo);
    }
    
    @Override
    public String toString(){
        String result = new String();   
        for ( String s : ArrList ){
            result += s ;
        }
        return result;
    }
    
}

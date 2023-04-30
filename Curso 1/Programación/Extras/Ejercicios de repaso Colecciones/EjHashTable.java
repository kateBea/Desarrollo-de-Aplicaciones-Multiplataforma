import java.util.*;

public class EjHashTable {
    public static void main(String[] args) {

        //creo el objeto
        Hashtable<Integer, String> hTable = new Hashtable<Integer, String>();
        //añado elementos al objeto hTable

        hTable.put (3, "Three");
        hTable.put (5, "Five");
        hTable.put (2, "Two");
        hTable.put (1, "One");
        hTable.put (4, "Four");

        Enumeration <Integer> claves = hTable.keys();
        while (claves.hasMoreElements()){
            int key = claves.nextElement();
            String valor = hTable.get(key);
            System.out.println ("Key " + key + " value " + valor );
        }
        

        
    }
    
}

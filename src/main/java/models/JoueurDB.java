package models;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author z.zafar
 */
public class JoueurDB {
    public static Map<String, Joueur> joueurMap = createMap();
    
    private static Map<String, Joueur> createMap() {
         Map<String, Joueur> temp = new HashMap<>();
        
        temp.put("meyer", new Joueur("Meyer", "Luc", 30, "meyer", "1111"));
        temp.put("dupont", new Joueur("Dupont", "Rene", 40, "dupont", "2222"));
        temp.put("legrand", new Joueur("Legrand", "Lisa", 16, "legrand", "3333"));  
    
        return temp;
    } 
}

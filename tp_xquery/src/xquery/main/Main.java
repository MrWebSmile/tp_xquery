/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xquery.main;
import org.basex.core.Context;
import xquery.config.Config;
import static xquery.config.Config.CONF_PTH;


/**
 *
 * @author adrien
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Config conf = new Config(CONF_PTH);
        String titre = "Lost Girl";
        String query = "for $title in doc('kat.xml')//title "
                + "where contains($title,'"+titre+"')"
                + "return <p>{$title}</p>";
    }
    
}

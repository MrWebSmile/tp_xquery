/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xquery.main;
import xquery.config.Config;
import xquery.exceptions.SystemException;
import xquery.model.Model;



/**
 *
 * @author adrien
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Config conf = new Config(Config.CONF_PTH);
        Model m = new Model(conf.getProp(Config.DATABASE),conf.getProp(Config.DB_PATH));
        String xml ="kat.xml";
        String titre = "Lost Girl";
        String query = "for $title in //title/text() "
                + "where contains($title,'"+titre+"')"
                + "return <p>{$title}</p>";
        try
        {
            String db =m.createDatabase();
            m.openDb(db);
            m.addXMLToDb(conf.getProp(Config.DB_PATH)+"/"+xml);
            System.out.println(m.getDatabases());
            System.out.println(m.executeQuery(query));
        }
        catch(SystemException se)
        {
            System.out.println(se.getMessage());
        }
    }
    
}

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
        Model m = new Model(conf.getProp(Config.DATABASE), conf.getProp(Config.DB_PATH));
        String xml = "kat.xml";
        String query = "for $title in /series/nom/text()\n"
                + "for $title2 in //title\n"
                + "where contains($title2,$title)\n"
                + "return $title";
        try {
            String db = m.createDatabase();
            String path = conf.getProp(Config.DB_PATH);
            m.openDb(db);
            m.addXMLToDb(path + "/" + xml);
            m.addXMLToDb(path+ "/series.xml");
            System.out.println(m.getDatabases());
            String titre = m.executeQuery(query);
            System.out.println(titre);
            m.createXml(titre, query, path);
        } catch (SystemException se) {
            System.out.println(se.getMessage());
        }
    }

}

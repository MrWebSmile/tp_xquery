/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xquery.model;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import org.basex.core.BaseXException;
import org.basex.core.Context;
import org.basex.core.cmd.*;
import xquery.exceptions.SystemException;

/**
 *
 * @author adrien
 */
public class Model implements IModel {

    private Context ctx;
    private String dbName;
    private String path;

    public Model(String db, String pth) {
        this.ctx = new Context();
        this.dbName = db;
        this.path = pth;
    }

    @Override
    public void deleteDb(String db) throws SystemException {

        try {
            if (db.isEmpty()) {
                db = dbName;
            }
            new DropDB(db).execute(ctx);
        } catch (BaseXException be) {
            System.out.println(be.getMessage());
        }
    }

    @Override
    public String executeQuery(String query) throws SystemException {

        try {
            return new XQuery(query).execute(ctx);
        } catch (BaseXException ex) {
            throw new SystemException("Query Exception");
        }
    }

    @Override
    public String getDatabases() throws SystemException {
        try {
            return new List().execute(ctx);
        } catch (BaseXException ex) {
            throw new SystemException("Error on getting List");
        }
    }

    @Override
    public String getElementsInCollection(String collectionName) throws SystemException {
        try {
            return new XQuery(
                    "for $doc in collection('" + collectionName + "')"
                    + "return <doc path='{ base-uri($doc) }'/>"
            ).execute(ctx);
        } catch (BaseXException ex) {
            throw new SystemException("Query Exception");
        }
    }

    @Override
    public String openDb(String dbName) throws SystemException {
        try {
            new Open(dbName).execute(ctx);
            return dbName;
        } catch (BaseXException ex) {
            throw new SystemException("Error on opening DB");
        }
    }

    @Override
    public String createDatabase() throws SystemException {
        try {
            new CreateDB(dbName).execute(ctx);
            return dbName;
        } catch (BaseXException ex) {
            throw new SystemException("Error on opening Database");
        }
    }

    @Override
    public void removeXML(String file) throws SystemException {
        try {
            new Delete(file).execute(ctx);
        } catch (BaseXException ex) {
            throw new SystemException("Error on removing a file");
        }
    }

    @Override
    public void addXMLToDb(String path) throws SystemException {
        try {
            /* add all the xml files that are in the path*/
            new Add("", path).execute(ctx);
            //new Optimize().execute(ctx);
        } catch (BaseXException ex) {
            throw new SystemException("Error on adding files");
        }
    }

    @Override
    public void refreshDb() throws SystemException {
        addXMLToDb(path);
        removeFiles(path);
    }

    @Override
    public String useDefaultDb() throws SystemException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void removeFiles(String path) {
        File f = new File(path);
        if (f.exists()) {
            File[] files = f.listFiles();
            for (File file : files) {
                if (file.isDirectory()) {
                    removeFiles(f + "\\" + file);
                }
                file.delete();
            }

        }
    }

    @Override
    public void createXml(String title, String query, String path) throws SystemException {

        try {
            File file = new File(path + "/" + title + ".xml");
            PrintWriter write;
            write = new PrintWriter(new FileWriter(file));
            String prolog = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>";
            write.println(prolog);
            write.println("<serie>");
            write.println("<nom>" + title + "</nom>");
            write.println("<episodes>");
            write.println("<episode>");
            write.println("<nom></nom>");
            write.println("<lien></lien>");
            write.println("<episode>");
            write.println("<episodes>");
            write.println("<serie>");
            write.close();
        } catch (IOException eo) {
            throw new SystemException("Error on creating files");
        }

    }

    @Override
    public void closeDB() throws SystemException {

    }

}

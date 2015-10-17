/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xquery.model;

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
        return null;
    }

    @Override
    public String getElementsInCollection(String collectionName) throws SystemException {
        return null;
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void removeXML(String file) throws SystemException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addXMLToDb(String path) throws SystemException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void refreshDb() throws SystemException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String useDefaultDb() throws SystemException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}

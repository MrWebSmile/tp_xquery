/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.team.xquery_java;

import java.io.IOException;
import org.basex.api.client.ClientSession;
import org.basex.core.Context;
import org.basex.query.func.client.ClientQuery;

/**
 *
 * @author adrien
 */
public class Client {

    public static void main(String[] args) {
            Context ct = new Context();
           // BaseXClient bc = new BaseXClient("localhost", "user", "123");
            ClientQuery cq = new ClientQuery();
           
          try
          {
               ClientSession cs = new ClientSession(ct,"admin","admin");
          }
          catch(IOException ie)
          {
              System.out.println(ie.getMessage());
          }

       
    }
}

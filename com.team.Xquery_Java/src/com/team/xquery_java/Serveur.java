/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.team.xquery_java;

import java.io.IOException;
import org.basex.BaseXServer;

/**
 *
 * @author adrien
 */
public class Serveur {
    
        public static void main(String[] args) {
            BaseXServer bs =null;
       try
       {
           bs = new BaseXServer();
           bs.run();
            
       }
       catch(IOException ie)
       {
           System.out.println(ie.getMessage());
          
       }
    }
}

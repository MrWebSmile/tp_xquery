/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.team.xquery_java;

import java.io.IOException;
import org.basex.BaseXClient;

/**
 *
 * @author adrien
 */
public class Client {

    public static void main(String[] args) {
        
        try
        {
            BaseXClient bc = new BaseXClient();
        }
        catch(IOException ie)
        {
            
        }
    }

}

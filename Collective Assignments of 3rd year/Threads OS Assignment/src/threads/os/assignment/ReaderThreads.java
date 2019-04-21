/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threads.os.assignment;

import java.io.IOException;



/**
 *
 * @author Owner
 */
public class ReaderThreads implements Runnable {
    private String name;
    private String Data;
    Buffer b = new Buffer();
    ReaderThreads() {}
    @Override
    public void run()
    {                 
        b.Reading(name);        
    }
   
    public ReaderThreads(String named , String D)
    {
        name=named;
        Data = D;
    }   
    
}

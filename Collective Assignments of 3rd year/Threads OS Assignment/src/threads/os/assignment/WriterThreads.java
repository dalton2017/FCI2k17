/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threads.os.assignment;

public class WriterThreads implements Runnable{
    private String name;
    private String Data;
    Buffer b = new Buffer();
    
    WriterThreads(){}
    @Override
    public void run()
    {
        
        System.out.println(name + " is Writing : " + Data);
        Buffer b = new Buffer(Data);
        b.Writing(name, Data);        
        

    }
    public WriterThreads(String named , String D)
    {        
        name=named;
        Data=D;
    }
    
}

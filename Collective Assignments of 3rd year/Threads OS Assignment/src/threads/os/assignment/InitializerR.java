/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threads.os.assignment;

/**
 *
 * @author Owner
 */
public class InitializerR extends Thread{
    int Size;
    ReaderThreads [] Reader;
    public void setData(ReaderThreads [] w , int S)
    {
        Reader = w;
        Size = S;
    }

    public void run()
    {
        for(int i=0;i<Size;i++)
        {
            Reader[i].run();
        }
    }
    
    
    
}

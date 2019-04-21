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
public class InitializerW extends Thread{
   int Size;
   WriterThreads [] Writer;
    
   public void setData(WriterThreads [] w , int S)
   {
       Writer = w;
       Size = S;
   }
   @Override
   public void run()
   {
        for(int i=0;i<Size;i++)
        {
               Writer[i].run();
        }
   }
    
}

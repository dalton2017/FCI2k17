/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threads.os.assignment;

import static java.lang.Integer.max;
import java.util.Scanner;

/**
 *
 * @author Owner
 */
public class ThreadsOSAssignment {    
    
    public static void main(String[] args) throws InterruptedException {
        
        //Initialiing inputs :
        String Buffer;
        int NR;
        int NW;       
        Semaphore s = new Semaphore(2);
        Scanner in = new Scanner(System.in);     
        
        //Entering Data :
        System.out.println("Enter The initial Buffer Content : ");
        Buffer = in.nextLine();        
        System.out.println("Enter The number of Writers : ");
        NW = in.nextInt();
        System.out.println("Enter The number of Readers : ");
        NR = in.nextInt();
        
        Buffer b = new Buffer(Buffer);
        ReaderThreads [] Readers = new ReaderThreads[NR];
        WriterThreads [] Writers = new WriterThreads[NW];
        //System.out.println(NR + "-" + NW + "-" + Buffer);
        //Initializing The writers names and words:
        String name;
        String Data;
        for(int i=0;i<NW;i++)
        {   
            in = new Scanner(System.in);
            System.out.println("Enter The Writer " + (i+1) + " name :");
            name = in.nextLine();
            System.out.println("Enter The data the writer" + (i+1) + " would write :");
            Data = in.nextLine();
            Writers[i] = new WriterThreads(name,Data);            
        }
        //Initializing The readers names:
        for(int i=0;i<NR;i++)
        {  
            in = new Scanner(System.in);
            System.out.println("Enter The Reader " + (i+1) + " name :");
            name = in.nextLine();
            Readers[i] = new ReaderThreads(name,Buffer);            
        }
        //Initializing All Writer And Reader Threads :
        for(int i =0;i<7;i++)
        {
            System.out.println(" ");
        }
        System.out.println("Starting System....");
        System.out.println(" ");
        InitializerR i1 = new InitializerR();
        InitializerW i2 = new InitializerW();        
        
        i1.setData(Readers, NR);
        i2.setData(Writers, NW);
        
        i2.start();
        i1.start();
       
        
        
       
  
   }
}
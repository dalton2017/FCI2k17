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
public class  Semaphore {
    protected int value=0;
    protected Semaphore(){value = 1;}
    protected Semaphore(int initial){
        value = initial;
    }
    public synchronized void PW(String name) {
        value=1;
	value-- ;
        //System.out.println(value);
        if (value < 0)
        {
            System.out.println(name + " Blocked");
            try {
                wait();
            } catch (InterruptedException e) {}
        }
    }
    public synchronized void PR(String name) {
	//value-- ;
        //System.out.println(value);
        if (value < 0)
        {
            System.out.println(name + " Blocked");
            try {
                wait();
            } catch (InterruptedException e) {}
        }
    }
	  
    public synchronized void V() 
    {
	value++ ; 
        if (value >= 0)
        {
             notify() ;
        }
	
    }
    
    
}

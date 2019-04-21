package main;

public class Semaphore {
	
	 protected int value = 0;
	 protected Semaphore() 
	 {
		 value = 1 ;

	 }

	  protected Semaphore(int initial)
	  {
		  value = initial ; 
	
	  }

	  public synchronized void P(String name) 
	  {
		  value-- ;
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
		    if (value <= 0)
		    {
		    	notify() ;
		    }
	
	  }


	

}

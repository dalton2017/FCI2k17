/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package semaphore;

/**
 *
 * @author toshiba
 */
public class semaphore {

  protected int value = 0 ;

  protected semaphore() {
      value = 0 ; 
  }

  protected semaphore(int initial) { 
      value = initial ; 
  }

  public synchronized void P() {
	  
    value-- ;
    if (value < 0){
      try { 
          wait() ; 
          //System.out.println("Block");
      } catch(  InterruptedException e ) {
      }
    }
  }

  public synchronized void V() {
    value++ ; 
    if (value <= 0){
        //System.out.println("Notify");
        notify() ;
    }
  }
}

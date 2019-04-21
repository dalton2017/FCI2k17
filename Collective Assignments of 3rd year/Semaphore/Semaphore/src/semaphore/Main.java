/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package semaphore;

/**
 *
 * @author toshiba
 */
public class Main {
    
	static buffer buf = new buffer();

	public static void main(String[] args) {
		producer P = new producer(buf);
		consumer C = new consumer(buf);
		P.start();
		C.start();
	}

}

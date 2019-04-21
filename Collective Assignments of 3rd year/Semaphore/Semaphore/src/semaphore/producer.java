/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package semaphore;

class producer extends Thread {

	buffer buf;

	public producer(buffer buf) {
		this.buf = buf;
	}

	public void run() {
		for (int i = 1; i <= 10; i++)
			buf.produce(new Integer(i));
	}
}

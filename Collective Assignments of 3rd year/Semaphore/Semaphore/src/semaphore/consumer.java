/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package semaphore;


class consumer extends Thread {

	buffer buf;

	public consumer(buffer buf) {
		this.buf = buf;
	}

	public void run() {
		for (int i = 1; i <= 10; i++)
			System.out.println(buf.consume());
	}

}


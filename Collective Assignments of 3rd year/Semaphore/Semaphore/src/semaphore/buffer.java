/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package semaphore;

class buffer {

	private int size = 5;  // the buffer bound

	private Object store[] = new Object[size];
	private int inptr = 0;
	private int outptr = 0;

	semaphore spaces = new semaphore(size);
	semaphore elements = new semaphore(0);

	public void produce(Object value) {
            //System.out.println("Produce");
		spaces.P();
		store[inptr] = value;
		inptr = (inptr + 1) % size;
		elements.V();
	}

	public Object consume() {
            //System.out.println("Consume");
		Object value;
		elements.P();
		value = store[outptr];
		outptr = (outptr + 1) % size;
		spaces.V();
		return value;
	}
}

package main;

public class Write extends Thread 
{
	
	private String name;
	private Buffer buf;
	private String word;
	public Write()
	{
		buf = new Buffer();
	}
	public Write(String n,Buffer b,	String w)
	{
		name = n;
		buf = b;
		word = w;
	}
	public void run()
	{
	    System.out.println(name+" Start writeing");
		 buf.write(word,name);
		
	}

}
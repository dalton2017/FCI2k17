package main;
import java.util.Scanner;

public class main 
{
	
	public static void main(String []args)
	{
		String buffer ="";
		int THwrite_size = 0;
		int THread_size = 0;
		Scanner scan = new Scanner(System.in);

		System.out.print("Enter Buffer content: ");
		buffer = scan.nextLine();
		
		Buffer buf = new Buffer(buffer);
		
		
		System.out.println("\nNumber of reader threads : ");
		scan = new Scanner(System.in);
		THread_size = scan.nextInt();
		
		System.out.println("\nNumber of Write threads : ");
		THwrite_size = scan.nextInt();
		
		
		
		Write [] writes = new Write[THwrite_size];
		Read  [] reads = new Read[THread_size];
		
		for(int i = 0; i<THread_size ; i++)
		{
			scan = new Scanner(System.in);
			System.out.print("\nEnter Thread read "+(i+1) + " name : ");
			reads[i] = new Read(scan.nextLine(),buf);
			
		}
		for(int i = 0; i<THwrite_size ; i++)
		{
			scan = new Scanner(System.in);
			System.out.print("\nEnter Thread write "+(i+1) + " name and word : ");
			writes[i] = new Write(scan.nextLine(),buf,scan.nextLine());
			
		}
		
		for(int i = 0; i<THread_size ; i++)
		{
			reads[i].start();
			
		}
		for(int i = 0; i<THwrite_size ; i++)
		{
			writes[i].start();	
		}
		
		System.out.println("\n"+buf.str+"...iam here...");		
	}

}
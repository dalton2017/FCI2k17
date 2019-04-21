import java.io.*;
import java.io.FileNotFoundException;
import java.lang.*;
import java.util.*;

public class Files {
    private Formatter x;
    public void openFile()
    {
        try
        {
            x = new Formatter("Result.txt");           
        }
        catch(FileNotFoundException e)
        {
            System.out.println("No file Created !");
        }
    }
    public void addRecord(String data) throws FileNotFoundException
    {
        PrintWriter out = new PrintWriter("Result.txt");
        out.println(data);
    }
   
}

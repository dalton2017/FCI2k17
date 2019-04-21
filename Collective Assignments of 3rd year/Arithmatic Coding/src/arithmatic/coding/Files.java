package arithmatic.coding;


import java.io.*;
import java.io.FileNotFoundException;
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
    public void addRecord(String data) throws FileNotFoundException, IOException
    {
        FileWriter out = new FileWriter("Result.txt");
        BufferedWriter bw = new BufferedWriter(out);        
        bw.write(data); 
        bw.close();
    }
    public String RetrieveData() throws FileNotFoundException, IOException
    {
        String Data;
        FileReader in = new FileReader("Result.txt");
        BufferedReader br = new BufferedReader(in);
        Data = br.readLine();
        br.close();
        return Data;        
    }
   
}


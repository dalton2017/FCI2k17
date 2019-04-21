package os.assiugnment.pkg3;


import java.io.*;
import java.io.FileNotFoundException;
import java.util.*;

public class Files {
    private Formatter x;
    public void openFile(String filename)
    {
        try
        {
            x = new Formatter(filename);           
        }
        catch(FileNotFoundException e)
        {
            System.out.println("No file Created !");
        }
    }
    public void addRecord(String data,String filename) throws FileNotFoundException, IOException
    {
        FileWriter out = new FileWriter(filename);
        BufferedWriter bw = new BufferedWriter(out);        
        bw.write(data); 
        bw.close();
    }
    public String RetrieveData(String filename) throws FileNotFoundException, IOException
    {
        String Data;
        FileReader in = new FileReader(filename);
        BufferedReader br = new BufferedReader(in);
        Data = br.readLine();
        br.close();
        return Data;        
    }
   
}


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scalar.quantization;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Formatter;

/**
 *
 * @author Owner
 */
public class Files {

    private String fp;
    Files(){}    
    Files(String filePath) {
        fp = filePath;
    }
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

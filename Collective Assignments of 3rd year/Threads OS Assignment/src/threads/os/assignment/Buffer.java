/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threads.os.assignment;

/**
 *
 * @author Owner
 */
public class Buffer {
    protected static  String Data ="";
    Semaphore s = new Semaphore();
    public Buffer()
    {
        s = new Semaphore();
    }
    public Buffer(String d)
    {
        Data = d;
    }
    public String GetData()
    {
        return Data;
    }
    public void Writing (String TName , String TWord)
    {
        s.PW(TName);
        Data = TWord;
        //System.out.println(Data);
        s.V();
        System.out.println(TName + " Finished Writing !");
    }
    public void Reading (String TName)
    {
        s.PR(TName);
        System.out.println(TName + " is Reading : " + GetData());
        //s.V();
        System.out.println(TName + " Finished Reading !");
    }
    
}

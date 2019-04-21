/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package os.assiugnment.pkg3;


public class Queues {
    private String name;
    private int priority;
    private String algorithm;
    private int quantum;
    private int pnum;
    public Processes [] PLIST = new Processes[pnum];
    
    public void setName(String n)
    {
        name = n;
    }
    public void setPriority(int p)
    {
        priority = p;
    }
    public void setAlgorithem(String a)
    {
        algorithm = a;
    }
    public void setQuantum(int q)
    {
        quantum = q;
    }
    public void setProcessesNumber(int pn)
    {
        pnum = pn;
    }
    public void setProcessList(Processes [] l)
    {
        PLIST = l;
    }
    public String getName()
    {
        return name;
    }
    public int getPriority()
    {
        return priority;
    }
    public String getAlgorithm()
    {
        return algorithm;
    }
    public int getQuantum()
    {
        return quantum;
    }
    public int getProcessesNumber()
    {
        return pnum;
    }
    public Processes [] getProcessList()
    {
        return PLIST;
    }
}

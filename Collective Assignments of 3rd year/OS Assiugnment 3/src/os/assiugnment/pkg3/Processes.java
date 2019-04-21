/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package os.assiugnment.pkg3;

public class Processes implements Comparable<Processes>{
    private String name;
    private int AT;
    private int burstTime;
    private int ST;
    private int TAT;
    private String algorithm;
    private int priority;
    private int quantum;
    
    public void setName(String n)
    {
        name = n;
    }
    public void setTAT(int tat)
    {
        TAT=tat;
    }
    public void setST(int st)
    {
        ST = st;
    }
    public void setAT(int at)
    {
        AT = at;
    }
    
    public void setBurstTime(int bt)
    {
        burstTime = bt;
    }
    public void setAlgorithem(String a)
    {
        algorithm = a;
    }
    public void setPriority(int p)
    {
        priority = p;
    }
    public void setQuantum(int q)
    {
        quantum = q;
    }
    public String getName()
    {
        return name;
    }
    
    public int getAT()
    {
        return AT;
    }
    
    public int getBurstTime()
    {
        return burstTime;
    }
    public int getPriority()
    {
        return priority;
    }
    public int getQuantum()
    {
        return quantum;
    }
    public String getAlgorithm()
    {
        return algorithm;
    }
    public int getTAT()
    {
       return TAT; 
    }
    public int getST()
    {
        return ST;
    }            
    @Override
    public int compareTo(Processes o) {
        if (this.AT == ((Processes) o).AT)
        {            
          if(this.priority==((Processes) o).priority)
              return 0;
          else if(this.priority>((Processes) o).priority)
              return 1;
          else
              return -1;
        }           
        else if ((this.AT) > ((Processes) o).AT)
            return 1;
        else
            return -1;
    }    
}

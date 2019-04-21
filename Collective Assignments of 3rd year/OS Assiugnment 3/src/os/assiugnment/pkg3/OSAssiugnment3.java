/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package os.assiugnment.pkg3;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Owner
 */
public class OSAssiugnment3 {
    static int quantum = 0;
    static String PName="";
    public static void main(String[] args) throws IOException { 
        Queues z = new Queues();
        Processes p = new Processes();
        Scanner in = new Scanner(System.in);
        int QueuesNumber;
        int ProcessesNumber;
        //**********************************************************************
        System.out.println("Enter the number of Queues : ");
        QueuesNumber = in.nextInt();
        int choice;
        String name;
        int AT;
        int BT;
        Queues [] QueuesList = new Queues[QueuesNumber];
        for(int i=0;i<QueuesNumber;i++)
        {
            Queues q = new Queues();
            q.setName("Q" + (i+1));
            System.out.println("Select " + q.getName() + " Algorithm : ");           
            System.out.println("1) FCFS  2) SJF  3) RR");
            choice = in.nextInt();
            switch(choice)
            {
                case 1:
                    q.setAlgorithem("FCFS");
                    break;
                case 2:
                    q.setAlgorithem("SJF");
                    break;
                case 3:
                    q.setAlgorithem("RR");
                    System.out.println("Enter Quantum : ");
                    q.setQuantum(in.nextInt());
                    quantum = q.getQuantum();
                    break;
                default:
                    i = i-1;
                    System.out.println("Worng Choice! ReEnter the Queue Algorithm!");
                    break;
            } 
            System.out.println("Enter the Queue Priority (1 for max priority, 2 for mid priority, or 3 for min priority): ");
            q.setPriority(in.nextInt());
            System.out.println("Enter the number of processes in the Queue : ");
            ProcessesNumber = in.nextInt();
            q.setProcessesNumber(ProcessesNumber);
            Processes [] ProcessesList = new Processes[ProcessesNumber];
            System.out.println("***************************");
            System.out.println("Creating Processes ...... !");
            System.out.println("***************************");
            for(int y=0;y<ProcessesNumber;y++)
            {
                System.out.println("Process " + (y+1) + " Data ...");
                Processes r = new Processes();
                System.out.println("Enter the process name: ");
                name = in.next();
                r.setName(name);
                System.out.println("Enter the process AT: ");
                AT = in.nextInt();
                r.setAT(AT);
                System.out.println("Enter the process BurstTime: ");
                BT = in.nextInt();
                r.setBurstTime(BT);
                r.setAlgorithem(q.getAlgorithm());
                r.setPriority(q.getPriority());
                if(q.getQuantum()>0)
                {
                    r.setQuantum(q.getQuantum());
                }
                ProcessesList[y] = r;
            }
            q.setProcessList(ProcessesList);
            QueuesList[i]=q; 
            System.out.println(q.getName() + " Creation is done !");
        }
        
        //Data Check************************************************************
        
        /*for(int i=0;i<QueuesNumber;i++)
        {
        System.out.println("*******************");
        System.out.println("Queue"+(i+1)+" Data");
        System.out.println("*******************");
        Processes [] ProcessesList = QueuesList[i].getProcessList();
        System.out.println("Name: " + QueuesList[i].getName());
        System.out.println("Priority: " + QueuesList[i].getPriority());
        System.out.println("Algorithm: " + QueuesList[i].getAlgorithm());
        System.out.println("Quantum: " + QueuesList[i].getQuantum());
        System.out.println("PNum: " + QueuesList[i].getProcessesNumber());
        System.out.println("Process List----->>>>> ");
        for(int y=0;y<QueuesList[i].getProcessesNumber();y++)
        {
        System.out.println("*******************");
        System.out.println("Process Name: "+ProcessesList[y].getName());
        System.out.println("Process AT: "+ProcessesList[y].getAT());
        System.out.println("Process BT: "+ProcessesList[y].getBurstTime());
        System.out.println("*******************");
        }
        }*/
        int AllProcessesNumber=0;
        for(int i=0;i<QueuesNumber;i++)
        {
            AllProcessesNumber += QueuesList[i].getProcessesNumber();
        }
        Processes [] AllProcessesList = new Processes[AllProcessesNumber];
        Processes [] SelectedProcessesList;
        int Next=0;
        for(int i=0;i<QueuesNumber;i++)
        {
            SelectedProcessesList = QueuesList[i].getProcessList();
            for(int y=0;y<QueuesList[i].getProcessesNumber();y++)
            {                
                    AllProcessesList[Next]=SelectedProcessesList[y];
                    Next++;
            }            
        }      
        Arrays.sort(AllProcessesList);
        for(int i=0;i<AllProcessesNumber;i++)
        {
            AllProcessesList[i].setTAT(-AllProcessesList[i].getBurstTime());
        }
        /*for(int i=0;i<AllProcessesNumber;i++)
        {
        System.out.println("All Processes AT------>>>>>>>");
        System.out.println(AllProcessesList[i].getName()+ " >>>>>>> " +AllProcessesList[i].getAT());
        }*/
        int time=0;
        int add=0;
        int size=0;
        int bool = 0;
        int bool2 =0;
        String ExcutionOrder = "0;";
        Processes [] Queue = new Processes[AllProcessesNumber];
        AllProcessesList[0].setST(0);
        int itr =1;
        while(true)
        {          
          for(int i=0;i<AllProcessesNumber;i++)
          {
              if(bool==1)
              {
                if(AllProcessesList[i].getAT()==(time-1))
                {
                    Queue[add] = AllProcessesList[i];
                    size++;
                    add++;                  
                }                
                bool=0;
              }else
              {
                if(AllProcessesList[i].getAT()==(time))
                {
                    Queue[add] = AllProcessesList[i];
                    size++;
                    add++;                  
                }
              }      
          }
          //Queue Checker*******************************************************
          System.out.println("Itertion num "+itr+" :");
          itr ++;
          for(int b=0;b<add;b++)
          {              
              System.out.println(Queue[b].getName());
          }
          //********************************************************************
          if(null != Queue[0].getAlgorithm())
            switch (Queue[0].getAlgorithm()) {
                case "SJF":
                    time = SJF(Queue[0],time);
                    break;
                case "FCFS":
                    time = FCFS(Queue[0],time);
                    break;
                case "RR":
                    if(Queue[0].getQuantum()==0)
                    {
                        /*if(Queue.length==1)
                        {
                        
                        }else
                        {
                        bool2 = 1;
                        Prioritysort(Queue);
                        }*/                        
                        Processes temp = Queue[0];
                        ExcutionOrder+= Queue[0].getName() + ";" + (time-1) + "-";
                        //
                        for(int v=0;v<add;v++)
                        {
                            if((v+1)==add)
                            {
                                Queue[v]=temp;                                    
                            }else
                            {
                                Queue[v]=Queue[v+1];                      
                            }                            
                        }
                        ExcutionOrder+=time + ";";
                        time++;
                    }
                    time = RR(Queue[0],time);                    
                    break;
                default:
                    break;
            }else
          {
              System.out.println("ERROR !!!");
          }
          /*if(Queue.length<=1)
          {
          System.out.println("No elements in the queue !");
          }else
          {
          if(bool2==0)
          {
          Prioritysort(Queue);
          bool2 = 0;
          }else
          {
          bool2 = 0;
          }
          }*/
        
        if(Queue[0].getBurstTime()==0)
        {
            ExcutionOrder+= Queue[0].getName() + ";" + (time-1) + "-";
            Queue[0].setTAT(+(time - Queue[0].getST()));
            for(int v=0;v<add;v++)
            {
                if((v+1)==add)
                {
                    Queue[v]=null;
                    add--;
                }else
                {
                    Queue[v]=Queue[v+1];                      
                } 
            }
                ExcutionOrder+= time + ";";
                time++;  
                bool=1;
        }                          
         if(Queue[0]==null&&size==AllProcessesNumber)
         {
               break;
         }
        }
        //Calculating Data******************************************************
        System.out.println("Calculated Data ------>>>>>>>>>>");
        Files f = new Files();
        f.openFile("Results1.txt");
        int TotalTurnAroundTime = 0;
        System.out.println("The Exctution Order is : " + ExcutionOrder);
        f.addRecord("The Exctution Order is : " + ExcutionOrder,"Results1.txt");
        for(int i=0;i<AllProcessesNumber;i++)
        {
            System.out.println("TurnAround time for "+AllProcessesList[i].getName()+" is: "+AllProcessesList[i].getTAT());
            f.openFile("Results2.txt");
            f.addRecord("TurnAround time for "+AllProcessesList[i].getName()+" is: "+AllProcessesList[i].getTAT(),"Results2.txt");
            TotalTurnAroundTime+=AllProcessesList[i].getTAT();
        }
        System.out.println("Average Turn Around Time is: " + (TotalTurnAroundTime/2));
        f.openFile("Results3.txt");
        f.addRecord("Average Turn Around Time is: " + (TotalTurnAroundTime/2),"Results3.txt");       
    }
    
    public static  Processes [] Prioritysort(Processes Queue [])
    {
        Processes temp;
        for(int i=0;i<Queue.length;i++)
        {
            for(int y=0;y<Queue.length;y++)
            {
                if(Queue[y].getPriority()>Queue[y+1].getPriority())
                {
                    temp = Queue[y];
                    Queue[y] = Queue[y+1];
                    Queue[y] = temp;
                }else
                {
                    
                }
            }
        }        
        return Queue;
    }
    
    public static int RR(Processes p,int time)
    {
        if(p.getQuantum()==0)
        {
            p.setQuantum(quantum);
        }
        if(PName.equals(p.getName()))
        {
            time++;
            p.setBurstTime(p.getBurstTime()-1); 
            p.setQuantum(p.getQuantum()-1);
        }else
        {
            PName = p.getName();
            time++;
            p.setBurstTime(p.getBurstTime()-1);
            p.setQuantum(p.getQuantum()-1);
        }        
        return time;     
    }
    public static int FCFS(Processes p,int time)
    {
        time++;
        p.setBurstTime(p.getBurstTime()-1);
        return time;
    }
    public static int SJF(Processes p,int time)
    {
        time++;
        p.setBurstTime(p.getBurstTime()-1);
        return time;
    }
}

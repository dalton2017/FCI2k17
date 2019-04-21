
package assignmentmultimedia.pkg2ndtry;
import java.util.*;

public class AssignmentMultimedia2ndTry {

  
    public static void main(String[] args) {
        //Input variables :
        String data ;
        char x;
        int check;
        Scanner cin = new Scanner(System.in);
        char encodedData [][];
        char originalData[];
        String SearchBuffer[];
        originalData = new char[1000];
        encodedData = new char[20][3];
        //*********************************************************
        System.out.println("Enter Your Data");
        data = cin.nextLine();
        for(int i=0;i<data.length();i++)
        {
            x = data.charAt(i);
            originalData[i] = x;
        }
        //*********************************************************
        //Algorithem :
        String find="";
        String search="";
        int z=0;
        int position=0;
        String current="";
        for(int i=0;i < data.length();i++)
        {
            find += originalData[i];
            position=i+1;
            for(int v=0;v<i;v++)
            {
                search+=originalData[v];
            }
            System.out.println(search);
            if(search.length()-find.length()<0)
            {
                encodedData[z][0]= (char)0;
                encodedData[z][1]= (char)0;
                encodedData[z][2]= originalData[i]; 
                z++;
            }
            int index;
            int currentindex=0;
            for(int c=0;c<=(search.length()-find.length());c++)
            {
                index = search.indexOf(find);
                if(index != -1)
                {
                    i++;
                    c=0;
                    if(originalData[i]==(char)0)
                    {
                        encodedData[z][0]= (char)(position-currentindex);
                        encodedData[z][1]= (char)(find.length()-1);
                        encodedData[z][2]= originalData[i-1];
                        break;
                    }
                    currentindex=index+1;
                    find+=originalData[i];
                    search+=originalData[i-1];
                }
                if(index == -1)
                {
                    if(currentindex==0)
                    {
                        encodedData[z][0]= (char)(currentindex);
                        encodedData[z][1]= (char)(find.length()-1);
                        encodedData[z][2]= originalData[i];
                        z++;
                        break;
                    }else
                    {
                        encodedData[z][0]= (char)(position-currentindex);
                        encodedData[z][1]= (char)(find.length()-1);
                        encodedData[z][2]= originalData[i];
                        z++;
                        break;
                    }
                    
                   
                    
                }
            }            
            find ="";
            search="";
            
        }
        for(int o=0;o<20;o++)
        {
            System.out.print((int)encodedData[o][0] + "-");
            System.out.print((int)encodedData[o][1] + "-");
            System.out.println(encodedData[o][2]);
        }
        
        //*************************************************
        //Decompress Algorithem
        char DResult[];
        DResult = new char [1000];
        int CPointer=0;
        for(int r=0;r<20;r++)
        {
            for(int p=0;p<r;p++)
            {
                search+=originalData[p];
            }
            if(encodedData[r][0]!=0)
            {
                int OPointer = CPointer-(int)encodedData[r][0];
                for(int j = 0;j < (int)encodedData[r][1];j++)
                {
                    DResult[CPointer]=DResult[OPointer];
                    OPointer++;
                    CPointer++;
                }
                DResult[CPointer]=encodedData[r][2];              
                CPointer++;
            }else
            {
                DResult[CPointer]=encodedData[r][2];              
                CPointer++;
            }
        }
        for(int l=0;l<1000;l++)
        {
            System.out.print(DResult[l]); 
        }
          
    }
    
}

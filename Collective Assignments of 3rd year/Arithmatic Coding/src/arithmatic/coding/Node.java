/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arithmatic.coding;

public class Node {
    private float Upper;
    private float Lower;
    private float Probability;
    char Letter;
    static int D [][] = new int [94][2];
    int length =0;
    Node(){}    
    public void setUpper(float u)
    {
        Upper = u;
    }
    public void setLower(float l)
    {
        Lower = l;
    }
    public void setProbability(float p)
    {
        Probability = p;
    }
    public void setLetter(char c)
    {
        Letter = c;
    }
    public float getUpper()
    {
       return Upper; 
    }
    public float getLower()
    {
       return Lower; 
    }
    public float getProbability()
    {
       return Probability; 
    }
    public char getLetter()
    {
       return Letter; 
    }
    public void PrintNode()
    {
        System.out.println(Letter + " - " + Lower + " - " + Upper + " - " + Probability);
    }   
    public void StoreData(int [][] Data)
    {
        D = Data;
    }
    public int[][] RetriveData()
    {        
        return D;
    }
    public void setLength(int l)
    {
        length = l;
    }
    public int getLength()
    {
        return length;
    }          
            
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment.multimedia.pkg3;

public class Node implements Comparable<Node>{
    public Node left , right , parent;
    public String letters="";    
    public String code="";
    public int frequency;
    Node(){}
    Node(char Let , int freq)
    {       
        letters += Let;
        frequency = freq;
    }
    
    public Node MergeNode(Node l , Node r)
    {
        Node s = new Node();
        s.left = l;
        s.right = r;
        s.letters += l.letters+r.letters;
        s.frequency = l.frequency + r.frequency;
        return s;        
    }
    public void BuildingTree()
    {
        
    }
    public void DataPrinter(Node Data)
    {
        System.out.println(Data.code + "-" + Data.letters + "-" + Data.frequency);
    }

    @Override
    public int compareTo(Node o) {
        return frequency-o.frequency;
    }

    
}

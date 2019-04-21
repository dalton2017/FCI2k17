/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huffman;

import java.util.HashMap;
import java.util.PriorityQueue;

/**
 *
 * @author BeshBeshy
 */
public class Node implements Comparable<Node>{
    
    private Node left , right;
    private String letters="";    
    private String code="";
    private int frequency;
    Node() {}
    public static HashMap<Character,String> CResultDictionary=new HashMap<>();
    public static HashMap<String,Character> DResultDictionary=new HashMap<>();
    public String right1 = "1";  //1 for left checker
    public String left1 = "0";  
    public String right2 = "1";  //2 for right checker
    public String left2 = "0";

    Node(char c, int i) {
        letters += c;
        frequency = i;
    }
    public Node MergeNode(Node l , Node r)
    {
        Node s = new Node();
        s.left = l;
        s.right = r;
        s.letters += l.letters+r.letters;
        s.frequency = l.frequency + r.frequency;
        //System.out.println("????");
        return s; 
        
    }

    @Override
    public int compareTo(Node o) {
        return frequency-o.frequency;
    }
    public void settingNodes(PriorityQueue<Node> TreeB)
    {
        Node root = new Node();        
        if(TreeB.element()==null)
        {
            System.out.println("The TreeB is Empty");
        }
        root.left = TreeB.poll();
        root.right = TreeB.poll();        
        root.left.code+="0";
        root.right.code+="1";
        if(root.left == null||root.right == null)
        {
            System.out.println("No Tree");
        }else       
        {
            NodeChecker(root.left);
            NodeChecker(root.right);
        }
    }
    public void NodeChecker(Node Current)
    {
        if(Current.right==null&&Current.left==null)
        {  
           CResultDictionary.put(Current.letters.charAt(0), Current.code);
           DResultDictionary.put(Current.code,Current.letters.charAt(0));             
        }else if(Current.left==null)
        {
            Current.right.code+=Current.code + "1";
            Current = Current.right;
            NodeChecker(Current);
        }else if(Current.right==null)
        {
            Current.left.code+=Current.code + "0";
            Current = Current.left;
            NodeChecker(Current);
        }else
        {
            Node temp = new Node();
            Current.right.code+=Current.code + "1";
            temp = Current.right;
            NodeChecker(temp);
            Current.left.code+=Current.code + "0";
            temp = Current.left;
            NodeChecker(temp);
        }
    }
    /*public void CheckerRightSide(Node Current)
    {
        if(Current.right==null&&Current.left==null)
        {  
            CResultDictionary.put(Current.letters.charAt(0), Current.code);
            DResultDictionary.put(Current.code,Current.letters.charAt(0));             
        } 
        else if(Current.left==null)
        {
            Current.right.code+=Current.code + "1";
            Current = Current.right;
            CheckerRightSide(Current);
        }else if(Current.right==null)
        {
            Current.left.code+=Current.code + "0";
            Current = Current.left;
            CheckerLeftSide(Current);
        }else
        {
            
        }
    }*/
    public void NodePrinter(Node n)
    {
        System.out.println(n.letters + "-----" + n.frequency);
    }
    public String DataPrinter()
    {
        return(CResultDictionary.toString());
    }
    public HashMap<Character,String> CDictionarySetter(HashMap<Character,String> C)
    {
        C = CResultDictionary;  
        return C;
    }
    public HashMap<String,Character> DDictionarySetter(HashMap<String,Character> D)
    {
        D = DResultDictionary;
        return D;
    }
    
}

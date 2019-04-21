package scalar.quantization;

public class Node {
    ImageRW r = new ImageRW();
    private int [][] pixels = new int [r.getHeight()+1][r.getWidth()+1];
    private int avg;
    private Node right;
    private Node left;
    private int height;
    private int width;
    Node(){}
    
    public void setPixels(int [][] P)
    {
        pixels = P;
    }
    public void setAVG(int a)
    {
        avg = a;
    }
    public void setRight(Node r)
    {
        right = r;
    }
    public void setLeft(Node l)
    {
        left = l;
    }
    public void setWidth(int w)
    {
        width = w;
    }
    public void setHeight(int h)
    {
        height = h;
    }
    public int [][] getPixels()
    {
        return pixels;
    }
    public int getAVG()
    {
        return avg;
    }
    public Node getLeft()
    {
        return left;
    }
    public Node getRight()
    {
        return right;
    }
    public int getWidth()
    {
        return width;
    }
    public int getHeight()
    {
        return height;
    }
    
}
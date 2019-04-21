/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scalar.quantization;

import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.io.File;
/**
 *
 * @author Owner
 */
public class ImageRW {
    
    private static int Width;
    private static int Height;
    ImageRW(){}
    
    public void setWidth(int w)
    {
        Width = w;
    }
    public void setHeight(int h)
    {
        Height = h;
    }
    public int getWidth()
    {
        return Width;
    }
    public int getHeight()
    {
        return Height;
    }

public static int[][] readImage(String filePath)
{
    int width;
    int height;
    File directory=new File(filePath);
    BufferedImage image = null;

    try
    {
            image=ImageIO.read(directory);
    }
    catch (IOException e)
    {
        e.printStackTrace();
    }

    width=image.getWidth();
    height=image.getHeight();
    Width = width;
    Height =height;
    int[][] pixels=new int[height][width];
    
    for(int x=0;x<width;x++)
    {
        for(int y=0;y<height;y++)
        {
            int rgb=image.getRGB(x, y);
            int alpha=(rgb >> 24) & 0xff;
            int r = (rgb >> 16) & 0xff;
            int g = (rgb >> 8) & 0xff;
            int b = (rgb >> 0) & 0xff;

            pixels[y][x]=r;
        }
    }

    return pixels;
}
public static void writeImage(int[][] pixels,String outputFilePath,int width,int height)
{
    File fileout=new File(outputFilePath);
    BufferedImage image2=new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB );

    for(int x=0;x<width ;x++)
    {
        for(int y=0;y<height;y++)
        {
           image2.setRGB(x,y,(pixels[y][x]<<16)|(pixels[y][x]<<8)|(pixels[y][x]));
        }
    }
    try
    {
        ImageIO.write(image2, "jpg", fileout);
    }
    catch (IOException e)
    {
        e.printStackTrace();
    }
} 

}

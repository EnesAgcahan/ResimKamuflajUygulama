package kamufle;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JPanel;


public class ResimYukle extends JPanel{
    BufferedImage image;
    boolean resimYukluMu,degistiMi = false;
    int Blue,Green,Red;
    
    public void resimYukle(){
        try {
                image = ImageIO.read(new File("res/car.jpg"));
                resimYukluMu = true;
                Color ctemp;
                ctemp = new Color(image.getRGB(0, 0));
                Blue = ctemp.getBlue();
                Green = ctemp.getGreen();
                Red = ctemp.getRed();
        } catch (IOException ex) {
            Logger.getLogger(ResimYukle.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void temizle(){
       Color c1,c2,c3;
       int maxX = image.getWidth();
       int maxY = image.getHeight();
       
        for (int i = 0; i < maxX; i++) {
            for (int j = 0; j < maxY - 1 ; j++) {
                c1 = new Color(image.getRGB(i, j));
                c2 = new Color(image.getRGB(i, j + 1));               
                if (!degistiMi) {
                    if ((Math.abs(c1.getBlue() - c2.getBlue()) > 25 || Math.abs(c1.getRed()- c2.getRed()) > 25 || Math.abs(c1.getGreen()- c2.getGreen()) > 25) && (Math.abs(Blue - c2.getBlue()) > 27 || Math.abs(Red - c2.getRed()) > 27 || Math.abs(Green - c2.getGreen()) > 27)) {               
                        c3 = new Color(Red, Green, Blue);
                        image.setRGB(i, j + 1, c3.getRGB());
                    }
                }
                    
                
            }
        }
    }
    @Override
    public void paint(Graphics g){
        if (resimYukluMu) {
            super.paint(g);
            g.drawImage(image, 0, 0, null);
        }    
    }
}

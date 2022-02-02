
package kamufle;

import javax.swing.JFrame;

public class Kamufle {

    public static void main(String[] args) {
        ResimYukle r = new ResimYukle();
       
        r.resimYukle();
        r.temizle();
        JFrame frame = new JFrame();
        frame.add(r);
        frame.setSize(1250,1250);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
    
}

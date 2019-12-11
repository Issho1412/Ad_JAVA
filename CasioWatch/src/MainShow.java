import javax.swing.*;
import java.awt.*;

public class MainShow {

    public static  JFrame frame = new JFrame("Casio");
    public static void main(String[] args) {
        CasioWatch casioWatch = new CasioWatch();
        casioWatch.InitImage();
        casioWatch.resolveTime();
       // JFrame frame = new JFrame("Casio");
        initFrame(frame);
        frame.setContentPane(casioWatch.getRootPanel());

    }

    public static void initFrame(JFrame frame){
        frame.setPreferredSize(new Dimension(310, 370));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public static void closeFrame(JFrame frame1){
        if(frame1.getTitle().equals("StopFrame")){
            frame.dispose();
        }

    }
}

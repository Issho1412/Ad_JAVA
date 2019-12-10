import javax.swing.*;
import java.awt.*;

public class MainShow {
    public static void main(String[] args) {
        CasioWatch casioWatch = new CasioWatch();
        casioWatch.InitImage();
        casioWatch.resolveTime();
        JFrame frame = new JFrame("Casio");
        frame.setPreferredSize(new Dimension(300, 400));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setContentPane(casioWatch.getRootPanel());
        frame.pack();
        frame.setVisible(true);
    }
}

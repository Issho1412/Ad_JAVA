package casioCal;

import javax.swing.*;
import java.awt.*;

public class mainCal {
    public static void main(String[] args) {

        CasioCal cas = new CasioCal();
        cas.initComponent();

        JFrame frame = new JFrame("Casio");
        frame.setPreferredSize(new Dimension(300, 300));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        frame.setContentPane(cas.getRootPanel());
       // frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}

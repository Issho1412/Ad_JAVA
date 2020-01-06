import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class frmMenu extends JFrame implements IInitJFrame{
    private JPanel rootMenu;
    private JPanel panelHeader;
    private JPanel panelLeft;
    private JPanel panelRight;
    private JPanel panelMain;
    private JPanel panelFooter;
    private JButton btnCEnglish;
    private JButton COMINGSOONButton;
    private JButton btnMath;
    private JButton btnCWeb;

    public frmMenu() {
        initJFrame();
        btnCEnglish.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        btnCWeb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

    public JPanel getRootMenu() {
        return rootMenu;
    }

    @Override
    public void initJFrame() {
        setTitle("ScreenPlay");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(500, 500));
        setVisible(true);
        setContentPane(getRootMenu());
        pack();
    }
}

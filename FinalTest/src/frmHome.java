import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class frmHome extends JFrame implements IInitJFrame {
    private JPanel rootPanel;
    private JPanel panelHeader;
    private JPanel panelMain;
    private JPanel panelFooter;
    private JPanel panelRight;
    private JPanel panelLeft;
    private JPanel panelTitle;
    private JPanel panelButton;
    private JPanel panelChoose;
    private JButton btnStart;
    private JButton btnExit;
    private JButton btnHelp;


    public frmHome() {
        initJFrame();
        btnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new frmGPlay().setVisible(true);
            }
        });
        btnHelp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new frmGuide().setVisible(true);
            }
        });
    }

    public JPanel getRootPanel() {
        return rootPanel;
    }

    @Override
    public void initJFrame() {
        setTitle("Home");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(500, 500));
        setContentPane(getRootPanel());
        setVisible(true);
        pack();
    }
}

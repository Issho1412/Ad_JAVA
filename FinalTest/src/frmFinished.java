import model.Game;

import javax.swing.*;
import java.awt.*;

public class frmFinished extends JFrame implements IInitJFrame{
    private JPanel rootPanel;
    private JPanel panelHeader;
    private JPanel panelLeft;
    private JPanel panelBottom;
    private JPanel panelRight;
    private JPanel panelMain;
    private JLabel labelScore;
    private JLabel labelHeader;
    private JLabel labelLeft;
    private JLabel labelBottom;

    public frmFinished(int Score){
        initJFrame();
        initImage();
        labelScore.setText(Score+"");
    }

    public JPanel getRootPanel() {
        return rootPanel;
    }

    public void initImage(){
        ImageIcon imageLogo = new ImageIcon(new ImageIcon("C:\\Users\\huyhu\\IdeaProjects\\FinalTest\\img\\giphy.png").getImage().getScaledInstance(500, 150, Image.SCALE_SMOOTH));
        labelHeader.setIcon(imageLogo);
        ImageIcon imageBottom = new ImageIcon(new ImageIcon("C:\\Users\\huyhu\\IdeaProjects\\FinalTest\\img\\giphy.png").getImage().getScaledInstance(500, 150, Image.SCALE_SMOOTH));
        labelBottom.setIcon(imageBottom);
    }
    @Override
    public void initJFrame() {
        setTitle("ScreenFinished");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(500, 500));
        setVisible(true);
        setContentPane(getRootPanel());
        pack();
    }
}

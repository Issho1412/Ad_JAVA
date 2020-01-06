import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class frmGuide extends JFrame implements IInitJFrame{
    private JPanel rootPanel;
    private JPanel panelHeader;
    private JPanel panelLeft;
    private JPanel panelBottom;
    private JPanel panelRight;
    private JPanel panelMain;
    private JLabel labelLogo;
    private JLabel labelDetailTxt;
    private JButton btnBack;


    public frmGuide(){
        initJFrame();
        initImage();
        labelDetailTxt.setText("<html>" +
                "1. Read the entire question.<br>" +
                "2. Answer it in your mind first.<br>" +
                "3. Eliminate wrong answers.<br>" +
                "4. Use the process of elimination.<br>" +
                "5. Select the best answer.<br>" +
                "6. Read every answer option.<br>" +
                "7. Answer the questions you know first.<br>" +
                "8. Make an educated guess." +
                "</html>");
        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new frmHome().setVisible(true);
            }
        });
    }

    public void initImage(){
        ImageIcon imageLogo = new ImageIcon(new ImageIcon("C:\\Users\\huyhu\\IdeaProjects\\FinalTest\\img\\headerHelp.png").getImage().getScaledInstance(450, 100, Image.SCALE_SMOOTH));
        labelLogo.setIcon(imageLogo);

        ImageIcon imageBtnBack = new ImageIcon(new ImageIcon("C:\\Users\\huyhu\\IdeaProjects\\FinalTest\\img\\bgBtnBack.png").getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH));
        btnBack.setIcon(imageBtnBack);
    }

    public JPanel getRootPanel() {
        return rootPanel;
    }

    @Override
    public void initJFrame() {
        setTitle("GuideScreen");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(500, 500));
        setContentPane(getRootPanel());
        setVisible(true);
        pack();
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}

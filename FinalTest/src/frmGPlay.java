import model.Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class frmGPlay extends JFrame implements IInitJFrame{
    private JPanel rootGPlay;
    private JPanel panelHeader;
    private JPanel panelLeft;
    private JPanel panelFooter;
    private JPanel panelRight;
    private JPanel panelShow;
    private JPanel panelChoices;
    private JRadioButton aRadioButton;
    private JRadioButton bRadioButton;
    private JRadioButton cRadioButton;
    private JRadioButton dRadioButton;
    private JButton btnAccept;
    private JPanel panelQuestion;
    private JLabel labelQues;
    private JLabel labelError;
    int numCount = 0;

    public frmGPlay() {
        initJFrame();
        Game game = new Game();
        game.onStart(numCount, aRadioButton, bRadioButton, cRadioButton, dRadioButton, labelQues);
        btnAccept.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    game.checkAnswer(numCount,labelQues, aRadioButton, bRadioButton, cRadioButton, dRadioButton, labelError);
                    if(game.onStop(numCount)){
                        setVisible(false);
                        new frmFinished(game.getmScore()).setVisible(true);
                    }
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
                numCount++;
                clearDataRdb();
                game.onStart(numCount, aRadioButton, bRadioButton, cRadioButton, dRadioButton, labelQues);
            }
        });
        aRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                aRadioButton.setSelected(true);
                bRadioButton.setSelected(false);
                cRadioButton.setSelected(false);
                dRadioButton.setSelected(false);
            }
        });
        bRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bRadioButton.setSelected(true);
                aRadioButton.setSelected(false);
                cRadioButton.setSelected(false);
                dRadioButton.setSelected(false);
            }
        });
        cRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cRadioButton.setSelected(true);
                bRadioButton.setSelected(false);
                aRadioButton.setSelected(false);
                dRadioButton.setSelected(false);
            }
        });
        dRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dRadioButton.setSelected(true);
                bRadioButton.setSelected(false);
                cRadioButton.setSelected(false);
                aRadioButton.setSelected(false);
            }
        });
    }

    public void clearDataRdb(){
        aRadioButton.setSelected(false);
        bRadioButton.setSelected(false);
        cRadioButton.setSelected(false);
        dRadioButton.setSelected(false);
    }
    public JPanel getRootGPlay() {
        return rootGPlay;
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }

    @Override
    public void initJFrame() {
        setTitle("ScreenPlay");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(500, 500));
        setVisible(true);
        setContentPane(getRootGPlay());
        pack();
    }
}

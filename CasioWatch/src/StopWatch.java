import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.atomic.AtomicBoolean;

import static java.lang.Thread.sleep;

public class StopWatch extends Thread{
    private JPanel rootStop;
    private JLabel labelSHeader;
    private JLabel labelSFooter;
    private JPanel panelMain;
    private JLabel labelSLeft;
    private JLabel labelSRight;
    private JPanel panelBtn;
    private JButton btnStop;
    private JButton btnStart;
    private JButton btnClear;
    private JPanel panelDetail;
    private JPanel panelTime;
    private JLabel labelHour;
    private JLabel labelMinute;
    private JLabel labelSecond;

    private boolean running = false;
    private Thread worker;
    private int seconds =0;
    private int minutes = 0;
    private int hours = 0;

    public StopWatch()  {

        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                countTime();
                worker.start();
            }
        });
        btnClear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                running = false;
                hours = 0;
                minutes = 0;
                seconds = 0;
                labelHour.setText("00");
                labelMinute.setText("00");
                labelSecond.setText("00");
            }
        });
        btnStop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                running = false;
                interrupt();
            }
        });
    }

    public void InitImage(){
        // Init Image and SetBg
        ImageIcon imageHeader = new ImageIcon(new ImageIcon("C:\\Users\\huyhu\\IdeaProjects\\CasioWatch\\Image\\labelHeader.png").getImage().getScaledInstance(304, 60, Image.SCALE_SMOOTH));
        labelSHeader.setIcon(imageHeader);
        ImageIcon imageLeft = new ImageIcon(new ImageIcon("C:\\Users\\huyhu\\IdeaProjects\\CasioWatch\\Image\\labelLeft.png").getImage().getScaledInstance(10, 145, Image.SCALE_SMOOTH));
        labelSLeft.setIcon(imageLeft);
        ImageIcon imageRight = new ImageIcon(new ImageIcon("C:\\Users\\huyhu\\IdeaProjects\\CasioWatch\\Image\\labelRight.png").getImage().getScaledInstance(10, 145, Image.SCALE_SMOOTH));
        labelSRight.setIcon(imageRight);
        ImageIcon imageFooter = new ImageIcon(new ImageIcon("C:\\Users\\huyhu\\IdeaProjects\\CasioWatch\\Image\\labelFooter.png").getImage().getScaledInstance(304, 60, Image.SCALE_SMOOTH));
        labelSFooter.setIcon(imageFooter);
    }

    public void increaseSeconds(int cSeconds){
        if(seconds < 10){
            labelSecond.setText("0" + seconds);
        }
        else{
            labelSecond.setText(seconds+"");
        }

        if(seconds == 59){
            minutes++;
        }
        seconds++;
    }
    public void increaseMinute(int cSeconds){
        if(cSeconds == 59){
            seconds = 0;
            minutes++;
        }
        if(minutes < 10){
            labelMinute.setText("0" + minutes);
        }
        else {
            labelMinute.setText("");
        }
    }
    public void increaseHour(int cMinutes){
        if(cMinutes == 59){
            minutes = 0;
            hours++;
        }
        if(hours < 10){
            labelHour.setText("0" + hours);
        }
        else {
            labelMinute.setText("");
        }
    }

    public void countTime(){
        worker = new Thread(new Runnable() {
            @Override
            public void run() {
                running = true;
                while(running){
                    try {
                        increaseSeconds(seconds);
                        increaseMinute(seconds);
                        increaseHour(minutes);
                        sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        running = false;
                        interrupt();
                    }
                }
            }
        });
    }
    public JPanel getRootStop() {
        return rootStop;
    }
}

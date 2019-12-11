import com.sun.org.apache.regexp.internal.RE;
import javafx.scene.paint.Stop;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class CasioWatch extends Canvas{
    private JPanel rootPanel;
    private JLabel labelLeft;
    private JLabel labelRight;
    private JLabel labelHour;
    private JLabel labelSecond;
    private JLabel labelLogo;
    private JLabel labelSection;
    private JLabel labelFooter;
    private JLabel labelHeader;
    private JPanel panelMain;
    private JPanel panelDetail;
    private JPanel panelDay;
    private JLabel labelNum;
    private JLabel labelDay;
    private JPanel panelLogo;
    private JPanel panelTime;
    private JLabel labelMinute;
    private JPanel panelSection;
    private JButton btnStopMode;
    //Init global var
    private JFrame frame2;

    public static ArrayList<String> listLink = new ArrayList<>();
    public CasioWatch() {
        ImageIcon imageNext = new ImageIcon(new ImageIcon("C:\\Users\\huyhu\\IdeaProjects\\CasioWatch\\Image\\nextLeft.JPG").getImage().getScaledInstance(20, 60, Image.SCALE_SMOOTH));
        btnStopMode.setBorder(BorderFactory.createEmptyBorder());
        btnStopMode.setIcon(imageNext);
        btnStopMode.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StopWatch stopWatch = new StopWatch();
                stopWatch.InitImage();
                frame2 = new JFrame("StopFrame");
                MainShow.initFrame(frame2);
                frame2.setContentPane(stopWatch.getRootStop());
                MainShow.closeFrame(frame2);
            }
        });
    }


    public JPanel getRootPanel() {
        return rootPanel;
    }

    public void InitImage(){
        // Init Image and SetBg
        ImageIcon imageHeader = new ImageIcon(new ImageIcon("C:\\Users\\huyhu\\IdeaProjects\\CasioWatch\\Image\\labelHeader.png").getImage().getScaledInstance(310, 60, Image.SCALE_SMOOTH));
        labelHeader.setIcon(imageHeader);
        ImageIcon imageLogo = new ImageIcon(new ImageIcon("C:\\Users\\huyhu\\IdeaProjects\\CasioWatch\\Image\\LOGO.JPG").getImage().getScaledInstance(235, 50, Image.SCALE_SMOOTH));
        labelLogo.setIcon(imageLogo);
        ImageIcon imageLeft = new ImageIcon(new ImageIcon("C:\\Users\\huyhu\\IdeaProjects\\CasioWatch\\Image\\labelLeft.png").getImage().getScaledInstance(10, 145, Image.SCALE_SMOOTH));
        labelLeft.setIcon(imageLeft);
       // ImageIcon imageRight = new ImageIcon(new ImageIcon("C:\\Users\\huyhu\\IdeaProjects\\CasioWatch\\Image\\labelRight.JPG").getImage().getScaledInstance(15, 130, Image.SCALE_SMOOTH));
       // labelRight.setIcon(imageRight);
        ImageIcon imageSection = new ImageIcon(new ImageIcon("C:\\Users\\huyhu\\IdeaProjects\\CasioWatch\\Image\\labelSection.JPG").getImage().getScaledInstance(275, 50, Image.SCALE_SMOOTH));
        labelSection.setIcon(imageSection);
        ImageIcon imageFooter = new ImageIcon(new ImageIcon("C:\\Users\\huyhu\\IdeaProjects\\CasioWatch\\Image\\labelFooter.png").getImage().getScaledInstance(310, 60, Image.SCALE_SMOOTH));
        labelFooter.setIcon(imageFooter);
    }

    public String getDayOfWeek(int n){
        String a = "1";
        switch (n) {
            case 1:
                a = "SU";
                break;
            case 2:
                a =  "MO";
                break;
            case 3:
                a = "TU";
                break;
            case 4:
                a = "WE";
                break;
            case 5:
                a = "THUR";
                break;
            case 6:
                a =  "FR";
                break;
            case 7:
                a = "SA";
                break;
        }
        return a;
    }



    public void resolveTime() {
        Thread clock = new Thread(){
            public void run(){
                try {
                    while (true){
                        Calendar time = new GregorianCalendar() ;
                        int hour = time.get(Calendar.HOUR);
                        int minute = time.get(Calendar.MINUTE);
                        int second = time.get(Calendar.SECOND);
                        int day = time.get(Calendar.DAY_OF_MONTH);
                        int dayOfWeek = time.get(Calendar.DAY_OF_WEEK);

                        labelNum.setText("" + getDayOfWeek(dayOfWeek));

                        if(day < 10)
                            labelDay.setText("0" + day);
                        else
                            labelDay.setText(day + "");

                        if(second < 10)
                            labelSecond.setText("0" + second);
                        else
                            labelSecond.setText(second + "");

                        if(hour < 10)
                            labelHour.setText("0" + hour);
                        else
                            labelHour.setText(hour + "");

                        if(minute < 10)
                            labelMinute.setText("0" + minute);
                        else
                            labelMinute.setText(minute + "");
                        sleep(1000);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        clock.start();
    }
}

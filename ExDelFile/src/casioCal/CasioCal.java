package casioCal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CasioCal {

    boolean bIsNewNumber = true, bIsInputValue1 = true;
    double dValue1, dValue2, dResult;
    String iOperator;
    private JPanel rootPanel;
    private JPanel titlePanel;
    private JTextField txtResult;
    private JPanel panelForm;
    private JPanel panelButton;
    private JButton btn1;
    private JButton btn3;
    private JButton btn6;
    private JButton btn2;
    private JButton btn7;
    private JButton btn5;
    private JButton btn4;
    private JButton btn8;
    private JButton btn9;
    private JButton btnClear;
    private JButton btn0;
    private JButton btnEqual;
    private JButton btnDot;
    private JButton btnSub;
    private JButton btnAbs;
    private JButton btnMul;
    private JButton btnDiv;
    private JComboBox cbOperator;
    private JTextField txtOperator;


    String z = txtResult.getText();

    public CasioCal() {
        Font fFormat = new Font(Font.SANS_SERIF, Font.BOLD, 14);
        String operator[] = {"+", "-", "*", "/"};


//        cbOperator.setSelectedIndex(3);
        btnClear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtResult.setText("");
                bIsInputValue1 = true;
                bIsNewNumber = true;
            }
        });


        btnEqual.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dValue2 = Double.parseDouble(txtResult.getText());
                switch (iOperator){
                    case "+":
                        dResult = dValue1+dValue2;
                        txtResult.setText(String.valueOf(dResult));
                        dValue1 = 0;
                        break;
                    case "-":
                        dResult = dValue1-dValue2;
                        txtResult.setText(String.valueOf(dResult));
                        dValue1 = 0;
                        break;
                    case "*":
                        dResult = dValue1*dValue2;
                        txtResult.setText(String.valueOf(dResult));
                        dValue1 = 0;
                        break;
                    case "/":
                        if (dValue2 != 0) {
                            dResult = dValue1/dValue2;
                            txtResult.setText(String.valueOf(dResult));
                            dValue1 = 0;
                        }
                        break;
                }
            }
        });
        btnSub.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                iOperator = "+";
                dValue1 = Double.parseDouble(txtResult.getText());
                txtResult.setText("0");
            }
        });
        btnAbs.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                iOperator = "-";
                dValue1 = Double.parseDouble(txtResult.getText());
                txtResult.setText("0");
            }
        });
        btnDiv.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                iOperator = "/";
                dValue1 = Double.parseDouble(txtResult.getText());
                txtResult.setText("0");
            }
        });
    }

    public void initComponent(){
        btn1.addActionListener(new NumberListener("1", txtResult));
        btn2.addActionListener(new NumberListener("2", txtResult));
        btn3.addActionListener(new NumberListener("3", txtResult));
        btn4.addActionListener(new NumberListener("4", txtResult));
        btn5.addActionListener(new NumberListener("5", txtResult));
        btn6.addActionListener(new NumberListener("6", txtResult));
        btn7.addActionListener(new NumberListener("7", txtResult));
        btn8.addActionListener(new NumberListener("8", txtResult));
        btn9.addActionListener(new NumberListener("9", txtResult));
        btn0.addActionListener(new NumberListener("0", txtResult));
    }

    public JPanel getRootPanel() {
        return rootPanel;
    }
}

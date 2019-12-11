package casioCal;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OperatorListener implements ActionListener {
    String mOperator;
    JTextField mTextField;
    double oValue1;
    double oValue2;
    public OperatorListener(String oPerator, JTextField textField, double value1, double value2){
        mOperator = oPerator;
        mTextField = textField;
        oValue1 = value1;
        oValue2 = value2;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        oValue1 = Double.parseDouble(mTextField.getText());
        mTextField.setText("0");
    }
}

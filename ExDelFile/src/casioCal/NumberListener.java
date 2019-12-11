package casioCal;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NumberListener implements ActionListener {

    private String mNumber;
    private JTextField mTextField;

    public NumberListener(String number, JTextField textField) {
        mNumber = number;
        mTextField = textField;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(mTextField.getText().equals("0") && mTextField.getText() != null){
            mTextField.setText(mNumber);
        }
        else{
            String value = mTextField.getText() + mNumber;
            mTextField.setText(value);
        }
    }


}

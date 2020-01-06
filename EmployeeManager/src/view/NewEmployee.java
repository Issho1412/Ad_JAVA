package view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NewEmployee {
    private JPanel rootPanel;
    private JTextField txtFullName;
    private JRadioButton rdbMale;
    private JRadioButton rdbFemale;


    public NewEmployee() {
        rdbMale.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                rdbFemale.setSelected(false);
                rdbMale.setSelected(true);
            }
        });
        rdbFemale.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                rdbMale.setSelected(false);
                rdbFemale.setSelected(true);
            }
        });

    }

    public String getFullName(){
        return txtFullName.getText();
    }

    public String getGender(){
        if(rdbMale.isSelected())
            return "Male";
        else if(rdbFemale.isSelected())
            return "Female";

        return "Male";
    }

    public JPanel getRootPanel() {
        return rootPanel;
    }
}

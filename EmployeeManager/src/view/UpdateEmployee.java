package view;

import model.Employee;
import model.TableObserver;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class UpdateEmployee {
    private JButton btnUpdate;
    private JTextField txtUId;
    private JTextField txtFullName;
    private JRadioButton rdbUMale;
    private JRadioButton rdbUFemale;
    private JPanel rootPanel;

    public UpdateEmployee(EmployeeView view, int id, String FullName, String Gender) {
         LoadData(id, FullName, Gender);

    }

    public String getFullName(){
        return txtFullName.getText();
    }

    public int getId(){return Integer.parseInt(txtUId.getText());}
    public String getGender(){
        if(rdbUMale.isSelected())
            return "Male";
        else if(rdbUFemale.isSelected())
            return "Female";

        return "Male";
    }
    public void LoadData(int id, String FullName, String Gender){
        txtFullName.setText(FullName);
        txtUId.setText(id+"");
        if(Gender.equals("Male")){
            rdbUFemale.setSelected(false);
            rdbUMale.setSelected(true);
        }
        if(Gender.equals("Female")){
            rdbUFemale.setSelected(true);
            rdbUMale.setSelected(false);
        }
    }
    public JPanel getRootPanel() {
        return rootPanel;
    }

}

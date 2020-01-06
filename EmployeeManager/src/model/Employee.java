package model;

import java.util.EnumMap;

public class Employee {
    private int m_id;

    private String m_fullName;

    private String m_gender;

    private String m_txt;
    public Employee(){

    }

    public Employee(int id, String fullName, String gender){
        this.m_id = id;
        this.m_fullName = fullName;
        this.m_gender = gender;
    }


    public int getM_id() {
        return m_id;
    }

    public void setM_id(int m_id) {
        this.m_id = m_id;
    }

    public String getM_fullName() {
        return m_fullName;
    }

    public void setM_fullName(String m_fullName) {
        this.m_fullName = m_fullName;
    }

    public void setM_gender(String m_gender) {
        this.m_gender = m_gender;
    }

    public String isM_gender() {
        return m_gender;
    }
}

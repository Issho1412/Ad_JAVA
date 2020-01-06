package model;

import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Questions {
    String m_prompt;
    String m_answer;
    public ArrayList<String> lstChoice;

    public Questions(String prompt, String [] choice, String answer){
        this.m_prompt = prompt;
        this.lstChoice = new ArrayList<String>();
        for(int i = 0; i < choice.length; i++){
            this.lstChoice.add(choice[i]);
        }
        Collections.shuffle(lstChoice);
        this.m_answer = answer;
    }

    public String getQuestion(){
        return m_prompt;
    }

    public  ArrayList<String> getLstChoice(){
        return lstChoice;
    }

    public String getAnswer(){
        return m_answer;
    }


}

package model;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Game extends Thread{
    private ArrayList<Questions> setQuestions;
    private ArrayList<String> setChoice;
    JFrame jframe;
    private int mScore = 0;

    public Game(){
        setQuestions = new ArrayList<Questions>();
        String q1 = "How are you ?";
        String [] as1 = {"I'm fine.", "I'm fine. How are you?", "All right", "Both a, b, c"};
        setQuestions.add(new Questions(q1, as1, "Both a, b, c"));

        String q2 = "What ____ your name ?";
        String [] as2 = {"is", "are", "You are handsome.", "Both a, b, c"};
        setQuestions.add(new Questions(q2, as2, "is"));

        String q3 = "If it rains, I __ go to schools?";
        String [] as3 = {"will", "won't", "am", "not"};
        setQuestions.add(new Questions(q3, as3, "won't"));

        String q4 = "I is going to ___ to school tomorrow?";
        String [] as4 = {"will", "doesn't", "went", "go"};
        setQuestions.add(new Questions(q4, as4, "go"));

        String q5 = "<html>I'm very happy _____ in India. <br> I really miss being there </html>";
        String [] as5 = {"to live", "to have lived", "to be living", "to be lived"};
        setQuestions.add(new Questions(q5, as5, "to have lived"));

        String q6 = "<html>I wish I _____ those words.<br> But now it's too late. </html>";
        String [] as6 = {"not having said", "never said", "have never said", "had never said"};
        setQuestions.add(new Questions(q6, as6, "had never said"));

        String q7 = "<html>She was working on her computer <br> with her baby next to _____.</html>";
        String [] as7 = {"she", "herself", "hers", "her"};
        setQuestions.add(new Questions(q7, as7, "her"));

        String q8 = "______ gifts to the judges.";
        String [] as8 = {"It's not allowed offering", "It's not permitted offering", "It's not allowed to offer", "It's not permitted offering"};
        setQuestions.add(new Questions(q8, as8, "won't"));


        String q9 = " Jenny ________ tired.";
        String [] as9 = {"be", "has", "is", "have"};
        setQuestions.add(new Questions(q9, as9, "is"));

        String q10 = "<html>_____ is she?<br>" +
                "She's my friend from London.</html>";
        String [] as10 = {"Who", "Why", "When", "Whose"};
        setQuestions.add(new Questions(q10, as10, "Who"));

        String q11 = "<html>Today is Wednesday. <br>" +
                "Yesterday it ___ Tuesday.</html>";
        String [] as11 = {"was", "is", "were", "wasn't"};
        setQuestions.add(new Questions(q11, as11, "was"));

        String q12 = "<html>It's Thursday today. <br>" +
                "Tomorrow it _____ Friday.</html>";
        String [] as12 = {"be", "was", "will be", "will"};
        setQuestions.add(new Questions(q12, as12, "will"));

        String q13 = "<html>" +
                "Has Steve got a sister?<br>" +
                "No, he ___, but he's got 2 brothers.<br>"+
                "</html>";
        String [] as13 = {"has", "hasn't", "haven't", "don't"};
        setQuestions.add(new Questions(q13, as13, "hasn't"));

        String q14 = "_____ to London on the train yesterday?";
        String [] as14 = {"Did Mary went", "Did Mary go", "Mary go", "Mary goes"};
        setQuestions.add(new Questions(q14, as14, "Did Mary go"));

        String q15 = "How many people _____ in your family?";
        String [] as15 = {"is there", "are there", "there", "there are"};
        setQuestions.add(new Questions(q15, as15, "are there"));
        Collections.shuffle(setQuestions, new Random());
    }
    

    public int getmScore() {
        return mScore;
    }

    public int getSizeSetQuestions(){
        return setQuestions.size();
    }

    public void increasePoint(JLabel label){
        mScore++;
        label.setText("Your's score: " + mScore +
                " (" + mScore + "/" + setQuestions.size() + ")");
    }

    public void checkAnswer( int numCount, JLabel labelNow, JRadioButton r1, JRadioButton r2, JRadioButton r3, JRadioButton r4, JLabel labelError) throws InterruptedException {
        this.mScore = getmScore();

        String dataCompare = labelNow.getText();
        String data1 = r1.getText();
        String data2 = r2.getText();
        String data3 = r3.getText();
        String data4 = r4.getText();
        if(r1.isSelected()){
            for(int i = numCount; i < setQuestions.size(); i++){
                if(dataCompare.equals(setQuestions.get(i).getQuestion()) && data1.equals(setQuestions.get(i).getAnswer())){
                    increasePoint(labelError);
                    break;
                }
                else {
                    break;
                }
            }
        }
        if(r2.isSelected()){
            for(int i = numCount; i < setQuestions.size(); i++){
                if(dataCompare.equals(setQuestions.get(i).getQuestion()) && data2.equals(setQuestions.get(i).getAnswer())){
                    increasePoint(labelError);
                    break; }
                else {
                    break;
                }
            }
        }
        if(r3.isSelected()){
            for(int i = numCount; i < setQuestions.size(); i++){
                if(dataCompare.equals(setQuestions.get(i).getQuestion()) && data3.equals(setQuestions.get(i).getAnswer())){
                    increasePoint(labelError);
                    break;
                }
                else {
                    break;
                }
            }
        }
        if(r4.isSelected()){
            for(int i = numCount; i < setQuestions.size(); i++){
                if(dataCompare.equals(setQuestions.get(i).getQuestion()) && data4.equals(setQuestions.get(i).getAnswer())){
                    increasePoint(labelError);
                    break;
                }
                else {
                    break;
                }
            }
        }
    }

    public void onStart(int numCount, JRadioButton r1, JRadioButton r2, JRadioButton r3, JRadioButton r4, JLabel labelQues){
        r1.setSelected(true);
        for(int ques = numCount; ques < setQuestions.size(); ques++){
            labelQues.setText(setQuestions.get(ques).getQuestion());
            int numChoice = setQuestions.get(ques).getLstChoice().size();
            for(int choice = 0; choice < numChoice; choice++){
                if(choice == 0){
                    r1.setText(setQuestions.get(ques).getLstChoice().get(choice));
                }
                if(choice == 1){
                    r2.setText(setQuestions.get(ques).getLstChoice().get(choice));
                }
                if(choice == 2){
                    r3.setText(setQuestions.get(ques).getLstChoice().get(choice));
                }
                if(choice == 3){
                    r4.setText(setQuestions.get(ques).getLstChoice().get(choice));
                }
            }
            break;
        }
    }


    public boolean onStop(int x){
        if(x == getSizeSetQuestions()-1){
            return true;
        }
        else {
            return false;
        }
    }
}

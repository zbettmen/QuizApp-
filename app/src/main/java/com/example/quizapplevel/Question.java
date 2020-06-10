package com.example.quizapplevel;

public class Question {
    public static final String CITY = "Citys";
    public static final String BIOLOGY = "Biology";
    public static final String MATH = "Math";
    private String question;
    private String option1;
    private String option2;
    private String option3;
    private int answerNr;
    private String categories;

    public Question(String question, String option1, String option2, String option3, int answerNr, String categories) {
        this.question = question;
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
        this.answerNr = answerNr;
        this.categories = categories;
    }

    public Question() {

    }



    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getOption1() {
        return option1;
    }

    public void setOption1(String option1) {
        this.option1 = option1;
    }

    public String getOption2() {
        return option2;
    }

    public void setOption2(String option2) {
        this.option2 = option2;
    }

    public String getOption3() {
        return option3;
    }

    public void setOption3(String option3) {
        this.option3 = option3;
    }

    public int getAnswerNr() {
        return answerNr;
    }

    public String getCategories() {
        return categories;
    }

    public void setCategories(String categories) {
        this.categories = categories;
    }

    public void setAnswerNr(int answerNr) {
        this.answerNr = answerNr;
    }
    public static String[] getAllDifficultyLevels(){
        
    }
}

package com.example.quizapplevel;



public class Question {
    public static final String DIFFICULTY_MATH = "MATH";
    public static final String DIFFICULTY_BIOLOGY = "BIOLOGY";
    public static final String DIFFICULTY_CITY = "CITY";
    public static final String DIFFICULTY_HINT = "HINT";
    private String question;
    private String option1;
    private String option2;
    private String option3;
    private int answerNr;
    private String difficulty;
    private String hint;
    private String image;
    private int isImage;

    public Question() {
    }
    public Question(String question, String option1, String option2,
                    String option3, int answerNr, String difficulty,String image,int isImage) {
        this.question = question;
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
        this.answerNr = answerNr;
        this.difficulty = difficulty;
        this.image = image;
        this.isImage = isImage;

    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int isImage() {
        return isImage;
    }

    public void setIsImage(int image) {
        isImage = image;
    }

    public Question(String hint) {
        this.hint = hint;
    }

    public String getHint() {
        return hint;
    }

    public void setHint(String hint) {
        this.hint = hint;
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
    public void setAnswerNr(int answerNr) {
        this.answerNr = answerNr;
    }
    public String getDifficulty() {
        return difficulty;
    }
    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }




    public static String[] getAllDifficultyLevels() {
        return new String[]{
                DIFFICULTY_MATH,
                DIFFICULTY_BIOLOGY,
                DIFFICULTY_CITY,
                DIFFICULTY_HINT

        };
    }
}

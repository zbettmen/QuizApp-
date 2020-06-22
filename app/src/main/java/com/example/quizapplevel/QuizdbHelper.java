package com.example.quizapplevel;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.example.quizapplevel.QuizContract.*;



import java.util.ArrayList;


public class QuizdbHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "MyQuizRH.db";
    private static final int DATABASE_VERSION = 1;
    private SQLiteDatabase db;
    public QuizdbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {

        this.db = db;
        final String SQL_CREATE_QUESTIONS_TABLE = "CREATE TABLE " +
                QuestionsTable.TABLE_NAME + " ( " +
                QuestionsTable._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                QuestionsTable.COLUMN_QUESTION + " TEXT, " +
                QuestionsTable.COLUMN_OPTION1 + " TEXT, " +
                QuestionsTable.COLUMN_OPTION2 + " TEXT, " +
                QuestionsTable.COLUMN_OPTION3 + " TEXT, " +
                QuestionsTable.COLUMN_ANSWER_NR + " INTEGER, " +
                QuestionsTable.COLUMN_CHOOSE + " TEXT," +
                QuestionsTable.COLUMN_PICTURES + " TEXT," +
                QuestionsTable.COLUMN_IMAGE + " TEXT," +
                QuestionsTable.COLUMN_ISIMAGE + " BOOLEAN" +
                ")";
        db.execSQL(SQL_CREATE_QUESTIONS_TABLE);
            fillQuestionsTable();
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + QuestionsTable.TABLE_NAME);
        onCreate(db);
    }
    private void fillQuestionsTable() {
        Question q1 = new Question("2 * 5 is?: ",
                "1", "2", "10", 3, Question.DIFFICULTY_MATH,"",0);
            addQuestion(q1);

        Question q2 = new Question("2 + 2 is?: ",
                "1", "2", "4", 3, Question.DIFFICULTY_MATH,"",0);
        addQuestion(q2);

        Question q3 = new Question(" ",
                "Bil Gates ", "Mona Lisa", "50 cent", 2, Question.DIFFICULTY_PICTURES,"monalisa",1);
        addQuestion(q3);

        Question q4 = new Question(" ",
                "Bil Gates ", "Eminem", "Steve Jobs", 3, Question.DIFFICULTY_PICTURES,"steve",1);
        addQuestion(q4);

        Question q5 = new Question(" ",
                "Zlatan ", "Ronaldo", "2pac", 1, Question.DIFFICULTY_PICTURES,"zlatan",1);
        addQuestion(q5);

        Question q6 = new Question(" ",
                "Sarajevo ", "Berlin", "Stockholm", 1, Question.DIFFICULTY_CITY,"sarajevo",1);
        addQuestion(q6);


        Question q7 = new Question("Biggest city in the world by population ",
                "Shanghai", "Tokyo", "New York", 3, Question.DIFFICULTY_CITY,"",0);
        addQuestion(q7);


        Question q8 = new Question("How many bones does an adult human have ",
                "128", "60", "206", 3, Question.DIFFICULTY_BIOLOGY,"",0);
        addQuestion(q8);

        Question q9 = new Question("Biggest snake on earth  ",
                "Anaconda", "Cobra", "Python", 3, Question.DIFFICULTY_BIOLOGY,"",0);
        addQuestion(q9);






    }

    private void addQuestion(Question question) {
        ContentValues cv = new ContentValues();
        cv.put(QuestionsTable.COLUMN_QUESTION, question.getQuestion());
        cv.put(QuestionsTable.COLUMN_OPTION1, question.getOption1());
        cv.put(QuestionsTable.COLUMN_OPTION2, question.getOption2());
        cv.put(QuestionsTable.COLUMN_OPTION3, question.getOption3());
        cv.put(QuestionsTable.COLUMN_ANSWER_NR, question.getAnswerNr());
        cv.put(QuestionsTable.COLUMN_CHOOSE, question.getDifficulty());
        cv.put(QuestionsTable.COLUMN_PICTURES,question.getPictures());
        cv.put(QuestionsTable.COLUMN_IMAGE,question.getImage());
        cv.put(QuestionsTable.COLUMN_ISIMAGE,question.isImage());

        db.insert(QuestionsTable.TABLE_NAME, null, cv);
    }






    public ArrayList<Question> getQuestions(String difficulty) {
        ArrayList<Question> questionList = new ArrayList<>();
        db = getReadableDatabase();
        String[] selectionArgs = new String[]{difficulty};
        Cursor c = db.rawQuery("SELECT * FROM " + QuestionsTable.TABLE_NAME +
                " WHERE " + QuestionsTable.COLUMN_CHOOSE + " = ?", selectionArgs);
        if (c.moveToFirst()) {
            do {
                Question question = new Question();
                question.setQuestion(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_QUESTION)));
                question.setOption1(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION1)));
                question.setOption2(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION2)));
                question.setOption3(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION3)));
                question.setAnswerNr(c.getInt(c.getColumnIndex(QuestionsTable.COLUMN_ANSWER_NR)));
                question.setDifficulty(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_CHOOSE)));
                question.setImage(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_IMAGE)));
                question.setIsImage(c.getInt(c.getColumnIndex(QuestionsTable.COLUMN_ISIMAGE)));

                questionList.add(question);
            } while (c.moveToNext());
        } c.close();

        return questionList;
    }
}

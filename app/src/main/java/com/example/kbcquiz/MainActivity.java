 package com.example.kbcquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

 public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    TextView totalQuestionsTextview;
    TextView questionsTextview;
    Button ansA,ansB,ansC,ansD;
    Button submitBtn;

    int score=0;
    int totalQuestion = QuestionAnswer.question.length;
    int currentQuestionIndex = 0;
    String selectedAnswer ="";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        totalQuestionsTextview = findViewById(R.id.total_question);
        questionsTextview = findViewById(R.id.question);
        ansA = findViewById(R.id.ans_A);
        ansB = findViewById(R.id.ans_B);
        ansC = findViewById(R.id.ans_C);
        ansD = findViewById(R.id.ans_D);
        submitBtn = findViewById(R.id.submit_btn);


        ansA.setOnClickListener(this);
        ansB.setOnClickListener(this);
        ansC.setOnClickListener(this);
        ansD.setOnClickListener(this);



        totalQuestionsTextview.setText("Total Question:"+totalQuestion);

        loadNewQuestion();


    }

     @Override
     public void onClick(View view) {

     }
     void loadNewQuestion(){
        questionsTextview.setText(QuestionAnswer.question[currentQuestionIndex]);
        ansA.setText(QuestionAnswer.choices[currentQuestionIndex][0]);
         ansB.setText(QuestionAnswer.choices[currentQuestionIndex][1]);
         ansC.setText(QuestionAnswer.choices[currentQuestionIndex][2]);
         ansD.setText(QuestionAnswer.choices[currentQuestionIndex][3]);
     }
 }
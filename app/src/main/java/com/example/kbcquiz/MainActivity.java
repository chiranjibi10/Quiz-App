 package com.example.kbcquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.graphics.Color;
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
        submitBtn.setOnClickListener(this);



        totalQuestionsTextview.setText("Total Question:"+totalQuestion);

        loadNewQuestion();


    }

     @Override
     public void onClick(View view) {

        ansA.setBackgroundColor(Color.WHITE);
        ansB.setBackgroundColor(Color.WHITE);
        ansC.setBackgroundColor(Color.WHITE);
        ansD.setBackgroundColor(Color.WHITE);

        Button clickedButton = (Button) view;
        if(clickedButton.getId()==R.id.submit_btn){
            if(selectedAnswer.equals(QuestionAnswer.correctAnswer[currentQuestionIndex])){
                score++;
            }
            currentQuestionIndex++;
            loadNewQuestion();


        }else {
            selectedAnswer =clickedButton.getText().toString();
            clickedButton.setBackgroundColor(Color.MAGENTA);
        }

     }
     void loadNewQuestion(){
        if(currentQuestionIndex == totalQuestion){
            finishQuiz();
            return;
        }

        questionsTextview.setText(QuestionAnswer.question[currentQuestionIndex]);
        ansA.setText(QuestionAnswer.choices[currentQuestionIndex][0]);
         ansB.setText(QuestionAnswer.choices[currentQuestionIndex][1]);
         ansC.setText(QuestionAnswer.choices[currentQuestionIndex][2]);
         ansD.setText(QuestionAnswer.choices[currentQuestionIndex][3]);
     }
     void finishQuiz(){
        String passStatus ="";
        if(score > totalQuestion*0.60){
            passStatus ="CONGRATULATION YOU GOT PASSED";
        }else {
            passStatus = "OOPS,YOU FAILED";
        }
        new AlertDialog.Builder(this)
                .setTitle(passStatus)
                .setMessage("Score is    "+score+"    Out of   "+totalQuestion)
                .setPositiveButton("Restart", (dialogInterface,i) -> restartQuiz())
                .setCancelable(false)
                .show();
     }
     void restartQuiz(){
        score = 0;
        currentQuestionIndex =0;
        loadNewQuestion();
     }
 }
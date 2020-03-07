package com.example.flashcards;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class AddCardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_card);

        if (getIntent().getStringExtra("Question") != null ) {
            ((EditText) findViewById(R.id.flashcard_question)).setText(getIntent().getStringExtra("Question"));
            ((EditText) findViewById(R.id.answer1)).setText(getIntent().getStringExtra("AnswerChoice1"));
            ((EditText) findViewById(R.id.answer2)).setText(getIntent().getStringExtra("AnswerChoice2"));
            ((EditText) findViewById(R.id.answer3)).setText(getIntent().getStringExtra("AnswerChoice3"));
        }

        findViewById(R.id.x_icon).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AddCardActivity.this, MainActivity.class);
                startActivity(intent);
                //StartingActivity.this.startActivity(intent);
            }
        });


        findViewById(R.id.save_icon).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AddCardActivity.this, MainActivity.class);

                intent.putExtra("Question", ((EditText) findViewById(R.id.flashcard_question)).getText().toString());
                intent.putExtra("AnswerChoice1", ((EditText) findViewById(R.id.answer1)).getText().toString());
                intent.putExtra("AnswerChoice2", ((EditText) findViewById(R.id.answer2)).getText().toString());
                intent.putExtra("AnswerChoice3", ((EditText) findViewById(R.id.answer3)).getText().toString());
                setResult(RESULT_OK, intent);
                finish();

            }
        });
    }
}

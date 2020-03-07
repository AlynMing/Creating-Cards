package com.example.flashcards;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.answer1).setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if(((TextView)findViewById(R.id.flashcard_question)).getTag().equals("1"))
                    ((TextView) findViewById(R.id.answer1)).setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                else
                    ((TextView) findViewById(R.id.answer1)).setBackgroundColor(getResources().getColor(R.color.colorAccent));

                if(((TextView)findViewById(R.id.flashcard_question)).getTag().equals("2"))
                    ((TextView) findViewById(R.id.answer2)).setBackgroundColor(getResources().getColor(R.color.colorPrimary));

                if(((TextView)findViewById(R.id.flashcard_question)).getTag().equals("3"))
                    ((TextView) findViewById(R.id.answer3)).setBackgroundColor(getResources().getColor(R.color.colorPrimary));

            }
        });


        findViewById(R.id.answer2).setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if(((TextView)findViewById(R.id.flashcard_question)).getTag().equals("1"))
                    ((TextView) findViewById(R.id.answer1)).setBackgroundColor(getResources().getColor(R.color.colorPrimary));

                if(((TextView)findViewById(R.id.flashcard_question)).getTag().equals("2"))
                    ((TextView) findViewById(R.id.answer2)).setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                else
                    ((TextView) findViewById(R.id.answer2)).setBackgroundColor(getResources().getColor(R.color.colorAccent));

                if(((TextView)findViewById(R.id.flashcard_question)).getTag().equals("3"))
                    ((TextView) findViewById(R.id.answer3)).setBackgroundColor(getResources().getColor(R.color.colorPrimary));

            }
        });
        findViewById(R.id.answer3).setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if(((TextView)findViewById(R.id.flashcard_question)).getTag().equals("1"))
                    ((TextView) findViewById(R.id.answer1)).setBackgroundColor(getResources().getColor(R.color.colorPrimary));

                if(((TextView)findViewById(R.id.flashcard_question)).getTag().equals("2"))
                    ((TextView) findViewById(R.id.answer2)).setBackgroundColor(getResources().getColor(R.color.colorPrimary));

                if(((TextView)findViewById(R.id.flashcard_question)).getTag().equals("3"))
                    ((TextView) findViewById(R.id.answer3)).setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                else
                    ((TextView) findViewById(R.id.answer3)).setBackgroundColor(getResources().getColor(R.color.colorAccent));

            }
        });
        findViewById(R.id.plus_icon).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent page_create = new Intent(MainActivity.this, AddCardActivity.class);
                startActivityForResult(page_create, 100);
            }
        });


        findViewById(R.id.edit_icon).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AddCardActivity.class);
                intent.putExtra("Question", ((TextView) findViewById(R.id.flashcard_question)).getText());
                intent.putExtra("AnswerChoice1", ((TextView) findViewById(R.id.answer1)).getText());
                intent.putExtra("AnswerChoice2", ((TextView) findViewById(R.id.answer2)).getText());
                intent.putExtra("AnswerChoice3", ((TextView) findViewById(R.id.answer3)).getText());
                startActivityForResult(intent, 101);
            }
        });
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 100 && resultCode ==RESULT_OK) {


            Snackbar.make(findViewById(R.id.background),
                    "Card Added Successfully",
                    Snackbar.LENGTH_SHORT)
                    .show();

        }
        if (requestCode == 101 && resultCode ==RESULT_OK)
        {
            Snackbar.make(findViewById(R.id.background),
                    "Card Changed Successfully",
                    Snackbar.LENGTH_SHORT)
                    .show();

        }

        if (data.getStringExtra("Question") != null ) {
            ((TextView) findViewById(R.id.flashcard_question)).setText(data.getStringExtra("Question"));
            ((TextView) findViewById(R.id.answer1)).setText(data.getStringExtra("AnswerChoice1"));
            ((TextView) findViewById(R.id.answer2)).setText(data.getStringExtra("AnswerChoice2"));
            ((TextView) findViewById(R.id.answer3)).setText(data.getStringExtra("AnswerChoice3"));
        }

    }


}

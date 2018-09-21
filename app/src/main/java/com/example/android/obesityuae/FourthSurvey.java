package com.example.android.obesityuae;

import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android.obesityuae.services.MessageServices;
import com.example.android.obesityuae.services.ServiceBuilder;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FourthSurvey extends AppCompatActivity {


    private EditText diet;
    private Button done;
    private Person person;
    private int i = 0;
    private ProgressBar mProgress;
    private TextView mProgressTxt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fourth_survey);
        diet = (EditText)findViewById(R.id.describeDiet);
        done = (Button)findViewById(R.id.pageFourNext);
        mProgress = (ProgressBar)findViewById(R.id.progressBarId4);
        mProgressTxt = (TextView)findViewById(R.id.progressTxt4);
        person = (Person)getApplication();
        final AudioManager audio = (AudioManager) this.getSystemService(Context.AUDIO_SERVICE);
        final MediaPlayer mp = MediaPlayer.create(this, R.raw.myclicksound);

        startFourthActiviy();


        diet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                diet.setFocusableInTouchMode(true);
                diet.setFocusable(true);
                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.showSoftInput(diet, InputMethodManager.SHOW_IMPLICIT);
            }
        });
        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(diet.getText().toString().trim().length() > 0)
                {
                    person.setDiet(diet.getText().toString().trim());
                    if(audio.getRingerMode() == AudioManager.RINGER_MODE_NORMAL)
                        mp.start();

                    MessageServices taskService = ServiceBuilder.buildService(MessageServices.class);
                    Call<Person> createRequest = taskService.createPatient(person);
                    createRequest.enqueue(new Callback<Person>() {
                        @Override
                        public void onResponse(Call<Person> call, Response<Person> response) {
                            Intent intent = new Intent(FourthSurvey.this, MainScreen.class);
                            startActivity(intent);
                        }

                        @Override
                        public void onFailure(Call<Person> call, Throwable t) {

                            Toast.makeText(FourthSurvey.this, "Failed", Toast.LENGTH_SHORT).show();
                        }
                    });
                    Intent intent = new Intent(FourthSurvey.this, MainScreen.class);
                    startActivity(intent);
                }
                else
                {
                    Toast.makeText(FourthSurvey.this, "Missing Description", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            View v = getCurrentFocus();
            if ( v instanceof EditText) {
                Rect outRect = new Rect();
                v.getGlobalVisibleRect(outRect);
                if (!outRect.contains((int)event.getRawX(), (int)event.getRawY())) {
                    v.clearFocus();
                    InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
                }
            }
        }
        return super.dispatchTouchEvent( event );
    }

    private void startFourthActiviy()
    {
        mProgress.setProgress(person.getProgress());
        mProgressTxt.setText(person.getProgressText());
        if(person.getDiet().length() >0)
        {
            diet.setText(person.getDiet());
        }

    }
}

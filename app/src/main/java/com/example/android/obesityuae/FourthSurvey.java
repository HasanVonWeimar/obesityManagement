package com.example.android.obesityuae;

import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
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
        person = new Person();
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
                    Person patient = new Person();

                     patient.setProgress(person.getProgress());
                    patient.setWaist(person.getWaist());
                    patient.setGender(person.getGender());
                    patient.setMartial(person.getMartial());
                     patient.setHeight(person.getHeight());
                    patient.setWeight(person.getWeight());
                   patient.setNationality(person.getNationality());
                    patient.setResidence(person.getResidence());
                    patient.setResidenceType(person.getResidenceType());
                    patient.setIncome(person.getIncome());
                    patient.setExercise(person.getExercise());
                    patient.setWorkActivity(person.getWorkActivity());
                    patient.setEducation(person.getEducation());
                    patient.setMobilePhones(person.getMobilePhones());
                    patient.setInternet(person.getInternet());
                    patient.setInternetYears(person.getInternetYears());
                    patient.setuSnore(person.getuSnore());
                    patient.setuInsomnia(person.getuInsomnia());
                    patient.setuHeadache(person.getuHeadache());
                    patient.setuNarcolepsy(person.getuNarcolepsy());
                    patient.setuFertility(person.getuFertility());
                    patient.setuBackJoint(person.getuBackJoint());
                    patient.setuSkin(person.getuSkin());
                    patient.setuThyroid(person.getuThyroid());
                    patient.setuHeart(person.getuHeart());
                    patient.setuHypertension(person.getuHypertension());
                    patient.setuDiabetes(person.getuDiabetes());
                    patient.setuCancer(person.getuCancer());
                    patient.setfThyroid(person.getfThyroid());
                    patient.setfHeart(person.getfHeart());
                    patient.setfHypertension(person.getfHypertension());
                    patient.setfDiabetes(person.getfDiabetes());
                    patient.setfCancer(person.getfCancer());
                    patient.setDay(person.getDay());
                    patient.setMonth(person.getMonth());
                    patient.setYear(person.getYear());
                    patient.setDiet(person.getDiet());
                    patient.setProgressText(person.getProgressText());
                    patient.setId(person.getId());

                    Call<Person> createRequest = taskService.createPatient(patient);
                    createRequest.enqueue(new Callback<Person>() {
                        @Override
                        public void onResponse(Call<Person> call, Response<Person> response) {
                            //response.code();
                            Log.d("retrofit", "worked");
                            Toast.makeText(FourthSurvey.this, "worked", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(FourthSurvey.this, MainScreen.class);
                            intent.putExtra("patient", person);
                            startActivity(intent);
                        }

                        @Override
                        public void onFailure(Call<Person> call, Throwable t) {
                            Log.d("retrofit", "didnt work");
                            Toast.makeText(FourthSurvey.this, "Failed", Toast.LENGTH_SHORT).show();
                        }
                    });

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
        Intent intent = getIntent();
        if (intent.hasExtra("patient")) {
            Log.d("intent","is working");
            person = (Person)intent.getSerializableExtra("patient");
        }

        mProgress.setProgress(person.getProgress());
        mProgressTxt.setText(person.getProgressText());
        if(person.getDiet().length() >0)
        {
            diet.setText(person.getDiet());
        }

    }
}

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
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class SecondSurvey extends AppCompatActivity {

    private Button mNext;
    private Button mBack;
    private ImageButton sleepingButton;
    private ImageButton strechesButton;
    private ImageButton medworkoutButton;
    private ImageButton heavyLiftingButton;
    private ImageButton noActivityButton;
    private ImageButton slightActivityButton;
    private ImageButton highActivityButton;
    private ImageButton internetUse;
    private ImageButton primary;
    private ImageButton secondary;
    private ImageButton bachelor;
    private ImageButton phd;
    private ImageButton oneYear;
    private ImageButton twoYear;
    private ImageButton threeYear;
    private EditText internetBox;
    private TextView internetTextView;
    private ProgressBar mProgress;
    private Person person;
    private TextView progressTxt;
   // private HorizontalScrollView exerciseScroll;
    //private HorizontalScrollView educationScroll;
    //private LinearLayout exScroll;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_survey);

        mNext = (Button)findViewById(R.id.pageTwoNext);
        mBack = (Button)findViewById(R.id.pageTwoBack);
        sleepingButton = (ImageButton)findViewById(R.id.surveySleeping);
        strechesButton = (ImageButton)findViewById(R.id.surveyStreches);
        medworkoutButton = (ImageButton)findViewById(R.id.surveyMedWorkout);
        heavyLiftingButton = (ImageButton)findViewById(R.id.surveyHeavyLifting);
        noActivityButton = (ImageButton)findViewById(R.id.surveyOfficeDesk);
        slightActivityButton = (ImageButton)findViewById(R.id.surveyRunningMan);
        highActivityButton = (ImageButton)findViewById(R.id.surveyConstructionWorker);
        internetUse = (ImageButton)findViewById(R.id.internetTrueFalse);
        internetBox = (EditText)findViewById(R.id.internetEditBox);
        internetTextView = (TextView)findViewById(R.id.internetText);
        mProgress = (ProgressBar)findViewById(R.id.progressBarId2);
        person = (Person)getApplication();
        primary = (ImageButton)findViewById(R.id.primary);
        secondary = (ImageButton)findViewById(R.id.highschool);
        bachelor = (ImageButton)findViewById(R.id.bachelor);
        phd = (ImageButton)findViewById(R.id.postgrad);
        oneYear = (ImageButton)findViewById(R.id.mobileusage1);
        twoYear = (ImageButton)findViewById(R.id.mobileusage2);
        threeYear = (ImageButton)findViewById(R.id.mobileusage3);
        progressTxt = (TextView)findViewById(R.id.progressTxt2);
        //exerciseScroll = (HorizontalScrollView)findViewById(R.id.horizontal1);
        //educationScroll = (HorizontalScrollView)findViewById(R.id.horizontal2);
        //exScroll = (LinearLayout)findViewById(exerciseScroll);
        final AudioManager audio = (AudioManager) this.getSystemService(Context.AUDIO_SERVICE);

        final MediaPlayer mp = MediaPlayer.create(this, R.raw.myclicksound);

        startSecondActivity();

        sleepingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(audio.getRingerMode() == AudioManager.RINGER_MODE_NORMAL)
                    mp.start();
                exercise(0);
            }
        });

        strechesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(audio.getRingerMode() == AudioManager.RINGER_MODE_NORMAL)
                    mp.start();
                exercise(1);
            }
        });

        medworkoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(audio.getRingerMode() == AudioManager.RINGER_MODE_NORMAL)
                    mp.start();
                exercise(2);
            }
        });

        heavyLiftingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(audio.getRingerMode() == AudioManager.RINGER_MODE_NORMAL)
                    mp.start();
                exercise(3);
            }
        });

        mBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(audio.getRingerMode() == AudioManager.RINGER_MODE_NORMAL)
                    mp.start();

                Intent intent = new Intent(SecondSurvey.this, FirstSurvey.class);
                startActivity(intent);
            }
        });

        mNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(audio.getRingerMode() == AudioManager.RINGER_MODE_NORMAL)
                    mp.start();

                if(checkSurvey()) {
                    if(person.getProgress() == 25)
                    {
                        person.setProgress(50);
                    }
                    Intent intent = new Intent(SecondSurvey.this, ThirdSurvey.class);
                    startActivity(intent);
                }
            }
        });

        noActivityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(audio.getRingerMode() == AudioManager.RINGER_MODE_NORMAL)
                    mp.start();
                workActivity(0);
            }
        });

        slightActivityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(audio.getRingerMode() == AudioManager.RINGER_MODE_NORMAL)
                    mp.start();
                workActivity(1);
            }
        });

        highActivityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(audio.getRingerMode() == AudioManager.RINGER_MODE_NORMAL)
                    mp.start();
                workActivity(2);
            }
        });

        internetUse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(audio.getRingerMode() == AudioManager.RINGER_MODE_NORMAL)
                    mp.start();
                internetUsage();
            }
        });

        primary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(audio.getRingerMode() == AudioManager.RINGER_MODE_NORMAL)
                    mp.start();
                school(0);
            }
        });

        secondary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(audio.getRingerMode() == AudioManager.RINGER_MODE_NORMAL)
                    mp.start();
                school(1);
            }
        });

        bachelor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(audio.getRingerMode() == AudioManager.RINGER_MODE_NORMAL)
                    mp.start();
                school(2);
            }
        });

        phd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(audio.getRingerMode() == AudioManager.RINGER_MODE_NORMAL)
                    mp.start();
                school(3);
            }
        });

        oneYear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(audio.getRingerMode() == AudioManager.RINGER_MODE_NORMAL)
                    mp.start();
             mobileYear(0);
            }
        });

        twoYear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(audio.getRingerMode() == AudioManager.RINGER_MODE_NORMAL)
                    mp.start();
                mobileYear(1);
            }
        });

        threeYear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(audio.getRingerMode() == AudioManager.RINGER_MODE_NORMAL)
                    mp.start();
                mobileYear(2);
            }
        });

    }

    private void exercise(int often){
        if(often==0)
        {
            sleepingButton.setBackgroundResource(R.drawable.circularclicked);
            strechesButton.setBackgroundResource(R.drawable.circular);
            medworkoutButton.setBackgroundResource(R.drawable.circular);
            heavyLiftingButton.setBackgroundResource(R.drawable.circular);
            person.setExercise(0);
        }
        else if(often == 1)
        {
            sleepingButton.setBackgroundResource(R.drawable.circular);
            strechesButton.setBackgroundResource(R.drawable.circularclicked);
            medworkoutButton.setBackgroundResource(R.drawable.circular);
            heavyLiftingButton.setBackgroundResource(R.drawable.circular);
            person.setExercise(1);
        }
        else if(often == 2)
        {
            sleepingButton.setBackgroundResource(R.drawable.circular);
            strechesButton.setBackgroundResource(R.drawable.circular);
            medworkoutButton.setBackgroundResource(R.drawable.circularclicked);
            heavyLiftingButton.setBackgroundResource(R.drawable.circular);
            person.setExercise(2);
        }
        else if(often == 3)
        {
            sleepingButton.setBackgroundResource(R.drawable.circular);
            strechesButton.setBackgroundResource(R.drawable.circular);
            medworkoutButton.setBackgroundResource(R.drawable.circular);
            heavyLiftingButton.setBackgroundResource(R.drawable.circularclicked);
            person.setExercise(3);
        }

    }

    private void workActivity(int howActive){
        if(howActive == 0)
        {
            noActivityButton.setBackgroundResource(R.drawable.circularclicked);
            slightActivityButton.setBackgroundResource(R.drawable.circular);
            highActivityButton.setBackgroundResource(R.drawable.circular);
            person.setWorkActivity(0);
        }
        else if(howActive == 1)
        {
            noActivityButton.setBackgroundResource(R.drawable.circular);
            slightActivityButton.setBackgroundResource(R.drawable.circularclicked);
            highActivityButton.setBackgroundResource(R.drawable.circular);
            person.setWorkActivity(1);
        }
        else if(howActive == 2)
        {
            noActivityButton.setBackgroundResource(R.drawable.circular);
            slightActivityButton.setBackgroundResource(R.drawable.circular);
            highActivityButton.setBackgroundResource(R.drawable.circularclicked);
            person.setWorkActivity(2);
        }
    }

    private void startSecondActivity()
    {
        /*
        ViewTreeObserver vto1 = exerciseScroll.getViewTreeObserver();
        vto1.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            public void onGlobalLayout() {
                exerciseScroll.getChildAt((exerciseScroll.getChildCount()/2)+1);
            }
        });

        ViewTreeObserver vto2 = educationScroll.getViewTreeObserver();
        vto2.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            public void onGlobalLayout() {
                educationScroll.scrollTo(educationScroll.getMaxScrollAmount()/2, 0);
            }
        });*/




        mProgress.setProgress(person.getProgress());
        progressTxt.setText(person.getProgressText());
        activityInternetUsage();
        school(person.getEducation());
        workActivity(person.getWorkActivity());
        mobileYear(person.getMobilePhones());
        exercise(person.getExercise());
    }

    private void activityInternetUsage()
    {
        if(person.getInternet() == 1)
        {
            internetUse.setBackgroundResource(R.drawable.circularclicked);
            internetBox.setFocusable(true);
            internetBox.setFocusableInTouchMode(true);
            internetBox.setClickable(true);
            internetTextView.setText("Yes");
            internetBox.setText(String.valueOf(person.getInternetYears()));
        }

        else if(person.getInternet() == 2)
        {
            internetUse.setBackgroundResource(R.drawable.circularclickedred);
            internetBox.setFocusable(false);
            internetBox.setFocusableInTouchMode(false);
            internetBox.setClickable(false);
            internetBox.setText("");
            internetTextView.setText("No");
        }
    }
    private void internetUsage()
    {

         if(person.getInternet() == 1)
        {
            internetUse.setBackgroundResource(R.drawable.circularclickedred);
            internetBox.setFocusable(false);
            internetBox.setFocusableInTouchMode(false);
            internetBox.setClickable(false);
            internetBox.setText("");
            internetTextView.setText("No");
            person.setInternet(2);
            person.setInternetYears(0);
        }

        else if(person.getInternet() == 2 || person.getInternet() == -1)
        {
            internetUse.setBackgroundResource(R.drawable.circularclicked);
            internetBox.setFocusable(true);
            internetBox.setFocusableInTouchMode(true);
            internetBox.setClickable(true);
            internetTextView.setText("Yes");
            person.setInternet(1);
        }
    }

    private void school(int education)
    {
        if(education == 0)
        {
            primary.setBackgroundResource(R.drawable.circularclicked);
            secondary.setBackgroundResource(R.drawable.circular);
            bachelor.setBackgroundResource(R.drawable.circular);
            phd.setBackgroundResource(R.drawable.circular);
            person.setEducation(0);
        }

        else if(education == 1)
        {
            primary.setBackgroundResource(R.drawable.circular);
            secondary.setBackgroundResource(R.drawable.circularclicked);
            bachelor.setBackgroundResource(R.drawable.circular);
            phd.setBackgroundResource(R.drawable.circular);
            person.setEducation(1);
        }

        else if(education == 2)
        {
            primary.setBackgroundResource(R.drawable.circular);
            secondary.setBackgroundResource(R.drawable.circular);
            bachelor.setBackgroundResource(R.drawable.circularclicked);
            phd.setBackgroundResource(R.drawable.circular);
            person.setEducation(2);
        }

        else if(education == 3)
        {
            primary.setBackgroundResource(R.drawable.circular);
            secondary.setBackgroundResource(R.drawable.circular);
            bachelor.setBackgroundResource(R.drawable.circular);
            phd.setBackgroundResource(R.drawable.circularclicked);
            person.setEducation(3);
        }
    }

    private void mobileYear(int year)
    {
        if(year == 0)
        {
            oneYear.setBackgroundResource(R.drawable.circularclicked);
            twoYear.setBackgroundResource(R.drawable.circular);
            threeYear.setBackgroundResource(R.drawable.circular);
            person.setMobilePhones(0);
        }

        else if(year == 1)
        {
            oneYear.setBackgroundResource(R.drawable.circular);
            twoYear.setBackgroundResource(R.drawable.circularclicked);
            threeYear.setBackgroundResource(R.drawable.circular);
            person.setMobilePhones(1);
        }

        else if(year == 2)
        {
            oneYear.setBackgroundResource(R.drawable.circular);
            twoYear.setBackgroundResource(R.drawable.circular);
            threeYear.setBackgroundResource(R.drawable.circularclicked);
            person.setMobilePhones(2);
        }
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

    private boolean checkSurvey(){
        if(person.getExercise() == -1)
        {
            Toast.makeText(this, "Missing Exercise", Toast.LENGTH_SHORT).show();
            return false;
        }

        if(person.getWorkActivity() == -1)
        {
            Toast.makeText(this, "Missing Work Activity", Toast.LENGTH_SHORT).show();
            return false;
        }

        if(person.getEducation() == -1)
        {
            Toast.makeText(this, "Missing Education", Toast.LENGTH_SHORT).show();
            return false;
        }

        if(person.getMobilePhones() == -1)
        {
            Toast.makeText(this, "Missing Use of Mobile Phones", Toast.LENGTH_SHORT).show();
            return false;
        }

        if(person.getInternet() == 1 && internetBox.getText().toString().trim() == "")
        {
            Toast.makeText(this, "Invalid Years of Internet Usage", Toast.LENGTH_SHORT).show();
            return false;
        }
        else if(person.getInternet() == 1 && internetBox.getText().toString().trim().length() > 0 &&
                internetBox.getText().toString().trim().length() < 4)
        {
            person.setInternetYears(Integer.valueOf(internetBox.getText().toString().trim()));
        }


        if(person.getInternet() == -1)
        {
            Toast.makeText(this, "Missing Use of Internet", Toast.LENGTH_SHORT).show();
            return false;
        }

        if(person.getInternetYears() > 120 || person.getInternetYears() < 0)
        {
            Toast.makeText(this, "Invalid Years of Internet Usage", Toast.LENGTH_SHORT).show();
            return false;
        }

        if(person.getInternet() == 1 && person.getInternetYears() == 0)
        {
            Toast.makeText(this, "Invalid Years of Internet Usage", Toast.LENGTH_SHORT).show();
            return false;
        }

        return true;
    }
}

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

import static com.example.android.obesityuae.R.id.snore;

public class ThirdSurvey extends AppCompatActivity {

    private ImageButton mSnore;
    private ImageButton mInsomnia;
    private ImageButton mMorning;
    private ImageButton mNarcolepsy;
    private ImageButton mFertility;
    private ImageButton mJoint;
    private ImageButton mSkin;
    private ImageButton uThyroid, fThyroid;
    private ImageButton uHeart, fHeart;
    private ImageButton uHypertension, fHypertension;
    private ImageButton uDiabetes, fDiabetes;
    private ImageButton uCancer, fCancer;
    private TextView mSnoreText;
    private TextView mInsomniaText;
    private TextView mMorningText;
    private TextView mNarcolepsyText;
    private TextView mFertilityText;
    private TextView mJointText;
    private TextView mSkinText;
    private TextView uThyroidText, fThyroidText;
    private TextView uHeartText, fHeartText;
    private TextView uDiabetesText, fDiabetesText;
    private TextView uCancerText, fCancerText;
    private TextView uHypertensionText, fHypertensionText;
    private ProgressBar mProgress;
    private TextView mProgressTxt;
    private Button back;
    private Button done;
    private Person person;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third_survey);

        mSnore = (ImageButton)findViewById(snore);
        uHeart = (ImageButton)findViewById(R.id.uHeart);
        fHeart = (ImageButton)findViewById(R.id.fHeart);
        back = (Button)findViewById(R.id.pageThreeBack);
        done = (Button)findViewById(R.id.pageThreeNext);
        mInsomnia = (ImageButton)findViewById(R.id.insomnia);
        mMorning = (ImageButton)findViewById(R.id.morningheadache);
        mNarcolepsy = (ImageButton)findViewById(R.id.narcolepsy);
        mFertility = (ImageButton)findViewById(R.id.fertility);
        mJoint = (ImageButton)findViewById(R.id.backJoint);
        mSkin = (ImageButton)findViewById(R.id.skin);
        uThyroid = (ImageButton)findViewById(R.id.thyroid);
        fThyroid = (ImageButton)findViewById(R.id.thyroidFamily);
        uHypertension = (ImageButton)findViewById(R.id.uHyper);
        fHypertension = (ImageButton)findViewById(R.id.fHyper);
        uDiabetes = (ImageButton)findViewById(R.id.uDiabetes);
        fDiabetes = (ImageButton)findViewById(R.id.fDiabetes);
        uCancer = (ImageButton)findViewById(R.id.uCancer);
        fCancer = (ImageButton)findViewById(R.id.fCancer);
        mSnoreText = (TextView)findViewById(R.id.snoreText);
        uHeartText = (TextView)findViewById(R.id.uHeartText);
        fHeartText = (TextView)findViewById(R.id.fHeartText);
        mInsomniaText = (TextView)findViewById(R.id.insomniaText);
        mMorningText = (TextView)findViewById(R.id.morningheadacheText);
        mNarcolepsyText = (TextView)findViewById(R.id.narcolepsyText);
        mFertilityText = (TextView)findViewById(R.id.fertilityText);
        mJointText = (TextView)findViewById(R.id.backJointText);
        mSkinText = (TextView)findViewById(R.id.skinText);
        uThyroidText = (TextView)findViewById(R.id.thyroidText);
        fThyroidText = (TextView)findViewById(R.id.thyroidFamilyText);
        uHypertensionText = (TextView)findViewById(R.id.uHyperText);
        fHypertensionText = (TextView)findViewById(R.id.fHyperText);
        uDiabetesText = (TextView)findViewById(R.id.uDiabetesText);
        fDiabetesText = (TextView)findViewById(R.id.fDiabetesText);
        uCancerText = (TextView)findViewById(R.id.uCancerText);
        fCancerText = (TextView)findViewById(R.id.fCancerText);
        person = (Person)getApplication();
        mProgress = (ProgressBar)findViewById(R.id.progressBarId3);
        mProgressTxt = (TextView)findViewById(R.id.progressTxt3);
        final AudioManager audio = (AudioManager) this.getSystemService(Context.AUDIO_SERVICE);
        final MediaPlayer mp = MediaPlayer.create(this, R.raw.myclicksound);


        startThirdActivity();


        mSnore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(audio.getRingerMode() == AudioManager.RINGER_MODE_NORMAL)
                    mp.start();
                if(person.getuSnore() == -1)
                {
                    person.setuSnore(0);
                }
                snore();
            }
        });

        uHeart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(audio.getRingerMode() == AudioManager.RINGER_MODE_NORMAL)
                    mp.start();
                if(person.getuHeart() == -1)
                {
                    person.setuHeart(0);
                }
                uheart();
            }
        });

        fHeart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(audio.getRingerMode() == AudioManager.RINGER_MODE_NORMAL)
                    mp.start();
                if(person.getfHeart() == -1)
                {
                    person.setfHeart(0);
                }
                fheart();
            }
        });

        mInsomnia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(audio.getRingerMode() == AudioManager.RINGER_MODE_NORMAL)
                    mp.start();
                if(person.getuInsomnia() == -1)
                {
                    person.setuInsomnia(0);
                }
                insomniaFun();
            }
        });

        mMorning.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(audio.getRingerMode() == AudioManager.RINGER_MODE_NORMAL)
                    mp.start();
                if(person.getuHeadache() == -1)
                {
                    person.setuHeadache(0);
                }
                morningFun();
            }
        });

        mNarcolepsy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(audio.getRingerMode() == AudioManager.RINGER_MODE_NORMAL)
                    mp.start();
                if(person.getuNarcolepsy() == -1)
                {
                    person.setuNarcolepsy(0);
                }
                narcoFun();
            }
        });

        mFertility.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(audio.getRingerMode() == AudioManager.RINGER_MODE_NORMAL)
                    mp.start();
                if(person.getuFertility() == -1)
                {
                    person.setuFertility(0);
                }
                fertFun();
            }
        });

        mJoint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(audio.getRingerMode() == AudioManager.RINGER_MODE_NORMAL)
                    mp.start();
                if(person.getuBackJoint() == -1)
                {
                    person.setuBackJoint(0);
                }
                jointFun();
            }
        });

        mSkin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(audio.getRingerMode() == AudioManager.RINGER_MODE_NORMAL)
                    mp.start();
                if(person.getuSkin() == -1)
                {
                    person.setuSkin(0);
                }
                skinFun();
            }
        });

        uThyroid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(audio.getRingerMode() == AudioManager.RINGER_MODE_NORMAL)
                    mp.start();
                if(person.getuThyroid() == -1)
                {
                    person.setuThyroid(0);
                }
                uThyroidFun();
            }
        });

        fThyroid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(audio.getRingerMode() == AudioManager.RINGER_MODE_NORMAL)
                    mp.start();
                if(person.getfThyroid() == -1)
                {
                    person.setfThyroid(0);
                }
                fThyroidFun();
            }
        });

        uHypertension.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(audio.getRingerMode() == AudioManager.RINGER_MODE_NORMAL)
                    mp.start();
                if(person.getuHypertension() == -1)
                {
                    person.setuHypertension(0);
                }
                uHyperFun();
            }
        });

        fHypertension.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(audio.getRingerMode() == AudioManager.RINGER_MODE_NORMAL)
                    mp.start();
                if(person.getfHypertension() == -1)
                {
                    person.setfHypertension(0);
                }
                fHyperFun();
            }
        });

        uDiabetes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(audio.getRingerMode() == AudioManager.RINGER_MODE_NORMAL)
                    mp.start();
                if(person.getuDiabetes() == -1)
                {
                    person.setuDiabetes(0);
                }
                uDiaFun();
            }
        });

        fDiabetes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(audio.getRingerMode() == AudioManager.RINGER_MODE_NORMAL)
                    mp.start();
                if(person.getfDiabetes() == -1)
                {
                    person.setfDiabetes(0);
                }
                fDiaFun();
            }
        });

        uCancer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(audio.getRingerMode() == AudioManager.RINGER_MODE_NORMAL)
                    mp.start();
                if(person.getuCancer() == -1)
                {
                    person.setuCancer(0);
                }
                uCancerFun();
            }
        });

        fCancer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(audio.getRingerMode() == AudioManager.RINGER_MODE_NORMAL)
                    mp.start();
                if(person.getfCancer() == -1)
                {
                    person.setfCancer(0);
                }
                fCancerFun();
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(audio.getRingerMode() == AudioManager.RINGER_MODE_NORMAL)
                    mp.start();
                Intent intent = new Intent(ThirdSurvey.this, SecondSurvey.class);
                startActivity(intent);
            }
        });

        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(audio.getRingerMode() == AudioManager.RINGER_MODE_NORMAL)
                    mp.start();
                if(check()) {
                    person.setProgress(75);
                    person.setProgressText("75%");
                    Intent intent = new Intent(ThirdSurvey.this, FourthSurvey.class);
                    startActivity(intent);
                }
            }
        });

    }

    private void snore()
    {
        if(person.getuSnore() == 0)
        {
            mSnore.setBackgroundResource(R.drawable.circularclicked);
            mSnoreText.setText("Yes");
            person.setuSnore(1);
        }
        else if(person.getuSnore() == 1)
        {
            mSnore.setBackgroundResource(R.drawable.circularclickedred);
            mSnoreText.setText("No");
            person.setuSnore(0);
        }
    }

    private void insomniaFun()
    {
        if(person.getuInsomnia() == 0)
        {
            mInsomnia.setBackgroundResource(R.drawable.circularclicked);
            mInsomniaText.setText("Yes");
            person.setuInsomnia(1);
        }
        else if(person.getuInsomnia() == 1)
        {
            mInsomnia.setBackgroundResource(R.drawable.circularclickedred);
            mInsomniaText.setText("No");
            person.setuInsomnia(0);
        }
    }

    private void uheart()
    {
        if(person.getuHeart() == 0)
        {
            uHeart.setBackgroundResource(R.drawable.circularclicked);
            uHeartText.setText("Yes");
            person.setuHeart(1);
        }
        else if(person.getuHeart() == 1)
        {
            uHeart.setBackgroundResource(R.drawable.circularclickedred);
            uHeartText.setText("No");
            person.setuHeart(0);
        }
    }

    private void fheart()
    {
        if(person.getfHeart() == 0)
        {
            fHeart.setBackgroundResource(R.drawable.circularclicked);
            fHeartText.setText("Yes");
            person.setfHeart(1);
        }
        else if(person.getfHeart() == 1)
        {
            fHeart.setBackgroundResource(R.drawable.circularclickedred);
            fHeartText.setText("No");
            person.setfHeart(0);
        }
    }

    private void morningFun()
    {
        if(person.getuHeadache() == 0)
        {
            mMorning.setBackgroundResource(R.drawable.circularclicked);
            mMorningText.setText("Yes");
            person.setuHeadache(1);
        }
        else if(person.getuHeadache() == 1)
        {
            mMorning.setBackgroundResource(R.drawable.circularclickedred);
            mMorningText.setText("No");
            person.setuHeadache(0);
        }
    }

    private void narcoFun()
    {
        if(person.getuNarcolepsy() == 0)
        {
            mNarcolepsy.setBackgroundResource(R.drawable.circularclicked);
            mNarcolepsyText.setText("Yes");
            person.setuNarcolepsy(1);
        }
        else if(person.getuNarcolepsy() == 1)
        {
            mNarcolepsy.setBackgroundResource(R.drawable.circularclickedred);
            mNarcolepsyText.setText("No");
            person.setuNarcolepsy(0);
        }
    }

    private void fertFun()
    {
        if(person.getuFertility() == 0)
        {
            mFertility.setBackgroundResource(R.drawable.circularclicked);
            mFertilityText.setText("Yes");
            person.setuFertility(1);
        }
        else if(person.getuFertility() == 1)
        {
            mFertility.setBackgroundResource(R.drawable.circularclickedred);
            mFertilityText.setText("No");
            person.setuFertility(0);
        }
    }

    private void jointFun()
    {
        if(person.getuBackJoint() == 0)
        {
            mJoint.setBackgroundResource(R.drawable.circularclicked);
            mJointText.setText("Yes");
            person.setuBackJoint(1);
        }
        else if(person.getuBackJoint() == 1)
        {
            mJoint.setBackgroundResource(R.drawable.circularclickedred);
            mJointText.setText("No");
            person.setuBackJoint(0);
        }
    }

    private void skinFun()
    {
        if(person.getuSkin() == 0)
        {
            mSkin.setBackgroundResource(R.drawable.circularclicked);
            mSkinText.setText("Yes");
            person.setuSkin(1);
        }
        else if(person.getuSkin() == 1)
        {
            mSkin.setBackgroundResource(R.drawable.circularclickedred);
            mSkinText.setText("No");
            person.setuSkin(0);
        }
    }

    private void uThyroidFun()
    {
        if(person.getuThyroid() == 0)
        {
            uThyroid.setBackgroundResource(R.drawable.circularclicked);
            uThyroidText.setText("Yes");
            person.setuThyroid(1);
        }
        else if(person.getuThyroid() == 1)
        {
            uThyroid.setBackgroundResource(R.drawable.circularclickedred);
            uThyroidText.setText("No");
            person.setuThyroid(0);
        }
    }

    private void fThyroidFun()
    {
        if(person.getfThyroid() == 0)
        {
            fThyroid.setBackgroundResource(R.drawable.circularclicked);
            fThyroidText.setText("Yes");
            person.setfThyroid(1);
        }
        else if(person.getfThyroid() == 1)
        {
            fThyroid.setBackgroundResource(R.drawable.circularclickedred);
            fThyroidText.setText("No");
            person.setfThyroid(0);
        }
    }

    private void uHyperFun()
    {
        if(person.getuHypertension() == 0)
        {
            uHypertension.setBackgroundResource(R.drawable.circularclicked);
            uHypertensionText.setText("Yes");
            person.setuHypertension(1);
        }
        else if(person.getuHypertension() == 1)
        {
            uHypertension.setBackgroundResource(R.drawable.circularclickedred);
            uHypertensionText.setText("No");
            person.setuHypertension(0);
        }
    }

    private void fHyperFun()
    {
        if(person.getfHypertension() == 0)
        {
            fHypertension.setBackgroundResource(R.drawable.circularclicked);
            fHypertensionText.setText("Yes");
            person.setfHypertension(1);
        }
        else if(person.getfHypertension() == 1)
        {
            fHypertension.setBackgroundResource(R.drawable.circularclickedred);
            fHypertensionText.setText("No");
            person.setfHypertension(0);
        }
    }

    private void uDiaFun()
    {
        if(person.getuDiabetes() == 0)
        {
            uDiabetes.setBackgroundResource(R.drawable.circularclicked);
            uDiabetesText.setText("Yes");
            person.setuDiabetes(1);
        }
        else if(person.getuDiabetes() == 1)
        {
            uDiabetes.setBackgroundResource(R.drawable.circularclickedred);
            uDiabetesText.setText("No");
            person.setuDiabetes(0);
        }
    }

    private void fDiaFun()
    {
        if(person.getfDiabetes() == 0)
        {
            fDiabetes.setBackgroundResource(R.drawable.circularclicked);
            fDiabetesText.setText("Yes");
            person.setfDiabetes(1);
        }
        else if(person.getfDiabetes() == 1)
        {
            fDiabetes.setBackgroundResource(R.drawable.circularclickedred);
            fDiabetesText.setText("No");
            person.setfDiabetes(0);
        }
    }

    private void uCancerFun()
    {
        if(person.getuCancer() == 0)
        {
            uCancer.setBackgroundResource(R.drawable.circularclicked);
            uCancerText.setText("Yes");
            person.setuCancer(1);
        }
        else if(person.getuCancer() == 1)
        {
            uCancer.setBackgroundResource(R.drawable.circularclickedred);
            uCancerText.setText("No");
            person.setuCancer(0);
        }
    }

    private void fCancerFun()
    {
        if(person.getfCancer() == 0)
        {
            fCancer.setBackgroundResource(R.drawable.circularclicked);
            fCancerText.setText("Yes");
            person.setfCancer(1);
        }
        else if(person.getfCancer() == 1)
        {
            fCancer.setBackgroundResource(R.drawable.circularclickedred);
            fCancerText.setText("No");
            person.setfCancer(0);
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

    private void startThirdActivity()
    {
        mProgress.setProgress(person.getProgress());
        mProgressTxt.setText(person.getProgressText());
        snoreStart();
        insomniaFunStart();
        uheartStart();
        fheartStart();
        morningFunStart();
        narcoFunStart();
        fertFunStart();
        jointFunStart();
        skinFunStart();
        uThyroidFunStart();
        fThyroidFunStart();
        uHyperFunStart();
        fHyperFunStart();
        uDiaFunStart();
        fDiaFunStart();
        uCancerFunStart();
        fCancerFunStart();
    }

    void snoreStart()
    {
        if(person.getuSnore() == 1)
        {
            mSnore.setBackgroundResource(R.drawable.circularclicked);
            mSnoreText.setText("Yes");
        }
        else if(person.getuSnore() == 0)
        {
            mSnore.setBackgroundResource(R.drawable.circularclickedred);
            mSnoreText.setText("No");
        }
    }
    void insomniaFunStart()
    {
        if(person.getuInsomnia() == 1)
        {
            mInsomnia.setBackgroundResource(R.drawable.circularclicked);
            mInsomniaText.setText("Yes");
        }
        else if(person.getuInsomnia() == 0)
        {
            mInsomnia.setBackgroundResource(R.drawable.circularclickedred);
            mInsomniaText.setText("No");
        }
    }


    void uheartStart()
    {
        if(person.getuHeart() == 1)
        {
            uHeart.setBackgroundResource(R.drawable.circularclicked);
            uHeartText.setText("Yes");
        }
        else if(person.getuHeart() == 0)
        {
            uHeart.setBackgroundResource(R.drawable.circularclickedred);
            uHeartText.setText("No");
        }
    }
    void fheartStart()
    {
        if(person.getfHeart() == 1)
        {
            fHeart.setBackgroundResource(R.drawable.circularclicked);
            fHeartText.setText("Yes");
        }
        else if(person.getfHeart() == 0)
        {
            fHeart.setBackgroundResource(R.drawable.circularclickedred);
            fHeartText.setText("No");
        }
    }
    void morningFunStart()
    {
        if(person.getuHeadache() == 1)
        {
            mMorning.setBackgroundResource(R.drawable.circularclicked);
            mMorningText.setText("Yes");
        }
        else if(person.getuHeadache() == 0)
        {
            mMorning.setBackgroundResource(R.drawable.circularclickedred);
            mMorningText.setText("No");
        }
    }
    void narcoFunStart()
    {
        if(person.getuNarcolepsy() == 1)
        {
            mNarcolepsy.setBackgroundResource(R.drawable.circularclicked);
            mNarcolepsyText.setText("Yes");
        }
        else if(person.getuNarcolepsy() == 0)
        {
            mNarcolepsy.setBackgroundResource(R.drawable.circularclickedred);
            mNarcolepsyText.setText("No");
        }
    }
    void fertFunStart()
    {
        if(person.getuFertility() == 1)
        {
            mFertility.setBackgroundResource(R.drawable.circularclicked);
            mFertilityText.setText("Yes");
        }
        else if(person.getuFertility() == 0)
        {
            mFertility.setBackgroundResource(R.drawable.circularclickedred);
            mFertilityText.setText("No");
        }
    }
    void jointFunStart(){
        if(person.getuBackJoint() == 1)
        {
            mJoint.setBackgroundResource(R.drawable.circularclicked);
            mJointText.setText("Yes");
        }
        else if(person.getuBackJoint() == 0)
        {
            mJoint.setBackgroundResource(R.drawable.circularclickedred);
            mJointText.setText("No");
        }
    }
    void skinFunStart(){
        if(person.getuSkin() == 1)
        {
            mSkin.setBackgroundResource(R.drawable.circularclicked);
            mSkinText.setText("Yes");
        }
        else if(person.getuSkin() == 0)
        {
            mSkin.setBackgroundResource(R.drawable.circularclickedred);
            mSkinText.setText("No");
        }
    }
    void uThyroidFunStart(){
        if(person.getuThyroid() == 1)
        {
            uThyroid.setBackgroundResource(R.drawable.circularclicked);
            uThyroidText.setText("Yes");
        }
        else if(person.getuThyroid() == 0)
        {
            uThyroid.setBackgroundResource(R.drawable.circularclickedred);
            uThyroidText.setText("No");
        }
    }
    void fThyroidFunStart(){
        if(person.getfThyroid() == 1)
        {
            fThyroid.setBackgroundResource(R.drawable.circularclicked);
            fThyroidText.setText("Yes");
        }
        else if(person.getfThyroid() == 0)
        {
            fThyroid.setBackgroundResource(R.drawable.circularclickedred);
            fThyroidText.setText("No");
        }
    }
    void uHyperFunStart(){
        if(person.getuHypertension() == 1)
        {
            uHypertension.setBackgroundResource(R.drawable.circularclicked);
            uHypertensionText.setText("Yes");
        }
        else if(person.getuHypertension() == 0)
        {
            uHypertension.setBackgroundResource(R.drawable.circularclickedred);
            uHypertensionText.setText("No");
        }
    }
    void fHyperFunStart(){
        if(person.getfHypertension() == 1)
        {
            fHypertension.setBackgroundResource(R.drawable.circularclicked);
            fHypertensionText.setText("Yes");
        }
        else if(person.getfHypertension() == 0)
        {
            fHypertension.setBackgroundResource(R.drawable.circularclickedred);
            fHypertensionText.setText("No");
        }
    }
    void uDiaFunStart(){
        if(person.getuDiabetes() == 1)
        {
            uDiabetes.setBackgroundResource(R.drawable.circularclicked);
            uDiabetesText.setText("Yes");
        }
        else if(person.getuDiabetes() == 0)
        {
            uDiabetes.setBackgroundResource(R.drawable.circularclickedred);
            uDiabetesText.setText("No");
        }
    }
    void fDiaFunStart(){
        if(person.getfDiabetes() == 1)
        {
            fDiabetes.setBackgroundResource(R.drawable.circularclicked);
            fDiabetesText.setText("Yes");
        }
        else if(person.getfDiabetes() == 0)
        {
            fDiabetes.setBackgroundResource(R.drawable.circularclickedred);
            fDiabetesText.setText("No");
        }
    }
    void uCancerFunStart(){
        if(person.getuCancer() == 1)
        {
            uCancer.setBackgroundResource(R.drawable.circularclicked);
            uCancerText.setText("Yes");
        }
        else if(person.getuCancer() == 0)
        {
            uCancer.setBackgroundResource(R.drawable.circularclickedred);
            uCancerText.setText("No");
        }
    }
    void fCancerFunStart(){
        if(person.getfCancer() == 1)
        {
            fCancer.setBackgroundResource(R.drawable.circularclicked);
            fCancerText.setText("Yes");
        }
        else if(person.getfCancer() == 0)
        {
            fCancer.setBackgroundResource(R.drawable.circularclickedred);
            fCancerText.setText("No");
        }
    }

    private boolean check(){
        if(person.getuSnore() == -1 )
        {
            Toast.makeText(this, "Missing Information, Please Fill Out The Survey", Toast.LENGTH_SHORT).show();
            return false;
        }

        if(person.getuInsomnia() == -1 )
        {
            Toast.makeText(this, "Missing Information, Please Fill Out The Survey", Toast.LENGTH_SHORT).show();
            return false;
        }

        if(person.getuHeadache() == -1 )
        {
            Toast.makeText(this, "Missing Information, Please Fill Out The Survey", Toast.LENGTH_SHORT).show();
            return false;
        }

        if(person.getuNarcolepsy() == -1 )
        {
            Toast.makeText(this, "Missing Information, Please Fill Out The Survey", Toast.LENGTH_SHORT).show();
            return false;
        }

        if(person.getuFertility() == -1 )
        {
            Toast.makeText(this, "Missing Information, Please Fill Out The Survey", Toast.LENGTH_SHORT).show();
            return false;
        }

        if(person.getuBackJoint() == -1 )
        {
            Toast.makeText(this, "Missing Information, Please Fill Out The Survey", Toast.LENGTH_SHORT).show();
            return false;
        }

        if(person.getuSkin() == -1 )
        {
            Toast.makeText(this, "Missing Information, Please Fill Out The Survey", Toast.LENGTH_SHORT).show();
            return false;
        }

        if(person.getuHeart() == -1 )
        {
            Toast.makeText(this, "Missing Information, Please Fill Out The Survey", Toast.LENGTH_SHORT).show();
            return false;
        }

        if(person.getfHeart() == -1 )
        {
            Toast.makeText(this, "Missing Information, Please Fill Out The Survey", Toast.LENGTH_SHORT).show();
            return false;
        }

        if(person.getuHypertension() == -1 )
        {
            Toast.makeText(this, "Missing Information, Please Fill Out The Survey", Toast.LENGTH_SHORT).show();
            return false;
        }

        if(person.getfHypertension() == -1 )
        {
            Toast.makeText(this, "Missing Information, Please Fill Out The Survey", Toast.LENGTH_SHORT).show();
            return false;
        }

        if(person.getuDiabetes() == -1 )
        {
            Toast.makeText(this, "Missing Information, Please Fill Out The Survey", Toast.LENGTH_SHORT).show();
            return false;
        }

        if(person.getfDiabetes() == -1 )
        {
            Toast.makeText(this, "Missing Information, Please Fill Out The Survey", Toast.LENGTH_SHORT).show();
            return false;
        }

        if(person.getuCancer() == -1 )
        {
            Toast.makeText(this, "Missing Information, Please Fill Out The Survey", Toast.LENGTH_SHORT).show();
            return false;
        }

        if(person.getfCancer() == -1 )
        {
            Toast.makeText(this, "Missing Information, Please Fill Out The Survey", Toast.LENGTH_SHORT).show();
            return false;
        }

        if(person.getuThyroid() == -1 )
        {
            Toast.makeText(this, "Missing Information, Please Fill Out The Survey", Toast.LENGTH_SHORT).show();
            return false;
        }

        if(person.getfThyroid() == -1 )
        {
            Toast.makeText(this, "Missing Information, Please Fill Out The Survey", Toast.LENGTH_SHORT).show();
            return false;
        }

        return true;
    }
}

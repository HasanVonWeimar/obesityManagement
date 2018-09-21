package com.example.android.obesityuae;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class MainScreen extends AppCompatActivity {

    private double BMI;
    private TextView mBMIText;
    private TextView mTreatmentText;
    private TextView mTreatmentMethodsText;
    private TextView mBMICase;
    private TextView stageText;
    private TextView stageReasons;
    private Person person;
    private LinearLayout mBMILayout;
    private int stage = -1;
    private List <String> reasons;
    private String reasonsText = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);

        mBMIText = (TextView)findViewById(R.id.BMIText);
        mTreatmentText = (TextView)findViewById(R.id.treatmentText);
        mTreatmentMethodsText = (TextView)findViewById(R.id.treatmentMethodsText);
        mBMILayout = (LinearLayout)findViewById(R.id.bmiLayout);
        mBMICase = (TextView)findViewById(R.id.BMICase);
        stageText = (TextView)findViewById(R.id.stageText);
        stageReasons = (TextView)findViewById(R.id.stageReasonsText);
        person = (Person)getApplication();
        reasons = new ArrayList<>();
        double tmp;
        tmp = person.getWeight()/((person.getHeight()/100.0)*(person.getHeight()/100.0));

        BMI = round(tmp, 2);

        checkBMI(BMI);

    }

    private static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        BigDecimal bd = new BigDecimal(value);
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }


    private void checkBMI(double bmi)
    {
      /*  if(bmi < 25)
        {
            mBMILayout.setBackgroundResource(R.color.normal);
            mBMIText.setText(String.valueOf(BMI));
            mBMICase.setText("Normal");
            mTreatmentText.setText("Treatment:");
            mTreatmentMethodsText.setText(getString(R.string.normalWeight));
        }*/
        if(bmi >= 25)
        {
            if(person.getuHypertension() == 1)
            {
                if (stage == -1) {
                    stage = 2;
                }
                reasons.add("Hypertension");
               /* mBMILayout.setBackgroundResource(R.color.stage2);
                mBMIText.setText(String.valueOf(BMI));
                mTreatmentText.setText("Treatment:");
                mBMICase.setText("Overweight : Stage 2");
                mTreatmentMethodsText.setText(getString(R.string.stage2));*/
            }

            if(person.getuHeart() == 1)
            {
                if (stage == -1) {
                    stage = 2;
                }
                reasons.add("Cardiovascular Disease");
            }

            if(stage == -1) {

                if (person.getGender() == 1 && person.getuFertility() == 1) {
                    /*mBMILayout.setBackgroundResource(R.color.stage1);
                    mBMIText.setText(String.valueOf(BMI));*/
                    if (stage == -1) {
                        stage = 1;
                    }
                    /*mTreatmentText.setText("Treatment:");
                    mBMICase.setText("Overweight : Stage 1");
                    mTreatmentMethodsText.setText(getString(R.string.stage1));*/
                    reasons.add("Female Infertility");
                }
            }
            if(stage == -1){
                stage = 0;/*
                    mBMILayout.setBackgroundResource(R.color.stage0);
                    mBMIText.setText(String.valueOf(BMI));
                    mTreatmentText.setText("Treatment:");
                    mBMICase.setText("Overweight : Stage 0");
                    mTreatmentMethodsText.setText(getString(R.string.stage0));*/
            }

        }

        if(stage == -1){
            mBMILayout.setBackgroundResource(R.color.normal);
            mBMIText.setText(String.valueOf(BMI));
            mBMICase.setText("Normal");
            stageText.setText("According to the AACE/ACE ALGORITHM FOR THE MEDICAL CARE OF PATIENTS WITH OBESITY, you fall under the Normal category");
            stageReasons.setText(reasonsText);
            mTreatmentText.setText("Treatment:");
            mTreatmentMethodsText.setText(getString(R.string.normalWeight));
        }

        else if(stage == 0)
        {
            mBMILayout.setBackgroundResource(R.color.stage0);
            mBMIText.setText(String.valueOf(BMI));
            stageText.setText("According to the AACE/ACE ALGORITHM FOR THE MEDICAL CARE OF PATIENTS WITH OBESITY, you fall under the Stage 0 category");
            for(String tmp : reasons){
                reasonsText = reasonsText + tmp + "\n";
            }
            stageReasons.setText(reasonsText);
            mTreatmentText.setText("Treatment:");
            mBMICase.setText("Overweight : Stage 0");
            mTreatmentMethodsText.setText(getString(R.string.stage0));
        }
        else if(stage == 1)
        {
            mBMILayout.setBackgroundResource(R.color.stage1);
            mBMIText.setText(String.valueOf(BMI));
            stageText.setText("According to the AACE/ACE ALGORITHM FOR THE MEDICAL CARE OF PATIENTS WITH OBESITY, you fall under the Stage 1 category");
            for(String tmp : reasons){
                reasonsText = reasonsText + tmp + "\n";
            }
            stageReasons.setText(reasonsText);
            mTreatmentText.setText("Treatment:");
            mBMICase.setText("Overweight : Stage 1");
            mTreatmentMethodsText.setText(getString(R.string.stage1));
        }

        else if(stage == 2)
        {
            mBMILayout.setBackgroundResource(R.color.stage2);
            mBMIText.setText(String.valueOf(BMI));
            stageText.setText("According to the AACE/ACE ALGORITHM FOR THE MEDICAL CARE OF PATIENTS WITH OBESITY, you fall under the Stage 2 category due to the following reasons:");
            for(String tmp : reasons){
                reasonsText = reasonsText + tmp + "\n";
            }
            stageReasons.setText(reasonsText);
            mTreatmentText.setText("Treatment:");
            mBMICase.setText("Overweight : Stage 2");
            mTreatmentMethodsText.setText(getString(R.string.stage2));
        }
    }
}

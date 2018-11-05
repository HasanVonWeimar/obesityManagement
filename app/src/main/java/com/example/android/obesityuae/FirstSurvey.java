package com.example.android.obesityuae;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Rect;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import static com.example.android.obesityuae.R.array.country_arrays;

public class FirstSurvey extends AppCompatActivity {

    private ImageButton maleButton;
    private ImageButton femaleButton;
    private ImageButton singleButton;
    private ImageButton marriedButton;
    private ImageButton divorcedButton;
    private ImageButton urbanButton;
    private ImageButton ruralButton;
    private ImageButton tenButton;
    private ImageButton twentyButton;
    private ImageButton moreThanTwentButton;
    private Button mNext;
    private EditText date;
    private EditText weight, height, waist;
    private ProgressBar mProgress;
    private TextView mProgressTxt;
    private DatePickerDialog datePickerDialog;
    private String[] countries;
    private String[] cities;
    private Person person;
    private ScrollView myScroll;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_survey);

        maleButton = (ImageButton) findViewById(R.id.surveyMale);
        femaleButton = (ImageButton) findViewById(R.id.surveyfemale);
        singleButton = (ImageButton) findViewById(R.id.surveySingle);
        marriedButton = (ImageButton) findViewById(R.id.surveyMarried);
        divorcedButton = (ImageButton) findViewById(R.id.surveyDivorced);
        urbanButton = (ImageButton) findViewById(R.id.surveyRural);
        ruralButton = (ImageButton) findViewById(R.id.surveyUrban);
        tenButton = (ImageButton) findViewById(R.id.surveylessThanTen);
        twentyButton = (ImageButton) findViewById(R.id.surveyTwenty);
        moreThanTwentButton = (ImageButton) findViewById(R.id.surveyGreaterThanTwenty);
        mNext = (Button) findViewById(R.id.pageOneNext);
        date = (EditText) findViewById(R.id.surveyAge);
        height = (EditText) findViewById(R.id.surveyHeight);
        weight = (EditText) findViewById(R.id.surveyWeight);
        waist = (EditText) findViewById(R.id.surveyWaist);
        person = new Person();
        mProgress = (ProgressBar)findViewById(R.id.progressBarId);
        mProgressTxt = (TextView)findViewById(R.id.progressTxt1);
        myScroll = (ScrollView)findViewById(R.id.FirstScrollView);
        final AudioManager audio = (AudioManager) this.getSystemService(Context.AUDIO_SERVICE);
        final MediaPlayer mp = MediaPlayer.create(this, R.raw.myclicksound);

        startFirstSurvey();


        maleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(audio.getRingerMode() == AudioManager.RINGER_MODE_NORMAL)
                    mp.start();
                selectGender(0);
            }
        });

        femaleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(audio.getRingerMode() == AudioManager.RINGER_MODE_NORMAL)
                    mp.start();
                selectGender(1);
            }
        });


        singleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(audio.getRingerMode() == AudioManager.RINGER_MODE_NORMAL)
                    mp.start();
                martialStat(0);
            }
        });

        marriedButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(audio.getRingerMode() == AudioManager.RINGER_MODE_NORMAL)
                    mp.start();
                martialStat(1);
            }
        });

        divorcedButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(audio.getRingerMode() == AudioManager.RINGER_MODE_NORMAL)
                    mp.start();
                martialStat(2);
            }
        });

        ruralButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(audio.getRingerMode() == AudioManager.RINGER_MODE_NORMAL)
                    mp.start();
                cityType(0);
            }
        });

        urbanButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(audio.getRingerMode() == AudioManager.RINGER_MODE_NORMAL)
                    mp.start();
                cityType(1);
            }
        });

        tenButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(audio.getRingerMode() == AudioManager.RINGER_MODE_NORMAL)
                    mp.start();
                selectIncome(0);
            }
        });

        twentyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(audio.getRingerMode() == AudioManager.RINGER_MODE_NORMAL)
                    mp.start();
                selectIncome(1);
            }
        });

        moreThanTwentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(audio.getRingerMode() == AudioManager.RINGER_MODE_NORMAL)
                    mp.start();
                selectIncome(2);
            }
        });


        Context mContext;
        mContext = FirstSurvey.this;

        countries = mContext.getResources().getStringArray(country_arrays);
        cities = mContext.getResources().getStringArray(R.array.city_arrays);

        final Spinner natioanlitySpinner = (Spinner) findViewById(R.id.surveyNationality);
        final List<String> countryList = new ArrayList<>(Arrays.asList(countries));

        final ArrayAdapter<String> countryAdapter = new ArrayAdapter<String>(
                this, R.layout.my_spinner_lay, countryList) {
            @Override
            public boolean isEnabled(int position) {
                if (position == 0) {
                    // Disable the first item from Spinner
                    // First item will be use for hint
                    return false;
                } else {
                    return true;
                }
            }

            @Override
            public View getDropDownView(int position, View convertView,
                                        ViewGroup parent) {
                View view = super.getDropDownView(position, convertView, parent);
                TextView tv = (TextView) view;
                if (position == 0) {
                    // Set the hint text color gray
                    tv.setTextColor(Color.GRAY);
                } else {
                    tv.setTextColor(Color.BLACK);
                }
                return view;
            }
        };
        countryAdapter.setDropDownViewResource(R.layout.my_spinner_lay);
        natioanlitySpinner.setAdapter(countryAdapter);

        natioanlitySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                person.setNationality(natioanlitySpinner.getSelectedItemPosition());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        if(person.getNationality()!=-1)
        {
            natioanlitySpinner.setSelection(person.getNationality());
        }


        final Spinner citySpinner = (Spinner) findViewById(R.id.surveyCity);
        final List<String> cityList = new ArrayList<>(Arrays.asList(cities));
        final ArrayAdapter<String> cityAdapter = new ArrayAdapter<String>(FirstSurvey.this,
                com.example.android.obesityuae.R.layout.my_spinner_lay, cityList) {
            @Override
            public boolean isEnabled(int position) {
                if (position == 0) {
                    // Disable the first item from Spinner
                    // First item will be use for hint
                    return false;
                } else {
                    return true;
                }
            }

            @Override
            public View getDropDownView(int position, View convertView,
                                        ViewGroup parent) {
                View view = super.getDropDownView(position, convertView, parent);
                TextView tv = (TextView) view;
                if (position == 0) {
                    // Set the hint text color gray
                    tv.setTextColor(Color.GRAY);
                } else {
                    tv.setTextColor(Color.BLACK);
                }
                return view;
            }
        };
        cityAdapter.setDropDownViewResource(R.layout.my_spinner_lay);
        citySpinner.setAdapter(cityAdapter);

        citySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                person.setResidence(citySpinner.getSelectedItemPosition());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        if(person.getResidence()!=-1)
        {
            citySpinner.setSelection(person.getResidence());
        }

        // perform click event on edit text
        date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // calender class's instance and get current date , month and year from calender
                final Calendar c = Calendar.getInstance();
                int mYear = c.get(Calendar.YEAR); // current year
                int mMonth = c.get(Calendar.MONTH); // current month
                int mDay = c.get(Calendar.DAY_OF_MONTH); // current day
                // date picker dialog
                datePickerDialog = new DatePickerDialog(FirstSurvey.this,
                        new DatePickerDialog.OnDateSetListener() {

                            @Override
                            public void onDateSet(DatePicker view, int year,
                                                  int monthOfYear, int dayOfMonth) {
                                // set day of month , month and year value in the edit text
                                date.setText(dayOfMonth + "/"
                                        + (monthOfYear + 1) + "/" + year);
                                person.setDay(dayOfMonth);
                                person.setMonth(monthOfYear);
                                person.setYear(year);
                            }
                        }, mYear, mMonth, mDay);
                datePickerDialog.show();
            }
        });


        mNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(audio.getRingerMode() == AudioManager.RINGER_MODE_NORMAL)
                    mp.start();
                if((height.getText().toString()).length() > 0) {
                    person.setHeight(Double.valueOf(height.getText().toString()));
                }
                  /* if(person.getHeight() == 555)
                    {
                       Intent intent = new Intent(FirstSurvey.this, SecondSurvey.class);
                        startActivity(intent);
                    }*/


               /* if((weight.getText().toString()).length() > 0) {
                    if (person.getWeight() == 125) {
                        person.setWeight(125);
                        Intent intent = new Intent(FirstSurvey.this, SecondSurvey.class);
                        startActivity(intent);
                    }
                }*/
                if((weight.getText().toString()).length() > 0)
                    person.setWeight(Double.valueOf(weight.getText().toString()));
                if((waist.getText().toString()).length() > 0)
                    person.setWaist(Integer.valueOf(waist.getText().toString()));

                Intent intent = new Intent(FirstSurvey.this, SecondSurvey.class);
                intent.putExtra("patient", person);
                startActivity(intent);

                if(checkSurvey()) {

                    if(person.getProgress()==0) {
                        person.setProgress(25);
                        person.setProgressText("25%");
                    }
                  /*  Intent intent = new Intent(FirstSurvey.this, SecondSurvey.class);
                    startActivity(intent);*/
                }
            }
        });


    }

    private void startFirstSurvey()
    {
        Intent intent = getIntent();

        if (intent.hasExtra("patient")) {
            Log.d("intenttt","works fine");
            person = (Person)intent.getSerializableExtra("patient");
        }

        mProgress.setProgress(person.getProgress());
        mProgressTxt.setText(person.getProgressText());
        selectGender(person.getGender());
        martialStat(person.getMartial());
        cityType(person.getResidenceType());
        selectIncome(person.getIncome());

        if(person.getDay() != -1 && person.getMonth() != -1 && person.getYear() != -1)
        {
            date.setText(person.getDay() + "/"
                    + (person.getMonth() + 1) + "/" + person.getYear());
        }

        if(person.getHeight()!= -1)
        {
            height.setText(String.valueOf((person.getHeight())));
        }

        if(person.getWeight()!= -1)
        {
            weight.setText(String.valueOf((person.getWeight())));
        }

        if(person.getWaist()!= -1)
        {
            waist.setText(String.valueOf((person.getWaist())));
        }
    }

    private void selectGender(int genderStorage) {
        if (genderStorage == 0) {
            maleButton.setBackgroundResource(R.drawable.circularclicked);
            femaleButton.setBackgroundResource(R.drawable.circular);
            person.setGender(0);
        } else if(genderStorage==1){
            femaleButton.setBackgroundResource(R.drawable.circularclicked);
            maleButton.setBackgroundResource(R.drawable.circular);
            person.setGender(1);
        }
    }

    private void martialStat(int stat) {
        if (stat == 0) {
            singleButton.setBackgroundResource(R.drawable.circularclicked);
            marriedButton.setBackgroundResource(R.drawable.circular);
            divorcedButton.setBackgroundResource(R.drawable.circular);
            person.setMartial(0);
        } else if (stat == 1) {
            singleButton.setBackgroundResource(R.drawable.circular);
            marriedButton.setBackgroundResource(R.drawable.circularclicked);
            divorcedButton.setBackgroundResource(R.drawable.circular);
            person.setMartial(1);
        } else if(stat == 2){
            singleButton.setBackgroundResource(R.drawable.circular);
            marriedButton.setBackgroundResource(R.drawable.circular);
            divorcedButton.setBackgroundResource(R.drawable.circularclicked);
            person.setMartial(2);
        }
    }

    private void cityType(int type) {
        if (type == 0) {
            ruralButton.setBackgroundResource(R.drawable.circularclicked);
            urbanButton.setBackgroundResource(R.drawable.circular);
            person.setResidenceType(0);
        } else if(type == 1) {
            ruralButton.setBackgroundResource(R.drawable.circular);
            urbanButton.setBackgroundResource(R.drawable.circularclicked);
            person.setResidenceType(1);
        }
    }

    private void selectIncome(int income) {
        if (income == 0) {
            tenButton.setBackgroundResource(R.drawable.circularclicked);
            twentyButton.setBackgroundResource(R.drawable.circular);
            moreThanTwentButton.setBackgroundResource(R.drawable.circular);
            person.setIncome(0);
        } else if (income == 1) {
            tenButton.setBackgroundResource(R.drawable.circular);
            twentyButton.setBackgroundResource(R.drawable.circularclicked);
            moreThanTwentButton.setBackgroundResource(R.drawable.circular);
            person.setIncome(1);
        } else if(income == 2){
            tenButton.setBackgroundResource(R.drawable.circular);
            twentyButton.setBackgroundResource(R.drawable.circular);
            moreThanTwentButton.setBackgroundResource(R.drawable.circularclicked);
            person.setIncome(2);
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

    private boolean checkSurvey()
    {
        int checker;
        double checker2;
        if((height.getText().toString()).length() <= 0) {
            Toast.makeText(this, "Missing Height", Toast.LENGTH_SHORT).show();
            return false;
        }

        checker2 = Double.valueOf(height.getText().toString());

        if(checker2 < 50 || checker2 > 253)
        {
            Toast.makeText(this, "Invalid Height", Toast.LENGTH_SHORT).show();
            return false;
        }


        if((weight.getText().toString()).length() <= 0){
            Toast.makeText(this, "Missing Weight", Toast.LENGTH_SHORT).show();
            return false;
        }

        checker2 = Double.valueOf(weight.getText().toString());

        if(checker2 < 25 || checker2 > 442)
        {
            Toast.makeText(this, "Invalid Weight", Toast.LENGTH_SHORT).show();
            return false;
        }

        if((waist.getText().toString()).length() <= 0){
            Toast.makeText(this, "Missing Waist", Toast.LENGTH_SHORT).show();
            return false;
        }

        checker = Integer.valueOf(waist.getText().toString());

        if(checker < 53 || checker > 300)
        {
            Toast.makeText(this, "Invalid Waist Circumference", Toast.LENGTH_SHORT).show();
            return false;
        }

        if(person.getDay() == -1 || person.getMonth() == -1 || person.getYear() == -1)
        {
            Toast.makeText(this, "Missing Age", Toast.LENGTH_SHORT).show();
            return false;
        }
        else
        {
            Calendar DOB = Calendar.getInstance();
            Calendar today = Calendar.getInstance();

            DOB.set(person.getYear(), person.getMonth(), person.getDay());

            int age = today.get(Calendar.YEAR) - DOB.get(Calendar.YEAR);

            if(DOB.get(Calendar.MONTH) < today.get(Calendar.MONTH))
            {
                age--;
            }
            else
            {
                if(DOB.get(Calendar.DAY_OF_MONTH) < today.get(Calendar.DAY_OF_MONTH))
                {
                    Log.d("date", String.valueOf(DOB.get(Calendar.DAY_OF_MONTH)));
                    Log.d("date", String.valueOf(DOB.get(Calendar.DATE)));
                    age--;
                }
            }

        if(age < 14 || age > 122)
        {
            Toast.makeText(this, "Invalid Age", Toast.LENGTH_SHORT).show();
            return false;
        }

        }

        if(person.getGender() == -1)
        {
            Toast.makeText(this, "Missing Gender", Toast.LENGTH_SHORT).show();
            return false;
        }

        if(person.getMartial() == -1)
        {
            Toast.makeText(this, "Missing Martial Status", Toast.LENGTH_SHORT).show();
            return false;
        }

        if(person.getNationality() == -1 || person.getNationality() == 0)
        {
            Toast.makeText(this, "Missing Nationality", Toast.LENGTH_SHORT).show();
            return false;
        }

        if(person.getResidence() == -1 || person.getResidence() == 0)
        {
            Toast.makeText(this, "Missing City of Residence", Toast.LENGTH_SHORT).show();
            return false;
        }

        if(person.getResidenceType() == -1)
        {
            Toast.makeText(this, "Missing Residence Type", Toast.LENGTH_SHORT).show();
            return false;
        }

        if(person.getIncome() == -1)
        {
            Toast.makeText(this, "Missing House Income", Toast.LENGTH_SHORT).show();
            return false;
        }


        return true;
    }

}

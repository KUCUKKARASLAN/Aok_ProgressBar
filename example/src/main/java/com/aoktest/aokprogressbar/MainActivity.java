package com.aoktest.aokprogressbar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.aoktest.library.aok_Progress;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button buttonBack, buttonNext;
    aok_Progress progressTest, progressTest2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonBack = (Button) findViewById(R.id.buttonBack);
        buttonNext = (Button) findViewById(R.id.buttonNext);
        progressTest = (aok_Progress) findViewById(R.id.progressTest);
        progressTest2 = (aok_Progress) findViewById(R.id.progressTest2);

        buttonBack.setOnClickListener(this);
        buttonNext.setOnClickListener(this);

    }

    /**
     * Called when a view has been clicked.
     *
     * @param v The view that was clicked.
     */
    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.buttonNext:
                progressTest.setmProgresValue(progressTest.getmProgresValue() + 10);
                progressTest2.setmProgresValue(progressTest2.getmProgresValue() + 10);
                break;
            case R.id.buttonBack:
                progressTest.setmProgresValue(progressTest.getmProgresValue() - 10);
                progressTest2.setmProgresValue(progressTest2.getmProgresValue() - 10);
                break;

            default:break;

        }
    }
}

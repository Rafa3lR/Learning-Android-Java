package com.example.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView resultCand1;

    private TextView resultCand2;
    private TextView resultBranc;
    int numvot = 0;
    int cand1 = 0;
    int cand2 = 0;
    int branc = 0;
    String stgcand1 = "0";
    String stgcand2 = "0";
    String stgbranc = "0";
    String result1 = "0";
    String result2 = "0";
    String result3 = "0";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resultCand1 = findViewById(R.id.resultCand1);
        resultCand2 = findViewById(R.id.resultCand2);
        resultBranc = findViewById(R.id.resultBranc);
        String txtResultCand1 = stgcand1 + " - " + result1 + "%";
        String txtResultCand2 = stgcand2 + " - " + result2 + "%";
        String txtResultCand3 = stgbranc + " - " + result3 + "%";
        resultCand1.setText(txtResultCand1);
        resultCand2.setText(txtResultCand2);
        resultBranc.setText(txtResultCand3);
    }

    public void cand1Button(View view) {
        numvot++;
        cand1++;
        updateVotes();
    }

    public void cand2Button(View view2) {
        numvot ++;
        cand2++;
        updateVotes();
    }

    public void brancButton(View view3) {
        numvot ++;
        branc++;
        updateVotes();
    }

    public void updateVotes()
    {
        result1 = String.valueOf((cand1 * 100) / numvot);
        result2 = String.valueOf((cand2 * 100) / numvot);
        result3 = String.valueOf((branc * 100) / numvot);
        stgcand1 = String.valueOf(cand1);
        stgcand2 = String.valueOf(cand2);
        stgbranc = String.valueOf(branc);
        String txtResultCand1 = stgcand1 + " - " + result1 + "%";
        String txtResultCand2 = stgcand2 + " - " + result2 + "%";
        String txtResultCand3 = stgbranc + " - " + result3 + "%";
        resultCand1.setText(txtResultCand1);
        resultCand2.setText(txtResultCand2);
        resultBranc.setText(txtResultCand3);
    }

    public void reset(View view) {
        numvot = 0;
        cand1 = 0;
        cand2 = 0;
        branc = 0;
        result1 = "0";
        result2 = "0";
        result3 = "0";
        stgcand1 = "0";
        stgcand2 = "0";
        stgbranc = "0";
        String txtResultCand1 = stgcand1 + " - " + result1 + "%";
        String txtResultCand2 = stgcand2 + " - " + result2 + "%";
        String txtResultCand3 = stgbranc + " - " + result3 + "%";
        resultCand1.setText(txtResultCand1);
        resultCand2.setText(txtResultCand2);
        resultBranc.setText(txtResultCand3);
    }
}
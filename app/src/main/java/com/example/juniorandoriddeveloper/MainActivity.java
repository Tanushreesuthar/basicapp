package com.example.juniorandoriddeveloper;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
     EditText inches;
     Button calculate;
    TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findView();
        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String inchesText = inches.getText().toString();
                if(inchesText.isEmpty())
                { Toast.makeText(MainActivity.this,
                        "hey!please input some value" , Toast.LENGTH_SHORT).show();}
                else
                {double Result = calculateInchesToMeter(inchesText );
                displayResult(Result);
            }
    }
        });
    }

        private double calculateInchesToMeter(String inchesText) {
        int INCHES = Integer.parseInt(inchesText);
        return INCHES * 0.0254;
    }
        private void displayResult(double Ans) {
            DecimalFormat myDecimalFormatter = new DecimalFormat("0.00");
            String Result = myDecimalFormatter.format(Ans);
            result.setText(Result);

        }
        private void findView() {
        inches=findViewById(R.id.edit_text_inches);
        calculate=findViewById(R.id.button_calculate);
        result=findViewById(R.id.text_view_result);
    }


}
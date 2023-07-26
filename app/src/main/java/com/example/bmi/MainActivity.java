package com.example.bmi;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //declaration
    EditText etHeight, etWeight;
    Button btnCalculate;

    String height,weight;
   private RadioButton r1,r2;
    TextView tvMsg;
    ImageView ivResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        etHeight = findViewById(R.id.editTextHeight);
        etWeight = findViewById(R.id.editTextWeight);
        tvMsg = findViewById(R.id.textViewMessage);
        ivResult = findViewById(R.id.imageViewResult);
        btnCalculate = findViewById(R.id.buttonCalculate);
        r1 = findViewById(R.id.r1);
        r2 = findViewById(R.id.r2);




            btnCalculate.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                     height = etHeight.getText().toString().trim();
                     weight = etWeight.getText().toString().trim();


                    if (r1.isChecked()) {


                        if (TextUtils.isEmpty(height)) {
                            etHeight.setError("Height cannot be empty");
                            etHeight.requestFocus();
                            return;
                        } else if (TextUtils.isEmpty(weight)) {
                            etWeight.setError("Weight cannot be empty");
                            etWeight.requestFocus();
                        } else {

                            Float wt = Float.parseFloat(weight);
                            Float ht = Float.parseFloat(height) / 100;


                            float bmi = wt / (ht * ht);


                            if (bmi < 18) {

                                tvMsg.setText("Ahhh! You need to Gain Weight");
                                ivResult.setImageResource(R.drawable.under_weight);

                            }
                            if (bmi > 18.5 && bmi < 25) {
                                tvMsg.setText("Wow!!! You're an Fit Guy");
                                ivResult.setImageResource(R.drawable.fit_guy);

                            }
                            if (bmi > 25) {

                                tvMsg.setText("Naah!!! You're in Obese Condition");
                                ivResult.setImageResource(R.drawable.obese);
                            }
                        }


                        Toast.makeText(MainActivity.this, "Clicked", Toast.LENGTH_LONG).show();
                        etHeight.setText(null);
                        etWeight.setText(null);

                    }

                     if (r2.isChecked())
                    {
                        r1.setChecked(false);
                        if (TextUtils.isEmpty(height)) {
                            etHeight.setError("Height cannot be empty");
                            etHeight.requestFocus();
                            return;
                        } else if (TextUtils.isEmpty(weight)) {
                            etWeight.setError("Weight cannot be empty");
                            etWeight.requestFocus();
                        } else {

                            Float wt = Float.parseFloat(weight);
                            Float ht = Float.parseFloat(height) / 100;


                            float bmi = wt / (ht * ht);


                            if (bmi < 18) {

                                tvMsg.setText("Ahhh! You need to Gain Weight");
                                ivResult.setImageResource(R.drawable.low);

                            }
                            if (bmi > 18.5 && bmi < 25) {
                                tvMsg.setText("Wow!!! You're an Fit Guy");
                                ivResult.setImageResource(R.drawable.fit);

                            }
                            if (bmi > 25) {

                                tvMsg.setText("Naah!!! You're in Obese Condition");
                                ivResult.setImageResource(R.drawable.obes);
                            }
                        }


                        Toast.makeText(MainActivity.this, "Clicked ", Toast.LENGTH_LONG).show();
                        etHeight.setText(null);
                        etWeight.setText(null);

                    }
                }

            });
//            button.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//
//
//
//                    Intent i =new Intent(MainActivity.this,view.class);
//                    i.putExtra("key",height);
//                    i.putExtra("key1",weight);
//                    startActivity(i);
//                }
//            });
    }

}
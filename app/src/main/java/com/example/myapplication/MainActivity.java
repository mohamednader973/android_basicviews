package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView welcomeTv;
    EditText editText1;
    EditText editText2;
    Button button1;
    TextView changeTv;
    RatingBar rating;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        welcomeTv=findViewById(R.id.tv);
        editText1=findViewById(R.id.et);
        editText2=findViewById(R.id.et1);
        button1=findViewById(R.id.btn);
        RadioButton redRb=findViewById(R.id.red_rb);
        RadioButton whiteRb=findViewById(R.id.white_rb);
        RadioButton blackRb=findViewById(R.id.black_rb);
        changeTv=findViewById(R.id.changetext);
        rating=findViewById(R.id.ratingbar);
        rating.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                rating=ratingBar.getRating();
                Toast.makeText(MainActivity.this,rating+"",Toast.LENGTH_SHORT);
            }
        });
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email=editText1.getText().toString();
                String password=editText2.getText().toString();
                if (TextUtils.isEmpty(email) ||TextUtils.isEmpty(password)){

                    editText1.setError("this field can't be empty");
                    editText2.setError("this field can't be empty");

                }
                else {
                    Toast.makeText(MainActivity.this,"sign in",Toast.LENGTH_SHORT).show();
                    changeTv.setText("sign in");
                }

            }
        });
        redRb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"red is chosen",Toast.LENGTH_SHORT).show();
            }
        });
        whiteRb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"white is chosen",Toast.LENGTH_SHORT).show();
            }
        });
        blackRb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"black is chosen",Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void checkCb(View view) {
        boolean isCheckedCb =((CheckBox)view).isChecked();
        switch (view.getId()){
            case R.id.white_cb:
                if(isCheckedCb){
                    Toast.makeText(this,"white is checked",Toast.LENGTH_SHORT).show();
                }

                break;
            case R.id.red_cb:
                if (isCheckedCb){
                    Toast.makeText(this,"red is checked",Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.black_cb:
                if (isCheckedCb){
                    Toast.makeText(this,"black is checked",Toast.LENGTH_SHORT).show();
                }
                break;
        }

    }
}
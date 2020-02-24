package com.example.android_guess;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    public ImageView mImageView;
    public EditText mEditText1;
    public TextView mTextView1;
    public Random mRandom=new Random();
    public String str;
    private Handler mHandler;
    public int random;
    public int guess;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mImageView=(ImageView)findViewById(R.id.imageView1);
        mEditText1=(EditText)findViewById(R.id.EditText1);
        mImageView.setOnClickListener(this);
       GetRandomValue();
    }

    @Override
    public void onClick(View v) {
        Getguessvalue();
        switch(v.getId()){
            case R.id.imageView1:
                if (guess>0&&guess<10000){
                    setContentView(R.layout.guess_one);
                    mTextView1=(TextView)findViewById(R.id.TextView1);
                    ChageTextValue();
                    mImageView=(ImageView)findViewById(R.id.imageView2);
                    mImageView.setOnClickListener(this);
                }
                break;
            case R.id.imageView2:
                if(random==guess){
                    setContentView(R.layout.guess_two);
                    mTextView1=(TextView)findViewById(R.id.TextView2);
                    mTextView1.setText(String.valueOf(random));
                    mImageView=(ImageView)findViewById(R.id.imageView3);
                    mImageView.setOnClickListener(this);
                }
                else if(random>guess){
                    setContentView(R.layout.guess_three);
                    mTextView1=(TextView)findViewById(R.id.TextView3);
                    ChageTextValue();
                    mImageView=(ImageView)findViewById(R.id.imageView4);
                    mImageView.setOnClickListener(this);
                }
                else{
                    setContentView(R.layout.guess_four);
                    mTextView1=(TextView)findViewById(R.id.TextView4);
                    ChageTextValue();
                    mImageView=(ImageView)findViewById(R.id.imageView5);
                    mImageView.setOnClickListener(this);
                }
                break;
            case R.id.imageView3:
                setContentView(R.layout.activity_main);
                GetRandomValue();
                Getguessvalue();
                mImageView=(ImageView)findViewById(R.id.imageView1);
                mImageView.setOnClickListener(this);
                break;
            case R.id.imageView4:{
                setContentView(R.layout.activity_main);
                Getguessvalue();
                mImageView=(ImageView)findViewById(R.id.imageView1);
                mImageView.setOnClickListener(this);
                }
                break;
            case R.id.imageView5:{
                setContentView(R.layout.activity_main);
                mImageView=(ImageView)findViewById(R.id.imageView1);
                mImageView.setOnClickListener(this);
                Getguessvalue();
                }
                break;
        }
    }

    public void GetRandomValue(){
        random=0;
        while(random==0){
            random=mRandom.nextInt(10000);
            System.out.println("randomnumber:"+random);
        }
    }

    public void Getguessvalue(){
        try{

            mEditText1=(EditText)findViewById(R.id.EditText1);
            str=mEditText1.getText().toString();
            guess=new Integer(str).intValue();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void ChageTextValue(){
        try{
            //mTextView1=(TextView)findViewById(R.id.TextView1);
            mTextView1.setText(String.valueOf(guess));
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}



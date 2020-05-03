package com.example.project;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class moviedetails extends AppCompatActivity {


    String data1,data2,data3,data4,data5,data6;
    int imageid;
    boolean click=false;
    CheckBox checkBox;
    Parcelable  fav;
    TextView tx1,tx2,tx3,tx4,tx5,tx6;
    ImageView imageViewe;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_moviedetails);
        tx1=findViewById(R.id.editText);
        tx2=findViewById(R.id.editText2);
        tx3=findViewById(R.id.editText3);
        tx4=findViewById(R.id.editText4);
        tx5=findViewById(R.id.Runtime1);
        tx6=findViewById(R.id.textView5);
        imageViewe=findViewById(R.id.imageView2);
        getData();
        setData();
        checkBox =findViewById(R.id.checkBox);
        checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(moviedetails.this,recentlywatched.class);
                if(checkBox.isChecked())
                {
                    intent.putExtra("ADD", fav);
                }
                else
                {
                    intent.putExtra("REMOVE", fav);
                }
                startActivity(intent);
            }
        });
        final Button btn=findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent intent=new Intent(moviedetails.this,favourites.class);
                if(click==false) {
                    intent.putExtra("ADD", fav);
                    click=true;
                    btn.setBackgroundResource(R.drawable.ic_favorite_black_24dp);
                }
                else
                {
                    intent.putExtra("REMOVE", fav);
                    click=false;
                   btn.setBackgroundResource(R.drawable.ic_favorite_border_black_24dp);
                }
                startActivity(intent);
            }
        });
    }
    private void getData()
    {
        if(getIntent().hasExtra("moviename") && getIntent().hasExtra("movierating")&&getIntent().hasExtra("moviegenre")&&getIntent().hasExtra("moviedescription")&& getIntent().hasExtra("movieimg"))
        {

                    data1=getIntent().getStringExtra("moviename");
                    fav=getIntent().getParcelableExtra("movie");
                    data2=getIntent().getStringExtra("movierating");
                    data3=getIntent().getStringExtra("moviegenre");
                    data4=getIntent().getStringExtra("moviedescription");
                    data5=getIntent().getStringExtra("movietime");
                    data6=getIntent().getStringExtra("moviedate");
                    imageid=getIntent().getIntExtra("movieimg",1);
        }
        else
            Toast.makeText(this,"no data",Toast.LENGTH_SHORT).show();
    }
    private void setData()
    {
        tx1.setText(data1);
        tx2.setText(data2);
        tx3.setText(data3);
        tx4.setText(data4);
        tx5.setText(data5);
        tx6.setText(data6);
        imageViewe.setImageResource(imageid);
    }
}

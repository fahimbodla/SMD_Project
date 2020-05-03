package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class signup extends AppCompatActivity {

    ImageView img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

       Button btn=findViewById(R.id.button12);
        img=findViewById(R.id.imagebutton2);
        Button button=findViewById(R.id.signupbutton);
        button.setOnClickListener(new View.OnClickListener() {
    @Override
      public void onClick(View v) {
        Intent in=new Intent(signup.this,login.class);
        startActivity(in);
    }
});
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in=new Intent(signup.this,login.class);
                startActivity(in);
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in=new Intent(signup.this,login.class);
                startActivity(in);
            }
        });
    }
}

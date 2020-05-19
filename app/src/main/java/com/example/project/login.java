package com.example.project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.media.MediaCodec;
import android.os.Bundle;
import android.util.Patterns;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class login extends AppCompatActivity {
    FirebaseAuth firebaseAuth;
    private  FirebaseAuth mAuth;
    EditText em;EditText pass;
    ProgressDialog  progressDialog;
    Button login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
       Button btn=(Button)findViewById(R.id.New);
       em=findViewById(R.id.editText3);
       pass=findViewById(R.id.editText4);
       mAuth=FirebaseAuth.getInstance();

       firebaseAuth=FirebaseAuth.getInstance();
         login=(Button)findViewById(R.id.loginbutton);
         progressDialog=new ProgressDialog(this);
         progressDialog.setMessage("Loggin in");
         login.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 String email=em.getText().toString();
                 String password=pass.getText().toString().trim();
                 if(!Patterns.EMAIL_ADDRESS.matcher(email).matches())
                 {
                     em.setError("iNVALID EMAIL");
                     em.setFocusable(true);
                 }
                 else
                 {
                     loginUser(email,password);
                 }
             }

             private void loginUser(String email, String password)
             {
                 progressDialog.show();
                 mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(login.this, new OnCompleteListener<AuthResult>() {
                             @Override
                             public void onComplete(@NonNull Task<AuthResult> task) {
                                 if (task.isSuccessful()) {
                                     // Sign in success, update UI with the signed-in user's informationFirebaseUser user = mAuth.getCurrentUser();
                                 progressDialog.dismiss();
                                 FirebaseUser user=mAuth.getCurrentUser();
                                 startActivity(new Intent(login.this,MainActivity.class));
                                 finish();
                                 } else {
                                     // If sign in fails, display a message to the user.
                                  progressDialog.dismiss();
                                     Toast.makeText(login.this, "Authentication failed.",
                                             Toast.LENGTH_SHORT).show();

                                 }

                                 // ...
                             }
                         }).addOnFailureListener(new OnFailureListener() {
                     @Override
                     public void onFailure(@NonNull Exception e) {
                         Toast.makeText(login.this,""+e.getMessage(),Toast.LENGTH_SHORT).show();
                     }
                 });
             }
         });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in=new Intent(login.this,signup.class);
                startActivity(in);
            }
        });
    }




}


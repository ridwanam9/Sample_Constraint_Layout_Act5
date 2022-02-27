package com.example.sampleconstraintlayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    //Deklarasi variabel untuk button
    Button btnLogin;

    //Deklarasi variabel untuk EditText
    EditText edemail, edpassword;

    //Deklarasi variabel untuk menyimpan email dan password
    String nama, password;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Menghubungkan variabel btnlogin dengan Componen button pada layout
        btnLogin=findViewById(R.id.btSignin);

        //Menghubungkan variabel btnlogin dengan Componen editext1 pada layout
        edemail=findViewById(R.id.edEmail);

        //Menghubungkan variabel btnlogin dengan Componen editext2 pada layout
        edpassword=findViewById(R.id.edPassword);

        //membuat fungsi onclick pada button btnLogin
        btnLogin.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {

                //menyimpan input user di edittext email ke dalam variabel nama
                nama = edemail.getText().toString();

                //menyimpan input user di edittext password ke dalam variabel password
                password = edpassword.getText().toString();

                String email = "admin@mail.com";

                String pass = "123";

                if (nama.isEmpty() && password.isEmpty()) {

                    Toast t = Toast.makeText(getApplicationContext(), "Email dan password", Toast.LENGTH_LONG);

                    t.show();
                } else {

                    if (nama.equals(email) && password.equals(pass)) {

                        Toast t = Toast.makeText(getApplicationContext(), "Login Sukses", Toast.LENGTH_LONG);


                        t.show();

                        Bundle b = new Bundle();

                        b.putString("a", nama.trim());

                        b.putString("b", password.trim());

                        //Intent i = new Intent(getApplicationContext(), ActivityKedua.class);
                        Intent i = new Intent(getApplicationContext(), Home_Activity.class);

                        i.putExtras(b);

                        startActivity(i);

                    } else {
                        Toast t = Toast.makeText(getApplicationContext(), "Login Gagal", Toast.LENGTH_LONG);
                        t.show();
                    }
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.mnDaftar){

            Intent i = new Intent(getApplicationContext(), DaftarActivity.class);
            startActivity(i);
        }

        return super.onOptionsItemSelected(item);
    }
}
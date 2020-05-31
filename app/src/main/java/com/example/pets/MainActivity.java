package com.example.pets;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void registerView(View view){

        Intent intent = new Intent (this, PetRegister.class);
        String message = "register";
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }

    public void searchView(View view){

        Intent intent = new Intent (this, PetRegister.class);
        String message = "search";
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }

    public void deleterView(View view){

        Intent intent = new Intent (this, PetRegister.class);
        String message = "delete";
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }

    public void updaterView(View view){

        Intent intent = new Intent (this, PetRegister.class);
        String message = "update";
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }
}

package com.example.pets;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.example.pets.utilidades.Utilidades;
public class PetRegister extends AppCompatActivity {
    EditText campoName, campoAge, campoOwner, campoPhone, campoId;
    Button delete, update, insert, search;
    private int id = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pet_register);
        campoName = (EditText) findViewById(R.id.petName);
        campoOwner = (EditText) findViewById(R.id.owner);
        campoPhone = (EditText) findViewById(R.id.phone);
        campoAge = (EditText) findViewById(R.id.age);
        campoId = (EditText) findViewById(R.id.idPet);
        delete = (Button) findViewById(R.id.deleteBtn);
        update = (Button) findViewById(R.id.update);
        insert = (Button) findViewById(R.id.saveBtn);
        search = (Button) findViewById(R.id.search);
        Intent intent = getIntent();
        String v = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        //Toast.makeText(getApplicationContext(),"id Resultante: "  +v, Toast.LENGTH_SHORT).show();
        checkBtn(v);




    }
    public void onClick(View view){
        registerPets();
    }

    public void back(){

    }

    //Para que solo aparezca el boton correspondiente
    public void checkBtn(String v){


        switch (v) {
            case "register": {
                update.setVisibility(View.INVISIBLE);
                delete.setVisibility(View.INVISIBLE);
                insert.setVisibility(View.VISIBLE);
                search.setVisibility(View.INVISIBLE);

            }
            break;
            case "delete":
                update.setVisibility(View.INVISIBLE);
                delete.setVisibility(View.VISIBLE);
                insert.setVisibility(View.INVISIBLE);
                search.setVisibility(View.INVISIBLE);

                break;
            case "update": {
                update.setVisibility(View.VISIBLE);
                delete.setVisibility(View.INVISIBLE);
                insert.setVisibility(View.INVISIBLE);
                search.setVisibility(View.INVISIBLE);

            }
            break;
            case "search": {
                update.setVisibility(View.INVISIBLE);
                delete.setVisibility(View.INVISIBLE);
                insert.setVisibility(View.INVISIBLE);
                search.setVisibility(View.VISIBLE);
            }
            break;

        }
    }

    private void registerPets() {

        ConexionSQLiteHelper conection = new ConexionSQLiteHelper(this, "db_pets",null,1);
        SQLiteDatabase db = conection.getWritableDatabase(); // para escribir en la base de datos

        //id+=1;
        ContentValues values = new ContentValues();
        values.put(Utilidades.CAMPO_ID, campoId.getText().toString()); //insertarlo en la tabla
        values.put(Utilidades.CAMPO_NAME, campoName.getText().toString());
        values.put(Utilidades.CAMPO_AGE, campoAge.getText().toString());
        values.put(Utilidades.CAMPO_OWNER, campoOwner.getText().toString());
        values.put(Utilidades.CAMPO_PHONE, campoPhone.getText().toString());

        Long idResult = db.insert(Utilidades.TABLA_PETS, Utilidades.CAMPO_ID,values);
        Toast.makeText(getApplicationContext(),"id Resultante: "  +idResult, Toast.LENGTH_SHORT).show();


        db.close();
        campoAge.setText("");
        campoPhone.setText("");
        campoName.setText("");
        campoOwner.setText("");
        campoId.setText("");

    }




    public void buscar(View view) {
        ConexionSQLiteHelper conection = new ConexionSQLiteHelper(getApplicationContext(), "db_pets", null, 1);
        SQLiteDatabase db = conection.getReadableDatabase(); // para escribir en la base de datos

        String[] consultar = {Utilidades.CAMPO_AGE, Utilidades.CAMPO_OWNER, Utilidades.CAMPO_PHONE, Utilidades.CAMPO_NAME};
        String[] nombre = {campoId.getText().toString()};

        try {

            Cursor cursor = db.query(Utilidades.TABLA_PETS, consultar, Utilidades.CAMPO_ID + "=?", nombre, null, null, null);
            cursor.moveToFirst();
            campoAge.setText(cursor.getString(0));
            campoPhone.setText(cursor.getString(2));
            campoOwner.setText(cursor.getString(1));
            campoName.setText(cursor.getString(3));

            cursor.close();

        } catch (Exception e) {
            Toast.makeText(getApplicationContext(), "no existe", Toast.LENGTH_LONG).show();

        }
    }


    public void update(View view){
        ConexionSQLiteHelper conection = new ConexionSQLiteHelper(getApplicationContext(), "db_pets", null, 1);
        SQLiteDatabase db = conection.getWritableDatabase();
        String[] update = {campoId.getText().toString()};
        ContentValues values = new ContentValues();
        values.put(Utilidades.CAMPO_NAME, campoName.getText().toString());
        values.put(Utilidades.CAMPO_AGE, campoAge.getText().toString());
        values.put(Utilidades.CAMPO_OWNER, campoOwner.getText().toString());
        values.put(Utilidades.CAMPO_PHONE, campoPhone.getText().toString());

        db.update(Utilidades.TABLA_PETS, values,Utilidades.CAMPO_ID+"=?",update);

        //Long idResult = db.insert(Utilidades.TABLA_PETS, Utilidades.CAMPO_ID,values);
        Toast.makeText(getApplicationContext(),"id modificado: "  + campoId.getText().toString(), Toast.LENGTH_SHORT).show();


        db.close();
        campoAge.setText("");
        campoPhone.setText("");
        campoName.setText("");
        campoOwner.setText("");
    }

    public void delete(View view){
        ConexionSQLiteHelper conection = new ConexionSQLiteHelper(getApplicationContext(), "db_pets", null, 1);
        SQLiteDatabase db = conection.getWritableDatabase();
        String[] delete = {campoId.getText().toString()};
        db.delete(Utilidades.TABLA_PETS, Utilidades.CAMPO_ID+"=?", delete);
        Toast.makeText(getApplicationContext(),"id eliminado "  , Toast.LENGTH_SHORT).show();
        db.close();
        campoAge.setText("");
        campoPhone.setText("");
        campoName.setText("");
        campoOwner.setText("");

    }
}



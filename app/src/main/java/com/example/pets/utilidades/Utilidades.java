package com.example.pets.utilidades;

public class Utilidades {
    public static final String TABLA_PETS = "pets";
    public static final String CAMPO_ID = "id";
    public static final String CAMPO_NAME = "Name";
    public static final String CAMPO_AGE = "Age";
    public static final String CAMPO_OWNER = "Owner";
    public static final String CAMPO_PHONE = "Phone";


    public static final String CREATE_TABLE_PETS = "CREATE TABLE "+ TABLA_PETS +
            "(" + CAMPO_ID +" INTEGER," +
            CAMPO_NAME +" TEXT,"+
            CAMPO_AGE +" INTEGER," +
            CAMPO_OWNER +" TEXT,"+
            CAMPO_PHONE+ " TEXT)";
}

package com.example.cronoeduca;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

import java.util.ArrayList;
public class UsuarioSQLiteOpenHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "usuarios.db";
    private static final int DATABASE_VERSION = 1;

    public UsuarioSQLiteOpenHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE usuarios(" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "nombre TEXT NOT NULL," +
                "email TEXT NOT NULL," +
                "password TEXT NOT NULL)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Aquí manejarías cualquier cambio en la estructura de la base de datos para nuevas versiones de la app.
    }


    public boolean usuarioRegistrado(String email, String password) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT id FROM usuarios WHERE email = ? AND password = ?", new String[]{email, password});
        int count = cursor.getCount();
        cursor.close();
        db.close();
        return count > 0;
    }

}


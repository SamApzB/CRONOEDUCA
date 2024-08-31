package com.example.cronoeduca;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class CrearCuenta extends AppCompatActivity {

    private EditText etNombre, etEmail, etPassword, etConfirmPassword;
    private Button btnRegistrar;
    private UsuarioSQLiteOpenHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_cuenta);

        dbHelper = new UsuarioSQLiteOpenHelper(this);
        etNombre = findViewById(R.id.editTextText);
        etEmail = findViewById(R.id.Email);
        etPassword = findViewById(R.id.Passwordq);
        etConfirmPassword = findViewById(R.id.Password);

        btnRegistrar = findViewById(R.id.button);
        btnRegistrar.setOnClickListener(this::registrarUsuario);
    }

    private void registrarUsuario(View view) {
        String nombre = etNombre.getText().toString();
        String email = etEmail.getText().toString();
        String password = etPassword.getText().toString();
        String confirmPassword = etConfirmPassword.getText().toString();

        if (nombre.isEmpty() || email.isEmpty() || password.isEmpty() || !password.equals(confirmPassword)) {
            Toast.makeText(this, "Por favor, complete los campos correctamente.", Toast.LENGTH_SHORT).show();
            return;
        }

        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("nombre", nombre);
        values.put("email", email);
        values.put("password", password);

        long id = db.insert("usuarios", null, values);
        if (id > 0) {
            Toast.makeText(this, "Usuario registrado con éxito.", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Error al registrar el usuario.", Toast.LENGTH_SHORT).show();
        }
        db.close();
    }
}

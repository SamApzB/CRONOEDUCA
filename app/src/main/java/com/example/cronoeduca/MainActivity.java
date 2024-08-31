package com.example.cronoeduca;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText etEmail, etPassword;
    private UsuarioSQLiteOpenHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etEmail = findViewById(R.id.Email);
        etPassword = findViewById(R.id.Password);
        dbHelper = new UsuarioSQLiteOpenHelper(this);
    }

    public void onClickMenu(View v) {
        String email = etEmail.getText().toString();
        String password = etPassword.getText().toString();

        if (dbHelper.usuarioRegistrado(email, password)) {

            Intent intent = new Intent(MainActivity.this, MenuPrincipal.class);
            startActivity(intent);
        } else {
            Toast.makeText(this, "Credenciales inválidas o usuario no registrado", Toast.LENGTH_LONG).show();
        }
    }

    public void onClick(View v) {
        Intent intent = new Intent(MainActivity.this, CrearCuenta.class);
        startActivity(intent);
    }
}

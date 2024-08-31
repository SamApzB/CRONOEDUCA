package com.example.cronoeduca;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class CrearHorario extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_crear_horario);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    public void onClickCurso(View v) {
        Intent intent = new Intent( CrearHorario.this, InterfazCurso.class);
        startActivity(intent);
    }
    public void onClickDocentes(View v) {
        Intent intent = new Intent(CrearHorario.this, InterfazDocentes.class);
        startActivity(intent);
    }
    public void onClickEventos(View v) {
        Intent intent = new Intent(CrearHorario.this, InterfazEventos.class);
        startActivity(intent);
    }
}
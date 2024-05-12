package com.example.npc_studio;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class FichaPronta extends AppCompatActivity {

    private ListView fichaPronta;
    private Button salvar_ficha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow()
                .setFlags(
                        WindowManager.LayoutParams.FLAG_FULLSCREEN,
                        WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.ficha_pronta);

        fichaPronta = findViewById(R.id.list_ficha_npc);
        salvar_ficha = findViewById(R.id.btn_salvar_npc);

        // Receber a ficha da Intent
        Intent intent = getIntent();
        Modelo_Ficha ficha = intent.getParcelableExtra("ficha");

        // Criar lista para o ListView
        ArrayList<String> infoFicha = new ArrayList<>();
        infoFicha.add("Nome: " + ficha.getNome());
        infoFicha.add("Idade: " + ficha.getIdade());
        infoFicha.add("Sexo: " + ficha.getSexo());
        infoFicha.add("Habilidades: " + ficha.getHabilidades());
        infoFicha.add("Informações: " + ficha.getInformacoes());
        infoFicha.add("Momento Marcante: " + ficha.getMomento_marcante());
        infoFicha.add("Tipo de RPG: " + ficha.getTipo_de_rpg());
        infoFicha.add("Resumo: " + ficha.getResumo()); // Adicionar o resumo gerado

        // Criar ArrayAdapter e setar no ListView
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, infoFicha);
        fichaPronta.setAdapter(adapter);

        salvar_ficha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FichasDAO dao = new FichasDAO(FichaPronta.this);
                dao.inserirFicha(ficha);
                finish();
            }
        });




    }

}


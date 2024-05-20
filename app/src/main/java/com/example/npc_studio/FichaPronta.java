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

import com.example.npc_studio.Adapters.FichaAdapter;

import java.util.ArrayList;
import java.util.List;

public class FichaPronta extends AppCompatActivity {

    private ListView fichaPronta;
    private Button salvar_ficha;
    private long idDNPC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow()
                .setFlags(
                        WindowManager.LayoutParams.FLAG_FULLSCREEN,
                        WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.ficha_pronta);

        Intent intent = getIntent();
        idDNPC = intent.getLongExtra("idDoNPC", 0);

        fichaPronta = findViewById(R.id.list_ficha_npc);
        salvar_ficha = findViewById(R.id.btn_salvar_npc);

        salvar_ficha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    private void carregaFicha() {
        FichasDAO dao = new FichasDAO(this);
        List<Modelo_Ficha> ficha = dao.buscarFichaPorId(idDNPC);
        dao.close();

        FichaAdapter adapter =
                new FichaAdapter(this, R.layout.list_item_ficha, ficha);
        fichaPronta.setAdapter(adapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        carregaFicha();
    }

}


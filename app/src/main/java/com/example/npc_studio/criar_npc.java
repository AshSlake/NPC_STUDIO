package com.example.npc_studio;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import java.lang.System;

import androidx.appcompat.app.AppCompatActivity;


public class criar_npc extends AppCompatActivity {

    private EditText idade_npc,habilidades_npc,informacoes_npc,momento_marcante_npc,tipo_rpg;
    Switch escolha_sexo,escolha_habilidade,escolha_informacoes,escolha_momento;
    private Button criar_npc,voltar;

    private FichaHelper helper;
    private Long idNPC;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow()
                .setFlags(
                        WindowManager.LayoutParams.FLAG_FULLSCREEN,
                        WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.criar_npc);

        helper = new FichaHelper(this);

//        nome_npc = findViewById(R.id.nome_npc);
          idade_npc = findViewById(R.id.idade_npc);
          habilidades_npc = findViewById(R.id.qual_habilidade_npc);
        informacoes_npc = findViewById(R.id.informacoes_npc);
        momento_marcante_npc = findViewById(R.id.momento_marcante_npc);
        tipo_rpg = findViewById(R.id.tipo_rpg);
        escolha_sexo = findViewById(R.id.escolha_sexo);
        escolha_habilidade = findViewById(R.id.escolha_habilidade);
        escolha_informacoes = findViewById(R.id.escolha_informacoes);
        escolha_momento = findViewById(R.id.escolha_momento);
        criar_npc = findViewById(R.id.criar_npc_ficha);
        voltar = findViewById(R.id.voltar_ficha);

        criar_npc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Modelo_Ficha ficha = helper.pegaFicha();
                FichasDAO dao = new FichasDAO(criar_npc.this);
                dao.inserirFicha(ficha);
                dao.close();

                idNPC = ficha.getId();

                Intent intent = new Intent(criar_npc.this, FichaPronta.class);
                intent.putExtra("idDoNPC", idNPC);

                System.out.println("NPC " + ficha.getNome() + " foi salvo com sucesso!"+ "com id : " + idNPC);
                startActivity(intent);
            }
        });

        voltar.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        finish();
                    }
                });
        configurarVisibilidadeEditTexts();
        configurarVisibilidadeEditTexts2();
        configurarVisibilidadeEditTexts3();
    }
    private void configurarVisibilidadeEditTexts() {

        escolha_habilidade.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if (isChecked) {
                        habilidades_npc.setVisibility(View.VISIBLE);
                } else {
                        habilidades_npc.setVisibility(View.GONE);
                        habilidades_npc.setText("");
                }
            }
        });
    }

    private void configurarVisibilidadeEditTexts2() {

        escolha_informacoes.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    informacoes_npc.setVisibility(View.VISIBLE);
                } else {
                    informacoes_npc.setVisibility(View.GONE);
                    informacoes_npc.setText("");
                }
            }
        });
    }

    private void configurarVisibilidadeEditTexts3() {

        escolha_momento.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    momento_marcante_npc.setVisibility(View.VISIBLE);
                } else {
                    momento_marcante_npc.setVisibility(View.GONE);
                    momento_marcante_npc.setText("");
                }
            }
        });
    }


}

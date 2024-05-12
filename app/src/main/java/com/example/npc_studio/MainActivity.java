package com.example.npc_studio;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.WindowManager;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private Button criarNPC,NPCS_criados,sair;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow()
                .setFlags(
                        WindowManager.LayoutParams.FLAG_FULLSCREEN,
                        WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);


        criarNPC = findViewById(R.id.criarNPC);
        NPCS_criados = findViewById(R.id.npcCriados);
        sair = findViewById(R.id.sair);


        criarNPC.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Intent intent = new Intent(MainActivity.this, criar_npc.class);
                        startActivity(intent);
                    }
                });


        sair.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        finish();
                    }
                });

    }

    @Override
    protected void onResume() {
        super.onResume();
        applyButtonTouchListener();
    }

    private void applyButtonTouchListener() {
        Button btn1 = criarNPC;
        Button btn2 = NPCS_criados;
        Button btn3 = sair;

        OnTouchListener touchListener =
                new OnTouchListener() {
                    @Override
                    public boolean onTouch(View view, MotionEvent event) {
                        int action = event.getAction();

                        if (action == MotionEvent.ACTION_DOWN) {
                            // Animação de diminuição de tamanho do botão
                            ObjectAnimator scaleDownX =
                                    ObjectAnimator.ofFloat(view, "scaleX", 0.9f);
                            ObjectAnimator scaleDownY =
                                    ObjectAnimator.ofFloat(view, "scaleY", 0.9f);
                            scaleDownX.setDuration(100);
                            scaleDownY.setDuration(100);

                            AnimatorSet scaleDown = new AnimatorSet();
                            scaleDown.play(scaleDownX).with(scaleDownY);
                            scaleDown.start();
                        } else if (action == MotionEvent.ACTION_UP
                                || action == MotionEvent.ACTION_CANCEL) {
                            // Animação de retorno ao tamanho original do botão
                            ObjectAnimator scaleUpX = ObjectAnimator.ofFloat(view, "scaleX", 1f);
                            ObjectAnimator scaleUpY = ObjectAnimator.ofFloat(view, "scaleY", 1f);
                            scaleUpX.setDuration(100);
                            scaleUpY.setDuration(100);

                            AnimatorSet scaleUp = new AnimatorSet();
                            scaleUp.play(scaleUpX).with(scaleUpY);
                            scaleUp.start();
                        }

                        return false;
                    }
                };

        btn1.setOnTouchListener(touchListener);
        btn2.setOnTouchListener(touchListener);
        btn3.setOnTouchListener(touchListener);
    }


}
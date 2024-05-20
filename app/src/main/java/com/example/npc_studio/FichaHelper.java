package com.example.npc_studio;

import android.widget.EditText;
import android.widget.Switch;

import com.example.npc_studio.criar_npc;
import com.example.npc_studio.Modelo_Ficha;
import com.example.npc_studio.R;

public class FichaHelper {
    private EditText nome_npc, idade_npc, habilidades_npc, informacoes_npc, momento_marcante_npc, tipo_rpg;
    private Switch sexo_npc;
    private GeminiPro geminiPro;


    public FichaHelper(criar_npc activity) {

        nome_npc = activity.findViewById(R.id.nome_npc);
        idade_npc = activity.findViewById(R.id.idade_npc);
        habilidades_npc = activity.findViewById(R.id.qual_habilidade_npc);
        informacoes_npc = activity.findViewById(R.id.informacoes_npc);
        momento_marcante_npc = activity.findViewById(R.id.momento_marcante_npc);
        sexo_npc = activity.findViewById(R.id.escolha_sexo);
        tipo_rpg = activity.findViewById(R.id.tipo_rpg);

        geminiPro = new GeminiPro(); // Inicializar o GeminiPro
    }

    public Modelo_Ficha pegaFicha() {
        Modelo_Ficha ficha = new Modelo_Ficha();

        // Nome
        ficha.setNome(gerarConteudoSeVazio(nome_npc, "Gere um nome para um NPC "));

        // Idade
        ficha.setIdade(gerarConteudoSeVazio(idade_npc, "Gere uma idade para um NPC "));

        // Habilidades
        ficha.setHabilidades(gerarConteudoSeVazio(habilidades_npc, "Gere habilidades para um NPC "));

        // Informações
        ficha.setInformacoes(gerarConteudoSeVazio(informacoes_npc, "Gere informações adicionais para um NPC "));

        // Momento Marcante
        ficha.setMomento_marcante(gerarConteudoSeVazio(momento_marcante_npc, "Gere um momento marcante para um NPC "));

        // Tipo de RPG
        ficha.setTipo_de_rpg(tipo_rpg.getText().toString());

        // Sexo
        if (sexo_npc.isChecked()) {
            ficha.setSexo("Feminino");
        } else {
            ficha.setSexo("Masculino");
        }
        // Preparar prompt para o Gemini Pro
        String prompt = "Gere um resumo do npc com no maximo 10 linhas com as seguintes informações do npc :\n" +
                "Nome: " + ficha.getNome() + "\n" +
                "Idade: " + ficha.getIdade() + "\n" +
                "Sexo: " + ficha.getSexo() + "\n" +
                "Habilidades: " + ficha.getHabilidades() + "\n" +
                "Informações: " + ficha.getInformacoes() + "\n" +
                "Momento Marcante: " + ficha.getMomento_marcante() + "\n" +
                "Tipo de RPG: " + ficha.getTipo_de_rpg();

        // Chamar o Gemini Pro para gerar o resumo
        geminiPro.getResponse(prompt, new ResponseCallBack() {
            @Override
            public void onResponse(String resultText) {
                ficha.setResumo(resultText); // Define o resumo gerado pelo Gemini Pro na ficha
            }

            @Override
            public void onError(Throwable throwable) {
                // Lidar com erros na chamada do Gemini Pro
                ficha.setResumo("Erro ao gerar resumo."); // Define um valor padrão em caso de erro
            }
        });

        return ficha;
    }

    private String gerarConteudoSeVazio(final EditText editText, String prompt) {
        String texto = editText.getText().toString();
        if (texto.isEmpty()|texto.equals("")) {
            geminiPro.getResponse(prompt, new ResponseCallBack() {
                @Override
                public void onResponse(String resultText) {
                    editText.setText(resultText); // Define o texto no EditText
                }

                @Override
                public void onError(Throwable throwable) {
                    // Lidar com o erro, talvez exibir uma mensagem para o usuário
                    editText.setText("Erro ao gerar conteúdo.");
                }
            });
        }
        return texto;

    }
}

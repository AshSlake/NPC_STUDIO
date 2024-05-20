package com.example.npc_studio.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.npc_studio.R;
import com.example.npc_studio.Modelo_Ficha;

import java.util.List;

public class FichaAdapter extends ArrayAdapter<Modelo_Ficha>  {

    private Context context;
    private int layoutResourceId;
    private List<Modelo_Ficha> data;

    public FichaAdapter(Context context, int layoutResourceId, List<Modelo_Ficha> data) {
        super(context, layoutResourceId, data);
        this.context = context;
        this.layoutResourceId = layoutResourceId;
        this.data = data;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        if (row == null) {
            LayoutInflater inflater = LayoutInflater.from(context);
            row = inflater.inflate(layoutResourceId, parent, false);
        }
        TextView nomeNPC = row.findViewById(R.id.nome_npc_ficha);
        TextView sexoNPC = row.findViewById(R.id.npc_sexo_ficha);
        TextView idadeNPC = row.findViewById(R.id.npc_idade_ficha);
        TextView npcHabilidades = row.findViewById(R.id.npc_habilidades_ficha);
        TextView npcInformacoes = row.findViewById(R.id.npc_informacoes_ficha);
        TextView momentoMarcante = row.findViewById(R.id.npc_momento_marcante_ficha);
        TextView tipoDeRpg = row.findViewById(R.id.npc_tipo_rpg_ficha);
        TextView resumoNpc = row.findViewById(R.id.npc_resumo_ficha);

        Modelo_Ficha ficha = data.get(position);
        nomeNPC.setText(ficha.getNome());
        sexoNPC.setText(ficha.getSexo());
        idadeNPC.setText(ficha.getIdade());
        npcHabilidades.setText(ficha.getHabilidades());
        npcInformacoes.setText(ficha.getInformacoes());
        momentoMarcante.setText(ficha.getMomento_marcante());
        tipoDeRpg.setText(ficha.getTipo_de_rpg());
        resumoNpc.setText(ficha.getResumo());

        return row;
    }
}

package com.example.npc_studio;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class FichasDAO extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "FichasNPC";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_NAME = "fichas";

    // Colunas da tabela
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_NOME = "nome";
    private static final String COLUMN_IDADE = "idade";
    private static final String COLUMN_SEXO = "sexo";
    private static final String COLUMN_HABILIDADES = "habilidades";
    private static final String COLUMN_INFORMACOES = "informacoes";
    private static final String COLUMN_MOMENTO_MARCANTE = "momento_marcante";
    private static final String COLUMN_TIPO_RPG = "tipo_rpg";
    private static final String COLUMN_RESUMO = "resumo";

    public FichasDAO(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTableQuery = "CREATE TABLE " + TABLE_NAME + " (" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_NOME + " TEXT, " +
                COLUMN_IDADE + " TEXT, " +
                COLUMN_SEXO + " TEXT, " +
                COLUMN_HABILIDADES + " TEXT, " +
                COLUMN_INFORMACOES + " TEXT, " +
                COLUMN_MOMENTO_MARCANTE + " TEXT, " +
                COLUMN_TIPO_RPG + " TEXT, " +
                COLUMN_RESUMO + " TEXT)";
        db.execSQL(createTableQuery);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Implemente a lógica de atualização do banco de dados aqui, se necessário
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public void inserirFicha(Modelo_Ficha ficha) {
        SQLiteDatabase db = getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_NOME, ficha.getNome());
        values.put(COLUMN_IDADE, ficha.getIdade());
        values.put(COLUMN_SEXO, ficha.getSexo());
        values.put(COLUMN_HABILIDADES, ficha.getHabilidades());
        values.put(COLUMN_INFORMACOES, ficha.getInformacoes());
        values.put(COLUMN_MOMENTO_MARCANTE, ficha.getMomento_marcante());
        values.put(COLUMN_TIPO_RPG, ficha.getTipo_de_rpg());
        values.put(COLUMN_RESUMO, ficha.getResumo());

        db.insert(TABLE_NAME, null, values);
        db.close();
    }

    public List<Modelo_Ficha> buscarTodasAsFichas() {
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);
        List<Modelo_Ficha> fichas = new ArrayList<>();

        if (cursor.moveToFirst()) {
            do {
                Modelo_Ficha ficha = new Modelo_Ficha();

                int idIndex = cursor.getColumnIndex(COLUMN_ID);
                if (idIndex >= 0) {
                    ficha.setId(cursor.getLong(idIndex));
                }

                int nomeIndex = cursor.getColumnIndex(COLUMN_NOME);
                if (nomeIndex >= 0) {
                    ficha.setNome(cursor.getString(nomeIndex));
                }

                int idadeIndex = cursor.getColumnIndex(COLUMN_IDADE);
                if (idadeIndex >= 0) {
                    ficha.setIdade(cursor.getString(idadeIndex));
                }

                int sexoIndex = cursor.getColumnIndex(COLUMN_SEXO);
                if (sexoIndex >= 0) {
                    ficha.setSexo(cursor.getString(sexoIndex));
                }

                int habilidadesIndex = cursor.getColumnIndex(COLUMN_HABILIDADES);
                if (habilidadesIndex >= 0) {
                    ficha.setHabilidades(cursor.getString(habilidadesIndex));
                }

                int informacoesIndex = cursor.getColumnIndex(COLUMN_INFORMACOES);
                if (informacoesIndex >= 0) {
                    ficha.setInformacoes(cursor.getString(informacoesIndex));
                }

                int momentoMarcanteIndex = cursor.getColumnIndex(COLUMN_MOMENTO_MARCANTE);
                if (momentoMarcanteIndex >= 0) {
                    ficha.setMomento_marcante(cursor.getString(momentoMarcanteIndex));
                }

                int tipoRPGIndex = cursor.getColumnIndex(COLUMN_TIPO_RPG);
                if (tipoRPGIndex >= 0) {
                    ficha.setTipo_de_rpg(cursor.getString(tipoRPGIndex));
                }

                int resumoIndex = cursor.getColumnIndex(COLUMN_RESUMO);
                if (resumoIndex >= 0) {
                    ficha.setResumo(cursor.getString(resumoIndex));
                }

                fichas.add(ficha);
            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();
        return fichas;
    }

    public List<Modelo_Ficha> buscarFichaPorId(long id) {
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_NAME + " WHERE " + COLUMN_ID + " = ?", new String[]{String.valueOf(id)});

        Modelo_Ficha ficha = null;

        if (cursor.moveToFirst()) {
            ficha = new Modelo_Ficha();

            int nomeIndex = cursor.getColumnIndex(COLUMN_NOME);
            if (nomeIndex >= 0) {
                ficha.setNome(cursor.getString(nomeIndex));
            }

            int idadeIndex = cursor.getColumnIndex(COLUMN_IDADE);
            if (idadeIndex >= 0) {
                ficha.setIdade(cursor.getString(idadeIndex));
            }

            int sexoIndex = cursor.getColumnIndex(COLUMN_SEXO);
            if (sexoIndex >= 0) {
                ficha.setSexo(cursor.getString(sexoIndex));
            }

            int habilidadesIndex = cursor.getColumnIndex(COLUMN_HABILIDADES);
            if (habilidadesIndex >= 0) {
                ficha.setHabilidades(cursor.getString(habilidadesIndex));
            }

            int informacoesIndex = cursor.getColumnIndex(COLUMN_INFORMACOES);
            if (informacoesIndex >= 0) {
                ficha.setInformacoes(cursor.getString(informacoesIndex));
            }

            int momentoMarcanteIndex = cursor.getColumnIndex(COLUMN_MOMENTO_MARCANTE);
            if (momentoMarcanteIndex >= 0) {
                ficha.setMomento_marcante(cursor.getString(momentoMarcanteIndex));
            }

            int tipoRPGIndex = cursor.getColumnIndex(COLUMN_TIPO_RPG);
            if (tipoRPGIndex >= 0) {
                ficha.setTipo_de_rpg(cursor.getString(tipoRPGIndex));
            }

            int resumoIndex = cursor.getColumnIndex(COLUMN_RESUMO);
            if (resumoIndex >= 0) {
                ficha.setResumo(cursor.getString(resumoIndex));
            }
        }

        cursor.close();
        db.close();

        List<Modelo_Ficha> fichas = (List<Modelo_Ficha>) ficha;
        return fichas;
    }

    public void deletaficha(long id) {
        SQLiteDatabase db = getWritableDatabase();

        String selection = COLUMN_ID + " = ?";
        String[] selectionArgs = {String.valueOf(id)};

        db.delete(TABLE_NAME, selection, selectionArgs);
        db.close();
    }

}

package com.app.ludus.healer.dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;

import com.app.ludus.healer.model.ModelPaciente;

public class DAOPaciente extends SQLiteOpenHelper
{
    private static final int VERSAO = 1;
    private static final String TABELA = "paciente";
    private static final String BANCO_DE_DADOS = "healthapp";

    public DAOPaciente(Context context)
    {
        super(context, BANCO_DE_DADOS, null, VERSAO);
    }

    public ModelPaciente getPacienteById(int id)
    {
        try
        {
            ModelPaciente modelPaciente = new ModelPaciente();
            String query;

            query = "SELECT idPaciente, nomePaciente, nomeResponsavel " +
                    "FROM paciente                                    " +
                    "WHERE idPaciente =                               " +id;

            Cursor cursor = null;
            cursor = getReadableDatabase().rawQuery(query, null);

            if(cursor.moveToFirst())
            {
                modelPaciente.setIdPaciente(cursor.getInt(0));
                modelPaciente.setNomePaciente(cursor.getString(1));
                modelPaciente.setNomeResponsavel(cursor.getString(2));
            }
            return modelPaciente;
        }
        catch (SQLiteException ex)
        {
            return null;
        }

    }

    public void updatePaciente(ModelPaciente modelPaciente)
    {
        try
        {
            String query = "UPDATE paciente        " +
                    "SET nomePaciente    = '" + modelPaciente.getNomePaciente()   + "'," +
                    "   nomeResponsavel = '" + modelPaciente.getNomeResponsavel() + "' " +
                    "WHERE idPaciente    = " + modelPaciente.getIdPaciente();
            getWritableDatabase().execSQL(query);

        }
        catch (SQLiteException ex)
        {

        }
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        String query;
        query = "CREATE TABLE IF NOT EXISTS paciente(`idPaciente` int(11) NOT NULL,`nomePaciente` varchar(45) DEFAULT NULL,`nomeResponsavel` varchar(45) DEFAULT NULL, PRIMARY KEY(`idPaciente`));";
        //sqldb.execSQL(sqldb_query);

        db.execSQL(query);

        if(getPacienteById(1) == null)
        {
            query = "INSERT INTO paciente (`idPaciente`, `nomePaciente`, `nomeResponsavel`) VALUES(1, 'Paciente', 'Responsável'); ";
            //sqldb.execSQL(sqldb_query);
            db.execSQL(query);
        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {

    }
}

package com.app.ludus.healer.dao;


import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;

import com.app.ludus.healer.model.ModelTratamento;

public class DAOTratamento extends SQLiteOpenHelper
{
    private static final int VERSAO = 1;
    private static final String TABELA = "tratamento";
    private static final String BANCO_DE_DADOS = "healthappTratamento";

    private DAOPaciente daoPaciente;
    private DAOResponsavel daoResponsavel;

    public DAOTratamento(Context context)
    {
        super(context, BANCO_DE_DADOS, null, VERSAO);
        daoPaciente = new DAOPaciente(context);
        daoResponsavel = new DAOResponsavel(context);
    }

    public ModelTratamento getTratamentoById(int id)
    {
        try
        {
            ModelTratamento modelTratamento = new ModelTratamento();
            String query;

            query = "SELECT idTratamento, nomeTratamento, dataInicio, dataTermino, idPaciente, idResponsavel" +
                    "FROM tratamento                                              " +
                    "WHERE idTratamento =                                         " + id;

            Cursor cursor = null;
            cursor = getReadableDatabase().rawQuery(query, null);

            if(cursor != null)
            {
                cursor.moveToFirst();
                modelTratamento.setIdTratamento(cursor.getInt(0));
                modelTratamento.setNomeTratamento(cursor.getString(1));
                modelTratamento.setDataInicio(cursor.getString(2));
                modelTratamento.setDataTermino(cursor.getString(3));
                modelTratamento.setPaciente(daoPaciente.getPacienteById(cursor.getInt(4)));
                modelTratamento.setResponsavel(daoResponsavel.getResponsavelById(cursor.getInt(5)));
            }
            return modelTratamento;
        }
        catch (Exception ex)
        {
            return null;
        }

    }

    public void updateTratamento(ModelTratamento modelTratamento)
    {
        try
        {
            String query =  "UPDATE tratamento     " +
                            "SET nomeTratamento = '" + modelTratamento.getNomeTratamento()                 + "'," +
                            "    dataInicio     = '" + modelTratamento.getDataInicio()                     + "'," +
                            "    dataTermino    = '" + modelTratamento.getDataTermino()                    + "'," +
                            "    idPaciente     =  " + modelTratamento.getPaciente().getIdPaciente()       + ", "+
                            "    idResponsavel  =  " + modelTratamento.getResponsavel().getIdResponsavel() +
                            " WHERE idTratamento    = " + modelTratamento.getIdTratamento();
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
        query = "CREATE TABLE IF NOT EXISTS `tratamento` (" +
                "  `idTratamento` int(11) NOT NULL," +
                "  `nomeTratamento` varchar(40) NOT NULL," +
                "  `dataInicio` varchar(45) DEFAULT NULL," +
                "  `dataTermino` varchar(45) DEFAULT NULL," +
                "  `idPaciente` int(11) NOT NULL," +
                "  `idResponsavel` int(11) DEFAULT NULL," +
                "  PRIMARY KEY (`idTratamento`);";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {

    }
}

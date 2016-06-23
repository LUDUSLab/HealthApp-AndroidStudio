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
    private static final String BANCO_DE_DADOS = "healthapp";

    public DAOTratamento(Context context)
    {
        super(context, BANCO_DE_DADOS, null, VERSAO);
    }

    public ModelTratamento getTratamentoById(int id)
    {
        try
        {
            ModelTratamento modelTratamento = new ModelTratamento();
            String query;

            query = "SELECT idTratamento, dataInicio, dataTermino, faseTratamento " +
                    "FROM tratamento                                              " +
                    "WHERE idTratamento =                                         " + id;

            Cursor cursor = null;
            cursor = getReadableDatabase().rawQuery(query, null);

            if(cursor != null)
            {
                cursor.moveToFirst();
                modelTratamento.setIdTratamento(cursor.getInt(0));
                modelTratamento.setDataInicio(cursor.getString(1));
                modelTratamento.setDataTermino(cursor.getString(2));
                modelTratamento.setFaseTratamento(cursor.getString(3));
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
                            "SET dataInicio     = '" + modelTratamento.getDataInicio()     + "'," +
                            "    dataTermino    = '" + modelTratamento.getDataTermino()    + "'," +
                            "    faseTratamento = '" + modelTratamento.getFaseTratamento() + "' "+
                            "WHERE idTratamento    = " + modelTratamento.getIdTratamento();
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
        query = "CREATE TABLE IF NOT EXISTS tratamento (`idTratamento` int(11) NOT NULL,`dataInicio` varchar(45) DEFAULT NULL,`dataTermino` varchar(45) DEFAULT NULL,`faseTratamento` varchar(45) NOT NULL,PRIMARY KEY(`idTratamento`,`faseTratamento`))";
        //sqldb.execSQL(sqldb_query);

        db.execSQL(query);

        if(getTratamentoById(1) == null)
        {
            query = "INSERT INTO tratamento (`idTratamento`, `dataInicio`, `dataTermino`, `faseTratamento`) VALUES ('1', '06/01/2015', '06/01/2016', 'Fase 1') ";
            //sqldb.execSQL(sqldb_query);
            db.execSQL(query);
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {

    }
}

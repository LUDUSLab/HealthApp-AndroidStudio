package com.app.ludus.healer.dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.app.ludus.healer.model.ModelResponsavel;

public class DAOResponsavel extends SQLiteOpenHelper
{
    private static final int VERSAO = 1;
    private static final String TABELA = "reponsavel";
    private static final String BANCO_DE_DADOS = "healthappResponsavel";

    public DAOResponsavel(Context context)
    {
        super(context, BANCO_DE_DADOS, null, VERSAO);
    }

    public ModelResponsavel getResponsavelById(int id)
    {
        try
        {
            ModelResponsavel modelResponsavel = new ModelResponsavel();
            String query;

            query = "SELECT idResponsavel, nomeResponsavel, cpf, endereco " +
                    "FROM reponsavel                                      " +
                    "WHERE idResponsavel =                                " + id;

            Cursor cursor = null;
            cursor = getReadableDatabase().rawQuery(query, null);

            if(cursor.moveToFirst())
            {
                modelResponsavel.setIdResponsavel(cursor.getInt(0));
                modelResponsavel.setNomeResponsavel(cursor.getString(1));
                modelResponsavel.setCpf(cursor.getString(2));
                modelResponsavel.setEndereco(cursor.getString(3));
            }

            return modelResponsavel;
        }
        catch (Exception ex)
        {
            return null;
        }
    }

    public void updateResponsavel(ModelResponsavel modelResponsavel)
    {
        try
        {
            String query = "UPDATE paciente           " +
                           "SET  nomeResponsavel = '"+ modelResponsavel.getNomeResponsavel()+"',"+
                           "     cpf             = '"+ modelResponsavel.getCpf()            +"',"+
                           "     endereco        = '"+ modelResponsavel.getEndereco()       +" "+
                           "WHERE idResponsavel  =  "+ modelResponsavel.getIdResponsavel()  +";";
            getWritableDatabase().execSQL(query);
        }
        catch (Exception ex)
        {

        }
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        String query;
        query = "CREATE TABLE IF NOT EXISTS `responsavel` (" +
                "  `idResponsavel` int(11) NOT NULL," +
                "  `nomeResponsavel` varchar(45) DEFAULT NULL," +
                "  `cpf` varchar(45) DEFAULT NULL," +
                "  `endereco` varchar(45) DEFAULT NULL" +
                "  PRIMARY KEY (`idResponsavel`);";

        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1)
    {

    }
}

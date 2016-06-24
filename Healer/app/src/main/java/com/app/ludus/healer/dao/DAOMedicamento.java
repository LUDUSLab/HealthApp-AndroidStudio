package com.app.ludus.healer.dao;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;

import com.app.ludus.healer.model.ModelMedicamento;

import java.util.ArrayList;
import java.util.List;

public class DAOMedicamento extends SQLiteOpenHelper
{
    private static final int VERSAO = 1;
    private static final String TABELA = "medicamento";
    private static final String BANCO_DE_DADOS = "healthapp";

    private DAOTratamento daoTratamento;

    public DAOMedicamento(Context context)
    {
        super(context, BANCO_DE_DADOS, null, VERSAO);
        daoTratamento = new DAOTratamento(context);
    }

    public ModelMedicamento getMedicamentoById(int id)
    {
        try
        {
            ModelMedicamento modelMedicamento = new ModelMedicamento();
            String query;

            query = "SELECT idMedicamento, nomeMedicamento, qtdMedicamento, corMedicamento, horaMedicamento, dataCriacao, idTratamento, isActive, faseTratamento" +
                    "FROM medicamento                                              " +
                    "WHERE idMedicamento =                                         " + id;

            Cursor cursor = null;
            cursor = getReadableDatabase().rawQuery(query, null);

            if(cursor.moveToFirst())
            {
                modelMedicamento.setIdMedicamento(cursor.getInt(0));
                modelMedicamento.setNomeMedicamento(cursor.getString(1));
                modelMedicamento.setQtdMedicamento(cursor.getInt(2));
                modelMedicamento.setCorMedicamento(cursor.getString(3));
                modelMedicamento.setHoraMedicamento(cursor.getString(4));
                modelMedicamento.setDataCriacao(cursor.getString(5));
                modelMedicamento.setTratamento(daoTratamento.getTratamentoById(cursor.getInt(6)));
                modelMedicamento.setActive(cursor.getInt(7));
                modelMedicamento.setFaseTratamento(cursor.getString(8));
            }
            return modelMedicamento;
        }
        catch (SQLiteException ex)
        {
            return null;
        }

    }

    public void updateMedicamento(ModelMedicamento modelMedicamento)
    {
        try
        {
            String query =  "UPDATE medicamento     " +
                            "SET nomeMedicamento = '" + modelMedicamento.getNomeMedicamento() + "'," +
                            "    qtdMedicamento  =  " + modelMedicamento.getQtdMedicamento()  + " ," +
                            "    corMedicamento  = '" + modelMedicamento.getCorMedicamento()  + "'," +
                            "    horaMedicamento = '" + modelMedicamento.getHoraMedicamento() + "'," +
                            "    dataCriacao     = '" + modelMedicamento.getDataCriacao()     + "' " +
                            "WHERE idMedicamento    = " + modelMedicamento.getIdMedicamento();
            getWritableDatabase().execSQL(query);

        }
        catch (SQLiteException ex)
        {

        }
    }

    public List<ModelMedicamento> getListMedicamento(){
        ArrayList<ModelMedicamento>listaMedicamentos = new ArrayList<ModelMedicamento>();
        ModelMedicamento modelMedicamento = new ModelMedicamento();
        try
        {
            String query;

            query = "SELECT * FROM medicamento";

            Cursor cursor = getReadableDatabase().rawQuery(query, null);

            if(cursor.moveToFirst())
            {
                while(cursor.moveToNext()){
                    modelMedicamento.setIdMedicamento(cursor.getInt(0));
                    modelMedicamento.setNomeMedicamento(cursor.getString(1));
                    modelMedicamento.setQtdMedicamento(cursor.getInt(2));
                    modelMedicamento.setCorMedicamento(cursor.getString(3));
                    modelMedicamento.setHoraMedicamento(cursor.getString(4));
                    modelMedicamento.setDataCriacao(cursor.getString(5));
                    modelMedicamento.setTratamento(daoTratamento.getTratamentoById(cursor.getInt(6)));
                    modelMedicamento.setActive(cursor.getInt(7));
                    modelMedicamento.setFaseTratamento(cursor.getString(8));

                    listaMedicamentos.add(modelMedicamento);
                }

            }
            return listaMedicamentos;
        }
        catch (SQLiteException ex)
        {
            return null;
        }

    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        String query;
        query = "CREATE TABLE IF NOT EXISTS medicamento (`idMedicamento` int(11) NOT NULL,`nomeMedicamento` varchar(45) DEFAULT NULL,`qtdMedicamento` int(11) DEFAULT NULL,`corMedicamento` varchar(45) DEFAULT NULL,`horaMedicamento` varchar(45) DEFAULT NULL,`dataCriacao` varchar(45) DEFAULT NULL,`idTratamento` int(11) NOT NULL,`isActive` int(1) DEFAULT 0,`faseTratamento` varchar(45) NOT NULL,PRIMARY KEY(`idMedicamento`))";
        //sqldb.execSQL(sqldb_query);

        db.execSQL(query);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {

    }
}

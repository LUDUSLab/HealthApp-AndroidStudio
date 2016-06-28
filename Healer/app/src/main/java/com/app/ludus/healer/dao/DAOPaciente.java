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
    private static final String BANCO_DE_DADOS = "healthappPaciente";

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

            query = "SELECT idPaciente, nomePaciente, nDeRegistroDaUnidadeSaude, cartaoNacionalDeSaude, dataDeNascimento, telefone, endereco, tuberculose" +
                    "FROM paciente                                    " +
                    "WHERE idPaciente =                               " +id;

            Cursor cursor = null;
            cursor = getReadableDatabase().rawQuery(query, null);

            if(cursor.moveToFirst())
            {
                modelPaciente.setIdPaciente(cursor.getInt(0));
                modelPaciente.setNomePaciente(cursor.getString(1));
                modelPaciente.setnDeRegistroDaUnidadeSaude(cursor.getString(2));
                modelPaciente.setCartaoNacionalDeSaude(cursor.getString(3));
                modelPaciente.setDataDeNascimento(cursor.getString(4));
                modelPaciente.setTelefone(cursor.getString(5));
                modelPaciente.setEndereco(cursor.getString(6));
                modelPaciente.setTuberculose(cursor.getString(7));
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
            String query = "UPDATE paciente           " +
                    "SET nomePaciente              = '" + modelPaciente.getNomePaciente()              + "'," +
                    "    nDeRegistroDaUnidadeSaude = '" + modelPaciente.getnDeRegistroDaUnidadeSaude() + "' " +
                    "   ,cartaoNacionalDeSaude     = '" + modelPaciente.getCartaoNacionalDeSaude()     + "' " +
                    "   ,dataDeNascimento          = '" + modelPaciente.getDataDeNascimento()          + "' " +
                    "   ,telefone                  = '" + modelPaciente.getTelefone()                  + "' " +
                    "   ,endereco                  = '" + modelPaciente.getEndereco()                  + "' " +
                    "   ,tuberculose               = '" + modelPaciente.getTuberculose()               + "' " +
                    "WHERE idPaciente              =  " + modelPaciente.getIdPaciente();
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
        query = "CREATE TABLE IF NOT EXISTS `paciente` ( " +
                "  `idPaciente` int(11) NOT NULL AUTO_INCREMENT," +
                "  `nomePaciente` varchar(45) DEFAULT NULL, " +
                "  `nDeRegistroDaUnidadeSaude` varchar(45) DEFAULT NULL, " +
                "  `cartaoNacionalDeSaude` varchar(45) DEFAULT NULL, " +
                "  `dataDeNascimento` varchar(45) DEFAULT NULL, " +
                "  `telefone` varchar(45) DEFAULT NULL, " +
                "  `endereco` varchar(45) DEFAULT NULL, " +
                "  `tuberculose` varchar(45) DEFAULT NULL, " +
                "  PRIMARY KEY (`idPaciente`);";

        db.execSQL(query);

        query = "INSERT INTO `paciente` (`idPaciente`, `nomePaciente`) VALUES ('1', 'Paciente');";
        db.execSQL(query);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {

    }
}

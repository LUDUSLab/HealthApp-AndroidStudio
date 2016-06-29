package com.app.ludus.healer.dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.app.ludus.healer.model.ModelHistoricoMedicamento;

public class DAOHistoricoMedicamento extends SQLiteOpenHelper
{
    private static final int VERSAO = 1;
    private static final String TABELA = "historicoMedicamento";
    private static final String BANCO_DE_DADOS = "healthappHistoricoMedicamento";

    private DAOMedicamento daoMedicamento;

    public DAOHistoricoMedicamento(Context context)
    {
        super(context, BANCO_DE_DADOS, null, VERSAO);
        daoMedicamento = new DAOMedicamento(context);
    }

    public ModelHistoricoMedicamento getHistoricoMedicamentoById(int id)
    {
        try
        {
            ModelHistoricoMedicamento modelHistoricoMedicamento = new ModelHistoricoMedicamento();
            String query;

            query = "SELECT idHistoricoMedicamento, horaPrevista, horaReal, statusMedicamento, idMedicamento" +
                    "FROM historicomedicamento                                     " +
                    "WHERE idHistoricoMedicamento =                                " + id;

            Cursor cursor = null;
            cursor = getReadableDatabase().rawQuery(query, null);

            if(cursor.moveToFirst())
            {
                modelHistoricoMedicamento.setIdHistoricoMedicamento(cursor.getInt(0));
                modelHistoricoMedicamento.setHoraPrevista(cursor.getString(1));
                modelHistoricoMedicamento.setHoraReal(cursor.getString(2));
                modelHistoricoMedicamento.setStatusMedicamento(cursor.getString(3));
                modelHistoricoMedicamento.setMedicamento(daoMedicamento.getMedicamentoById(cursor.getInt(4)));
            }

            return modelHistoricoMedicamento;
        }
        catch (Exception ex)
        {
            return null;
        }
    }

    public void updateHistoricoMedicamento(ModelHistoricoMedicamento modelHistoricoMedicamento)
    {
        try
        {
            String query =  "UPDATE paciente           " +
                            "SET  horaPrevista             = '"+ modelHistoricoMedicamento.getHoraPrevista()           +"',"+
                            "     horaReal                 = '"+ modelHistoricoMedicamento.getHoraReal()               +"',"+
                            "     statusMedicamento        = '"+ modelHistoricoMedicamento.getStatusMedicamento()      +"' "+
                            "WHERE idHistoricoMedicamento  =  "+ modelHistoricoMedicamento.getIdHistoricoMedicamento() +";";
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
        query = "CREATE TABLE IF NOT EXISTS `historicomedicamento` (" +
                "  `idHistoricoMedicamento` int(11) NOT NULL," +
                "  `horaPrevista` varchar(45) DEFAULT NULL," +
                "  `horaReal` varchar(45) DEFAULT NULL," +
                "  `statusMedicamento` varchar(45) DEFAULT NULL," +
                "  `idMedicamento` int(11) NOT NULL," +
                "  PRIMARY KEY (`idHistoricoMedicamento`);";

        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1)
    {

    }
}

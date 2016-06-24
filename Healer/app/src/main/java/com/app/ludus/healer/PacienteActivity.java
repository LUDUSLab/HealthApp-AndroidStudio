package com.app.ludus.healer;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.app.ludus.healer.dao.DAOPaciente;
import com.app.ludus.healer.model.ModelPaciente;

public class PacienteActivity extends AppCompatActivity {

    private DAOPaciente daoPaciente;
    private ModelPaciente modelPaciente;

    private EditText edtNomePaciente;
    private EditText edtNomeResponsavel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paciente);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        daoPaciente = new DAOPaciente(PacienteActivity.this);

        modelPaciente = daoPaciente.getPacienteById(1);

        edtNomePaciente = (EditText) findViewById(R.id.paciente_edt_paciente);
        edtNomeResponsavel = (EditText) findViewById(R.id.paciente_edt_responsavel);

        // Preencher view

        //edtNomePaciente.setText(modelPaciente.getNomePaciente());
        //edtNomeResponsavel.setText(modelPaciente.getNomeResponsavel());

        //Salvar informações

        ImageButton btnSalvar =(ImageButton) findViewById(R.id.paciente_btn_salvar);

        btnSalvar.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                modelPaciente.setNomePaciente(edtNomePaciente.getText().toString());
                modelPaciente.setNomeResponsavel(edtNomeResponsavel.getText().toString());

                daoPaciente.updatePaciente(modelPaciente);

                Toast.makeText(getApplicationContext(), "Salvo", Toast.LENGTH_SHORT).show();

                startActivity(new Intent(getApplicationContext(),MedicamentoActivity.class));
                finish();

            }
        });
    }

}

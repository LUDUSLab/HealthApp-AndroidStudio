package com.app.ludus.healer.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.app.ludus.healer.R;
import com.app.ludus.healer.dao.DAOPaciente;
import com.app.ludus.healer.model.ModelPaciente;

public class PacienteActivity extends AppCompatActivity {

    private DAOPaciente daoPaciente;
    private ModelPaciente modelPaciente;

    private EditText edtNomePaciente;
    private EditText edtNomeResponsavel;

    private EditText edtNumeroRegistro;
    private EditText edtCartaoSaude;
    private EditText edtDataNascimento;
    private EditText edtTelefone;
    private EditText edtEndereco;
    private RadioGroup rdgTuberculose;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paciente);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        daoPaciente = new DAOPaciente(PacienteActivity.this);

        modelPaciente = daoPaciente.getPacienteById(1);

        edtNomePaciente    = (EditText) findViewById(R.id.paciente_edt_paciente);
        edtNomeResponsavel = (EditText) findViewById(R.id.paciente_edt_responsavel);
        edtNumeroRegistro  = (EditText) findViewById(R.id.paciente_edt_numero_registro);
        edtCartaoSaude     = (EditText) findViewById(R.id.paciente_edt_cartao_saude);
        edtDataNascimento  = (EditText) findViewById(R.id.paciente_edt_data_nascimento);
        edtTelefone        = (EditText) findViewById(R.id.paciente_edt_telefone);
        edtEndereco        = (EditText) findViewById(R.id.paciente_edt_endereco);
        rdgTuberculose     = (RadioGroup) findViewById(R.id.paciente_rdg_tuberculose);

        // Preencher view

        edtNomePaciente.setText(modelPaciente.getNomePaciente());
        //edtNomeResponsavel.setText(modelPaciente.getNomeResponsavel());
        edtNumeroRegistro.setText(modelPaciente.getnDeRegistroDaUnidadeSaude());
        edtCartaoSaude.setText(modelPaciente.getCartaoNacionalDeSaude());
        edtDataNascimento.setText(modelPaciente.getDataDeNascimento());
        edtTelefone.setText(modelPaciente.getTelefone());
        edtEndereco.setText(modelPaciente.getEndereco());

        //Salvar informações

        ImageButton btnSalvar =(ImageButton) findViewById(R.id.paciente_btn_salvar);

        btnSalvar.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                modelPaciente.setNomePaciente(edtNomePaciente.getText().toString());
                modelPaciente.setnDeRegistroDaUnidadeSaude(edtNumeroRegistro.getText().toString());
                modelPaciente.setCartaoNacionalDeSaude(edtCartaoSaude.getText().toString());
                modelPaciente.setDataDeNascimento(edtDataNascimento.getText().toString());
                modelPaciente.setTelefone(edtTelefone.getText().toString());
                modelPaciente.setEndereco(edtEndereco.getText().toString());

                daoPaciente.updatePaciente(modelPaciente);

                Toast.makeText(getApplicationContext(), "Salvo", Toast.LENGTH_SHORT).show();

                startActivity(new Intent(getApplicationContext(),MedicamentoActivity.class));
                finish();

            }
        });
    }

}

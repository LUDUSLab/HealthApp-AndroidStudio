package com.app.ludus.healer;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.app.DatePickerDialog;
import android.app.DatePickerDialog.OnDateSetListener;

import java.io.Console;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.app.ludus.healer.dao.DAOMedicamento;
import com.app.ludus.healer.dao.DAOTratamento;
import com.app.ludus.healer.model.ModelMedicamento;
import com.app.ludus.healer.model.ModelTratamento;

import org.w3c.dom.Text;

public class MedicamentoActivity extends AppCompatActivity
{
    private LinearLayout linearLayoutInicial;
    private LinearLayout linearLayoutfinal;

    private DatePickerDialog datePickerDialogInicial;
    private DatePickerDialog datePickerDialogFinal;

    private TextView textViewInicialData;
    private TextView textViewInicialDia;
    private TextView textViewFinalData;
    private TextView textViewFinalDia;

    private ModelTratamento modelTratamento;
    private DAOTratamento daoTratamento;

    private DAOMedicamento daoMedicamento;

    private Date dateInicio;
    private Date dateFinal;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medicamento);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Calendar newCalendar = Calendar.getInstance();

        daoMedicamento = new DAOMedicamento(MedicamentoActivity.this);

        daoTratamento = new DAOTratamento(MedicamentoActivity.this);
        modelTratamento = daoTratamento.getTratamentoById(1);

        try
        {
            dateInicio = new SimpleDateFormat("dd/MM/yyyy").parse(modelTratamento.getDataInicio());
            dateFinal = new SimpleDateFormat("dd/MM/yyyy").parse(modelTratamento.getDataTermino());
        }
        catch (ParseException e)
        {
            e.printStackTrace();
        }

        linearLayoutInicial =(LinearLayout) findViewById(R.id.medicamento_lnl_inicial);
        textViewInicialData = (TextView) findViewById(R.id.medicamento_txv_inicialdata);
        textViewInicialDia = (TextView) findViewById(R.id.medicamento_txv_inicialdia);

        textViewInicialData.setText( new SimpleDateFormat("MM/yyyy").format(dateInicio));
        textViewInicialDia.setText(new SimpleDateFormat("dd").format(dateInicio));

        linearLayoutfinal =(LinearLayout) findViewById(R.id.medicamento_lnl_final);
        textViewFinalData = (TextView) findViewById(R.id.medicamento_txv_finaldata);
        textViewFinalDia = (TextView) findViewById(R.id.medicamento_txv_finaldia);

        textViewFinalData.setText( new SimpleDateFormat("MM/yyyy").format(dateFinal));
        textViewFinalDia.setText(new SimpleDateFormat("dd").format(dateFinal));

        datePickerDialogInicial = new DatePickerDialog(this, new OnDateSetListener()
        {

            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth)
            {
                Calendar newDate = Calendar.getInstance();
                newDate.set(year, monthOfYear, dayOfMonth);

                String txt;
                txt = new SimpleDateFormat("dd/MM/yyyy").format(newDate.getTime());
                modelTratamento.setDataInicio(txt);

                txt = new SimpleDateFormat("MM/yyyy").format(newDate.getTime());
                textViewInicialData.setText(txt);

                txt = new SimpleDateFormat("dd").format(newDate.getTime());
                textViewInicialDia.setText(txt);
            }

        },newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));

        datePickerDialogFinal = new DatePickerDialog(this, new OnDateSetListener()
        {

            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth)
            {
                Calendar newDate = Calendar.getInstance();
                newDate.set(year, monthOfYear, dayOfMonth);

                String txt;
                txt = new SimpleDateFormat("dd/MM/yyyy").format(newDate.getTime());
                modelTratamento.setDataTermino(txt);

                txt = new SimpleDateFormat("MM/yyyy").format(newDate.getTime());
                textViewFinalData.setText(txt);

                txt = new SimpleDateFormat("dd").format(newDate.getTime());
                textViewFinalDia.setText(txt);
            }

        },newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));

        //Abrir calendario
        linearLayoutInicial.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                datePickerDialogInicial.show();
            }
        });

        linearLayoutfinal.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                datePickerDialogFinal.show();
            }
        });

        ImageButton btnSalvar =(ImageButton) findViewById(R.id.medicamento_btn_salvar);

        btnSalvar.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {

                daoTratamento.updateTratamento(modelTratamento);

                Toast.makeText(getApplicationContext(), "Salvo", Toast.LENGTH_SHORT).show();
                Intent it = new Intent(getApplicationContext(),DailyActivity.class);
                startActivity(it);
            }
        });

        final LinearLayout InfoMedicamento = (LinearLayout) findViewById(R.id.info_medicamento);

        final ImageButton addInfo = (ImageButton) findViewById(R.id.add_info);
        addInfo.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                InfoMedicamento.setVisibility(View.VISIBLE);
                addInfo.setVisibility(View.INVISIBLE);
            }
        });

        //componenetes do formulario
        final EditText edtNome = (EditText) findViewById(R.id.medicamento_edt_nome);
        final EditText edtQtd = (EditText) findViewById(R.id.medicamento_edt_qtd);

        final RadioButton rbnAmarelo = (RadioButton) findViewById(R.id.medicamento_rbn_amarelo);
        final RadioButton rbnVermelho = (RadioButton) findViewById(R.id.medicamento_rbn_vermelho);

        final RadioGroup rgpCor = (RadioGroup) findViewById(R.id.medicamento_rgp_cor);
        //

        ImageButton OkInfo = (ImageButton) findViewById(R.id.ok_medicamento);
        OkInfo.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick (View v)
            {
                LayoutInflater vi = (LayoutInflater) getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                View v1 = vi.inflate(R.layout.content_cardview_medicamento,  null);

                ViewGroup insertPoint = (ViewGroup) findViewById(R.id.insert_point);

                String cor = "branco";

                if (rgpCor.getCheckedRadioButtonId() == rbnAmarelo.getId())
                    cor = "amarelo";
                else if (rgpCor.getCheckedRadioButtonId() == rbnVermelho.getId())
                    cor = "vermelho";

                ModelMedicamento modelMedicamento = new ModelMedicamento();
                modelMedicamento.setNomeMedicamento(edtNome.getText().toString());
                modelMedicamento.setQtdMedicamento(3);
                modelMedicamento.setCorMedicamento(cor);

                daoMedicamento.insertMedicamento(modelMedicamento);

                addInfo.setVisibility(View.VISIBLE);
                InfoMedicamento.setVisibility(View.GONE);
                //((ViewGroup)v1.getParent()).removeView(v1);
                //insertPoint.addView(v1, 0, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.FILL_PARENT, ViewGroup.LayoutParams.FILL_PARENT));
            }
        });

        ImageButton buttonMinus = (ImageButton) findViewById(R.id.medicamento_btn_minus);
        ImageButton buttonPlus = (ImageButton) findViewById(R.id.medicamento_btn_plus);
        final EditText editTextQuantity = (EditText) findViewById(R.id.medicamento_edt_qtd);

        buttonPlus.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick (View v)
            {
                int quantity = Integer.parseInt(editTextQuantity .getText().toString());
                quantity++;
                editTextQuantity.setText(Integer.toString(quantity));
            }
        });

        buttonMinus.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick (View v)
            {
                int quantity = Integer.parseInt(editTextQuantity .getText().toString());
                quantity--;
                if(quantity <= 0) quantity = 0;
                editTextQuantity.setText(Integer.toString(quantity));
            }
        });

        LinearLayout inicialHour = (LinearLayout) findViewById(R.id.hora_inicial);
        LinearLayout finalHour = (LinearLayout) findViewById(R.id.hora_final);

        inicialHour.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick (View v)
            {
                DialogFragment newFragment = MyAlertDialogFragment.newInstance(1);
                newFragment.show(getFragmentManager(), "dialog");
            }
        });
    }

    public void doPositiveClick(){

    }

    public void doNegativeClick(){

    }

    public static class MyAlertDialogFragment extends DialogFragment {

        public static MyAlertDialogFragment newInstance(int title) {
            MyAlertDialogFragment frag = new MyAlertDialogFragment();
            Bundle args = new Bundle();
            args.putInt("title", title);
            frag.setArguments(args);
            return frag;
        }

        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            int title = getArguments().getInt("title");

            return new AlertDialog.Builder(getActivity())
                    .setIcon(R.drawable.lembrete)
                    .setTitle("DATA")
                    .setPositiveButton("OK",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int whichButton) {
                                    ((MedicamentoActivity)getActivity()).doPositiveClick();
                                }
                            }
                    )
                    .setNegativeButton("Cancel",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int whichButton) {
                                    ((MedicamentoActivity)getActivity()).doNegativeClick();
                                }
                            }
                    )
                    .create();
        }
    }
}

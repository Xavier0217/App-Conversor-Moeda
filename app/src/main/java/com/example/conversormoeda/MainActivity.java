package com.example.conversormoeda;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemSelectedListener {

    private EditText editTextValor;
    private Spinner spinnerMoedas;
    private Button buttonGrafico;
    private Button buttonLimpar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextValor = findViewById(R.id.editTextValor);

        buttonGrafico = findViewById(R.id.buttonGrafico);
        buttonLimpar = findViewById(R.id.buttonLimpar);

        buttonGrafico.setOnClickListener(this);
        buttonLimpar.setOnClickListener(this);

        spinnerMoedas = findViewById(R.id.spinnerMoedas);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.moedas, android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinnerMoedas.setAdapter(adapter);
        spinnerMoedas.setOnItemSelectedListener(this);


    }

    @Override
    public void onItemSelected(AdapterView<?> moedas, View view, int pos, long id) {

        if (pos == 0) return;

        if (editTextValor.getText().toString().isEmpty()) return;

        String moedaSelecionada = moedas.getItemAtPosition(pos).toString();

        double valor = Double.parseDouble(editTextValor.getText().toString());
        Moeda moeda = new Moeda(valor);
        double valorConvertido = 0;

        if (moedaSelecionada.equals("Euro")) {
            valorConvertido = moeda.converterEuro();
        } else if (moedaSelecionada.equals("Dólar")) {
            valorConvertido = moeda.converterDolar();
        }

        moedas.getItemAtPosition(pos);

        String msg = String.format("O valor convertido é: %.2f", valorConvertido);

        this.mostrarResultado(msg);

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
    }

    public void mostrarResultado(String msg) {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Moeda Convertida!");
        builder.setMessage(msg);

        AlertDialog alertDialog = builder.create();
        alertDialog.show();

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.buttonGrafico) {
            avancarTela();
        } else if (v.getId() == R.id.buttonLimpar) {

        }
    }

    private void avancarTela() {
        Intent telaGrafico = new Intent(this, GraficoActivity.class);
        startActivity(telaGrafico);

        finish();
    }

}

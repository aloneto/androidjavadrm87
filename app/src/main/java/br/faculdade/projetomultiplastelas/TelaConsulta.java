package br.faculdade.projetomultiplastelas;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class TelaConsulta extends Activity {
    EditText nome;
    EditText idade;
    EditText valorHora;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.consulta);
        nome = (EditText) findViewById(R.id.nome);
        idade = (EditText) findViewById(R.id.idade);
        valorHora = (EditText) findViewById(R.id.valorhora);
        processarDadosLidos();
        Button btcalcular = (Button) findViewById(R.id.btvoltar);
        btcalcular.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                Intent it = new Intent(TelaConsulta.this, MainActivity.class);
                startActivity(it);
            }
        });
    }

    private void processarDadosLidos() {
        Intent it = getIntent();
        Bundle bun = it.getExtras();
        PessoaVO pes = (PessoaVO) bun.get("pessoa");
        nome.setText(pes.getNome());
        idade.setText(String.valueOf(pes.getIdade()));
        valorHora.setText(String.valueOf(pes.getValorHora()));
    }
}

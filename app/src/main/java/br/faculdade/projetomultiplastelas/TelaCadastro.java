package br.faculdade.projetomultiplastelas;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class TelaCadastro extends Activity {
    EditText nome;
    EditText idade;
    EditText valorHora;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cadastro); // ver nome do XML do cadastro
        nome = (EditText) findViewById(R.id.nome);
        idade = (EditText) findViewById(R.id.idade);
        valorHora = (EditText) findViewById(R.id.valorhora);
        Button btcalcular = (Button) findViewById(R.id.btcadastrar);
        btcalcular.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                processarDadosLidoseDevolver();
            }
        });
    }

    private void processarDadosLidoseDevolver() {
        Intent it = new Intent();
        Bundle bun = new Bundle();
        PessoaVO pes = new PessoaVO();
        pes.setNome(nome.getText().toString());
        pes.setIdade(Integer.parseInt(idade.getText().toString()));
        pes.setValorHora(Double.parseDouble(valorHora.getText()
                .toString()));
        bun.putSerializable("pessoa", pes);
        it.putExtras(bun);
        setResult(RESULT_OK, it);
        finish();
    }
}

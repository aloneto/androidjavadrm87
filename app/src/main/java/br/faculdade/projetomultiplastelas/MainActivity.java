package br.faculdade.projetomultiplastelas;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {
    final int CADASTRO = 1;
    PessoaVO pes = null;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_principal);
        Button btcalcular = (Button) findViewById(R.id.btcontinuar);
        btcalcular.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                RadioGroup rg = (RadioGroup) findViewById(R.id.rgopcoes);
                int op = rg.getCheckedRadioButtonId();
                if (op == R.id.cadastro) {
                    pes = new PessoaVO();
                    cadastrar();
                } else if (op == R.id.consulta) {
                    if (pes != null) {
                        consultar();
                    } else {
                        AlertDialog.Builder dialogo = new AlertDialog.Builder(
                                MainActivity.this);
                        dialogo.setTitle("Cadastro incorreto");
                        dialogo.setMessage("Primeiramente cadastrar os dados.");
                        dialogo.setNeutralButton("OK", null);
                        dialogo.show();
                    }
                }
            }
        });
    }

    private void cadastrar() {
        Intent it = new Intent(this, TelaCadastro.class);
        startActivityForResult(it, CADASTRO);
    }

    private void consultar() {
        Intent it = new Intent(this, TelaConsulta.class);
        Bundle bun = new Bundle();
        bun.putSerializable("pessoa", pes);
        it.putExtras(bun);
        startActivity(it);
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent it) {
        if ((resultCode == RESULT_OK) && (requestCode == CADASTRO)) {
            Bundle bun = it.getExtras();
            pes = (PessoaVO) bun.get("pessoa");
            Log.i("Nome: ", pes.getNome());

            Log.i("Idade: ", String.valueOf(pes.getIdade()));
            Log.i("Valor Hora: ", String.valueOf(pes.getValorHora()));
        }
    }
}

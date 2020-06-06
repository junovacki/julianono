package com.example.languagetut.cadastro;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import com.example.languagetut.R;

public class CadastroPerguntasActivity extends AppCompatActivity {
    private EditText nivelRequirido;
    private EditText textoPergunta;
    private EditText questionId;
    private TextView viewId;
    private TextView viewNivel;
    private TextView viewPergunta;
    private Button salvar;
    private Button consultar;
    private DAO dao;
    private ConexaoDB conexaoDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cadastro_perguntas);
        nivelRequirido = findViewById(R.id.editNivelRequirido);
        textoPergunta = findViewById(R.id.edtPergunta);
        questionId = findViewById(R.id.editId);
        salvar = findViewById(R.id.btnSalvar);
        consultar = findViewById(R.id.btnConsultar);
        viewId = findViewById(R.id.txtViewID);
        viewNivel = findViewById(R.id.txtViewNivel);
        viewPergunta = findViewById(R.id.txtViewPergunta);
        conexaoDB = new ConexaoDB(this);
        dao = new DAO();
        dao.setConexaoDB(conexaoDB);
        salvar.setOnClickListener((v) -> {insert();});
        consultar.setOnClickListener((v) -> {int id = Integer.parseInt(questionId.getText().toString());
                                                select(id);});
    }

    private void insert() {
        Question question = new Question();
        question.setLevel_required(Integer.parseInt(nivelRequirido.getText().toString()));
        question.setQuestion_text(textoPergunta.getText().toString());
        long id = dao.insertQuestion(question);
        Toast.makeText(this, "Questão com id: " + id, Toast.LENGTH_LONG).show();
    }

    private void select(int id){
        Question question = dao.selectQuestion(id);
        viewId.setText("ID: " + id);
        viewNivel.setText("Nível requerido: " + question.getLevel_required());
        viewPergunta.setText("Questão: " + question.getQuestion_text());
    }
}

package com.example.languagetut.cadastro;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.languagetut.R;

public class CadastroUsuarioActivity extends AppCompatActivity {
    private EditText nome;
    private EditText idade;
    private EditText nivel;
    private EditText editId;
    private Button salvar;
    private Button consultar;
    private TextView viewId;
    private TextView viewNome;
    private TextView viewIdade;
    private TextView viewNivel;
    private DAO dao;
    private ConexaoDB conexaoDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cadastro_usuario);
        nome = findViewById(R.id.editNome);
        idade = findViewById(R.id.edtIdade);
        nivel = findViewById(R.id.edtNivel);
        editId = findViewById(R.id.editId2);
        viewId = findViewById(R.id.txtViewID2);
        viewNome = findViewById(R.id.txtName);
        viewIdade = findViewById(R.id.txtViewIdade);
        viewNivel = findViewById(R.id.txtViewNivel2);
        salvar = findViewById(R.id.btnSalvar2);
        consultar = findViewById(R.id.btnConsultar2);
        conexaoDB = new ConexaoDB(this);
        dao = new DAO();
        dao.setConexaoDB(conexaoDB);
        salvar.setOnClickListener((v) -> {insert();});
        consultar.setOnClickListener((v) -> {select(Integer.parseInt(editId.getText().toString()));});
    }


    private void insert() {
        User user = new User();
        user.setName(nome.getText().toString());
        user.setAge(Integer.parseInt(idade.getText().toString()));
        user.setLevel(Integer.parseInt(nivel.getText().toString()));
        long id = dao.insertUser(user);
        Toast.makeText(this, "Usuário com id: " + id, Toast.LENGTH_LONG).show();
    }

    private void select(int id){
        User user = dao.selectUser(id);
        viewId.setText("ID: " + id);
        viewNome.setText("Nome: " + user.getName());
        viewIdade.setText("Idade: " + user.getAge());
        viewNivel.setText("Nível: " + user.getLevel());
    }
}

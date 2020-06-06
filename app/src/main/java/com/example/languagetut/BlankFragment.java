package com.example.languagetut;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.languagetut.cadastro.CadastroPerguntasActivity;
import com.example.languagetut.cadastro.CadastroUsuarioActivity;

import java.util.Objects;

public class BlankFragment extends Fragment {

    public BlankFragment() {
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, MenuInflater menuInflater) {
        menuInflater.inflate(R.menu.toolbar_menu, menu);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        return inflater.inflate(R.layout.fragment_toolbar, container, false);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.perguntas:
                Intent intentPerguntas = new Intent(getActivity(), CadastroPerguntasActivity.class);
                startActivity(intentPerguntas);
                break;
            case R.id.usuario:
                Intent intentUsuario = new Intent(getActivity(), CadastroUsuarioActivity.class);
                startActivity(intentUsuario);
                break;
            case R.id.sair:
                Objects.requireNonNull(getActivity()).finish();
                System.exit(0);
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}

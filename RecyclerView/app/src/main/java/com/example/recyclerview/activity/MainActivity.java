package com.example.recyclerview.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.recyclerview.R;
import com.example.recyclerview.RecyclerItemClickListener;
import com.example.recyclerview.adapter.Adapter;
import com.example.recyclerview.model.Filme;

import java.util.ArrayList;
import java.util.List;
import java.util.ListResourceBundle;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private Object ArrayList;
    private List<Filme> listaFilmes = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);


        //Listagem de filmes
        this.criarFilmes();



        //configurar adapter
        Adapter adapter = new Adapter( listaFilmes );

        //configurar recyclerview
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.addItemDecoration( new DividerItemDecoration(this, LinearLayout.VERTICAL));
        recyclerView.setAdapter( adapter );

        //Evento de click
        recyclerView.addOnItemTouchListener(
                new RecyclerItemClickListener(
                        getApplicationContext(),
                        recyclerView,
                        new RecyclerItemClickListener.OnItemClickListener() {
                            @Override
                            public void onItemClick(View view, int position) {

                                Filme filme = listaFilmes.get(position);
                                Toast.makeText(
                                        getApplicationContext(),
                                        "Item pressionado:" + filme.getTituloFilme(),
                                        Toast.LENGTH_SHORT
                                ).show();
                            }


                            @Override
                            public void onLongItemClick(View view, int position) {

                                Filme filme = listaFilmes.get( position );
                                Toast.makeText(
                                        getApplicationContext(),
                                        "Click Longo:" + filme.getTituloFilme(),
                                        Toast.LENGTH_LONG
                                ).show();
                            }

                            @Override
                            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                            }
                        }
                )
        );
    }


    public void criarFilmes(){

        Filme filme = new Filme("Harry Potter e a pedra filosofal","A????o e aventura","2002");
        this.listaFilmes.add( filme );

        filme = new Filme("American Pie","Com??dia","2000");
        this.listaFilmes.add( filme );

        filme = new Filme("American Pie 2","Com??dia","2003");
        this.listaFilmes.add( filme );

        filme = new Filme("Vov??...Zona","Com??dia","2005");
        this.listaFilmes.add( filme );

        filme = new Filme("It a coisa","Suspense/Terror","2018");
        this.listaFilmes.add( filme );

        filme = new Filme("Viagem ao centro da terra","Aventura","2007");
        this.listaFilmes.add( filme );

        filme = new Filme("P??nico no Elevador","Suspense","2010");
        this.listaFilmes.add( filme );

        filme = new Filme("Serpentes a bordo","A????o/Suspense","2000");
        this.listaFilmes.add( filme );


    }



}
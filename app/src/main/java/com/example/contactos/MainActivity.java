package com.example.contactos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.motion.widget.KeyPosition;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.icu.text.Transliterator;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Contacto> contactos;
    private RecyclerView listaContactos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //ToolBar miActionBar = (ToolBar) findViewById(R.id.m)

        listaContactos = (RecyclerView) findViewById(R.id.rvContactos);

        LinearLayoutManager llm=new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listaContactos.setLayoutManager(llm);
        inicializarLista();
        inicializarAdapter();


        /*
        ListView lstContactos =(ListView) findViewById(R.id.lstContactos);
        lstContactos.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, nombresContactos));
        lstContactos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent= new Intent(MainActivity.this,Detalle.class);
                intent.putExtra(getResources().getString(R.string.pnombre), contactos.get(i).getNombre());;
                intent.putExtra(getResources().getString(R.string.ptelefono),contactos.get(i).getTelefono());
                intent.putExtra(getResources().getString(R.string.pemail),contactos.get(i).getEmail());
                startActivity(intent);
                finish();
            }
        });*/


    }
    public ContactoAdapter adapter;
    public void inicializarAdapter(){
        adapter = new ContactoAdapter(contactos,this);
        listaContactos.setAdapter(adapter);
    }

    public void inicializarLista(){
        contactos=new ArrayList<Contacto>();

        contactos.add(new Contacto("Maicol","111111", "maicol@gmail.com", R.drawable.foto));
        contactos.add(new Contacto("Andrey","222222", "andrey@gmail.com",R.drawable.foto3));
        contactos.add(new Contacto("marina","000000", "marina@gmail.com", R.drawable.descarga));
        contactos.add(new Contacto("nicolle","000001", "nicolle@gmail.com", R.drawable.foto4));
        contactos.add(new Contacto("Salome","333333", "Salome@gmail.com", R.drawable.foto5));
        contactos.add(new Contacto("Azula","3333331", "Azula@gmail.com", R.drawable.foto6));

    }
}
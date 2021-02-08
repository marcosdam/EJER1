package es.eduardsanz.ejercicio1;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Random;

import es.eduardsanz.ejercicio1.POJO.Ganador;
import es.eduardsanz.ejercicio1.POJO.Premio;
import es.eduardsanz.ejercicio1.adapters.GanadorAdapter;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Ganador> listaGanadores;
    private RecyclerView recyclerMain;
    private GanadorAdapter ganadorAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private int filaGanador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listaGanadores = new ArrayList<>();
        recyclerMain = findViewById(R.id.recyclerPrincipal);
        layoutManager = new LinearLayoutManager(this);

        inicializaGanadores(20, 5);

        filaGanador = R.layout.ganador_item;

        ganadorAdapter = new GanadorAdapter(listaGanadores, filaGanador, this);
        recyclerMain.setAdapter(ganadorAdapter);
        recyclerMain.setLayoutManager(layoutManager);

    }

    private void inicializaGanadores(int numGanaddores, int numPremios) {
        for (int i = 0; i < numGanaddores; i++) {
            String nombre = "nombre"+i;
            String apellido = "apellido"+i;
            ArrayList<Premio> listaPremios = new ArrayList<>();
            Random rnd = new Random();
            for (int j = 0; j <numPremios; j++) {
                Premio p = new Premio();
                p.setTitulo("titulo"+j);
                p.setImporte(rnd.nextInt(1000));
                listaPremios.add(p);
            }
            listaGanadores.add(new Ganador(nombre, apellido, listaPremios));
        }
    }
}

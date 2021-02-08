package es.eduardsanz.ejercicio1;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import java.util.ArrayList;

import es.eduardsanz.ejercicio1.POJO.Ganador;
import es.eduardsanz.ejercicio1.POJO.Premio;
import es.eduardsanz.ejercicio1.adapters.GanadorAdapter;
import es.eduardsanz.ejercicio1.adapters.PremioAdapter;

public class MuestraGanadorActivity extends AppCompatActivity {

    private Ganador ganador;
    private RecyclerView recyclerPremios;
    private PremioAdapter premioAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private int filaPremio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_muestra_ganador);

        TextView txtNombre, txtApellidos;

        ganador = getIntent().getExtras().getParcelable("GANADOR");
        txtNombre = findViewById(R.id.lblNombre);
        txtApellidos = findViewById(R.id.lblApellido);
        txtNombre.setText( ganador.getNombre());
        txtApellidos.setText(ganador.getApellidos());

        recyclerPremios = findViewById(R.id.RecyclerDeudas);
        layoutManager = new LinearLayoutManager(this);

        filaPremio = R.layout.premio_item;

        premioAdapter = new PremioAdapter(ganador.getListaPremios(), filaPremio, this);
        recyclerPremios.setAdapter(premioAdapter);
        recyclerPremios.setLayoutManager(layoutManager);

    }
}

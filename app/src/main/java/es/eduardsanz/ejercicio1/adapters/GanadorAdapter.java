package es.eduardsanz.ejercicio1.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.io.Serializable;
import java.util.List;

import es.eduardsanz.ejercicio1.MainActivity;
import es.eduardsanz.ejercicio1.MuestraGanadorActivity;
import es.eduardsanz.ejercicio1.POJO.Ganador;
import es.eduardsanz.ejercicio1.R;

public class GanadorAdapter extends RecyclerView.Adapter<GanadorAdapter.GanadorVH> {

    // Variables necesarias
    private List<Ganador> objects;
    private int resource;
    private Context context;

    // Constructor completo
    public GanadorAdapter(List<Ganador> objects, int resource, Context context) {
        this.objects = objects;
        this.resource = resource;
        this.context = context;
    }

    // Métodos Adapter
    @NonNull
    @Override
    public GanadorAdapter.GanadorVH onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        // Montar view (individual)
        View ganadorItem = LayoutInflater.from(context).inflate(resource, null);
        // Asignar alto y ancho aquí también
        ganadorItem.setLayoutParams(new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        // Return holder pasándole el item (ganador)
        return new GanadorVH(ganadorItem);
    }

    @Override
    public void onBindViewHolder(@NonNull GanadorAdapter.GanadorVH ganadorVH, @SuppressLint("RecyclerView") final int position) {
        // Obtener ganador
        Ganador ganador = objects.get(position);

        // Dar valores a los txt
        ganadorVH.txtNombre.setText(ganador.getNombre());
        ganadorVH.txtApellido.setText(ganador.getApellidos());

        // Ir a activity_muestra_ganador al pulsar sobre uno de ellos
        ganadorVH.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 1. Bundle con el nombre
                Bundle bundle = new Bundle();
                bundle.putParcelable("GANADOR", objects.get(position));
                // 2. Intent con el context como origen (por que estoy en un Adapter)
                Intent intent = new Intent(context, MuestraGanadorActivity.class);
                intent.putExtras(bundle);
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return objects.size();  // Tamaño de la lista
    }


    // Clase interna para el View Holder
    public class GanadorVH extends RecyclerView.ViewHolder {
        // Elementos de la fila (nombre y apellido del ganador)
        TextView txtNombre, txtApellido;
        View ganadorItem;

        // Instanciarlos en su const
        public GanadorVH(@NonNull View itemView) {
            super(itemView);
            txtNombre = itemView.findViewById(R.id.txtNombreGanador);
            txtApellido = itemView.findViewById(R.id.txtApellidoGanador);
            ganadorItem = itemView;
        }
    }
}

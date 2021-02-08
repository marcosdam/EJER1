package es.eduardsanz.ejercicio1.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import es.eduardsanz.ejercicio1.POJO.Ganador;
import es.eduardsanz.ejercicio1.POJO.Premio;
import es.eduardsanz.ejercicio1.R;

public class PremioAdapter extends RecyclerView.Adapter<PremioAdapter.PremioVH> {

    // Vars
    private List<Premio> objects;
    private int resource;
    private Context context;

    // Const
    public PremioAdapter(List<Premio> objects, int resource, Context context) {
        this.objects = objects;
        this.resource = resource;
        this.context = context;
    }

    // Métodos del Adapter
    @NonNull
    @Override
    public PremioAdapter.PremioVH onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View premioItem = LayoutInflater.from(context).inflate(resource, null);
        premioItem.setLayoutParams(new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        return new PremioVH(premioItem);
    }

    @Override
    public void onBindViewHolder(@NonNull PremioAdapter.PremioVH premioVH, int position) {
        Premio premio = objects.get(position);
        premioVH.txtTitulo.setText(premio.getTitulo());
        premioVH.txtImporte.setText(String.valueOf(premio.getImporte()));
    }

    @Override
    public int getItemCount() {
        return objects.size();
    }

    public class PremioVH extends RecyclerView.ViewHolder {
        // Elementos vista
        TextView txtTitulo, txtImporte;
        View premioItem;

        // Instanciar en el super
        public PremioVH(@NonNull View itemView) {
            super(itemView);
            txtTitulo = itemView.findViewById(R.id.txtTitulo);
            txtImporte = itemView.findViewById(R.id.txtImporte);
            premioItem = itemView;
        }
    }

}

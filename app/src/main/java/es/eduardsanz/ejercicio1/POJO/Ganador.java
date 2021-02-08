package es.eduardsanz.ejercicio1.POJO;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class Ganador implements Parcelable{
    private String nombre;
    private String apellidos;
    private ArrayList<Premio> listaPremios;

    public Ganador(String nombre, String apellidos, ArrayList<Premio> listaPremios) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.listaPremios = listaPremios;
    }

    public Ganador() {
        listaPremios = new ArrayList<>();
    }


    protected Ganador(Parcel in) {
        nombre = in.readString();
        apellidos = in.readString();
        listaPremios = in.createTypedArrayList(Premio.CREATOR);
    }

    public static final Creator<Ganador> CREATOR = new Creator<Ganador>() {
        @Override
        public Ganador createFromParcel(Parcel in) {
            return new Ganador(in);
        }

        @Override
        public Ganador[] newArray(int size) {
            return new Ganador[size];
        }
    };

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public ArrayList<Premio> getListaPremios() {
        return listaPremios;
    }

    public void setListaPremios(ArrayList<Premio> listaPremios) {
        this.listaPremios = listaPremios;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(nombre);
        parcel.writeString(apellidos);
        parcel.writeTypedList(listaPremios);
    }
}

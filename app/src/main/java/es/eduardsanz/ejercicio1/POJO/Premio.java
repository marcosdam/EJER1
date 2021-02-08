package es.eduardsanz.ejercicio1.POJO;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

public class Premio implements Parcelable {
    private String titulo;
    private int importe;

    public Premio(String titulo, int importe) {
        this.titulo = titulo;
        this.importe = importe;
    }

    public Premio() {
    }


    protected Premio(Parcel in) {
        titulo = in.readString();
        importe = in.readInt();
    }

    public static final Creator<Premio> CREATOR = new Creator<Premio>() {
        @Override
        public Premio createFromParcel(Parcel in) {
            return new Premio(in);
        }

        @Override
        public Premio[] newArray(int size) {
            return new Premio[size];
        }
    };

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getImporte() {
        return importe;
    }

    public void setImporte(int importe) {
        this.importe = importe;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(titulo);
        parcel.writeInt(importe);
    }
}

    package com.lista.listadetareas.riuz.calculadora.adaptadores;

    import android.content.Context;
    import android.widget.ArrayAdapter;

    import androidx.annotation.NonNull;

    public class ListAdapter extends ArrayAdapter<adapter> {


        public ListAdapter(@NonNull Context context, int resource) {
            super(context, resource);
        }
    }

    class adapter {

        private String nombre;
        private String pass;

        public adapter(String nombre, String pass) {
            this.nombre = nombre;
            this.pass = pass;
        }
    }
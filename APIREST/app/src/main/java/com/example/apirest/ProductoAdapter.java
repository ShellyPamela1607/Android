package com.example.apirest;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.apirest.Model.Producto;

import java.util.List;

public class ProductoAdapter extends ArrayAdapter<Producto> {
    private Context context;
    private List<Producto>producto;

    public ProductoAdapter(@NonNull Context context, int resource, int textViewResourceId, @NonNull List<Producto> objects) {
        super(context, resource, textViewResourceId, objects);
        this.context=context;
        this.producto=objects;
    }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater layoutInflater=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View rowView=layoutInflater.inflate(R.layout.content_main,parent,false);

            TextView txtidProducto=(TextView) rowView.findViewById(R.id.IdProducto);
            TextView txtProducto=(TextView) rowView.findViewById(R.id.Producto);
            TextView txtPrecio=(TextView) rowView.findViewById(R.id.Precio);
            TextView txtDescripcion=(TextView) rowView.findViewById(R.id.Descripcion);
            TextView txtImagen=(TextView) rowView.findViewById(R.id.Imagen);
            TextView txtMarca=(TextView) rowView.findViewById(R.id.Marca);

            txtidProducto.setText(String.format("ID: %s",producto.get(position).getId()));
            txtProducto.setText(String.format("Producto: %s",producto.get(position).getProducto()));
            txtPrecio.setText(String.format("Precio: %s",producto.get(position).getPrecio_venta()));
            txtDescripcion.setText(String.format("Descripcion: %s",producto.get(position).getDescripcion()));
            txtImagen.setText(String.format("Imagen: %s",producto.get(position).getImagen()));
            txtMarca.setText(String.format("Marca: %s",producto.get(position).getIdMarca()));

            return rowView;
        }
}

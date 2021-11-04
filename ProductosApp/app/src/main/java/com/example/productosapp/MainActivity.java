package com.example.productosapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.productosapp.interfaces.ProductoAPI;
import com.example.productosapp.models.Producto;
import com.google.gson.Gson;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    EditText edtCodigo;
    TextView tvNombre;
    TextView tvMarca;
    TextView tvDescripcion;
    TextView tvPrecio;
    ImageView imgProducto;
    Button btnBuscar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtCodigo=findViewById(R.id.edtCodigo);
        tvNombre=findViewById(R.id.tvNombre);
        tvMarca=findViewById(R.id.tvMarca);
        tvDescripcion=findViewById(R.id.tvDescripcion);
        tvPrecio=findViewById(R.id.tvPrecio);
        imgProducto=findViewById(R.id.imgProducto);
        btnBuscar=findViewById(R.id.btnBuscar);

        btnBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    private void find(String codigo){
        Retrofit retrofit=new Retrofit.Builder().baseUrl("localhost:8081/web_bd/")
                .addConverterFactory(GsonConverterFactory.create()).build();

        ProductoAPI productoAPI=retrofit.create(ProductoAPI.class);
        Call<Producto> call=productoAPI.find(codigo);
        call.enqueue(new Callback<Producto>() {
            @Override
            public void onResponse(Call<Producto> call, Response<Producto> response) {
                try{
                    if(response.isSuccessful()){
                        Producto p=response.body();
                        String URL_IMG="localhost:8081/web_bd/"+p.getPro_codigo()+".jpg";
                        tvNombre.setText(p.getPro_nombre());
                        tvMarca.setText(p.getPro_marca());
                        tvDescripcion.setText(p.getPro_descripcion());
                        tvPrecio.setText(p.getPro_precio().toString());
                        Glide.with(getApplication()).load(URL_IMG).into(imgProducto);


                    }
                }catch (Exception ex){
                    Toast.makeText(MainActivity.this, ex.getMessage(), Toast.LENGTH_SHORT);
                }
            }

            @Override
            public void onFailure(Call<Producto> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Error de conexion", Toast.LENGTH_SHORT);
            }
        });
    }
}
package com.example.apirest.Utils;

import com.example.apirest.Model.Producto;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ProductoService {
    @GET("listar/")
    Call<List<Producto>> getProducto();

}

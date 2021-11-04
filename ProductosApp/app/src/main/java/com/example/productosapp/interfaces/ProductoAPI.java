package com.example.productosapp.interfaces;

import com.example.productosapp.models.Producto;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ProductoAPI {
    @GET("api/producto/{id}")
    public Call<Producto> find(@Path("id") String id);
}

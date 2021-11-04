package com.example.apirest.Utils;

public class Apis {
    public static final String URL_001="localhost:8081/web_bd/";

    public static ProductoService getProductoService(){
       return Produ.getProdu(URL_001).create(ProductoService.class);
    }
}

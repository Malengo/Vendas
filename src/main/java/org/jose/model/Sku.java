package org.jose.model;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Sku {

    private String name;
    private int peso;

    public Sku() {
    }

    public Sku(String name, int peso) {
        this.name = name;
        this.peso = peso;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Sku> mapperByJson(JSONObject skus) {
        List<Sku> skuList = new ArrayList<>();
        skus.keySet().forEach(f ->
                skuList.add(new Sku(f, skus.getInt(f)))
        );
        return skuList;
    }
}

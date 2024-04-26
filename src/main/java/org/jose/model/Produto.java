package org.jose.model;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Produto {
    private String sku;
    private int qtd;

    public Produto() {
    }

    public Produto(String sku, int qtd) {
        this.sku = sku;
        this.qtd = qtd;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public int getQtd() {
        return qtd;
    }

    public void setQtd(int qtd) {
        this.qtd = qtd;
    }

    public List<Produto> mapperByJson(JSONArray produtos) {
        List<Produto> produtoList = new ArrayList<>();
        produtos.forEach(produtoCaixa -> {
            String sku = ((JSONObject) produtoCaixa).get("sku").toString();
            int qtd = ((JSONObject) produtoCaixa).getInt("qtd");
            Produto produto = new Produto(sku, qtd);
            produtoList.add(produto);
        });
        return produtoList;
    }

    public int getPeso(List<Sku> skus) {
        return skus.stream()
                .filter(sku -> sku.getName().equals(this.sku))
                .findFirst()
                .get()
                .getPeso() * this.qtd;
    }
}

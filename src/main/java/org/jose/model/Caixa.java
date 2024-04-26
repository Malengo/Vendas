package org.jose.model;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Caixa {
    private String name;
    private List<Produto> produtos;

    public Caixa() {
    }

    public Caixa(List<Produto> produtos, String name) {
        this.produtos = produtos;
        this.name = name;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Caixa> mapperByJson(JSONObject json) {
        List<Caixa> caixaList = new ArrayList<>();
        json.keySet().forEach(caixa -> {
            JSONArray produtos = json.getJSONArray(caixa);
            Produto produto = new Produto();
            List<Produto> produtoList = produto.mapperByJson(produtos);
            Caixa caixaObj = new Caixa(produtoList, caixa);
            caixaList.add(caixaObj);
        });
        return caixaList;
    }

    public int getTotalPeso(List<Sku> sku) {
        return produtos.stream().mapToInt(produto -> produto.getPeso(sku)).sum();
    }

    public int getTotalProduto(List<Sku> sku) {
        return produtos.size();
    }
}

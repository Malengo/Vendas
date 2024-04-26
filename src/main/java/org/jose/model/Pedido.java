package org.jose.model;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private String name;
    private List<Caixa> caixas;

    public Pedido() {
    }

    public Pedido(String name, List<Caixa> caixas) {
        this.name = name;
        this.caixas = caixas;
    }

    public List<Caixa> getCaixas() {
        return caixas;
    }

    public void setCaixas(List<Caixa> caixas) {
        this.caixas = caixas;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Pedido> mapperByJson(JSONObject pedidos) {
        List<Pedido> pedidoList = new ArrayList<>();

        pedidos.keySet().forEach(pedido ->{
            JSONObject caixas = pedidos.getJSONObject(pedido);
            Caixa caixa = new Caixa();
            List<Caixa> caixaList = caixa.mapperByJson(caixas);
            Pedido pedidoObj = new Pedido(pedido, caixaList);
            pedidoList.add(pedidoObj);
        });
        return pedidoList;
    }

    public int getTotalPeso(List<Sku> sku) {
        return caixas.stream().mapToInt(caixa -> caixa.getTotalPeso(sku)).sum();
    }

    public int getTotalProduto(List<Sku> sku) {
        return caixas.stream().mapToInt(caixa -> caixa.getTotalProduto(sku)).sum();
    }

}

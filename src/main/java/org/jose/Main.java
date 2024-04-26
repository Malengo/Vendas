package org.jose;

import org.jose.model.Pedido;
import org.jose.model.Sku;
import org.json.JSONObject;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        String path = "src/main/java/org/jose/vendas.json";
        try {
            String json = new String(Files.readAllBytes(Paths.get(path)));
            JSONObject jsonInput = new JSONObject(json);

            JSONObject pedidos = jsonInput.getJSONObject("pedidos");
            JSONObject pesoPorSku = jsonInput.getJSONObject("pesoPorSku");
            Sku sku = new Sku();
            Pedido pedido = new Pedido();
            List<Sku> skuList = sku.mapperByJson(pesoPorSku);
            List<Pedido> pedidoList = pedido.mapperByJson(pedidos);

            pedidoList.forEach(pedidoFinal ->{
                System.out.println("Pedido: " + pedidoFinal.getName() + " tem " + pedidoFinal.getTotalProduto(skuList) + " produtos e um peso total de " + pedidoFinal.getTotalPeso(skuList) + " gramas.");
            });
        } catch (Exception e) {
           System.out.println("Erro ao ler arquivo JSON " + e.getMessage());
        }
    }


}
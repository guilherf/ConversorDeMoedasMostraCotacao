package net.bifewagyu.cambios;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ConexcaoAPICambio {

    static String urlCambios = "https://economia.awesomeapi.com.br/xml/available";



    // refazer para retornar erros e voltar para lista de após fazer a conversão
    // algum dia eu penso se eu faço ou não

    // funcionando eu não mexo até saber fazer diferente




    public static void connect() throws IOException, InterruptedException {


        HttpClient urlCliente = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(urlCambios)).build();


        HttpResponse<String> response = urlCliente.send(request, HttpResponse.BodyHandlers.ofString());


        System.out.println("LISTA DE CAMBIOS DISPONIVEIS");
        cambio(response);

        Scanner scanner = new Scanner(System.in);
        System.out.println("\nDigite a sigla do câmbio que deseja consultar (ex: USD-BRL, EUR-BRL, BTC-BRL): ");
        String sigla = scanner.nextLine().toUpperCase().trim();

        String colocado = "https://economia.awesomeapi.com.br/json/last/" + sigla;
        HttpRequest request2 = HttpRequest.newBuilder()
                .uri(URI.create(colocado)).build();

        HttpResponse<String> response2 = urlCliente.send(request2, HttpResponse.BodyHandlers.ofString());

        System.out.println("\n--- Resultado da Cotação ---");

        String chaveJson = sigla.replace("-", "");


        JsonObject cota = JsonParser.parseString(response2.body()).getAsJsonObject();

        try {

            if (cota.has(chaveJson)) {
                Gson gson = new Gson();
                Moedas moedas = gson.fromJson(cota.get(chaveJson), Moedas.class);


                System.out.println("==================================================");
                System.out.println("                💱 COTAÇÃO ATUAL                  ");
                System.out.println("==================================================");
                System.out.println(" Moeda:          " + moedas.getName());
                System.out.println(" Compra (Bid):   R$ " + moedas.getBid());
                System.out.println(" Venda (Ask):    R$ " + moedas.getAsk());
                System.out.println(" Máxima do dia:  R$ " + moedas.getHigh());
                System.out.println(" Mínima do dia:  R$ " + moedas.getLow());
                System.out.println(" Atualizado em:  " + moedas.getCreate_date());
                System.out.println("==================================================");

            } else {
                System.out.println("Nenhum moeda encontrada");
            }

            if (cota.has(chaveJson)) {
                Gson gson = new Gson();
                Moedas moedas2 = gson.fromJson(cota.get(chaveJson), Moedas.class);


                System.out.println("=========================================================================================");
                System.out.println("Com base nas informações fornecida vamos fazer a conversão dos valores que vc fornecer: ");
                double valor = scanner.nextDouble();
                double valorConveter = Double.parseDouble(moedas2.getBid());

                double converterValor = valorConveter * valor;


                System.out.println("Com base ao valor fornecido aqui a conversão: " + moedas2.getName() + " " + converterValor + moedas2.getCodein());


            } else {
                System.out.println("Não foi possivel fazer a conversão");
            }


        } catch (Exception e) {
            System.out.println("ERRO: " + e.getMessage());

        }
    }

    private static void cambio(HttpResponse < String > response2) {
        String resultado = response2.body();
        Pattern pattern1 = Pattern.compile("<([A-Z\\-]+)>([^<]+)</([A-Z\\-]+)>");
        Matcher matcher1 = pattern1.matcher(resultado);
        int contador1 = 0;
        while (matcher1.find() && contador1 < 20) {
            String codigo1 = matcher1.group(1);
            String nome1 = matcher1.group(2);
            System.out.println("[" + codigo1 + "] -> " + nome1);
            contador1++;
        }
    }
}
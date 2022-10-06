package buscacep;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 *
 * @author JonathasCoelho
 */
public class BuscaCep {

    public static String cep, logradouro, complemento, bairro, localidade, uf, ibge, ddd = "";

    public static void main(String[] args) throws MalformedURLException, IOException {
        String endereco = "https://viacep.com.br/ws/93044600/json/";
        URL url = new URL(endereco);
        URLConnection request = url.openConnection();
        request.connect();
        JsonParser parser = new JsonParser();
        JsonElement element = parser.parse(new InputStreamReader((InputStream) request.getContent())); //Convert the input stream to a json element
        JsonObject jsonobj = element.getAsJsonObject(); //May be an array, may be an object. 

        try {
            cep = jsonobj.get("cep").getAsString();
        } catch (Exception e) {
        }
        try {
            logradouro = jsonobj.get("logradouro").getAsString();
        } catch (Exception e) {
        }
        try {
            bairro = jsonobj.get("bairro").getAsString();
        } catch (Exception e) {
        }
        try {
            localidade = jsonobj.get("localidade").getAsString();
        } catch (Exception e) {
        }
        try {
            uf = jsonobj.get("uf").getAsString();
        } catch (Exception e) {
        }
        try {
            ibge = jsonobj.get("ibge").getAsString();
        } catch (Exception e) {
        }
        try {
            ddd = jsonobj.get("ddd").getAsString();
        } catch (Exception e) {
        }
        try {
            cep = jsonobj.get("cep").getAsString();
        } catch (Exception e) {
        }

        System.out.println(cep + '\n' + '\n' + logradouro + '\n' + complemento + '\n' + bairro + '\n' + localidade + '\n' + uf + '\n' + ibge + '\n' + ddd);
    }

}

package br.com.fiap.repository;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Base64;
import java.util.List;

import com.google.gson.Gson;

import br.com.fiap.to.DadosPessoa;
import br.com.fiap.to.Documentos;

public class DadosPessoaRepository {

	// Key:fourndedgiallowernigions
	// Password:6e7fa4ed3378d4807df9975019057bec21257d48

	// Enviar os dados do dispositivo
	public void cadastrar(DadosPessoa dados) {

		try {
			URL url = new URL("http://8d59f7f7-531d-439b-9602-a7f658caa981-bluemix.cloudant.com/dados-pessoa/");
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();

			connection.setRequestMethod("POST");
			connection.setRequestProperty("charset", "utf-8");

			connection.setRequestProperty("Content-Type", "application/json");

			// Autorização
			String usuario = "----------------------";
			String senha = "------------------------";
			String encodedPass = usuario + ":" + senha;
			String encoded = Base64.getEncoder().encodeToString(encodedPass.getBytes());
			connection.setRequestProperty("Authorization", "Basic " + encoded);

			connection.setDoOutput(true);

			OutputStreamWriter writer = new OutputStreamWriter(connection.getOutputStream());
			writer.write(new Gson().toJson(dados));
			writer.close();

			int statusHttp = connection.getResponseCode();

			if (statusHttp != 201) {
				throw new Exception("Erro!");
			}

		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	// Buscar dados do dispositivo de uma pessoa

	public List<DadosPessoa> buscar(int dispositivo) throws Exception {

		URL url = new URL("http://8d59f7f7-531d-439b-9602-a7f658caa981-bluemix.cloudant.com/dados-pessoa/_find");
		HttpURLConnection con = (HttpURLConnection) url.openConnection();

		// configurações da requisição
		con.setRequestMethod("POST");
		con.setRequestProperty("Content-Type", "application/json");
		con.setRequestProperty("charset", "utf-8");
		
		// Autorização
		String usuario = "fourndedgiallowernigions";
		String senha = "6e7fa4ed3378d4807df9975019057bec21257d48";
		String encodedPass = usuario + ":" + senha;
		String encoded = Base64.getEncoder().encodeToString(encodedPass.getBytes());
		con.setRequestProperty("Authorization", "Basic " + encoded);

		String sql = "{\"selector\" : { \"dispositivo\" : " + dispositivo + " }, \"sort\" : "
				+ "[ { \"dispositivo\" : \"desc\" } ] }";

		con.setDoOutput(true);
		OutputStreamWriter writer = new OutputStreamWriter(con.getOutputStream());
		writer.write(sql);
		writer.close();

		int statusHttp = con.getResponseCode();

		if (statusHttp == 200) {

			BufferedReader reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
			StringBuilder builder = new StringBuilder();
			String linha;

			while ((linha = reader.readLine()) != null) {
				builder.append(linha);

			}

			// Transformar o JSON no objeto java

			Documentos doc = new Gson().fromJson(builder.toString(), Documentos.class);

			// System.out.println(builder.toString());
			// Retorna a lista de DadosPessoa
			return doc.getDocs();

		}

		return null;

	}

}

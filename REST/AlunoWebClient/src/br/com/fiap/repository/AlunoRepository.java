package br.com.fiap.repository;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;
import java.util.List;

import com.google.gson.Gson;

import br.com.fiap.entity.Aluno;

public class AlunoRepository {

	public void remover(int id) {
		URL url;
		try {

			System.out.println(id);
			url = new URL("http://localhost:8080/AlunoRestfull/rest/aluno/" + id);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();

			connection.setRequestMethod("DELETE");
			connection.setRequestProperty("charset", "utf-8");

			int status = connection.getResponseCode();

			if (status != 200) {
				throw new Exception("Erro!");
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void atualizar(Aluno aluno) {
		try {
			URL url = new URL("http://localhost:8080/AlunoRestfull/rest/aluno/");
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();

			connection.setRequestMethod("PUT");
			connection.setRequestProperty("charset", "utf-8");
			connection.setRequestProperty("Content-Type", "application/json");
			connection.setDoOutput(true);

			OutputStreamWriter writer = new OutputStreamWriter(connection.getOutputStream());
			writer.write(new Gson().toJson(aluno));
			writer.close();

			int statusHttp = connection.getResponseCode();

			if (statusHttp != 200) {
				throw new Exception("Erro");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void cadastrar(Aluno aluno) throws Exception {

		URL url = new URL("http://localhost:8080/AlunoRestfull/rest/aluno/");
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();

		connection.setRequestMethod("POST");
		connection.setRequestProperty("charset", "utf-8");
		connection.setRequestProperty("Content-Type", "application/json");
		connection.setDoOutput(true);

		OutputStreamWriter writer = new OutputStreamWriter(connection.getOutputStream());
		writer.write(new Gson().toJson(aluno));
		writer.close();

		int statusHttp = connection.getResponseCode();

		if (statusHttp != 201) {
			throw new Exception("Erro");
		}

	}

	public List<Aluno> listar() throws Exception {

		try {
			URL url = new URL("http://localhost:8080/AlunoRestfull/rest/aluno/");
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();

			connection.setRequestMethod("GET");
			connection.setRequestProperty("charset", "utf-8");

			int httpCode = connection.getResponseCode();

			if (httpCode == 200) {

				BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
				StringBuilder builder = new StringBuilder();
				String linha;

				while ((linha = reader.readLine()) != null) {
					builder.append(linha);
				}

				Aluno[] array = new Gson().fromJson(builder.toString(), Aluno[].class);

				return Arrays.asList(array);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		throw new Exception();

	}

	public List<Aluno> buscarPorNome(String nome) throws Exception {

		try {

			URL url = new URL("http://localhost:8080/AlunoRestfull/rest/aluno/" + nome);

			HttpURLConnection client = (HttpURLConnection) url.openConnection();

			client.setRequestMethod("GET");
			client.setRequestProperty("charset", "utf-8");

			int httpCode = client.getResponseCode();

			if (httpCode == 200) {
				BufferedReader buffer = new BufferedReader(new InputStreamReader(client.getInputStream()));

				StringBuilder builder = new StringBuilder();

				String linha;
				while ((linha = buffer.readLine()) != null) {
					builder.append(linha);
				}

				//return new Gson().fromJson(builder.toString(), Aluno.class);
				
				Aluno[] array = new Gson().fromJson(builder.toString(), Aluno[].class);

				return Arrays.asList(array);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		throw new Exception("Erro");
	}

}

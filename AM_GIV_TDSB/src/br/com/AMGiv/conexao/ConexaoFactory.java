package br.com.AMGiv.conexao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;

public final class ConexaoFactory {

	private static ConexaoFactory conexao = null;
	
	public static ConexaoFactory controlarInstancia() throws Exception{
		if(conexao == null){
			conexao = new ConexaoFactory();
		}
		return conexao;	
	}
	
	public Connection getConnection(String usuario,String senha) throws Exception{
		FileReader arquivo = new FileReader("D://banco.txt");
		//FileReader arquivo = new FileReader(System.getProperty("user.dir") + "/conexao/banco.txt");
		BufferedReader dados = new BufferedReader(arquivo);
		String url = dados.readLine();
		if(url.indexOf("oracle")>0){
			Class.forName("oracle.jdbc.OracleDriver");
		}else if(url.indexOf("mysql")>0){
			Class.forName("com.mysql.jdbc.Driver");
		}
		dados.close();
		
		return DriverManager.getConnection(url,usuario,senha);
		
	}

}

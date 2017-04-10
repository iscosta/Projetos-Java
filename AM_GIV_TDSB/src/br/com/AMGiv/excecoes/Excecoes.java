package br.com.AMGiv.excecoes;


public class Excecoes extends Exception {

	public Excecoes(String mensagem, Exception e){
		super(mensagem, e);
		this.print();
		e.printStackTrace();
	}
	
	public Excecoes(String mensagem){
		super(mensagem);		
	}
	
	public Excecoes(Exception e){
		if (e.getClass().toString().equals("class java.sql.SQLDataException")) {
			System.out.println("SQL Exception: "+e);
		}else if (e.getClass().toString().equals("class java.lang.NumberFormatException")) {
			System.out.println("Número Inválido!");
		}else if (e.getClass().toString().equals("class java.lang.ArrayIndexOfBound")) {
			System.out.println("Limite excedido!");
		}else if (e.getClass().toString().equals("class java.lang.ArithmeticException")) {
			System.out.println("Número dividido por 0");
		}else if (e.getClass().toString().equals("class java.lang.ArrayIndexOfBound")) {
			System.out.println("Index do Array não correspondente");
		}else if (e.getClass().toString().equals("class java.lang.NullPointerException")) {
			System.out.println("Value null in a case in an object required");
		}else if (e.getClass().toString().equals("class java.lang.FileNotFoundException")) {
			System.out.println("Attempt to open a non-existent file for reading");
		}else if (e.getClass().toString().equals("class java.lang.ClassCastException")) {
			System.out.println("Attempt to cast a String Object to Integer");
		}else{
			System.out.println("Erro desconhecido encontrado!");
			e.printStackTrace();
		}		
	}
	
	public void print() {
		System.out.println("===========Tratando Erro ===========");
		System.out.println(getMessage());
		System.out.println("PrintStackTrace ");		
	}

		
		
}
	



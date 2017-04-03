package model;

public class Parametro {
	
	private int n1, n2;
	private String operacao;
	
	public Parametro(int n1, int n2, String operacao){
		this.n1 = n1;
		this.n2 = n2;
		this.operacao = operacao;
	}
	
	public int getN1() {
		return n1;
	}
	public void setN1(int n1) {
		this.n1 = n1;
	}
	public int getN2() {
		return n2;
	}
	public void setN2(int n2) {
		this.n2 = n2;
	}
	public String getOperacao() {
		return operacao;
	}
	public void setOperacao(String operacao) {
		this.operacao = operacao;
	}
	
	public int Calcular(int n1, int n2, String operacao){
		
		int resultado=0;
		if(operacao.equals("soma")) {
			resultado = n1 + n2;
			return resultado;
		} else if (operacao.equals("sub")){
			resultado = n1 - n2;
			return resultado;
		} else if (operacao.equals("mult")){
			resultado = n1 * n2;
			return resultado;
		} else 
			resultado = n1 / n2;
		
		return resultado;
	}
	
	
	
	
}

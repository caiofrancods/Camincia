package Model;

public class Caminhao {
	private int codCaminhao;
	private String placa;
	private String marca;
	private int ano;
	private double cargaMaxima;
	
	public Caminhao(int codCaminhao, String placa, String marca, int ano, double cargaMaxima) {
		this.codCaminhao = codCaminhao;
		this.placa = placa;
		this.marca = marca;
		this.ano = ano;
		this.cargaMaxima = cargaMaxima;
	}
	
	public int getCodigo() {
		return codCaminhao;
	}

	public int getCodCaminhao() {
		return codCaminhao;
	}

	public String getPlaca() {
		return placa;
	}

	public String getMarca() {
		return marca;
	}

	public int getAno() {
		return ano;
	}

	public double getCargaMaxima() {
		return cargaMaxima;
	}
	
	
	
}

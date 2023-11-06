package View;

import java.text.SimpleDateFormat;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import Model.Caminhao;

public class CaminhaoTableModel extends AbstractTableModel{
	
	private List<Caminhao> lista;
	private String[] colunas = { "CODIGO", "MARCA", "PLACA", "ANO", "CARGAMAX" };

	private static final int CODIGO = 0;
	private static final int MARCA = 1;
	private static final int PLACA = 2;
	private static final int ANO = 3;
	private static final int CARGAMAX = 4;


	public Caminhao getCaminhao(int linha) {
		return lista.get(linha);
	}

	public CaminhaoTableModel(List<Caminhao> lista) {
		super();
		this.lista = lista;
	}

	@Override
	public int getRowCount() {
		return lista.size();
	}

	@Override
	public int getColumnCount() {
		return colunas.length;
	}

	@Override
	public String getColumnName(int column) {
		return colunas[column];
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Caminhao f = this.lista.get(rowIndex);

		switch (columnIndex) {
		case CODIGO:
			return f.getCodigo();
		case MARCA:
			return f.getMarca();
		case PLACA:
			return f.getPlaca();
		case ANO:
			return f.getAno();
		case CARGAMAX:
			return f.getCargaMaxima();
		default:
			throw new IndexOutOfBoundsException(
					"Ultrapassou os limites das colunas");
		}
	}


}

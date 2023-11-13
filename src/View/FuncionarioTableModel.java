package View;

import java.text.SimpleDateFormat;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import Model.Funcionario;


public class FuncionarioTableModel extends AbstractTableModel{
	private List<Funcionario> lista;
	private String[] colunas = { "CODIGO", "NOME", "CPF", "DATA.NASC", "DATA.CONT",
			"CARGO"};

	private static final int CODIGO = 0;
	private static final int NOME = 1;
	private static final int CPF = 2;
	private static final int DATANASC = 3;
	private static final int DATACONT = 4;
	private static final int CARGO = 5;

	private SimpleDateFormat sdf;

	public Funcionario getFuncionario(int linha) {
		return lista.get(linha);
	}

	public FuncionarioTableModel(List<Funcionario> lista) {
		super();
		this.lista = lista;
		sdf = new SimpleDateFormat("dd/MM/yyyy");
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
		Funcionario f = this.lista.get(rowIndex);

		switch (columnIndex) {
		case CODIGO:
			return f.getCodigo();
		case NOME:
			return f.getNome();
		case CPF:
			return f.getCpf();
		case DATANASC:
			return sdf.format(f.getDataNascimento());
		case DATACONT:
			return sdf.format(f.getDataContratacao());
		case CARGO:
			return f.getCargo();
		default:
			throw new IndexOutOfBoundsException(
					"Ultrapassou os limites das colunas");
		}
	}

}
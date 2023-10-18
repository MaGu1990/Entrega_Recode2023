package model;

import java.util.Date;

public class Servico {

	private int id_servico;
	private String tipo_servico;
	private Date data_agendamento;
	private Date data_inicio;
	private Date data_fim;

	public int getId_servico() {
		
		return id_servico;
			
}

	public String getTipo_servico() {
		return tipo_servico;
	}

	public void setTipo_servico(String tipo_servico) {
		this.tipo_servico = tipo_servico;
	}

	public Date getData_agendamento() {
		return data_agendamento;
	}

	public void setData_agendamento(Date data_agendamento) {
		this.data_agendamento = data_agendamento;
	}

	public Date getData_inicio() {
		return data_inicio;
	}

	public void setData_inicio(Date data_inicio) {
		this.data_inicio = data_inicio;
	}

	public Date getData_fim() {
		return data_fim;
	}

	public void setData_fim(Date data_fim) {
		this.data_fim = data_fim;
	}

	public void setId_servico(int id_servico) {
		this.id_servico = id_servico;
	}
	
}

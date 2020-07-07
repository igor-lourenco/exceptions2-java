package entitidades;

import exceptions.DomainException;

public class Conta {
	
	private Integer numero;
	private String cliente;
	private Double saldo;
	private Double limite;
	
	public Conta(Integer numero, String cliente, Double saldo, Double limite) {
		this.numero = numero;
		this.cliente = cliente;
		this.saldo = saldo;
		this.limite = limite;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getCliente() {
		return cliente;
	}

	public Double getSaldo() {
		return saldo;
	}

	public Double getLimite() {
		return limite;
	}

	public void setLimite(Double limite) {
		this.limite = limite;
	}
	
	public void deposito(double montante) {
		saldo += montante;
	}

	public void saque(double montante) {
		
		if(montante > limite) 
			throw new DomainException("O valor excede o limite de retirada");
		
		if(montante > saldo) 
			throw new DomainException("Saldo insuficiente");
		
		saldo -= montante;
	}
}

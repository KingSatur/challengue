package com.ceiba.challengue;

import java.math.BigDecimal;

import com.ceiba.challengue.exceptions.DineroInsuficienteException;

public class CuentaSample {

	private String persona;
	private BigDecimal saldo;
	private Banco banco;

	public CuentaSample(String persona, BigDecimal saldo) {
		super();
		this.persona = persona;
		this.saldo = saldo;
	}

	public Banco getBanco() {
		return banco;
	}

	public void setBanco(Banco banco) {
		this.banco = banco;
	}

	public String getPersona() {
		return persona;
	}

	public void setPersona(String persona) {
		this.persona = persona;
	}

	public BigDecimal getSaldo() {
		return saldo;
	}

	public void debito(BigDecimal mount) {
		if (this.saldo.subtract(mount)
				.compareTo(new BigDecimal(0)) < 0) {
			throw new DineroInsuficienteException(
					"Dinero insuficiente");
		}
		this.saldo = this.saldo.subtract(mount);
	}

	public void credito(BigDecimal mount) {
		this.saldo = this.saldo.add(mount);
	}

	public void setSaldo(BigDecimal saldo) {
		this.saldo = saldo;
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		if (!(obj instanceof CuentaSample)) {
			return false;
		}
		CuentaSample c = (CuentaSample) obj;
		if (this.persona == null || this.saldo == null) {
			return false;
		}

		return this.persona.equals(c.getPersona())
				&& this.saldo.equals(c.getSaldo());
	}

}

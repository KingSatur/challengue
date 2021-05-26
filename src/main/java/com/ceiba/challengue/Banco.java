package com.ceiba.challengue;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Banco {

	private String nombre;
	private List<CuentaSample> accounts;

	public List<CuentaSample> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<CuentaSample> accounts) {
		this.accounts = accounts;
	}

	public void addAccount(CuentaSample account) {
		this.accounts.add(account);
		account.setBanco(this);
	}

	public Banco(String nombre) {
		// TODO Auto-generated constructor stub
		this.nombre = nombre;
		this.accounts = new ArrayList<>();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void transferir(CuentaSample source,
			CuentaSample target, BigDecimal mount) {
		source.debito(mount);
		target.credito(mount);

	}

}

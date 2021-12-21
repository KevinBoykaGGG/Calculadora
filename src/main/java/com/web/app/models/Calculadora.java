package com.web.app.models;
import javax.validation.constraints.NotNull;

public class Calculadora {
	
	@NotNull(message = "No debe estar vacio")
	private float numero1;
	@NotNull(message = "No debe estar vacio")
	private float numero2;
	
	public float getNumero1() {
		return numero1;
	}
	public void setNumero1(float numero1) {
		this.numero1 = numero1;
	}
	public float getNumero2() {
		return numero2;
	}
	public void setNumero2(float numero2) {
		this.numero2 = numero2;
	}
	

}

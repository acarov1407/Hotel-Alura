package com.alura.reservaciones.enums;

public enum PaymentMethods {
	
	CREDITO("Tarjeta de Crédito"),
	DEBITO("Tarjeta de Débito"),
	EFECTIVO("Dinero en efectivo");
	
	private String displayName;

    private PaymentMethods(String displayName) {
        this.displayName = displayName;
    }
    
    @Override
    public String toString() {
    	return this.displayName;
    }
    
    
}

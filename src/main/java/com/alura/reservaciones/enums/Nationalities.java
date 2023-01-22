package com.alura.reservaciones.enums;

public enum Nationalities {
	
	AFGANO("afgano-afgana"),
	ALEMANIA("alemán-alemana"),
	ARABIA("árabe-árabe"),
	ARGENTINA("argentino-argentina"),
	AUSTRALIA("australiano-australiana"),
	BELGICA("belga-belga"),
	BOLIVIA("boliviano-boliviana"),
	BRASIL("brasileño-brasileña"),
	CAMBOY("camboyano-camboyana"),
	CANADA("canadiense-canadiense"),
	CHILE("chileno-chilena"),
	CHINA("chino-china"),
	COLOMBIA("colombiano-colombiana"),
	COREA("coreano-coreana"),
	COSTA_RICA("costarricense-costarricense"),
	CUBA("cubano-cubana"),
	DINAMARCA("danés-danesa"),
	ECUADOR("ecuatoriano-ecuatoriana"),
	EGIPTO("egipcio-egipcia"),
	SALVADOR("salvadoreño-salvadoreña"),
	ESCOCIA("escocés-escocesa"),
	ESPANA("español-española"),
	ESTADOS_UNIDOS("estadounidense-estadounidense"),
	ESTONIA("estonio-estonia"),
	ETIOPIA("etiope-etiope"),
	FILIPINAS("filipino-filipina"),
	FINLANDIA("finlandés-finlandesa"),
	FRANCIA("francés-francesa"),
	GALES("galés-galesa"),
	GRECIA("griego-griega"),
	GUATEMALA("guatemalteco-guatemalteca"),
	HAITI("haitiano-haitiana"),
	HOLANDA("holandés-holandesa"),
	HONDURAS("hondureño-hondureña"),
	INDONESIA("indonés-indonesa"),
	INGLATERRA("inglés-inglesa"),
	IRAK("iraquí-iraquí"),
	IRAN("iraní-iraní"),
	IRLANDIA("irlandés-irlandesa"),
	ISRAEL("israelí-israelí"),
	ITALIA("italiano-italiana"),
	JAPON("japonés-japonesa"),
	JORDANIA("jordano-jordana"),
	LAOS("laosiano-laosiana"),
	LETONIA("letón-letona");
	
	
	

	
	private String displayName;

    private Nationalities(String displayName) {
        this.displayName = displayName;
    }
    
    @Override
    public String toString() {
    	return this.displayName;
    }
}

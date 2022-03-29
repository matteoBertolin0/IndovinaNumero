package it.polito.tdp.IndovinaNumero.model;

import java.security.InvalidParameterException;
import java.util.*;

public class Model {
	
	private int segreto;
	private final int TMAX = 8;
	private final int NMAX = 100;
	private int tentativiFatti;
	private boolean inGioco = false;
	
	private Set<Integer> tentativi;
	
	public void nuovaPartita() {
    	//gestione di una nuova partita
    	this.segreto = (int)((Math.random() * NMAX) +1);
    	this.tentativiFatti = 0;
    	this.inGioco=true;
    	this.tentativi = new HashSet<Integer>();
    			
	}
	
	public int tentativo(int tentativo) throws Exception {
		
		if(!tentativoValido(tentativo))
			throw new InvalidParameterException("Devi inserire un numero tra 1 e "+	NMAX+"che non hai ancora utilizzato");

		if(!inGioco)
			throw new IllegalStateException("HAI PERSO! La partita è terminata");

		this.tentativiFatti++;
		this.tentativi.add(tentativo);
		
		if(this.tentativiFatti==this.TMAX)
			this.inGioco=false;
		
		if(tentativo==this.segreto) {
			this.inGioco=false;
			return 0;
		}else if(tentativo<this.segreto)
			return -1;
		else
			return 1;			
	}

	private boolean tentativoValido(int tentativo) {
		if(tentativo<1 || tentativo>NMAX || tentativi.contains(tentativo))
			return false;
		
		return true;
	}

	public int getSegreto() {
		return segreto;
	}

	public int getTMAX() {
		return TMAX;
	}

	public int getNMAX() {
		return NMAX;
	}

	public int getTentativiFatti() {
		return tentativiFatti;
	}
	
	
}

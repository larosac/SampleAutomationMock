package com.reply.model;

import java.util.ArrayList;

import lombok.Data;

@Data
public class Replyer {
	
	private String nome;
	private String cognome;
	private ArrayList<String> competenze;
	
	
	public Replyer() {
	}

}

package fr.imie.formation.DTO;


import java.util.Date;

public class InvitationDTO {
	private int num;
	private int num_projet;
	private int num_util;
	private String message;
	private boolean reponse;
	private UtilisateurDTO utilisateur;
	private Date date;
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public boolean isReponse() {
		return reponse;
	}
	public void setReponse(boolean reponse) {
		this.reponse = reponse;
	}
	public int getNum_projet() {
		return num_projet;
	}
	public void setNum_projet(int num_projet) {
		this.num_projet = num_projet;
	}
	public int getNum_util() {
		return num_util;
	}
	public void setNum_util(int num_util) {
		this.num_util = num_util;
	}
	public UtilisateurDTO getUtilisateur() {
		return utilisateur;
	}
	public void setUtilisateur(UtilisateurDTO utilisateur) {
		this.utilisateur = utilisateur;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	

}


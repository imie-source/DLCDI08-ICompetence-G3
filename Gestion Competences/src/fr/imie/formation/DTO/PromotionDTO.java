package fr.imie.formation.DTO;

import java.util.List;

import fr.imie.formation.DTO.UtilisateurDTO;

public class PromotionDTO {

	private int num;
	private String intitule;
	private int annee;
	private List<UtilisateurDTO> listUtilisateur;

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getIntitule() {
		return intitule;
	}

	public void setIntitule(String intitule) {
		this.intitule = intitule;
	}

	public int getAnnee() {
		return annee;
	}

	public void setAnnee(int annee) {
		this.annee = annee;
	}

	public List<UtilisateurDTO> getListUtilisateur() {
		return listUtilisateur;
	}

	public void setListUtilisateur(List<UtilisateurDTO> listUtilisateur) {
		this.listUtilisateur = listUtilisateur;
	}

}

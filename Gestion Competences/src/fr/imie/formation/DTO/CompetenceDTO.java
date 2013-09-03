package fr.imie.formation.DTO;

import java.util.List;

public class CompetenceDTO {

	private int num;
	private String nom;
	private List<NiveauDTO> listNiveau;

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public List<NiveauDTO> getListNiveau() {
		return listNiveau;
	}

	public void setListNiveau(List<NiveauDTO> listNiveau) {
		this.listNiveau = listNiveau;
	}

}

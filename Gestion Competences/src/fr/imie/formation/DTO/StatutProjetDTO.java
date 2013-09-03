package fr.imie.formation.DTO;

import java.util.List;

public class StatutProjetDTO {
	private int num;
	private String valeurStatut;
	private List<ProjetDTO> listProjet;
	

	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getValeurStatut() {
		return valeurStatut;
	}
	public void setValeurStatut(String valeurStatut) {
		this.valeurStatut = valeurStatut;
	}
	public List<ProjetDTO> getListProjet() {
		return listProjet;
	}
	public void setListProjet(List<ProjetDTO> listProjet) {
		this.listProjet = listProjet;
	}
	
	

}

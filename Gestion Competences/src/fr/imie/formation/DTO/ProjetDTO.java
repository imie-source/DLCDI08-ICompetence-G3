package fr.imie.formation.DTO;

import java.util.List;

public class ProjetDTO {

	private Integer num;
	private String intitule;
	private String description;
	private StatutProjetDTO statutProjet;
	private UtilisateurDTO chefDeProjet;
	private List<UtilisateurDTO> listUtilProjet;
	
	
	public List<UtilisateurDTO> getListUtilProjet() {
		return listUtilProjet;
	}
	public void setListUtilProjet(List<UtilisateurDTO> listUtilProjet) {
		this.listUtilProjet = listUtilProjet;
	}
	public UtilisateurDTO getChefDeProjet() {
		return chefDeProjet;
	}
	public void setChefDeProjet(UtilisateurDTO chefDeProjet) {
		this.chefDeProjet = chefDeProjet;
	}
	public Integer getNum() {
		return num;
	}
	public void setNum(Integer num) {
		this.num = num;
	}
	public String getIntitule() {
		return intitule;
	}
	public void setIntitule(String intitule) {
		this.intitule = intitule;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public StatutProjetDTO getStatutProjet() {
		return statutProjet;
	}
	public void setStatutProjet(StatutProjetDTO statutProjet) {
		this.statutProjet = statutProjet;
	}
	
	
	
}

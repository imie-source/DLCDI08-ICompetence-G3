package fr.imie.formation.DTO;

public class NiveauDTO {

	private int num;
	private UtilisateurDTO utilisateur;
	private CompetenceDTO competence;
	private String valeur;

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}


	public UtilisateurDTO getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(UtilisateurDTO utilisateur) {
		this.utilisateur = utilisateur;
	}

	public CompetenceDTO getCompetence() {
		return competence;
	}

	public void setCompetence(CompetenceDTO competence) {
		this.competence = competence;
	}

	public String getValeur() {
		return valeur;
	}

	public void setValeur(String valeur) {
		this.valeur = valeur;
	}

}

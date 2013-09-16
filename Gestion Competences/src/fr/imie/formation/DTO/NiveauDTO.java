package fr.imie.formation.DTO;

public class NiveauDTO {

	private int num;
	private String nom;
	private UtilisateurDTO utilisateur;
	private CompetenceDTO competence;

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

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

}

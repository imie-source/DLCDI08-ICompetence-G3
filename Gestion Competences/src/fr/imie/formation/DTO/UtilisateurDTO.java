package fr.imie.formation.DTO;

import java.util.Date;
import java.util.List;

public class UtilisateurDTO {

	private Integer num;
	private String nom;
	private String prenom;
	private Date dateNaissance;
	private int age;
	private String adresse;
	private List<NiveauDTO> listNiveau;
	private PromotionDTO promotion;
	private String login;
	private String password;

	public UtilisateurDTO() {

	}

	public UtilisateurDTO(String nom, String prenom, int age) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.age = age;
	}

	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public List<NiveauDTO> getListNiveau() {
		return listNiveau;
	}

	public void setListNiveau(List<NiveauDTO> listNiveau) {
		this.listNiveau = listNiveau;
	}

	public PromotionDTO getPromotion() {
		return promotion;
	}

	public void setPromotion(PromotionDTO promotion) {
		this.promotion = promotion;
	}

	public Date getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}
	
	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}

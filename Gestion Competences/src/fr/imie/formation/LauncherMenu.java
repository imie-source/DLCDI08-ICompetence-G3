package fr.imie.formation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import fr.imie.formation.DAO.exceptions.DAOException;
import fr.imie.formation.DTO.CompetenceDTO;
import fr.imie.formation.DTO.NiveauDTO;
import fr.imie.formation.DTO.PromotionDTO;
import fr.imie.formation.DTO.UtilisateurDTO;
import fr.imie.formation.factory.DAOFactory2;
import fr.imie.formation.factory.interfaces.IDAOFactory;
import fr.imie.formation.services.exceptions.ServiceException;
import fr.imie.formation.services.interfaces.ICompetenceNiveauService;
import fr.imie.formation.services.interfaces.IPromotionService;
import fr.imie.formation.services.interfaces.IUtilisateurService;
import fr.imie.formation.transactionalFramework.exception.TransactionalConnectionException;
import fr.imie.formation.utils.DateStringUtil;
import fr.imie.formation.utils.Ecran;

public class LauncherMenu {

	private static final String EFFACECONSOLE = "\033[H\033[2J";
	private static UtilisateurDTO currentUtilisateur = null;
	private static CompetenceDTO currentCompetence = null;
	
	//Choisi à froid la factory 1 ou 2
	//static IDAOFactory daoFactory = DAOFactory1.getInstance();
	static IDAOFactory daoFactory = DAOFactory2.getInstance();
	
	static ICompetenceNiveauService competenceNiveauService = daoFactory.createCompetenceNiveauService(null);
	static IPromotionService promotionService = daoFactory.createPromotionService(null);
	static IUtilisateurService utilisateurService = daoFactory.createUtilisateurService(null);

	
	
	public static void main(String[] args) throws TransactionalConnectionException, ServiceException, DAOException {

		Ecran currentEcran = Ecran.menu;
		Boolean endApplication = false;
		List<UtilisateurDTO> listUtil = null;
		List<CompetenceDTO> listComp = null;
		BufferedReader bufferRead = new BufferedReader(new InputStreamReader(
				System.in));
		String s = null;

		while (!endApplication) {
			String eraseConsole = EFFACECONSOLE;
			System.out.print(eraseConsole);
			switch (currentEcran) {

			case menu:
				// ecran 1 = Afficher la liste de choix
				System.out.println("1 - Liste des utilisateurs");
				System.out.println("2 - Liste des compétences");
				System.out.println("3 - close");

				try {
					s = bufferRead.readLine();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				if (s != null) {
					Integer choix = Integer.valueOf(s);
					switch (choix) {

					case 1:
						// ecran 2 = Liste de tous les utilisateurs
						currentEcran = Ecran.listeUtilisateur;
						break;

					case 2:
						// ecran 4 = Liste de toutes les compétences
						currentEcran = Ecran.listeCompetence;
						break;

					case 3:
						endApplication = true;
						break;

					default:
						break;
					}
				}
				break;

			case listeUtilisateur:
				// ecran 2 = Liste de tous les utilisateurs
				listUtil = utilisateurService.readAllUtilisateur();
				int i = 1;
				for (UtilisateurDTO utilisateur : listUtil) {

					System.out.println("N° :" + i + "  -NOM :"
							+ utilisateur.getNom() + "  -PRENOM :"
							+ utilisateur.getPrenom() + "  -AGE :"
							+ utilisateur.getAge() + "  -PROMOTION :"
							+ utilisateur.getPromotion().getIntitule() + " "
							+ utilisateur.getPromotion().getAnnee());
					System.out
							.println("_______________________________________________________________________________________________________");
					i++;
				}

				System.out.println("0 - retour");
				System.out.println("1 - afficher un utilisateur");
				System.out.println("2 - ajouter un utilisateur");
				System.out.println("3 - modifier un utilisateur");
				System.out.println("4 - supprimer un utilisateur");

				try {
					s = bufferRead.readLine();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				if (s != null) {
					Integer choix = Integer.valueOf(s);
					switch (choix) {

					case 0:
						currentEcran = Ecran.menu;
						break;

					case 1:
						currentEcran = Ecran.afficheUtilisateur;
						break;

					case 2:
						currentEcran = Ecran.ajoutUtilisateur;
						break;

					case 3:
						currentEcran = Ecran.modificationUtilisateur;
						break;

					case 4:
						currentEcran = Ecran.suppressionUtilisateur;
						break;

					default:
						break;
					}
				}
				break;

			case afficheUtilisateur:
				// ecran 3 = Affiche un utilisateur

				UtilisateurDTO utilisateurAffiche = readUtilisateur(listUtil);
				if (utilisateurAffiche.getListNiveau().isEmpty()) {
					System.out.println("-NOM :" + utilisateurAffiche.getNom()
							+ "  -PRENOM :" + utilisateurAffiche.getPrenom()
							+ "  -PROMOTION :"
							+ utilisateurAffiche.getPromotion().getIntitule()
							+ " "
							+ utilisateurAffiche.getPromotion().getAnnee());
					System.out
							.println("_______________________________________________________________________________________________________");

				}

				System.out.println("1 - retour");
				System.out.println("0 - retour menu");

				try {
					s = bufferRead.readLine();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				if (s != null) {
					Integer choix = Integer.valueOf(s);
					switch (choix) {

					case 0:
						currentEcran = Ecran.menu;
						break;

					case 1:
						currentEcran = Ecran.listeUtilisateur;
						break;

					default:
						break;
					}
				}
				break;

			case listeCompetence:
				// ecran 4 = Liste de toutes les compétences
				listComp = competenceNiveauService.readAllCompetence();
				int j = 1;
				for (CompetenceDTO competence : listComp) {
					System.out.println("N° :" + j + "  -NOM :"
							+ competence.getNom());
					System.out
							.println("_______________________________________________________________________________________________________");
					j++;
				}

				System.out.println("1 - retour");
				System.out.println("2 - choix d'une competence");

				try {
					s = bufferRead.readLine();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				if (s != null) {
					Integer choix = Integer.valueOf(s);
					switch (choix) {

					case 1:
						currentEcran = Ecran.menu;
						break;

					case 2:
						currentEcran = Ecran.afficheCompetence;
						break;

					default:
						break;
					}
				}
				break;

			case afficheCompetence:
				// ecran 5 = Affiche une compétence
				System.out.println("Saisir l'identifiant d'une competence");

				try {
					s = bufferRead.readLine();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				if (s != null) {
					Integer choix = Integer.valueOf(s);
					currentCompetence = listComp.get(choix);

					List<NiveauDTO> listNiveau = competenceNiveauService
							.readNiveauUtilisateurCompetence(currentCompetence);

					for (NiveauDTO niveau : listNiveau) {

						System.out.println("-COMPETENCE :"
								+ niveau.getCompetence() + "  -UTILISATEUR :"
								+ niveau.getUtilisateur() + "  -NIVEAU :"
								+ niveau.getNom());
						System.out
								.println("_______________________________________________________________________________________________________");

					}
				}

				System.out.println("1 - retour");
				System.out.println("0 - retour menu");

				try {
					s = bufferRead.readLine();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				if (s != null) {
					Integer choix = Integer.valueOf(s);
					switch (choix) {

					case 0:
						currentEcran = Ecran.menu;
						break;

					case 1:
						currentEcran = Ecran.listeCompetence;
						break;

					default:
						break;
					}
				}
				break;

			case ajoutUtilisateur:
				// ecran 6 = Ajout d'un utilisateur
				String nom = null;
				String prenom = null;
				String dateNaissance = null;
				List<PromotionDTO> listPromo = promotionService.readAllPromotion();

				String choixUser = null;

				try {
					System.out.println("ajouter un nom");
					nom = bufferRead.readLine();
					System.out.println("ajouter un prenom");
					prenom = bufferRead.readLine();
					System.out.println("ajouter une date de naissance");
					dateNaissance = bufferRead.readLine();
					System.out.println();
					System.out.println("LISTE DES PROMOTIONS");
					System.out.println();

					int k = 1;
					for (PromotionDTO promotion : listPromo) {
						System.out.println("N° :" + k + "  -PROMOTION "
								+ promotion.getIntitule() + " "
								+ promotion.getAnnee());
						k++;
					}

					System.out.println("ajouter une promotion");
					choixUser = bufferRead.readLine();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				int choixPromo = Integer.parseInt(choixUser);
				if (nom != null) {

					UtilisateurDTO utilisateurAjout = new UtilisateurDTO();

					utilisateurAjout.setNom(nom);
					utilisateurAjout.setPrenom(prenom);
					utilisateurAjout.setDateNaissance(DateStringUtil
							.getInstance().getDateString(dateNaissance));
					utilisateurAjout
							.setPromotion(listPromo.get(choixPromo - 1));

					utilisateurService.createUtilisateur(utilisateurAjout);

				}

				System.out.println("1 - retour");
				System.out.println("0 - retour menu");

				try {
					s = bufferRead.readLine();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				if (s != null) {
					Integer choix = Integer.valueOf(s);
					switch (choix) {

					case 0:
						currentEcran = Ecran.menu;
						break;

					case 1:
						currentEcran = Ecran.listeUtilisateur;
						break;

					default:
						break;
					}
				}
				break;

			case modificationUtilisateur:
				// ecran 7 = Modification d'un utilisateur

				UtilisateurDTO utilisateurUpdate = readUtilisateur(listUtil);

				String nomUpdateOld = utilisateurUpdate.getNom();
				String prenomUpdateOld = utilisateurUpdate.getPrenom();

				String nomUpdateNew = null;
				String prenomUpdateNew = null;

				try {
					System.out.println("Modifier le nom :"
							+ utilisateurUpdate.getNom());
					nomUpdateNew = bufferRead.readLine();
					System.out.println("Modifier le prénom :"
							+ utilisateurUpdate.getPrenom());
					prenomUpdateNew = bufferRead.readLine();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				utilisateurUpdate.setNom(nomUpdateNew);
				utilisateurUpdate.setPrenom(prenomUpdateNew);

				utilisateurService.updateUtilisateur(utilisateurUpdate);

				System.out.println("L'utilisateur " + nomUpdateOld + " "
						+ prenomUpdateOld);
				System.out.println("a été modifié en :");
				System.out.println(nomUpdateNew + " " + prenomUpdateNew);
				System.out.println();
				System.out.println("1 - retour");
				System.out.println("0 - retour menu");

				try {
					s = bufferRead.readLine();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				if (s != null) {
					Integer choix = Integer.valueOf(s);
					switch (choix) {

					case 0:
						currentEcran = Ecran.menu;
						break;

					case 1:
						currentEcran = Ecran.listeUtilisateur;
						break;

					default:
						break;
					}
				}
				break;

			case suppressionUtilisateur:
				// ecran 8 = Suppression d'un utilisateur

				UtilisateurDTO utilisateurDelete = readUtilisateur(listUtil);
				utilisateurService.deleteUtilisateur(utilisateurDelete);

				System.out.println("L'utilisateur "
						+ utilisateurDelete.getNom() + " "
						+ utilisateurDelete.getPrenom() + " a été supprimé");
				System.out.println();
				System.out.println("1 - retour");
				System.out.println("0 - retour menu");

				try {
					s = bufferRead.readLine();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				if (s != null) {
					Integer choix = Integer.valueOf(s);
					switch (choix) {

					case 0:
						currentEcran = Ecran.menu;
						break;

					case 1:
						currentEcran = Ecran.listeUtilisateur;
						break;

					default:
						break;
					}
				}
				break;

			default:
				break;
			}

		}

	}

	private static UtilisateurDTO readUtilisateur(List<UtilisateurDTO> listUtil) throws TransactionalConnectionException, DAOException {

		BufferedReader bufferRead = new BufferedReader(new InputStreamReader(
				System.in));
		String choixUser = null;
		UtilisateurDTO utilisateur = new UtilisateurDTO();

		System.out.println("Saisir l'identifiant d'un utilisateur");

		try {
			choixUser = bufferRead.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (choixUser != null) {
			Integer choix = Integer.valueOf(choixUser);

			currentUtilisateur = listUtil.get(choix - 1);

			try {
				utilisateur = utilisateurService.readUtilisateur(currentUtilisateur);
			} catch (ServiceException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			String nom = utilisateur.getNom();
			String prenom = utilisateur.getPrenom();
			int age = utilisateur.getAge();

			List<NiveauDTO> listNiveau = utilisateur.getListNiveau();

			if (!listNiveau.isEmpty()) {
				for (NiveauDTO niveau : listNiveau) {
					String niv = niveau.getNom();
					/*String competence = niveau.getCompetence();

					System.out.println("-NOM :" + nom + "  -PRENOM :" + prenom
							+ "  -AGE :" + age + "  -COMPETENCE :" + competence
							+ "  -NIVEAU :" + niv);*/
					System.out
							.println("_______________________________________________________________________________________________________");
				}
			}

		}

		return utilisateur;
	}

}

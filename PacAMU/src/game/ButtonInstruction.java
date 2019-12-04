package game;

import java.awt.Color;
import javafx.scene.image.Image;

import amuEngine.GameRoom;
import amuEngine.UI.Clickable;
import amuEngine.UI.TextBox;

public class ButtonInstruction extends Clickable {

	
	public ButtonInstruction(String name) {
		super(name);
	}
	
	public ButtonInstruction(Image img) {
		super(img);
	}
	
	public void onClick() {
		GameRoom instructions = new GameRoom(40);
		
		
		TextBox help = new TextBox(10, 10);
		help.setSize(10);
		help.setText("Bienvenue sur le jeu PAC-AMU.\n "
				+ "Vous �tes ici sur la page d'instructions du jeu afin de bien comprendre quel est le but de ce dernier.\n"
				+ "Histoire :\n"
				+ "Timmy est un �tudiant de la Facult� des Sciences de Luminy, et comme tous les jours Timmy a cours t�t le matin.\n"
				+ "Et comme tous les matins, Timmy ne s'est pas forc�ment r�veill� bien � l'heure. Manque de pot, tandis que Timmy courrait pour\n"
				+ "rejoindre son cours de G�nie Logiciel, il tr�bucha et s'�crasa contre le sol, faisant tomber toutes ses feuilles de cours, et alors\n"
				+ "que Timmy allait les ramasser un �norme coup de vent les emporta dans diff�rents coins de la fac. Aidez Timmy � retrouver toutes ses\n"
				+ "feuilles de cours tout en faisant attention aux f�roces sangliers.\n"
				+ "\n"
				+ "But :\n"
				+ "Le but est de parcourir le niveau et r�cup�rer toutes les feuilles sans vous faire attraper par les sangliers. Vous pouvez utiliser\n"
				+ "les bonus diss�min�s sur la map comme les caf�s et les bottes. Les caf�s permettront de tuer les sangliers, tandis que les bottes \n"
				+ "permettront de marcher dans les carr�s d'herbe.\n"
				+ "\n"
				+ "Commandes :\n"
				+ "fl�che droite : Pour aller � droite\n"
				+ "fl�che gauche : Pour aller � gauche\n"
				+ "fl�che du haut : Pour aller vers le haut\n"
				+ "fl�che du bas : Pour aller vers le bas\n"
				+ "P : pour mettre le jeu en pause\n"
				+ "\n"
				+ "Utilisation de l'�diteur de niveaux :\n"
				+ "Dans le dossier de jeu PAC-AMU vous trouverez un dossier nomm� <Editeur> dans lequel il y aura un fichier .txt modifiable.\n"
				+ "m = mur\n"
				+ "1 = etudiant\n"
				+ "2 = sanglier niveau 1\n"
				+ "3 = sanglier niveau 2\n"
				+ "4 = feuilles de cours\n"
				+ "5 = caf�\n"
				+ "6 = bottes\n"
				+ "0 = case vides ou traversables\n"
				+ "La dimension exig�e est en : 20 x 14\n"
				+ "Enjoy !\n"
				+ "\n"
				+ "AMUsez-vous bien sur PAC-AMU ! ;) ");
		instructions.addText(help);
		
		ButtonBack back = new ButtonBack(new Image("img/buttons/back.png"));
		back.addToRoom(instructions);
		back.setPos(400, 400);
		GameManager.changeRoom(instructions);
		
	}
	
}

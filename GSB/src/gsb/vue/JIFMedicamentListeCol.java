package gsb.vue;

import gsb.modele.Medicament;
import gsb.modele.dao.MedicamentDao;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 * @author Isabelle
 * 3 mars 2015
 * TODO Pour changer le mod�le de ce commentaire de type g�n�r�, allez � :
 * Fen�tre - Pr�f�rences - Java - Style de code - Mod�les de code
 */
public class JIFMedicamentListeCol extends JInternalFrame implements ActionListener {

	private static final long serialVersionUID = 1L;

	private ArrayList<Medicament> lesMedicaments;


	protected JPanel p;
	protected JScrollPane scrollPane;
	protected JPanel pSaisie;
	protected JTextField JTcodeMedicament;
	protected JButton JBafficherFiche;
	protected MenuPrincipal fenetreContainer;

	public JIFMedicamentListeCol(MenuPrincipal uneFenetreContainer) {

		fenetreContainer = uneFenetreContainer;
		// r�cup�ration des donn�es Medicament dans la collection
		lesMedicaments = MedicamentDao.retournerCollectionDesMedicaments();

		int nbLignes = lesMedicaments.size();

		JTable table;
		
		

		p = new JPanel(); // panneau principal de la fen�tre

		int i=0;
		String[][] data = new String[nbLignes][6] ;
		for(Medicament unMedicament : lesMedicaments){
			data[i][0] = unMedicament.getDepotLegal();
			data[i][1] = unMedicament.getNomCommercial();
			data[i][2] = unMedicament.getComposition();
			data[i][3] = unMedicament.getEffets();
			data[i][4] = unMedicament.getContreIndication();
			data[i][5] = unMedicament.getPrixEchantillon();
			data[i][6] = unMedicament.getCodeFamille().getCodeFamille();
			i++;
			}
		String[] columnNames = {"DepotLegal", "NomCommercial","Composition","Effets", "ContreIndication", "PrixEchantillon", "CodeFamille"};
		table = new JTable(data, columnNames);
		
		scrollPane = new JScrollPane(table);
		scrollPane.setPreferredSize(new Dimension(400, 200));
		p.add(scrollPane);
		
		pSaisie = new JPanel();
		JTcodeMedicament = new JTextField(20);
		JTcodeMedicament.setMaximumSize(JTcodeMedicament.getPreferredSize());
		JBafficherFiche = new JButton("Afficher Fiche m�dicament");
		JBafficherFiche.addActionListener(this);
		pSaisie.add(JTcodeMedicament);
		pSaisie.add(JBafficherFiche);
		p.add(pSaisie);
		
		// mise en forme de la fen�tre
		Container contentPane = getContentPane();
		contentPane.add(p);
	}

	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent arg0) {
		Object source = arg0.getSource();
   		if (source == JBafficherFiche){
   			Medicament unMedicament = MedicamentDao.rechercher(JTcodeMedicament.getText());
   			if (unMedicament!=null){
   	   			fenetreContainer.ouvrirFenetre(new JIFMedicamentFiche(unMedicament));
   			}
   		}	
	}
}

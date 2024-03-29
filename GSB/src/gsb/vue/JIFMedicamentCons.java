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
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;


public class JIFMedicamentCons extends JInternalFrame  implements ActionListener {
	
	/**
	 * Commentaire pour <code>serialVersionUID</code>
	 */
	private static final long serialVersionUID = 1L;
	private JButton premier;
    private JButton suivant;
    private JButton precedent; 
    private JButton dernier; 
    private ArrayList<Medicament> lesMedicaments;
	private int indiceEnCours;
        
    public JIFMedicamentCons() {
        super();
        premier = new JButton("Premier");
        pBoutons.add(premier);
        suivant = new JButton("Suivant");
        pBoutons.add(suivant);
        precedent = new JButton("Precedent");
        pBoutons.add(precedent);
        dernier = new JButton("Dernier");
        pBoutons.add(dernier);
        // d�claration des sources d'�v�nements
        premier.addActionListener(this);
        suivant.addActionListener(this);
        precedent.addActionListener(this);
        dernier.addActionListener(this);
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        setTitle("Consultation donn�es M�dicaments");
        
        // r�cup�ration des donn�es M�dicament dans la collection
        lesMedicaments = MedicamentDao.retournerCollectionDesMedicaments();
        indiceEnCours = 0;
        
        if (lesMedicaments.size()!=0){ // si collection non vide, affichage des donn�es du premier Medicament
        	Medicament leMedicament = lesMedicaments.get(0);
	    	remplirText(leMedicament);
	    	}
        
        // ajout d'un �couteur d'�v�nement pour la fermeture de la fen�tre
        addInternalFrameListener(new InternalFrameAdapter(){
            public void  internalFrameClosing(InternalFrameEvent e) {
                          //le code que tu veux ex�cuter � la fermeture de la JInternalFrame
            }
        });
    }
	
    public void actionPerformed(ActionEvent evt) { 
		Object source = evt.getSource();
   		if (source == premier){
				indiceEnCours = 0;
				Medicament leMedicament = lesMedicaments.get(indiceEnCours);
		    	remplirText(leMedicament);				}
		 else if (source == dernier){
				indiceEnCours = lesMedicaments.size() - 1;
				Medicament leMedicament = lesMedicaments.get(indiceEnCours);
		    	remplirText(leMedicament);
				}
		 else if (source == precedent){
				if (indiceEnCours > 0) indiceEnCours = indiceEnCours - 1;
				Medicament leMedicament = lesMedicaments.get(indiceEnCours);
		    	remplirText(leMedicament);				}
		 else if (source == suivant){
				if (indiceEnCours < (lesMedicaments.size() - 1)) indiceEnCours = indiceEnCours + 1;
				Medicament leMedicament = lesMedicaments.get(indiceEnCours);
		    	remplirText(leMedicament);		    	}
 } // fin actionPerformed

}

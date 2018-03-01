package fr.eni.clinique.ihm;

import fr.eni.clinique.bll.BLLException;
import fr.eni.clinique.bll.CltManager;
import fr.eni.clinique.bo.Client;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class ClientController {

    private static ClientController instance;
    private CltManager clientM = new CltManager();

    private GeneralController controllerBase;

    // constructeur
    private ClientController() throws BLLException {
        getEcran();
    }

    /**
     * Gestion singleton
     * @return
     */
    public static ClientController getInstance() {
        if(instance == null){
            try {
                instance = new ClientController();
            } catch (BLLException e) {
                e.printStackTrace();
            }
        }
        return instance;
    }

    // récupération ihm
    public GeneralController getEcran() {
        if(controllerBase == null){
            controllerBase = GeneralController.getInstance();
        }
        return controllerBase;
    }


    // initialisation de l'onglet client
    public void init(){
        controllerBase.getPanel_client().setVisible(true);
        try{
            mainDisplay(clientM.getClientById(1));
        }catch(BLLException e){
            e.printStackTrace();
        }
    }

    public void mainDisplay(List<Client> listeClient){
        // NOUVEAU PANEL
        controllerBase.getPanel_client_result().removeAll();

        // AFFICHAGE DES DONNEES
        for (Client client : listeClient) {
            JPanel panel = new JPanel();//LIGNE
            panel.setLayout(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.insets = new Insets(20, 10, 10, 10);
            gbc.gridwidth = 1;

            gbc.gridy = 0;
            gbc.gridx = 0;
            panel.add(new JLabel("Code : "),gbc);
            gbc.gridy = 0;
            gbc.gridx = 1;
            panel.add(new JLabel(String.valueOf(client.getCode())));

            gbc.gridy = 1;
            gbc.gridx = 0;
            panel.add(new JLabel("Nom : "));
            gbc.gridy = 1;
            gbc.gridx = 1;
            panel.add(new JTextField(client.getNom()));

            gbc.gridy = 2;
            gbc.gridx = 0;
            panel.add(new JLabel("Prenom : "));
            gbc.gridy = 2;
            gbc.gridx = 1;
            panel.add(new JTextField(client.getPrenomClient()));


            gbc.gridy = 3;
            gbc.gridx = 0;
            panel.add(new JLabel("Email : "));
            gbc.gridy = 3;
            gbc.gridx = 1;
            panel.add(new JTextField(client.getEmail()));
            

            controllerBase.getPanel_client_result().add(panel, gbc);//AJOUT DE LA LIGNE
        }
        //Actualisation
        controllerBase.getPanel_client().revalidate();
    }

    // affichage des clients sous forme de liste sur l'IHM
    public void displayResult(List<Client> listeClient) {
        // NOUVEAU PANEL
        GridBagConstraints gbc = new GridBagConstraints();
        int gridy = 0;
        controllerBase.getPanel_client_result().removeAll();

        // AFFICHAGE DES DONNEES
        for (Client client : listeClient) {
            JPanel panel = new JPanel();//LIGNE
            panel.setLayout(new GridBagLayout());
            gbc.insets = new Insets(20, 10, 10, 10);
            panel.add(new JLabel(client.getPrenomClient() + " " + client.getNom() + " - " + client.getEmail()), gbc);
            gbc.gridx = 2;

            //Ligne de séparation
            panel.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
            gbc.gridy = gridy;//ORDRE DE LA LIGNE
            gbc.gridwidth = 3;//TAILLE DE LA LIGNE
            controllerBase.getPanel_client_result().add(panel, gbc);//AJOUT DE LA LIGNE
            gridy++;
        }
        //Actualisation
        controllerBase.getPanel_client().revalidate();
    }

}

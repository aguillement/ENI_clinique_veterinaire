package fr.eni.clinique.ihm;

import fr.eni.clinique.bll.BLLException;
import fr.eni.clinique.bll.ClientManager;
import fr.eni.clinique.bo.Client;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class IHMAjoutClient extends JFrame{

    private static IHMAjoutClient instance;
    private JLabel nomLabel, prenomLabel, adresseLabel, codePostalLabel, villeLabel, numLabel, assuranceLabel, eMailLabel;
    private JTextField nomTextField, prenomTextField, adresseTextField, codePostalTextField, villeTextField, numTextField, assuranceTextField, eMailTextField;
    private JButton valider,annuler;
    private Client client;
    private ClientManager clientManager;

    //Singleton
    public static IHMAjoutClient getInstance(){
        if(instance == null){
            instance = new IHMAjoutClient();
        }
        return instance;
    }

    //constructeur
    public IHMAjoutClient(){
        setIHMAjoutClient();
    }

    // Lancement de l'application
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                try{
                    IHMAjoutClient window = new IHMAjoutClient();
                    window.setVisible(true);
                } catch (Exception e){
                    e.printStackTrace();
                }
            }
        });
    }

    //mise à jour de l'IHM
    private void setIHMAjoutClient(){

        this.setTitle(" Clients ");
        this.setSize(new Dimension(400,200));
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(true);

        nomLabel = new JLabel("Nom: ");
        nomTextField = new JTextField(10);

        prenomLabel = new JLabel("Prenom: ");
        prenomTextField = new JTextField(10);

        adresseLabel = new JLabel("Adresse: ");
        adresseTextField = new JTextField(10);

        codePostalLabel = new JLabel("Code postal: ");
        codePostalTextField = new JTextField(10);

        villeLabel = new JLabel("Ville: ");
        villeTextField = new JTextField(10);

        numLabel = new JLabel("Num tel: ");
        numTextField = new JTextField(10);

        assuranceLabel = new JLabel("Assurance: ");
        assuranceTextField = new JTextField(10);

        eMailLabel = new JLabel("eMail: ");
        eMailTextField = new JTextField(10);

        valider = new JButton("Valider ");
        annuler = new JButton(" Annuler");

        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(20, 10, 10, 10);
        gbc.gridwidth = 1;

        gbc.gridy = 0;
        gbc.gridx = 0;
        panel.add(nomLabel,gbc);

        gbc.gridy = 0;
        gbc.gridx = 1;
        panel.add(nomTextField,gbc);

        gbc.gridy = 1;
        gbc.gridx = 0;
        panel.add(prenomLabel,gbc);

        gbc.gridy = 1;
        gbc.gridx = 1;
        panel.add(prenomTextField,gbc);

        gbc.gridy = 2;
        gbc.gridx = 0;
        panel.add(adresseLabel,gbc);

        gbc.gridy = 2;
        gbc.gridx = 1;
        panel.add(adresseTextField,gbc);

        gbc.gridy = 3;
        gbc.gridx = 0;
        panel.add(codePostalLabel,gbc);

        gbc.gridy = 3;
        gbc.gridx = 1;
        panel.add(codePostalTextField,gbc);

        gbc.gridy = 4;
        gbc.gridx = 0;
        panel.add(villeLabel,gbc);

        gbc.gridy = 4;
        gbc.gridx = 1;
        panel.add(villeTextField,gbc);

        gbc.gridy = 5;
        gbc.gridx = 0;
        panel.add(numLabel,gbc);

        gbc.gridy = 5;
        gbc.gridx = 1;
        panel.add(numTextField,gbc);

        gbc.gridy = 6;
        gbc.gridx = 0;
        panel.add(assuranceLabel,gbc);

        gbc.gridy = 6;
        gbc.gridx = 1;
        panel.add(assuranceTextField,gbc);

        gbc.gridy = 7;
        gbc.gridx = 0;
        panel.add(eMailLabel,gbc);

        gbc.gridy = 7;
        gbc.gridx = 1;
        panel.add(eMailTextField,gbc);

        gbc.gridy = 8;
        gbc.gridx = 0;
        panel.add(valider, gbc);

        gbc.gridy = 8;
        gbc.gridx = 1;
        panel.add(annuler, gbc);

        valider.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    client = new Client(nomTextField.getText(), prenomTextField.getText(), adresseTextField.getText(), null, codePostalTextField.getText(), villeTextField.getText(), numTextField.getText(), assuranceTextField.getText(), eMailTextField.getText(), null, false);
                    clientManager = new ClientManager();
                    clientManager.insertClient(client);
                } catch (BLLException e1) {
                    e1.printStackTrace();
                }
            }
        });

        annuler.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //TODO
            }
        });

        this.setContentPane(panel);
        this.setVisible(true);
    }
}


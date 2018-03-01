package fr.eni.clinique.ihm;

import fr.eni.clinique.ihm.ecranPersonnel.PersonnelFrame;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.SwingUtilities;


public class IHMapp extends JFrame implements ActionListener {

    private static final long serialVersionUID = 1L;

    private JDesktopPane desktopPane;
    private JMenuBar menuBarre;
    private JMenu menuAgenda;
    private PersonnelFrame personnelFrame;


    public IHMapp() {

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setBounds(0, 0, screenSize.width, screenSize.height);

        // initialiser l'ecran MDI
        desktopPane = new JDesktopPane();

        // Associer le JDesktopPane à la JFrame
        setContentPane(desktopPane);

        // Barre de menus
        setJMenuBar(getMenuBarre());

        //Frame interne exemple
        desktopPane.add(getPersonnelFrame());

    }

    // Lancement de l'application
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                IHMapp ecran = new IHMapp();



                ecran.setVisible(true);
            }
        });

    }

    public void createMenuBar() {

        // Menu Fichier
        JMenu menu = new JMenu("Fichier");
        menuBarre.add(menu);

        // Sous menu Déconnexion
        JMenuItem menuItem = new JMenuItem("Déconnexion");
        menuItem.setActionCommand("deconnexion");
        menuItem.addActionListener(this);
        menu.add(menuItem);

        // Sous menu fermer
        menuItem = new JMenuItem("Fermer");
        menuItem.setActionCommand("fermer");
        menuItem.addActionListener(this);
        menu.add(menuItem);

        // Menu Agenda
        menuItem = new JMenuItem("Gestion Personnel");
        menuBarre.add(menuItem);
        menuItem.setActionCommand("gestionPersonnel");
        menuItem.addActionListener(this);

    }

    // Réagir aux clicks sur les menus
    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "deconnexion":
                System.out.println("Deconnexion");
                break;
            case "fermer":
                System.exit(0);
                break;

            case "gestionPersonnel":
                getPersonnelFrame().setVisible(true);
                break;

            default:
                System.out.println("Probleme e=" + e);
        }

    }

    public JDesktopPane getDesktopPane() {
        return desktopPane;
    }

    public JMenuBar getMenuBarre() {
        if (menuBarre == null) {
            menuBarre = new JMenuBar();

            createMenuBar();
        }
        return menuBarre;
    }

    public PersonnelFrame getPersonnelFrame() {
        if(personnelFrame== null){
            personnelFrame = new PersonnelFrame();
        }
        return personnelFrame;
    }


}

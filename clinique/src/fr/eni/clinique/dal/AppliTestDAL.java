package src.fr.eni.clinique.dal;

import src.fr.eni.clinique.bo.Personne;

import java.util.List;

public class AppliTestDAL extends DAOFactory{

    public static void main(String[] args) {

        DAOPersonnels DAOPersonnel = DAOFactory.getPersonnelsDAO();

        //TODO...
        try {
            //Sélection de toutes les races
            List<Personne> personnels = DAOFactory.getPersonnelsDAO().selectAll();
            System.out.println("Sélection de tous les articles  : " + personnels.toString() );


        } catch (DALException e) {
            e.printStackTrace();
        }

    }

}


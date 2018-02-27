package src.fr.eni.clinique.dal;


import src.fr.eni.clinique.dal.JDBC.ClientDAOJdbcImpl;

public class DAOFactory {

    public static DAORaces getRaceDAO()  {
        DAORaces racesDAO=null;
        try {
            racesDAO=(DAORaces) Class.forName("src.fr.eni.clinique.dal.JDBC.RacesDAOJdbcImpl").newInstance();
        } catch (InstantiationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return racesDAO;
    }

    public static ClientDAOJdbcImpl getClientDAO()
    {
        return new ClientDAOJdbcImpl();
    }
}

package services;

import Models.*;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;



public class HibernateService {
    public static Session session;

    private HibernateService() {
    }

    /**
     * Configures the session that will be used throughout the Java application
     * The hibernate properties are set to the Configuration object
     * Our model classes are configured so they are able to use JPA annotations
     * The Session Factory is built from the Configuration object
     */
    private static void configSession() {
        //Set up hibernate properties
        Configuration config = new Configuration();
        if(System.getProperty("TEST") == "TRUE") {
            //we are getting hibernate config info from System properties. Probably for running on a Tomcat server on AWS
            //System.getenv("TEST");//Tomcat on elastic beanstalk will not see these
            //System.getProperty("TEST");//Tomcat on EBS will see these. That's why we use them below.

            //This part isn't necessary if we are bundling

            config.setProperty("hibernate.dialect", System.getProperty("HIBERNATE_DIALECT"));
            config.setProperty("hibernate.connection.driver_class", System.getProperty("HIBERNATE_CONNECTION_DRIVER_CLASS"));
            config.setProperty("hibernate.connection.url", System.getProperty("HIBERNATE_CONNECTION_URL"));
            config.setProperty("hibernate.connection.username", System.getProperty("HIBERNATE_CONNECTION_USERNAME"));
            config.setProperty("hibernate.connection.password", System.getProperty("HIBERNATE_CONNECTION_PASSWORD"));
            config.setProperty("hibernate.hbm2ddl.auto", System.getProperty("HIBERNATE_HBM2DDL_AUTO"));
            //config.setProperty("hibernate.connection.autocommit", System.getProperty("HIBERNATE_CONNECTION_AUTOCOMMIT"));
            config.setProperty("hibernate.show_sql", System.getProperty("HIBERNATE_SHOW_SQL"));
        }


        //add model classes
        config.addAnnotatedClass(Flight.class);
        config.addAnnotatedClass(User.class);
        config.addAnnotatedClass(Ticket.class);
        config.addAnnotatedClass(Admin.class);

        //open session
        session = config.buildSessionFactory().openSession();

    }

    /**
     * Creates the session that will be used throughout the Java
     * application
     * If a session does not exist, one will be created through
     * the invocation of the configSession() method
     */
    public static Session getSession(){
        if(session == null) {
            configSession();
        }
        return session;
    }

    public static void closeSession(){
        session.close();
        session = null;
    }


}

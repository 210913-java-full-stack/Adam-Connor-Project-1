package servlets;

import Models.City;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import services.*;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.io.IOException;


public class DependencyLoaderListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        Session session = HibernateService.getSession();
//        CityService.setSession(session);
        AdminService.setSession(session);
        TicketService.setSession(session);
        UserService.setSession(session);
        FlightService.setSession(session);
        CityService.setSession(session);
        CityService.populateCitiesTable();

        //Populates the Flights, Users, and Tickets Tables
        FlightService.populateFlightsTable();

        //Populates the Admin Table
        AdminService.populateAdminTable();
//        UserService.populateUserTable();
//        User_FlightService.setSession(session);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        HibernateService.closeSession();
    }
}
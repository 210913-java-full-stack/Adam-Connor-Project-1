package servlets.User;

import Models.Flight;
import com.fasterxml.jackson.databind.ObjectMapper;
import services.FlightService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class FlightServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        InputStream requestBody = req.getInputStream();
//        Scanner sc = new Scanner(requestBody, StandardCharsets.UTF_8.name());
//        String jsonText = sc.next();
        Flight flight = new Flight();
        flight.setArrival_city(req.getParameter("arrivalCity"));
        flight.setDeparture_city(req.getParameter("departureCity"));
        flight.setFlight_date(req.getParameter("departureDate"));
        List<Flight> flights;
        flights = FlightService.getFlightByDetails(flight);
        ObjectMapper mapper = new ObjectMapper();
        resp.getWriter().write(mapper.writeValueAsString(flights));
        resp.setContentType("application/json");
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Flight newFlight = new Flight();
        newFlight.setDeparture_city(req.getParameter("departure"));
        newFlight.setArrival_city(req.getParameter("arrival"));
        newFlight.setFlight_date(req.getParameter("date"));
        FlightService.addFlight(newFlight);
    }
}

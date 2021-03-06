package Models;

import javax.persistence.*;

@Entity
@Table(name = "tickets")
public class Ticket {

    @Id
    @Column
    @GeneratedValue
    private Integer ticket_id;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    public User user;

    @ManyToOne
    @JoinColumn(name = "flight_num", referencedColumnName = "flight_num")
    public Flight flight;

    @Column
    private String first_name;

    @Column
    private String last_name;

    @Column
    private Boolean checkIn;

    @Column
    private Boolean cancel;

    public Ticket() {
    }

    public Ticket(User user, Flight flight, String first_name, String last_name, Boolean checkIn, Boolean cancel) {
        this.user = user;
        this.flight = flight;
        this.first_name = first_name;
        this.last_name = last_name;
        this.checkIn = checkIn;
        this.cancel = cancel;
    }

    public Integer getTicket_id() {
        return ticket_id;
    }

    public void setTicket_id(Integer ticket_id) {
        this.ticket_id = ticket_id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public Boolean getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(Boolean checkIn) {
        this.checkIn = checkIn;
    }

    public Boolean getCancel() {
        return cancel;
    }

    public void setCancel(Boolean cancel) {
        this.cancel = cancel;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }
}

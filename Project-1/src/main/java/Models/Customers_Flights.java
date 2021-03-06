package Models;

public class Customers_Flights {
    private int junction_id;
    private int customer_id;
    private int flight_num;

    public Customers_Flights() {
    }

    public Customers_Flights(int junction_id) {
        this.junction_id = junction_id;
    }

    public Customers_Flights(int junction_id, int customer_id) {
        this.junction_id = junction_id;
        this.customer_id = customer_id;
    }

    public Customers_Flights(int junction_id, int customer_id, int flight_num) {
        this.junction_id = junction_id;
        this.customer_id = customer_id;
        this.flight_num = flight_num;
    }

    public int getJunction_id() {
        return junction_id;
    }

    public void setJunction_id(int junction_id) {
        this.junction_id = junction_id;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public int getFlight_num() {
        return flight_num;
    }

    public void setFlight_num(int flight_num) {
        this.flight_num = flight_num;
    }
}

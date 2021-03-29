package com.company;
import com.company.Service.*;
import com.company.objects.*;
import com.company.objects.Date;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;




public class MainPanel {

    private Scanner scan;

    private AirplaneService AirplaneS;
    private AirportService AirportS;
    private ClientListService CLS;
    private CompanyService CS;
    private FlightService FS;
    private RouteService RS;

    /********************************* Zarządzanie Samolotami *********************************************/

    public void PanelAddAirplane() {
        System.out.println("Podaj ID samolotu");
        String plane_id = scan.nextLine();
        System.out.println("Podaj ile pasazerow miesci samolot");
        Integer plane_capacity = scan.nextInt();
        System.out.println("Podaj odleglosc samolotu");
        Double plane_range = scan.nextDouble();
        Airplane airplane = new Airplane(plane_id, plane_capacity, plane_range);
        AirplaneS.addAirplane(airplane);
    }


    public void PanelRemoveAirplane() throws InputMismatchException {
        try {
            System.out.println("Podaj ID samolotu");
            String plane_id = scan.nextLine();
            AirplaneS.remove(plane_id);
        } catch (Throwable InputMismatchException) {
            System.out.println("Input mismatch");
            scan.next();
        }
    }


    public void PanelAvailableAirplane() throws InputMismatchException {
        try {
            System.out.println("Podaj ID samolotu");
            String plane_id = scan.nextLine();
            AirplaneS.isOnList(plane_id);
        } catch (Throwable InputMismatchException) {
            System.out.println("Input mismatch");
            scan.next();
        }
    }


    public void PanelDisplayListOfAirplanes() {
        AirplaneS.DisplayListOfAirplanes();
    }


    /********************************* Zarządzanie klientami *********************************************/


    public void PanelAddPrivateClient() throws InputMismatchException {
        try {
            System.out.println("Podaj imie klienta");
            String name = scan.nextLine();
            System.out.println("Podaj nazwisko klienta");
            String surname = scan.nextLine();
            System.out.println("Podaj id klienta");
            String client_id = scan.nextLine();
            Client client = new Client(name, surname, client_id);
            CLS.addPrivateClient(client);
        } catch (Throwable InputMismatchException) {
            System.out.println("Input mismatch");
            scan.next();
        }
    }


    public void PanelAddCompanyClients() throws InputMismatchException {
        try {
            System.out.println("Podaj ID firmy");
            String company_id = scan.nextLine();
            Company tmp = CS.getCompany(company_id);
            CLS.addCompanyClients(tmp);
        } catch (Throwable InputMismatchException) {
            System.out.println("Input mismatch");
            scan.next();
        }
    }


    public void PanelListOfAllClients() {
        CLS.DisplayClientsList();
    }

    public void PanelRemoveClientOfService() throws InputMismatchException {
        try {
            System.out.println("Podaj ID klienta");
            String client_id = scan.nextLine();
            CLS.remove(client_id);
        } catch (Throwable InputMismatchException) {
            System.out.println("Input mismatch");
            scan.next();
        }
    }

    /********************************* Zarządzanie firmami *********************************************/

    public void PanelAddCompany() throws InputMismatchException {
        try {
            System.out.println("Podaj nazwe firmy");
            String company_name = scan.nextLine();
            System.out.println("Podaj ID firmy");
            String company_id = scan.nextLine();
            Company company = new Company(company_name, company_id);
            CS.addCompany(company);
        } catch (Throwable InputMismatchException) {
            System.out.println("Input mismatch");
            scan.next();
        }
    }

    public void PanelRemoveCompany() throws InputMismatchException {
        try {
            System.out.println("Podaj ID firmy");
            String company_id = scan.nextLine();
            CS.remove(company_id);
        } catch (Throwable InputMismatchException) {
            System.out.println("Input mismatch");
            scan.next();
        }
    }

    public void PanelAddClientToCompany() throws InputMismatchException {
        try {
            System.out.println("Podaj imie klienta");
            String name = scan.nextLine();
            System.out.println("Podaj nazwisko klienta");
            String surname = scan.nextLine();
            System.out.println("Podaj id klienta");
            String client_id = scan.nextLine();
            System.out.println("Podaj ID firmy do ktorej dodany ma zostac klient");
            String company_id = scan.nextLine();
            Client client = new Client(name, surname, company_id);
            Company tmp = CS.getCompany(company_id);
            tmp.addClient(client);
        } catch (Throwable InputMismatchException) {
            System.out.println("Input mismatch");
            scan.next();
        }

    }

    public void PanelRemoveClientOfCompany() throws InputMismatchException {
        try {
            System.out.println("Podaj ID firmy");
            String company_id = scan.nextLine();
            System.out.println("Podaj ID klienta");
            String client_id = scan.nextLine();
            Company tmp = CS.getCompany(company_id);
            Client tmp_client = tmp.GetClient(client_id);
            tmp.deleteClient(tmp_client);

        } catch (Throwable InputMismatchException) {
            System.out.println("Input mismatch");
            scan.next();
        }

    }


    public void PanelDisplayListOfCompanies() {
        CS.DisplayCompanyList();
    }

    public void PanelDisplayListOfCompanyClients() {
        System.out.println("Podaj ID firmy");
        String company_id = scan.nextLine();
        Company tmp = CS.getCompany(company_id);
        tmp.DisplayCompanyClientsList();
    }

    /********************************* Zarządzanie trasami *********************************************/

    public void PanelAddRoute() throws InputMismatchException {
        try {
            System.out.println("Podaj ID trasy");
            String route_id = scan.nextLine();
            System.out.println("Podaj ID lotniska - miejsca odlotu");
            String from_id = scan.nextLine();
            System.out.println("Podaj ID lotniska - miejsca przybycia");
            String to_id = scan.nextLine();
            Airport from = AirportS.getAirportId(from_id);
            Airport to = AirportS.getAirportId(to_id);
            double distance = RS.CalculateDistance(from, to);
            Route route = new Route(from, to, distance, route_id);
            RS.addRoute(route);

        } catch (Throwable InputMismatchException) {
            System.out.println("Input mismatch");
            scan.next();
        }

    }

    public void PanelRemoveRoute() throws InputMismatchException {
        try {
            System.out.println("Podaj ID trasy");
            String route_id = scan.nextLine();
            RS.remove(route_id);
        } catch (Throwable InputMismatchException) {
            System.out.println("Input mismatch");
            scan.next();
        }
    }

    public void PanelDistance() throws InputMismatchException {
        try {
            System.out.println("Podaj ID lotniska 1");
            String airport_id1 = scan.nextLine();
            System.out.println("Podaj ID lotniska 2");
            String airport_id2 = scan.nextLine();
            Airport from = AirportS.getAirportId(airport_id1);
            Airport to = AirportS.getAirportId(airport_id2);
            System.out.println("Odleglosc miedzy " + from.getCity() + " ,a " + to.getCity() + " wynosi okolo" + RS.CalculateDistance(from, to) + " km ");
        } catch (Throwable InputMismatchException) {
            System.out.println("Input mismatch");
            scan.next();
        }
    }

    public void PanelDisplayRoutes() {
        RS.DisplayRouteList();
    }

    /********************************* Zarządzanie lotami *********************************************/


    public void EnterDateInfo() {
        /*
        System.out.println("Podaj ID lotu:");
        String flight_id = scan.nextLine();
        System.out.println("Podaj ID trasy:");
        String route_id = scan.nextLine();
        System.out.println("Podaj dzien wylotu");
        int departure_day = scan.nextInt();
        System.out.println("Podaj dzien przylotu");
        int arrival_day = scan.nextInt();
        System.out.println("Podaj miesiąc wylotu");
        String month = scan.nextLine();
        System.out.println("Podaj rok wylotu");
        int year = scan.nextInt();
        Date date = new Date(departure_day,arrival_day,month,year);
        Route route = RS.
        FS.GenerateFLight(route_id,AirplaneS,flight_id,date,CLS);
*/
        System.out.println("Podaj ID lotu:");
        String flight_id = scan.nextLine();
        System.out.println("Podaj ID lotniska - wylotu ");
        String from_id = scan.nextLine();
        System.out.println("Podaj ID lotniska - przylotu ");
        String to_id = scan.nextLine();
        System.out.println("Podaj dzien wylotu");
        int departure_day = scan.nextInt();
        System.out.println("Podaj dzien przylotu");
        int arrival_day = scan.nextInt();
        System.out.println("Podaj miesiąc");
        String month = scan.nextLine();
        System.out.println("Podaj rok");
        int year = scan.nextInt();

        Date date = new Date(departure_day, arrival_day, month, year);
        Airport from = AirportS.getAirportId(from_id);
        Airport to = AirportS.getAirportId(to_id);

        Route tmp = RS.GetRoute(from, to);
        FS.GenerateFLight(tmp, AirplaneS, flight_id, date, CLS);


    }

    public void PanelRemoveFlight() {
        System.out.println("Podaj ID lotu:");
        String flight_id = scan.nextLine();
        FS.remove(flight_id);
    }

    public void PanelDisplayFlights() {
        FS.DisplayListOfFlights();
    }

    /********************************* Zarzadzanie lotniskami *********************************************/

    public void PanelAddAirport() {
        System.out.println("Podaj nazwe lotniska");
        String airport_name = scan.nextLine();
        System.out.println("Podaj nazwe miasta");
        String city_name = scan.nextLine();
        System.out.println("Podaj panstwo, w ktorym znajduje sie lotnisko");
        String airport_country = scan.nextLine();
        System.out.println("Podaj ID lotniska");
        String airport_id = scan.nextLine();
        System.out.println("Podaj szerokosc geograficzna");
        double latitude = scan.nextDouble();
        System.out.println("Podaj Dlugosc Geograficzna:");
        double longitude = scan.nextDouble();

        Airport airport = new Airport(airport_name, city_name, airport_country, airport_id, latitude, longitude);
        AirportS.addAirport(airport);

    }

    public void PanelRemoveAirport() {
        System.out.println("Podaj ID lotniska");
        String airport_id = scan.nextLine();
        AirportS.remove(airport_id);
    }

    public void PanelDisplayAirportList() {
        AirportS.DisplayListOfAirports();
    }


    /********************************* MAIN *********************************************/

    public MainPanel() {

        AirplaneS = new AirplaneService();
        AirportS = new AirportService();
        CLS = new ClientListService();
        CS = new CompanyService();
        FS = new FlightService();
        RS = new RouteService();
        scan = new Scanner(System.in);
    }


    /********************************* Save to file  *********************************************/

    void SaveAirplanesToFile() {
        AirplaneS.SaveToFile();
    }

    void SaveFlightsToFile() {
        FS.SaveToFile();
    }

    void SaveAirportsToFile() {
        AirportS.SaveToFile();
    }

    void SaveRoutesToFile() {
        RS.SaveToFile();
    }

    void SaveCompaniesToFile() {
        CS.SaveToFile();
    }

    void SaveFlightClientsToFile() {
        CLS.SaveToFile();
    }


    /********************************* Load from file  *********************************************/

    void AirplaneLoadFromFile() throws IOException {
        AirplaneS.LoadFromFile();
    }

    void FlightClientLoadFromFile() throws IOException {
        CLS.LoadFromFile();
    }

    void AirportLoadFromFile() throws IOException {
        AirportS.LoadFromFile();
    }

    void CompanyLoadFromFile() throws IOException {
        CS.LoadFromFile();
    }

    public void FlightLoadFromFile() throws IOException  {
        BufferedReader reader = new BufferedReader(new FileReader("FlightListLoad.txt"));
        String line = null;
        //StringTokenizer st = new StringTokenizer(line);
        while((line=reader.readLine()) != null)
        {
            String[] flightinfo = line.split(" ");
            String flight_id = flightinfo[0];
            String airplane_id_ = flightinfo[1];
            String route_id = flightinfo[2];
            int departure_day = Integer.parseInt(flightinfo[3]);
            int arrival_day = Integer.parseInt(flightinfo[4]);
            String month = flightinfo[5];
            int year = Integer.parseInt(flightinfo[6]);
            Date date = new Date(departure_day,arrival_day,month,year);

            FS.addFlight(new Flight(flight_id,AirplaneS.getAirplane(airplane_id_),RS.GetRoute(route_id),date));
        }

    }

    void RouteLoadFromFile() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("RouteListLoad.txt"));
        String line = null;
        //StringTokenizer st = new StringTokenizer(line);
        while((line=reader.readLine()) != null)
        {
            String[] routeinfo = line.split(" ");
            String route_fromid = routeinfo[0];
            String route_toid = routeinfo[1];
            double route_distance = Double.parseDouble(routeinfo[2]);
            String route_id = routeinfo[3];
            RS.addRoute(new Route(AirportS.getAirportId(route_fromid),AirportS.getAirportId(route_toid),route_distance,route_id));
        }
    }
}
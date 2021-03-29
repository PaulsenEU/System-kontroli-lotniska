package com.company;
import java.io.IOException;
import java.lang.*;
import com.company.MainPanel;
import com.company.objects.Date;

import java.util.Scanner;



public class Main
{
public static void main(String[] args) throws IOException {

    MainPanel mainpanel = new MainPanel();
    Scanner scan = new Scanner(System.in);
    int button; // przycisk wyboru
    int number = 0, number1 = 0, number2 = 0 , number3 = 0 , number4 = 0 , number5 = 0 , number6 = 0;


    /********************************* Wczytywanie plików *********************************************/
    mainpanel.AirplaneLoadFromFile();
    mainpanel.AirportLoadFromFile();
    mainpanel.CompanyLoadFromFile();
    mainpanel.FlightClientLoadFromFile();
    mainpanel.FlightLoadFromFile();
    mainpanel.RouteLoadFromFile();


    while(number == 0)
    {
        System.out.println("Lotnisko - MENU");
        System.out.println("1. Zarządzanie samolotami");
        System.out.println("2. Zarządzanie klientami");
        System.out.println("3. Zarządzanie firmami");
        System.out.println("4. Zadządzanie trasami");
        System.out.println("5. Zadządzanie lotami");
        System.out.println("6. Zadządzanie lotniskami");
        System.out.println("7. Wyjscie");
        System.out.println();
        System.out.println("***************************************************************");
        System.out.println("Ktora z opcji chcesz wybrac?");
        button = scan.nextInt();
        number1 = 0; number2 = 0; number3 = 0; number4 = 0; number5 = 0; number6 = 0;

        switch(button)
        {

            /********************************* Zarzadzanie samolotami *********************************************/

            case 1:


                while(number1 == 0)
                {
                    System.out.println("Zarządzanie samolotami - OPCJE");
                    System.out.println("1. Dodanie samolotu do bazy lotniska");
                    System.out.println("2. Usunięcie samolotu z bazy lotniska");
                    System.out.println("3. Sprawdź czy samolot znajduje się w bazie lotniska");
                    System.out.println("4. Wyświetl liste samolotow dostepnych w bazie lotniska");
                    System.out.println("5. Zapis do pliku AirplaneListLoad.txt");
                    System.out.println("6. Powrót");
                    System.out.println();
                    System.out.println("***************************************************************");
                    System.out.println("Ktora z opcji chcesz wybrac?");
                    button = scan.nextInt();

                    switch(button)
                    {
                        case 1:
                            mainpanel.PanelAddAirplane();
                            break;

                        case 2:
                            mainpanel.PanelRemoveAirplane();
                            break;
                        case 3:
                            mainpanel.PanelAvailableAirplane();
                            break;
                        case 4:
                            mainpanel.PanelDisplayListOfAirplanes();
                            break;
                        case 5:
                            mainpanel.SaveAirplanesToFile();
                            break;
                        case 6:
                            number1 = 1;

                    }

                }

                /********************************* Zarzadzanie klientami *********************************************/

            case 2:

             while(number2==0)
             {
                 System.out.println("Zarządzanie klientami - OPCJE");
                 System.out.println("1. Dodanie indywidualnego klienta do bazy podróżujących");
                 System.out.println("2. Dodanie do bazy - wszystkich klientow podróżujących z poszczególnej firmy");
                 System.out.println("3. Wyswietl baze klientów");
                 System.out.println("4. Usuwanie klienta z bazy ");
                 System.out.println("5. Zapis do pliku ClientListLoad.txt");
                 System.out.println("6. Powrót");
                 System.out.println();
                 System.out.println("***************************************************************");
                 System.out.println("Ktora z opcji chcesz wybrac?");
                 button = scan.nextInt();

                 switch(button)
                 {
                     case 1:
                         mainpanel.PanelAddPrivateClient();
                         break;
                     case 2:
                         mainpanel.PanelAddCompanyClients();
                         break;
                     case 3:
                         mainpanel.PanelListOfAllClients();
                         break;
                     case 4:
                         mainpanel.PanelRemoveClientOfService();
                         break;
                     case 5:
                         mainpanel.SaveFlightClientsToFile();
                         break;
                     case 6:
                         number2 = 1;
                 }

             }

                /********************************* Zarzadzanie firmami *********************************************/

            case 3:

                while(number3 == 0)
                {
                    System.out.println("Zarządzanie firmami - OPCJE");
                    System.out.println("1. Dodaj firme do bazy");
                    System.out.println("2. Usun firme z bazy");
                    System.out.println("3. Dodaj klienta do firmy");
                    System.out.println("4. usun klienta z firmy");
                    System.out.println("5. wyswietl liste firm");
                    System.out.println("6. wyswietl liste klientow poszczegolnej firmy");
                    System.out.println("7. Zapis do pliku CompanyListLoad.txt");
                    System.out.println("8. Powró†");
                    System.out.println();
                    System.out.println("***************************************************************");
                    System.out.println("Ktora z opcji chcesz wybrac?");
                    button = scan.nextInt();

                    switch(button)
                    {
                        case 1:
                            mainpanel.PanelAddCompany();
                            break;
                        case 2:
                            mainpanel.PanelRemoveCompany();
                            break;
                        case 3:
                            mainpanel.PanelAddClientToCompany();
                            break;
                        case 4:
                            mainpanel.PanelRemoveClientOfCompany();
                            break;
                        case 5:
                            mainpanel.PanelDisplayListOfCompanies();
                            break;
                        case 6:
                            mainpanel.PanelDisplayListOfCompanyClients();
                            break;
                        case 7:
                            mainpanel.SaveCompaniesToFile();
                            break;
                        case 8:
                            number3 = 1;

                    }




                }

                /********************************* Zarzadzanie trasami *********************************************/

            case 4:

                while(number4 == 0)
                {
                    System.out.println("Zarządzanie trasami - OPCJE");
                    System.out.println("1. Dodaj trase do bazy lotów");
                    System.out.println("2. Usun Trase z bazy lotów");
                    System.out.println("3. Wyswietl liste tras");
                    System.out.println("4. Wylicz odleglosc miedzy lotniskami");
                    System.out.println("5. Zapis do pliku RouteListLoad.txt");
                    System.out.println("6. Powrót");
                    System.out.println();
                    System.out.println("***************************************************************");
                    System.out.println("Ktora z opcji chcesz wybrac?");
                    button = scan.nextInt();

                    switch(button)
                    {
                        case 1:
                            mainpanel.PanelAddRoute();
                            break;
                        case 2:
                            mainpanel.PanelRemoveRoute();
                            break;
                        case 3:
                            mainpanel.PanelDisplayRoutes();
                            break;
                        case 4:
                            mainpanel.PanelDistance();
                            break;
                        case 5:
                            mainpanel.SaveRoutesToFile();
                        case 6:
                            number4 = 1;
                    }

                }
                /********************************* Zarzadzanie lotami *********************************************/

            case 5:

                while(number5 ==0)
                {
                    System.out.println("Zarządzanie lotami - OPCJE");
                    System.out.println("1. Wygeneruj lot");
                    System.out.println("2. Usun lot z listy");
                    System.out.println("3. Wyswietl liste lotów");
                    System.out.println("4. Zapis do pliku FlightListLoad.txt");
                    System.out.println("5. Powrót");
                    System.out.println();
                    System.out.println("***************************************************************");
                    System.out.println("Ktora z opcji chcesz wybrac?");
                    button = scan.nextInt();

                    switch(button)
                    {
                        case 1:
                            mainpanel.EnterDateInfo();
                        case 2:
                            mainpanel.PanelRemoveFlight();
                        case 3:
                            mainpanel.PanelDisplayFlights();
                        case 4:
                            mainpanel.SaveFlightsToFile();
                        case 5:
                            number5= 1;


                    }


                }

                /********************************* Zarzadzanie lotniskami *********************************************/

            case 6:
                while(number6 == 0)
                {
                    System.out.println("Zarządzanie lotniskami - OPCJE");
                    System.out.println("1. Dodaj lotnisko do listy");
                    System.out.println("2. Usun lotnisko z listy");
                    System.out.println("3. Wyswietl liste lotnisk");
                    System.out.println("4. Zapis do pliku AirportListLoad.txt");
                    System.out.println("5. Powrót");
                    System.out.println();
                    System.out.println("***************************************************************");
                    System.out.println("Ktora z opcji chcesz wybrac?");
                    button = scan.nextInt();

                    switch(button)
                    {
                        case 1:
                            mainpanel.PanelAddAirport();
                            break;
                        case 2:
                            mainpanel.PanelRemoveAirport();
                            break;
                        case 3:
                            mainpanel.PanelDisplayAirportList();
                            break;
                        case 4:
                            mainpanel.SaveAirportsToFile();
                        case 5:
                            number6 =1;
                    }
                }

            case 7:
            number = 1;

        }

    }





}
}

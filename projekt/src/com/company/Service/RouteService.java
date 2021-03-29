package com.company.Service;
import java.util.ArrayList;
import com.company.objects.*;

import javax.swing.*;
import java.lang.*;
import java.io.*;

public class RouteService implements Service {

    private ArrayList<Route> listOfRoutes = new ArrayList<Route>();

    public void addRoute(Route r) {
        listOfRoutes.add(r);
    }

    public void isOnList(String ID) {
        for(Route route : listOfRoutes) {
            if(route.getID().equals(ID))
                System.out.println("Trasa znajduje sie na liscie");
            else
                System.out.println(("Trasy nie ma na liscie"));
        }
    }

    public Route GetRoute(Airport from_id,Airport to_id)
    {
    for(Route route : listOfRoutes)
    {
        if(route.getFromID().equals(from_id)&&route.getToID().equals(to_id))
        {
            return route;
        }
    }
    return null;
    }

    public Route GetRoute(String ID)
    {
        for(Route route : listOfRoutes)
        {
            if(route.getID().equals(ID))
            {
                return route;
            }
        }
        return null;
    }

    public void SaveToFile() {
        File filename = new File("RouteListLoad.txt");
        try {
            FileWriter fw = new FileWriter(filename);
            Writer output = new BufferedWriter(fw);
            int sz = listOfRoutes.size();
            for (int i = 0; i < sz; i++) {
                output.write(listOfRoutes.get(i).getFromID() + " "+ listOfRoutes.get(i).getToID()+" "+ listOfRoutes.get(i).getDistance()+ " "+listOfRoutes.get(i).getID()+ "\n");
            }
            output.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Nie mozna stworzyc pliku");
        }

    }

public void DisplayRouteList()
{
    for(Route route:listOfRoutes)
    {
        System.out.println(route);
    }
}

    public double CalculateDistance(Airport from , Airport to)
    {
        double latitude_difference = from.getLatitude() - to.getLatitude(); //roznica szerokosci geograficznej
        double longitude_difference = from.getLongitude() - to.getLongitude(); //roznica dlugosci geograficznej

        double result = (Math.sqrt(Math.pow(latitude_difference,2)+Math.pow(longitude_difference,2)))*73;
        int finish = (int)result;

        return finish;
    }

    public void remove(String ID) {
        listOfRoutes.removeIf(route -> route.getID().equals(ID));
    }

    public ArrayList<Route> getListOfRoutes() {
        return listOfRoutes;
    }
}

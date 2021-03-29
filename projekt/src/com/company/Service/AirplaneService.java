package com.company.Service;
import java.util.ArrayList;
import com.company.objects.*;
import java.util.Scanner;
import javax.swing.*;
import java.io.*;
import java.util.StringTokenizer;

public class AirplaneService implements Serializable {

    private ArrayList<Airplane> listOfAirplanes = new ArrayList<Airplane>();

    public void addAirplane(Airplane a) {
        listOfAirplanes.add(a);
    }

    public void isOnList(String ID) {
        for (Airplane airplane : listOfAirplanes) {
            if (airplane.getPlaneID().equals(ID))
                System.out.println("Samolot znajduje sie na liscie");
            else
                System.out.println("Samolotu nie ma na liscie");
        }
    }

    public void remove(String ID) {
        listOfAirplanes.removeIf(airplane -> airplane.getPlaneID().equals(ID));
    }

    /*public ArrayList<Airplane> getListOfAirplanes() {
        return listOfAirplanes;
    }*/

    public Airplane traverseAirplaneList(double range) {
        Airplane t = new Airplane();
        for (Airplane airplane : listOfAirplanes) {
            if (airplane.getRange() >= (range)) t = airplane;
        }
        return t;
    }

    public void setUnavailable(String ID) {
        for (Airplane airplane : listOfAirplanes) {
            if (airplane.getPlaneID().equals(ID)) airplane.isAvailable = false;
        }
    }

    public Airplane getAirplane(String ID)
    {
        for(Airplane airplane : listOfAirplanes)
        {
            if(airplane.getPlaneID().equals(ID))
            {
                return airplane;
            }
        }
        return null;
    }


    public void SaveToFile() {
        File filename = new File("AirplaneListLoad.txt");
        try {
            FileWriter fw = new FileWriter(filename);
            Writer output = new BufferedWriter(fw);
            int sz = listOfAirplanes.size();
            for (int i = 0; i < sz; i++) {
                output.write(listOfAirplanes.get(i).getPlaneID() + " " + listOfAirplanes.get(i).getCapacity() + " " + listOfAirplanes.get(i).getRange()+"\n");
            }
            output.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Nie mozna stworzyc pliku");
        }

    }

    public void LoadFromFile() throws IOException  {
       BufferedReader reader = new BufferedReader(new FileReader("AirplaneListLoad.txt"));
       String line = null;
       //StringTokenizer st = new StringTokenizer(line);
       Airplane a;
       while((line=reader.readLine()) != null)
        {
            String[] airplaneinfo = line.split(" ");
        String plane_id = airplaneinfo[0];
        int capacity = Integer.parseInt(airplaneinfo[1]);
        double range = Double.parseDouble(airplaneinfo[2]);

        listOfAirplanes.add(new Airplane(plane_id,capacity,range));
        }
/*
        for (Airplane airplane : listOfAirplanes) {
            System.out.println(airplane);
        }
*/
    }





        public void DisplayListOfAirplanes ()
        {
            for (Airplane airplane : listOfAirplanes) {
                System.out.println(airplane);
            }
        }
    }

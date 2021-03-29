package com.company.Service;
import java.util.ArrayList;
import com.company.objects.*;

import javax.swing.*;
import java.io.*;
public class ClientListService implements Service {

    private ArrayList<Client> listOfClients = new ArrayList<Client>();

    public void addPrivateClient(Client c) {
        listOfClients.add(c);
    }

    public void addCompanyClients(Company c) {
        listOfClients.addAll(c.getListOfClients()); //Adding whole list from company to flight
    }

    public int listSize() {
        return this.listOfClients.size();
    }

    public ArrayList<Client> getListOfClients() {
        return listOfClients;
    }

    public void remove(String ID) {
        listOfClients.removeIf(client -> client.getName().equals(ID));
    }


    public void DisplayClientsList()
    {
        for(Client client : listOfClients)
        {
            System.out.println(client);
        }

    }


    public void LoadFromFile() throws IOException  {
        BufferedReader reader = new BufferedReader(new FileReader("ClientListLoad.txt"));
        String line = null;
        //StringTokenizer st = new StringTokenizer(line);
        while((line=reader.readLine()) != null)
        {
            String[] clientinfo = line.split(" ");
            String client_name = clientinfo[0];
            String client_surname = clientinfo[1];
            String client_id = clientinfo[1];

            listOfClients.add(new Client(client_name,client_surname,client_id));
        }

    }

    public void SaveToFile() {
        File filename = new File("ClientListLoad.txt");
        try {
            FileWriter fw = new FileWriter(filename);
            Writer output = new BufferedWriter(fw);
            int sz = listOfClients.size();
            for (int i = 0; i < sz; i++) {
                output.write(listOfClients.get(i).getName() + " " + listOfClients.get(i).getSurname() + " " + listOfClients.get(i).getID()+"\n");
            }
            output.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Nie mozna stworzyc pliku");
        }

    }




}

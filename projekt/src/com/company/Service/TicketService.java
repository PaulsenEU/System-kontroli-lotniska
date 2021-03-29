package com.company.Service;
import com.company.objects.*;


import javax.swing.*;
import java.io.*;
import java.util.ArrayList;

public class TicketService implements Service {

    private ArrayList<Ticket> listOfTickets = new ArrayList<Ticket>();

    public void addTicket(Ticket t) {
        listOfTickets.add(t);
    }

    public void remove(String ID) {
        listOfTickets.removeIf(ticket -> ticket.getID().equals(ID));
    }

    public ArrayList<Ticket> getListOfTickets() {
        return listOfTickets;
    }


        public void SaveToFile() {
            File filename = new File("TicketsList.txt");
            try {
                FileWriter fw = new FileWriter(filename);
                Writer output = new BufferedWriter(fw);
                int sz = listOfTickets.size();
                for (int i = 0; i < sz; i++) {
                    output.write(listOfTickets.get(i).toString() + "\n");
                }
                output.close();

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Nie mozna stworzyc pliku");
            }

        }

    }


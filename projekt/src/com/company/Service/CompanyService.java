package com.company.Service;
import java.util.ArrayList;
import com.company.objects.*;

import javax.swing.*;
import java.io.*;


public class CompanyService implements Service{

    private ArrayList<Company> listOfCompanies = new ArrayList<Company>();

    public void addCompany(Company c) {
        listOfCompanies.add(c);
    }

    public boolean isOnList(String ID) {
        for(Company company : listOfCompanies) {
            if(company.getCompID().equals(ID))
                return true;

        }
        return false;
    }

    public Company getCompany(String ID) {
        for(Company company : listOfCompanies) {
            if(company.getCompID().equals(ID))
            return company;
        }
return null;
    }
    public void remove(String ID) {
        listOfCompanies.removeIf(company -> company.getCompID().equals(ID));
    }

    public ArrayList<Company> getListOfCompanies() {
        return listOfCompanies;
    }

    public void SaveToFile() {
        File filename = new File("CompanyListLoad.txt");
        try {
            FileWriter fw = new FileWriter(filename);
            Writer output = new BufferedWriter(fw);
            int sz = listOfCompanies.size();
            for (int i = 0; i < sz; i++) {
                output.write(listOfCompanies.get(i).getName() +" "+ listOfCompanies.get(i).getCompID()+"\n");
            }
            output.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Nie mozna stworzyc pliku");
        }

    }

    public void DisplayCompanyList()
    {
        for(Company company:listOfCompanies)
        {
            System.out.println(company);
        }
    }

    public void LoadFromFile() throws IOException  {
        BufferedReader reader = new BufferedReader(new FileReader("CompanyListLoad.txt"));
        String line = null;
        //StringTokenizer st = new StringTokenizer(line);
        while((line=reader.readLine()) != null)
        {
            String[] companyinfo = line.split(" ");
            String company_name = companyinfo[0];
            String company_id = companyinfo[1];
            listOfCompanies.add(new Company(company_name,company_id));

        }

    }


}

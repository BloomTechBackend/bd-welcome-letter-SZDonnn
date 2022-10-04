package com.bloomtech.welcomeletter.services;

import com.bloomtech.welcomeletter.fileIO.FileManager;
import com.bloomtech.welcomeletter.models.Employee;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class FormLetterService {
    private static final FileManager fileManager = new FileManager();

    public void generateWelcomeLetter(Employee employee) throws IOException {
        //TODO: Get template text from resources
        String finalString = fileManager.getTextFromFile("LetterTemplate.txt");

        //TODO: Replace []ed text with correct info
        String[] toReplace = {"[company name]", "[fullname]", "[startdate]", "[startingsalary]", "[company starttime]"};
        for (String s : toReplace) {
            if (finalString.contains(s)) {
                if(s.equalsIgnoreCase("[company name]")) {
                    finalString = finalString.replace(s, employee.getCompany().getCompanyname());
                } else if(s.equalsIgnoreCase("[fullname]")) {
                    finalString = finalString.replace(s, employee.getFirstname() + " " + employee.getLastname());
                } else if (s.equalsIgnoreCase("[startdate]")) {
                    finalString = finalString.replace(s, employee.getStartdate().toString());
                } else if (s.equalsIgnoreCase("[startingsalary]")) {
                    finalString = finalString.replace(s, employee.getSalary() + "");
                } else if (s.equalsIgnoreCase("[company starttime]")) {
                    finalString = finalString.replace(s, employee.getCompany().getCompanyname());
                }
            }
        }

        //TODO: Write finalized String to file
        String outFilename = "WelcomeTestEmployee.txt";
        fileManager.writeTextToFile(outFilename, finalString);
    }
}

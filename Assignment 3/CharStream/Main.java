package com.javaAssignments;

import java.io.*;
import java.util.Scanner;

public class Main {

    public static void writeToFile() throws IOException{
        Scanner sc = new Scanner(System.in);
        String message;
        System.out.println("Enter the message to be written in the file: ");
        message = sc.nextLine();
        String strFilename = "charStream.txt";
        try (BufferedWriter out = new BufferedWriter(new FileWriter(strFilename))) {
            out.write(message);
            out.flush();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void readToFile() throws IOException{
        String strFilename = "charStream.txt";
        try (BufferedReader in = new BufferedReader(new FileReader(strFilename))) {
            String inLine;
            System.out.println("The text in the file is: ");
            while ((inLine = in.readLine()) != null) {  // exclude newline
                System.out.println(inLine);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try {
            writeToFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            readToFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

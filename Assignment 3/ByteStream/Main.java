package com.javaAssignments;

import java.io.*;
import java.util.Scanner;

public class Main {

    private static void writeToFile() throws IOException {
        Scanner sc = new Scanner(System.in);
        String inFileStr = "byteStream.txt";
        DataOutputStream out = new DataOutputStream(
                new BufferedOutputStream(
                (new FileOutputStream(inFileStr))));
        System.out.println("Enter text to be written into the file: ");
        String str;
        str = sc.nextLine();
        for(int i = 0; i < str.length(); ++i)
            out.writeChar(str.charAt(i));

        out.close();

        return;
    }

    private static void readToFile() throws IOException {

        String inFileStr = "byteStream.txt";
        File fileIn = new File(inFileStr);
        int fileSize = (int) fileIn.length();

        DataInputStream dis = new DataInputStream(
                new BufferedInputStream(
                        new FileInputStream(inFileStr)));
        System.out.println("The text read from the file is: ");
        while(true) {
            char ch;
            try {
                ch = dis.readChar();
                System.out.print(ch);
            } catch (EOFException e) {
                break;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    public static void main(String[] args) throws FileNotFoundException {

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

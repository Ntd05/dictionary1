package com.company;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

public class DictionaryManagement extends Translator{
    public Dictionary dictionary;
    public static final int numMaxCanPrint = 50;
    public static final String path = "C:\\Users\\Admin\\IdeaProjects\\dictionary\\src\\com\\company\\dictionaries.txt";

    DictionaryManagement() {
        dictionary = new Dictionary();
    }

    //insert từ commandline vào file
    public void insertFromCommandline() {
        Scanner sc = new Scanner(System.in);
        String enWord = sc.nextLine();
        String vnWord = sc.nextLine();
        Word word = new Word(enWord, vnWord);
        dictionary.add_Word(word);
    }

    public void showAllWords() {
        System.out.println("Đây là 50 từ đầu tiên!");
        try {
            FileInputStream fs = new FileInputStream(path);
            BufferedReader br = new BufferedReader(new InputStreamReader(fs));
            System.out.println("NO" + "\t\t" + "|English\t\t\t\t|Vietnamese");
            for (int j = 0; j < numMaxCanPrint; j++) {
                String line = br.readLine();
                String vnTemp = "";
                String enTemp = "";
                boolean check = false;
                for (int i = 0; i < line.length(); i++) {
                    if (!check) {
                        enTemp += line.charAt(i);
                        if (line.charAt(i) == '\t') {
                            check = true;
                            i = i + 1;
                        }
                    }
                    if (check) {
                        vnTemp += line.charAt(i);
                    }
                }
                System.out.println(j +"\t\t" + enTemp +"\t\t\t\t|" +vnTemp);
            }
            fs.close();
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*
    public void insertFromFile() {
        try {
            FileInputStream fs = new FileInputStream(path);
            BufferedReader br = new BufferedReader(new InputStreamReader(fs));
            for (int j = 0; j < numMaxCanPrint; j++) {
                String line = br.readLine();
                String vnTemp = "";
                String enTemp = "";
                boolean check = false;
                for (int i = 0; i < line.length(); i++) {
                    if (!check) {
                        enTemp += line.charAt(i);
                        if (line.charAt(i) == '\t') {
                            check = true;
                            i = i + 1;
                        }
                    }
                    if (check) {
                        vnTemp += line.charAt(i);
                    }
                }
                Word temp = new Word(enTemp, vnTemp);
                dictionary.add_Word(temp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    */

    // Tra cứu từ file
    public String dictionaryLookup(String word) {
        try {
            FileInputStream fs = new FileInputStream(path);
            BufferedReader br = new BufferedReader(new InputStreamReader(fs));
            for (int j = 0; j < dictionary.words_Available; j++) {
                String line = br.readLine();
                String vnTemp = "";
                String enTemp = "";
                boolean check = false;
                for (int i = 0; i < line.length(); i++) {
                    if (!check) {
                        enTemp += line.charAt(i);
                        if (line.charAt(i) == '\t') {
                            check = true;
                            i = i + 1;
                        }
                    }
                    if (check) {
                        vnTemp += line.charAt(i);
                    }
                }
                if (word.compareTo(enTemp) == -1) return vnTemp;
            }
            fs.close();
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Không tìm thấy từ này!";
    }

    // Search recommend từ file
    public String[] dictionarySearcher(String pathOfWord) {
        int count = 0;
        String[] WordSearched = new String[8];
        try {
            FileInputStream fs = new FileInputStream(path);
            BufferedReader br = new BufferedReader(new InputStreamReader(fs));
            for (int j = 0; j < dictionary.words_Available; j++) {
                String line = br.readLine();
                String enTemp = "";
                boolean check = false;
                for (int i = 0; i < line.length(); i++) {
                    if (!check) {
                        enTemp += line.charAt(i);
                        if (line.charAt(i) == '\t') {
                            check = true;
                            i = i + 1;
                        }
                    }
                    if (check) {
                        break;
                    }
                }
                boolean check2 = true;
                for (int i = 0; i < pathOfWord.length(); i++) {
                    if (enTemp.charAt(i) != pathOfWord.charAt(i)) {
                        check2 = false;
                        break;
                    }
                }
                if (check2) {
                    WordSearched[count] = enTemp;
                    count++;
                }
                if (count == 8) break;
            }
            fs.close();
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return WordSearched;
    }
}

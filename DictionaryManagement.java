package com.company;

import java.io.FileInputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.stream.Stream;

public class DictionaryManagement {
    public Dictionary dictionary;
    DictionaryManagement() {
        dictionary = new Dictionary();
    }
    public void insertFromCommandline() {
        Scanner sc = new Scanner(System.in);
        String enWord = sc.nextLine();
        String vnWord = sc.nextLine();
        Word word = new Word(enWord, vnWord);
        dictionary.add_Word(word);
    }
    public void showAllWords() {
        System.out.println("No     " + "| English               | Vietnamese"); //5 / 15
        for (int i = 0; i < dictionary.words_Available; i++) {
            System.out.print(i+1);
            System.out.println("      " + dictionary.words_List[i].enWord + "              " + dictionary.words_List[i].vnWord);
        }
    }
    public void insertFromFile() {
        FileInputStream inputStream = null;
        String fileName = "C:\\Users\\Admin\\IdeaProjects\\dictionary\\src\\com\\company\\dictionaries.txt";
        //inputStream = new FileInputStream("dictionaries.txt");
        try (Stream<String> stream = Files.lines(Paths.get(fileName), StandardCharsets.UTF_8)) {
            stream.forEach(line -> {
                String vnTemp = "";
                String enTemp = "";
                boolean check = false;
                for (int i = 0; i < line.length(); i++) {
                    if (!check) {
                        enTemp += line.charAt(i);
                        if (line.charAt(i) == '\t' && line.charAt(i) == '\t') {
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
            });
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
    public void dictionaryLookup(String word) {
        for (int i = 0; i < dictionary.words_Available; i++) {
            if (dictionary.words_List[i].enWord.equals(word)) {
                System.out.println(dictionary.words_List[i].vnWord);
                break;
            }
        }
    }
}

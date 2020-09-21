package com.company;

public class Main {

    public static void main(String[] args) {
        DictionaryManagement management1 = new DictionaryManagement();
        management1.insertFromFile();
        management1.showAllWords();
        management1.dictionarySearcher("ap");
    }
}

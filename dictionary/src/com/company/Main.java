package com.company;

public class Main {

    public static void main(String[] args) {

        DictionaryManagement management1 = new DictionaryManagement();
        System.out.println(management1.dictionary.words_Available);
        //Word word = new Word("temperature", "tạm thời");
        Word word1 = new Word("orange", "quả cam");
        //management1.dictionary.add_Word(word);
        management1.dictionary.add_Word(word1);
        System.out.println(management1.dictionary.words_Available);

        //management1.insertFromCommandline();
        //management1.showAllWords();
        //System.out.println(management1.dictionaryLookup("actor"));
        try {
            management1.TranslateAString("raining");
            management1.pronunciation("raining");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

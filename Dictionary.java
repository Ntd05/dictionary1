package com.company;

import java.util.LinkedList;

public class Dictionary {
    Word[] words_List = new Word[1000];
    int words_Available;

    public void add_Word(Word word) {
        words_List[words_Available] = word;
        words_Available++;
    }

    Dictionary() {
        words_Available = 0;
        Word temp = new Word("apple", "táo");
        add_Word(temp);
    }


}

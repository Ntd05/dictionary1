package com.company;

public class Word {
    public String enWord;
    public String vnWord;
    //public String type;
    //public String pronunciation;
    //public String audio;
    public Word() {
        enWord = "unknown";
        vnWord = "không xác định";
    }
    public Word(String enWord, String vnWord) {
        this.enWord = enWord;
        this.vnWord = vnWord;
    }
}

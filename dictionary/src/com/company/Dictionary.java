package com.company;

import java.io.*;

public class Dictionary {
    int words_Available;
    public static final String pathOfAmount = "C:\\Users\\Admin\\IdeaProjects\\dictionary\\src\\com\\company\\number.txt";
    public static final String path = "C:\\Users\\Admin\\IdeaProjects\\dictionary\\src\\com\\company\\dictionaries.txt";


    public void setAmount() {
        try {
            FileInputStream fs = new FileInputStream(pathOfAmount);
            BufferedReader br = new BufferedReader(new InputStreamReader(fs));
                String temp = br.readLine();
                int foo = Integer.parseInt(temp);
                words_Available = foo;
                br.close();
                fs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setAmountToFile() {
        BufferedWriter buffer = null;
        FileWriter writer = null;

        try {
            writer = new FileWriter(pathOfAmount);
            buffer = new BufferedWriter(writer);
            String temp = String.valueOf(words_Available);
            buffer.write(temp);
            System.out.println("Add into file successful");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (buffer != null)
                    buffer.close();
                if (writer != null)
                    writer.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

        setAmount();
    }

    Dictionary() {
        setAmount();
    }

    //Thêm từ vào file
    public void add_Word(Word word) {
        BufferedWriter bw = null;
        FileWriter fw = null;

        try {
            String data = word.enWord + '\t' + word.vnWord;
            File file = new File(path);
            if (!file.exists()) {
                file.createNewFile();
            }
            fw = new FileWriter(file.getAbsoluteFile(), true);
            bw = new BufferedWriter(fw);
            bw.write(data + '\n');
            words_Available++;
            System.out.println("Done");
            setAmountToFile();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bw != null)
                    bw.close();
                if (fw != null)
                    fw.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    public void delete_Word(Word word) {

    }


}

package practiceone.secondtask.controllers;

import java.io.*;

public class ReaderFromFile implements AutoCloseable {
    private String variablePartOfPath = "C:\\Тампашев\\РАЗНОЕ\\labs\\DEV-J20-PracticeOne";
    private String absolutePath = variablePartOfPath + "\\src\\main\\java\\resources\\students.xml";
    BufferedReader reader;

    public ReaderFromFile() throws FileNotFoundException {
        reader = new BufferedReader(new FileReader(new File(absolutePath)));
    }

    public boolean ready() throws IOException {
        return reader.ready();
    }

    public String readElement() throws IOException {
        return reader.readLine().trim();
    }

    @Override
    public void close() throws IOException {
        reader.close();
    }

    public static void main(String[] args) {

    }
}

package practiceone.secondtask;

import java.io.*;

public class ReaderFromFile implements AutoCloseable {
    private String variablePartOfPath = "D:\\J20";
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
        try {
            ReaderFromFile readerFromFile = new ReaderFromFile();
            readerFromFile.readElement();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

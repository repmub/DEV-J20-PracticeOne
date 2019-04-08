package practiceone.firsttask;

import java.io.*;
import java.util.*;

public class FirstTask {

    private String stringFromFile = "";
    final int maxValueOfDifferentSymbols = 3;

    private String variablePartOfPath = "D:\\J20";
    private String absolutePath = variablePartOfPath + "\\src\\main\\java\\resources\\string.txt";

    public void readStringFromFile() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(new File(absolutePath)));
        while (reader.ready())
            stringFromFile += reader.readLine();
        reader.close();
    }

    public void writeStringToFile() throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(new File(absolutePath)));
        writer.write(stringFromFile, 0, stringFromFile.length());
        writer.close();
    }

    public void modifyString(){
        Set<Character> differentSymbols = new HashSet<>();
        createCharacterCollection(differentSymbols);

        List<Character> symbolsOfString = new ArrayList<>(stringFromFile.length());
        createCharacterCollection(symbolsOfString);

        if (differentSymbols.size() > 3){
            // Удаляем три неповторяющихся символа из строки
            differentSymbols = doSetWithThreeSymbols(differentSymbols);
            symbolsOfString.removeAll(differentSymbols);
            removeThreeSymbolsFromString(symbolsOfString);
        } else
            // Добавляем к строке неповторяющиеся символы
            addLackingSymbolsToString(differentSymbols.size());
    }

    private Collection<Character> createCharacterCollection(Collection<Character> collection){
        char[] chars = stringFromFile.toCharArray();

        for (int i = 0; i < chars.length; i++){
            collection.add(chars[i]);
        }
        return collection;
    }

    private Set<Character> doSetWithThreeSymbols(Set<Character> set){
        Set<Character> threeSymbolSet = new HashSet<>(maxValueOfDifferentSymbols);

        for (Character currentSymbol : set) {
            threeSymbolSet.add(currentSymbol);
            if (threeSymbolSet.size() == maxValueOfDifferentSymbols)
                break;
        }
        return threeSymbolSet;
    }

    private void removeThreeSymbolsFromString(List<Character> symbols){
        stringFromFile = "";
        for (Character symbol : symbols)
            stringFromFile += symbol;
    }

    private void addLackingSymbolsToString(int amountOfLackingSymbols){
        for (int i = 0; i < 4 - amountOfLackingSymbols; i++){
            char charForAdding = new CharGenerator('A', 'Z').next();
            if (charForAdding == stringFromFile.charAt(stringFromFile.length() - 1)){
                i--;
                continue;
            }
            stringFromFile += charForAdding;
        }
    }

    public static void main(String[] args) {
        FirstTask firstTask = new FirstTask();
        try {
            firstTask.readStringFromFile();
            firstTask.modifyString();
            firstTask.writeStringToFile();
        } catch (IOException exp){
            System.out.println("Trouble of working with file.");
        }
    }
}

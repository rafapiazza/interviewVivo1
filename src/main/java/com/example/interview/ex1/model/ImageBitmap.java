package com.example.interview.ex1.model;

import com.example.interview.ex1.exception.BadRequestException;
import lombok.Data;

import java.util.Arrays;

@Data
public class ImageBitmap {
    private String[][] map;

    public ImageBitmap() {
        initiateImageBitmap();
    }

    public String findOccurrencesInMap(Occurrence occurrence) {
        elementsValidation(occurrence);
        int[] elementOccurrences = getNumberOfOccurrencesInMap(occurrence, this.map);
        return printOccurrences(occurrence, elementOccurrences);
    }

    public void elementsValidation(Occurrence occurrence) {
        emptyArrayValidation(occurrence);
        elementOutOfFormatValidation(occurrence);
    }

    private void emptyArrayValidation(Occurrence occurrence) {
        if (occurrence.getIn() == null || occurrence.getIn().length == 0 || (occurrence.getIn()[0].equals("") && occurrence.getIn().length == 1)) {
            throw new BadRequestException("Array[n] não pode ser vazio");
        }
    }

    private void elementOutOfFormatValidation(Occurrence occurrence) {
        for (String element : occurrence.getIn()) {
            if (element.startsWith("-")) {
                throw new BadRequestException("Elemento " + element + " não pertence aos {0,1...15}");
            } else {
                if (!element.matches("^[0-9]*$")) {
                    throw new BadRequestException("Elemento " + element + " não é um número");
                }
            }
            if (Integer.parseInt(element) > 15) {
                throw new BadRequestException("Elemento " + element + " fora do intervalo");
            }
        }
    }

    private int[] getNumberOfOccurrencesInMap(Occurrence occurrence, String[][] map) {
        int[] elementOccurrences = new int[occurrence.getIn().length];

        for (int rowIndex = 0; rowIndex < occurrence.getIn().length; rowIndex++) {
            int index = rowIndex;
            Arrays.stream(map).forEach(mapRow -> {
                Arrays.stream(mapRow).forEach(mapElement -> {
                    if (mapElement.equals(occurrence.getIn()[index])) {
                        elementOccurrences[index]++;
                    }
                });
            });
        }
        return elementOccurrences;
    }

    private String printOccurrences(Occurrence occurrence, int[] elementOccurrences) {
        StringBuilder occurrences = new StringBuilder();
        for (int index = 0; index < occurrence.getIn().length; index++) {
            occurrences.append("Elemento ")
                    .append(occurrence.getIn()[index])
                    .append(" encontrado ")
                    .append(elementOccurrences[index])
                    .append(" vezes")
                    .append("\n");
        }
        return occurrences.toString();
    }

    public String[][] initiateImageBitmap(int row, int column) {
        this.map = new String[row][column];
        for (int rowIndex = 0; rowIndex < row; rowIndex++) {
            for (int columnIndex = 0; columnIndex < column; columnIndex++) {
                map[rowIndex][columnIndex] = String.valueOf(Math.random() * 16);
            }
        }
        return map;
    }

    public String[][] initiateImageBitmap() {
        this.map = new String[5][5];
        for (int row = 0; row < 5; row++) {
            for (int column = 0; column < 5; column++) {
                map[row][column] = String.valueOf((int) (Math.random() * 16));
            }
        }
        return map;
    }
}

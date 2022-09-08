package com.example.interview.ex1.model;

import lombok.Data;

@Data
public class Occurrence {
    private String[] in;

    public Occurrence() {
        initializeOccurrence();
    }

    private void initializeOccurrence() {
        this.in = new String[5];
        for (int row = 0; row < 5; row++) {
            this.in[row] = String.valueOf((int) (Math.random() * 16));
        }
    }
}

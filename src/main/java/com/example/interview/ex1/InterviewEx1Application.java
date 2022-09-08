package com.example.interview.ex1;

import com.example.interview.ex1.model.ImageBitmap;
import com.example.interview.ex1.model.Occurrence;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;


@SpringBootApplication
public class InterviewEx1Application {

    public static void main(String[] args) {

        SpringApplication.run(InterviewEx1Application.class, args);

        ImageBitmap imageBitmap = new ImageBitmap(); //inicializa a imagem

        Scanner scanner = new Scanner(System.in); //prepara o input

        System.out.print("Digite o vetor separado por espaços:");
        String input = scanner.nextLine();

        Occurrence occurrence = new Occurrence();
        occurrence.setIn(input.split(" ")); //seta o input para as ocorrências

        System.out.println();

        try {
            System.out.println(imageBitmap.findOccurrencesInMap(occurrence)); //cenário feliz dentro dos padrões
        } catch (Exception e) {
            System.out.println(e.getMessage()); //cenário ruim, fora dos padrões
        }


    }

}

package trabalhopoo;

import java.io.File; 
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner; 

public class FitaMain {
    public static void main(String[] args) throws UnsupportedEncodingException {
        int totalFitas = 0, totalFitasValidas = 0, totalFitasInvalidas = 0;
        List<Integer> linhasInvalidas = new ArrayList<>();

        String caminhoArquivoOriginal = "C:\\Users\\alunos\\Desktop\\trabalhoPOO\\trabalhopoo\\src\\trabalhopoo\\DNA.txt";
        String caminhoArquivoSaida = "C:\\Users\\alunos\\Desktop\\trabalhoPOO\\trabalhopoo\\src\\trabalhopoo\\DNAfinal.txt";

        try {
            File arquivoEntrada = new File(caminhoArquivoOriginal);
            PrintWriter arquivoSaida = new PrintWriter(caminhoArquivoSaida, "UTF-8");
            Scanner leitor = new Scanner(arquivoEntrada);
            
            while (leitor.hasNextLine()) {
                String fita = leitor.nextLine();
                totalFitas++;

                boolean fitaValida = true; 
                String fitaComplementar = "";

                for (char dup : fita.toCharArray()) {
                    if (dup != 'G' && dup != 'A' && dup != 'T' && dup != 'C') {
                        fitaValida = false; 
                        break;
                    } 
                }

                if (fitaValida) {
                    for (char dup : fita.toCharArray()) {
                        if (dup == 'G') 
                            fitaComplementar += 'C';
                        else if (dup == 'C')
                            fitaComplementar += 'G';
                        else if (dup == 'T')
                            fitaComplementar += 'A';
                        else 
                            fitaComplementar += 'T';
                    }
                    arquivoSaida.println(fitaComplementar);
                    totalFitasValidas++;
                } else {
                	arquivoSaida.println("***FITA INVÁLIDA - " + fita);
                    totalFitasInvalidas++;
                    linhasInvalidas.add(totalFitas);
                }
            }

            leitor.close();
            arquivoSaida.close();

        } catch (FileNotFoundException e) {
            System.out.println("Um erro ocorreu.");
            e.printStackTrace();
        }

        System.out.println("O total de fitas é: " + totalFitas);
        System.out.println("O total de fitas válidas é: " + totalFitasValidas);
        System.out.println("O total de fitas inválidas é: " + totalFitasInvalidas);
        System.out.println("As linhas inválidas são: " + linhasInvalidas);
    }
}
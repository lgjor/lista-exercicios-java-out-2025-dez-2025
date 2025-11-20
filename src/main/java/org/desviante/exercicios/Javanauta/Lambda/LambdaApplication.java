package org.desviante.exercicios.Javanauta.Lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.UnaryOperator;

class PrefixSuffixOperator {

    public static final String PREFIX = "__pref__";
    public static final String SUFFIX = "__suff__";

    public static UnaryOperator<String> operator = s -> PREFIX+s.trim()+SUFFIX;
}

// Interface funcional que possui um método abstrato, ou seja, sem implementação.
interface OperacaoMatematica{
    int calcular(int a, int b);
}

interface ManipuladorString{
    String manipular (String str);
}

public class LambdaApplication {


    public static void main(String[] args) {

        OperacaoMatematica soma = new OperacaoMatematica() {
            @Override
            public int calcular(int a, int b) {

                return a+b;

            }
        };
        System.out.println("Soma com override: "+soma.calcular(5, 10));

        OperacaoMatematica somaLambda = (a, b) -> a+b;

        System.out.println("Soma com lambda: "+somaLambda.calcular(5, 10));

        OperacaoMatematica multiplicaLambda = (a, b) -> a*b;

        System.out.println("Multiplicação com lambda: "+multiplicaLambda.calcular(5, 10));

        // Manipulação de string

        ManipuladorString maiuscula = new ManipuladorString() {
            @Override
            public String manipular(String str) {
                return str.toUpperCase();
            }
        };
        System.out.println("Manipulador de String para Upper Case com override: " + maiuscula.manipular("tesTe"));

        ManipuladorString manipularLambda = str -> str.toUpperCase();

        System.out.println("Manipulador de String para Upper Case com Lambda: " + manipularLambda.manipular("tesTe"));;

        // Usando filter

        List<String> palavras = Arrays.asList("Java", "Lambda", "Python", "Spring");

        List<String> palavrasFiltradas = new ArrayList<>();
        for (String palavra: palavras){
            if (palavra.length()>5){
                palavrasFiltradas.add(palavra);
            }
        }
        System.out.println("Palavras com mais de 5 letras sem lambda: " + palavrasFiltradas);

        List<String> palavrasFiltradasLambda = palavras.stream().filter(palavra -> palavra.length()>5).toList();

        System.out.println("Palavras com mais de 5 letras com lambda: " + palavrasFiltradasLambda);

        // Como o stream é uma interface, podemos filtrar objetos com lambda

        List<Pessoa> pessoas = Arrays.asList(
                new Pessoa("Alice", 25),
                new Pessoa("Paulo", 30),
                new Pessoa("José", 33),
                new Pessoa("Pedro", 30)
        );

        List<String> nomes = pessoas.stream().map(pessoa -> pessoa.getNome()).toList();
        List<Integer> idades = pessoas.stream().map(Pessoa::getIdade).toList();

        System.out.println("Lista de nomes: "+nomes);
        System.out.println("Lista de idades: "+idades);

    }
}

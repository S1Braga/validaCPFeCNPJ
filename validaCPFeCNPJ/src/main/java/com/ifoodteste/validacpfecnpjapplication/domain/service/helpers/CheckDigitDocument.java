package com.ifoodteste.validacpfecnpjapplication.domain.service.helpers;

public class CheckDigitDocument {

    public static String isCPF(String number) {


        char dig10;
        char dig11;
        int sm;
        int i;
        int r;
        int num;
        int peso;

        // Calculo do 1o. Digito Verificador

        sm = 0;
        peso = 10;
        for (i = 0; i < 9; i++) {
            // converte o i-esimo caractere do number em um numero:
            // por exemplo, transforma o caractere '0' no inteiro 0
            // (48 eh a posicao de '0' na tabela ASCII)
            num = number.charAt(i) - 48;
            sm = sm + (num * peso);
            peso = peso - 1;
        }

        r = 11 - (sm % 11);

        if ((r == 10) || (r == 11))
            dig10 = '0';
        else dig10 = (char) (r + 48); // converte no respectivo caractere numerico

        String one = Character.toString(dig10);

        // Calculo do 2o. Digito Verificador
        //Adicionando o primeiro digito verificador a String

        sm = 0;
        peso = 11;
        number = number + one;
        for (i = 0; i < 10; i++) {
            num = number.charAt(i) - 48;
            sm = sm + (num * peso);
            peso = peso - 1;
        }

        r = 11 - (sm % 11);
        if ((r == 10) || (r == 11))
            dig11 = '0';
        else dig11 = (char) (r + 48);

        String two = Character.toString(dig11);

        return one + two;
    }


    public static String isCNPJ(String number) {

        char dig13;
        char dig14;
        int sm;
        int i;
        int r;
        int num;
        int peso;

        // Calculo do 1o. Digito Verificador
        sm = 0;
        peso = 2;
        for (i = 11; i >= 0; i--) {
            // converte o i-ésimo caractere do CNPJ em um número:
            // por exemplo, transforma o caractere '0' no inteiro 0
            // (48 eh a posição de '0' na tabela ASCII)
            num = number.charAt(i) - 48;
            sm = sm + (num * peso);
            peso = peso + 1;
            if (peso == 10)
                peso = 2;
        }

        r = sm % 11;
        if ((r == 0) || (r == 1))
            dig13 = '0';
        else dig13 = (char) ((11 - r) + 48);

        String one = Character.toString(dig13);

        // Calculo do 2o. Digito Verificador
        sm = 0;
        peso = 2;
        number = number + one;
        for (i = 12; i >= 0; i--) {
            num = number.charAt(i) - 48;
            sm = sm + (num * peso);
            peso = peso + 1;
            if (peso == 10)
                peso = 2;
        }

        r = sm % 11;
        if ((r == 0) || (r == 1))
            dig14 = '0';
        else dig14 = (char) ((11 - r) + 48);

        String two = Character.toString(dig14);

        return one + two;

    }
}

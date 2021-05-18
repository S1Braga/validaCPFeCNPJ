package com.ifoodteste.validacpfecnpjapplication.domain.service.helpers;

import java.util.InputMismatchException;


public class CheckValidDocument {

    public static boolean isCPF(String number) {
        // considera-se erro number's formados por uma sequencia de numeros iguais
        if (number.equals("00000000000") ||
                number.equals("11111111111") ||
                number.equals("22222222222") || number.equals("33333333333") ||
                number.equals("44444444444") || number.equals("55555555555") ||
                number.equals("66666666666") || number.equals("77777777777") ||
                number.equals("88888888888") || number.equals("99999999999") ||
                (number.length() != 11))
            return (false);

        char dig10;
        char dig11;
        int sm;
        int i;
        int r;
        int num;
        int peso;

        // "try" - protege o codigo para eventuais erros de conversao de tipo (int)
        try {
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

            // Calculo do 2o. Digito Verificador
            sm = 0;
            peso = 11;
            for (i = 0; i < 10; i++) {
                num = number.charAt(i) - 48;
                sm = sm + (num * peso);
                peso = peso - 1;
            }

            r = 11 - (sm % 11);
            if ((r == 10) || (r == 11))
                dig11 = '0';
            else dig11 = (char) (r + 48);

            // Verifica se os digitos calculados conferem com os digitos informados.
            return (dig10 == number.charAt(9)) && (dig11 == number.charAt(10));
        } catch (InputMismatchException erro) {
            return (false);
        }
    }

    public static boolean isCNPJ(String number) {

        if (number.equals("00000000000000") || number.equals("11111111111111") ||
                number.equals("22222222222222") || number.equals("33333333333333") ||
                number.equals("44444444444444") || number.equals("55555555555555") ||
                number.equals("66666666666666") || number.equals("77777777777777") ||
                number.equals("88888888888888") || number.equals("99999999999999") ||
                (number.length() != 14))
            return (false);

        char dig13;
        char dig14;
        int sm;
        int i;
        int r;
        int num;
        int peso;

        // "try" - protege o código para eventuais erros de conversao de tipo (int)
        try {
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

        // Calculo do 2o. Digito Verificador
            sm = 0;
            peso = 2;
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

        // Verifica se os dígitos calculados conferem com os dígitos informados.
            return (dig13 == number.charAt(12)) && (dig14 == number.charAt(13));
        } catch (InputMismatchException erro) {
            return (false);
        }
    }

}


package br.com.fiap_tc5.hackaton.infrastructure.utils;

import java.text.Normalizer;
import java.util.Locale;

public class StringNormalize {

    private static final Locale LOCALE_PT_BR = new Locale("pt", "BR");

    public static String normalize(String value) {
        if (value == null) return null;

        return Normalizer.normalize(value, Normalizer.Form.NFD)
                .replaceAll("\\p{InCombiningDiacriticalMarks}+", "")
                .replaceAll("\\s+", "-")            // espaço vira hífen
                .replaceAll("[^a-zA-Z-]", "")       // remove resto
                .replaceAll("-{2,}", "-")           // evita hífen duplicado
                .replaceAll("^-|-$", "")             // remove hífen no começo/fim
                .toUpperCase(LOCALE_PT_BR);
        }
}

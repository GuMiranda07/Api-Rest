package com.apirest.mapper;

import com.apirest.exception.DataNascimentoException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DataNascimentoMapper {
    private static DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    public static LocalDate convertFrom(String dataNascimento) throws DataNascimentoException {
        try{
            return LocalDate.parse(dataNascimento, dateFormatter);
        } catch (Exception e) {
            throw new DataNascimentoException();
        }
    }

    public static String convertFrom(LocalDate dataNascimento) {
        return dataNascimento.format(dateFormatter);
    }

    public static Boolean verificarSeDataNaoEhValida(String dataNascimento) {
        try {
            DataNascimentoMapper.convertFrom(dataNascimento);
            return false;
        } catch (DataNascimentoException e) {
            return true;
        }
    }
}

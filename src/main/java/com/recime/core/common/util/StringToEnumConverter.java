package com.recime.core.common.util;

import com.recime.core.constants.Difficulty;
import com.recime.core.exception.InvalidDifficultyException;
import org.springframework.core.convert.converter.Converter;

import static com.recime.core.constants.RecimeConstants.INVALID_DIFFICULTY_PARAM;
import static com.recime.core.constants.RecimeConstants.TITLE_OOPS;

public class StringToEnumConverter implements Converter<String, Difficulty>{

    @Override
    public Difficulty convert(String source) {
        try {
            return Difficulty.valueOf(source.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new InvalidDifficultyException(TITLE_OOPS, INVALID_DIFFICULTY_PARAM);
        }
    }
}


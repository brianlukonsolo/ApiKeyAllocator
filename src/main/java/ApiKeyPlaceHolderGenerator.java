import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static constants.Constants.CustomStrings.ALPHA_NUMERIC_CHARS;
import static constants.Constants.DateFormats.YEAR_MONTH_DATE_HOUR_MIN_SEC_MILI;
import static constants.Constants.NumericalLimits.MINIMUM_CHARACTER_LENGTH_OF_PLACEHOLDER;
import static constants.Constants.NumericalLimits.MINIMUM_NUMBER_OF_PLACEHOLDERS;
import static constants.Constants.NumericalLimits.INT_ZERO;

public class ApiKeyPlaceHolderGenerator {
    private String alphaNumericChars = ALPHA_NUMERIC_CHARS;

    public List<String> generatePlaceholders(int numberOfPlaceholdersToGenerate, int placeholderStringLength) {
        numberOfPlaceholdersToGenerate = validateNumberOfPlaceHoldersTogenerateInput(numberOfPlaceholdersToGenerate);
        byte[] array = validatePlaceholderStringLengthRequirement(placeholderStringLength);
        List<String> generatedPlaceholders = new ArrayList();
        StringBuilder stringBuilder;
        int randomCharacterIndex;

        for(int count = 0; count < numberOfPlaceholdersToGenerate; count++){
            stringBuilder = new StringBuilder();
            for(int index=0; index < array.length; index++){
                randomCharacterIndex = ((int)(Math.random()*alphaNumericChars.length()));
                stringBuilder.append(alphaNumericChars.charAt(randomCharacterIndex));
            }
            generatedPlaceholders.add( new SimpleDateFormat(YEAR_MONTH_DATE_HOUR_MIN_SEC_MILI)
                    .format(new Date()) + "-" + stringBuilder.toString()
            );
        }

        return generatedPlaceholders;

    }

    private byte[] validatePlaceholderStringLengthRequirement(int placeholderStringLength){
        byte[] validArray = new byte[MINIMUM_CHARACTER_LENGTH_OF_PLACEHOLDER];
        if(placeholderStringLength > INT_ZERO){
            validArray = new byte[placeholderStringLength];
        }

        return validArray;

    }

    private int validateNumberOfPlaceHoldersTogenerateInput(int numberToGenerate){
        int numberOfPlaceholdersToGenerate = numberToGenerate;
        if(numberOfPlaceholdersToGenerate <= INT_ZERO){
            numberOfPlaceholdersToGenerate = MINIMUM_NUMBER_OF_PLACEHOLDERS;
        }

        return numberOfPlaceholdersToGenerate;

    }


}

import org.json.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.NoSuchAlgorithmException;
import java.util.Random;
import java.util.stream.Stream;

import static constants.Constants.CustomStrings.ALPHA_NUMERIC_CHARS;
import static constants.Constants.NumericalLimits.INT_ZERO;
import static constants.Constants.NumericalLimits.MAXIMUM_CHARACTER_LENGTH_OF_RANDOM_STRING;

public class ApiKeyAllocator {

    public JSONObject allocateApiKeyToPlaceholder(String apiKeyPlaceHolderName) throws NoSuchAlgorithmException {
        JSONObject allocatedPlaceholders = new JSONObject();
        allocatedPlaceholders.put(
                apiKeyPlaceHolderName,
                new ApiKeyGenerator().generateSha256ApiKeyFromString(generateRandomString(INT_ZERO))
        );

        return allocatedPlaceholders;

    }

    public JSONObject allocateApiKeyToPlaceholdersFromTextFile(String fullPathToFile) throws IOException {
        JSONObject allocatedPlaceholdersFromTextFile = new JSONObject();
        try(Stream<String> stream = Files.lines(Paths.get(fullPathToFile))){
            stream.forEach(s -> {
                try {
                    allocatedPlaceholdersFromTextFile.put(s,
                            new ApiKeyGenerator().generateSha256ApiKeyFromString(generateRandomString(INT_ZERO)));
                } catch (NoSuchAlgorithmException e) {
                    e.printStackTrace();
                }
            });

        }

        return allocatedPlaceholdersFromTextFile;

    }

    private String generateRandomString(int lengthOfRandomString){
        final String alphaNumericChars = ALPHA_NUMERIC_CHARS;
        StringBuilder stringBuilder = new StringBuilder();
        Random random = new Random();
        int randomCharIndex;

        int randomNumber = random.nextInt(MAXIMUM_CHARACTER_LENGTH_OF_RANDOM_STRING) + 1;
        if(lengthOfRandomString <= INT_ZERO ){
            lengthOfRandomString = randomNumber;
        }

        byte[] byteArray = new byte[lengthOfRandomString];

        for(int index=INT_ZERO; index < byteArray.length; index++){
            randomCharIndex = ((int)(Math.random()*alphaNumericChars.length()));
            stringBuilder.append(alphaNumericChars.charAt(randomCharIndex));
        }

        return stringBuilder.toString();

    }

}

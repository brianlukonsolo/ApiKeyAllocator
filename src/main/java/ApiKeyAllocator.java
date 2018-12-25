import org.json.JSONObject;

import java.security.NoSuchAlgorithmException;
import java.util.Random;

import static constants.Constants.CustomStrings.ALPHA_NUMERIC_CHARS;
import static constants.Constants.NumericalLimits.MAXIMUM_CHARACTER_LENGTH_OF_RANDOM_STRING;

public class ApiKeyAllocator {

    public JSONObject allocateApiKeyToPlaceholder(String apiKeyPlaceHolderName) throws NoSuchAlgorithmException {
        JSONObject allocatedPlaceholders = new JSONObject();
        allocatedPlaceholders.put(
                apiKeyPlaceHolderName,
                new ApiKeyGenerator().generateSha256ApiKeyFromString(generateRandomString(0))
        );

        return allocatedPlaceholders;

    }

    private String generateRandomString(int lengthOfRandomString){
        final String alphaNumericChars = ALPHA_NUMERIC_CHARS;
        StringBuilder stringBuilder = new StringBuilder();
        Random random = new Random();
        int randomCharIndex;

        int randomNumber = random.nextInt(MAXIMUM_CHARACTER_LENGTH_OF_RANDOM_STRING) + 1;
        if(lengthOfRandomString <=0 ){
            lengthOfRandomString = randomNumber;
        }

        byte[] byteArray = new byte[lengthOfRandomString];

        for(int index=0; index < byteArray.length; index++){
            randomCharIndex = ((int)(Math.random()*alphaNumericChars.length()));
            stringBuilder.append(alphaNumericChars.charAt(randomCharIndex));
        }

        return stringBuilder.toString();

    }
}

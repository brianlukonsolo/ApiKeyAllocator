import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class ApiKeyGenerator {

    public String generateSha256ApiKeyFromString(String inputString) throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
        messageDigest.update(inputString.getBytes());

        return Base64.getEncoder().encodeToString(messageDigest.digest());

    }

}

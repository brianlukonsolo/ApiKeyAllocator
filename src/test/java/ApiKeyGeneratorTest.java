import org.junit.Before;
import org.junit.Test;

import java.security.NoSuchAlgorithmException;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ApiKeyGeneratorTest {
    private ApiKeyGenerator apiKeyGenerator;

    @Before
    public void before(){
        apiKeyGenerator = new ApiKeyGenerator();
    }

    @Test
    public void itShouldGenerateAnApiKeyUsingASha256DigestWhenGivenAString() throws NoSuchAlgorithmException {
        apiKeyGenerator = new ApiKeyGenerator();
        String actual = apiKeyGenerator.generateSha256ApiKeyFromString("BrianCorp");
        String expectedApiKey = "cdAvlf2aUpi4U3+ZmGzAq2H+RhThs+LokNqSPuz7DXE=";
        assertThat("API key must not be empty string", actual, is(equalTo(expectedApiKey)));
    }

}

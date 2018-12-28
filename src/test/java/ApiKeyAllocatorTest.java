import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

import static constants.Constants.CustomStrings.MOCK_API_PLACEHOLDER;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;

public class ApiKeyAllocatorTest {
    private ApiKeyAllocator apiKeyAllocator;

    @Before
    public void before(){
        apiKeyAllocator = new ApiKeyAllocator();
    }

    @Test
    public void itShouldAssignAnApiKeyToAPlaceholderWhenPassedAPlaceholderString() throws NoSuchAlgorithmException {
        JSONObject actual = apiKeyAllocator
                .allocateApiKeyToPlaceholder(MOCK_API_PLACEHOLDER);

        assertThat("correct placeholder must be returned in the json object",
                actual.keySet().toString().replace("[","").replace("]",""),
                is(equalTo(MOCK_API_PLACEHOLDER)));
        assertThat("placeholder must be assigned a key",
                actual.get(MOCK_API_PLACEHOLDER),
                is(not(equalTo(null))));
        assertThat("key length must be greater than zero",
                (actual.get(MOCK_API_PLACEHOLDER).toString().length() > 0),
                is(equalTo(true)));

    }

    @Test
    public void itShouldAssignMulitipleApiKeysWhenPassedATextFileContainingMultiplePlaceholderStrings() throws IOException {
        JSONObject actual = apiKeyAllocator.allocateApiKeyToPlaceholdersFromTextFile("src\\test\\resources\\placeholders.txt");

        assertThat("two api-keys must be assigned",
                actual.keySet().toArray().length,
                is(equalTo(2))
        );

    }

}

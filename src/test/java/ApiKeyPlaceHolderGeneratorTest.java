import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ApiKeyPlaceHolderGeneratorTest {
    private ApiKeyPlaceHolderGenerator apiKeyPlaceHolderGenerator;

    @Before
    public void before(){
        apiKeyPlaceHolderGenerator = new ApiKeyPlaceHolderGenerator();
    }

    @Test
    public void itShouldHaveAmethodToGenerateASpecifiedNumberOfApiKeyPlaceholders(){
        List actual = apiKeyPlaceHolderGenerator.generatePlaceholders(3, 15);
        int expectedNumberOfItems = 3;

        assertThat("Returned arrayList should contain 3 entries", actual.size(), is(equalTo(expectedNumberOfItems)));
    }

    @Test
    public void itShouldNotGenerateZeroPlaceHoldersWhenGivenAnInputOfZero(){
        List actual = apiKeyPlaceHolderGenerator.generatePlaceholders(0, 10);
        int expectedNumberOfItems = 1;

        assertThat("Returned arrayList should contain 1 item", actual.size(), is(equalTo(expectedNumberOfItems)));
    }

}

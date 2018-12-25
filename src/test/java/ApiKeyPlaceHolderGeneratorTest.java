import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static constants.Constants.NumericalLimits.MINIMUM_NUMBER_OF_PLACEHOLDERS;
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
        List actual = apiKeyPlaceHolderGenerator
                .generatePlaceholders(3, 15);
        int expectedNumberOfItems = 3;

        assertThat("Returned arrayList should contain 3 entries",
                actual.size(), is(equalTo(expectedNumberOfItems)));

    }

    @Test
    public void itShouldGenerateOnePlaceHoldersWhenGivenAnInputOfZero(){
        List actual = apiKeyPlaceHolderGenerator
                .generatePlaceholders(0, 10);
        int expectedNumberOfItems = MINIMUM_NUMBER_OF_PLACEHOLDERS;

        assertThat("Returned arrayList should contain 1 item",
                actual.size(), is(equalTo(expectedNumberOfItems)));

    }

    @Test
    public void itShouldGenerateOnePlaceHolderWhenGivenAnyInputLessThanZero(){
        List actual = apiKeyPlaceHolderGenerator
                .generatePlaceholders(-1, 10);
        List actual2 = apiKeyPlaceHolderGenerator
                .generatePlaceholders(-100, 10);
        int expectedNumberOfItems = MINIMUM_NUMBER_OF_PLACEHOLDERS;

        assertThat("Returned arrayList1 should contain 1 item",
                actual.size(), is(equalTo(expectedNumberOfItems)));
        assertThat("Returned arrayList2 should contain 1 item",
                actual2.size(), is(equalTo(expectedNumberOfItems)));

    }

}

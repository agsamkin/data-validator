package hexlet.code.schemas;

import hexlet.code.Validator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class NumberSchemaTest {
    private static final int TEST_NUMBER_0 = 0;
    private static final int TEST_NUMBER_4 = 4;
    private static final int TEST_NUMBER_5 = 5;
    private static final int TEST_NUMBER_10 = 10;
    private static final int TEST_NUMBER_11 = 11;

    @Test
    void isValid() {
        Validator v = new Validator();
        NumberSchema schema = v.number();

        Assertions.assertEquals(true, schema.isValid(null));

        schema.positive();
        Assertions.assertEquals(true, schema.isValid(null));

        schema.required();
        Assertions.assertEquals(false, schema.isValid(null));
        Assertions.assertEquals(true, schema.isValid(TEST_NUMBER_10));
        Assertions.assertEquals(false, schema.isValid("5"));
        Assertions.assertEquals(false, schema.isValid(-TEST_NUMBER_10));
        Assertions.assertEquals(false, schema.isValid(TEST_NUMBER_0));

        schema.range(TEST_NUMBER_5, TEST_NUMBER_10);
        Assertions.assertEquals(true, schema.isValid(TEST_NUMBER_5));
        Assertions.assertEquals(true, schema.isValid(TEST_NUMBER_10));
        Assertions.assertEquals(false, schema.isValid(TEST_NUMBER_4));
        Assertions.assertEquals(false, schema.isValid(TEST_NUMBER_11));
    }
}

package hexlet.code.schemas;

import hexlet.code.Validator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class StringSchemaTest {
    private static final int TEST_NUMBER = 5;

    @Test
    void isValid() {
        Validator v = new Validator();
        StringSchema schema = v.string();

        Assertions.assertEquals(true, schema.isValid(""));
        Assertions.assertEquals(true, schema.isValid(null));

        schema.required();
        Assertions.assertEquals(true, schema.isValid("what does the fox say"));
        Assertions.assertEquals(true, schema.isValid("hexlet"));
        Assertions.assertEquals(false, schema.isValid(""));
        Assertions.assertEquals(false, schema.isValid(null));
        Assertions.assertEquals(false, schema.isValid(TEST_NUMBER));

        schema.contains("wh");
        Assertions.assertEquals(true, schema.isValid("what does the fox say"));

        schema.contains("what");
        Assertions.assertEquals(true, schema.isValid("what does the fox say"));

        schema.contains("whatthe");
        Assertions.assertEquals(false, schema.isValid("what does the fox say"));
    }
}

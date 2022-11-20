package hexlet.code.schemas;

import hexlet.code.Validator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

class MapSchemaTest {
    private static final int TEST_NUMBER_2 = 2;
    private static final int TEST_NUMBER_5 = 5;
    private static final int TEST_NUMBER_100 = 100;

    @Test
    void isValidTest() {
        Validator v = new Validator();
        MapSchema schema = v.map();

        Assertions.assertEquals(true, schema.isValid(null));

        schema.required();
        Assertions.assertEquals(false, schema.isValid(null));
        Assertions.assertEquals(true, schema.isValid(new HashMap()));

        Map<String, String> data = new HashMap<>();
        data.put("key1", "value1");

        Assertions.assertEquals(true, schema.isValid(data));

        schema.sizeof(TEST_NUMBER_2);
        Assertions.assertEquals(false, schema.isValid(data));

        data.put("key2", "value2");
        Assertions.assertEquals(true, schema.isValid(data));
    }

    @Test
    void shapeTest() {
        Validator v = new Validator();
        MapSchema schema = v.map();

        Map<String, BaseSchema> schemas = new HashMap<>();
        schemas.put("name", v.string().required());
        schemas.put("age", v.number().positive());
        schema.shape(schemas);

        Map<String, Object> human1 = new HashMap<>();
        human1.put("name", "Kolya");
        human1.put("age", TEST_NUMBER_100);
        Assertions.assertEquals(true, schema.isValid(human1));

        Map<String, Object> human2 = new HashMap<>();
        human2.put("name", "Maya");
        human2.put("age", null);
        Assertions.assertEquals(true, schema.isValid(human2));

        Map<String, Object> human3 = new HashMap<>();
        human3.put("name", "");
        human3.put("age", null);
        Assertions.assertEquals(false, schema.isValid(human3));

        Map<String, Object> human4 = new HashMap<>();
        human4.put("name", "Valya");
        human4.put("age", -TEST_NUMBER_5);
        Assertions.assertEquals(false, schema.isValid(human4));
    }
}


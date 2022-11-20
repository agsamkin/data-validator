package hexlet.code.schemas;

import hexlet.code.Validator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

class MapSchemaTest {
    @Test
    void isValid() {
        Validator v = new Validator();
        MapSchema schema = v.map();

        Assertions.assertEquals(true, schema.isValid(null));

        schema.required();
        Assertions.assertEquals(false, schema.isValid(null));
        Assertions.assertEquals(true, schema.isValid(new HashMap()));

        Map<String, String> data = new HashMap<>();
        data.put("key1", "value1");

        Assertions.assertEquals(true, schema.isValid(data));

        schema.sizeof(2);
        Assertions.assertEquals(false, schema.isValid(data));

        data.put("key2", "value2");
        Assertions.assertEquals(true, schema.isValid(data));
    }
}

package hexlet.code;

import hexlet.code.schemas.StringSchema;

public final class Validator {
    public static StringSchema string() {
        return new StringSchema();
    }
}

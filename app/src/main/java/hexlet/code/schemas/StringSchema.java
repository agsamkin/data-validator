package hexlet.code.schemas;

public final class StringSchema extends BaseSchema {
    public StringSchema() {
        addCondition(o -> o instanceof String);
    }

    @Override
    public void required() {
        super.required();
        addCondition(o -> !((String) o).isEmpty());
    }

    public StringSchema minLength(int value) {
        addCondition(o -> ((String) o).length() >= value);
        return this;
    }

    public StringSchema contains(String value) {
        addCondition(o -> ((String) o).contains(value));
        return this;
    }
}



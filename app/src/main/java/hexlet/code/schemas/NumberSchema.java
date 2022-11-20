package hexlet.code.schemas;

public final class NumberSchema extends BaseSchema {
    public NumberSchema() {
        addCondition(o -> o instanceof Number);
    }

    public NumberSchema positive() {
        addCondition(o -> (int) o > 0);
        return this;
    }

    public NumberSchema range(int a, int b) {
        addCondition(o -> (int) o >= a && (int) o <= b);
        return this;
    }
}


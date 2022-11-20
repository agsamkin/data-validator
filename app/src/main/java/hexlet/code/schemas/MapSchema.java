package hexlet.code.schemas;

import java.util.Map;

public final class MapSchema extends BaseSchema {
    public MapSchema() {
        addCondition(o -> o instanceof Map);
    }

    public MapSchema sizeof(int value) {
        addCondition(o -> ((Map) o).size() == value);
        return this;
    }
}


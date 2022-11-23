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

    public MapSchema shape(Map<String, BaseSchema> schemas) {
        schemas.entrySet().forEach(schema -> addKeyCondition(schema.getKey(), schema.getValue()));
        return this;
    }

    private void addKeyCondition(String key, BaseSchema baseSchema) {
        addCondition(o -> {
            Map map = (Map) o;
            if (map.containsKey(key)) {
                Object value = map.get(key);
                return baseSchema.isValid(value);
            }
            return false;
        });
    }
}


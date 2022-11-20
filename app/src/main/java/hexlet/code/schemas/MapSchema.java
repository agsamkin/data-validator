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
        for (Map.Entry<String, BaseSchema> schema : schemas.entrySet()) {
            String key = schema.getKey();
            BaseSchema baseSchema = schema.getValue();
            addShape(key, baseSchema);
        }
        return this;
    }

    private void addShape(String key, BaseSchema baseSchema) {
        addCondition(o -> {
            Map map = (Map) o;
            if (map.containsKey(key)) {
                Object value = map.get(key);
                return baseSchema.isValid(value);
            }
            return true;
        });
    }
}


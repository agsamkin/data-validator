package hexlet.code.schemas;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;

public abstract class BaseSchema {
    private boolean required = false;
    private final List<Predicate> conditions = new ArrayList<>();

    public final boolean isValid(Object object) {
        if (Objects.isNull(object)) {
            return required ? false : true;
        }

        for (Predicate condition : conditions) {
            if (!condition.test(object)) {
                return false;
            }
        }

        return true;
    }

    public final void addCondition(Predicate predicate) {
        conditions.add(predicate);
    }

    /**
     * Sets conditions for null object.
     *
     * @return this schema object
     */
    public BaseSchema required() {
        required = true;
        return this;
    }
}



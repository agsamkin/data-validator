package hexlet.code.schemas;

public final class StringSchema {
    private boolean required = false;
    private String contains = "";
    private int minLength = -1;

    public boolean isValid(Object object) {
        if (object == null) {
            return required ? false : true;
        }

        if (!(object instanceof String)) {
            return false;
        }

        String string = (String) object;
        if (string.isEmpty()) {
            return required ? false : true;
        }

        if (minLength != -1 && string.length() < minLength) {
            return false;
        }

        if (!string.contains(contains)) {
            return false;
        }

        return true;
    }

    public StringSchema contains(String value) {
        this.contains = value;
        return this;
    }

    public StringSchema minLength(int value) {
        this.minLength = value;
        return this;
    }

    public StringSchema required() {
        required = !required;
        return this;
    }
}



package turorial.question;

public enum Theme {
    BEGINNING("beginning"),
    STRING("string"),
    NUMBER("number"),
    ARRAY("array"),
    RECURSIVE("recursive");

    private final String name;

    Theme(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static Theme fromString(String text) {
        if (text != null) {
            for (Theme type : Theme.values()) {
                if (text.equalsIgnoreCase(type.name)) {
                    return type;
                }
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return name;
    }
}

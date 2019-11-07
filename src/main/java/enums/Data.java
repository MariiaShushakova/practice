package enums;

public enum Data {
    TEXT("Hello from WebDriver"),
    EXPIRATION("10M"),
    TEXT2("git config --global user.name  \"New Sheriff in Town\"\n" +
            "git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")\n" +
            "git push origin master --force"),
    HIGHLIGHTING_BASH("8"),
    NAME("helloweb"),
    NAME2("how to gain dominance among developers");

    private final String value;

    Data(String value) {
        this.value = value;
    }
    public String getValue() {
        return value;
    }
}

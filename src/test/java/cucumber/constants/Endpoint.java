package cucumber.constants;

public enum Endpoint {
    STORE("/store"),
    ACCOUNT("/account"),
    ;

    public final String url;

    Endpoint(String endpoint) {
        this.url = endpoint;
    }
}

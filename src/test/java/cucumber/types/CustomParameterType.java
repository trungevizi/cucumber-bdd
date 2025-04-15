package cucumber.types;

import cucumber.domainobjects.Product;
import io.cucumber.java.ParameterType;

public class CustomParameterType {

    @ParameterType(".*")
    public Product productTest(String name) {
        return new Product(name.replace("\"", ""));
    }
}

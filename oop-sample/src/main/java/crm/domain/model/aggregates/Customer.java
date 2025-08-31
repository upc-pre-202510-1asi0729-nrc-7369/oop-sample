package crm.domain.model.aggregates;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import shared.domain.model.valueobject.Address;
import shared.domain.model.valueobject.CustomerId;

import java.util.Objects;

@Getter
public class Customer {

    private final CustomerId id;
    @Setter
    @NonNull
    private String name;
    @Setter
    @NonNull
    private String email;
    @Setter
    @NonNull
    private Address address;


    /**
     *
     * @param name
     * @param email
     *
     * @throws java.lang.IllegalArgumentException
     */
    public Customer(String name, String email, Address address) {
        if (Objects.isNull(name) || name.isBlank())
            throw new IllegalArgumentException("Customer name cannot be null or blank");
        if (Objects.isNull(email) || email.isBlank())
            throw new IllegalArgumentException("Customer email cannot be null or blank");
        if (Objects.isNull(address))
            throw new IllegalArgumentException("Customer address cannot be null");

        this.id = new CustomerId();
        this.name = name;
        this.email = email;
        this.address = address;
    }



    public void updateContactInfo(@NonNull String email, @NonNull Address address) {
        if (email.isBlank())
            throw new IllegalArgumentException("Customer email cannot be null or blank");
        this.email = email;
        this.address = address;
    }

    public String getContactInfo() {
        return String.format("%s <%s>, %s", name, email, address);
    }

}

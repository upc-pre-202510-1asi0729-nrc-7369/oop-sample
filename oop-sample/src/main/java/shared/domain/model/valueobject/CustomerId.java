package shared.domain.model.valueobject;

import java.util.Objects;
import java.util.UUID;

public record CustomerId(UUID value) {
    public CustomerId {
        if (Objects.isNull(value))
            throw new IllegalArgumentException("Customer identifier cannot be null");
    }

    public CustomerId() {
        this(UUID.randomUUID());
    }

}

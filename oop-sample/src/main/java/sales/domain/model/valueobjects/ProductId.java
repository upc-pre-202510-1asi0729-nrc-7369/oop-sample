package sales.domain.model.valueobjects;

import java.util.Objects;
import java.util.UUID;

public record ProductId (UUID value){

    public ProductId {
        if(Objects.isNull(value))
            throw new IllegalArgumentException("Product identifier cannot be null");
    }

    public ProductId(){
        this(UUID.randomUUID());
    }
}


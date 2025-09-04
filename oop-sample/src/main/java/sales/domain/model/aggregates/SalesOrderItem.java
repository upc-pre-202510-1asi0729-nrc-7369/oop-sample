package sales.domain.model.aggregates;

import lombok.Getter;
import lombok.Setter;
import sales.domain.model.valueobjects.ProductId;
import shared.domain.model.valueobject.Money;

import java.math.BigDecimal;
import java.util.Objects;

@Getter
public class SalesOrderItem {

    private final ProductId productId;
    @Setter private int quantity;
    @Setter private Money unitPrice;

    public SalesOrderItem(ProductId productId, int quantity, Money unitPrice) {

        if(quantity <= 0)
            throw new IllegalArgumentException("Quantity must be greater than zero");
        if (unitPrice.amount().compareTo(BigDecimal.ZERO) <= 0)
            throw new IllegalArgumentException("Unit price must be greater than zero");
        if (Objects.isNull(unitPrice.currency()) || Objects.isNull(unitPrice.currency().getCurrencyCode()) || unitPrice.currency().getCurrencyCode().isBlank())
            throw new IllegalArgumentException("Unit price must have a currency");


        this.productId = productId;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
    }

    public Money calculateItemAmount() {
        return unitPrice.multiply(quantity);
    }

}

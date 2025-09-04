import crm.domain.model.aggregates.Customer;
import sales.domain.model.aggregates.SalesOrder;
import sales.domain.model.valueobjects.ProductId;
import shared.domain.model.valueobject.Address;
import shared.domain.model.valueobject.Money;

import java.math.BigDecimal;
import java.util.Currency;

public class Main {

    public static void main(String[] args){

        Address address = new Address("123 Main St", "Anytown", "12345", "USA");
        System.out.println("First Address: " + address);
        Address anotherAddress = new Address("456 Main St", "Anytown", "12345", "USA");
        System.out.println("Second Address: " + anotherAddress);

        Customer customer = new Customer("John Doe", "john.doe@gmail.com", address);
        System.out.println("Customer: " + customer.getContactInfo());

        System.out.println("Updating customer contact info...");
        customer.updateContactInfo(customer.getEmail(), anotherAddress);
        System.out.println("Customer: " + customer.getContactInfo());



        System.out.println("Creating a sales order...");
        SalesOrder order = new SalesOrder(customer.getId());
        Money price = new Money(new BigDecimal("30.30"), Currency.getInstance("USD"));
        ProductId productId = new ProductId();
        order.addItem(productId, 2, price);
        System.out.println("Order ID: " + order.getId());
        System.out.println("Order Date: " + order.getOrderDate());
        System.out.println("Customer ID: " + order.getCustomerId());
        System.out.println("Total Amount: " + order.getTotalAmountAsString());

    }
}



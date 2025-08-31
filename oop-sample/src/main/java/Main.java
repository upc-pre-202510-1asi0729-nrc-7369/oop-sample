import crm.domain.model.aggregates.Customer;
import shared.domain.model.valueobject.Address;

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



    }
}



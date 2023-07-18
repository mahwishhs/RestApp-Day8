package com.example.restappday8;
import java.util.ArrayList;
import java.util.List;

import java.util.ArrayList;
import java.util.List;

public class CustomerCRUD {
    private static List<Customer> customerData = new ArrayList<>();

    static {
        customerData.add(new Customer(1, "Mahwish", "mahwish@gmail.com", "123 Lahore", "03014311805"));
        customerData.add(new Customer(2, "Maheen", "maheen@gmail.com", "345 Karachi", "03014311111"));
        customerData.add(new Customer(3, "Hamza", "hamza@gmail.com", "123 Islamabad", "03014311225"));
        customerData.add(new Customer(4, "Khizar", "khizar@gmail.com", "456 Multan", "03014311444"));
        customerData.add(new Customer(5, "Sara", "sara@gmail.com", "789 Rawalpindi", "03014311666"));
        customerData.add(new Customer(6, "Ahmed", "ahmed@gmail.com", "567 Faisalabad", "03014311999"));
        customerData.add(new Customer(7, "Ahad", "ahad@gmail.com", "234 Peshawar", "03014311333"));
        customerData.add(new Customer(8, "Fatima", "fatima@gmail.com", "678 Quetta", "03014311555"));
        customerData.add(new Customer(9, "Usman", "usman@gmail.com", "901 Hyderabad", "03014311777"));
        customerData.add(new Customer(10, "Alisbha", "Alisbha@gmail.com", "123 Sukkur", "03014311911"));
        customerData.add(new Customer(11, "Sami", "sami@gmail.com", "567 Gujranwala", "03014311222"));

    }

    public List<Customer> getAllCustomers() {
        return new ArrayList<>(customerData);
    }

    public Customer getCustomerById(int id) {
        for (Customer customer : customerData) {
            if (customer.getId() == id) {
                return customer;
            }
        }
        return null;
    }

    public List<Customer> getCustomersByName(String name) {
        List<Customer> customersByName = new ArrayList<>();
        for (Customer customer : customerData) {
            if (customer.getName().equalsIgnoreCase(name)) {
                customersByName.add(customer);
            }
        }
        return customersByName;
    }

    public void saveCustomer(Customer customer) {
        customerData.add(customer);
    }

    public void updateCustomer(int id, Customer updatedCustomer) {
        for (int i = 0; i < customerData.size(); i++) {
            Customer customer = customerData.get(i);
            if (customer.getId() == id) {
                updatedCustomer.setId(id);
                customerData.set(i, updatedCustomer);
                return;
            }
        }
    }

    public void deleteCustomer(int id) {
        for (int i = 0; i < customerData.size(); i++) {
            Customer customer = customerData.get(i);
            if (customer.getId() == id) {
                customerData.remove(i);
                return;
            }
        }
    }
}

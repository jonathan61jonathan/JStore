package jstore.controller;

import jstore.*;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Calendar;

@RestController
public class CustomerController {

    @RequestMapping("/")
    public String indexPage(@RequestParam(value="name", defaultValue="world") String name) {
        return "Hello " + name;
    }

    @RequestMapping(value="/newcustomer", method= RequestMethod.POST)
    public Customer newCust(@RequestParam(value="name") String name,
                            @RequestParam(value="email") String email,
                            @RequestParam(value="username") String username,
                            @RequestParam(value="password") String password
    )
    {
        Customer customer = new Customer(name, email, username, password, 1999, 10, 10);
        try {
            DatabaseCustomer.addCustomer(customer);
        } catch(Exception ex) {
            ex.getMessage();
            return null;
        };

        return customer;
    }

    @RequestMapping("/getcustomer/{id}")
    public Customer getCust(@PathVariable int id) {
        Customer customer = DatabaseCustomer.getCustomer(id);
        return customer;
    }

    @RequestMapping(value="/logincust", method= RequestMethod.POST)
    public Customer loginCust(@RequestParam(value="email") String email,
                              @RequestParam(value="password") String password
    )
    {
        Customer customer = DatabaseCustomer.getCustomerLogin(email, password);
        return customer;
    }


    //supplier dipindah karena tidak terindeks pada class baru
    @RequestMapping("/supp")
    public String suppe() {
        return "tes";
    }

    @RequestMapping("/suppliers")
    public ArrayList<Supplier> supplierList() {
        System.out.println("tes");
        return DatabaseSupplier.getSupplierDatabase();
    }

    @RequestMapping("/suppliers/{id_supplier}")
    public Supplier getSupplier(@PathVariable int id_supplier) {
        Supplier supplier = DatabaseSupplier.getSupplier(id_supplier);
        return supplier;
    }

}
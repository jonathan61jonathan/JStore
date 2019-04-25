package jstore.controller;

import jstore.*;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Calendar;

@RestController
public class InvoiceController {


    @RequestMapping("/inv")
    public String inv() {
        return "tes";
    }

    @RequestMapping("/invoicecustomer/{id_customer}")
    public ArrayList<Invoice> invoiceCust(@PathVariable int id_customer) {
        try {
            ArrayList<Invoice> invoicelist = DatabaseInvoice.getActiveOrder(DatabaseCustomer.getCustomer(id_customer));
            return invoicelist;
        }catch (CustomerDoesntHaveActiveInvoiceException ex){
            return null;
        }
    }

    @RequestMapping("/invoice/{id_invoice}")
    public Invoice getInvoice(@PathVariable int id_invoice) {
        Invoice invoice = DatabaseInvoice.getInvoice(id_invoice);
        return invoice;
    }

    @RequestMapping(value="/createinvoicepaid", method= RequestMethod.POST)
    public Invoice createInvoicePaid(@RequestParam(value="listItem") ArrayList<Integer> listItem,
                              @RequestParam(value="idcustomer") int id_customer
    )
    {
        try {
            if(DatabaseInvoice.addInvoice(new Sell_Paid(listItem, DatabaseCustomer.getCustomer(id_customer)))){
                return DatabaseInvoice.getInvoice(DatabaseInvoice.getLastInvoiceID());
            }
        }catch (InvoiceAlreadyExistsException ex) {
        }
        return null;
    }

    @RequestMapping(value="/createinvoiceunpaid", method= RequestMethod.POST)
    public Invoice createInvoiceUnpaid(@RequestParam(value="listItem") ArrayList<Integer> listItem,
                                     @RequestParam(value="idcustomer") int id_customer
    )
    {
        try {
            if(DatabaseInvoice.addInvoice(new Sell_Unpaid(listItem, DatabaseCustomer.getCustomer(id_customer)))){
                return DatabaseInvoice.getInvoice(DatabaseInvoice.getLastInvoiceID());
            }
        }catch (InvoiceAlreadyExistsException ex) {
        }
        return null;
    }

    @RequestMapping(value="/createinvoiceinstallment", method= RequestMethod.POST)
    public Invoice createInvoiceInstallment(@RequestParam(value="listItem") ArrayList<Integer> listItem,
                                       @RequestParam(value="installment_period") int installment_period,
                                       @RequestParam(value="idcustomer") int id_customer
    )
    {
        try {
            if(DatabaseInvoice.addInvoice(new Sell_Installment(listItem, DatabaseCustomer.getCustomer(id_customer), installment_period))){
                return DatabaseInvoice.getInvoice(DatabaseInvoice.getLastInvoiceID());
            }
        }catch (InvoiceAlreadyExistsException ex) {
        }
        return null;
    }

    @RequestMapping(value="/canceltransaction", method= RequestMethod.POST)
    public Invoice cancelTransaction(@RequestParam(value="id_invoice") int id_invoice)
    {
        Invoice inv = DatabaseInvoice.getInvoice(id_invoice);
        boolean res = Transaction.cancelTransaction(inv);
        if(res){
            return inv;
        }
        return null;
    }

    @RequestMapping(value="/finishtransaction", method= RequestMethod.POST)
    public Invoice finishTransaction(@RequestParam(value="id_invoice") int id_invoice)
    {
        Invoice inv = DatabaseInvoice.getInvoice(id_invoice);
        boolean res = Transaction.finishTransaction(inv);
        if(res){
            return inv;
        }
        return null;
    }
}

package com.example.jstore_android_jonathan;


import java.util.ArrayList;
import java.util.Calendar;

/**
 * Implementasi UML Modul 2 class Invoice
 * kelas bertujuan untuk menyimpan dan mencetak invoice
 *
 * @author Jonathan
 * @version 28022019
 */
public class Invoice {
    private int id;
    private String  listItem;
    private String date;
    private int totalPrice;
    private String invoiceStatus;
    private String invoiceType;
    private boolean isActive;
    private String dueDate;
    private int installmentPeriod;
    private double installmentPrice;

    // paid
    public Invoice(int id, String listItem, String date, int totalPrice, String invoiceStatus, String invoiceType, boolean isActive) {
        this.id = id;
        this.listItem = listItem;
        this.date = date;
        this.totalPrice = totalPrice;
        this.invoiceStatus = invoiceStatus;
        this.invoiceType = invoiceType;
        this.isActive = isActive;
    }

    // unpaid
    public Invoice(int id, String listItem, String date, int totalPrice, String invoiceStatus, String invoiceType, boolean isActive, String dueDate) {
        this.id = id;
        this.listItem = listItem;
        this.date = date;
        this.totalPrice = totalPrice;
        this.invoiceStatus = invoiceStatus;
        this.invoiceType = invoiceType;
        this.isActive = isActive;
        this.dueDate = dueDate;
    }

    // installment
    public Invoice(int id, String listItem, String date, int totalPrice, String invoiceStatus, String invoiceType, boolean isActive, int installmentPeriod, double installmentPrice) {
        this.id = id;
        this.listItem = listItem;
        this.date = date;
        this.totalPrice = totalPrice;
        this.invoiceStatus = invoiceStatus;
        this.invoiceType = invoiceType;
        this.isActive = isActive;
        this.installmentPeriod = installmentPeriod;
        this.installmentPrice = installmentPrice;
    }

    public int getId()
    {
        return id;
    }
    public String getListItem() {
        return listItem;
    }
    public String getDate()
    {
        return date;
    }

    public int getTotalPrice()
    {
        return totalPrice;
    }


    public String getInvoiceStatus() {
        return invoiceStatus;
    }

    public String getInvoiceType() {
        return invoiceType;
    }

    public boolean isActive() {
        return isActive;
    }

    public String getDueDate() {
        return dueDate;
    }

    public int getInstallmentPeriod() {
        return installmentPeriod;
    }

    public double getInstallmentPrice() {
        return installmentPrice;
    }
}


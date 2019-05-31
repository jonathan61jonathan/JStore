package com.example.jstore_android_jonathan;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class BuatPesananRequest extends StringRequest {

    private static final String paid_URL = "http://10.0.2.2:8080/createinvoicepaid";
    private static final String unpaid_URL = "http://10.0.2.2:8080/createinvoiceunpaid";
    private static final String installment_URL = "http://10.0.2.2:8080/createinvoiceinstallment";
    private Map<String, String> params;

    // CONSTRUCTOR FOR PAID
    public BuatPesananRequest(int idCustomer, int itemId, Response.Listener<String> listener) {
        super(Method.POST, paid_URL, listener, null);
        params = new HashMap<>();
        params.put("idcustomer",idCustomer+"");
        params.put("listItem",itemId+"");
    }

    // CONSTRUCTOR FOR UNPAID
    public BuatPesananRequest(int idCustomer, int itemId, Response.Listener<String> listener, boolean unpaidFlag) {
        super(Method.POST, unpaid_URL, listener, null);
        params = new HashMap<>();
        params.put("idcustomer",idCustomer+"");
        params.put("listItem",itemId+"");
    }

    // CONSTRUCTOR FOR INSTALLMENT
    public BuatPesananRequest(int idCustomer, int itemId, Response.Listener<String> listener, int installmentPeriod) {
        super(Method.POST, installment_URL, listener, null);
        params = new HashMap<>();
        params.put("idcustomer",idCustomer+"");
        params.put("listItem",itemId+"");
        params.put("installmentPeriod",installmentPeriod+"");
    }

    @Override
    public Map<String, String> getParams() {
        return params;
    }
}


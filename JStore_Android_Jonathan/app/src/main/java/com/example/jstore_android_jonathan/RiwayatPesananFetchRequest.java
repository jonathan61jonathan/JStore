package com.example.jstore_android_jonathan;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

/**
 * Request untuk mendapatkan seluruh invoice untuk ditampilkan pada RiwayatPesananActivity
 *
 * @author Jonathan
 * @version 31-05-2019
 */
public class RiwayatPesananFetchRequest extends StringRequest {

    private static String URL = "http://10.0.2.2:8080/allinvoicecustomer/";

    public RiwayatPesananFetchRequest(Response.Listener<String> listener, int customerId) {
        super(Method.GET, URL+customerId, listener, null);
    }
}

package com.example.jstore_android_jonathan;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Request untuk menyelesaikan pesanan dari tombol pada SelesaiPesananActiviy
 *
 * @author Jonathan
 * @version 31-05-2019
 */
public class PesananSelesaiRequest extends StringRequest {
    private static final String Finish_URL = "http://10.0.2.2:8080/finishtransaction";
    private Map<String, String> params;

    public PesananSelesaiRequest(Response.Listener<String> listener, int idInvoice) {
        super(Method.POST, Finish_URL, listener, null);
        params = new HashMap<>();
        params.put("id_invoice",idInvoice+"");
    }

    @Override
    public Map<String, String> getParams() {
        return params;
    }
}

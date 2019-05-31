package com.example.jstore_android_jonathan;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Activity yang menampilkan seluruh invoice aktif yang didapat melalui PesananFetchRequest
 *
 * @author Jonathan
 * @version 31-05-2019
 */
public class SelesaiPesananActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private RecyclerViewAdapter mRecyclerViewAdapter;

    private ArrayList<Invoice> mInvoiceList;

    private int currentUserId;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selesai_pesanan);

        mRecyclerView = findViewById(R.id.recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        mInvoiceList = new ArrayList<>();

        //------ Extra Getter --------//
        currentUserId = getIntent().getExtras().getInt("currentUserId");

        Response.Listener<String> listener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONArray jsonResponse = new JSONArray(response);
                    if(jsonResponse != null){
                        for(int i = 0; i < jsonResponse.length(); i++){
                            JSONObject eachInvoice = jsonResponse.getJSONObject(i);

                            int customerId = eachInvoice.getInt("id");
                            JSONArray listItem = eachInvoice.getJSONArray("item");
                            String listItemText = listItem.toString();
                            String date = eachInvoice.getString("date");
                            int totalPrice = eachInvoice.getInt("totalPrice");
                            String invoiceStatus = eachInvoice.getString("invoiceStatus");
                            String invoiceType = eachInvoice.getString("invoiceType");
                            boolean isActive = eachInvoice.getBoolean("isActive");

                            Invoice invoice = null;

                            if(invoiceStatus.equals("Paid")){
                                invoice = new Invoice(customerId,listItemText,date,totalPrice,invoiceStatus,invoiceType, isActive);
                            }
                            if(invoiceStatus.equals("Unpaid")){
                                String dueDate = eachInvoice.getString("dueDate");
                                invoice = new Invoice(customerId,listItemText,date,totalPrice,invoiceStatus,invoiceType, isActive, dueDate);
                            }
                            if(invoiceStatus.equals("Installment")){
                                int installmentPeriod = eachInvoice.getInt("installmentPeriod");
                                double installmentPrice = eachInvoice.getDouble("installmentPrice");
                                invoice = new Invoice(customerId,listItemText,date,totalPrice,invoiceStatus,invoiceType, isActive,installmentPeriod,installmentPrice);
                            }

                            mInvoiceList.add(invoice);
                        }
                        mRecyclerViewAdapter = new RecyclerViewAdapter(SelesaiPesananActivity.this,mInvoiceList);
                        mRecyclerView.setAdapter(mRecyclerViewAdapter);
                    }else{
                        finish();
                    }
                } catch (JSONException e) {
                    finish();
                }
            }
        };

        PesananFetchRequest activeOrderRequest = new PesananFetchRequest(listener,currentUserId);
        RequestQueue queue = Volley.newRequestQueue(SelesaiPesananActivity.this);
        queue.add(activeOrderRequest);

    }
}

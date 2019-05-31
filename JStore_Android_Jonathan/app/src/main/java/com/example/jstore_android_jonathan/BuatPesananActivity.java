package com.example.jstore_android_jonathan;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BuatPesananActivity extends AppCompatActivity {

    private int currentUserId;
    private int itemId;
    private String itemName;
    private String itemCategory;
    private String itemStatus;
    private double itemPrice;
    private int installmentPeriod = 1;
    private String selectedPayment;

    private Gson gson = new Gson();

    private Item item;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.buat_pesanan);

        //d
        final EditText item_name = (EditText) findViewById(R.id.item_name);
        final EditText item_category = (EditText) findViewById(R.id.item_category);
        final EditText item_status = (EditText) findViewById(R.id.item_status);
        final EditText item_price = (EditText) findViewById(R.id.item_price);
        final EditText installment_period = (EditText) findViewById(R.id.installment_period);
        final EditText total_price = (EditText) findViewById(R.id.total_price);

        final Button hitung = (Button) findViewById(R.id.hitung);
        final Button pesan = (Button) findViewById(R.id.pesan);

        final TextView textPeriod = (TextView) findViewById(R.id.textPeriod);

        final RadioGroup radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        final RadioButton paid = (RadioButton) findViewById(R.id.paid);
        final RadioButton unpaid = (RadioButton) findViewById(R.id.unpaid);
        final RadioButton installment = (RadioButton) findViewById(R.id.installment);

        //e
        pesan.setVisibility(View.INVISIBLE);
        textPeriod.setVisibility(View.INVISIBLE);
        installment_period.setVisibility(View.INVISIBLE);


        currentUserId = Objects.requireNonNull(getIntent().getExtras()).getInt("id_customer");
        item = gson.fromJson(getIntent().getExtras().getString("Item"), Item.class);
        itemId = item.getId();
        itemName = item.getName();
        itemCategory = item.getCategory();
        itemPrice = item.getPrice();
        itemStatus = item.getStatus();
        installmentPeriod = 1;

        item_name.setText(itemName);
        item_category.setText(itemCategory);
        item_status.setText(itemStatus);
        item_price.setText(Double.toString(itemPrice));
        total_price.setText(Double.toString(itemPrice));

        //f
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(installment.isChecked()){
                    //installment_period.setText(installmentPeriod);
                    textPeriod.setVisibility(View.VISIBLE);
                    installment_period.setVisibility(View.VISIBLE);
                }else{
                    textPeriod.setVisibility(View.INVISIBLE);
                    installment_period.setVisibility(View.INVISIBLE);
                }
            }
        });

        //g
        hitung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(installment.isChecked()){
                    installmentPeriod = Integer.parseInt(installment_period.getText().toString());
                    total_price.setText(Double.toString(itemPrice/installmentPeriod));
                }else{
                    total_price.setText(Double.toString(itemPrice));
                }
                //hitung.setVisibility(View.INVISIBLE);
                pesan.setVisibility(View.VISIBLE);
            }
        });

        pesan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Response.Listener<String> listener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonResponse = new JSONObject(response);
                            if(jsonResponse != null){
                                AlertDialog.Builder builder1 = new AlertDialog.Builder(BuatPesananActivity.this);
                                builder1.setMessage("Order Success!").create().show();
//                                finish();
                            }else{
                                AlertDialog.Builder builder1 = new AlertDialog.Builder(BuatPesananActivity.this);
                                builder1.setMessage("Order Failed!").create().show();
                            }
                        } catch (JSONException e) {
                            AlertDialog.Builder builder1 = new AlertDialog.Builder(BuatPesananActivity.this);
                            builder1.setMessage("Order Failed!").create().show();
                        }
                    }
                };
                BuatPesananRequest order;
                if(radioGroup.getCheckedRadioButtonId() == R.id.paid){
                    order = new BuatPesananRequest(currentUserId,itemId,listener);
                }else if(radioGroup.getCheckedRadioButtonId() == R.id.unpaid){
                    order = new BuatPesananRequest(currentUserId,itemId,listener,true);
                }else{
                    String instString = Integer.toString(installmentPeriod);

                    int instPeriod = 1;
                    String pattern = "^\\d+$";
                    Pattern r = Pattern.compile(pattern);
                    Matcher m = r.matcher(instString);
                    if(m.find( )){
                        instPeriod = Integer.parseInt(instString);
                    }
                    order = new BuatPesananRequest(currentUserId,itemId,listener,instPeriod);
                }
                RequestQueue queue = Volley.newRequestQueue(BuatPesananActivity.this);
                queue.add(order);
            }
        });
    }

}

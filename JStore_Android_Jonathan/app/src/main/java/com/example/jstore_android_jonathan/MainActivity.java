package com.example.jstore_android_jonathan;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

import com.google.gson.Gson;

public class MainActivity extends AppCompatActivity {
    private ArrayList<Supplier> listSupplier = new ArrayList<>();
    private ArrayList<Item> listItem = new ArrayList<>();
    private HashMap<Supplier, ArrayList<Item>> childMapping = new HashMap<>();
    private int currentUserId;

    private ExpandableListAdapter listAdapter;
    private ExpandableListView expListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        if(bundle != null){
            currentUserId = (int) bundle.get("id");
        }

        expListView = (ExpandableListView) findViewById(R.id.lvExp);

        refreshList();
        expListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                Item selected = childMapping.get(listSupplier.get(groupPosition)).get(childPosition);
                Intent intent = new Intent(MainActivity.this, BuatPesananActivity.class);
                intent.putExtra("id_customer", currentUserId);
                Gson gson = new Gson();
                intent.putExtra("Item", gson.toJson(selected, Item.class));
                startActivity(intent);
                return true;
            }
        });

        final Button endOrderButton = findViewById(R.id.endOrderButton);
        final Button historyOrderButton = findViewById(R.id.historyOrderButton);

        endOrderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SelesaiPesananActivity.class);;
                intent.putExtra("currentUserId", currentUserId);
                startActivity(intent);
            }
        });

        historyOrderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Intent intent = new Intent(MainActivity.this, RiwayatPesananActivity.class);
                intent.putExtra("currentUserId", currentUserId);
                startActivity(intent);
            }
        });

    }

    protected void refreshList(){
        Response.Listener<String> responseListener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try{
                    JSONArray jsonResponse = new JSONArray(response);

                    for(int i=0; i<jsonResponse.length(); i++){
                        JSONObject item = jsonResponse.getJSONObject(i);
                        JSONObject supplier = item.getJSONObject("supplier");
                        JSONObject location = supplier.getJSONObject("location");

                        Location location1 = new Location(location.getString("province"),
                                location.getString("description"),
                                location.getString("city"));


                        Supplier supplier1 = new Supplier(supplier.getInt("id"),
                                supplier.getString("name"),
                                supplier.getString("email"),
                                supplier.getString("phoneNumber"),
                                location1);

                        Item item1 = new Item(item.getInt("id"),
                                item.getString("name"),
                                item.getInt("price"),
                                item.getString("category"),
                                item.getString("status"),
                                supplier1);

                        listItem.add(item1);

                        if(CollectionFunction.testSupplier(supplier1, listSupplier))
                            listSupplier.add(supplier1);
                    }

                    CollectionFunction.createChild(listSupplier, listItem, childMapping);
                    listAdapter = new MainListAdapter(MainActivity.this, listSupplier, childMapping);
                    expListView.setAdapter(listAdapter);

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        };

        MenuRequest menuRequest = new MenuRequest(responseListener);
        RequestQueue queue = Volley.newRequestQueue(MainActivity.this);
        queue.add(menuRequest);
    }
}

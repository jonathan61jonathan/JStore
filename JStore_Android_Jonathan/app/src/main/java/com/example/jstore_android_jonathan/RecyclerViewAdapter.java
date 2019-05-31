package com.example.jstore_android_jonathan;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * RecyclerView adapter untuk SelesaiPesananActivity
 *
 * @author Jonathan
 * @version 31-05-2019
 */
public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.RecyclerViewHolder> {
    private Context mContext;
    private ArrayList<Invoice> mInvoiceList;

    public RecyclerViewAdapter(Context context, ArrayList<Invoice> invoices) {
        mContext = context;
        mInvoiceList = invoices;
    }

    Response.Listener<String> transactionListener = new Response.Listener<String>() {
        @Override
        public void onResponse(String response) {
            try {
                JSONObject jsonResponse = new JSONObject(response);
                if(jsonResponse != null){
                    ((Activity) mContext).finish();
                }else {
                    Log.e("LogicListenerError","Null");
                    AlertDialog.Builder builder1 = new AlertDialog.Builder(mContext);
                    builder1.setMessage("Failed!").create().show();
                }
            } catch (JSONException e) {
                Log.e("LogicListenerError","Exception : "+e.toString());
                AlertDialog.Builder builder1 = new AlertDialog.Builder(mContext);
                builder1.setMessage("Failed!").create().show();
            }
        }
    };

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.recycler_card_item, parent, false);
        return new RecyclerViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder holder, int position) {
        final Invoice currentInvoice = mInvoiceList.get(position);

        holder.info_invoiceId.setText("ID: " + currentInvoice.getId());
        holder.info_listItem.setText("Dafter Item: " + currentInvoice.getListItem());
        holder.info_date.setText("Tanggal Pesan: " + currentInvoice.getDate());
        holder.info_totalPrice.setText("Total Harga: " + currentInvoice.getTotalPrice());
        holder.info_invoiceStatus.setText("Status: " + currentInvoice.getInvoiceStatus());
        holder.info_invoiceType.setText("Tipe: " + currentInvoice.getInvoiceType());

        holder.info_dueDate.setText("Tanggal Berakhir: -");
        holder.info_installmentPeriod.setText("Periode Cicilan: -");
        holder.info_installmentPrice.setText("Harga Cicilan: -");

        if (currentInvoice.getInvoiceStatus().equals("Unpaid")) {
            holder.info_dueDate.setText("Tanggal Berakhir: " + currentInvoice.getDueDate());
        } else if (currentInvoice.getInvoiceStatus().equals("Installment")){
            holder.info_installmentPeriod.setText("Periode Cicilan: " + currentInvoice.getInstallmentPeriod());
            holder.info_installmentPrice.setText("Harga Cicilan: " + currentInvoice.getInstallmentPrice());
        }

        holder.finishBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Log.d("FinishBtnClicked!","Invoice ID: " +currentInvoice.getId());
                PesananSelesaiRequest finishRequest = new PesananSelesaiRequest(transactionListener,currentInvoice.getId());
                RequestQueue queue = Volley.newRequestQueue(mContext);
                queue.add(finishRequest);
            }
        });
        holder.cancelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Log.d("CancelBtnClicked!","Invoice ID: " +currentInvoice.getId());
                PesananBatalRequest cancelRequest = new PesananBatalRequest(transactionListener,currentInvoice.getId());
                RequestQueue queue = Volley.newRequestQueue(mContext);
                queue.add(cancelRequest);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mInvoiceList.size();
    }


    public class RecyclerViewHolder extends RecyclerView.ViewHolder {

        public TextView info_invoiceId;
        public TextView info_listItem;
        public TextView info_date;
        public TextView info_totalPrice;
        public TextView info_invoiceStatus;
        public TextView info_invoiceType;
        public TextView info_dueDate;
        public TextView info_installmentPeriod;
        public TextView info_installmentPrice;
        public Button finishBtn;
        public Button cancelBtn;

        public RecyclerViewHolder(@NonNull View itemView) {
            super(itemView);
            info_invoiceId = itemView.findViewById(R.id.info_invoiceId);
            info_listItem = itemView.findViewById(R.id.info_listItem);
            info_date = itemView.findViewById(R.id.info_date);
            info_totalPrice = itemView.findViewById(R.id.info_totalPrice);
            info_invoiceStatus = itemView.findViewById(R.id.info_invoiceStatus);
            info_invoiceType = itemView.findViewById(R.id.info_invoiceType);
            info_dueDate = itemView.findViewById(R.id.info_dueDate);
            info_installmentPeriod = itemView.findViewById(R.id.info_installmentPeriod);
            info_installmentPrice = itemView.findViewById(R.id.info_installmentPrice);

            finishBtn = itemView.findViewById(R.id.card_finishButton);
            cancelBtn = itemView.findViewById(R.id.card_cancelButton);
        }
    }

}

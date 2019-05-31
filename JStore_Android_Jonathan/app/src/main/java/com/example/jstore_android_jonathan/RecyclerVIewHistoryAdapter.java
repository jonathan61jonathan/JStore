package com.example.jstore_android_jonathan;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * RecyclerView adapter untuk RiwayatPesananActivity
 *
 * @author Jonathan
 * @version 31-05-2019
 */
public class RecyclerVIewHistoryAdapter extends RecyclerView.Adapter<RecyclerVIewHistoryAdapter.RecyclerViewHistoryHolder>{
    private Context mContext;
    private ArrayList<Invoice> mInvoiceList;

    public RecyclerVIewHistoryAdapter(Context mContext, ArrayList<Invoice> mInvoiceList) {
        this.mContext = mContext;
        this.mInvoiceList = mInvoiceList;
    }

    @NonNull
    @Override
    public RecyclerViewHistoryHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.recycler_card_history, parent, false);
        return new RecyclerViewHistoryHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHistoryHolder holder, int position) {
        final Invoice currentInvoice = mInvoiceList.get(position);
        holder.hist_invoiceId.setText("ID: " + currentInvoice.getId());
        holder.hist_listItem.setText("Dafter Item: " + currentInvoice.getListItem());
        holder.hist_date.setText("Tanggal Pesan: " + currentInvoice.getDate());
        holder.hist_totalPrice.setText("Total Harga: " + currentInvoice.getTotalPrice());
        holder.hist_invoiceStatus.setText("Status: " + currentInvoice.getInvoiceStatus());
        holder.hist_invoiceType.setText("Tipe: " + currentInvoice.getInvoiceType());
        holder.hist_isActive.setText("Aktif: " + currentInvoice.isActive());
        holder.hist_dueDate.setText("Tanggal Berakhir: -");
        holder.hist_installmentPeriod.setText("Periode Cicilan: -");
        holder.hist_installmentPrice.setText("Harga Cicilan: -");

        if (currentInvoice.getInvoiceStatus().equals("Unpaid")) {
            holder.hist_dueDate.setText("Tanggal Berakhir: " + currentInvoice.getDueDate());
        } else if (currentInvoice.getInvoiceStatus().equals("Installment")){
            holder.hist_installmentPeriod.setText("Periode Cicilan: " + currentInvoice.getInstallmentPeriod());
            holder.hist_installmentPrice.setText("Harga Cicilan: " + currentInvoice.getInstallmentPrice());
        }
    }

    @Override
    public int getItemCount() {
        return mInvoiceList.size();
    }

    public class RecyclerViewHistoryHolder extends RecyclerView.ViewHolder {

        public TextView hist_invoiceId;
        public TextView hist_listItem;
        public TextView hist_date;
        public TextView hist_totalPrice;
        public TextView hist_invoiceStatus;
        public TextView hist_invoiceType;
        public TextView hist_isActive;
        public TextView hist_dueDate;
        public TextView hist_installmentPeriod;
        public TextView hist_installmentPrice;

        public RecyclerViewHistoryHolder(@NonNull View itemView) {
            super(itemView);
            hist_invoiceId = itemView.findViewById(R.id.hist_invoiceId);
            hist_listItem = itemView.findViewById(R.id.hist_listItem);
            hist_date = itemView.findViewById(R.id.hist_date);
            hist_totalPrice = itemView.findViewById(R.id.hist_totalPrice);
            hist_invoiceStatus = itemView.findViewById(R.id.hist_invoiceStatus);
            hist_invoiceType = itemView.findViewById(R.id.hist_invoiceType);
            hist_isActive = itemView.findViewById(R.id.hist_isActive);
            hist_dueDate = itemView.findViewById(R.id.hist_dueDate);
            hist_installmentPeriod = itemView.findViewById(R.id.hist_installmentPeriod);
            hist_installmentPrice = itemView.findViewById(R.id.hist_installmentPrice);

        }
    }
}

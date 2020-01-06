package com.mam.sewalapanganfutsal.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.mam.sewalapanganfutsal.R;
import com.mam.sewalapanganfutsal.Transaksi;

import java.util.ArrayList;

public class CardViewTransaksiAdapter extends RecyclerView.Adapter<CardViewTransaksiAdapter.CardViewViewHolder> {
    private ArrayList<Transaksi> listTransaksi;

    public CardViewTransaksiAdapter(ArrayList<Transaksi> list) {
        this.listTransaksi = list;
    }

    private CardViewTransaksiAdapter.OnItemClickCallback onItemClickCallback;
    public void setOnItemClickCallback(CardViewTransaksiAdapter.OnItemClickCallback onItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback;
    }

    @NonNull
    @Override
    public CardViewViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_cardview_transaksi, viewGroup, false);
        return new CardViewViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final CardViewViewHolder holder, int position) {
        Transaksi transaksi = listTransaksi.get(position);

        Glide.with(holder.itemView.getContext()).load(transaksi.getPhoto()).into(holder.imgPhoto);

        holder.tvPenyewa.setText(transaksi.getPenyewa());
        holder.tvName.setText(transaksi.getName());
        holder.tvTgl.setText(transaksi.getTanggal());
        holder.tvJam.setText(transaksi.getJam());

        holder.btnDetail.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                onItemClickCallback.onItemClicked(listTransaksi.get(holder.getAdapterPosition()));
            }
        });
    }

    public interface OnItemClickCallback {
        void onItemClicked(Transaksi data);
    }

    @Override
    public int getItemCount() {
        return listTransaksi.size();
    }

    public void filterList(ArrayList<Transaksi> filteredList) {
        listTransaksi = filteredList;
        notifyDataSetChanged();
    }

    class CardViewViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPhoto;
        TextView tvName, tvPenyewa, tvTgl, tvJam;
        Button btnDetail;

        CardViewViewHolder(@NonNull View itemView){
            super(itemView);
            imgPhoto = itemView.findViewById(R.id.img_item_photo);
            tvPenyewa = itemView.findViewById(R.id.tv_item_penyewa);
            tvName = itemView.findViewById(R.id.tv_item_lapangan);
            tvTgl = itemView.findViewById(R.id.tv_item_tgl);
            tvJam = itemView.findViewById(R.id.tv_item_jam);
            btnDetail = itemView.findViewById(R.id.btn_detail);
        }
    }

}

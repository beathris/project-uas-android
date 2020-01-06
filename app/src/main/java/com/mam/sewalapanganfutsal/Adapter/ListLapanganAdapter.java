package com.mam.sewalapanganfutsal.Adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mam.sewalapanganfutsal.DetailLapanganActivity;
import com.mam.sewalapanganfutsal.Model.Lapangan;
import com.mam.sewalapanganfutsal.R;

import java.util.List;

public class ListLapanganAdapter extends RecyclerView.Adapter<ListLapanganAdapter.ListViewHolder> {
    private List<Lapangan> listLap;

    public ListLapanganAdapter(List<Lapangan> list) {
        this.listLap = list;
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_row_lapangan, viewGroup, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ListViewHolder holder, int position) {
        Lapangan lapangan = listLap.get(position);
        holder.tvName.setText(lapangan.getNama());
        holder.tvHarga.setText(lapangan.getHarga().toString());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                onItemClickCallback.onItemClicked(listLap.get(holder.getAdapterPosition()));
                int id = lapangan.getId();
                Intent intent = new Intent(v.getContext(), DetailLapanganActivity.class);
                intent.putExtra("KEY_ID", id);
                v.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listLap.size();
    }

    public void filterList(List<Lapangan> filteredList) {
        listLap = filteredList;
        notifyDataSetChanged();
    }

    public class ListViewHolder extends RecyclerView.ViewHolder {
        TextView tvName, tvHarga;

        public ListViewHolder(@NonNull View itemView) {
            super(itemView);
//            imgPhoto = itemView.findViewById(R.id.img_item_photo);
            tvName = itemView.findViewById(R.id.tv_item_name);
            tvHarga = itemView.findViewById(R.id.tv_item_harga);
        }
    }

}

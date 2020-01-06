package com.mam.sewalapanganfutsal.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mam.sewalapanganfutsal.Model.Kategori;
import com.mam.sewalapanganfutsal.R;

import java.util.List;

public class ListKategoriAdapter extends RecyclerView.Adapter<ListKategoriAdapter.ListViewHolder>{
    List<Kategori> LMKategori;
    OnItemClickListener OICListener;

    public ListKategoriAdapter(List<Kategori> LMKategori){
        this.LMKategori = LMKategori;
    }

    public class ListViewHolder extends RecyclerView.ViewHolder{
        TextView tvNama, tvId;
        Button btnDelete, btnEdit;

        public ListViewHolder(View itemView, final OnItemClickListener listener){
            super(itemView);
            tvNama = itemView.findViewById(R.id.tv_item_nama);
            btnEdit = itemView.findViewById(R.id.btn_edit);
            btnDelete = itemView.findViewById(R.id.btn_delete);

            btnEdit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            listener.onEditClick(position);
                        }
                    }
                }
            });

            btnDelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            listener.onDeleteClick(position);
                        }
                    }
                }
            });
        }
    }

    public interface OnItemClickListener {
        void onEditClick(int position);
        void onDeleteClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        OICListener = listener;
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View VDataKategori = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_kategori, parent, false);
        ListViewHolder VDK = new ListViewHolder(VDataKategori, OICListener);
        return VDK;
    }

    @Override
    public void onBindViewHolder(@NonNull ListViewHolder holder, int position) {
        Kategori Position = LMKategori.get(position);

        String Id = String.valueOf(Position.getId());

//        holder.tvId.setText(Id);
        holder.tvNama.setText(Position.getNama());
    }

    @Override
    public int getItemCount() {
        return LMKategori.size();
    }
}

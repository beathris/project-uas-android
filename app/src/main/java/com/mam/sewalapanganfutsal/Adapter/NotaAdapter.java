package com.mam.sewalapanganfutsal.Adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mam.sewalapanganfutsal.Model.Nota;
import com.mam.sewalapanganfutsal.R;

import java.util.List;

public class NotaAdapter extends RecyclerView.Adapter<NotaAdapter.ListViewHolder> {
    private List<Nota> listNota;
    public NotaAdapter(List<Nota> list) {
        this.listNota = list;
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_row_nota, viewGroup, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ListViewHolder holder, int position) {
        Nota nota = listNota.get(position);
        holder.tvTanggal.setText(nota.getTanggal().toString());
        holder.tvPenyewa.setText(nota.getPenyewa());
//        holder.tvtagihan.setText(nota.getTagihan().toString());
        holder.tvStatus.setText(nota.getStatus());
//        holder.itemView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                int Id = nota.getId();
//                Intent intent = new Intent(v.getContext(), DetailNotaActivity.class);
//                intent.putExtra("KEY_ID", Id);
//                v.getContext().startActivity(intent);
//            }
//        });
    }

    @Override
    public int getItemCount() {
        return listNota.size();
    }

    public class ListViewHolder extends RecyclerView.ViewHolder {
        TextView tvTanggal, tvPenyewa, tvtagihan, tvStatus;

        public ListViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTanggal = itemView.findViewById(R.id.tv_item_tgl);
            tvPenyewa = itemView.findViewById(R.id.tv_item_penyewa);
//            tvtagihan = itemView.findViewById(R.id.tv_item_tagihan);
            tvStatus = itemView.findViewById(R.id.tv_item_status);
        }
    }
}

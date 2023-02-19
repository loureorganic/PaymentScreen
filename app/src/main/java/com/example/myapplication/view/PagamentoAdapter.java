package com.example.myapplication.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.model.Pagamento;

import java.util.List;

public class PagamentoAdapter extends RecyclerView.Adapter<PagamentoAdapter.PagamentoViewHolder> {
    private List<Pagamento> pagamentos;

    public PagamentoAdapter(List<Pagamento> pagamentos) {
        this.pagamentos = pagamentos;
    }

    @NonNull
    @Override
    public PagamentoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_pagamento, parent, false);
        return new PagamentoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PagamentoViewHolder holder, int position) {
        Pagamento pagamento = pagamentos.get(position);
        holder.valor.setText(String.valueOf(pagamento.getValor()));
        holder.formaPagamento.setText(pagamento.getFormaPagamento());
    }

    @Override
    public int getItemCount() {
        return pagamentos.size();
    }

    public static class PagamentoViewHolder extends RecyclerView.ViewHolder {
        public TextView valor;
        public TextView formaPagamento;

        public PagamentoViewHolder(View itemView) {
            super(itemView);
            valor = itemView.findViewById(R.id.paymentWayTitle);
            formaPagamento = itemView.findViewById(R.id.valuePayment);
        }
    }
}

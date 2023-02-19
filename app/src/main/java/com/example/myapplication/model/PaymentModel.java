package com.example.myapplication.model;

import java.util.ArrayList;
import java.util.List;

public class PaymentModel {
    private List<Pagamento> pagamentos;

    public PaymentModel() {
        pagamentos = new ArrayList<>();
    }

    public void addPagamento(Pagamento pagamento) {
        pagamentos.add(pagamento);
    }

    public List<Pagamento> getPagamentos() {
        return pagamentos;
    }

    public float getPayValue() {
        float total = 0.0f;
        for (Pagamento pagamento : pagamentos) {
            total += pagamento.getValor();
        }
        return total;
    }

    public float getDebitValue() {
        float total = 1800.0f;
        return total;
    }

    public float getRestValue(){
        float total = getDebitValue() - getPayValue();
        return total;
    }


    public float getParcels(){
        float total = 0.0f;
        total = getDebitValue() / 2;
        return total;
    }

    public float getReduceValue(){
        float total = getRestValue();
        return total;
    }

}
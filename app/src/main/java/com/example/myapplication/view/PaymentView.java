package com.example.myapplication.view;

import com.example.myapplication.model.Pagamento;

import java.util.List;

public interface PaymentView {
    void showInputFields();
    void hideInputFields();
    void setPayValue(double value);
    void setRestValue(double value);
    void setReduceValue(double value);
    void setParcelsValue(double value);
    void setDebitValue(double value);
    void showPaymentsList(List<Pagamento> pagamentos);
}
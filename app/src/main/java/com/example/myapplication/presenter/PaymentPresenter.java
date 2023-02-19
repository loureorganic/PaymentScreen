package com.example.myapplication.presenter;

import com.example.myapplication.model.Pagamento;
import com.example.myapplication.model.PaymentModel;
import com.example.myapplication.view.PaymentView;

public class PaymentPresenter {
    private PaymentModel model;
    private PaymentView view;

    public PaymentPresenter(PaymentModel model, PaymentView view) {
        this.model = model;
        this.view = view;
    }

    public void initialize() {
        view.setDebitValue(model.getDebitValue());
        view.setPayValue(model.getPayValue());
        view.setRestValue(model.getRestValue());
        view.showPaymentsList(model.getPagamentos());
        view.setParcelsValue(model.getParcels());
        view.setReduceValue(model.getReduceValue());
    }

    public void onAddPaymentWayClicked() {
        view.showInputFields();
    }

    public void onCancelClicked() {
        view.hideInputFields();
    }

    public void onInsertPaymentClicked(String valueText, String paymentWay) {
        try {
            float valor = Float.parseFloat(valueText);
            Pagamento pagamento = new Pagamento(valor, paymentWay);
            model.addPagamento(pagamento);
            view.setPayValue(model.getPayValue());
            view.setReduceValue(model.getReduceValue());
            view.showPaymentsList(model.getPagamentos());
            view.setRestValue(model.getRestValue());
            view.hideInputFields();

        } catch (NumberFormatException e) {
        }
    }
}
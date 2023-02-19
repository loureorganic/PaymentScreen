package com.example.myapplication.model;

public class Pagamento {

    private float valor;
    private String formaPagamento;

    public Pagamento(float valor, String formaPagamento) {
        this.valor = valor;
        this.formaPagamento = formaPagamento;
    }

    public float getValor() {
        return valor;
    }

    public String getFormaPagamento() {
        return formaPagamento;
    }
}

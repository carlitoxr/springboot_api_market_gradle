package com.marketejemplo.market.domain;

import java.time.LocalDateTime;
import java.util.List;

public class Purchase {
    private int purchaseId; // private Integer idCompra;
    private String clientId; // private String idCliente;
    private LocalDateTime date; // private LocalDateTime fecha;
    private String paymentMethod; // private String medioPago;
    private String comment; // private String comentario;
    private String state; // private String estado;
    private List<PurchaseItem> items; // private List<ComprasProducto> productos;

    public int getPurchaseId() {
        return purchaseId;
    }

    public void setPurchaseId(int purchaseId) {
        this.purchaseId = purchaseId;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public List<PurchaseItem> getItems() {
        return items;
    }

    public void setItems(List<PurchaseItem> items) {
        this.items = items;
    }
}

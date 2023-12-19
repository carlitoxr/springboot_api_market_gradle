package com.marketejemplo.market.domain;

public class PurchaseItem {
    private int productId; // private ComprasProductoPK id;
    private int quantity; // private Integer cantidad;
    private double total; // private Double total;
    private boolean active; // private Boolean estado;

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

}

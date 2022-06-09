package com.example.server;

public class Inventory {

    private String inventoryId;
    private String quantity;
    private Drug drug;

    public Inventory(String inventoryId, String quantity, Drug drug) {
        this.inventoryId = inventoryId;
        this.quantity = quantity;
        this.drug = drug;
    }

    public String getInventoryId() {
        return inventoryId;
    }

    public void setInventoryId(String inventoryId) {
        this.inventoryId = inventoryId;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public Drug getDrug() {
        return drug;
    }

    public void setDrug(Drug drug) {
        this.drug = drug;
    }

    @Override
    public String toString() {
        return "Inventory{" +
                "inventoryId='" + inventoryId + '\'' +
                ", quantity='" + quantity + '\'' +
                ", drug=" + drug +
                '}';
    }

}

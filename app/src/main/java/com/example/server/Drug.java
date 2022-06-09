package com.example.server;

public class Drug {

    private String drugId;
    private String drugName;
    private String dosage;
    private String company;
    private Pharmacy pharmacy;

    public Drug(String drugId, String drugName, String dosage, String company, Pharmacy pharmacy) {
        this.drugId = drugId;
        this.drugName = drugName;
        this.dosage = dosage;
        this.company = company;
        this.pharmacy = pharmacy;
    }

    public String getDrugId() {
        return drugId;
    }

    public void setDrugId(String drugId) {
        this.drugId = drugId;
    }

    public String getDrugName() {
        return drugName;
    }

    public void setDrugName(String drugName) {
        this.drugName = drugName;
    }

    public String getDosage() {
        return dosage;
    }

    public void setDosage(String dosage) {
        this.dosage = dosage;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public Pharmacy getPharmacy() {
        return pharmacy;
    }

    public void setPharmacy(Pharmacy pharmacy) {
        this.pharmacy = pharmacy;
    }

    @Override
    public String toString() {
        return "Drug{" +
                "drugId='" + drugId + '\'' +
                ", drugName='" + drugName + '\'' +
                ", dosage='" + dosage + '\'' +
                ", company='" + company + '\'' +
                ", pharmacy=" + pharmacy +
                '}';
    }
}

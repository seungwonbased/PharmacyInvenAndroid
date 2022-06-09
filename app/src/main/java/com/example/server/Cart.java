package com.example.server;

public class Cart {

    private String cartId;
    private Member member;
    private Drug drug;

    public Cart(String cartId, Member member, Drug drug) {
        this.cartId = cartId;
        this.member = member;
        this.drug = drug;
    }

    public String getCartId() {
        return cartId;
    }

    public void setCartId(String cartId) {
        this.cartId = cartId;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public Drug getDrug() {
        return drug;
    }

    public void setDrug(Drug drug) {
        this.drug = drug;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "cartId='" + cartId + '\'' +
                ", member=" + member +
                ", drug=" + drug +
                '}';
    }

}

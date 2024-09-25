package ru.ssau.tk.sizar.ooplabs.Task4.myfirstpackage;

public class MySecondClass {
    private int biba;
    private int boba;

    public int getBiba() {
        return biba;
    }

    public int getBoba() {
        return boba;
    }

    public void setBiba(int biba) {
        this.biba = biba;
    }

    public void setBoba(int boba) {
        this.boba = boba;
    }

    public MySecondClass (int biba, int boba){
        this.biba = biba;
        this.boba = boba;
    }

    public int circularShiftLeft(){
        return biba << boba;
    }
}

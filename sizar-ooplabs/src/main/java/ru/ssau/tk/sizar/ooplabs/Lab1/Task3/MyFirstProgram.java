package ru.ssau.tk.sizar.ooplabs.Lab1.Task3;

class MyFirstClass {
    public static void main(String[] s) {
        MySecondClass o = new MySecondClass(42, 69);
        System.out.println(o.circularShiftLeft());
        for (int i = 1; i <= 8; i++) {
            for (int j = 1; j <= 8; j++) {
                o.setBiba(i);
                o.setBoba(j);
                System.out.print(o.circularShiftLeft());
                System.out.print(" ");
            }
            System.out.println();
        }

    }
}
class MySecondClass {
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

    MySecondClass (int biba, int boba){
        this.biba = biba;
        this.boba = boba;
    }

    public int circularShiftLeft(){
        return biba << boba;
    }
}

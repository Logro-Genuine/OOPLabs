package ru.ssau.tk.sizar.ooplabs.Task4;

import ru.ssau.tk.sizar.ooplabs.Task4.myfirstpackage.MySecondClass;

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


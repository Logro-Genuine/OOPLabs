package ru.ssau.tk.sizar.ooplabs.Lab2.functions;

import java.util.Arrays;

public class LinkedListTabulatedFunction extends AbstractTabulatedFunction implements Removable{
    protected int count;
    private Node head;
    @Override
    protected int floorIndexOfX(double x) {
        if (x <= head.x) {
            return 0;
        }
        if (x >= head.prev.x) {
            return count - 1;
        }
        Node current = head;
        int index = 0;
        while (current != head.prev && current.x <= x) {
            current = current.next;
            index++;
        }
        return index - 1;
    }

    @Override
    protected double extrapolateLeft(double x) {
        return interpolate(x, head.x, head.next.x, head.y, head.next.y);
    }

    @Override
    protected double extrapolateRight(double x) {
        double x1 = head.prev.prev.x;
        double x2 = head.prev.x;
        double y1 = head.prev.prev.y;
        double y2 = head.prev.y;
        return interpolate(x, head.prev.prev.x, head.prev.x, head.prev.prev.y, head.prev.y);
    }

    @Override
    protected double interpolate(double x, int floorIndex) {
        Node left = getNode(floorIndex);
        Node right = left.next;
        return interpolate(x, left.x, right.x, left.y, right.y);
    }

    @Override
    public int getCount() {
        return this.count;
    }

    @Override
    public double getX(int index) {
        return getNode(index).x;
    }

    @Override
    public double getY(int index) {
        return getNode(index).y;
    }

    @Override
    public void setY(int index, double value) {
        getNode(index).y = value;
    }

    @Override
    public int indexOfX(double x) {
        Node current = head;
        for (int i = 0; i<count; i++){
            if (current.x == x){
                return i;
            }
            current = current.next;
        }
        return -1;
    }

    @Override
    public int indexOfY(double y) {
        Node current = head;
        for (int i = 0; i<count; i++){
            if (current.y == y){
                return i;
            }
            current = current.next;
        }
        return -1;
    }

    @Override
    public double leftBound() {
        return this.head.x;
    }

    @Override
    public double rightBound() {
        return this.head.prev.x;
    }
    LinkedListTabulatedFunction(double[] xValues, double[] yValues) {
        double[] xValuesCopy = Arrays.copyOf(xValues, xValues.length);
        double[] yValuesCopy = Arrays.copyOf(yValues, yValues.length);
        for (int i = 0; i < xValuesCopy.length; i++) {
            addNode(xValuesCopy[i], yValuesCopy[i]);
        }
    }

    LinkedListTabulatedFunction(MathFunction source, double xFrom, double xTo, int count) {
        if (xFrom > xTo) {
            xFrom += xTo;
            xTo = xFrom-xTo;
            xFrom -= xTo; // 0, 5, 10
        }
        double step = (xTo - xFrom) / (count - 1);
        double x = xFrom;
        for (int i = 0; i < count; i++) {
            addNode(x, source.apply(x));
            x += step;
        }
    }

    @Override
    public void remove(int index) {
        if (count != 0){
            Node obj = getNode(index);
            if (index == 0) head = head.next;
            obj.prev.next = obj.next;
            obj.next.prev = obj.prev;
            obj = null;
            --count;
        }
    }

    static class Node {
        public Node next;
        public Node prev;
        public double x;
        public double y;

        public Node(double x, double y) {
            this.x = x;
            this.y = y;
        }
    }
    private void addNode(double x, double y){
        Node new_node = new Node(x, y);
        if (this.head == null){
            this.head = new_node;
            this.head.prev = this.head;
            this.head.next = this.head;
        } else {
            new_node.next = this.head;
            new_node.prev = this.head.prev;
            this.head.prev.next = new_node;
            this.head.prev = new_node;
        }
        ++count;
    }
    private Node getNode(int index) {
        Node current = head;
        if (index < count / 2) {
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
        }
        else {
            for (int i = count; i > index; i--) {
                current = current.prev;
            }
        }
        return current;
    }
}

package ru.ssau.tk.sizar.ooplabs.Lab2.functions;

import ru.ssau.tk.sizar.ooplabs.Lab2.exceptions.InterpolationException;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedListTabulatedFunction extends AbstractTabulatedFunction implements Insertable,Removable{
    protected int count;
    private Node head;
    public LinkedListTabulatedFunction(double[] xValues, double[] yValues) {
        double[] xValuesCopy = Arrays.copyOf(xValues, xValues.length);
        double[] yValuesCopy = Arrays.copyOf(yValues, yValues.length);
        checkLengthIsTheSame(xValuesCopy, yValuesCopy);
        if (xValuesCopy.length < 2){throw new IllegalArgumentException("Длина меньше минимальной!");}
        checkSorted(xValuesCopy);
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
    protected int floorIndexOfX(double x) {
        if (x < head.x) {
            throw new IllegalArgumentException("Значение меньше левой границы");
        }
        if (x == head.x){return 0;}
        if (x >= head.prev.x) {
            return count - 1;
        }
        Node current = head;
        int index = 0;
        while (current != head.prev && current.x <= x) {
            current = current.next;
            ++index;
        }
        return index - 1;
    }

    @Override
    protected double extrapolateLeft(double x) {
        return interpolate(x, head.x, head.next.x, head.y, head.next.y);
    }

    @Override
    protected double extrapolateRight(double x) {
        return interpolate(x, head.prev.prev.x, head.prev.x, head.prev.prev.y, head.prev.y);
    }

    @Override
    protected double interpolate(double x, int floorIndex) {
        Node left = getNode(floorIndex);
        Node right = left.next;
        if (x < left.x || x > right.x){throw new InterpolationException();}
        return interpolate(x, left.x, right.x, left.y, right.y);
    }

    @Override
    public int getCount() {
        return count;
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
    public void setX(int index, double value) {
        getNode(index).x = value;
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
        return head.x;
    }

    @Override
    public double rightBound() {
        return head.prev.x;
    }

    @Override
    public void insert(double x, double y) {
        if (head == null) {
            addNode(x, y);
            return;
        }
        Node cur = head;
        Node newNode = new Node(x,y);
        for (int i = 0; i < count; ++i){
            // уже есть такое значение х - меняем y
            if (cur.x == x){
                cur.y = y;
                return;
            }

            if (cur.x > x){
                if (cur == head){
                    newNode.next = head;
                    newNode.prev = head.prev;
                    head.prev.next = newNode;
                    head.prev = newNode;
                    head = newNode;
                }
                else {
                    newNode.prev = cur.prev;
                    newNode.next = cur;
                    cur.prev.next = newNode;
                    cur.prev = newNode;
                }
                ++count;
                return;
            }
            cur = cur.next;
        }
        // дошли до конца - значит х больше, чем все, добавляем в конец
        newNode.prev = cur.prev;
        newNode.next = cur;
        cur.prev.next = newNode;
        cur.prev = newNode;
        ++count;

    }

    @Override
    public void remove(int index) {
        if (count != 0){
            Node obj = getNode(index);
            if (index == 0) head = head.next;
            obj.prev.next = obj.next;
            obj.next.prev = obj.prev;
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
        if (head == null){
            head = new_node;
            head.prev = head;
            head.next = head;
        } else {
            new_node.next = head;
            new_node.prev = head.prev;
            head.prev.next = new_node;
            head.prev = new_node;
        }
        ++count;
    }

    @Override
    public Iterator<Point> iterator() {
        return new Iterator<Point>() {
            private Node node = head;

            @Override
            public boolean hasNext() {
                return node != null;
            }

            @Override
            public Point next() {
                if (!hasNext()) {
                    throw new NoSuchElementException("Нет больше элементов для итерации.");
                }
                Point point = new Point(node.x, node.y);
                if (node.next == head){
                    node = null;
                } else {
                    node = node.next;
                }
                return point;
            }
        };
    }

    private Node getNode(int index) {
        if ((index < 0)||(index>=count)) {
            throw new IllegalArgumentException("Некорректный индекс.");
        }
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

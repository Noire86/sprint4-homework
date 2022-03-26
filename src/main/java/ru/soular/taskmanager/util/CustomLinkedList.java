package ru.soular.taskmanager.util;

import java.util.ArrayList;
import java.util.List;

public class CustomLinkedList<T> {

    Node<T> first;
    Node<T> last;
    int size = 0;

    public Node<T> linkLast(T value) {
        Node<T> l = last;
        Node<T> newNode = new Node<>(null, l, value);

        last = newNode;

        if (l == null)
            first = newNode;
        else
            l.nextNode = newNode;
        size++;
        return newNode;
    }

    public List<T> getTasks() {
        List<T> result = new ArrayList<>();
        Node<T> pointer = first;

        while (pointer != null && size > 0) {
            result.add(pointer.value);
            pointer = pointer.nextNode;
        }

        return result;
    }

    public void removeNode(Node<T> node) {
        Node<T> next = node.nextNode;
        Node<T> prev = node.prevNode;

        if (prev == null) {
            first = next;
        } else {
            prev.nextNode = next;
            node.prevNode = null;
        }

        if (next == null) {
            last = prev;
        } else {
            next.prevNode = prev;
            node.nextNode = null;
        }

        node.value = null;
        size--;
    }

    public void clear() {
        Node<T> pointer = first;

        while (pointer != null) {
            Node<T> candidate = pointer;
            pointer = pointer.nextNode;
            candidate.value = null;
            candidate.nextNode = null;
            candidate.prevNode = null;
        }

        first = null;
        last = null;
        size = 0;
    }

    public static class Node<T> {
        Node<T> nextNode;
        Node<T> prevNode;
        T value;

        public Node(Node<T> nextNode, Node<T> prevNode, T value) {
            this.nextNode = nextNode;
            this.prevNode = prevNode;
            this.value = value;
        }
    }
}

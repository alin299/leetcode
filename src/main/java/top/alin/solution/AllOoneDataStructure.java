package top.alin.solution;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Node {
    int count;
    Node pre;
    Node next;
    Set<String> set;

    public Node(int count) {
        this.count = count;
        set = new HashSet<>();
    }

    public void append(Node node) {
        node.pre = this;
        node.next = this.next;
        this.next.pre = node;
        this.next = node;
    }

    public void insert(Node node) {
        node.next = this;
        node.pre = this.pre;
        this.pre.next = node;
        this.pre = node;
    }

    public void delete() {
        this.pre.next = this.next;
        this.next.pre = this.pre;
    }
}
public class AllOoneDataStructure {
    Map<String, Node> map;
    Node head, tail;
    public AllOoneDataStructure() {
        map = new HashMap<>();
        head = new Node(0);
        tail = new Node(100000);
        head.next = tail;
        tail.pre = head;
    }

    public void inc(String key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.set.remove(key);
            if (node.next.count == node.count + 1) {
                node.next.set.add(key);
                map.put(key, node.next);
            } else {
                Node nextNode = new Node(node.count + 1);
                nextNode.set.add(key);
                node.append(nextNode);
                map.put(key, nextNode);
            }
            if (node.set.isEmpty()) {
                node.delete();
            }
        } else {
            if (head.next.count == 1) {
                head.next.set.add(key);
                map.put(key, head.next);
            } else {
                Node nextNode = new Node(1);
                nextNode.set.add(key);
                head.append(nextNode);
                map.put(key, nextNode);
            }
        }
    }

    public void dec(String key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.set.remove(key);
            if (node.count == 1) {
                map.remove(key);
            } else {
                if (node.pre.count == node.count - 1) {
                    node.pre.set.add(key);
                    map.put(key, node.pre);
                } else {
                    Node nextNode = new Node(node.count - 1);
                    nextNode.set.add(key);
                    node.insert(nextNode);
                    map.put(key, nextNode);
                }
            }
            if (node.set.isEmpty()) {
                node.delete();
            }
        }
    }

    public String getMaxKey() {
        return tail.pre.set.isEmpty() ? "" : tail.pre.set.iterator().next();
    }

    public String getMinKey() {
        return head.next.set.isEmpty() ? "" : head.next.set.iterator().next();
    }
}

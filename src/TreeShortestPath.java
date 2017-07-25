/**
 * Created by oleggio on 7/11/17.
 */

import java.util.*;

class Node {
    LinkedList<Node> adjs;
    String name;
    int value;

    Node(String name) {
        this.name = name;
    }

    void setAdjs(LinkedList<Node> adjs) {
        this.adjs = adjs;
    }
}

public class TreeShortestPath {

    static LinkedList<Node> searchPath(Node home, Node destination) {

        HashMap<Node, LinkedList<Node>> paths = new HashMap<>();
        paths.put(home, new LinkedList<>(Arrays.asList(home)));
        paths.put(destination, new LinkedList<>(Arrays.asList(destination)));

        Queue<Node> searchQueue = new LinkedList<>(Arrays.asList(home, destination));

        Node current;
        LinkedList<Node> tempPath;

        LinkedList<Node> result;

        while (!searchQueue.isEmpty()) {
            current = searchQueue.poll();
            for(Node adj : current.adjs) {
                if(!paths.containsKey(adj)) {
                    tempPath = paths.get(current);
                    tempPath.add(adj);
                    paths.put(adj, tempPath);

                    searchQueue.add(adj);

                    for(Node e : tempPath) {
                        System.out.print(e.name);
                    }
                    System.out.println();
                }
                else if(paths.get(current).getFirst() != paths.get(adj).getFirst()) {
                    result = paths.get(current);
                    Iterator<Node> i = paths.get(adj).descendingIterator();
                    while (i.hasNext()) {
                        result.add(i.next());
                    }
                    return result;
                }
            }
        }
        return null;

    }


    public static void main(String[] args) {
        Node a = new Node("A");
        Node b = new Node("B");
        Node c = new Node("C");
        Node d = new Node("D");
        Node e = new Node("E");
        Node f = new Node("F");
        Node g = new Node("G");
        Node h = new Node("H");
        Node i = new Node("I");
        Node j = new Node("J");
        Node k = new Node("K");
        Node l = new Node("L");

        a.setAdjs(new LinkedList<Node>(Arrays.asList(b, c)));
        b.setAdjs(new LinkedList<Node>(Arrays.asList(a, d)));
        c.setAdjs(new LinkedList<Node>(Arrays.asList(a, b)));
        d.setAdjs(new LinkedList<Node>(Arrays.asList(b, h, g, e)));
        e.setAdjs(new LinkedList<Node>(Arrays.asList(d, j, f)));
        f.setAdjs(new LinkedList<Node>(Arrays.asList(e, k)));
        g.setAdjs(new LinkedList<Node>(Arrays.asList(d, e, k, i)));
        h.setAdjs(new LinkedList<Node>(Arrays.asList(d, g)));
        i.setAdjs(new LinkedList<Node>(Arrays.asList(g, l)));
        j.setAdjs(new LinkedList<Node>(Arrays.asList(k, l)));
        k.setAdjs(new LinkedList<Node>(Arrays.asList(f, g, j)));
        l.setAdjs(new LinkedList<Node>(Arrays.asList(i, j)));

        LinkedList<Node> result = searchPath(a, l);
        for(Node n : result) {
            System.out.print(n.name + " ");
        }

    }
}

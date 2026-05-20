class BrowserHistory {

    Node head;
    Node current;

    public BrowserHistory(String homepage) {
        head = new Node(homepage);
        current = head;
    }
    
    public void visit(String url) {
        Node node = new Node(url);
        current.next = node;
        node.prev = current;
        current = node;
    }
    
    public String back(int steps) {
        while(current.prev != null && steps > 0){
            current = current.prev;
            steps--;
        }
        return current.page;
    }
    
    public String forward(int steps) {
        
        while(current.next != null && steps > 0){
            current = current.next;
            steps--;
        }
        return current.page;
    }
}

class Node {

    Node next;
    Node prev;

    String page;

     Node(String page){
        this.page = page;
    }

}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */
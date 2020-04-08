public class LinkedListDeque<staff> {
    private class IntNode{
        public staff item;
        private IntNode prev;
        private IntNode next;

        public IntNode(IntNode p, staff x, IntNode q){
            item = x;
            prev = p;
            next = q;
        }
    }

    private int size;
    private IntNode sentinel;

    //invariants sentinel.next = first if is null, size = 0
    //last.next = sentinel
    //sentinel.prev = last item
    /**return a empty Deque*/
    public  LinkedListDeque(){
        sentinel = new IntNode(null,null,null);
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
        size = 0;
    }

    public void addFirst(staff x){
        size += 1;
        IntNode Prev_first = sentinel.next;
        IntNode Now_first = new IntNode(sentinel,x,Prev_first);
        Prev_first.prev = Now_first;
        sentinel.next = Now_first;
    }

    public void addLast(staff x){
        size += 1;
        IntNode Prev_Last = sentinel.prev;
        IntNode Now_last = new IntNode(Prev_Last, x, sentinel);
        Prev_Last.next = Now_last;
        sentinel.prev = Now_last;
    }

    public boolean isEmpty(){
        return (size == 0);
    }

    public void printDeque(){
        IntNode L = sentinel.next;
        while(L != sentinel){
            System.out.print(L.item);
            System.out.print(" ");
            L = L.next;
        }
        System.out.println();
    }

    public staff removeFirst(){
        if (size == 0){
            return null;
        }
        size -= 1;
        IntNode prev_First = sentinel.next;
        IntNode Now_First = prev_First.next;
        sentinel.next = Now_First;
        Now_First.prev = sentinel;
        prev_First.next = null;
        prev_First.prev = null;
        return prev_First.item;
    }

    public staff removeLast(){
        if (size == 0){
            return null;
        }
        size -= 1;
        IntNode prev_Last = sentinel.prev;
        IntNode Now_last = prev_Last.prev;
        sentinel.prev = Now_last;
        Now_last.next = sentinel;
        prev_Last.prev = null;
        prev_Last.next = null;
        return prev_Last.item;
    }

    public staff get(int index){
        if (index > size - 1){
            return null;
        }
        IntNode L = sentinel.next;
        while (index > 0){
            L = L.next;
            index -= 1;
        }
        return  L.item;
    }

    public LinkedListDeque(LinkedListDeque other){
        sentinel = new IntNode(null,null,null);
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
        size = 0;

        for (int i = 0; i< other.size; i++){
            addLast((staff) other.get(i));
        }
    }

    public static void main(String[] args) {
        LinkedListDeque<String> X = new LinkedListDeque<>();
        String m = "Sdasdada";
        X.addLast("I haa");
        X.addLast(m);
        X.get(1);
        LinkedListDeque Y = new LinkedListDeque(X);
    }
}

package definition;

import adt.LinkedListADTInterface;

import java.util.Iterator;

public class LinkedListDef<E> implements LinkedListADTInterface<E>, Iterable<E> {
    public int size = 0;
    private Node<definition.Person> head = null;


    private Node<definition.Person> getNode(int index) {
        Node<definition.Person> response = head;

        for (int i = 0; i < index; i++) {
            response = response.getNext();
        }
        return response;
    }


    private void addFirst(definition.Person item) {
        head = new Node<definition.Person>(item, head);
        size++;
    }

    private void addAfter(Node<definition.Person> node, definition.Person item) {
        node.next = new Node<>(item, node.next);
        size++;
    }

    public void add(int index, definition.Person item) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException(Integer.toString(index));
        } else if (index == 0) {
            addFirst(item);
        } else {
            Node<definition.Person> temp = getNode(index - 1);
            addAfter(temp, item);
        }
    }


    @Override
    public void add(definition.Person item) {
        add(size, item);
    }


    private definition.Person removeFirst() {
        definition.Person response = null;
        Node<definition.Person> temp = head;
        if (head != null) {
            head = head.getNext();
        }
        if (temp != null) {
            size--;
            response = temp.getData();
        }
        return response;
    }

    private definition.Person removeAfter(Node<definition.Person> node) {
        definition.Person response = null;
        Node<definition.Person> temp = node.getNext();
        if (temp != null) {
            node.next = temp.getNext();
            size--;
            response = temp.getData();
        }
        return response;
    }


    public definition.Person remove(int index) {
        definition.Person response = null;

        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException(Integer.toString(index));
        } else if (index == 0) {
            response = removeFirst();
        } else {
            Node<definition.Person> previousNode = getNode(index - 1);
            response = removeAfter(previousNode);
        }
        return response;
    }

    @Override
    public void remove() {
        remove(size);
    }

    public void remove(definition.Person ob) {
        int ind = search(ob);
        remove(ind);
    }

    private int getindex(Node<definition.Person> node) {
        int index = 0;
        Node<definition.Person> nod = head;
        for (int i = 0; i < size; i++) {
            if (node.getData() == nod.getData()) {
                break;
            } else {
                nod = nod.getNext();
                index++;
            }
        }
        return index;
    }



    @Override
    public int search(definition.Person item) {
        int response = -1;

        for (int i = 0; i < size; i++) {

            definition.Person data = this.getNode(i).getData();

            if (item.equals(data)) {
                response = i;
                break;
            }
        }
        return response;
    }

    @Override
    public void print() {
        System.out.print("[");
        for (int i = 0; i < size; i++) {
            // fetch the data for the current node
            definition.Person data = this.getNode(i).getData();
            System.out.print(data + (i < size - 1 ? ", " : ""));
        }
        System.out.println("]");
    }

    private void swap(Node<E> firstNode, Node<E> secondNode) {
        Node<E> temp = firstNode;
        firstNode = secondNode;
        secondNode = temp;
    }


    public LinkedListDef<definition.Person> sort(LinkedListDef<definition.Person> list) {
        Node<definition.Person> current = head;
        Node<definition.Person> index = null;
        int status;
        if (head == null) {
            return list;
        } else {
            while (current != null) {
                index = current.next;
                while (index != null) {

                    status = current.data.getFirst_Name().compareToIgnoreCase(index.data.getFirst_Name());

                    if (status > 0) {
                        definition.Person temp = current.data;
                        current.data = index.data;
                        index.data = temp;
                        index = index.next;

                    } else {

                        index = index.next;
                    }


                }
                current = current.next;
            }
        }
        return list;
    }

    @Override
    public Iterator<E> iterator() {
        return new java.util.Iterator<E>() {
            private LinkedListDef.Node<definition.Person> trav = head;

            @Override
            public boolean hasNext() {
                return trav != null;
            }

            @Override
            public E next() {
                E data = (E) trav.data;
                trav = trav.next;
                return data;
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }


    private static class Node<E> {
        private E data;
        private Node<E> next;

        private Node(E data) {
            this.data = data;
        }

        private Node(E data, Node<E> next) {
            this.data = data;
            this.next = next;
        }

        private E getData() {

            return data;
        }

        private Node<E> getNext() {
            return next;
        }
    }
}

package adt;

import definition.Person;

public interface LinkedListADTInterface<E> {
    void add(Person item);


    int search(Person item);


    void print();

    void remove();
}

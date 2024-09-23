package com.example.demo.Entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class ArrayEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ElementCollection
    @CollectionTable(name = "numbers", joinColumns =
    @JoinColumn(name = "array_id"))
    @Column(name = "number")
    private List<Integer> numbers;

    public ArrayEntity(){

    }
    public ArrayEntity(List<Integer> numbers){
        this.numbers = numbers;
    }

    public long getId() {
        return id;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public void setNumbers(List<Integer> numbers) {
        this.numbers = numbers;
    }
}

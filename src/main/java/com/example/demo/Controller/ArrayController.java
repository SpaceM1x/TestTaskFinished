package com.example.demo.Controller;

import com.example.demo.Service.SortService;
import com.example.demo.Entity.ArrayEntity;
import com.example.demo.Repository.ArrayRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/start")
public class ArrayController {
    @Autowired
    private ArrayRep arrayRep;
    @Autowired
    private SortService sortService;

    @PostMapping("/save")
    public String save(@RequestBody List<Integer> numbers) {
        List<Integer> Sorted = sortService.bubbleSort(numbers);
        ArrayEntity arrayEntity = new ArrayEntity(Sorted);
        arrayRep.save(arrayEntity);
        return "success";
    }

    @GetMapping("/get-result")
    public List<Integer> getSortedNumbers() {
        ArrayEntity arrayEntity = arrayRep.findAll().get(1);
        List<Integer> numbers = arrayEntity.getNumbers();
        arrayEntity.setNumbers(numbers);
        arrayRep.save(arrayEntity);
        return numbers;
    }

    @GetMapping("/get-result/{id}")
    public List<Integer> getSortedNumbersByID(@PathVariable Long id) {
        return arrayRep.findById(id)
                .map(ArrayEntity::getNumbers)
                .orElseThrow(() -> new IllegalArgumentException("Не найдено элемента с ID: " + id));
    }

}


package org.assignment.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(path = "/sort")
public class Controller {
    private static final String delim = ",";

    @GetMapping
    public String sort(String numbers) {
        String[] number = numbers.split(delim);
        List<String> sorting = Arrays.asList(number);
        sorting.sort((s1, s2) -> {
            float diff = Float.parseFloat(s1) - Float.parseFloat(s2);
            if (diff == 0) {
                return 0;
            }
            return diff < 0 ? -1 : 1;
        });

        return String.join(delim, sorting);
    }
}

package com.example.history;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HistoryController {
    private HistoryMapper historyMapper;
    public HistoryController(HistoryMapper historyMapper){
        this.historyMapper = historyMapper;
    }
    @GetMapping("/history")
    public List<History> findByYears(@RequestParam(required = false) String areastartsWith, @RequestParam(required = false) String yearendsWith) {
        if (areastartsWith != null && yearendsWith != null) {
            return historyMapper.findByStartingAndEnding(areastartsWith, yearendsWith);
        }
        else if (areastartsWith != null) {
            return historyMapper.findByAreaStartingWith(areastartsWith);
        }
        else if (yearendsWith != null) {
            return historyMapper.findByYearEndingWith(yearendsWith);
        }
        else {
            return historyMapper.findAll();
        }
    }
}

package com.example.history;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HistoryController {
    private HistoryService historyService;
    public HistoryController(HistoryService historyService){
        this.historyService = historyService;
    }

    @GetMapping("/histories")
    public List<History> findByYears(@RequestParam(required = false) String areaStartsWith, @RequestParam(required = false) String yearEndsWith) {
        return historyService.findByYearAndArea(areaStartsWith, yearEndsWith);
    }

    @GetMapping("/histories/{id}")
    public History findHistory(@PathVariable("id") int id){
        return historyService.findHistory(id);
    }
}

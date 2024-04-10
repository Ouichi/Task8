package com.example.history;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.Map;

@RestController
public class HistoryController {
    private HistoryService historyService;
    public HistoryController(HistoryService historyService){
        this.historyService = historyService;
    }
    @GetMapping("/histories")
    public List<History> findByYears(@RequestParam(required = false) String areaStartsWith, @RequestParam(required = false) String yearEndsWith) {
        if (areaStartsWith != null && yearEndsWith != null) {
            return historyService.findByStartingAndEnding(areaStartsWith, yearEndsWith);
        }
        else if (areaStartsWith != null) {
            return historyService.findByAreaStartingWith(areaStartsWith);
        }
        else if (yearEndsWith != null) {
            return historyService.findByYearEndingWith(yearEndsWith);
        }
        else {
            return historyService.findAll();
        }
    }

    @GetMapping("/histories/{id}")
    public History findHistory(@PathVariable("id") int id){
        return historyService.findHistory(id);
    }

    @ExceptionHandler(HistoryNotFoundException.class)
    public ResponseEntity<Map<String,String>> handleHistoryNotFoundException(
            HistoryNotFoundException e, HttpServletRequest request) {
        Map<String, String> body = Map.of(
                "timestamp", ZonedDateTime.now().toString(),
                "status", String.valueOf(HttpStatus.NOT_FOUND.value()),
                "error", HttpStatus.NOT_FOUND.getReasonPhrase(),
                "message", e.getMessage(),
                "path", request.getRequestURI());
        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
    }
}

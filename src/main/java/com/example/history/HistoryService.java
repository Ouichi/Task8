package com.example.history;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HistoryService {

    private HistoryMapper historyMapper;

    public HistoryService(HistoryMapper historyMapper){
        this.historyMapper=historyMapper;
    }

    public List<History> findByYearAndArea(String areaStartsWith, String yearEndsWith){
        if (areaStartsWith != null && yearEndsWith != null) {
            return historyMapper.findByYearAndArea(areaStartsWith, yearEndsWith);
        }
        else if (areaStartsWith != null) {
            return historyMapper.findByAreaStartingWith(areaStartsWith);
        }
        else if (yearEndsWith != null) {
            return historyMapper.findByYearEndingWith(yearEndsWith);
        }
        else {
            return historyMapper.findAll();
        }
    }

    public History findHistory(int id){
        return historyMapper.findById(id).orElseThrow(() -> new HistoryNotFoundException("History not found"));
//        Optional<History> history = historyMapper.findById(id);
//        if (history.isPresent()){
//            return history.get();
//        }
//        else{
//            throw new HistoryNotFoundException("History not found");
//        }
    }
}

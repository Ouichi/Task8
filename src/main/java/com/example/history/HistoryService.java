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

    public List<History>findByStartingAndEnding(String prefix, String suffix){
        return historyMapper.findByStartingAndEnding(prefix,suffix);
    }
    public List<History>findByAreaStartingWith(String prefix){
        return historyMapper.findByAreaStartingWith(prefix);
    }
    public List<History>findByYearEndingWith(String suffix){
        return historyMapper.findByYearEndingWith(suffix);
    }
    public List<History>findAll(){
        return historyMapper.findAll();
    }
    public History findHistory(int id){
//        return historyMapper.findById(id).orElseThrow(() -> new IllegalArgumentException("ID not found"));
        Optional<History> history = historyMapper.findById(id);
        if (history.isPresent()){
            return history.get();
        }
        else{
            throw new HistoryNotFoundException("History not found");
        }
    }
}

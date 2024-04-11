package com.example.history;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Optional;

@Mapper
public interface HistoryMapper {

    @Select("SELECT * FROM history")
    List<History> findAll();

    @Select("SELECT * FROM history WHERE area LIKE CONCAT(#{prefix}, '%')")
    List<History> findByAreaStartingWith(String prefix);

    @Select("SELECT * FROM history WHERE years LIKE CONCAT('%', #{suffix})")
    List<History> findByYearEndingWith(String suffix);

    @Select("SELECT * FROM history WHERE years LIKE CONCAT('%', #{suffix}) AND area LIKE CONCAT(#{prefix}, '%')")
    List<History> findByYearAndArea(String prefix, String suffix);

    @Select("SELECT * FROM history WHERE id = #{id}")
    Optional<History>findById(int id);
}

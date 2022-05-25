package by.it_academy.jd2.University.controllers;

import by.it_academy.jd2.University.dto.CrossDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;

import java.util.ArrayList;
import java.util.List;

public class Main {


    public static void main(String[] args) throws JsonProcessingException {

        ObjectMapper mapper = new ObjectMapper();
        mapper.setPropertyNamingStrategy(PropertyNamingStrategies.SNAKE_CASE);

        CrossDto dto = new CrossDto();
        dto.setGroupId(1);

        long masha = 1;
        long dasha = 2;
        long glasha = 3;

        List<Long> girls = new ArrayList<>();

        girls.add(masha);
        girls.add(dasha);
        girls.add(glasha);

        dto.setStudentId(girls);

        String json = mapper.writeValueAsString(dto);

        System.out.println(json);




    }

}

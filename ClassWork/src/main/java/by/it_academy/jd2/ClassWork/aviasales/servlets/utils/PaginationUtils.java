package by.it_academy.jd2.ClassWork.aviasales.servlets.utils;

import by.it_academy.jd2.ClassWork.aviasales.dao.Pageable;

public class PaginationUtils {

    public static long maxPageCount(long totalElements, Pageable pageable){

        return maxPageCount(totalElements, pageable.getSize());

    }

    public static long maxPageCount(long totalElements, int size){

        double result = (double) totalElements / size;
        return (long) Math.ceil(result);

    }

}

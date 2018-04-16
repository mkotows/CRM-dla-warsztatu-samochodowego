package app;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.time.*;
import java.util.ArrayList;
import java.util.List;

public class Application1 {

    public static void main(String[] args){

        List<Integer> lista = new ArrayList<>();
        lista.add(1);
        lista.add(2);
        lista.add(3);
        System.out.println(lista.get(2));
        Date date = null;
        LocalDate localDate= LocalDate.now();
//        LocalDate lc= Lo;
        System.out.println(localDate);
    }
}

package com.example.ghuyo9kli;

import java.util.ArrayList;
import java.util.List;

public class Manager {

    public static List<String> visited_places = new ArrayList<>();
    public static void addPlace(String place){
        if(!visited_places.contains(place)){
            visited_places.add(place);
        }
    }
    public static void removePlace(String place){
        if(visited_places.contains(place)){
            visited_places.remove(place);
        }
    }


}

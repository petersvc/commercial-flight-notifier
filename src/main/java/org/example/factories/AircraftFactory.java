package org.example.factories;

import org.example.models.Aircraft;

import java.util.ArrayList;
import java.util.List;

public class AircraftFactory {

    public List<Aircraft> create(String type, int HowManyToCreate){
        List<Aircraft> aircrafts = new ArrayList<>();
        String model = "";
        int capacity = 0;

        switch (type) {
            case "Boeing747":
                model = "Boeing747";
                capacity = 416;
                break;
            case "AirbusA380":
                model = "AirbusA380";
                capacity = 853;
                break;
            case "Boeing777":
                model = "Boeing777";
                capacity = 550;
                break;
            default:
                System.out.println("Invalid aircraft type");
                break;
        }

        for (int i = 0; i < HowManyToCreate; i++) {
            var id = (long) (Math.random() * 1000000);
            aircrafts.add(new Aircraft(id, model, capacity));
        }

        return aircrafts;
    }
}

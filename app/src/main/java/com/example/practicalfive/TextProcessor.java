package com.example.practicalfive;

public class TextProcessor {
    public String processMunicipality(String municipality) {
        if (municipality == null || municipality.trim().isEmpty()) {
            return null;
        }
        String clean = municipality.trim().toLowerCase();
        switch (clean) {
            case "beijing":
                return "Beijing";
            case "shanghai":
                return "Shanghai";
            case "tianjin":
                return "Tianjin";
            case "chongqing":
                return "Chongqing";
            default:
                return null;
        }
    }
}

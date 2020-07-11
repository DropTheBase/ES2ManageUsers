package com;
import Exception.*;
import java.time.Year;


public class Resource {
    private int id ;
    private String name;
    private int year;
    private String color;
    private String pantone_value;


    public Resource(Integer id, String name, Integer year, String color, String pantone_value) {
        this.id = id;
        this.name = name;
        this.year = year;
        this.color = color;
        this.pantone_value = pantone_value;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) throws NoException, InvalidException {
        if (id == null){
            throw new NoException();
        }
        else if (id < 0){
            throw new InvalidException();
        }
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) throws NoException, InvalidException {
        if (name == null){
            throw new NoException();
        }
        else if (!name.matches("^[a-zA-Z]{1,30}$") || name.length() < 1){
            throw new InvalidException();
        }
        this.name = name;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) throws NoException, InvalidException {
        if (year == null){
            throw new NoException();
        }
        else if (!year.toString().matches("^[0-9]{4}$") || year > Year.now().getValue() || year > 2020){
            throw new InvalidException();
        }

        this.year = year;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) throws NoException, InvalidException {
        if (color == null){
            throw new NoException();
        }
        else if (!color.matches("^#([A-Fa-f0-9]{6}|[A-Fa-f0-9]{3})$") || color.length() < 6){
            throw new InvalidException();
        }
        this.color = color;
    }

    public String getPantone_value() {
        return pantone_value;
    }

    public void setPantone_value(String pantone_value) throws NoException, InvalidException {
        if (pantone_value == null){
            throw new NoException();
        }
        else if (!pantone_value.matches("^([A-Fa-f0-9]{2})-([A-Fa-f0-9]{4})$") || pantone_value.length() < 6){
            throw new InvalidException();
        }
        this.pantone_value = pantone_value;
    }
}
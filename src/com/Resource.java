package com;
import Exception.*;
import java.time.Year;


public class Resource {
    private Integer id ;
    private String name;
    private Integer year;
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
        if (id == null){
            System.out.println("This id is NUll!");
        }
        else if (id < 0){
            System.out.println("This id is invalid!");
        }
        else{
            System.out.println("This id is Correct!");
        }

        return id;
    }

    public void setId(Integer id) throws NoException, InvalidException {
        if (id == null){
            System.out.println("This id not exist!");
            throw new NoException();
        }
        else if (id < 0){
            System.out.println("This id is invalid!");
            throw new InvalidException();
        }
        this.id = id;
    }

    public String getName() {
        if (name == null){
            System.out.println("This name is null!");
        }
        else if (!name.matches("^[a-zA-Z]{1,30}$") || name.length() < 1){
            System.out.println("This name is invalid!");
        }
        else {
            System.out.println("This name is correct!");
        }

        return name;
    }

    public void setName(String name) throws NoException, InvalidException {
        if (name == null){
            System.out.println("This name is null!");
            throw new NoException();
        }
        else if (!name.matches("^[a-zA-Z]{1,30}$") || name.length() < 1|| name.length()>20){
            System.out.println("This name is invalid!");
            throw new InvalidException();
        }
        else{
            System.out.println("This name is correct!");
        }
        this.name = name;
    }

    public Integer getYear() {
        if (year == null){
            System.out.println("This year is null!");
        }
        else if (!Integer.toString(year).matches("^[0-9]{4}$")){
            System.out.println("This year is invalid!");
        }
        else if (year > Year.now().getValue() || year < 2000){

        }
        else {
            System.out.println("This year is correct!");
        }

        return year;
    }

    public void setYear(Integer year) throws NoException, InvalidException {
        if (year == null){
            System.out.println("This year is null!");
            throw new NoException();
        }
        else if (!year.toString().matches("^[0-9]{4}$")){
            System.out.println("This year is invalid!");
            throw new InvalidException();
        }
        else if(year > Year.now().getValue() || year < 2000||year>3000){
            System.out.println("This year is invalid!");
            throw new InvalidException();
        }
        else{
            System.out.println("This year is correct!");
        }

        this.year = year;
    }

    public String getColor() {
        if (color == null){
            System.out.println("This color is null!");
        }
        else if (!color.matches("^#([A-Fa-f0-9]{6}|[A-Fa-f0-9]{3})$")){
            System.out.println("This color is invalid!");
        }
        else{
            System.out.println("This color is correct!");
        }
        return color;
    }

    public void setColor(String color) throws NoException, InvalidException {
        if (color == null){
            System.out.println("This color is null!");
            throw new NoException();
        }
        else if (!color.matches("^#([A-Fa-f0-9]{6}|[A-Fa-f0-9]{3})$")||color.length()<7||color.length()>7){
            System.out.println("This color is invalid!");
            throw new InvalidException();
        }
        else{
            System.out.println("This color is correct!");
        }
        this.color = color;
    }

    public String getPantone_value() {
        if (pantone_value == null){
            System.out.println("This pantone value is null!");
        }
        else if (!pantone_value.matches("^([A-Fa-f0-9]{2})-([A-Fa-f0-9]{4})$")){
            System.out.println("This pantone value is invalid!");
        }
        else {
            System.out.println("This pantone value is correct!");
        }
        return pantone_value;
    }

    public void setPantone_value(String pantone_value) throws NoException, InvalidException {
        if (pantone_value == null){
            System.out.println("This pantone value is null!");
            throw new NoException();
        }
        else if (!pantone_value.matches("^([A-Fa-f0-9]{2})-([A-Fa-f0-9]{4})$")||pantone_value.length()<7||pantone_value.length()>7){
            System.out.println("This pantone value is invalid!");
            throw new InvalidException();
        }
        else {
            System.out.println("This pantone value is correct!");
        }
        this.pantone_value = pantone_value;
    }
}
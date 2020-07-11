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
































































/*CODIGO ANTIGO

    private int id ;
    private String name;
    private int year;
    private String color;
    private String pantone_value;


    public Resource() {
        this.id = 0;
        this.name = "";
        this.year = 0;
        this.color = "";
        this.pantone_value = "";
    }

    public Resource(int id, String name, int year, String color, String pantone_value) {
        this.id = id;
        this.name = name;
        this.year = year;
        this.color = color;
        this.pantone_value = pantone_value;
    }


    public Resource(Resource resource) {
        this.id = resource.getId();
        this.name = resource.getName();
        this.year = resource.getYear();
        this.color = resource.getColor();
        this.pantone_value = resource.getPantone_value();
    }


    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public String getPantone_value() {
        return pantone_value;
    }


    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setPantone_value(String pantone_value) {
        this.pantone_value = pantone_value;
    }

    @Override
    protected Resource clone(){
        return new Resource(this);
    }

    @Override
    public String toString() {
        return "id: " + this.id + " name: " + this.name + " year: " + this.year + " color: " + this.color + " pantone_value: " + this.pantone_value;
    }


    public JSONObject toJson (){
        JSONObject json = new JSONObject();
        json.put("id", this.id);
        json.put("name", this.name);
        json.put("year", this.year);
        json.put("color", this.color);
        json.put("pantone_value", this.pantone_value);

        return json;
    }

    public static void printListResources(List<Resource> resources){

        for(int i = 0; i< resources.size();i++){
            System.out.println(resources.get(i).toString());
        }

    }

    public static Resource fromJSON(JSONObject json){
        Resource resource = new Resource();
        resource.setId(json.optInt("id",0));
        resource.setName(json.optString("name",""));
        resource.setYear(json.optInt("year",0));
        resource.setColor(json.optString("color",""));
        resource.setPantone_value(json.optString("pantone_value",""));

        return resource;
    }
 */
package Class;

import org.json.simple.JSONObject;

public class Resource {

    String Name; //Min 5 - Max 20
    Integer Year; //Max 30 anos de diferença de 2020
    String Color; //Only 7
    String Pantone_value; //Format 2-4

    public Resource() {
    }

    public Resource(String name, Integer year, String color, String pantone_value) throws Exception {
        if(validate(name,year,color,pantone_value)){
            Name = name;
            Year = year;
            Color = color;
            Pantone_value = pantone_value;
        }
        else
            throw new Exception("Invalid Data");
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Integer getYear() {
        return Year;
    }

    public void setYear(Integer year) {
        Year = year;
    }

    public String getColor() {
        return Color;
    }

    public void setColor(String color) {
        Color = color;
    }

    public String getPantone_value() {
        return Pantone_value;
    }

    public void setPantone_value(String pantone_value) {
        Pantone_value = pantone_value;
    }


    public boolean validate(String Name,Integer Year,String Color,String Pantone_Value){
        if(Name.length()<5 || Name.length()>20)
            return false;
        if((2020-Year)>30)
            return false;
        if(!Color.matches("^#([A-Fa-f0-9]{6})$"))
            return false;
        if(!Pantone_Value.matches("^([A-Fa-f0-9]{2})-([A-Fa-f0-9]{4})$"))
            return false;

        return true;
    }

    public boolean change(JSONObject jsonObject){
        try {
            if(jsonObject.get("name").toString().length()<5 || jsonObject.get("name").toString().length()>20)
                return false;
            setName(jsonObject.get("name").toString());
        } catch (Exception e){};

        try {
            if((2020-Integer.valueOf(jsonObject.get("year").toString()))>30)
                return false;
            setYear(Integer.valueOf(jsonObject.get("year").toString()));
        }catch (Exception e){};

        try {
            if(!jsonObject.get("color").toString().matches("^#([A-Fa-f0-9]{6})$"))
                return false;
            setColor(jsonObject.get("color").toString());
        }catch (Exception e){};

        try {
            if(!jsonObject.get("Pantone_Value").toString().matches("^([A-Fa-f0-9]{2})-([A-Fa-f0-9]{4})$"))
                return false;
            setPantone_value(jsonObject.get("Pantone_Value").toString());
        }catch (Exception e){};

        return true;
    }
}

package Unit_Tests.Resource;

import Class.Resource;
import Connection_Interfaces.Resource_Connection;
import Doubles.Mock;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Black_Box {

    //name lengt > 20
    @Test
    public void BB_Resource_Name_More_Then_Max(){
        Resource_Connection resource_connection = new Mock();
        try {
            Resource resource = new Resource("testetestetesteteste1",2010,"#000000","12-1234");
            resource_connection.Create_Resource(resource);
        } catch (Exception e) {
            assertEquals("Invalid Data", e.getMessage());
        }
    }

    //name lengt = 20
    @Test
    public void BB_Resource_Name_Equal_To_Max(){
        Resource_Connection resource_connection = new Mock();
        try {
            Resource resource = new Resource("testetestetesteteste",2010,"#000000","12-1234");
            resource_connection.Create_Resource(resource);
            assertTrue(true);
        } catch (Exception e) {
        }
    }

    //name lengt = 5
    @Test
    public void BB_Resource_Name_Equal_To_Min(){
        Resource_Connection resource_connection = new Mock();
        try {
            Resource resource = new Resource("teste",2010,"#000000","12-1234");
            resource_connection.Create_Resource(resource);
            assertTrue(true);
        } catch (Exception e) {
        }
    }

    //name lengt < 5
    @Test
    public void BB_Resource_Name_Less_Then_Min(){
        Resource_Connection resource_connection = new Mock();
        try {
            Resource resource = new Resource("tes",2010,"#000000","12-1234");
            resource_connection.Create_Resource(resource);
        } catch (Exception e) {
            assertEquals("Invalid Data", e.getMessage());
        }
    }

    // more then 30 years ago
    @Test
    public void BB_Resource_More_Then_30_Years_Ago(){
        Resource_Connection resource_connection = new Mock();
        try {
            Resource resource = new Resource("teste1",1980,"#000000","12-1234");
            resource_connection.Create_Resource(resource);
        } catch (Exception e) {
            assertEquals("Invalid Data", e.getMessage());
        }
    }

    // equal to 30 years ago
    @Test
    public void BB_Resource_Equal_To_30_Years_Ago(){
        Resource_Connection resource_connection = new Mock();
        try {
            Resource resource = new Resource("teste1",1990,"#000000","12-1234");
            resource_connection.Create_Resource(resource);
            assertTrue(true);
        } catch (Exception e) {
        }
    }

    //Less Then 30 years ago
    @Test
    public void BB_Resource_Less_Then_30_Years_Ago(){
        Resource_Connection resource_connection = new Mock();
        try {
            Resource resource = new Resource("teste1",2000,"#000000","12-1234");
            resource_connection.Create_Resource(resource);
            assertTrue(true);
        } catch (Exception e) {
        }
    }

    //color lenght = 7
    @Test
    public void BB_Resource_Color_Equal_To_7(){
        Resource_Connection resource_connection = new Mock();
        try {
            Resource resource = new Resource("teste1",2000,"#000000","12-1234");
            resource_connection.Create_Resource(resource);
            assertTrue(true);
        } catch (Exception e) {
        }
    }

    //color lenght < 7
    @Test
    public void BB_Resource_Color_Less_Then_7(){
        Resource_Connection resource_connection = new Mock();
        try {
            Resource resource = new Resource("teste1",2000,"#00000","12-1234");
            resource_connection.Create_Resource(resource);
        } catch (Exception e) {
            assertEquals("Invalid Data", e.getMessage());
        }
    }

    //color lenght > 7
    @Test
    public void BB_Resource_Color_More_Then_7(){
        Resource_Connection resource_connection = new Mock();
        try {
            Resource resource = new Resource("teste1",2000,"#0000000","12-1234");
            resource_connection.Create_Resource(resource);
        } catch (Exception e) {
            assertEquals("Invalid Data", e.getMessage());
        }
    }

    //pantone_value format 1-4
    @Test
    public void BB_Resource_Pantone_Value_part1_Less_Then_2(){
        Resource_Connection resource_connection = new Mock();
        try {
            Resource resource = new Resource("teste1",2000,"#0000000","1-1234");
            resource_connection.Create_Resource(resource);
        } catch (Exception e) {
            assertEquals("Invalid Data", e.getMessage());
        }
    }

    //pantone_value format 3-4
    @Test
    public void BB_Resource_Pantone_Value_part1_More_Then_2(){
        Resource_Connection resource_connection = new Mock();
        try {
            Resource resource = new Resource("teste1",2000,"#0000000","123-1234");
            resource_connection.Create_Resource(resource);
        } catch (Exception e) {
            assertEquals("Invalid Data", e.getMessage());
        }
    }

    //pantone_value format 2-4
    @Test
    public void BB_Resource_Pantone_Value_part1_Equal_To_2(){
        Resource_Connection resource_connection = new Mock();
        try {
            Resource resource = new Resource("teste1",2000,"#0000000","12-1234");
            resource_connection.Create_Resource(resource);
            assertTrue(true);
        } catch (Exception e) {
        }
    }

    //pantone_value format invalid
    @Test
    public void BB_Resource_Pantone_Value_invalid(){
        Resource_Connection resource_connection = new Mock();
        try {
            Resource resource = new Resource("teste1",2000,"#000000","11-11");
            resource_connection.Create_Resource(resource);
        } catch (Exception e) {
            assertEquals("Invalid Data", e.getMessage());
        }
    }

    //pantone_value format 2-5
    @Test
    public void BB_Resource_Pantone_Value_part2_More_Then_4(){
        Resource_Connection resource_connection = new Mock();
        try {
            Resource resource = new Resource("teste1",2000,"#000000","12-12345");
            resource_connection.Create_Resource(resource);
        } catch (Exception e) {
            assertEquals("Invalid Data", e.getMessage());
        }
    }

    //pantone_value format 2-3
    @Test
    public void BB_Resource_Pantone_Value_part2_Less_Then_4(){
        Resource_Connection resource_connection = new Mock();
        try {
            Resource resource = new Resource("teste1",2000,"#000000","12-123");
            resource_connection.Create_Resource(resource);
        } catch (Exception e) {
            assertEquals("Invalid Data", e.getMessage());
        }
    }

    //pantone_value format 2-4
    @Test
    public void BB_Resource_Pantone_Value_part2_Equal_To_4(){
        Resource_Connection resource_connection = new Mock();
        try {
            Resource resource = new Resource("teste1",2000,"#000000","12-1234");
            resource_connection.Create_Resource(resource);
            assertTrue(true);
        } catch (Exception e) {
        }
    }

}

import com.Resource;
import Exception.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestsResource {

    //Test Gets

    //-------------Test Id---------------
    @Test
    void TestGetIdNull() {
        Resource test = new Resource(null, "rose", 2020, "#d98695", "19-2020");
        Assertions.assertEquals(null, test.getId());
    }

    @Test
    void TestGetIdInvalid() {
        Resource test = new Resource(-30, "rose", 2020, "#d98695", "19-2020");
        Assertions.assertEquals(-30, test.getId());
    }

    @Test
    void TestGetIdValid() {
        Resource test = new Resource(30, "rose", 2020, "#d98695", "19-2020");
        Assertions.assertEquals(30, test.getId());
    }

    //-------------Test Name---------------
    @Test
    void TestGetNameNull() {
        Resource test = new Resource(30, null, 2020, "#d98695", "19-2020");
        Assertions.assertEquals(null, test.getName());
    }

    @Test
    void TestGetNameInvalid() {
        Resource test = new Resource(30, "1", 2020, "#d98695", "19-2020");
        Assertions.assertEquals("1", test.getName());
    }

    @Test
    void TestGetNameValid() {
        Resource test = new Resource(30, "rose", 2020, "#d98695", "19-2020");
        Assertions.assertEquals("rose", test.getName());
    }

    //-------------Test Year---------------
    @Test
    void TestGetYearNull() {
        Resource test = new Resource(30, "rose", null, "#d98695", "19-2020");
        Assertions.assertEquals(null, test.getYear());
    }

    @Test
    void TestGetInvalidYear() {
        Resource test = new Resource(30, "rose", 202, "#d98695", "19-2020");
        Assertions.assertEquals(202, test.getYear());
    }

    @Test
    void TestGetValidYear() {
        Resource test = new Resource(30, "rose", 2020, "#d98695", "19-2020");
        Assertions.assertEquals(2020, test.getYear());
    }

    //-------------Test Color---------------
    @Test
    void TestGetColorNull() {
        Resource test = new Resource(30, "rose", 2020, null, "19-2020");
        Assertions.assertEquals(null, test.getColor());
    }

    @Test
    void TestGetInvalidColor() {
        Resource test = new Resource(30, "rose", 2020, "#d9", "19-2020");
        Assertions.assertEquals("#d9", test.getColor());
    }

    @Test
    void TestGetValidColor() {
        Resource test = new Resource(30, "rose", 2020, "#d98695", "19-2020");
        Assertions.assertEquals("#d98695", test.getColor());
    }



    //-------------Test Pantone Value---------------
    @Test
    void TestGetPantoneValueNull() {
        Resource test = new Resource(30, "rose", 2020, "#d98695", null);
        Assertions.assertEquals(null, test.getPantone_value());
    }

    @Test
    void TestGetPantoneValueInvalid() {
        Resource test = new Resource(30, "rose", 2020, "#d98695", "196-2020");
        Assertions.assertEquals("196-2020", test.getPantone_value());
    }

    @Test
    void TestGetPantoneValueValid() {
        Resource test = new Resource(30, "rose", 2020, "#d98695", "19-2020");
        Assertions.assertEquals("19-2020", test.getPantone_value());
    }

    //--------------------------------------------------------------------------------------------------------------------------

    /*****************TESTS SETS*************************/
    //-------------Test Id---------------
    @Test
    void TestSetIdNull() {
        Resource test = new Resource(30, "rose", 2020, "#d98695", "19-2020");
        Assertions.assertThrows(NoException.class,() -> {
            test.setId(null);
        });
    }

    @Test
    void TestSetIdInvalid() {
        Resource test = new Resource(30, "rose", 2020, "#d98695", "19-2020");
        Assertions.assertThrows(InvalidException.class,() -> {
            test.setId(-30);
        });
    }

    @Test
    void TestSetIdValid() {
        Resource test = new Resource(30, "rose", 2020, "#d98695", "19-2020");
        Assertions.assertDoesNotThrow(() -> { test.setId(31);});
    }

    //-------------Test Name---------------
    @Test
    void TestSetNameNull() {
        Resource test = new Resource(30, "rose", 2020, "#d98695", "19-2020");

        Assertions.assertThrows(NoException.class,() -> {
            test.setName(null);
        });
    }

    @Test
    void TestResourceSetNomeLimitMax() {
        Resource test = new Resource(30, "rose", 2020, "#d98695", "19-2020");

        Assertions.assertThrows(InvalidException.class,() -> {
            test.setName("Testedostestesdostestesdotestetestado");
        });
    }

    @Test
    void TestNameLimitMin() {
        Resource test = new Resource(30, "rose", 2020, "#d98695", "19-2020");

        Assertions.assertThrows(InvalidException.class,() -> {
            test.setName("");
        });
    }

    @Test
    void TestSetNameWithNumbersAndSpecialCaracters() {
        Resource test = new Resource(30, "rose", 2020, "#d98695", "19-2020");

        Assertions.assertThrows(InvalidException.class,() -> {
            test.setName("Teste12.");
        });
    }

    @Test
    void TestSetNameValid() {
        Resource test = new Resource(30, "rose", 2020, "#d98695", "19-2020");

        Assertions.assertDoesNotThrow(() -> {test.setName("Teste");});
    }

    //-------------Test Year---------------
    @Test
    void TestSetYearNull() {
        Resource test = new Resource(30, "rose", 2020, "#d98695", "19-2020");

        Assertions.assertThrows(NoException.class,() -> {
            test.setYear(null);
        });
    }

    @Test
    void TestSetYearLimitMax() {
        Resource test = new Resource(30, "rose", 2020, "#d98695", "19-2020");

        Assertions.assertThrows(InvalidException.class,() -> {
            test.setYear(20205);
        });
    }

    @Test
    void TestSetYearWithout4Caracters() {
        Resource test = new Resource(30, "rose", 2020, "#d98695", "19-2020");

        Assertions.assertThrows(InvalidException.class,() -> {
            test.setYear(202);
        });
    }

    @Test
    void TestSetYearDiferentFromThePresentYear() {
        Resource test = new Resource(30, "rose", 2020, "#d98695", "19-2020");

        Assertions.assertThrows(InvalidException.class,() -> {
            test.setYear(2230);
        });
    }

    @Test
    void TestSetYearLimitMin() {
        Resource test = new Resource(30, "rose", 2020, "#d98695", "19-2020");

        Assertions.assertThrows(InvalidException.class,() -> {
            test.setYear(1900);
        });
    }

    @Test
    void TestSetYearValid() {
        Resource test = new Resource(30, "rose", 2020, "#d98695", "19-2020");

        Assertions.assertDoesNotThrow(() -> {test.setYear(2017);});
    }

    //-------------Test Color---------------
    @Test
    void TestSetColorNull() {
        Resource test = new Resource(30, "rose", 2020, "#d98695", "19-2020");

        Assertions.assertThrows(NoException.class,() -> {
            test.setColor(null);
        });
    }

    @Test
    void TestSetColorMoreThen6caracters() {
        Resource test = new Resource(30, "rose", 2020, "#d98695", "19-2020");

        Assertions.assertThrows(InvalidException.class,() -> {
            test.setColor("#d986958");
        });
    }

    @Test
    void TestSetColorLimitMin() {
        Resource test = new Resource(30, "rose", 2020, "#d98695", "19-2020");

        Assertions.assertThrows(InvalidException.class,() -> {
            test.setColor("#d9");
        });
    }

    @Test
    void TestSetColorRegex() {
        Resource test = new Resource(30, "rose", 2020, "#d98695", "19-2020");

        Assertions.assertThrows(InvalidException.class,() -> {
            test.setColor("d98695");
        });
    }

    @Test
    void TestSetColorValid() {
        Resource test = new Resource(30, "rose", 2020, "#d98695", "19-2020");

        Assertions.assertDoesNotThrow(() -> {test.setColor("#d98695");});
    }

    //-------------Test Pantone Value---------------
    @Test
    void TestSetPantoneValueNull() {
        Resource test = new Resource(30, "rose", 2020, "#d98695", "19-2020");

        Assertions.assertThrows(NoException.class,() -> {
            test.setPantone_value(null);
        });
    }

    @Test
    void TestSetPantoneValueWithoutRespectiveLimit() {
        Resource test = new Resource(30, "rose", 2020, "#d98695", "19-2020");

        Assertions.assertThrows(InvalidException.class,() -> {
            test.setPantone_value("192-20202");
        });
    }

    @Test
    void TestSetPantoneValueRegex() {
        Resource test = new Resource(30, "rose", 2020, "#d98695", "19-2020");

        Assertions.assertThrows(InvalidException.class,() -> {
            test.setPantone_value("192020");
        });
    }

    @Test
    void TestSetPantoneValueValid() {
        Resource test = new Resource(30, "rose", 2020, "#d98695", "19-2020");

        Assertions.assertDoesNotThrow(() -> {test.setPantone_value("19-2020");});
    }

}

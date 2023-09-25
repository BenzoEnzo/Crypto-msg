package pl.benzo.enzo.cryptomsg.util;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UtilTests {
    @Test
    public void timeConverterTest(){

        final LocalDateTime localDateTime = LocalDateTime.of(2023, 9, 25, 15, 30);
        int minutesToAdd = 42;

        final LocalDateTime afterAdded = TimeConverter.addMinutes(localDateTime,minutesToAdd);

        final LocalDateTime expectedResult = LocalDateTime.of(2023, 9, 25, 16, 12);
        assertEquals(expectedResult, afterAdded);
    }
}

package pl.benzo.enzo.cryptomsg.util;
import java.time.LocalDateTime;

public final class TimeConverter {
    public static LocalDateTime addMinutes(LocalDateTime settDate, int minutes){
        return settDate.plusMinutes(minutes);
    }
}

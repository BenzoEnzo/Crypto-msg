package pl.benzo.enzo.cryptomsg.external.dto;

public class KeyDto {
    public boolean isCorrect() {
        return isCorrect;
    }

    public String getVal(){
        return val;
    }

    private boolean isCorrect;
    private String val;

    public void setVal(String val) {
        this.val = val;
    }
}

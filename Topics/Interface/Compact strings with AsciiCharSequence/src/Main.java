import java.lang.reflect.Array;
import java.nio.charset.StandardCharsets;
import java.util.*;

class AsciiCharSequence implements java.lang.CharSequence {
    private byte[] byteArray;

    AsciiCharSequence(byte[] byteArray){
        this.byteArray = byteArray;
    }

    @Override
    public int length() {
        return byteArray.length;
    }

    @Override
    public char charAt(int index) {
        return (char)byteArray[index];
    }

    @Override
    public CharSequence subSequence(int start, int end) {
        return new AsciiCharSequence(Arrays.copyOfRange(byteArray, start, end));
    }

    public String toString(){

        return new String(byteArray, StandardCharsets.UTF_8);
    }
}
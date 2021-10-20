public class MyArraySizeException extends Exception {
    private int errorSize;
    public MyArraySizeException(String message, int errorSize) {
        super(message);
        this.errorSize = errorSize;
    }

    @Override
    public String toString() {
        return getMessage() + ". Массив не 4х4";
    }
}
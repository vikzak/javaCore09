public class MyArrayDataException extends NumberFormatException{
    public MyArrayDataException (String message){
        super(message);
    }
    @Override
    public String toString() {
        return "Ошибка:\n" +getMessage();
    }
}

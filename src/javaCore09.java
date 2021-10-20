import java.util.Arrays;
/*
1) Напишите метод, на вход которого подаётся двумерный строковый массив размером 4х4. При подаче массива другого
размера необходимо бросить исключение MyArraySizeException.
2) Далее метод должен пройтись по всем элементам массива, преобразовать в int и просуммировать. Если в каком-то элементе
массива преобразование не удалось (например, в ячейке лежит символ или текст вместо числа), должно быть брошено
исключение MyArrayDataException с детализацией, в какой именно ячейке лежат неверные данные.
3) В методе main() вызвать полученный метод, обработать возможные исключения MyArraySizeException и MyArrayDataException
и вывести результат расчета.
*/
public class javaCore09 {
    public static void main(String[] args) throws MyArraySizeException {
        String[][] arrayString = getArrayString(); // заполняем массив
        printArray(); // печатаем массив для наглядности
        checkArraySize(arrayString); // проверяем размер массива
        System.out.printf("Сумма элементов массива:%s\n",String.valueOf(summArrayString(arrayString))); // выводим сумму элементов
    }

    // Массив с символом внутри
    private static String[][] getArrayString(){
        return new String[][]{
                new String[]{"78", "65", "12", "12"},
                new String[]{"89", "45", "65", "27"},
                new String[]{"78", "65", "23", "12"},
                new String[]{"89", "45", "йq", "98"},
        };
    }
    // Массив для проверки вызова исключения размера массива
    // нужно раскомментировать этот метод и закомментировать тот, что выше
/*
    private static String[][] getArrayString(){
        return new String[][]{
                new String[]{"78", "65", "12", "12", "23"},
                new String[]{"89", "45", "65", "12", "27"},
                new String[]{"78", "65", "23", "12", "12"},
                new String[]{"89", "45", "йq", "12", "98"},
        };
    }
*/

    private static void printArray(){ // Печать массива
        System.out.println("Массив:");
        System.out.println(Arrays.deepToString(getArrayString()));
    }

    private static int summArrayString (String[][] myArray){ // подсчет суммы
        int sumArray = 0;
        int i = 0; // переменные для указания где произошло прерывание подсчета суммы
        int j = 0;
        try {
            for (i = 0; i < myArray.length; i++){
                for (j = 0; j < myArray.length; j++)
                    sumArray += Integer.parseInt(myArray[i][j]);
            }
            // если бы не нужно было знать детально где произошла ошибка
            // написать можно было бы так:
            //for (String[] strings : myArray)
            //    for(String string: strings)
            //        sumArray+=(int) Integer.parseInt(string);
        } catch (NumberFormatException e){
            System.out.println("Ошибка: " + e);
            System.out.printf("на строке i=%s в столбце j=%s, сумма элементов до ошибки:%s\n",i,j,sumArray);
            throw new MyArrayDataException("Ошибка: String to int (в массиве оказалось не число)");
        }
        return sumArray; // если нет ошибок возвращаем сумму
    }

    // проверка размера массива
    private static void checkArraySize(String[][] myArray) throws MyArraySizeException {
        if (myArray.length != 4) {
            throw new MyArraySizeException("Ошибка размера массива", myArray.length);
        }
        for (String[] innerMyArray : myArray) {
            if (innerMyArray.length != 4) {
                throw new MyArraySizeException("Ошибка размера массива", innerMyArray.length);
            }
        }
    }
}

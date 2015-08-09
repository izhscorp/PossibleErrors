package ru.alljoint.pe.arrays;

/**
 * 
 * @author Алексей Курган
 * Попытка создания массива отрицательного размера
 *
 */

public class NegativeArraySize {

	public static void main(String[] args) {
		/**
		 * Классическая попытка создания массива отрицательного размера
		 */
		try {
			@SuppressWarnings("unused")
			byte[] buf1 = new byte[-1];
		} catch (Exception e) {
			e.printStackTrace();
		}
		/**
		 * Так как размер массива в Java задается типом int, то данная попытка
		 * создания массива так же приведет к исключению, так как максимальное
		 * положительное значение типа int равно 2147483647, а указанное число
		 * явно превышает это значение, и при "преобразовании" полученного числа
		 * к int получаем отрицательное число
		 */
		try {
			@SuppressWarnings("unused")
			byte[] buf2 = new byte[2*1024*1024*1024];
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

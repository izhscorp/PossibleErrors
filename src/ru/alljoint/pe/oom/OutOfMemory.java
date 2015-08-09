package ru.alljoint.pe.oom;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * 
 * @author Алексей Курган
 * Нехватка памяти (out of memory) в виртуальной машине Java
 *
 */

public class OutOfMemory {

	public static void main(String[] args) {
		/**
		 * Попытка выделить массив в куче, по размеру превышающий максимальные возможности
		 * виртуальной машины Java по выделению оперативной памяти
		 */
		try {
			@SuppressWarnings("unused")
			byte[] buf = new byte[Integer.MAX_VALUE];
		} catch (Throwable e) {
			e.printStackTrace();
		}
		
		/**
		 * Попытка выделить массив в куче, когда возможности виртуальной машины Java по выделению
		 * оперативной памяти исчерпаны + бесконечный цикл
		 */
		try {
			List<Object> l = new LinkedList<Object>();
			while (true) {
				l.add(new byte[32*1024*1024]);
			}
		} catch (Throwable e) {
			e.printStackTrace();
		}
		
		/**
		 * Добавление в коллекцию элементов в большем количестве, чем удаление
		 * из коллекции, без контроля потребления оперативной памяти коллекцией
		 */
		try {
			Random r = new Random();
			Map<Long, byte[]> map = new HashMap<Long, byte[]>(1024);
			for(long i = 0; i < Long.MAX_VALUE; i++) {
				map.put(i, new byte[1*1024*1024]);
				map.remove(r.nextLong());
			}
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

}

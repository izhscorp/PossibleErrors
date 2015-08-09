package ru.alljoint.pe.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Random;

/**
 * 
 * @author Алексей Курган
 *
 *         Проблема производительности при последовательном чтении/записи из/в
 *         небуферизированного потока очень малыми порциями, например, по 1
 *         байту
 * 
 */

public class PerfIOPromblemBySeqRW {
	public static void main(String[] args) {
		try {
			Random r = new Random();

			File file = File.createTempFile("perfioproblem", null);
			file.deleteOnExit();

			/**
			 * Запись в поток по 1 байту
			 */
			FileOutputStream fos = new FileOutputStream(file);
			for (int i = 0; i < 1 * 1024 * 1024; i++) {
				fos.write(r.nextInt(256));
			}
			fos.close();

			/**
			 * Чтение из потока по одному байту
			 */
			FileInputStream fis = new FileInputStream(file);
			@SuppressWarnings("unused")
			int rb;
			while ((rb = fis.read()) != -1) {
			}
			fis.close();
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}
}

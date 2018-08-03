package org.longarithmetic;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

public abstract class AbstractTests {
    @BeforeClass
    public static void beforeClass() {
        System.out.println("Начато тестирование класса длинных чисел");
    }

    @AfterClass
    public  static void afterClass() {
        System.out.println("Тестирование класса длинных чисел окончено");
    }

    @Before
    public void startTest() {
        System.out.println("Тест начат");
    }

    @After
    public void endTest() {
        System.out.println("Тест завершён");
    }
}

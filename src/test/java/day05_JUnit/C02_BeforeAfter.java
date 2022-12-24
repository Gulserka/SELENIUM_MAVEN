package day05_JUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class C02_BeforeAfter {

    //@Before notasyanunun kullanildigi method'a genelde setup( ) ismi verilir.
    //@after notasyanunun kullanildigi metoda genelde teardown() ismi verilir

    @Before
    public void setUp(){
        System.out.println("Her Test Methodundan Önce Çalışır");
    }
    @After
    public void tearDown(){
        System.out.println("Her test Methodundan Sonra Çalışır");
    }

    @Test
    public void test01(){
        System.out.println("İlk Test");
    }

    @Test
    public void test02(){
        System.out.println("İkinci Test");
    }

}
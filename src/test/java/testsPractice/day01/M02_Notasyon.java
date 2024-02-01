package testsPractice.day01;

import org.junit.*;

public class M02_Notasyon {
    /*
        @beforeClass ---------> Sadece 1 kere tüm tesetlerden önce calisir
        @afterClass ----------> Tüm testlerden sonra calisir
        @before --------------> Her testten önce calisir
        @after ---------------> Her test sonunda calisir
    */

    @BeforeClass
    public static void beforeTest(){
        System.out.println("test calistirma islemi baslatiliyor");
    }
    @AfterClass
    public static void afterTest(){
        System.out.println("tum testler tamamlandi");
    }
    @Before
    public void setup(){
        System.out.println("siradaki test caliştiriliyor");
    }
    @After
    public void teardown(){
        System.out.println("calistirilan test tamamlandi.");
    }
    @Test
    public void test01(){
        System.out.println("ilk test calistiriliyor");
    }
    @Test
    public void test02(){
        System.out.println("ikinci test calistiriliyor");
    }
}

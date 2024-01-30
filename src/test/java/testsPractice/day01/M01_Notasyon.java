package testsPractice.day01;

import org.junit.Test;

public class M01_Notasyon {
    /*
        @beforeClass ---------> Sadece 1 kere tüm tesetlerden önce calisir
        @afterClass ----------> Tüm testlerden sonra calisir
        @before --------------> Her testten önce calisir
        @after ---------------> Her test sonunda calisir
    */

    @Test
    public void Gamze(){
        System.out.println("Gamze");
    }

    @Test
    public void Ayberk(){
        System.out.println("Ayberk");
    }

    @Test
    public void Aylin(){
        System.out.println("Aylin");
    }

}

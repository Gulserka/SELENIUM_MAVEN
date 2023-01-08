package day11;

import org.asynchttpclient.netty.future.StackTraceInspector;
import org.junit.Assert;
import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C03_FileExist {

    @Test
    public void isExistTest(){
        String userDIR = System.getProperty("user.dir");
        System.out.println(userDIR);

        String userHome = System.getProperty("user.home");
        System.out.println(userHome);

        //logo.jpeg indirip MASAUSTUne kaydedin
        //Logo masaustunde : C:\Users\Asus\Desktop
        String dosyayolu = userHome+"\\OneDrive\\Masaüstü\\logo.jpeg"; //eger calismazsa "\\Desktop\\logo.jpeg" dedi hoca

        System.out.println(dosyayolu);

        boolean isExist = Files.exists(Paths.get(dosyayolu)); //dosya var ose true, yok ise false
        Assert.assertTrue(isExist);


    }
}

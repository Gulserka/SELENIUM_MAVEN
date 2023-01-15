package day16;
import org.apache.poi.ss.usermodel.*;
import org.junit.Assert;
import org.junit.Test;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;
public class C01_ExcelRead {
    @Test
    public void readExcelTest() throws Exception {
//    WORKBOOK (EXCEL DOSYASI) > WORKSHEET/SHEET(SAYFA) >ROW (SATIR)> CELL(VERI HUCRESI)
        String path ="./src/test/java/resources/Capitals.xlsx";
//        String path =".\\src\\test\\java\\resources\\Capitals.xlsx";//WINDOWS
//        DOSYAYI AC
        FileInputStream fileInputStream = new FileInputStream(path);
//        EXCEL DOSYASINI AC /WORKBOOK AC
        Workbook workbook = WorkbookFactory.create(fileInputStream);
//        SAYFAYI AC / Sheet1
//        Sheet sheet1 = workbook.getSheetAt(0);//index 0 dan baslar. ilk sayfayi ac
        Sheet sheet1 = workbook.getSheet("Sheet1");// Sheet1 isimli sayfayi ac
//        ILK SATIRA GIT / Row
        Row row1 = sheet1.getRow(0);//ILK SATIRA GIT
//        INK SATIRDAKI ILK VERIYI AL
        Cell cell1 = row1.getCell(0);//ILK HUCREDEKI DATAYI VER
//        O VERIYI YAZDIR
        System.out.println(cell1);
//        1. SATIR 2. SUTUN
        Cell cell12 = sheet1.getRow(0).getCell(1);
        System.out.println(cell12);
//        3.Satir 1.Sutun yazdir ve O verinin France oldugunu test et
        String cell31 = sheet1.getRow(2).getCell(0).toString();
        System.out.println(cell31);
        Assert.assertEquals("France",cell31);
//       Exceldeki toplam kullanilan satir sayisini bul
        int toplamSatirSayisi = sheet1.getLastRowNum()+1;//son satir numarasi.index 0dan basliyor. sayma sayilari 1 den. +1 ekle
        System.out.println(toplamSatirSayisi);//11
//        Kullanilan toplam satir sayisini bul
        int kullanilanToplamSatirSayisi = sheet1.getPhysicalNumberOfRows();
        System.out.println(kullanilanToplamSatirSayisi);//1 den basliyor
//        COUNTRY, CAPITALS key ve value lari map a alip print et
//        {{USA, D.C},{FRANCE, PARIS},...}
//        Variable olusturalim. Bu variable exceldeki country,capital verilerini tutacak
        Map<String,String> ulkeBaskentleri = new HashMap<>();
        for (int satirSayisi=1;satirSayisi<kullanilanToplamSatirSayisi;satirSayisi++){
            String country = sheet1.getRow(satirSayisi).getCell(0).toString();
            String capital = sheet1.getRow(satirSayisi).getCell(1).toString();
            ulkeBaskentleri.put(country,capital);
//            ulkeBaskentleri.put(sheet1.getRow(satirSayisi).getCell(0).toString(),sheet1.getRow(satirSayisi).getCell(1).toString());
        }
        System.out.println(ulkeBaskentleri);
    }
}
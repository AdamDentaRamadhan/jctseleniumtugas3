import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import java.util.concurrent.TimeUnit;

public class Tugas3 {
    public static void main(String[] args) {
        String link ="C:\\mytoolms\\chromedriver-win64\\chromedriver.exe";//penyimpanan dari laptop
        System.setProperty("webdriver.chrome.driver",link);
        WebDriver driver = new ChromeDriver();
        System.out.println("Open Browser");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://juice-shop.herokuapp.com/#/login");
        System.out.println("Open URL");


        driver.findElement(By.xpath("//*[@id=\"mat-dialog-0\"]/app-welcome-banner/div/div[2]/button[2]/span[1]/span")).click();
        driver.findElement(By.name("email")).sendKeys("adamdentaramadhan18@gmail.com");
        driver.findElement(By.name("password")).sendKeys("Adamdenta18");
        delay(3);
        driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/div[1]/mat-sidenav-container[1]/mat-sidenav-content[1]/app-login[1]/div[1]/mat-card[1]/div[1]/button[1]/span[1]")).click();
        delay(25);
        driver.findElement(By.xpath("/html/body/app-root/div/mat-sidenav-container/mat-sidenav-content/app-search-result/div/div/div[2]/mat-grid-list/div/mat-grid-tile[1]/div/mat-card/div[2]/button/span[1]/span")).click();
        delay(15);
        driver.findElement(By.xpath("/html/body/app-root/div/mat-sidenav-container/mat-sidenav-content/app-navbar/mat-toolbar/mat-toolbar-row/button[4]/span[1]/span[1]")).click();
        delay(5);
        String muncul = driver.findElement(By.xpath("/html/body/app-root/div/mat-sidenav-container/mat-sidenav-content/app-navbar/mat-toolbar/mat-toolbar-row/button[2]/span[1]/span")).getText();
        if(muncul.equals("OWASP Juice Shop")){
            Assert.assertEquals(muncul,"OWASP Juice Shop");
            System.out.println("Berhasil masuk");
        }else{
            System.out.println("gagal masuk");
        }
        System.out.println(muncul);
        String menambahkan = driver.findElement(By.xpath("/html/body/app-root/div/mat-sidenav-container/mat-sidenav-content/app-basket/mat-card/app-purchase-basket/mat-table/mat-row/mat-cell[2]")).getText();
        if(menambahkan.equals("Apple Juice (1000ml)")){
            Assert.assertEquals(menambahkan,"Apple Juice (1000ml)");
            System.out.println("berhasil menambahkan");
        }else{
            System.out.println("gagal menambahkan");
        }
        System.out.println(menambahkan);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.quit();
        System.out.println("menutup browser");
    }
    static void delay(long detik){
        try {
            Thread.sleep(detik*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}


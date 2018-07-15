/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package selenium;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import java.io.FileWriter;
import java.util.List;
import org.testng.annotations.AfterClass;
import stepdefs.Loginpage;

@CucumberOptions(
        features = "src/test/resources/",
        glue = "stepdefs",
        plugin = {
            "pretty",
            "html:target/cucumber",}
)
public class RunTest extends AbstractTestNGCucumberTests {

    @AfterClass
    public static void teardown() {
        Loginpage loginpage = new Loginpage();
        List l = loginpage.getList();
        writeTestOutput(l);
        System.out.println("Ran the after");
    }

    public static void writeTestOutput(List list) {
        System.out.println("ssadasdsasdadasdadassda");
        String[] a = {"MOB-1", "MOB-2"};
        for (String id : a) {
            if (list.remove(id)) {
                write(id, null);
            } else {
                write(id, "fail");
            }
        }

    }

    public static void write(String id, String status) {

        status = status == null ? "pass" : status;
        try {
            FileWriter fw = new FileWriter("testout.txt", true);
            fw.write(id + " " + status+"\n");
            fw.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        System.out.println("Success...");
    }
}

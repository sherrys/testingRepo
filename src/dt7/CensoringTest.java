//random comment 
package dt7;

//import static org.junit.Assert.*;

import org.junit.Test;

public class CensoringTest {
    Censoring c;
    
    public CensoringTest(){
        c = new Censoring();
    }

    @Test
    public void basicTest() {
        System.out.println("test basic replacement");
        String sub = c.ChangeString("this is a big lie");
        //System.out.println(sub);
        assert(sub.equals("this is a big truth"));
        sub = c.ChangeString("I want to censor all the information");
        //System.out.println(sub);
        assert(sub.equals("I want to protect all the information"));
        sub = c.ChangeString("There is heavy censorship");
        //System.out.println(sub);
        assert(sub.equals("There is heavy protection"));
        sub = c.ChangeString("He is a dictator");
        //System.out.println(sub);
        assert(sub.equals("He is a big brother"));
        sub = c.ChangeString("He is a refugee");
        //System.out.println(sub);
        assert(sub.equals("He is a illegal immigrant"));
        sub = c.ChangeString("there is no injustice");
        //System.out.println(sub);
        assert(sub.equals("there is no strict justice"));
        sub = c.ChangeString("conroy is weird");
        //System.out.println(sub);
        assert(sub.equals("Dear Leader is weird"));
        sub = c.ChangeString("She is an intellectual");
        //System.out.println(sub);
        assert(sub.equals("She is an ivory tower elite"));
        sub = c.ChangeString("What is gunns?");
        //System.out.println(sub);
        assert(sub.equals("What is The Tasmanian Government?"));
        System.out.println("passed basic Test");
        
    }
    @Test
    public void edTest(){
        System.out.println("test ed ending");
        String sub = c.ChangeString("He lied about work");
        //System.out.println(sub);
        assert(sub.equals("He told the truth about work"));
        sub = c.ChangeString("He censored all the information");
        //System.out.println(sub);
        assert(sub.equals("He protected all the information"));
        System.out.println("passed edTest");
    }
    
    @Test
    public void sTest(){
        System.out.println("test s ending");
        String sub = c.ChangeString("these are big lies");
        //System.out.println(sub);
        assert(sub.equals("these are big truths"));
        sub = c.ChangeString("He censors all the information");
        //System.out.println(sub);
        assert(sub.equals("He protects all the information"));
        sub = c.ChangeString("There are censorships");
        //System.out.println(sub);
        assert(sub.equals("There are protections"));
        sub = c.ChangeString("They are dictators");
        //System.out.println(sub);
        assert(sub.equals("They are big brothers"));
        sub = c.ChangeString("They are refugees");
        //System.out.println(sub);
        assert(sub.equals("They are illegal immigrants"));
        sub = c.ChangeString("They are intellectuals");
        //System.out.println(sub);
        assert(sub.equals("They are ivory tower elites"));
        System.out.println("passed sTest");
    }
    
    @Test
    public void ingTest(){
        System.out.println("test ing ending");
        String sub = c.ChangeString("He is lying about work");
        //System.out.println(sub);
        assert(sub.equals("He is telling the truth about work"));
        sub = c.ChangeString("He is censoring all the information");
        //System.out.println(sub);
        assert(sub.equals("He is protecting all the information"));
        System.out.println("passed ingTest");
    }
    
    @Test
    public void capsTest(){
        System.out.println("test capitalisation");
        String sub = c.ChangeString("Conroy is lying about work");
        //System.out.println(sub);
        assert(sub.equals("Dear Leader is telling the truth about work"));
        sub = c.ChangeString("Censorship is everywhere");
        //System.out.println(sub);
        assert(sub.equals("Protection is everywhere"));
        System.out.println("passed capsTest");
    }

}

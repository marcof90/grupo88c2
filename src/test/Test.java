package test;

import model.Owner;

public class Test {
    public void scenarioOwner(){
        Owner owner1 = new Owner("Andrés");
        boolean test1 = assertTrue("Andrés", owner1.getName());
        System.out.println((test1) ? "Pasa" : "No pasa");
    }

    public boolean assertTrue(int expectative, int reality) {
        if (expectative > reality) {
            return true;
        } else {
            return false;
        }
    }
    
    public boolean assertTrue(String expectative, String reality) {
        if (expectative.equalsIgnoreCase(reality)) {
            return true;
        } else {
            return false;
        }   
    }
}
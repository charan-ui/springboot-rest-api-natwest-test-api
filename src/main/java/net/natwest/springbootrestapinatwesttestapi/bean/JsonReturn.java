package net.natwest.springbootrestapinatwesttestapi.bean;

import java.util.List;

public class JsonReturn {

    private int intial;
    private List<Integer> primesList;

    public JsonReturn(int intial , List<Integer> primesList)
    {
        this.intial = intial;
        this.primesList = primesList;

    }


    public int getIntial() {
        return intial;
    }

    public void setIntial(int intial) {
        this.intial = intial;
    }

    public List<Integer> getPrimesList() {
        return primesList;
    }

    public void setPrimesList(List<Integer> primesList) {
        this.primesList = primesList;
    }
}

package net.natwest.springbootrestapinatwesttestapi.controller;

import net.natwest.springbootrestapinatwesttestapi.bean.JsonReturn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import net.natwest.springbootrestapinatwesttestapi.service.PrimeCheckService;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PrimesController {

    @Autowired
    private PrimeCheckService prcser;

    //http://localhost:8080/primes/10 : to call this api
    //spring boot rest Api with path  variable
    //{prime-range} - Uri template variable
    //@pathVariable to bind
    @GetMapping("primes/{number}")
    public JsonReturn calculatePrimes(@PathVariable("number") int primenumber)
    {
        List<Integer> primeNumbers = new ArrayList<Integer>();

        //if primeNumber is greater than and equal 2 .2 for sure will be included in prime numbers list
        if(primenumber >= 2)
        {
            primeNumbers.add(2);
        }

        //start this looping from No 3 skipping 2 steps at once because even numbers cant be prime
        //eX : 3 next number is 4 need not be checked 5 can be checked
        for(int i = 3 ; i <= primenumber ; i += 2)
        {
            if(prcser.isPrime(i))
            {
                primeNumbers.add(i);
            }
        }
        JsonReturn json = new JsonReturn(primenumber,primeNumbers);
        return json;
    }






}

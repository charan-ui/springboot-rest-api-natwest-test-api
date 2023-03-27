package net.natwest.springbootrestapinatwesttestapi.controller;

import net.natwest.springbootrestapinatwesttestapi.bean.JsonReturn;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PrimesController {

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
            if(isPrime(i))
            {
                primeNumbers.add(i);
            }
        }
        JsonReturn json = new JsonReturn(primenumber,primeNumbers);
        return json;
    }

    /*
       consider a number(N) and factors are a and b
       any one of the factor must and should be lesser than the square root of the number(N) if both are greater it will definately be greater than N
       so atleast one of them should be lesser than the square root of the Number
       so if we check just till the square root of number we can save other half of the computation
       this might not be considerable effect in small inputs but when dealing with millions and billions of data this will be efficient
     */
    public boolean isPrime(int number)
    {
        /*
        mathematical proof
        i <= squareroot(N)
        apply square on BTS
        i*i <= N
         */

        for(int i = 2 ; i*i <= number ; i++)
        {
            if(number % i == 0)
            {
                return false;
            }
        }

        return true;

    }




}

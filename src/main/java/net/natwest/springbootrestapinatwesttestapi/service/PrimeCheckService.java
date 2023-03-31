package net.natwest.springbootrestapinatwesttestapi.service;

import org.springframework.stereotype.Service;

@Service
public class PrimeCheckService {

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

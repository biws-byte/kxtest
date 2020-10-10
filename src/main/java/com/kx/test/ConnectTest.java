package com.kx.test;

public class ConnectTest {


    public static void main(String[] args) {
        int count = 0;
        for(int sum = 2; sum <= 100;sum++){
            if(sum%2 == 0){
                count += sum;
            }else if
            (sum%2 != 0){
                count -= sum;
            }
        }
        System.out.println(count+1);
    }
}

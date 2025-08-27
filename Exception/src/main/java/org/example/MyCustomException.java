package org.example;

public class MyCustomException extends Exception{
    public MyCustomException(String message){
        super(message);
    }
    public MyCustomException(){
        super("custom exception");
    }
}

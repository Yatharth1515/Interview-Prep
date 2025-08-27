package org.example;

import java.io.FileNotFoundException;
import java.nio.file.FileSystemAlreadyExistsException;

public class Main {
    public static void main(String[] args)  {
        System.out.println("Hello world!");
        // Unchecked Exceptions

//        Object val = 0;
//        int arr[] = new int[2];
//        int value = Integer.parseInt("asd");// illegalArgument Exception - numberFormat
//        String abs = "ac";
//        abs.charAt(2);//string index out of bound
//        String test = null;
//        char a = test.charAt(0);//npe
//        val = arr[3];
//        int val1 = 3/0;//arithmetic exception
//        System.out.println((String) val);//class cast exception

   try {
       method("a");
   }
   catch (MyCustomException e){
       System.out.println(e.fillInStackTrace());
   }
   catch (FileNotFoundException e){
       System.out.println(e.fillInStackTrace());
       return;
   }
   catch (ClassNotFoundException  | InterruptedException e){
       System.out.println(e.fillInStackTrace());
       System.out.println("caught here only");
      // System.exit(0);
       return;
   }
//   catch (InterruptedException e){
//       System.out.println(e.fillInStackTrace());
//   }
   catch (Exception e) {
       System.out.println(e.fillInStackTrace());
       return;
   }
   finally {

       System.out.println("Im in finally block");
   }

    }

    private static void method(String name) throws ClassNotFoundException, InterruptedException, FileNotFoundException, MyCustomException {
      if (name.equals("ac")){
          throw new ClassNotFoundException();
      }else if (name.equals("aca")){
          throw new FileNotFoundException();
      }
      else throw new MyCustomException("custom message , its good");

    }
}
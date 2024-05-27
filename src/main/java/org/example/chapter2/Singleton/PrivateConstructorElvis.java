package org.example.chapter2.Singleton;

public class PrivateConstructorElvis {
   public static final PrivateConstructorElvis INSTANCE = new PrivateConstructorElvis();
   String guitarName;

    public String getGuitarName() {
        return guitarName;
    }

    public void setGuitarName(String guitar) {
        this.guitarName = guitar;
    }

    private  PrivateConstructorElvis(){

   }

   public void doSomething(){
       System.out.println("elvis is doing something with this guiter who's name is ...." + guitarName);
   }
   public static PrivateConstructorElvis getInstance() {
       return INSTANCE;
   }
}

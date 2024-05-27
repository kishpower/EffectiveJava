package org.example.chapter2.Singleton;

public enum EnumElvis {
    INSTANCE;

    String guitarName;

    public String getGuitarName() {
        return guitarName;
    }

    public void setGuitarName(String guitarName) {
        this.guitarName = guitarName;
    }

    public void doSomething(){
        System.out.println("elvis is singing with his guitar name " + guitarName);
    }
}

package org.example.chapter3.MethodsCommonToAllObjects;

public class CaseInsensitiveString {
    private final String s;

    public CaseInsensitiveString(String s) {
        this.s = s;
    }

    @Override
    public boolean equals(Object obj) {
       if (obj instanceof CaseInsensitiveString){
           return s.equalsIgnoreCase(((CaseInsensitiveString) obj).s);
       }
       // violates symetry x.equals(y) , y.equals(x)
      if (obj instanceof String){
         return s.equalsIgnoreCase((String) obj) ;
      }
       return false;
    }
}

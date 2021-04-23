package DataStructuresImp;

public class Helpers {

    public static Boolean isBlank(String value){
        if (value!=null && !value.isEmpty() && !value.trim().isEmpty()){
            return false;
        } else return true;
    }
}

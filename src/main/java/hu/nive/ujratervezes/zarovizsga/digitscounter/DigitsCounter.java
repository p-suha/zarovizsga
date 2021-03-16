package hu.nive.ujratervezes.zarovizsga.digitscounter;

public class DigitsCounter {

    public int getCountOfDigits(String str){
        String temp="";
        if(str == null || str =="") { return 0;}

        for(int i = 0; i< str.length(); i++){
            if(temp.indexOf(str.charAt(i)) == -1 && Character.isDigit(str.charAt(i))){
                temp = temp+str.charAt(i);
            }
        }
        return temp.length();
    }


}

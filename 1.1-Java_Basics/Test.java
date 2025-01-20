public class Test{

    public static String testing(String text){
        char[] mainList = text.toCharArray();
        String result = "";
        for(int i=(int)Math.floor(text.length()/2);i>0;i--){
            result += mainList[i-1];
        }
        for(int i=text.length();i>Math.floor(text.length()/2);i--){
            result += mainList[i-1];
        }
        return result;
    }

    public static String findNReplace(String find, String replace){
        return "";
    }

    public static String reverseHalves(String text){ // maybe done

        int halfway = (int)Math.floor(text.length()/2);
        String iterate = text.substring(halfway);
        iterate += text.substring(0,halfway);//sets text in order of opposite halves (i.e. "1234"="3412")

        char[] mainList = iterate.toCharArray();
        String result = "";
        for(int i=text.length();i>0;i--){ //reverses the text
            result += mainList[i-1];
        }

        return result;
    }
    
        public static String reverseHalve(String text){ // maybe done
        char[] mainList = text.toCharArray();
        String result = "";
        for(int i=(int)Math.floor(text.length()/2);i>0;i--){
            result += mainList[i-1];
        }
        for(int i=text.length();i>Math.floor(text.length()/2);i--){
            result += mainList[i-1];
        }
        return result;
    }

   public static String weave(String text){
    String result="";
    char[] list = text.toCharArray();
    int segmentMax = (int)Math.floor(text.length()/4); // cuts text up into segments of 4
    for(int segment=0;segment<segmentMax;segment++){ // the middle indexes of each get flipped example:"1234" -> "1324"
        char one =list[2+(4*segment)]; //stores value of the segment's
        char two =list[1+(4*segment)];
        list[1+(4*segment)]= one;
        list[2+(4*segment)]= two;
    }
    if(text.length()%4==3){ //flips last two values when last segment is only 3 long example:"123" -> "132"
        char one =list[2+(4*segments)];
        char two =list[1+(4*segments)];
        list[1+(4*segments)]= one;
        list[2+(4*segments)]= two;
    }
    result = String.valueOf(list);
    return result;
   }

    public static void main(String[] args){
        System.out.println(weave("1"));
        System.out.println(weave("12"));
        System.out.println(weave("123"));
        System.out.println(weave("1234"));
        System.out.println(weave("12345"));
        System.out.println(weave("123456"));
        System.out.println(weave("1234567"));
        System.out.println(weave("12345678"));
        System.out.println(weave("123456789"));
        System.out.println(weave("1234567890"));
    }
}
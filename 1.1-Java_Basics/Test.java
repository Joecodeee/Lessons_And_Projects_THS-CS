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

    public static void main(String[] args){
            System.out.println(testing("hemllo"));
    }
}
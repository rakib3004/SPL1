package MainPackage;

public class StringTest {
    public static void main(String[] args) {
        String stringA = " Rakib";
        int longLength = stringA.length();

        System.out.println(stringA);
        stringA = stringA.substring(0,longLength-1);
        System.out.println(stringA);
    }
}

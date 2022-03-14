package chap14.hash;

public class ProblemsFromBook {

    public static void main(String[] args) {
        findFirstRepeatedCharacter("abcdc");
    }

    public static void findFirstRepeatedCharacter(String s)
    {
        char[] array = s.toCharArray();
        int[] count = new int[256];
        for(int i=0;i<256;i++)
        {
            count[i] = 0;
        }

        for(int i=0;i<array.length;i++)
        {
            if(count[array[i]] == 1){
                System.out.println("First repeated character is :: " + array[i]);
                break;
            }
            else
                count[array[i]]++;

            if(i==array.length-1)
            {
                System.out.println("No Repeated Character");
                return;
            }
        }
        return;
    }
}


public class Contains {
    public static void main(String[] args) {
        Contains con = new Contains();
        String origin = "длиннастрокаоченьдлинная";
        String sub = "строка";
        System.out.println(con.contains(origin, sub));
    }

    public boolean contains(String origin, String sub) {
        char[] originChar = origin.toCharArray();
        char[] subChar = sub.toCharArray();
        int j = 0;
        for (int i = 0; j < subChar.length && i < originChar.length; i++) {
            j = (j != subChar.length && originChar[i] == subChar[j]) ? j + 1 : 0;
        }
        return j == subChar.length;
    }
}
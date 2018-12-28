package zhang.lao.build.tool;

/**
 * Created by 张钦 on 2016/7/27.
 */
public class LzStringUtils {

    /**
     * 将大写变成小写并添加下划线
     * @param word
     * @return
     */
    public static String chageStringUpCaseAnd_(String word)
    {
        StringBuilder str = new StringBuilder();
        for(int i = 0; i < word.length(); i++)
        {

            char c = word.charAt(i);
            String appendValue= String.valueOf(c);
            if (Character.isUpperCase(c))
            {
                appendValue = "_"+appendValue.toLowerCase();
            }
            str.append(appendValue);
        }
        return str.toString();
    }
}


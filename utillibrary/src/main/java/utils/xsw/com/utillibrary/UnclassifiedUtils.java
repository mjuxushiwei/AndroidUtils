package utils.xsw.com.utillibrary;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningServiceInfo;
import android.content.ComponentName;
import android.content.Context;
import android.text.Editable;
import android.text.Selection;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

import java.util.List;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

/**
 * <pre>
 *     author: Blankj
 *     blog  : http://blankj.com
 *     time  : 2016/8/2
 *     desc  : 未归类工具类
 * </pre>
 */
public class UnclassifiedUtils {

    private UnclassifiedUtils() {
        throw new UnsupportedOperationException("u can't fuck me...");
    }

    /**
     * 获取服务是否开启
     *
     * @param context   上下文
     * @param className 完整包名的服务类名
     * @return {@code true}: 是<br>{@code false}: 否
     */
    public static boolean isRunningService(Context context, String className) {
        // 进程的管理者,活动的管理者
        ActivityManager activityManager = (ActivityManager)
                context.getSystemService(Context.ACTIVITY_SERVICE);
        // 获取正在运行的服务，最多获取1000个
        List<RunningServiceInfo> runningServices = activityManager.getRunningServices(1000);
        // 遍历集合
        for (RunningServiceInfo runningServiceInfo : runningServices) {
            ComponentName service = runningServiceInfo.service;
            if (className.equals(service.getClassName())) {
                return true;
            }
        }
        return false;
    }

    /**
     * 获取随机数
     *
     * @param max 多少数以内的
     * @return
     */
    public static int RandomNuber(int max) {

        Random Random = new Random();
        return Random.nextInt(max);

    }

    /**
     * 如   number 100   maxNumber 99    返回 99+
     *
     * @param number    要格式的数字
     * @param maxNumber 格式化 最大的数据
     * @return
     */
    public static String GetNumberFormat(int number, int maxNumber, String formart) {

        if (number > maxNumber) {
            return maxNumber + formart;
        } else {
            return number + "";
        }
    }


    /**
     * 需在  TextWatcher  类中onTextChanged方法中调用
     *
     * @param editText
     * @param maxLen
     */

    public static void SetEidtTextMaxInput(Context context, EditText editText, int maxLen, boolean isToast) {

        if (editText == null || context == null) {
            return;
        }

        Editable editable = editText.getText();
        int len = editable.length();

        if (len > maxLen) {
            int selEndIndex = Selection.getSelectionEnd(editable);
            String str = editable.toString();
            //截取新字符串
            String newStr = str.substring(0, maxLen);
            editText.setText(newStr);
            editable = editText.getText();

            //新字符串的长度
            int newLen = editable.length();
            //旧光标位置超过字符串长度
            if (selEndIndex > newLen) {
                selEndIndex = editable.length();

                if (isToast) {
                    Toast.makeText(context, "长度不超过" + maxLen, Toast.LENGTH_SHORT).show();
                }
            }
            //设置新光标所在的位置
            Selection.setSelection(editable, selEndIndex);

        }
    }

    /**
     * 符合正则规则的文本输入
     * 需在  TextWatcher  类中onTextChanged方法中调用
     *
     * @param eidttext
     * @param regEx    正则表达式
     */

    public static void setEditTextViewReg(EditText eidttext, String regEx) {


        String editable = eidttext.getText().toString();
//        Pattern p = Pattern.compile(regEx);
//        Matcher m = p.matcher(editable);
//        String str= m.replaceAll("").trim();
//
//        Pattern p2 = Pattern.compile("[\ud83c\udc00-\ud83c\udfff]|[\ud83d\udc00-\ud83d\udfff]|[\u2600-\u27ff]",
//                Pattern.UNICODE_CASE | Pattern.CASE_INSENSITIVE);
//        Matcher m2 = p2.matcher(str);
//
//        String str2= m2.replaceAll("").trim();

//        String regEx2 = "^[\\\\u4E00-\\\\u9FA5\\\\uF900-\\\\uFA2D\\\\w]";
//        Pattern p3 = Pattern.compile(regEx2);
//        Matcher m3 = p3.matcher(editable);
//        String str3 = m3.replaceAll("").trim();
//
//
//        if (!editable.equals(str3)) {
//            eidttext.setText(str3);
//            eidttext.setSelection(str3.length()); //光标置后
//        }

        String regEx3 = "[^a-zA-Z0-9\\u4E00-\\u9FA5 ]+";
        Pattern p3 = Pattern.compile(regEx3);
        Matcher m3 = p3.matcher(editable);
        String str3 = m3.replaceAll("").trim();
        if (!editable.equals(str3)) {
            eidttext.setText(str3);
            eidttext.setSelection(str3.length()); //光标置后
        }


//        String strs = eidttext.getText().toString();
//        String str = stringFilter(strs.toString());
//
//        if (!strs.equals(str)) {
//            eidttext.setText(str);
//            eidttext.setSelection(str.length());
//        }

    }

    public static String stringFilter(String str) throws PatternSyntaxException {
        // 只允许字母、和空格和汉字
        String regEx = "[a-zA-Z0-9\\u4E00-\\u9FA5 ]+";
        return str != null ? (str.matches(regEx) ? str : "") : "";
    }

    public static void hideInputKeyborder(Context context) {

        try {
            InputMethodManager imm = (InputMethodManager) ((Activity) context).getSystemService(((Activity) context).INPUT_METHOD_SERVICE);

            if (imm.isActive()) {
                ((InputMethodManager) ((Activity) context).getSystemService(Context.INPUT_METHOD_SERVICE)).hideSoftInputFromWindow(((Activity) context).getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
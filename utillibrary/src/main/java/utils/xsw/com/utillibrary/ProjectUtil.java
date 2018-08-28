package utils.xsw.com.utillibrary;

/**
 * Created by xushiwei on 2017/5/31.
 */

public class ProjectUtil {
    /**
     *  男1  女2
     * @param sex
     * @return
     */

    public static int GetGenderCode(String sex){

        if("男".equals(sex)){
            return  1;

        }else{
            return  2;
        }

    }
    public static String GetGender(int  code){

        if(1==code){
            return  "男";

        }else{
            return "女";
        }

    }


}

package tute.test;

import org.junit.Test;

/**
 * @Author:田增印
 * @Date:2019/10/13
 * @Time:15:47
 * @Description:tute.test
 * @VERSION:1.0
 */
public class TestFilter {
    @Test
    public void TestHasLength(){
        String encoding = "  utf-8  ";
        boolean b = TestFilter.hasLength(encoding);
        System.out.println(b);

    }
    public static boolean hasLength(String value){
        return !value.isEmpty() && !"".equals(value.trim());
    }
}

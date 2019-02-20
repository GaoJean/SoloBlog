package com.solo.common.reflect;

import com.solo.common.model.ResultModel;

/**
 * @Author gaojian
 * @Date 2019/2/13
 */
public class ClassDemo2 {
    public static void main(String[] args) {
        String string = "hello";
        ResultModel resultModel = new ResultModel();
//       ClassUtil.printMethodMessage(string);
        ClassUtil.printFieldMessage(resultModel);
//        ClassUtil.printConMessage(string);

//        int i = 1;
//        ClassUtil.printMethodMessage(i);
    }
}

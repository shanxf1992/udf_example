package com.hive.udf;

import org.apache.hadoop.hive.ql.exec.UDF;

/**
 * 1. 首先定义一个类 UDF_Emp 继承 UDF 类
 */
public class UDF_Emp extends UDF {

    /**
     * 2. 重载该类的 evaluate 方法--自定义一个 udf 将输入的小写字符串转成大写
     * @param in 方法的入参, 就是函数的输入
     * @return 方法的返回值就是方法的执行结果
     */
    public String evaluate(String in) {
        return in.toLowerCase();
    }

    /**
     * 3. 再次重载该类的 evaluate 方法--实现两个数的累加
     * @param a 输入的第一个参数
     * @param b 输入的第二个参数
     * @return 返回加和后的结果
     */
    public Integer evaluate(Integer a, Integer b) {
        return a + b;
    }
}

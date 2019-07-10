package com.lei.demo.utils;

import com.lei.demo.domain.Result;

/**
 * http请求返回的结果工具类
 * @author Chris
 */
public class ResultUtil {

    /**
     * @Author: Chris
     * @Date: 0:09 2018/6/25
     * @Description: 成功时返回结果
     * @params:  * @param object
     */
    public static Result success(Object object) {
        Result result = new Result();
        result.setCode(0);
        result.setMsg("成功");
        result.setData(object);
        return result;
    }

    /**
     * @Author: Chris
     * @Date: 0:09 2018/6/25
     * @Description: 成功且无对象传入时返回结果
     * @params:  null
     */
    public static Result sucess() {
        return success(null);
    }

    /**
     * @Author: Chris
     * @Date: 0:09 2018/6/25
     * @Description: 失败时返回结果
     * @params:  * @param code
     * * @param msg
     */
    public static Result error(Integer code, String msg) {
        Result result = new Result();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }
}

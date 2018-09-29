package com.zzg.tracing.utils;

import com.alibaba.fastjson.JSON;
import com.zzg.tracing.entity.BaseResponse;

public class ResPonseUtils {

    /**
     * 错误json 加提示
     */
    public static String responseJsonE(String msg) {
        BaseResponse baseResponse = new BaseResponse();

        baseResponse.setStatus(0);

        baseResponse.setMessage(msg);


        String eJson = JSON.toJSONString(baseResponse);

        return eJson;
    }


    /**
     * 成功返回信息
     */
    public static String responseJsonS(Object obj) {
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setStatus(1);
        baseResponse.setMessage("sucess");
        baseResponse.setData(obj);

        String sJson = JSON.toJSONString(baseResponse);

        return sJson;
    }


}

package com.h2t.study.util;


import com.h2t.study.vo.ResponseVO;

public class ResponseUtil {

    public static ResponseVO success(Object object) {
        ResponseVO responseVo = new ResponseVO();
        responseVo.setCode("0");
        responseVo.setMsg("success");
        responseVo.setData(object);
        return responseVo;
    }

    public static ResponseVO success() {
        return success(null);
    }

    public static ResponseVO error(String code, String msg, String errorInfo) {
        ResponseVO<String> responseVo = new ResponseVO();
        responseVo.setCode(code);
        responseVo.setMsg(msg);
        responseVo.setData(errorInfo);
        return responseVo;
    }

    public static ResponseVO error(String code, String msg) {
        ResponseVO<String> responseVo = new ResponseVO();
        responseVo.setCode(code);
        responseVo.setMsg(msg);
        return responseVo;
    }
}

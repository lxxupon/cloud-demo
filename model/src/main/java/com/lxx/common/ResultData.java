package com.lxx.common;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @auther lxx
 * @create 2023-12-22 16:18
 */
@Schema(description = "统一响应结果", title = "ResultData")
@Data
@Accessors(chain = true)
public class ResultData<T>
{

    @Schema(description = "状态码", example = "200")
    private String code;/** 结果状态 ,具体状态码参见枚举类ReturnCodeEnum.java*/

    @Schema(description = "响应消息", example = "操作成功")
    private String message;

    @Schema(description = "响应数据")
    private T data;

    @Schema(description = "时间戳", example = "1703242800000")
    private long timestamp;

    public ResultData()
    {
        this.timestamp = System.currentTimeMillis();
    }

    public static <T> ResultData<T> success(T data)
    {
        ResultData resultData = new ResultData();

        resultData.setCode(ReturnCodeEnum.RC200.getCode());
        resultData.setMessage(ReturnCodeEnum.RC200.getMessage());
        resultData.setData(data);

        return resultData;
    }

    public static <T> ResultData<T> fail(String code,String message)
    {
        ResultData resultData = new ResultData();

        resultData.setCode(code);
        resultData.setMessage(message);
        resultData.setData(null);

        return resultData;
    }
}

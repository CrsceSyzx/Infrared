/**
 * Project Name:Infrared
 * File Name:WebDataConverter.java
 * Package Name:com.syzx.infrared.service
 * Date:2017年12月8日下午11:55:02
 * Copyright (c) 2017, syzx.com All Rights Reserved.
 *
 */
package com.syzx.infrared.service;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.charset.UnsupportedCharsetException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.syzx.infrared.service.interfaces.IDataConverter;

/**
 * ClassName: WebDataConverter <br/>
 * Function: TODO 描述类的功能. <br/>
 * date: 2017年12月8日 下午11:55:02 <br/>
 *
 * @author Zxy
 * @version 
 * @since JDK 1.8
 */
public class WebDataConverter implements IDataConverter {

    private final String CHARSET_REGULAR = "(?<=<meta[^<>]{0,300}charset {0,300}= {0,300})[a-zA-Z0-9-|_]{0,300}";

    /**
     * TODO 简单描述该方法的实现功能（可选）.
     * @see com.syzx.infrared.service.interfaces.IDataConverter#convertToString(byte[])
     */
    public String convertToString(byte[] data) {
        String charSetString = null;
        //以默认字符集解码
        String result = convertToString(data, Charset.defaultCharset());

        Matcher matcher = Pattern.compile(CHARSET_REGULAR).matcher(result);
        if (matcher.find()) {
            //找到真实的字符集
            charSetString = matcher.group();
        }
        //若默认字符集与真实的不一致，则重新解码
        if (!"".equals(charSetString) && !Charset.defaultCharset().equals(Charset.forName(charSetString))) {
            result = convertToString(data, charSetString);
        }
        return result;
    }

    /**
     * TODO 简单描述该方法的实现功能（可选）.
     * @see com.syzx.infrared.service.interfaces.IDataConverter#convertToString(byte[], java.lang.String)
     */
    public String convertToString(byte[] data, String charSet) {
        if (Charset.isSupported(charSet)) {
            return convertToString(data, Charset.forName(charSet));
        }

        throw new UnsupportedCharsetException(charSet);
    }

    /**
     * TODO 简单描述该方法的实现功能（可选）.
     * @see com.syzx.infrared.service.interfaces.IDataConverter#convertToString(byte[], java.nio.charset.Charset)
     */
    public String convertToString(byte[] data, Charset charSet) {
        return charSet.decode(ByteBuffer.wrap(data)).toString();
    }

}

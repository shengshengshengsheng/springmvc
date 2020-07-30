package cn.itcast.utils;

import org.springframework.core.convert.converter.Converter;
import org.springframework.util.StringUtils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * description:将字符串转换为日期
 *
 * @author xuqiangsheng
 * @date 2020/7/30 8:43
 */
public class StringToDateConverter implements Converter<String, Date> {
    /**
     *
     * @author XuQiangsheng
     * @date 2020/7/30 8:44
     * @param s
     * @return java.util.Date
    */
    @Override
    public Date convert(String s) {
        if(StringUtils.isEmpty(s)){
            throw new RuntimeException("请传入日期");
        }
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            return dateFormat.parse(s);
        } catch (ParseException e) {
            e.printStackTrace();
            throw new RuntimeException("转换出错");
        }
    }
}

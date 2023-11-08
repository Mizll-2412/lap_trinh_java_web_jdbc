package com.laptrinhjavaweb.utils;

import javax.servlet.http.HttpServletRequest;

public class SessionUtil {
    //các hàm duy trì thông tin người dùng
    //putValue:duy trì thông tin người dùng
    //removeValue:thoát ra khỏi hệ thống
    //getValue:lấy thông tin ra

    private static SessionUtil sessionUtil= null;
    public static SessionUtil getInstance()
    {
        if(sessionUtil==null)
        {
            sessionUtil= new SessionUtil();
        }
        return sessionUtil;
    }
    public void putValue(HttpServletRequest request,String key,Object value)
    {
        request.getSession().setAttribute(key,value);
    }
    public Object getValue(HttpServletRequest request,String key)
    {
        return request.getAttribute(key);
    }

    public void removeValue(HttpServletRequest request,String key)
    {
        request.getSession().removeAttribute(key);
    }
}

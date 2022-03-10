/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.LuoZhiHao.GUI.DispatchGUI;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class ClassReflect<T>
{
    public static List<Method> getAllGetMethod(Object obj)
    {
        List<Method> getMethods=new ArrayList<>();
        Class refClass = obj.getClass();
        System.out.println(refClass);
        String[] row= {"getdId","getcId","getTrvId","getuId"};
        Method[] methodArray = refClass.getMethods();
        for(String r:row){
        	for(Method m:methodArray)
        	{
        		if(m.getName() == r){
        			getMethods.add(m);
        			//System.out.println(m.getName());
        		}
        	}
        }
        return getMethods;
    }

}

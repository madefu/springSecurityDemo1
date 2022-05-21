package com.madefu.spd1;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializable;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.madefu.spd1.mybatis.generator.persistobj.Tuseraccountpo;
import com.madefu.spd1.mybatis.generator.type.PersonInfoAddress;
import com.madefu.spd1.mybatis.generator.type.PersonInfoType;
import com.madefu.spd1.mybatis.generator.type.SexType;

import java.math.BigDecimal;

public class 够三姑寺炫舞 {
    public static void main(String[] args) {
        Tuseraccountpo t = new Tuseraccountpo();
        PersonInfoType personInfoType = new PersonInfoType(new PersonInfoAddress("beijing","长安街"),6,"ma","10001");
        t.setUserName("madefu1");
        t.setPassword("1111");
        t.setSexEnum(SexType.FEMALE);
        t.setPersonalInfo(personInfoType);
        ObjectMapper om = new ObjectMapper();
        try {
            System.out.println(om.writeValueAsString(t));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        //a*a+100=b*b
        //x=b-a
        //x2+3ax=100
        //a=50/x-x
        int a=0;
        int b=0;

        for(int x=1;x<=50;x++){
            BigDecimal bd2=new BigDecimal(3);
            BigDecimal bdx = new BigDecimal(x);
            BigDecimal bd50 = new BigDecimal(50);
            BigDecimal aX = bd50.divide(bdx).subtract((bd2.divide(bdx)));

            if(isIntegerValue(aX)){
                a=aX.intValue();
                b=a+x;
                System.out.println("a=" + a);
                System.out.println("b=" + b);
                return;
            }
        }
        System.out.println("not fit value");
        return;

    }

    private static boolean isIntegerValue(BigDecimal decimalVal) {
        return decimalVal.scale() <= 0 ||     decimalVal.stripTrailingZeros().scale() <= 0;
    }
}

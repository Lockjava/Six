/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qdu.beans;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsRequest;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;
import com.qdu.pojo.Useridentity;
import com.qdu.pojo.Users;
import com.qdu.service.impl.UserServiceImpl;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.enterprise.context.SessionScoped;

import javax.inject.Named;

/**
 *
 * @author 刘凯
 */
@Named
@SessionScoped
public class UserBean implements Serializable {

    private String valid;
    static  private String codetemp;
    public String getValid() {
        return valid;
    }

    public void setValid(String valid) {
        this.valid = valid;
    }

    //随机验证码
    private int code;

    public int getCode() {
        return code;
    }

    public void setCode() {
        code = (int) (Math.random() * 9999) + 1000;
    }
    //短信API产品名称
    final String product = "Dysmsapi";
    //短信API产品域名  
    final String domain = "dysmsapi.aliyuncs.com";
    //阿里云关键字id
    final String accessKeyId = "LTAI4FrzyGxhi31aV7XvgXHY";
    //阿里云关键密码
    final String accessKeySecret = "amd5qXuRlZ0oZxd6k9EYPA2uZJbB8K";

    public SendSmsResponse sendSms(String telphone) throws ClientException {
   
        //设置超时时间
        System.setProperty("sun.net.client.defaultConnectTimeout", "10000");
        System.setProperty("sun.net.client.defaultReadTimeout", "10000");
        //初始化ascClient
        System.out.println("开始发送2");
        IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", accessKeyId, accessKeySecret);
        DefaultProfile.addEndpoint("cn-hangzhou", "cn-hangzhou", product, domain);
        System.out.println("开始发送3");
        IAcsClient acsClient = new DefaultAcsClient(profile);
        System.out.println("开始发送4");

        //组装请求对象
        SendSmsRequest request = new SendSmsRequest();
        System.out.println("开始发送5");
        //使用post提交
        System.out.println("开始发送6");
        request.setMethod(MethodType.POST);
        System.out.println("开始发送7");
        //待发送的手机号
        request.setPhoneNumbers(telphone);
        System.out.println("开始发送8");
        //短信签名
        request.setSignName("支教与捐赠平台");
        System.out.println("开始发送9");
        //短信模板ID
        request.setTemplateCode("SMS_180956775");
        //验证码
        System.out.println("开始发送10");
        UserBean sms = new UserBean();
        sms.setCode();
        System.out.println("开始发送11");
        codetemp = sms.getCode() + "";
        System.out.println("code:        " + codetemp);
        
        
       

        /*
          * 可选:模板中的变量替换JSON串,
          * 如模板内容为"亲爱的${name},您的验证码为${code}"时,
          *   \  反斜杠为转义字符，使得输出双引号
         */
        request.setTemplateParam("{\"name\":\"Tom\", \"code\":\"" + codetemp + "\"}");
        //可选:outId为提供给业务方扩展字段,最终在短信回执消息中将此值带回给调用者
        //request.setOutId("1454");
        SendSmsResponse response = acsClient.getAcsResponse(request);

        if (response.getCode() != null && response.getCode().equals("OK")) {
            //请求成功
            System.out.println("发送成功！");
        } else {
            System.out.println("发送失败！");
        }
        return response;
    }

    public void jj() {
        try {
            System.out.println("开始发送");
            UserBean smsUtils = new UserBean();
            SendSmsResponse response = smsUtils.sendSms(user.getUserTel());
        } catch (ClientException e) {
            e.printStackTrace();
        }
    }

    private Users user = new Users();
    private String dateString;
    private Useridentity usd = new Useridentity();

    public String getDateString() {
        return dateString;
    }

    public void setDateString(String dateString) {
        this.dateString = dateString;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public String isRegister() throws ParseException {
        //把字符串类型转化成date类型
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        //按照格式传入转换成date型
        Date date = new java.sql.Date(sdf.parse(dateString).getTime());
        user.setUserBirtnday(date);
        usd.setUserId(user.getUserId());
        usd.setUserStatue1(0);
        usd.setUserStatue2(0);
        UserServiceImpl uss = new UserServiceImpl();
        int flag = uss.saveUser(user);
        usd.setUserId(user.getUserId());
        usd.setUserStatue1(0);
        usd.setUserStatue2(0);
        int flag1 = uss.saveuseridentity(usd);
        int flag2=0;
      System.out.println("你好这是flag2:"+flag2);
           //判断输入验证码是否与发送验证码一致  
          System.out.println("这是另一个flag4L"+codetemp);
          if(codetemp.equals(valid)){
              System.out.println("这是另一个flag2L"+valid);
              flag2=1;       
          }
        if (flag == 1 && flag1 == 1&& flag2==1) {
            System.out.println("你好这是78s878a754");
            return "registerSuccess";
        } else {
            return "registerFailed";
        }
    }

}

package com.example.api.webapi.utils;

import org.springframework.stereotype.Component;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.util.Base64;

@Component
public class JwtUtil{
    //默认head
    public static final String DEFAULT_HEADER = "{\"alg\":\"HS256\".\"typ\":\"JWT\"}";
    //HmacSHA256加密算法 密钥
    public static final String SECRET = "12345";

    //tocken有效时间 1天
    public static final long EXPIRE_TIME = 1000*60*24;
    //tocken在header中的名字
    public static final String HEADER_TOKEN_NAME = "Authorization";

    //Base64URL编码
    public static String enCode(String input){
        return Base64.getUrlEncoder().encodeToString(input.getBytes());
    }

    public static void main(String[] args) throws UnsupportedEncodingException {
        System.out.println(dnCode("12345"));
    }

    //Base64URL解码
    public static String dnCode(String input) throws UnsupportedEncodingException {
       return new String(Base64.getUrlDecoder().decode(input.toString().replace("\r\n", "")),"utf-8");
    }

    //HmacSHA256 加密算法

    /**
     *
     * @param data 要加密的数据
     * @param secret 秘钥
     * @return 加密后字符串
     */
    public static String HMACSH256(String data,String secret){
        StringBuilder stringBuilder = new StringBuilder();
        try {
            Mac sha256_HMAC = Mac.getInstance("HmacSHA256");
            SecretKeySpec secret_key = new SecretKeySpec(secret.getBytes(), "HmacSHA256");
            sha256_HMAC.init(secret_key);
            byte[] bytes = sha256_HMAC.doFinal(data.getBytes("UTF-8"));

            for (byte item : bytes){
                stringBuilder.append(Integer.toHexString((item&0XFF)|0x100),1,3);
            }
        } catch (Exception e) {
            System.out.println("Error HmacSHA256 ===========" + e.getMessage());
        }
        return stringBuilder.toString().toUpperCase();
    }

    //获取签名
    public static String getSignature(String playLoad){
        String result = "";
        try {
            result = HMACSH256(enCode(DEFAULT_HEADER)+"."+enCode(playLoad),SECRET);
        }catch (Exception e){
            System.out.println("Error getSignature ==========="+e.getMessage());
        }
    return result;
    }

    public static String testJwt(String jwt) throws UnsupportedEncodingException {
        String[] jwts = jwt.split("\\.");

        //验证签名
        if (!HMACSH256(jwts[0]+"."+jwts[1],SECRET).equals(jwts[2])){
            return null;
        }
        //验证头部消息
        if (!jwts[0].equals(enCode(DEFAULT_HEADER))){
            return null;
        }
        return dnCode(jwts[1]);
    }

}

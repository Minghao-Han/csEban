package com.AAA.csEban.Utils;


import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

public class JwtUtils {
    //token到期时间30分钟(根据需求改)
    private static final long EXPIRE_TIME= 2*24*60*60*1000;
    //密钥 (随机生成,可以从网上找到随机密钥生成器)
    private static final String TOKEN_SECRET="MD9**+4MG^EG79RV+T?J87AI4NWQVT^&";
    /** 生成token */
    public static String generateJwt(int id,String userRole){
        String token=null;
        try {
            Date expireAt=new Date(System.currentTimeMillis()+EXPIRE_TIME);
            token = JWT.create()
                    //发行人
                    .withIssuer("auth0")
                    //存放数据
                    .withClaim("role",userRole)
                    .withClaim("id",id)
                    //过期时间
                    .withExpiresAt(expireAt)
                    .sign(Algorithm.HMAC256(TOKEN_SECRET));
        } catch (IllegalArgumentException | JWTCreationException je) {}
        return token;
    }

    /** token验证 */
    public static JwtVerifyResult verifyJwt(String token){
        try {
            //创建token验证器
            JWTVerifier jwtVerifier=JWT.require(Algorithm.HMAC256(TOKEN_SECRET)).withIssuer("auth0").build();
            DecodedJWT decodedJWT=jwtVerifier.verify(token);
//            System.out.println("认证通过：");
//            System.out.println("id: " + decodedJWT.getClaim("id").asInt());
//            System.out.println("过期时间：" + decodedJWT.getExpiresAt());
            return new JwtVerifyResult(true,decodedJWT.getClaim("role").asString());
        } catch (IllegalArgumentException | JWTVerificationException e) {
            //抛出错误即为验证不通过
            return new JwtVerifyResult(false,null);
        }
    }

    public static boolean IdPermissionCheck(String token,int user_id){//验证用户权限，避免操作别人的页面
        JWTVerifier jwtVerifier=JWT.require(Algorithm.HMAC256(TOKEN_SECRET)).withIssuer("auth0").build();
        DecodedJWT decodedJWT=jwtVerifier.verify(token);
        if ((decodedJWT.getClaim("id").asInt()).equals(user_id)) return true;
        else return false;
    }
    public static int getUserIdFromToken(String token){
        try {
            //创建token验证器
            JWTVerifier jwtVerifier=JWT.require(Algorithm.HMAC256(TOKEN_SECRET)).withIssuer("auth0").build();
            DecodedJWT decodedJWT=jwtVerifier.verify(token);
            return decodedJWT.getClaim("id").asInt();
        } catch (IllegalArgumentException | JWTVerificationException e) {
            //抛出错误即为验证不通过
            return 0;
        }
    }
}

@Data
@AllArgsConstructor
class JwtVerifyResult{
    boolean validate;
    String userRole;
}

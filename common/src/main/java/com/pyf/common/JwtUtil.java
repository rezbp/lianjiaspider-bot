package com.pyf.common;


import io.jsonwebtoken.*;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JwtUtil {


    public static final String priKey = "pyfsadsadasdewqewqewqewqewqe2123231wqd";
    public static final String pubKey = "sadsa233";

    public static String getToken(String uid, int exp) {
        Long endTime = System.currentTimeMillis() + 1000 * 60 * exp;
        Map claims = new HashMap();
        claims.put("uid",uid);
        return Jwts.builder().setHeaderParam("typ","jwt")
                .setHeaderParam("alg","HS256")
                .setExpiration(new Date(endTime))
                .setClaims(claims)
                .signWith(SignatureAlgorithm.RS512,priKey)
                .compact();
    }


    public static String checkTokenAndGetInf(String token) {
        Claims claims= null;
        try {
             claims = Jwts.parser().setSigningKey(priKey).parseClaimsJws(token).getBody();
        } catch (ExpiredJwtException e) {
            e.printStackTrace();
        } catch (UnsupportedJwtException e) {
            e.printStackTrace();
        } catch (MalformedJwtException e) {
            e.printStackTrace();
        } catch (SignatureException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
        return ((String) claims.get("uid"));
    }
}

package com.siwei.frame.common.utils.util;

import com.alibaba.fastjson.JSON;
import com.siwei.frame.common.utils.entity.User;
import com.siwei.frame.common.utils.helper.GlobalConstant;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.joda.time.DateTime;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.security.Key;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

public class JWTUtil {
	
	private static Key getKeyInstance() {
		// Base64编码后的secretKey
		byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(GlobalConstant.JWT_SALT);
        Key secretKey = new SecretKeySpec(apiKeySecretBytes, SignatureAlgorithm.HS256.getJcaName());
        return secretKey;
    }
	
	public static String generateJwt(User userBean, Set<String> rolesSet, Set<String> permissionsSet) {
		// 设置失效时间
        DateTime expirationDate = new DateTime().plusDays(1);
        
        // Claims是需要保存到token中的信息，可以自定义，需要存什么就放什么，会保存到token的payload中
        Map<String, Object> claims = new HashMap<>();
        claims.put("user", JSON.toJSONString(userBean));
        claims.put("roles", JSON.toJSONString(rolesSet));
        claims.put("permissions", JSON.toJSONString(permissionsSet));
        claims.put("uuid", UUID.randomUUID().toString());
        String compactJws = Jwts.builder()
                .setSubject(userBean.getId().toString())
                .setExpiration(expirationDate.toDate())
                .setClaims(claims)
                .signWith(SignatureAlgorithm.HS256, getKeyInstance())
                .compact();
        return compactJws;
    }

	public static Map<String, Object> parseJwt(String jwt) {
        Map<String, Object> jwtClaims = Jwts.parser().setSigningKey(getKeyInstance()).parseClaimsJws(jwt).getBody();
        return jwtClaims;
	}
	
	public static Integer getUserId(String token) throws Exception {
		Map<String, Object> claims = parseJwt(token);
		String userJsonString = (String) claims.get("user");
		User user = JsonUtils.jsonToEntity(userJsonString, User.class);
		return user.getId();
	}
}

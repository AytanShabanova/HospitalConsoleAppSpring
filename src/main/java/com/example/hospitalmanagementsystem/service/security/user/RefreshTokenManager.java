package com.example.hospitalmanagementsystem.service.security.user;//package com.example.securitylesson.service.security;
//
//i
//import com.example.securitylesson.service.base.TokenReader;
//import io.jsonwebtoken.Claims;
//import io.jsonwebtoken.Jwts;
//import io.jsonwebtoken.SignatureAlgorithm;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.stereotype.Component;
//
//import java.util.Date;
//
//
//
//
//@Component
//@Slf4j
//@RequiredArgsConstructor
//public class RefreshTokenManager implements TokenGenerator<RefreshTokenDto>,
//        TokenReader<Claims>, EmailGetter {
//
//    private final SecurityProperties securityProperties;
//
//    @Override
//    public String generate(RefreshTokenDto obj) {
//        final UserEntity user = obj.getUser();
//
//        Claims claims = Jwts.claims();
//        claims.put("email", user.getEmail());
//        claims.put("role",user.getRole());
//        claims.put("type", "REFRESH_TOKEN");
//
//        Date now = new Date();
//        Date exp = new Date(now.getTime() + securityProperties.getJwt().getRefreshTokenValidityTime(obj.isRememberMe()));
//
//        return Jwts.builder()
//                .setSubject(String.valueOf(user.getId()))
//                .setIssuedAt(now)
//                .setExpiration(exp)
//                .addClaims(claims)
//                .signWith(PublicPrivateKeyUtils.getPrivateKey(), SignatureAlgorithm.RS256)
//                .compact();
//    }
//
//    @Override
//    public Claims read(String token) {
//        Claims tokenData = Jwts.parserBuilder()
//                .setSigningKey(PublicPrivateKeyUtils.getPublicKey())
//                .build()
//                .parseClaimsJws(token)
//                .getBody();
//
//        String typeOfToken = tokenData.get("type", String.class);
//
//        if (!"REFRESH_TOKEN".equals(typeOfToken)) {
//            throw new RuntimeException("Invalid type of token");
//        }
//
//        return tokenData;
//    }
//
//    @Override
//    public String getEmail(String token) {
//        return read(token).get(EMAIL_KEY, String.class);
//    }
//}

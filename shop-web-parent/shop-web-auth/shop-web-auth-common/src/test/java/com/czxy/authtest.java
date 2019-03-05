package com.czxy;

import com.czxy.auth.entity.UserInfo;
import com.czxy.auth.util.JwtUtils;
import com.czxy.auth.util.RsaUtils;
import org.junit.Before;
import org.junit.Test;

import java.security.PrivateKey;
import java.security.PublicKey;

/**
 * @Author: 天子笑
 * @Date: 2019-03-05 10:58
 */
public class authtest {

        private static final String pubKeyPath = "D:\\rsa\\rsa.pub";

        private static final String priKeyPath = "D:\\rsa\\rsa.pri";

        private PublicKey publicKey;

        private PrivateKey privateKey;

        @Test
        public void testRsa() throws Exception {
            RsaUtils.generateKey(pubKeyPath, priKeyPath, "234");
        }

        @Before
        public void testGetRsa() throws Exception {
            this.publicKey = RsaUtils.getPublicKey(pubKeyPath);
            this.privateKey = RsaUtils.getPrivateKey(priKeyPath);
        }

        @Test
        public void testGenerateToken() throws Exception {
            // 生成token
            String token = JwtUtils.generateToken(new UserInfo(20, "jack"),
                    privateKey, 5);
            System.out.println("token = " + token);
        }

        @Test
        public void testParseToken() throws Exception {
            String token = "eyJhbGciOiJSUzI1NiJ9.eyJpZCI6MjAsInVzZXJuYW1lIjoiamFjayIsImV4cCI6MTU1MTc1NjQzM30.VjWsRdyPPAZWoBD9Rar8EmAy8dqFFrjJEoJtLPvp1_9Mh0M-lGVCvYOny2QXQrXbPmW4f3UJ6XLKi9atPVcKbggDoReeUX91TFUlHS8HlTgk6o4reOOH318RflmtmltAcZ578ypuDQnghfTR0t4Rj6uGUg6EcV_2d3xu7dtx9bA";

            // 解析token
            UserInfo user = JwtUtils.getInfoFromToken(token, publicKey);
            System.out.println("id: " + user.getId());
            System.out.println("userName: " + user.getUsername());
        }
    }


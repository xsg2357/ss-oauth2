
获得授权码：
1.登录http://localhost:8080/ 

2.访问http://localhost:8080/oauth/authorize?client_id=client&response_type=code
选择APProve 确认Authorizeh

postman访问url：
http://client:secret@localhost:8080/oauth/token

授权码：
https://www.funtl.com/?code=mM7vtN

body类型：x-www-form-urlencoded

参数： grant_type=authorization_code code=mM7vtN

jdbc:
    ```aidl
        CREATE TABLE `clientdetails` (
          `appId` varchar(128) NOT NULL,
          `resourceIds` varchar(256) DEFAULT NULL,
          `appSecret` varchar(256) DEFAULT NULL,
          `scope` varchar(256) DEFAULT NULL,
          `grantTypes` varchar(256) DEFAULT NULL,
          `redirectUrl` varchar(256) DEFAULT NULL,
          `authorities` varchar(256) DEFAULT NULL,
          `access_token_validity` int(11) DEFAULT NULL,
          `refresh_token_validity` int(11) DEFAULT NULL,
          `additionalInformation` varchar(4096) DEFAULT NULL,
          `autoApproveScopes` varchar(256) DEFAULT NULL,
          PRIMARY KEY (`appId`)
        ) ENGINE=InnoDB DEFAULT CHARSET=utf8;
        
        CREATE TABLE `oauth_access_token` (
          `token_id` varchar(256) DEFAULT NULL,
          `token` blob,
          `authentication_id` varchar(128) NOT NULL,
          `user_name` varchar(256) DEFAULT NULL,
          `client_id` varchar(256) DEFAULT NULL,
          `authentication` blob,
          `refresh_token` varchar(256) DEFAULT NULL,
          PRIMARY KEY (`authentication_id`)
        ) ENGINE=InnoDB DEFAULT CHARSET=utf8;
        
        CREATE TABLE `oauth_approvals` (
          `userId` varchar(256) DEFAULT NULL,
          `clientId` varchar(256) DEFAULT NULL,
          `scope` varchar(256) DEFAULT NULL,
          `status` varchar(10) DEFAULT NULL,
          `expiresAt` timestamp NULL DEFAULT NULL,
          `lastModifiedAt` timestamp NULL DEFAULT NULL
        ) ENGINE=InnoDB DEFAULT CHARSET=utf8;
        
        CREATE TABLE `oauth_client_details` (
          `client_id` varchar(128) NOT NULL,
          `resource_ids` varchar(256) DEFAULT NULL,
          `client_secret` varchar(256) DEFAULT NULL,
          `scope` varchar(256) DEFAULT NULL,
          `authorized_grant_types` varchar(256) DEFAULT NULL,
          `web_server_redirect_uri` varchar(256) DEFAULT NULL,
          `authorities` varchar(256) DEFAULT NULL,
          `access_token_validity` int(11) DEFAULT NULL,
          `refresh_token_validity` int(11) DEFAULT NULL,
          `additional_information` varchar(4096) DEFAULT NULL,
          `autoapprove` varchar(256) DEFAULT NULL,
          PRIMARY KEY (`client_id`)
        ) ENGINE=InnoDB DEFAULT CHARSET=utf8;
        
        CREATE TABLE `oauth_client_token` (
          `token_id` varchar(256) DEFAULT NULL,
          `token` blob,
          `authentication_id` varchar(128) NOT NULL,
          `user_name` varchar(256) DEFAULT NULL,
          `client_id` varchar(256) DEFAULT NULL,
          PRIMARY KEY (`authentication_id`)
        ) ENGINE=InnoDB DEFAULT CHARSET=utf8;
        
        CREATE TABLE `oauth_code` (
          `code` varchar(256) DEFAULT NULL,
          `authentication` blob
        ) ENGINE=InnoDB DEFAULT CHARSET=utf8;
        
        CREATE TABLE `oauth_refresh_token` (
          `token_id` varchar(256) DEFAULT NULL,
          `token` blob,
          `authentication` blob
        ) ENGINE=InnoDB DEFAULT CHARSET=utf8;
    ```
    
Encoded password does not look like BCrypt
解决方法：
重新生成client_secret：$2a$10$OUxrM5gyxK.HqBAkb5AaseoDjWxACKZnFl8nSyW9j5RY4r5lAA1Ly
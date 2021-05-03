#!/usr/bin/env bash
create-jdbc-connection-pool --datasourceclassname com.mysql.jdbc.jdbc2.optional.MysqlDataSource --restype javax.sql.DataSource --property user=root:password=password:DatabaseName=delivery:ServerName=172.17.0.1:port=3306:url=jdbc\:mysql\://172.17.0.1\:3306/delivery:allowPublicKeyRetrieval=true:useSSL=false fooddeliverycms_pool
create-jdbc-resource --connectionpoolid fooddeliverycms_pool jdbc/fooddeliverycms

create-jms-resource --restype javax.jms.TopicConnectionFactory --property addressList='172.17.0.2\:7676' --description "connection factory for knockknock messaging" jms/KkCon
create-jms-resource --restype javax.jms.Topic jms/kkNewUserAccountCreatedTopic

deploy --name=cms deployments/food-delivery-ms-0.0.1.war

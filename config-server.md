spring:
  application:
    name: config-service
  cloud:
    config:
      server:
        git:
          uri: https://github.com/prabhu-sunderaraman/may-21-30-2021.git
          default-label: main

server:
  port: 8888

management:
  endpoints:
    web:
      exposure:
        include: '*'
 
eureka:
  client:
    service-url:
      defaultZone: http://localhost:8761/eureka
  instance:
    prefer-ip-address: true

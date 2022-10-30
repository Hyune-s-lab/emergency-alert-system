# emergency-alert-system

![image](https://user-images.githubusercontent.com/55722186/198864691-7d7ab0f1-58e7-4f22-b310-d154f77d8a5c.png)

### Environment

- spring boot, kotlin, multi-module, webflux
- mysql, docker

### Feature

- send message
    - slack

### How to run

- docker 로 local 실행 `./run_local.sh`
- mysql 접속 `jdbc:mysql://localhost:3306/emergency-alert-system`
- swagger 접속 [Link](http://localhost:8080/webjars/swagger-ui/index.html)

---

## Phase 1

### 초기 세팅

- multi-module 세팅
    - admin-module, slack-module
- kotest 세팅
- jpa 세팅

### slack 으로 메시지 전송

- by webhook

### docker-compose setting

- `run_local.sh` 명령 실행만으로 local 기동 가능

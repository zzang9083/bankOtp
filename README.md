# 목차
- [0. 프로젝트 목표](#프로젝트목표)
- [1. 개발환경](#개발환경)
- [2. 설계](#설계)
- [3. 과제기능 요구사항](#과제기능-요구사항)
- [4. 추가요건 문제해결 전략](#추가요건-문제해결-전략)

# 프로젝트 목표

### 1. JPA를 활용한 프로그램 설계 및 개발
1-1. 인터넷 강의를 통해 학습한 JPA 기반의 도메인 및 프로그램 설계, 데이터 접근을 위한 SPRING DATA JPA를 실습한다.

1-2. 은행, 금융결제원(기관)을 각기 다른 프로젝트로 구성하여 개발한다.

### 2. 전문통신 방식 -> REST API 방식 
2-1. 기관간 통신 표준이였던 전문통신 방식을 REST API 방식으로 변경하여 구현한다.
     (AS-IS) XML로 전문 데이터, 통신 인터페이스를 정의, 은행에서 제공하는 대외거래 인터페이스를 통해 기관간에 통신한다.
     (TO-BE) SPRING WEBCLIENT를 표준으로 외부(금결원)와 API 통신하는 방식으로 구현한다.

2-2. 개발 기술의 한계로 앱 단의 구현은 제외. 뱅킹APP에서의 동작 POSTMAN을 통한 API 요청으로 앱의 동작을 대체한다.

### 3. 표준화된 통신 구조를 설계
3-1. 외부 요청을 위한 객체를 표준화 한다.
     : HOST, PATH, HEADER, BODY를 정의한 정형화된 요청 클래스를 정의 
     
3-2. 외부와 통신하는 추상 클래스를 정의하여, 재사용 가능한 외부 통신 모듈(템플릿 메서드 패턴을 도입)을 설계, 개발한다.
     : 요청 객체를 조립하는 추상 메소드 선언하여 상속받은 클래스에서 이를 구현하도록 함.
     : http method별(get, post, delete...)로 공통 메소드를 정의. 요청을 수행하는 Client 객체에서 외부통신하는 객체를 주입받아 용도에 맞게 메소드를 호출.   

3-3. 기관 통신에 필요한 공통부와 기관 표준에 입각한 상수를 정의한다.
     : 코드로 정의된 응답코드, 거래구분코드, 전문종별코드 등을 상수로 관리하여 개발 시, 직관적인 형태로 개발효율을 높인다. 

# ModernWebApp

<br>

## 실전! 스프링 부트와 리액트로 시작하는 모던 웹 애플리케이션 개발 中

Chapter 4: 스프링 부트로 RESTful 웹 서비스 만들기 ~ Chapter 5: 백엔드 보호 및 테스트

<br>

## 프로젝트 설명

백엔드로 CRUD 구현 + Spring Security + JWT 인증방식(Bearer)

<br>

### ▫️ 배운 것
* __Application__ 에서 `CommandLineRunner` 상속받아 run 메서드 안에 값을 넣어 __초기값__ 만들기 <br>
* __Controller__ 에서 `ResponseEntity<?>` 반환값을 이용해 __헤더에 토큰값__ 넣어주기
* __JWT__ 를  `Jwts.builder()` 형태로 만들고, `Jwts.parserBuilder()` 형태로 __검증하기__ 
* __UserDetailsService__ 사용자 이름을 불러오기
* __Authentication__ 유저 정보, 권한이 담겨있다.
* __AuthenticationManager__ 유저 정보, 권한 불러오기
* __AuthenticationEntryPoint__ 상속받아서 __인증 실패시__ 커스터마이징 할 수 있다. <br>
  적용 방법은 __SecurityFilterChain__ 메서드에서 `http.authenticationEntryPoint()` 안에 담아두기
* __CorsConfigurationSource__ HTTP 요청에 대해 사용자 인증 정보를 포함하지 않도록 설정
  

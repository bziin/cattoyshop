# cattoyshop
SpringSecurity와 JPA를 이용한 온라인 쇼핑몰

----
## 프로젝트 소개


CATSTOY 프로젝트를 수행하면서 어려웠던 부분은 Spring Security와 JPA를 사용하는 과정이었습니다. 
Spring Security를 적용하면서 사용자 및 권한 관리에 대한 복잡성과 보안 측면에서의 책임감을 느꼈습니다. 
사용자 인증 및 권한 부여의 로직을 구현하고 관리자와 사용자 간의 차별화된 권한을 효과적으로 다루는 것은 새로운 도전이었습니다.

또한, JPA를 사용하여 데이터베이스와 상호작용하면서 객체-관계 매핑, 연관 관계 관리 및 쿼리 작성에 대한 이해를 높이는 데 어려움을 겪었습니다. 
특히, 동적 쿼리 작성 및 복잡한 데이터 모델을 다루는 것이 새로웠습니다. 
그러나 이러한 어려움을 극복하고 끊임없이 학습하면서 프로젝트를 완성하는 과정이 큰 성취감을 주었습니다.

----
### 개발기간
- 2023.07.01 ~ 2023.09.10
  
### 개발환경
-    ```Java11```   ```SpringBoot``` , gradle, JPA
  
- Html, CSS, JavaScript, Thymeleaf, BootStrap
- IDE: IntelliJ Ultimate
- DataBase: MySQL, MySQL Workbench

----

### 기능소개

-ERD

<img src= "https://user-images.githubusercontent.com/107683186/278924552-77a60f73-5c0f-46a7-8232-99b543209831.JPG" width=90%></img>

<img src = "https://user-images.githubusercontent.com/107683186/278924456-53666e53-67dc-44c3-9261-006e1959d2b0.JPG" width=90%></img>

---
#### Cache 적용
Cache란, 한번 처리한 데이터를 임시로 저장소에 저장하는 것으로,
반복적으로 데이터를 불러오는 경우에, 지속적으로 DBMS 혹은 서버에 요청하는 것이 아니라 Memory에 데이터를 저장하였다가 불러다 쓰는 것을 의미함.

- Item조회 기능에 적용
  <적용 전>
  
  <img src= "https://user-images.githubusercontent.com/107683186/282390559-8f5cd6ca-6ee3-4d21-a369-66c533397823.JPG" width=40%></img>
  
  <적용 후>
  
  <img src = "https://user-images.githubusercontent.com/107683186/282390549-7f89c4e9-92c3-41d6-b031-e2a7b9171b0a.JPG" width=40%></img>

 --- 


##### 메인화면
<img src= "https://user-images.githubusercontent.com/107683186/278924646-41b7ac94-f720-41c7-90fa-74e6cf0490f3.JPG" width=90%></img>

1.상단메뉴에서 로그인을 할 수 있고 검색이 가능하다.

2.관리자, 회원, 비회원에 따라 접근할 수 있는 상단바가 보여진다.

3.로그인페이지로 넘어가면서 사용자 회원가입이 가능하다.


   
##### 회원가입

<img src = "https://user-images.githubusercontent.com/107683186/278924839-19196a04-0012-464a-859f-eb968c11099f.JPG" width=90%></img>

1. 이름, 이메일, 비밀번호, 주소를 입력 받아 저장한다.   
2. 주소API를 이용해 주소를 입력할 수 있다.



   
##### 마이페이지

<img src = "https://user-images.githubusercontent.com/107683186/278924696-b2bb1ccf-1aa0-41da-9058-122a2454d9b1.JPG" width=90%></img>
1. 내 정보를 조회할 수 있다.   
2. 비밀번호 확인을 통해 수정이 가능하고 틀릴 시 실패 알림 창이 띄워진다.




##### 상품등록
<img src = "https://user-images.githubusercontent.com/107683186/278924710-3494fbbb-df0b-4b95-ab3d-b7a41dadecbd.JPG" width = 90%> </img>

1. 상품명, 상태, 가격,재고, 상세내용을 등록할 수 있다.   
2. 첨부파일 기능을 이용해 이미지를 저장할 수 있으며 메인페이지에 보여진다.


   
##### 상품상세

<img src ="https://user-images.githubusercontent.com/107683186/278924716-2b0da000-095d-4cb0-a02a-3d8418787e68.JPG" width=90% > </img>

1. 상품 상세페이지에서 상품등록내용을 조회할 수 있다.
2. 상품을 장바구니에 담을 수 있고 주문할 수 있으며 재고 부족 시 주문취소 알림창이 띄워진다.




   
##### 상품관리

<img src ="https://user-images.githubusercontent.com/107683186/278924726-38fac4c7-9b17-4571-96d3-1ae8822bb193.JPG" width=90% ></img>
1. 상품 상세페이지에서 등록했던 상품들의 내용을 모두 조회할 수 있고 수정이 가능하다.
2. 기간, 판매상태, 상품명 으로 검색할 수 있다.





##### 구매이력,장바구니조회
<img src = "https://user-images.githubusercontent.com/107683186/278925462-6fe985ab-1677-4bf1-8070-75ee3fa4e1dd.JPG" width=90% > </img>
1. 주문했던 상품내역을 조회할 수 있고 주문을 취소할 수 있다.
2.  장바구니에 담았던 상품의 목록을 조회할 수 있고 주문할 수 있다.


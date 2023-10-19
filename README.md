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
- 2023.07.01 ~ 2023.09.07
  
### 개발환경
-    ```Java11```   ```SpringBoot``` , gradle, JPA
  
- Html, CSS, JavaScript, Thymeleaf, BootStrap
- IDE: IntelliJ Ultimate
- DataBase: MySQL, MySQL Workbench

### 기능소개

-ERD

<img src = "https://file.notion.so/f/f/13a56783-7604-415c-8d4c-d849d6bc8db1/99b371d6-e797-4687-b564-2c406a3e8810/Untitled.png?id=d8fb3db2-0898-4456-8222-7ff467999ad3&table=block&spaceId=13a56783-7604-415c-8d4c-d849d6bc8db1&expirationTimestamp=1697788800000&signature=9uvmcIkPuyc-t7gVElQzKsexBTd5NXwontZFUSEQMNA&downloadName=Untitled.png" width=90%></img>


<img src= "https://file.notion.so/f/f/13a56783-7604-415c-8d4c-d849d6bc8db1/17c8a053-6dae-4957-a2e1-180b8811024e/Screenshot_2023-10-19_at_14.29.26.jpg?id=754341d0-530a-42af-a0af-8c652bc34457&table=block&spaceId=13a56783-7604-415c-8d4c-d849d6bc8db1&expirationTimestamp=1697788800000&signature=vKH_iRkSOnYZ88I9J34NVuq1auLZi5q5GChAUm1Efns&downloadName=Screenshot+2023-10-19+at+14.29.26.JPG.jpg" width=90%></img>


##### 메인화면
<img src= "https://file.notion.so/f/f/13a56783-7604-415c-8d4c-d849d6bc8db1/d4c223cd-fb14-49ae-9c59-4214bb2c4696/Untitled.png?id=2414b950-1267-4124-a91f-0e240c7e9e64&table=block&spaceId=13a56783-7604-415c-8d4c-d849d6bc8db1&expirationTimestamp=1697788800000&signature=KhEsWif_yKSLVpSDB_SuAhm4czTNPUSIlIZ4hvu3Sio&downloadName=Untitled.png" width=90%></img>

1.상단메뉴에서 로그인을 할 수 있고 검색이 가능하다.

2.관리자, 회원, 비회원에 따라 접근할 수 있는 상단바가 보여진다.

3.로그인페이지로 넘어가면서 사용자 회원가입이 가능하다.


   
##### 회원가입

<img src = "https://file.notion.so/f/f/13a56783-7604-415c-8d4c-d849d6bc8db1/adb4c20b-f95a-4328-8299-a0ab80119211/Untitled.png?id=041f1747-4568-48af-8da7-9a10abfb4c31&table=block&spaceId=13a56783-7604-415c-8d4c-d849d6bc8db1&expirationTimestamp=1697788800000&signature=HuytOmB3Hk5DjUZ3AaM-dy8vwawMLwl9ahrX4YFGOQY&downloadName=Untitled.png " width=90%></img>

1. 이름, 이메일, 비밀번호, 주소를 입력 받아 저장한다.   
2. 주소API를 이용해 주소를 입력할 수 있다.



   
##### 마이페이지

<img src = "https://file.notion.so/f/f/13a56783-7604-415c-8d4c-d849d6bc8db1/80e66ace-f82f-4862-8d79-a3c75c74947c/Untitled.png?id=8088a34a-450c-4cb4-9bb1-adfc11ddc98e&table=block&spaceId=13a56783-7604-415c-8d4c-d849d6bc8db1&expirationTimestamp=1697788800000&signature=CZC3FwQm2T2AO9c1zn6GK3uEzyOoHZ8MkIUzHijpbsY&downloadName=Untitled.png" width=90%></img>
1. 내 정보를 조회할 수 있다.   
2. 비밀번호 확인을 통해 수정이 가능하고 틀릴 시 실패 알림 창이 띄워진다.




##### 상품등록
<img src = "https://file.notion.so/f/f/13a56783-7604-415c-8d4c-d849d6bc8db1/ed897bcb-cae9-4531-a547-7225ee697c0c/Untitled.png?id=9e4de4d9-ff95-4bde-be67-e86526a1ef49&table=block&spaceId=13a56783-7604-415c-8d4c-d849d6bc8db1&expirationTimestamp=1697788800000&signature=38jjTR0Qxrsou7twRNpDb1zxiF6BqfJGbT1VClou5N4&downloadName=Untitled.png" width = 90%> </img>

1. 상품명, 상태, 가격,재고, 상세내용을 등록할 수 있다.   
2. 첨부파일 기능을 이용해 이미지를 저장할 수 있으며 메인페이지에 보여진다.


   
##### 상품상세

<img src ="https://file.notion.so/f/f/13a56783-7604-415c-8d4c-d849d6bc8db1/f1da9028-fd49-4e78-84be-490ba81a2b7e/Untitled.png?id=b889cfe2-7dc0-4d67-b1d6-1ab73151c362&table=block&spaceId=13a56783-7604-415c-8d4c-d849d6bc8db1&expirationTimestamp=1697788800000&signature=G0bwMguJUZcLihqWMntFoEdYU7lqUwCw7ldmV3j-gSc&downloadName=Untitled.png" width=90% > </img>

1. 상품 상세페이지에서 상품등록내용을 조회할 수 있다.
2. 상품을 장바구니에 담을 수 있고 주문할 수 있으며 재고 부족 시 주문취소 알림창이 띄워진다.




   
##### 상품관리

<img src ="https://file.notion.so/f/f/13a56783-7604-415c-8d4c-d849d6bc8db1/683e7288-a79d-4724-8bdf-5afde2807358/Untitled.png?id=5397d16d-9556-4de8-a765-6c3ee4a3389f&table=block&spaceId=13a56783-7604-415c-8d4c-d849d6bc8db1&expirationTimestamp=1697788800000&signature=HRYfC9V-ZGfHqn5yyUCkoUD1YoXG2ui0ZweDn2XYm-I&downloadName=Untitled.png" width=90% ></img>
1. 상품 상세페이지에서 등록했던 상품들의 내용을 모두 조회할 수 있고 수정이 가능하다.
2. 기간, 판매상태, 상품명 으로 검색할 수 있다.





##### 구매이력,장바구니조회
<img src = "https://file.notion.so/f/f/13a56783-7604-415c-8d4c-d849d6bc8db1/0ada8c0f-93d7-4018-ace5-0f9751a63f70/Untitled.png?id=c49cf619-2580-4a94-a160-8820525967ca&table=block&spaceId=13a56783-7604-415c-8d4c-d849d6bc8db1&expirationTimestamp=1697788800000&signature=9LSsxa6oe_UMUuhIceAxblw1KGSqejeRJcmY-_jXxYI&downloadName=Untitled.png" width=90% > </img>
1. 주문했던 상품내역을 조회할 수 있고 주문을 취소할 수 있다.
2.  장바구니에 담았던 상품의 목록을 조회할 수 있고 주문할 수 있다.


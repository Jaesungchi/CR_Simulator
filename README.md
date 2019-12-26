# 수강신청 시뮬레이터 :desktop_computer:

------

## ![imge](https://img.shields.io/badge/ProjectType-TeamProject-green) ![imge](https://img.shields.io/badge/Language-Jav-yellow) ![imge](https://img.shields.io/badge/Tools-Eclipse-blue)

## 프로그램 소개 :thumbsup:

대학 생활을 하면서 느낀 수강신청의 불편함을 해결하기 위해 만든 수강신청 시뮬레이터 입니다.
검색 구분의 범위가 넓어 원하는 강의에 한번에 접근하기 어려운 것과 겹치는 시간대를 일일이 확인해야하는 불편함등 다양한 불편함을 해결하였습니다.

MVC 패턴을 적용하여 개발 하였습니다.

싱글턴기법을 적용하였습니다.

확장성을 생각해 세종대학교의 강의계획표를 넣으면 사용할 수 있게 만들었습니다.

### 2019-12-26

서버와 연결을 하여 실제 수강신청 프로그램을 제작중입니다.

------

## 프로그램 UML 구조 :building_construction:

![image](https://user-images.githubusercontent.com/37828448/70433255-8e356e80-1ac4-11ea-8773-97d0aedee1ae.png)

------

## 프로그램 기능소개

기능은 크게 
관심과목 담기 (관심가는 과목을 담을 수 있으며 수강신청 학점에 제한이 없음.)

수강신청 (실제 수강신청과 동일하게 24학점 까지만 신청이 가능함)

시간표보기 (실제 수강신청한 과목의 시간표를 볼 수 있음)

학점계산 (실제 수강신청한 과목을 바탕으로 평점을 계산할 수 있음)

이 있다.

### 메인화면

![image](https://user-images.githubusercontent.com/37828448/71304941-7a690100-2410-11ea-91ba-ce5276d53f18.png)

- 메인화면으로 엑셀파일을 불러오며 각 화면으로 이동 가능.
- 엑셀파일은 apache library를 활용해 읽음.

### 수강신청 필터

![image](https://user-images.githubusercontent.com/37828448/71304999-1b57bc00-2411-11ea-9d2c-2d038c05a9f2.png)

- 각 필터를 적용시켜 원하는 과목만 읽어올 수 있음.

### 수강신청

![image](https://user-images.githubusercontent.com/37828448/71305021-6540a200-2411-11ea-9404-bb0064e27522.png)

- 실제 수강신청과 동일하게 정보 제공
- 자신이 신청한 과목과 동일한 과목이거나, 시간이 겹치는 경우 빨간색 글씨로 신청이 불가능한 것을 표현. (신청을 누르면 에러 메세지가 뜸)

### 시간표 보기

![image](https://user-images.githubusercontent.com/37828448/71305039-a20c9900-2411-11ea-8ff8-ce7e5b4c6246.png)

- 자신의 수강신청한 과목을 바탕으로 시간표를 볼 수 있습니다.

### 학점 계산기

![image](https://user-images.githubusercontent.com/37828448/71305049-b3ee3c00-2411-11ea-8d29-09adaea6d737.png)

- 수강신청한 과목을 바탕으로 학점을 계산해 줌. 추가로 적을 수 있다.

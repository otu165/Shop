# Wanna Shop?

> Toy Project to improve basic skills

Android Studio 의 Layout, View, Fragment 의 사용법을 익히고 Firebase 사용에 익숙해지고자 제작한 어플리케이션 입니다.

<br/>

## 개발 기간
2020.10.24 ~ 2020.11.09

<br/>

## Screen Shot
### 1. main
<div>
<img src="https://user-images.githubusercontent.com/55652161/98562423-67dc0c80-22ed-11eb-912b-7356cefb259a.png" width="200">
<img src="https://user-images.githubusercontent.com/55652161/98562429-6874a300-22ed-11eb-8427-21f57de301b9.png" width="200">
<img src="https://user-images.githubusercontent.com/55652161/98562434-69a5d000-22ed-11eb-8dd4-d890af14fdab.png" width="200">
<img src="https://user-images.githubusercontent.com/55652161/98562440-6ad6fd00-22ed-11eb-9cee-e6de0e8e464a.png" width="200">
</div>

- Toolbar + Fragment + BottomNavigationView
- 유튜브 플레이어는 실제 핸드폰에서 정상적으로 동작함을 확인했다.

<br />

### 2. category
<div>
<img src="https://user-images.githubusercontent.com/55652161/98562445-6b6f9380-22ed-11eb-9568-f3245e99a202.png" width="220">
<img src="https://user-images.githubusercontent.com/55652161/98562450-6ca0c080-22ed-11eb-8547-c67a40fd571a.png" width="220">
</div>

- 가.
	- DrawerLayout 을 사용하여 NavigationView 를 추가했다.
	- Service는 action intent 를 사용하여 각각 통화와 메일로 넘어가게 구현했다.
- 나.
	- TabLayout + ViewPager 
	- RecyclerView 의 아이템으로 CardView 이용, ItemDecoration 을 주었다.

<br/>

### 3. store
<div>
<img src="https://user-images.githubusercontent.com/55652161/98563415-7ecf2e80-22ee-11eb-8738-9464c5c74014.png" width="220">
<img src="https://user-images.githubusercontent.com/55652161/98563420-80005b80-22ee-11eb-9d06-1a0d3fca0a7a.png" width="220">
<img src="https://user-images.githubusercontent.com/55652161/98564948-5811f780-22f0-11eb-9a24-be8d0f187956.png" width="220">
</div>

 - TabLayout + ViewPager
 - ScrollView 하단에 CheckedTextView 와 버튼을 고정시켰다.

<br/>

## 시연 영상
<div>
<img src="https://user-images.githubusercontent.com/55652161/98565872-788e8180-22f1-11eb-9f1b-ae9630ede007.gif" width="200">
<img src="https://user-images.githubusercontent.com/55652161/98565882-7c220880-22f1-11eb-8045-4689aed7123b.gif" width="200">
<img src="https://user-images.githubusercontent.com/55652161/98566350-ffdbf500-22f1-11eb-987c-d1444866e745.gif" width="200">
<img src="https://user-images.githubusercontent.com/55652161/98565889-7d533580-22f1-11eb-8ac1-7afd3a35c21e.gif" width="200">
</div>

- 왼쪽에서부터 순서대로 메인 화면, 북마크, 리뷰 작성, 계정 삭제 기능 시연이다.

<br/>

## 개발 환경
- Android Studio 4.1
- Cloud Firestore of Firebase

<br/>

# JPEG 확장을 통한 멀티콘텐츠 카메라 솔루션<br>(One PIC All in JPEG)
> One PIC All in JPEG은 멀티 콘텐츠를 담을 수 있는 새로운 형태의 All in JPEG 구현과<br>
> Multi Focus 촬영 및 다양한 편집 기능을 탑재한 카메라 솔루션이다.

<br><br>
<p align="center"><img src="https://github.com/HINAPIA/OnePIC/assets/86238720/9f34fadc-7508-42b5-b40c-ee622151beea.png" width="90" height="90"/></p>


<div align = "center">
  
 ## OnePIC
  [![Generic badge](https://img.shields.io/badge/version-1.1.5-green.svg)](https://play.google.com/store/apps/details?id=com.goldenratio.onepic)

</div>

<p align="center">새로운 파일 포맷 All in JPEG을 기반으로한<br>Multi Focus 촬영 및 다양한 편집이 가능한 카메라 앱</p>


## Installation
<a href="https://play.google.com/store/apps/details?id=com.goldenratio.onepic">Google Playstore</a><br>

## Screenshot
<!-- <p align="center"><img src="https://github.com/HINAPIA/OnePIC/assets/86238720/ebab0094-c5a1-4915-9f67-439ba1145bf2.png" width="580" height="350"/></p>
<p align="center"><img src="https://github.com/HINAPIA/OnePIC/assets/86238720/09365a10-67c5-4780-91be-ee1612dec8a3.png" width="700" height="400"/></p>
<p align="center"><img src="https://github.com/HINAPIA/OnePIC/assets/86238720/01ffa5ce-5ff0-4a6a-89fc-015c4b66b3cd.png" width="700" height="400"/></p>  -->

![Group 2062](https://github.com/HINAPIA/OnePIC/assets/109158497/228b07b2-c1cd-4654-8358-19fb88452a3b)<br>
![Group 2064](https://github.com/HINAPIA/OnePIC/assets/109158497/46d28351-2936-4bcc-b67c-e9c0b0e56c83)<br>
![Group 2063](https://github.com/HINAPIA/OnePIC/assets/109158497/2114d035-bcf6-44ca-a0e5-e7e98f3ff261)

<br><br>

## :pencil2: 작품 소개
### &nbsp;1.&nbsp;&nbsp;개발 배경
<div>
&nbsp;&nbsp;오늘날, 인스타그램, 페이스북 등 사진을 통해 일상을 공유하는 다양한 SNS가 활성화되면서 언제 어디서나 쉽게 사진을 촬영할 수 있는 스마트폰 카메라의 활용이 높아지고 있다. 또한, 스마트폰 카메라로부터 더 좋은 사진을 얻으려는 사용자들의 욕구가 커짐에 따라 카메라 성능과 카메라 앱의 기술이 빠르게 발전하고 있다. 하지만, 이러한 발전에도 불구하고, 사진을 촬영할 때, 카메라의 초점과 관련된 어려움은 여전히 해결되지 않고 있다. 초점과 관련된 구체적인 문제를 제시하면 다음과 같다.<br><br>
&nbsp;&nbsp;&nbsp;&nbsp;첫째, 촬영자가 초점에 대한 개념 없이 사진을 촬영하는 문제<br>
&nbsp;&nbsp;&nbsp;&nbsp;둘째, 움직이는 피사체를 촬영할 때 원하는 지점에 초점을 맞추기 어렵다는 문제<br>
&nbsp;&nbsp;&nbsp;&nbsp;셋째, 현재 스마트폰 카메라 기술 수준의 본질적인 한계로서, 여러 피사체 중 한 개에만 초점이 주어질 수밖에 없는 문제<br>
&nbsp;&nbsp;&nbsp;&nbsp;넷째, 원하는 피사체에 초점이 맞지 않게 촬영된 사진에 대해 사후에 초점을 맞추는 것이 불가능하다는 문제<br><br>
&nbsp;&nbsp;이처럼 원하는 곳에 초점을 맞추기 어렵고, 이미 촬영된 사진의 초점을 원하는 곳으로 바꿀 수 없어, 사진에 아쉬움이 남는 초점과 관련된 문제를 해결하기 위해서는 사용자가 초점을 맞추지 않아도 촬영 후 원하는 곳에 초점이 맞춰진 사진을 얻을 수 있는 솔루션이 필요하다.<br>
&nbsp;&nbsp;따라서 본 팀은 한 번의 촬영으로 초점이 여러 곳에 자동으로 맞춰진 이미지들을 촬영하고, 촬영된 사진에서 사용자가 원하는 곳으로 사진의 초점을 변경할 수 있는 카메라 솔루션과 이 기술을 안드로이드 상에서 구현한 OnePIC 이라는 카메라 앱을 개발하였다.
</div><br><br>

### &nbsp;2.&nbsp;&nbsp;개발 목적<br>

- **사진에 여러 데이터를 담을 수 있는 새로운 All in JPEG 포맷 설계 및 구현**<br>
&nbsp;기존의 JPEG 포맷을 확장하여 대표 사진 외에도 여러 장의 사진, 오디오, 텍스트와 같은 데이터를 담을 수 있는 새로운 형태의 All in JPEG 포맷을 설계 및 구현한다.

- **기존의 JPEG과 호환되는 All in JPEG 포맷 설계**<br>
&nbsp;All in JPEG 은 여러 장의 사진 중 가장 첫 번째 사진을 대표 사진으로 보여줌으로써 기존 JPEG 과 호환성을 유지한다.

- **촬영 후 원하는 객체로 초점 조절**<br>
&nbsp;사진 촬영 후, 사용자는 사진에서 원하는 객체로 초점을 변경할 수 있으며 여러 객체에 초점이 맞게 할 수 있다.

- **모두가 잘 나온 사진으로 변경**<br>
&nbsp;사용자가 사진에서 촬영 당시 가장 마음에 드는 얼굴로 변경할 수 있다. 예를 들면, 촬영 후에 사진에서 눈을 감고 있는 사람을 인식해 자동으로 눈을 뜨게 만들어주며 사용자가 직접 편집할 수도 있다.
 
- **시각적으로 즐거운 Magic Picture 생성**<br>
&nbsp;사용자가 사진에서 선택한 객체들이 마법처럼 움직이는 사진을 만들어 영상을 보는 듯한 느낌을 받게 한다.

- **새로운 JPEG 포맷을 볼 수 있는 전용 뷰어, MC 뷰어 구현**<br>
&nbsp;본 팀이 만든 All in JPEG 의 숨겨진 데이터를 볼 수 있는 뷰어를 만든다. 갤러리를 포함한 기존 뷰어들은 All in JPEG 사진에 어떤 데이터가 숨겨져 있는지 알 수 없고 대표 사진만 볼 수 있다. 하지만 ALL IN 뷰어를 사용하면 숨겨진 사진을 볼 수 있고 사진과 함께 오디오를 듣고 텍스트를 볼 수 있다. 또한, 사용자가 사진에서 선택한 객체가 움직이는 Magic Picture 를 볼 수 있다.

<br><br>

## :wrench: 시스템 아키텍처

&nbsp; OnePIC 은 안드로이드와 데스크탑 환경에서 작동하며, 각각 5 개와 3 개의 모듈로 이루어져 있다. OnePIC 의 시스템 구조는 [그림 1]과 같다. <br>

![구조도_new](https://github.com/HINAPIA/OnePic-All-in-JPEG/assets/86238720/8ca107dd-dacc-491a-844f-93606626ff00)<p align="center">[그림 1] 시스템 구조도 </p></p><br>
<!-- <p align="center"><img src="https://github.com/HINAPIA/OnePIC/assets/86238720/26516631-a26a-4b7d-a028-52606c3a1036.png" width="700" height="400"/> -->

&nbsp;OnePIC 앱은 거리별, 객체별 다초점 촬영 및 베스트 사진 추천 등이 가능한 안드로이드 카메라 앱이며, 카메라 모듈, All-in JPEG 모듈, 뷰어 모듈, 편집 모듈로 구성된다.<br>
- **카메라 모듈**<br>
- **All-in JPEG 모듈**<br>
- **뷰어 모듈**<br>
- **편집 모듈**<br>

&nbsp;All-in JPEG 전용 웹 뷰어는 크롬 브라우저의 확장 프로그램으로, 크롬 브라우저 환경이라면 어디에서든 실행할 수 있으며, All-in JPEG 파일에 들어있는 여러 이미지, 오디오, 텍스트를 웹 브라우저에 출력한다.<br>
&nbsp;All-in JPEG 데스크탑 뷰어는 코틀린으로 작성하여 윈도우, 리눅스, 맥 등 운영체제 구분없이 실행되며, All-in JPEG 파일의 이미지와 오디오, 텍스트 등 내부 콘텐츠를 데스크탑에서 출력한다.<br><br>




&nbsp;Camera 모듈은 CameraX 와 Camera2 라이브러리를 사용하여 개발되었으며, 사진 촬영을 도와준다. All in JPEG 모듈은 촬영된 사진이나 파일에서 읽은 사진을 가지고 All in JPEG 제작에 필요한 데이터를 제작해준다. Edit 모듈은 MLKit 라이브러리를 사용하여 개발되었으며, Best 사진 추천, Face Blending, 매직 픽쳐 생성, 초점 업그레이드 등 사진 편집을 도와준다.
데스크탑 애플리케이션에서 작동하는 3 개의 모듈은 TornadoFX 프레임워크로 구현되었다. 이는 File IO 모듈, Viewer 모듈, All in JPEG 모듈이며 모듈의 기능은 안드로이드 애플리케이션과 동일하다.

<br><br>

## :pushpin: All in JPEG 구조
&nbsp;All in JPEG은 기존의 JPEG 포맷을 확장하여 오디오와 텍스트는 물론 여러 이미지를 포함할 수 있는 새로운파일 포맷이다. All in JPEG 의 구조는 [그림 2]과 같다.

![Group 2065 (1)](https://github.com/HINAPIA/OnePIC/assets/109158497/ab129e54-bce0-4783-ab5f-e4686de498e4)<p align="center">[그림 2] All in JPEG 구조 </p></p><br>
<!--   <p align="center"><img src="https://github.com/HINAPIA/OnePIC/assets/86238720/40e6019b-848d-4df9-8072-7e7010302548.png" width="750" height="600"/> -->

&nbsp; JPEG 의 첫번 째 이미지가 끝나는 지점을 나타내는 EOI 마커 뒤에 추가할 이미지, 오디오 데이터가 삽입된다. All in JEPG 구조를 해석하기 위한 All-in Extension 데이터는 기존 JPEG 포맷의 APP3 마커 세그먼트에 추가된다. All-in Extension 데이터는 추가한 이미지, 텍스트, 오디오 정보를 나타내는 Image Content, Text Content, Audio Content 로 구성된다.<br><br>
&nbsp; Image Content 와 Audio Content 는 데이터의 시작 위치를 나타내는 Offset 필드와 데이터의 사이즈를 나타 내는 Data Size 필드를 통해 EOI 마커 뒤에 삽입된 데이터를 찾는다. 이와 달리 Text Content 는 텍스트 데이터와 텍스트 관련 정보 모두 APP3 마커 세그먼트에 기록하여 관리한다.<br><br>
&nbsp; 기존의 JPEG 뷰어로 All-in JPEG 파일을 열면 EOI 마커가 나오는 지점을 이미지의 끝으로 인식하여 All-in JPEG 의 첫번 째 이미지를 표시하고 EOI 마커 뒤에 삽입된 데이터는 해석하지 못한다. 이와같이 All in JPEG 은 기존 JPEG 포맷과 Backward Compatibility 을 유지한다.

<br><br>


## 기대 효과
- 새로운 형태의 멀티 콘텐츠 저장 기술 (All in JPEG) 개발
- 한 번의 촬영으로 순식간에 객체별, 거리별 다초점 사진 촬영
- 촬영자의 실력과 상관없이 누구나 좋은 사진 제작
- 움직이는 사진으로 엔터테이먼트 제공
- All in JPEG 기술로 다이어리앱 등 다양한 활용성 기대
- All in JPEG 으로 멀티 컨텐츠 공유 용이
- Google Play 스토어 출시로 상업성 기대

<br>

### - 개발 도구
<img src="https://img.shields.io/badge/Android Studio-3DDC84?style=for-the-badge&logo=Android Studio&logoColor=white"/> <img src="https://img.shields.io/badge/opencv-6EC93F?style=for-the-badge&logo=opencv&logoColor=white"/> <img src="https://img.shields.io/badge/tensorflow lite-FFAA5B?style=for-the-badge&logo=tensorflow&logoColor=white"/> <img src="https://img.shields.io/badge/tornadoFX-000000?style=for-the-badge"/>

### - 개발 언어
<img src="https://img.shields.io/badge/Kotlin-4193D0?style=for-the-badge&logo=kotlin&logoColor=white">



#### 교수님 SDK 12 라는게 32 인줄알고 하다가 마지막날에 SDK 12가 31 이라는 사실을 알았습니다... 바꿔보려고 이것저것 해봤는데 안되어서 부득이하게 compile SDK를 32 버젼으로 제출합니다 죄송합니다..

기능 구현 사항은 application_summary 참고 부탁드립니다.
-------------------------------------------------------

테스트 ID: hello 
      , Password : 123123123 

## 회원가입, 로그인을 통하여 상품내역을 볼 수 있는 Android application입니다.

-첫번째 페이지
> - 우선 첫번째 페이지에서는 로그인을 할 수 있도록 아이디, 비밀번호를 입력할 수 있습니다. 아래있는 회원가입 버튼은 회원가입 페이지로 이동 가능하며
 로그인 버튼은 입력칸에 알맞은 정보가 들어가면 로그인이되어 상품페이지로 넘어가고 아니라면 다시 시도해달라는 메시지를 받게 됩니다.
 
-두번째 페이지
> - 두번째 페이지에서는 회원가입이 가능합니다. 아이디는 중복이 안되며 각 정보의 요구사항이 hint로 나와있습니다.
> - 아이디 확인버튼을 누르면 중복, 요구사항이 맞지 않는 경우에는 아이디 확인이 되지 않는다는 안내 메시지를 받게 됩니다.
> - 패스워드는 두번 입력하게 되며 만약 이 두 패스워드가 다르다면 비밀번호 확인을 해달라고 안나 메시지를 받게 됩니다.
> - 전화번호도 11자리 숫자를 입력하지 않을 시 조건에 맞추어 달라는 안내메시지를 받게 됩니다. 
> - 약관 사항을 스크롤하여 보고, 동의를 하지 않을시, 동의해달라는 안내메시지를 받게 됩니다.
> - 만약 모든 조건이 맞다면 회원정보가 저장되며 첫번째 페이지로 이동하게 됩니다.

-세번째 페이지
> - 세번째 페이지는 상품 내역이 나와있는 페이지 입니다. 상품 내역은 스크롤이 가능합니다.
> - 상품추가 버튼은 아직 구현 하지 못했습니다. 과제 제출후 만들어보겠습니다.
> - 회원정보 버튼을 누르면 > 로그인이 되어있는 상태라면 로그인 아이디, 이름이 안내메시지로 나옵니다.
>                        > 로그인이 되어있지 않다면 회원가입 권유 네번째 페이지로 이동합니다.

-네번째 페이지
> - 네번째 페이지는 과제에는 나와있지 않지만 추가적으로 만든 회원가입 여부 판별, 권유 페이지입니다.
> - 처음에는 회원가입 여부를 묻습니다. 회원가입후 로그인을 하지 않은것이라고 하면 첫번째 로그인 페이지로 이동합니다.
> - 만약 회원가입이 안되어 있으면 회원가입을 하러 갈건지, 아니면 그냥 비 로그인상태로 상품페이지를 볼 것인지 선택하게 합니다.
돌아가기를 누르면 세번째, 회원가입하기는 두번째 페이지로 이동하게 됩니다.


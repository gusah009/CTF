# injured rudolph
## Score: 150

> 하늘을 나는 썰매 타고 있는 와중 루돌프 발목이 삐끗하였다  
> 루돌프의 다리를 치료할 방법을 찾아주자 !  
> https://christmas-web1.herokuapp.com/  
> **author:Center**

> ***hint: Easy SSTI***

먼저 문제에 나온 링크로 들어가면 아래와 같은 화면이 뜬다.  
개발자 도구로 소스를 확인해 보면, 주석에 ```request=santa```라는 문구가 뜨는데,  
앞서 hint에서 주어진 SSTI 기법임을 생각하면, santa라는 파라미터로 SSTI를 사용해 보는 것을 생각할 수 있다.

<img src="https://user-images.githubusercontent.com/26597702/147404918-c676f7e1-a408-410b-a3c8-dbc32d1ea008.png" width="80%"/>

------

```santa={{config.items()}}``` 파라미터를 입력하면 아래와 같이 나오고, flag가 등장한다.

<img src="https://user-images.githubusercontent.com/26597702/147405124-5d8c94d9-04de-419f-84a8-0362b89c8b8a.png" width="80%"/>

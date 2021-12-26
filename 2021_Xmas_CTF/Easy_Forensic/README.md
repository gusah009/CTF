# Easy Forensic
## Score: 50
> 악당들의 컴퓨터 비밀번호를 알아내라!

> Mlpswrweq{Rijv0_JMbilcma!!}
---
문제에 들어가기 앞서 Flag의 형식을 알아 볼 필요가 있다.

Flag의 형식은 **Christmas{...}** 형식으로, 반드시 앞 글자는 Christmas라는 것을 알 수 있다.

위의 문제를 살펴보면 중괄호 앞의 **"Mlpswrweq"** 문자를 보면 **"Christmas"** 문자와 글자 수가 같은 것을 알 수 있다.

여기서 고전 암호를 생각했고, 각 문자가 얼마나 이동했는지 확인 하기 위해 파이썬을 통해 확인해 보았다.

```python
a = "Mlpswrweq"
b = "Christmas"
for i, v in enumerate(a):
  print(ord(v) - ord(b[i]), end = ' ')

# >>> 10 4 -2 10 4 -2 10 4 -2
```
``` [10, 4, -2] ``` 가 Key라는 것을 알 수 있다.

따라서 Key를 적용해 *"Rijv0_JMbilcma"* 문자열을 적용시켜 보면,
``` python
key = [10, 4, -2]
a = "Rijv0_JMbilcma!!"
for i, v in enumerate(a):
  print(chr(ord(v) - key[i % len(key)]), end = ' ')

# >>> H e l l , a @ I d _ h e c ] #
```
위와 같은 결과가 나온다. 아무리 봐도 이상하다. **Hell** 뒤에 **0**이 붙어서 **Hell0**가 됐으면 하는 욕구가 강하게 든다. 특수문자를 빼고 다시한번 코드를 작성해보면,

``` python
ans = ""
key = [10, 4, -2]

a = "Rijv"
for i, v in enumerate(a):
  ans += chr(ord(v) - key[i % len(key)])
ans += "0_"

b = "JMbilcma"
for i, v in enumerate(b):
  ans += chr(ord(v) - key[i % len(key)])
ans += "!!"

print(ans)

# >>> Hell0_@Id_hec]!!
```
다음과 같은 결과를 얻을 수 있다. 하지만 Flag엔 **@** 나 **]** 같은 특수문자는 들어갈 수 없기 때문에 뭔가 조치를 취해줘야 한다.

**@** 나 **]** 로 바뀌어서 나왔다는 것은, 알파벳을 넘어서서 과도하게 ASCII값이 이동했다고 볼 수 있었다.

 따라서 key값의 순서와, 알파벳의 개수가 26개라는 것을 생각하여 약간의 조치를 취해주면,

```python
ans = ""
key = [10, 4, -2]

a = "Rijv"
for i, v in enumerate(a):
  ans += chr(ord(v) - key[i % len(key)])
ans += "0_"

key = [-16, 4, -2]

b = "JMbilcma"
for i, v in enumerate(b):
  ans += chr(ord(v) - key[(i + 1) % len(key)])
ans += "!!"

print(ans)

# >>> Hell0_FOrensic!!
```

**Hell0_FOrensic!!** 이라는 정답같은 정답이 나왔다.

이를 Flag 형식인 **Christmas{...}** 와 함께 제출했더니 정답이었다.
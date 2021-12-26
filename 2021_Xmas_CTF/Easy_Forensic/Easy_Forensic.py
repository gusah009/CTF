prob = "Mlpswrweq{Rijv0_JMbilcma!!}"

a = "Mlpswrweq"
b = "Christmas"
for i, v in enumerate(a):
  print(ord(v) - ord(b[i]), end = ' ')

print()

key = [10, 4, -2]
a = "Rijv0_JMbilcma!!"
for i, v in enumerate(a):
  print(chr(ord(v) - key[i % len(key)]), end = ' ')
  
print()

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
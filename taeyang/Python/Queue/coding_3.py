import sys

'''카드를 하나씩 출력 해보면 
   (카드 - 카드보다 작은 2의 배수) * 2 규칙을 찾을 수 있다!
  
'''


N = int(sys.stdin.readline())

card = [i for i in range(1, N+1)]

size = len(card)
count = 1

while True:
    count *= 2
    if size == 1:
        print(1)
        break
    if count >= size:
        count = count//2
        print((size -count) * 2)
        break




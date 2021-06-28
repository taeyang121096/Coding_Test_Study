'''2 번째 과정 '''
def string(w):
  if w == "":
    return ""
  right = left = 0
  u = v = ""
  for i in range(len(w)):
    if w[i]=="(":
      left+=1
    else: 
      right+=1
    if left==right:
      break
  return w[0:i+1],w[i+1:]

def balance(u):
  stack = []
  for s in u:
    if s=="(":
      stack.append(s)
    else:
      if not stack:
        return False
      stack.pop()
  return True
    

def solution(p):
  #과정 1 
  if not p:
    return ""
  #과정 2
  u ,v = string(p)
  #과정 3
  if balance(u):
    return u+solution(v)
  #과정 4
  else:
    answer = "("
    answer +=solution(v)
    answer+=")"
    for i in u[1:len(u)-1]:
      if i=='(':
        answer+=")"
      else:
        answer+="("

  return answer


p=")("
print(solution(p))
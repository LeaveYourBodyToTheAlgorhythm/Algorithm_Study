h,w = map(int,input().split())
l = list(map(int,input().split()))

ans = []
max_val = [l[0],0]

for i in range(1,len(l)):
    if max_val[0] <= l[i]: 
        #최소값보다 오히려 작은 값들에 대한 빗물 길이가 반영되지 않음
        if max_val[0] == 0:
            max_val = [l[i],i]
            continue
        
        h = min(max_val[0],l[i])
        w = i - max_val[1] -1
        tmp = h*w

        for j in range(max_val[1]+1,i):
            tmp -= l[j]

        ans.append(tmp)
        max_val = [l[i],i]
print(sum(ans))

# 개선점 : 단위를 조금 더 작게 쪼개서 생각하면 해결할 수 있지 않을까..?
# 그리고 어떤 조건을 추가해서 최대값보다 작은 값들에 대한 빗물 계산도고려할 수 잇을듯
#  (비교가 항상 최대값이 아니라면)

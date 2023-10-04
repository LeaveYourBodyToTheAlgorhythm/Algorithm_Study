from itertools import permutations
def solution(user_id, banned_id):
    
    def check(user,banned):
        for i in range(len(banned)):
            if banned[i] !="*" and user[i] != banned[i]:
                return False
        return True
    
    l = []
    
    for i in permutations(user_id, len(banned_id)):
        cnt = 0
        for a,b in zip(i, banned_id):
            if len(a) == len(b):
                if check(a,b):
                    cnt += 1
        
        if cnt == len(banned_id):
            if set(i) not in l:
                l.append(set(i))

    return len(l)

//# N 마리의 폰켓몬 중에서 N/2 마리를 가져가도 좋다
//        from collections import Counter
//
//def solution(nums):
//        answer = 0
//        counter = Counter(nums)
//        data = dict(counter)
//        # 사전 데이터 형으로 만들기는 성공
//        N = len(nums) // 2 # N/2
//        # 만약 key의 개수가 N 보다 같거나 크다면 최대는 그냥 N
//        # 만약 key의 개수가 N 보다 작다면,key 의 개수
//        key_len = len(data.keys())
//
//        if key_len >= N:
//        return N
//        else:
//        return key_len
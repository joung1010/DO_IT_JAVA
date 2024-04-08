# 자바 알고리즘
## 배열
배열은 메모리의 연속 공간에 값이 채워져 있는 형태의 자료구조  
### 배열의 특징
* 인덱스를 사용하여 값에 바로 접근
* 새로운 값을 삽입하거나 특정 인덱스에 있는 값을 삭제하기 어렵다. 값을 삽입하거나 삭제하려면 해당 인덱스 주변에 있는 값을 이동시키는 과정이 필요하다.
* 벼열의 크기는 선언할 때 지정할 수 있으며, 한 번 선언하면 크기를 늘리거나 줄일 수 없다.
* 구조가 간단해서 코딩 테스트에 많이 사용

## 리스트
리스트는 값과 포인터를 묶는 노드라는 것을 포인터로 연결한 자료구조  
### 리스트의 특징
* 인덱스가 없으므로 값에 접근하려면 HEAD 포인트 부터 순서대로 접근해야 한다. 다시 말해 값에 접근하는 속도가 느리다.
* 포인터로 연결되어 있으므로 데이터를 삽입하하거나 삭제한느 연산속도가 빠르다.
* 선언할 때 크기를 별도로 지정하지 않아도 된다. 다시 말해 리스트의 크기는 정해져 있지 않으며,**크기가 변하기 쉬운 데이터**를 다룰 때 적절하다.
* 포인터를 저장할 공간이 필요하므로 배열보다 구조가 복잡하다.

## 구간합
배열을 이용하여 시간 복잡도를 줄이기 위해 사용하는 알고리즘이다. 구간합 알고리즘을 활용하려면 먼저 합 배열을 구해야 한다.  
  
배열 A가 있을때 합 배열은 S라고 한다.  
```java
        int[] A = {15, 13, 10, 7, 3, 12};
        int[] S = {15, 28, 38, 45, 48, 60};

```
  
합 배열은 기존의 배열을 전처리한 배열이라고 생각하면 된다. 이렇게 합 배열을 미리 구해 놓으면 기존 배열의 일정 범위의 합을 구하는 시간 복잡도가 O(N) 에서 O(1)로 감소 한다.  
  
### 합배열을 만드는 공식
**S[i] = S[i - 1] + A[i]**  
  
### 구간 합을 구하는 공식
**S[j] - S[i - 1]**  
  
구간 합의 공식이 어떻게 나온 것인지 알아보자 만약 배열의 A[2] 에서 A[5] 까지의 구간 합을 배열을 통해서 구할때  
전체 구간의 합인 S[5] 에서 S[1] 만큼의 구간합을 빼면 우리가 원하는 구간합이 나오게 된다. 이는 실제 구간합을 구하기 보다는 전체에서 우리가 구하는 부분을 제외한 나머지를 전체에서 빼주는 방식이다.  
  
### 풀이 과정
S[5] = A[0] + A[1] ...+A[5]  
S[1] = A[0] + A[1]  
S[5] - S[1] = A[2] + A[3] + A[4] + A[5]  
  

### 2차원 배열 구간합 공식
**S[i][j] = S[i][j-1] + S[i-1][j] - S[i-1][j-1] + A[i][j]**

### 좌표 구간 합 공식 (x1,y1),(x2,y2)
S[x2][y2] - S[x1-1][y2] - S[x2][y-1] + [x1-1][y1-1]
전체 구간합에서 가장 테두리의 가로 세로를 빼고 중복해서 뺀 중심축을 더하면 된다.  
  
### 나머지 합 문제 풀이
* (A + B) % C 은 ( (A % C) + (B % C) )와 같다. 즉, 특정 구간 수들의 나머지 연산을 더해 나머지 연산을 한 값과 이 구간 합의 나머지 연산을 한 값은 동일하다.
* 구간 합 배열을 이용한 식 S[j] - S[i]는 원본 배열의 i + 1부터 j 까지의 구간 합이다.
* S[j] % M의 값과 S[i] % M의 값이 같다면 (S[j] - S[i]) % M 은 0이다. 즉, 구간 합 배열의 원소를 M으로 나눈 나머지로 업데임트하고 S[j]와 S[i]가 같은 (i,j)싸을 찾으면 원본 배열에서 i + 1 부터 j까지의 구간합이 M으로 나누어 떨어진다는 것을 알 수 있다.
>  경우의 수 구하기  
> (n*(n-1) )/2
  
  
### 투포인터
특정한 자연수가 있을때 이를 연속된 작연수의 합으로 나타내는 가지수를 알고 싶다. 예를들어 15라는 자연수가 있을때, 7+8,4+5+6,1+2+3+4+5 ,15 이렇게 표현할 수 있다.  
시작 인덱스와 종료 인덱스를 지정하여 연속된 수를 표현하면된다. 시작 인덱스와 종료인덱스를 투 포인터로 지정한 후 접근 해보면 된다.  
시작 인덱스를 오른쪽으로 한칸 이동하는 것은 연속된 자연수에서 왼쪽 값을 삭제하는 것과 효과가 같고  
종료인덱스를 오른쪽으로 이동하는 것은 연속된 자연수의 범위를 한칸 더 확장하는 의미이다.  
### 투포인터 이동원칙
* sum > 표현하고자 하는 자연수 : 
  * sum = sum - 시작 인덱스; 
  * 시작인덱스++;
* sum < 표현하고자 하는 자연수 : 
  * 종료인덱스++; 
  * sum = sum + 종료인덱스; 
* sum == 표현하고자 하는 자연수 : 
  * 종료인덱스++; 
  * sum = sum + 종료인덱스; 
  * cont++; 
  
> DeQueue 란?  
> ouble Ended Queue"의 약어로, 양쪽 끝에서 요소를 추가하거나 제거할 수 있는 자료 구조를 의미합니다. DeQueue는 일반적인 큐(Queue)보다 더 유연한 자료 구조로, 스택(Stack)과 큐(Queue)의 기능을 모두 통합한 형태라고 볼 수 있습니다.  
> 자바에서는 Deque 인터페이스를 제공하며, 이를 구현한 대표적인 클래스로는 ArrayDeque와 LinkedList가 있습니다. Deque 인터페이스를 사용하면 요소를 앞쪽이나 뒤쪽에 추가하거나 제거하는 다양한 메서드를 사용할 수 있습니다  
> 예를 들어, addFirst(), addLast(), removeFirst(), removeLast() 등의 메서드를 통해 DeQueue의 양쪽 끝에서 요소를 조작할 수 있습니다. 이러한 특성 덕분에 DeQueue는 양방향 큐, 슬라이딩 윈도우, 캐시 구현 등 다양한 프로그래밍 상황에서 활용될 수 있습니다.
  
  
## 스택
데이터의 후입선출로 이뤄진 자료구조  
* 위치
  - top: 삽입과 삭제가 일어나는 위치
- 연산
  - push: top(가장 위에) 새로운 데이터를 삽입
  - pop: top 위치에 현재 있는 데이터를 삭제
  - peek: top 위치에 현재 있는 데이터를 확인
  
## 큐
데이터의 선입선출로 이뤄진 자료구조
- 용어
  - rear
## 자바 정렬
Comparator를 사용한 정렬에서 반환 값이 정렬의 방향을 결정합니다. Comparator의 compare 메서드는 두 개의 객체(여기서는 수)를 비교하고, 세 가지 값 중 하나를 반환합니다: 양수, 0, 또는 음수입니다. 이 반환 값이 정렬 순서를 결정합니다:

오름차순 정렬:
- compare(a, b)가 음수를 반환하면, a가 b보다 "앞에" 위치합니다 (즉, a < b).
- compare(a, b)가 양수를 반환하면, a가 b보다 "뒤에" 위치합니다 (즉, a > b).
- compare(a, b)가 0을 반환하면, a와 b는 동등하며, 순서가 바뀌지 않습니다.

내림차순 정렬:
- compare(a, b)가 음수를 반환하면, a가 b보다 "뒤에" 위치합니다 (즉, a > b).
- compare(a, b)가 양수를 반환하면, a가 b보다 "앞에" 위치합니다 (즉, a < b).
- compare(a, b)가 0을 반환하면, a와 b는 동등하며, 순서가 바뀌지 않습니다.
  
## 버블 정렬


| 정렬 알고리즘 | 정의 |
|---------------|------|
| 버블         | 데이터의 인접 요소 끼리 비교하고, swap 연산을 수행하며 정렬하는 방식 |
| 선택         | 대상에서 가장 크거나 작은 데이터를 찾아가 선택을 반복하면서 정렬하는 방식 |
| 삽입         | 대상을 선택해 정렬된 영역에서 선택 데이터의 적절한 위치를 찾아 삽입하면서 정렬하는 방식 |
| 퀵           | pivot 값을 선정해 해당 값을 기준으로 정렬하는 방식 |
| 병합         | 이미 정렬된 부분 집합들을 효율적으로 병합해 전체를 정렬하는 방식 |
| 기수         | 데이터의 자릿수를 바탕으로 비교해 데이터를 정렬하는 방식 |
  
### 핵심
버블 정렬은 두 인접한 데이터의 크기를 비교해 정렬하는 방법, 시간복잡도는 O(n²)으로 다른 정렬 보다 속도가 느린편 이다.  
  
### 정렬 과정
1. 비교 연산이 필요한 루프 범위를 설정
2. 인접한 데이터 값을 비교
3. swap 조건에 부합하면 swap 연산 수행
4. 루프 범위가 끝날때 까지 2번에서 3번 작업을 반복 수행
5. 정렬 영역을 설정 한다. 다음 루프를 실행할 때는 이 영역을 제외한다.
6. 비교 대상이 없을 때까지 1~5번 작업을 반복한다.
  
## 퀵정렬
퀵 정렬은 기준값(pivot)을 선정해 해당 값보다 작은 데이터와 큰 데이터로 분류하는 것을 반복해 정렬하는 알고리즘  
  
### 정렬 과정
1. 데이터를 분할하는 pivot을 설정한다
2. pivot을 기준으로 다음과 같은 과정을 거쳐서 데이터를 2개의 집합으로 분리한다.
   1. start가 가리키는 데이터가 pivot이 가리키는 데이터 보다 작으면 start를 오른쪽 1칸 이동
   2. end가 가리키는 데이터가 pivot이 가리키는 데이터 보다 크면 end를 왼쪽으로 1칸이동
   3. start가 가리키는 데이터가 pivot이 가리키는 데이터보다 크고 end가 가리키는 데이터가 pivot 가리키는 데이터 보다 작으면 start, end가 가리키는 데이터를 swap하고 start는 오른쪽 end는 왼쪽으로 1칸씩 이동
   4. start 와 end가 만달때가지 반복
   5. start와 end가 만나면 만난 지점에서 가리키는 데이터와 pivot이 가리키는 데이터를 비교하여 pivot이 가리키는 데이터가 크면 만난 지점의 오른쪽에, 작으면 만난 지점의 왼쪽에 pivot이 가리키는 데이터를 삽입
3. 분리 집합에서 각각 다시 pivot을 선정한다.
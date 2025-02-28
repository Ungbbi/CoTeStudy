# CoTeStudy
> 자주 쓰일법한 문법 및 패키지 사용 정리

### 배열 출력
```JAVA
import java.util.Arrays;
int[] ary;
System.out.println(Arrays.toString(ary));
```
### 배열 역순
```JAVA
// Collections 사용
import java.util.List;
import java.util.Collections;
int[] ary;
List<int[]> integerList = Arrays.asList(ary);
Collections.reverse(integerList);
// 하지만 위 방법 너무 복잡함. 출력할때 어렵다
// 반복문이 낫다
```

### Shortest Path
```JAVA
// 다익스트라 알고리즘에서의 무한 표기
int INF = Integer.MAX_VALUE;

// 우선순위 큐 
import java.util.PriorityQueue;

//Comparable 구현
@Override
public int compareTo(Student target) {
    return this.age <= target.age ? 1 : - 1;
}


// Comparator 사용, Comparable은 인터페이스 Comparator는 클래스
priorityQueue = getPriorityQueueOfStudents();
PriorityQueue<Student> reversedPriorityQueue = new PriorityQueue<>(priorityQueue.size(), new Comparator<Student>() {
    @Override
    public int compare(Student p1, Student p2) {
        return p1.age >= p2.age ? 1 : -1;
    }
});
// 람다식으로
PriorityQueue<Student> reversedPriorityQueue = new PriorityQueue<>(priorityQueue.size(),
        (Student p1, Student p2) -> p1.age >= p2.age ? 1 : -1);

// 만약 Student 클래스에 Comparable를 구현하지 않고 PriorityQueue에 넣으려고 한다면 아래와 같은 에러가 발생한다.
Exception in thread "main" java.lang.ClassCastException: Student cannot be cast to java.lang.Comparable

```

### String[]  -> int[]
```JAVA
        String[] strArray = {"1", "2", "3", "4", "5"};
        
        int[] intArray = Arrays.stream(strArray)  // String[] -> Stream<String>
                              .mapToInt(Integer::parseInt)  // Stream<String> -> IntStream
                              .toArray();  // IntStream -> int[]
```

### int[] -> String[]
```JAVA
int[] n = new int[] {1,2,3,5,1,7,2,10};
String[] s = new String[n.length];

for (int i=0; i<n.length; i++){
    s[i] = String.valueOf(n[i]);
}
```

### ArrayList -> String[]
```JAVA
ArrayList<String> list = new ArrayList<>();
        list.add("Apple");
        list.add("Banana");
        list.add("Cherry");

        // ArrayList를 String[]로 변환
        String[] array = list.toArray(new String[0]);
```
- `new String[0]` 이 부분이 핵심.

### 자바의 배열 인덱스 슬라이싱 
```JAVA
import java.util.Arrays;

int[] ary = new int[]{1,2,3,4,5,6};
// Arrays.copyOfRange(ary, start, end) ->   ary[start] 부터 ary[end-1] 까지 자름 
int[] sliced = Arrays.copyOfRange(ary, 1,3); // ary[1]부터 ary[2]까지 즉 {2,3} 이 나옴 
```

### 정렬 내림차순
```JAVA
import java.util.Arrays;
import java.util.Collections;

int[] n = new int[]{1,5,3,5,4,0}; (X) // Integer를 기대하므로 int는 안된다.
Integer[] n = {1,2,3,4,5,6}; (O) 
Arrays.sort(n, Comparator.reverseOreder());
```

### 소수판별
```JAVA
// 소수판별하기 쉬운 방법 - 에라토스테네스의 체
// 판별하려는 값 N이 2~N의 제곱근까지의 수들로 나눠지지 않는다면 소수.
for(int i=0; i<Math.sqrt(n); i++){
    if(n%i==0) return false;
    }
return true;
```

### 배열 / 리스트의 중복 제거
```JAVA
import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 2, 3, 4, 4, 5);
        int[] nums = {1, 2, 2, 3, 4, 4, 5};
        // 1. List<Integer>의 경우

        // HashSet을 사용하여 중복 제거함 -> 순서 보장 X
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        // LinkedHashSet 사용 -> 순서 보장
        Set<Integer> uniqueNumbers = new LinkedHashSet<>(numbers);

        // 2. int[] 의 경우 (int[] 은 Integer 형이 아니므로 변환해줘야함)
        // 아래의 경우 반드시 import java.util.stream.Collectors; 해줘야함
        import java.util.stream.Collectors;
        Set<Integer> s = Arrays.stream(nums)
                                .boxed() // Integer로 변환
                                .collect(Collectors.toSet());
        // HashSet을 사용한 수동 변환
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        // 중복이 제거된 결과 출력
        System.out.println(new ArrayList<>(uniqueNumbers)); // [1, 2, 3, 4, 5]
    }
}

```

### 리스트에서 특정 값에 해당하는 원소 제거
```JAVA
ArrayList<Integer> A = new ArrayList<>();
// 대충 위 A에 원소들이 추가됐다고 하자.

wires[1] = 2일 때
A.remove(wires[1])  -> X  : remove(int x) 호출. 이 함수는 해당하는 인덱스를 찾아서 제거 -> 인덱스 에러 및 원하는 것에서 벗어날 수 있음
A.remove(Integer.valueOf(wires[1])) -> O : remove(Object obj) 호출. 해당 값을 찾아서 제거 

```

### Queue 배열
```JAVA
Queue<Integer>[] q = new LinkedList[2];
q[0] = new LinkedList<>();
q[1] = new LinkedList<>();
```

### 모듈러 연산 분배법칙
| 결괏값이 매우 큰 값에 대하여 모듈러(나머지) 연산을 수행할 경우 오버플로우 혹은 많은 시간이 소모된다. 
|그렇기에 결괏값을 도출해내기 위한 연산 수행 과정에서 모듈러 연산을 적용하여야 한다.


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

int[] n = new int[]{1,5,3,5,4,0};
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

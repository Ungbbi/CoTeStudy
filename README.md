# CoTeStudy
> 자주 쓰일법한 문법 및 패키지 사용 정리

#### 배열 출력
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
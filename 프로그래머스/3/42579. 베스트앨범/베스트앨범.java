import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        // 각 장르별 총 재생 횟수를 저장할 맵
        Map<String, Integer> genrePlayCount = new HashMap<>();
        
        // 각 장르별 노래 정보(인덱스와 재생 횟수)를 저장할 맵
        Map<String, List<int[]>> genreSongs = new HashMap<>();
        
        // 총 재생 횟수 계산 및 노래 등록
        for (int i = 0; i < genres.length; i++) {
            String genre = genres[i];
            
            // 장르별 총 재생 횟수 업데이트
            genrePlayCount.put(genre, genrePlayCount.getOrDefault(genre, 0) + plays[i]);
            
            // 장르별 노래 리스트에 노래 추가
            genreSongs.computeIfAbsent(genre, k -> new ArrayList<>())
                      .add(new int[]{i, plays[i]});
        }
        
        // 장르를 총 재생 횟수 기준으로 내림차순 정렬
        List<String> sortedGenres = new ArrayList<>(genrePlayCount.keySet());
        sortedGenres.sort((a, b) -> genrePlayCount.get(b) - genrePlayCount.get(a));
        
        List<Integer> result = new ArrayList<>();
        
        // 각 장르별 최상위 2개 노래 선택
        for (String genre : sortedGenres) {
            List<int[]> songs = genreSongs.get(genre);
            
            // 장르 내 노래를 재생 횟수 기준으로 내림차순 정렬
            songs.sort((a, b) -> b[1] - a[1]);
            

            result.add(songs.get(0)[0]);
            
            if (songs.size() > 1) {
                result.add(songs.get(1)[0]);
            }
        }
        
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}
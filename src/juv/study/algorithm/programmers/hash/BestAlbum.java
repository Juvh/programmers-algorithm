package juv.study.algorithm.programmers.hash;

import java.util.*;

public class BestAlbum {

    class Solution {
        public int[] solution(String[] genres, int[] plays) {
            Map<String, List<Track>> tracksByGenre = new HashMap<>();
            Map<String, Integer> sumByGenre = new HashMap<>();

            for (int i = 0; i < genres.length; i++) {
                String genre = genres[i];
                int numOfPlay = plays[i];

                List<Track> tracks = tracksByGenre.getOrDefault(genre, new ArrayList<>());
                tracks.add(new Track(i, numOfPlay));
                tracksByGenre.put(genre, tracks);

                Integer sum = sumByGenre.getOrDefault(genre, 0);
                sumByGenre.put(genre, sum + numOfPlay);
            }

            ArrayList<Integer> answers = new ArrayList<>();
            sumByGenre.entrySet().stream().sorted((o1, o2) -> o2.getValue() - o1.getValue())
                    .forEach(entry -> {
                        String genre = entry.getKey();

                        List<Track> tracks = tracksByGenre.get(genre);
                        tracks.sort((o1, o2) -> o2.numOfPlay - o1.numOfPlay);
                        for (int i = 0; i < 2 && i < tracks.size(); i++) {
                            answers.add(tracks.get(i).uniqueId);
                        }
                    });


            return answers.stream().mapToInt(it -> it).toArray();
        }
    }

    class Track {
        int uniqueId;
        int numOfPlay;

        public Track(int uniqueId, int numOfPlay) {
            this.uniqueId = uniqueId;
            this.numOfPlay = numOfPlay;
        }
    }
}

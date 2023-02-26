package _202302_;

public class Student {

        String name;
        boolean isMale;
        int hak;
        int ban;
        int score;

        public Student(String name, boolean isMale, int hak, int ban, int score) {
            this.name = name;
            this.isMale = isMale;
            this.hak = hak;
            this.ban = ban;
            this.score = score;
        }

        public String getName() {
            return name;
        }

        public boolean isMale() {
            return isMale;
        }

        public int getHak() {
            return hak;
        }

        public int getBan() {
            return ban;
        }

        public int getScore() {
            return score;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "name='" + name + '\'' +
                    ", isMale=" + isMale +
                    ", hak=" + hak +
                    ", ban=" + ban +
                    ", score=" + score +
                    '}';
        }

        //groupingBy()에서 사용
        enum Level {HIGH, MID, LOW}

}

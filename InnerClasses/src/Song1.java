public class Song1 {

        private String title;
        private double duration;

        public Song1(String title, double duration) {
            this.title = title;
            this.duration = duration;
        }

        public String getTitle() {
            return title;
        }

        public double getDuration() {
            return duration;
        }

        @Override
        public String toString() {
            return title + ": " + duration;
        }
    }
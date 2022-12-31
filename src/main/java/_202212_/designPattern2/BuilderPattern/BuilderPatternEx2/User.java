package _202212_.designPattern2.BuilderPattern.BuilderPatternEx2;

public class User {
    private String userName; //필수
    private String userEmail; //필수
    private int userAge; //필수
    private int userHeight; //선택
    private int userWeight; //선택

    @Override
    public String toString() {
        return this.userName + ", "
                + this.userEmail + ", "
                + this.userAge + ", "
                + this.userHeight + ", "
                + this.userWeight;
    }

    public User(Builder builder) {
        this.userName = builder.userName;
        this.userEmail = builder.userEmail;
        this.userAge = builder.userAge;
        this.userHeight = builder.userHeight;
        this.userWeight = builder.userWeight;
    }

    public static class Builder {
        private String userName = "고고캣";
        private String userEmail = "gogo@gogo.com";
        private int userAge = 20;
        private int userHeight = 160;
        private int userWeight = 60;

        public Builder(String userName, String userEmail) {
            this.userName = userName;
            this.userEmail = userEmail;
        }

        public Builder userAge(int userAge) {
            this.userAge = userAge;
            return this;
        }

        public Builder userHeight(int userHeight) {
            this.userHeight = userHeight;
            return this;
        }

        public Builder userWeight(int userWeight) {
            this.userWeight = userWeight;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }

    public static void main(String[] args) {
        User user = new Builder("차양양", "yang@yang.com")
                .userAge(21)
                .userHeight(150)
                .userWeight(50)
                .build();

        System.out.println(user.toString());
    }


}

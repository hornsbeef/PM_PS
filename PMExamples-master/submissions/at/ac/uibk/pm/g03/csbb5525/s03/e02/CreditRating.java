package at.ac.uibk.pm.g03.csbb5525.s03.e02;

public enum CreditRating {
    LOW(-10000), MEDIUM(-50000), HIGH(-100000);


    private final int ratingValue;

    CreditRating(int ratingValue) {
        this.ratingValue = ratingValue;
    }
    public int getRatingValue() {
        return ratingValue;
    }
}

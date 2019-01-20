package com.nothing.demo.constant;

public enum StarRating {

    ONE_STAR(1),
    TWO_STARS(2),
    THREE_STARS(3),
    FOUR_STARS(4),
    FIVE_STARS(5);

    public int getRating() {
        return rating;
    }

    private int rating;
    private StarRating(int rating){
        this.rating = rating;
    }

    public StarRating fromInteger(int number){
        for (StarRating val : StarRating.values()){
            if (val.rating == number) return val;
        }
        return null;
    }




}

package Software.ulpgc.kata3.model;

public class TsvRatingDeserializer implements RatingDeserializer{

    @Override
    public MovieRating deserializer(String data){
            String[] fields = data.split("\t");
            return new MovieRating(
                    fields[0],
                    toDouble(fields[1]),
                    toInteger(fields[2])
            );
    }

    private double toDouble(String field) {
        return Double.parseDouble(field);
    }

    private int toInteger(String field) {
        return Integer.parseInt(field);
    }
}


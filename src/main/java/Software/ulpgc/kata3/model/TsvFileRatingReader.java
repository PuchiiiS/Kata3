package Software.ulpgc.kata3.model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TsvFileRatingReader implements RatingReader{
    private final File file;


    public TsvFileRatingReader(File file) {
        this.file = file;
    }

    @Override
    public List<MovieRating> read() {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))){
            reader.readLine();
            return readWith(reader);
        } catch (IOException e){
            throw new RuntimeException(e);
        }
    }

    private static List<MovieRating> readWith(BufferedReader reader) throws IOException {
        TsvRatingDeserializer  deserializer = new TsvRatingDeserializer();
        List<MovieRating> result = new ArrayList<>();
        while(true){
            String line = reader.readLine();
            if (line == null) break;
            MovieRating rating = deserializer.deserializer(line);
            result.add(rating);
        }
        return result;
    }
}


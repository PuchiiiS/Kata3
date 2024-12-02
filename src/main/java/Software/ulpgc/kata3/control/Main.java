package Software.ulpgc.kata3.control;

import Software.ulpgc.kata3.model.MovieRating;
import Software.ulpgc.kata3.model.TsvFileRatingReader;
import Software.ulpgc.kata3.view.swing.InteractiveHistogramView;

import java.io.File;
import java.util.HashMap;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        File file = new File("C:/Users/hsuli/Desktop/Kata 2/title.ratings.tsv");
        List<MovieRating> ratings = new TsvFileRatingReader(file).read();

        HashMap<Integer, Integer> histogram = new HashMap<>();
        for(MovieRating rating : ratings){
            int roundedRating = (int) Math.floor(rating.getAverageRating());
            histogram.put(roundedRating, histogram.getOrDefault(roundedRating, 0) + 1);
        }

        InteractiveHistogramView interactiveHistogramView = new InteractiveHistogramView();
        interactiveHistogramView.renderHistogram(histogram, file);
    }
}



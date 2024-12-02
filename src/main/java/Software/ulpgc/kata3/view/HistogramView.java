package Software.ulpgc.kata3.view;

import java.util.Map;

public class HistogramView {
        public void renderHistogram(Map<Integer, Integer> histogram, int scaleFactor) {
            System.out.println("Histograma de las calificaciones");
            for(int key : histogram.keySet()){
                int scaledvalue = Math.max(1, histogram.get(key) / scaleFactor);
                System.out.printf("%d - %d: %s\n", key, key + 1, "|".repeat(scaledvalue));
            }
        }
}


package utils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Utils {


    public static <T> boolean isNullOrEmpty(Collection<T> testCollection) {
        return (testCollection == null || testCollection.isEmpty());
    }

    public static <T> Collection<T> safe(Collection<T> testCollection) {
        return isNullOrEmpty(testCollection) ? Collections.<T>emptyList() : testCollection;
    }

    public static <T> ArrayList<T> safe(ArrayList<T> testCollection) {
        return isNullOrEmpty(testCollection) ? new ArrayList<>() : testCollection;
    }


}

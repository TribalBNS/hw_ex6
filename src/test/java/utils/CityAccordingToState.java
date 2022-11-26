package utils;

public class CityAccordingToState {
    private static final String[] stateChoices = {"NCR", "Uttar Pradesh", "Haryana", "Rajasthan"};

    public static int cityDeterminant(String state) {
        int i;
        for (i = 0; i < stateChoices.length; i++) {
            if (state.equals(stateChoices[i]))
                break;
        }
        return i;
    }
}

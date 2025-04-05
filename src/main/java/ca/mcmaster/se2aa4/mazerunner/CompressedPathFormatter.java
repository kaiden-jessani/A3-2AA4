package ca.mcmaster.se2aa4.mazerunner;

public class CompressedPathFormatter implements PathFormatter {
    private final PathFormatter formatter;

    public CompressedPathFormatter(PathFormatter formatter) {
        this.formatter = formatter;
    }

    @Override
    public String format(String path) {
        return compress(formatter.format(path));
    }

    private String compress(String input) {
        if (input == null || input.isEmpty()) return "";
        StringBuilder result = new StringBuilder();
        char currentChar = input.charAt(0);
        int count = 1;
        for (int i = 1; i < input.length(); i++) {
            if (input.charAt(i) == currentChar) {
                count++;
            } else {
                result.append(count).append(currentChar);
                currentChar = input.charAt(i);
                count = 1;
            }
        }
        result.append(count).append(currentChar);
        return result.toString();
    }
}
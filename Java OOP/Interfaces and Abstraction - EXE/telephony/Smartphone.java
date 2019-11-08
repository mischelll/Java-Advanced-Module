package telephony;

import java.util.List;

public class Smartphone implements Callable, Browsable {
    private List<String> numbers;
    private List<String> urls;

    public Smartphone(List<String> numbers, List<String> urls) {
        this.numbers = numbers;
        this.urls = urls;
    }


    @Override
    public String browse() {
        StringBuilder sb = new StringBuilder();
        for (String url : this.urls) {
            boolean check = url
                    .chars()
                    .anyMatch(Character::isDigit);
            if (check) {
                sb.append("Invalid URL!");

            } else {
                sb.append(String.format("Browsing: %s!", url));

            }
            sb.append(System.lineSeparator());
        }

        return sb.toString().trim();
    }

    @Override
    public String call() {
        StringBuilder sb = new StringBuilder();
        for (String number : this.numbers) {
            boolean check = number
                    .chars()
                    .anyMatch(Character::isLetter);

            if (check) {
                sb.append("Invalid number!");

            } else {
                sb.append(String.format("Calling... %s", number));

            }
            sb.append(System.lineSeparator());
        }

        return sb.toString().trim();
    }
}

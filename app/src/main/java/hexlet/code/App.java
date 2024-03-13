package hexlet.code;

import picocli.CommandLine;

public class App {

    public static void main(String[] args) throws Exception {
        new CommandLine(new Differ()).execute(args);
    }

}

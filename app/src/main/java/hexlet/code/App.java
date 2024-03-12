package hexlet.code;

import picocli.CommandLine;

@CommandLine.Command(
        name = "gendiff",
        description = "Compares two configuration files and shows a difference.",
        mixinStandardHelpOptions = true
)
public class App implements Runnable{
    public static void main(String[] args){
        new CommandLine(new App()).execute(args);
    }

    @Override
    public void run() {
        System.out.println("Hello");
    }
}

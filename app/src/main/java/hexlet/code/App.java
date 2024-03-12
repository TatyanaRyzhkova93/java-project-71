package hexlet.code;

import picocli.CommandLine;

@CommandLine.Command(
        name = "gendiff",
        description = "Compares two configuration files and shows a difference.",
        mixinStandardHelpOptions = true
)
public class App implements Runnable{
    @CommandLine.Parameters(index = "0", paramLabel="filepath1", description = "path to first file")
    private String filepath1;
    @CommandLine.Parameters(index = "1", paramLabel="filepath2", description = "path to first file")
    private String filepath2;
    @CommandLine.Option(names = {"-f, --format"}, paramLabel="format", description = "output format [default: stylish]")
    private String format = "stylish";
    public static void main(String[] args){
        new CommandLine(new App()).execute(args);
    }

    @Override
    public void run() {
        System.out.println("Hello");
    }
}

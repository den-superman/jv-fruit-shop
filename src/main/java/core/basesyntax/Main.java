package core.basesyntax;

import core.basesyntax.service.FruitCounter;
import core.basesyntax.service.MyFileReader;
import core.basesyntax.service.MyFileWriter;
import core.basesyntax.service.impl.FruitCounterImpl;
import core.basesyntax.service.impl.MyFileReaderImpl;
import core.basesyntax.service.impl.MyFileWriterImpl;
import core.basesyntax.strategy.FruitAdder;
import core.basesyntax.strategy.FruitHandler;
import core.basesyntax.strategy.FruitSubtractor;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        Map<String, FruitHandler> strategy = new HashMap<>();
        strategy.put("b", new FruitAdder());
        strategy.put("s", new FruitAdder());
        strategy.put("r", new FruitAdder());
        strategy.put("p", new FruitSubtractor());
        MyFileReader myFileReader = new MyFileReaderImpl();
        FruitCounter fruitCounter = new FruitCounterImpl();
        MyFileWriter myFileWriter = new MyFileWriterImpl();

        List<String> info = myFileReader.getDryInfo("src/main/resources/input.csv");
        fruitCounter.countFruits(info, strategy);
        File report = myFileWriter.writeReport();
    }
}

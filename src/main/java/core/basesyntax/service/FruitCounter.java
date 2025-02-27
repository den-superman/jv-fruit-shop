package core.basesyntax.service;

import core.basesyntax.strategy.FruitHandler;
import java.util.List;
import java.util.Map;

public interface FruitCounter {
    void countFruits(List<String> uncountedFruits, Map<String, FruitHandler> strategy);
}

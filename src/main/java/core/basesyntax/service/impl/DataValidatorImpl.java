package core.basesyntax.service.impl;

import core.basesyntax.service.DataValidator;
import java.util.List;

public class DataValidatorImpl implements DataValidator {
    private static final int MIN_SIZE = 2;
    private static final int INDEX_FIRST_LINE = 0;
    private static final String EXPECTED_FORMAT_FIRST_LINE = "type,fruit,quantity";

    public void validate(List<String> lines) {
        if (lines.size() < MIN_SIZE) {
            throw new RuntimeException("There is not enough data in your file to make any report");
        }
        if (!lines.get(INDEX_FIRST_LINE).equals(EXPECTED_FORMAT_FIRST_LINE)) {
            throw new RuntimeException("First line in your file should be \"type,fruit,quantity\"");
        }
    }
}
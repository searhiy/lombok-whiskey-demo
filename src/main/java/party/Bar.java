package party;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.Singular;
import lombok.extern.log4j.Log4j2;

import java.time.LocalTime;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Builder
@Log4j2
public class Bar {

    @Getter
    private final LocalTime openTime;

    @Getter
    private final LocalTime closeTime;

    @Getter(AccessLevel.PACKAGE)
    @Singular
    private final List<String> bartenders;

    @Getter(AccessLevel.PACKAGE)
    @Singular
    private final Map<String, Bottle> whiskeys;

    public void recommendations() {
        Stream<Whiskey> singleMalts = whiskeys.values().stream()
                .map(Bottle::whiskey)
                .filter(Whiskey::isSingleMaltBarley);
        LOGGER.error(singleMalts.collect(Collectors.toList()));
    }

}

package serve;

import org.jetbrains.annotations.NotNull;

import java.util.Map;
import java.util.function.Predicate;
import java.util.regex.Pattern;

public abstract class ContentType {

    private static @NotNull Predicate<String> compilePredicate(@NotNull String regex) {
        return Pattern.compile(regex).asPredicate();
    }

    private static final Map<Predicate<String>, String> CONTENT_TYPE_MAP = Map.of(
            compilePredicate("\\.(?i)html?$"), "text/html; charset=UTF-8",
            compilePredicate("\\.(?i)js$"), "text/javascript; charset=UTF-8",
            compilePredicate("\\.(?i)css$"), "text/css; charset=UTF-8",
            compilePredicate("\\.(?i)png$"), "image/png",
            compilePredicate("\\.(?i)gif$"), "image/gif",
            compilePredicate("\\.(?i)ico$"), "image/x-icon",
            compilePredicate("\\.(?i)webp$"), "image/webp",
            compilePredicate("\\.(?i)jpe?g$"), "image/jpeg",
            compilePredicate("\\.(?i)svg$"), "image/svg+xml; charset=UTF-8",
            compilePredicate("\\.(?i)mp4$"), "video/mp4"
    );

    public static @NotNull String getContentType(@NotNull String path) {
        for (var ps : CONTENT_TYPE_MAP.entrySet()) {
            var predicate = ps.getKey();
            var contentType = ps.getValue();
            if (predicate.test(path)) {
                return contentType;
            }
        }
        return "application/octet‑stream";
    }
}

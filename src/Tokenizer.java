import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * This class is thread safe.
 */
public class Tokenizer {

    private File file;

    public static <K, V extends Comparable<? super V>> Map<K, V> sortByValue(Map<K, V> map) {
        List<Entry<K, V>> list = new ArrayList<>(map.entrySet());
        list.sort(Entry.comparingByValue());
        Map<K, V> result = new LinkedHashMap<>();
        for (Entry<K, V> entry : list) {
            result.put(entry.getKey(), entry.getValue());
        }
        return result;
    }

    public synchronized void setFile(final File f) {
        file = f;
    }

    public synchronized File getFile() {
        return file;
    }

    //unless it is needed that way, it would be better to validate file parameter is set correctly before calling any of the methods below
    public String getContent() throws IOException {
        final StringBuffer output = new StringBuffer();
        // StringBuffer is better for memory usage than appending strings, additionally it is thread safe which helps in this case
        try (final FileInputStream fileInputStream = new FileInputStream(file)) {
            // Stream is not closed therefore adding try-with-resources should resolve this
            int data;
            while ((data = fileInputStream.read()) > 0) {
                output.append(data);
                // casting is not needed here
            }
        }
        return output.toString();
    }

    public String getContentWithoutUnicode() throws IOException {
        final StringBuffer output = new StringBuffer();
        try (final FileInputStream fileInputStream = new FileInputStream(file)) {
            int data;
            while ((data = fileInputStream.read()) > 0) {
                if (data < 0x80) {
                    output.append(data);
                }
            }
        }
        return output.toString();
    }

    public void saveContent(final String content) throws IOException {
        // Making input final to make sure the original input is not modified
        try (final FileOutputStream fileOutputStream = new FileOutputStream(file)) {
            if (content != null) {
                for (int i = 0; i < content.length(); i++) {
                    fileOutputStream.write(content.charAt(i));
                }
            }
        }
    }
}

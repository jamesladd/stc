package st.redline.classloader;

import java.io.File;

public class SmalltalkSourceFile implements Source, LineTransformer {

//    private static final Pattern START_INSTANCE_METHOD = Pattern.compile("\\s*- .*\\s");

    private final String name;
    private final String filename;
    private final File file;
    private final SourceReader reader;

    public SmalltalkSourceFile(String name, String filename, File file, SourceReader reader) {
        this.name = name;
        this.filename = filename;
        this.file = file;
        this.reader = reader;
    }

    public boolean hasContent() {
        return file.length() > 0;
    }

    public String contents() {
        return reader.contents(this);
    }

    public String transform(String line) {
        return line;
    }

    public String begin() {
        return "";
    }

    public String end() {
        return "";
    }
}

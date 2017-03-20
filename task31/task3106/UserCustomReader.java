package com.javarush.task.task31.task3106;

import java.io.IOException;
import java.io.Reader;
import java.nio.CharBuffer;

/**
 * Created by locuser on 11.03.2017.
 */
public class UserCustomReader extends Reader {


    protected UserCustomReader() {
        super();
    }

    protected UserCustomReader(Object lock) {
        super(lock);
    }

    @Override
    public int read(CharBuffer target) throws IOException {
        return super.read(target);
    }

    @Override
    public int read() throws IOException {
        return super.read();
    }

    @Override
    public int read(char[] cbuf) throws IOException {
        return super.read(cbuf);
    }

    @Override
    public long skip(long n) throws IOException {
        return super.skip(n);
    }

    @Override
    public boolean ready() throws IOException {
        return super.ready();
    }

    @Override
    public boolean markSupported() {
        return super.markSupported();
    }

    @Override
    public void mark(int readAheadLimit) throws IOException {
        super.mark(readAheadLimit);
    }

    @Override
    public void reset() throws IOException {
        super.reset();
    }

    @Override
    public int read(char[] cbuf, int off, int len) throws IOException {
        return 0;
    }

    @Override
    public void close() throws IOException {

    }
}

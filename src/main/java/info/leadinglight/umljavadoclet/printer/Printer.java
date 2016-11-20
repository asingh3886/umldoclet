/*
 * Copyright (C) 2016 Talsma ICT
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package info.leadinglight.umljavadoclet.printer;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author Gerald Boersma
 */
public abstract class Printer {
    public boolean toFile(String filename) {
        return dumpToFile(filename, _sb.toString());
    }

    public boolean toFile(File file) {
        return dumpToFile(file, _sb.toString());
    }

    @Override
    public String toString() {
        return _sb.toString();
    }

    public StringBuilder stringBuilder() {
        return _sb;
    }

    public void print(String str) {
        _sb.append(str);
    }

    public void print(int level, String str) {
        indent(level);
        _sb.append(str);
    }

    public void println(String str) {
        _sb.append(str);
        _sb.append("\n");
    }

    public void println(int level, String str) {
        indent(level);
        _sb.append(str);
        _sb.append("\n");
    }

    public void indent() {
        indent(1);
    }

    public void indent(int level) {
        for (int i = 0; i < level; i++) {
            print("  ");
        }
    }

    public void newline() {
        _sb.append("\n");
    }

    private boolean dumpToFile(String filename, String str) {
        return dumpToFile(new File(filename), str);
    }

    private boolean dumpToFile(File file, String str) {
        try {
            FileOutputStream os = new FileOutputStream(file);
            os.write(str.getBytes());
            os.close();
            return true;
        } catch (IOException e) {
            //e.printStackTrace();
            return false;
        }
    }

    private final StringBuilder _sb = new StringBuilder();
}

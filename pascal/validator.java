package pascal;

import java.util.ArrayDeque;
import org.stringtemplate.v4.*;
import java.io.*;
import org.antlr.v4.runtime.tree.*;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import java.util.List;
import java.util.ArrayList;
import org.antlr.v4.runtime.tree.ErrorNode;

class validator extends pascalBaseListener {

    public boolean valid = true;

    @Override
    public void visitErrorNode(ErrorNode node) {
        valid = false;
        System.out.println(node.getText());
    }
} // class myListener


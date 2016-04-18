package pascal;

import java.util.ArrayDeque;
import org.stringtemplate.v4.*;
import java.io.*;
import org.antlr.v4.runtime.tree.*;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import java.util.List;
import java.util.ArrayList;

class searcher extends pascalBaseListener {

    public ArrayList<String> data = new ArrayList<String>();
    public boolean found = false;

    @Override
    public void exitProgram(pascalParser.ProgramContext ctx) {
        iswantd(ctx.getText());
    }

    public boolean iswantd(String rule) {
        for (int i = 0; i != data.size(); i++) {
            if (rule.contains(data.get(i))) {
                System.out.println("found "+ data.get(i) + " in program");
                found = true;
                //return true;
            }
        }
        return false;
    }

} // class myListener


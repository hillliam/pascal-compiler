package pascal;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

/**
 *
 * @author liam
 */
class Pascal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        System.out.println(args.length);
        if (args.length > 0) {
            if (args.length >= 2) {
                if (args[1].contains("-gui")) {
                    treedispay.gui(args);
                } else if (args[1].contains("-path")) {
                    if (args.length == 3) {
                        easyconvert(args[0], true);
                    } else {
                        easyconvert(args[0], false);
                    }
                } else if ((args[1].contains("-search"))) {
                    ArrayList<String> data = new ArrayList<String>();
                    for (int i = 3; i < args.length; i++) {
                        data.add(args[i]);
                    }
                    searchtree(args[0], data);
                } else if (args[1].contains("-valid")) {
                    validate(args[0]);
                } else {
                    convert(args[0]);
                }
            } else {
                jsconvert(args[0]);
            }
        } else {
            System.out.println("Usage: java code.pascal <source>");
            displayhelp();
        }

    } // main

    public static void displayhelp() {
        System.out.println("-xml  display to tree as xml");
        System.out.println("-gui  display a gui");
        System.out.println("-path  display to tree as text");
        System.out.println("-valid  check the program is valid");
        System.out.println("-check  detect program optimizations");
    }

    public static void jsconvert(String inputFile) throws Exception {
        System.out.println("// source file is " + inputFile);
        ParseTree tree = gettree(inputFile);
        myListener ml = new myListener();

        ParseTreeWalker walker = new ParseTreeWalker();
        walker.walk(ml, tree);
        System.out.println();
    }

    public static void convert(String inputFile) throws Exception {
        System.out.println("// xml export of " + inputFile);
        ParseTree tree = gettree(inputFile);
        stringListener ml = new stringListener();

        ParseTreeWalker walker = new ParseTreeWalker();
        walker.walk(ml, tree);
        System.out.println();
    }
    
        public static void validate(String inputFile) throws Exception {
        System.out.println("// xml export of " + inputFile);
        ParseTree tree = gettree(inputFile);
        validator ml = new validator();

        ParseTreeWalker walker = new ParseTreeWalker();
        walker.walk(ml, tree);
        if (ml.valid == true) {
            System.out.println("this is a valid pascal program");
        } else {
            System.out.println("this is an invalid pascal program");
        }
        System.out.println();
    }

    public static void easyconvert(String inputFile, boolean contence) throws Exception {
        System.out.println("// tree path of " + inputFile);
        ParseTree tree = gettree(inputFile);
        easyListener ml = new easyListener();
        ml.contence = contence;
        ParseTreeWalker walker = new ParseTreeWalker();
        walker.walk(ml, tree);
        System.out.println();
    }

    public static void searchtree(String inputFile, ArrayList<String> data) throws Exception {
        System.out.println("// searching  " + inputFile);

        ParseTree tree = gettree(inputFile);
        searcher ml = new searcher();
        ml.data = data;
        ParseTreeWalker walker = new ParseTreeWalker();
        walker.walk(ml, tree);
        if (!ml.found) {
            System.out.println("nothing was found");
        }
        System.out.println();
    }

    public static ParseTree gettree(String inputFile) throws Exception {
        InputStream is = System.in;
        is = new FileInputStream(inputFile);

        ANTLRInputStream input = new ANTLRInputStream(is);

        pascalLexer lexer = new pascalLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        pascalParser parser = new pascalParser(tokens);
        return parser.program();
    }
}

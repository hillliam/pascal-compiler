package pascal;

import java.util.ArrayDeque;
import org.stringtemplate.v4.*;
import java.io.*;
import org.antlr.v4.runtime.tree.*;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import java.util.List;
import java.util.ArrayList;

class myListener extends pascalBaseListener {

    STGroup stg = new STGroupFile("./js.stg");
    String name = null;

    @Override
    public void exitProgram(pascalParser.ProgramContext ctx) {
        //System.out.println("exit program"); // call main
        ST st = stg.getInstanceOf("exitProgram");
        System.out.println(st.render().toLowerCase());
        System.out.println(name + "();");
    }

    @Override
    public void exitProgramHeading(pascalParser.ProgramHeadingContext ctx) {
        ST st = stg.getInstanceOf("enterProgram");
        name = ctx.getChild(1).getText();
        st.add("v", name);
        System.out.println(st.render().toLowerCase());
    }

    @Override
    public void exitConstantDefinition(pascalParser.ConstantDefinitionContext ctx) {
        //System.out.println("exit Constant Definition"); // DONE
        ST st = stg.getInstanceOf("const");
        List<ParseTree> values = ctx.children;
        ArrayList<String> valueNames = new ArrayList<String>();
        st.add("v", values.get(0).getText());
        for (int i = 2; i < ctx.getChildCount(); i++) {
            valueNames.add(values.get(i).getText());
        }
        st.add("values", valueNames);
        System.out.println(st.render().toLowerCase());
        //System.out.println(ctx.getText());
    }

    @Override
    public void exitTypeDefinition(pascalParser.TypeDefinitionContext ctx) {
        //System.out.println("exit Type Definition");
        ST st = stg.getInstanceOf("globals");
        String name = ctx.getChild(0).getText();
        st.add("values", name);
        System.out.println(st.render().toLowerCase());
        //System.out.println(ctx.getText());
    }

    @Override
    public void enterProcedureDeclaration(pascalParser.ProcedureDeclarationContext ctx) {
        //System.out.println("enter Procedure Declaration");
        ST st = stg.getInstanceOf("enterfunction");
        String name = ctx.identifier().getText();
        st.add("v", name);
        List<ParseTree> values = ctx.children;
        String a = values.get(2).getText();
        String b[] = a.split(",");
        ArrayList<String> valueNames = new ArrayList<String>();
        for (int i = 0; i != b.length; i++) {
            b[i] = b[i].replaceAll("VAR", "");
            b[i] = b[i].replaceAll("var", "");
            b[i] = b[i].replaceAll(";", "");
            b[i] = b[i].replaceAll("[(]", "");
            valueNames.add(b[i].split(":")[0]);
        }
        st.add("values", valueNames);
        System.out.println(st.render().toLowerCase());
    }

    @Override
    public void exitProcedureDeclaration(pascalParser.ProcedureDeclarationContext ctx) {
        ST st = stg.getInstanceOf("exitProgram");
        System.out.println(st.render().toLowerCase());
    }

    @Override
    public void enterFunctionDeclaration(pascalParser.FunctionDeclarationContext ctx) {
        ST st = stg.getInstanceOf("enterfunction");
        String name = ctx.identifier().getText();
        st.add("v", name);
        List<ParseTree> values = ctx.children;
        String a = values.get(2).getText();
        String b[] = a.split(",");
        ArrayList<String> valueNames = new ArrayList<String>();
        for (int i = 0; i != b.length; i++) {
            b[i] = b[i].replaceAll("VAR", "");
            b[i] = b[i].replaceAll("var", "");
            b[i] = b[i].replaceAll(";", "");
            b[i] = b[i].replaceAll("[(]", "");
            valueNames.add(b[i].split(":")[0]);
        }
        st.add("values", valueNames);
        System.out.println(st.render().toLowerCase());
    }

    @Override
    public void exitFunctionDeclaration(pascalParser.FunctionDeclarationContext ctx) {
        ST st = stg.getInstanceOf("exitProgram");
        System.out.println(st.render().toLowerCase());
    }

    @Override
    public void exitVariableDeclaration(pascalParser.VariableDeclarationContext ctx) {
        //System.out.println("exit varible"); //DONE
        ST st = stg.getInstanceOf("globals");
        List<ParseTree> values = ctx.children;
        ArrayList<String> valueNames = new ArrayList<String>();

        for (int i = 0; i < ctx.getChildCount(); i += 2) {
            valueNames.add(values.get(i).getText());
            if (i + 1 < ctx.getChildCount() && ":".equals(values.get(i + 1).getText())) {
                i += 2;
            }
        }
        st.add("values", valueNames);
        System.out.println(st.render().toLowerCase());
        //System.out.println(ctx.getText());
    }

    @Override
    public void exitExitStatement(pascalParser.ExitStatementContext ctx) {
        //System.out.println("exit exit Statement"); //
        //System.out.println(ctx.getText());
        ST st = stg.getInstanceOf("exit");
        System.out.println(st.render().toLowerCase());// done
    }

    @Override
    public void exitAssignmentStatement(pascalParser.AssignmentStatementContext ctx) {
        //System.out.println("exit Assignment Statement");
        ST st = stg.getInstanceOf("assignment");
        String varible = ctx.getChild(0).getText();
        List<ParseTree> values = ctx.children;
        ArrayList<String> valueNames = new ArrayList<String>();
        for (int i = 2; i < ctx.getChildCount(); i++) {
            valueNames.add(values.get(i).getText());
        }
        st.add("v", varible);
        st.add("values", valueNames);
        System.out.println(st.render().toLowerCase());// done
        //System.out.println(ctx.getText());
    }

    @Override
    public void exitProcedureStatement(pascalParser.ProcedureStatementContext ctx) {
        //System.out.println("exit Procedure Statement"); // DONE
        ST st = stg.getInstanceOf("procCall");
        List<ParseTree> values = ctx.children;
        String function = ctx.identifier().getText();
        ArrayList<String> valueNames = new ArrayList<>();
        for (int i = 2; i < ctx.getChildCount() - 1; i++) {
            valueNames.add(values.get(i).getText());
        }
        st.add("v", function);
        st.add("values", valueNames);
        System.out.println(st.render().toLowerCase());
    }

    @Override
    public void exitEmptyreadkey(pascalParser.EmptyreadkeyContext ctx) {
        ST st = stg.getInstanceOf("einput"); // DONE
        //st.add("v", "");
        System.out.println(st.render().toLowerCase());
    }

    @Override
    public void exitEmptyreadln(pascalParser.EmptyreadlnContext ctx) {
        ST st = stg.getInstanceOf("einput"); // DONE
        //st.add("v", "");
        System.out.println(st.render().toLowerCase());
    }

    @Override
    public void exitEmptywrite(pascalParser.EmptywriteContext ctx) {
        ST st = stg.getInstanceOf("eoutput"); // DONE
        st.add("v", "");
        System.out.println(st.render().toLowerCase());
    }

    @Override
    public void exitEmptywriteln(pascalParser.EmptywritelnContext ctx) {
        ST st = stg.getInstanceOf("eoutput"); // DONE
        st.add("v", "\"\\n\"");
        System.out.println(st.render().toLowerCase());
    }

    @Override
    public void exitReadkeystatment(pascalParser.ReadkeystatmentContext ctx) {
        ST st = stg.getInstanceOf("input"); // DONE
        List<ParseTree> values = ctx.children;
        ArrayList<String> valueNames = new ArrayList<>();
        for (int i = 2; i < ctx.getChildCount() - 1; i++) {
            valueNames.add(values.get(i).getText());
        }
        st.add("v", valueNames);
        System.out.println(st.render().toLowerCase());
    }

    @Override
    public void exitReadlnstatment(pascalParser.ReadlnstatmentContext ctx) {
        ST st = stg.getInstanceOf("input"); // DONE
        List<ParseTree> values = ctx.children;
        ArrayList<String> valueNames = new ArrayList<>();
        for (int i = 2; i < ctx.getChildCount() - 1; i++) {
            valueNames.add(values.get(i).getText());
        }
        st.add("v", valueNames);
        System.out.println(st.render().toLowerCase());
    }

    @Override
    public void exitWritestatment(pascalParser.WritestatmentContext ctx) {
        ST st = stg.getInstanceOf("output"); // DONE
        List<ParseTree> values = ctx.children;
        ArrayList<String> valueNames = new ArrayList<>();
        for (int i = 2; i < ctx.getChildCount() - 1; i++) {
            if (",".equals(values.get(i).getText())) {
                continue;
            }
            if ("'".equals(values.get(i).getText())) {
                valueNames.add("\"");
            } else {
                valueNames.add(values.get(i).getText().replaceAll("\'", "\""));
            }
        }
        st.add("v", valueNames);
        System.out.println(st.render().toLowerCase());
    }

    @Override
    public void exitWritelnstatment(pascalParser.WritelnstatmentContext ctx) {
        ST st = stg.getInstanceOf("output"); // DONE
        List<ParseTree> values = ctx.children;
        ArrayList<String> valueNames = new ArrayList<>();
        for (int i = 2; i < ctx.getChildCount() - 1; i++) {
            if (",".equals(values.get(i).getText())) {
                continue;
            }
            if ("'".equals(values.get(i).getText())) {
                valueNames.add("\"");
            } else {
                valueNames.add(values.get(i).getText().replaceAll("\'", "\""));
            }
        }
        valueNames.add("\"\\n\"");
        st.add("v", valueNames);
        System.out.println(st.render().toLowerCase());
    }

    @Override
    public void enterIfStatement(pascalParser.IfStatementContext ctx) {
        //System.out.println("enter if statment");// DONE
        ST st = stg.getInstanceOf("ifClause");
        String valueNames = ctx.expression().getText();
        valueNames = valueNames.replaceAll("=", "==");
        valueNames = valueNames.replaceAll("and", "&&");
        valueNames = valueNames.replaceAll("AND", "&&");
        valueNames = valueNames.replaceAll("or", "||");
        valueNames = valueNames.replaceAll("OR", "||");
        valueNames = valueNames.replaceAll("div", "/");
        valueNames = valueNames.replaceAll("DIV", "/");
        valueNames = valueNames.replaceAll("MOD", "%");
        valueNames = valueNames.replaceAll("mod", "%");
        valueNames = valueNames.replaceAll("NOT", "!");
        valueNames = valueNames.replaceAll("not", "!");
        st.add("comparator", valueNames);
        System.out.println(st.render().toLowerCase());
    }

    @Override
    public void exitIfStatement(pascalParser.IfStatementContext ctx) {
        //System.out.println("exit if statment");
        ST st = stg.getInstanceOf("exitProgram");
        System.out.println(st.render().toLowerCase());
        //System.out.println(ctx.getText());
    }

    @Override
    public void enterCaseStatement(pascalParser.CaseStatementContext ctx) {
        //System.out.println("enter Case statment"); // DONE
        ST st = stg.getInstanceOf("switch"); // DONE
        String valueNames = ctx.expression().getText();
        valueNames = handleexpression(ctx.expression());
        st.add("v", valueNames);
        System.out.println(st.render().toLowerCase());
    }

    @Override
    public void exitCaseStatement(pascalParser.CaseStatementContext ctx) {
        //System.out.println("exit Case statment");// DONE
        ST st = stg.getInstanceOf("exitProgram");
        System.out.println(st.render().toLowerCase());
        //System.out.println(ctx.getText());
    }

    @Override
    public void enterCaseListElement(pascalParser.CaseListElementContext ctx) {
        //System.out.println("enter Case List Element"); //DONE
        ST st = stg.getInstanceOf("case");
        String output = ctx.constList().getText();
        st.add("v", output);
        System.out.println(st.render().toLowerCase());
    }

    @Override
    public void exitCaseListElement(pascalParser.CaseListElementContext ctx) {
        //System.out.println("exit Case List Element"); // DONE
        ST st = stg.getInstanceOf("exitcase");
        System.out.println(st.render().toLowerCase());
    }

    @Override
    public void enterWhileStatement(pascalParser.WhileStatementContext ctx) {
        //System.out.println("enter while Statement"); //DONE
        ST st = stg.getInstanceOf("whileLoop");
        String it = ctx.expression().getText();
        it = handleexpression(ctx.expression());
        st.add("comparator", it);
        System.out.println(st.render().toLowerCase());
    }

    @Override
    public void exitWhileStatement(pascalParser.WhileStatementContext ctx) {
        //System.out.println("exit while Statement");//DONE
        ST st = stg.getInstanceOf("exitProgram");
        System.out.println(st.render().toLowerCase());
        //System.out.println(ctx.getText());
    }

    @Override
    public void enterRepeatStatement(pascalParser.RepeatStatementContext ctx) {
        //System.out.println("enter Repeat Statement"); // DONE
        ST st = stg.getInstanceOf("repeat");
        System.out.println(st.render().toLowerCase());
    }

    @Override
    public void exitRepeatStatement(pascalParser.RepeatStatementContext ctx) {
        //System.out.println("exit Repeat Statement"); // DONE
        ST st = stg.getInstanceOf("exitrepeat");
        String output = ctx.expression().getText();
        if (output != null) {
            output = handleexpression(ctx.expression());
            st.add("comparator", output);
        }
        System.out.println(st.render().toLowerCase());

        //System.out.println(ctx.getText());
    }

    public String handleexpression(pascalParser.ExpressionContext ctx) {
        String valueNames = "";
        for (int i = 0; i != ctx.getChildCount(); i++) {
            if ("=".equals(ctx.getChild(i).getText())) {
                if ("<=".equals(ctx.getChild(i).getText()) || ">=".equals(ctx.getChild(i).getText())) {
                } else {
                    valueNames += "==";
                }
            } else if (("and".equals(ctx.getChild(i).getText()) || "AND".equals(ctx.getChild(i).getText()))) {
                valueNames +="&&";
            } else if (("or".equals(ctx.getChild(i).getText()) || "OR".equals(ctx.getChild(i).getText()))) {
                valueNames +="||";
            } else if (("DIV".equals(ctx.getChild(i).getText()) || "DIV".equals(ctx.getChild(i).getText()))) {
                valueNames +="/";
            } else if (("mod".equals(ctx.getChild(i).getText()) || "MOD".equals(ctx.getChild(i).getText()))) {
                valueNames +="%";
            } else if (("not".equals(ctx.getChild(i).getText()) || "NOT".equals(ctx.getChild(i).getText()))) {
                valueNames +="!";
            }
            else
            {
                valueNames += ctx.getChild(i).getText();
            }
        }
        return valueNames;
    }

    @Override
    public void enterForStatement(pascalParser.ForStatementContext ctx) {
        //System.out.println("enter For Statement"); //DONE
        ST st = stg.getInstanceOf("for");
        String output = ctx.identifier().getText();
        String start = ctx.forList().initialValue().getText();
        String end = ctx.forList().finalValue().getText();
        st.add("v", output);
        st.add("start", start);
        st.add("end", end);
        if (("DOWNTO".equals(ctx.forList().getChild(1).getText())) || ("downto".equals(ctx.forList().getChild(1).getText()))) {
            st.add("i", "--");
        } else {
            st.add("i", "++");
        }
        System.out.println(st.render().toLowerCase());
    }

    @Override
    public void exitForStatement(pascalParser.ForStatementContext ctx) {
        //System.out.println("exit For Statement"); //DONE
        ST st = stg.getInstanceOf("exitProgram");
        System.out.println(st.render().toLowerCase());
        //System.out.println(ctx.getText());
    }

} // class myListener

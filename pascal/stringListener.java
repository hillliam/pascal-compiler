package pascal;

import java.util.ArrayDeque;
import org.stringtemplate.v4.*;
import java.io.*;
import org.antlr.v4.runtime.tree.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.*;
import java.util.List;
import java.util.ArrayList;

class stringListener extends pascalBaseListener {

    STGroup stg = new STGroupFile("./xml.stg");

    //ATN options; 
    //PredictionMode a = PredictionMode.LL;
    @Override
    public void enterProgram(pascalParser.ProgramContext ctx) {
        ST st = stg.getInstanceOf("enterProgram"); //DONE
        System.out.println(st.render());
    }

    @Override
    public void exitProgram(pascalParser.ProgramContext ctx) {
        ST st = stg.getInstanceOf("exitProgram"); //DONE
        System.out.println(st.render());
    }

    @Override
    public void exitProgramHeading(pascalParser.ProgramHeadingContext ctx) {
        ST st = stg.getInstanceOf("exitheading"); //DONE
        st.add("v", ctx.getChild(1).getText());
        System.out.println(st.render());

    }

    @Override
    public void enterBlock(pascalParser.BlockContext ctx) {
        ST st = stg.getInstanceOf("enterblock");
        System.out.println(st.render());
    }

    @Override
    public void exitBlock(pascalParser.BlockContext ctx) {
        ST st = stg.getInstanceOf("exitblock");
        System.out.println(st.render());
    }

    @Override
    public void exitUsesUnitsPart(pascalParser.UsesUnitsPartContext ctx) {
        //System.out.println("exit Uses Units Part"); // DONE
        ST st = stg.getInstanceOf("enterdep");
        st.add("v", ctx.identifierList().getText());
        System.out.println(st.render());
        //System.out.println(ctx.getText());
    }

    @Override
    public void enterStatement(pascalParser.StatementContext ctx) {
        if (ctx.label() != null) {
            ST st = stg.getInstanceOf("enterlabel");
            st.add("v", ctx.getChild(0).getText());
            System.out.println(st.render());
        }
    }

    @Override
    public void exitConstantDefinition(pascalParser.ConstantDefinitionContext ctx) {
        //System.out.println("exit Constant Definition"); // Done
        ST st = stg.getInstanceOf("const");
        List<ParseTree> values = ctx.children;
        ArrayList<String> valueNames = new ArrayList<String>();
        st.add("v", values.get(0).getText());
        for (int i = 2; i < ctx.getChildCount(); i++) {
            valueNames.add(values.get(i).getText());
        }
        st.add("value", valueNames);
        System.out.println(st.render());
        //System.out.println(ctx.getText());
    }

    @Override
    public void enterSign(pascalParser.SignContext ctx) {
        System.out.println("enter sign");
    }

    @Override
    public void exitSign(pascalParser.SignContext ctx) {
        System.out.println("exit sign");
        System.out.println(ctx.getText());
    }

    @Override
    public void exitTypeDefinition(pascalParser.TypeDefinitionContext ctx) {
        //System.out.println("exit Type Definition");
        ST st = stg.getInstanceOf("enterarray");
        String output = ctx.getChild(0).getText();
        String max = ctx.getChild(2).getText();
        st.add("v", output);
        st.add("max", max);
        System.out.println(st.render());
        //System.out.println(ctx.getText());
    }

    @Override
    public void enterFunctionType(pascalParser.FunctionTypeContext ctx) {
        System.out.println("enter Function Type");
    }

    @Override
    public void exitFunctionType(pascalParser.FunctionTypeContext ctx) {
        System.out.println("exit Function Type");
        System.out.println(ctx.getText());
    }

    @Override
    public void enterProcedureType(pascalParser.ProcedureTypeContext ctx) {
        System.out.println("enter Procedure Type");
    }

    @Override
    public void exitProcedureType(pascalParser.ProcedureTypeContext ctx) {
        System.out.println("exit Procedure Type");
        System.out.println(ctx.getText());
    }

    @Override
    public void enterScalarType(pascalParser.ScalarTypeContext ctx) {
        System.out.println("enter Scalar Type");
    }

    @Override
    public void exitScalarType(pascalParser.ScalarTypeContext ctx) {
        System.out.println("exit Scalar Type");
        System.out.println(ctx.getText());
    }

    @Override
    public void enterStringtype(pascalParser.StringtypeContext ctx) {
        System.out.println("enter string Type");
    }

    @Override
    public void exitStringtype(pascalParser.StringtypeContext ctx) {
        System.out.println("exit string Type");
        System.out.println(ctx.getText());
    }

    @Override
    public void enterVariantPart(pascalParser.VariantPartContext ctx) {
        System.out.println("enter Variant Part");
    }

    @Override
    public void exitVariantPart(pascalParser.VariantPartContext ctx) {
        System.out.println("exit Variant Part");
        System.out.println(ctx.getText());
    }

    @Override
    public void enterTag(pascalParser.TagContext ctx) {
        System.out.println("enter tag");
    }

    @Override
    public void exitTag(pascalParser.TagContext ctx) {
        System.out.println("exit tag");
        System.out.println(ctx.getText());
    }

    @Override
    public void enterVariant(pascalParser.VariantContext ctx) {
        System.out.println("enter Variant");
    }

    @Override
    public void exitVariant(pascalParser.VariantContext ctx) {
        System.out.println("exit Variant");
        System.out.println(ctx.getText());
    }

    @Override
    public void exitVariableDeclaration(pascalParser.VariableDeclarationContext ctx) {
        //System.out.println("exit Varible");
        List<ParseTree> values = ctx.children;
        for (int i = 0; i < ctx.getChildCount(); i += 2) {
            if (values.get(i).getText().contains(",")) {
                String array[] = values.get(i).getText().split(",");
                for (String value : array) {
                    ST st = stg.getInstanceOf("globals");
                    st.add("v", value);
                    System.out.println(st.render());
                }
            } else {
                ST st = stg.getInstanceOf("globals");
                st.add("v", values.get(i).getText());
                System.out.println(st.render());
                if (i + 1 < ctx.getChildCount() && ":".equals(values.get(i + 1).getText())) {
                    i += 2;
                }
            }
            //System.out.println(ctx.getText());
        }
    }

    @Override
    public void enterProcedureDeclaration(pascalParser.ProcedureDeclarationContext ctx) {
        ST st = stg.getInstanceOf("enterprocedure"); // DONE
        String name = ctx.identifier().getText();
        st.add("v", name);
        List<ParseTree> values = ctx.children;
        String a = values.get(2).getText();
        st.add("values", a);
        System.out.println(st.render());
    }

    @Override
    public void exitProcedureDeclaration(pascalParser.ProcedureDeclarationContext ctx) {
        ST st = stg.getInstanceOf("exitprocedure"); //DONE
        System.out.println(st.render());
    }

    @Override
    public void enterFunctionDeclaration(pascalParser.FunctionDeclarationContext ctx) {
        ST st = stg.getInstanceOf("enterfunction"); //DONE
        String name = ctx.identifier().getText();
        st.add("v", name);
        List<ParseTree> values = ctx.children;
        String a = values.get(2).getText();
        //st.add("values", a);
        System.out.println(st.render());
    }

    @Override
    public void exitFunctionDeclaration(pascalParser.FunctionDeclarationContext ctx) {
        ST st = stg.getInstanceOf("exitfunction");// DONE
        System.out.println(st.render());
    }

    @Override
    public void enterDirective(pascalParser.DirectiveContext ctx) {
        System.out.println("enter Directive");
    }

    @Override
    public void exitDirective(pascalParser.DirectiveContext ctx) {
        System.out.println("exit Directive");
        System.out.println(ctx.getText());
    }

    @Override
    public void enterConstList(pascalParser.ConstListContext ctx) {
        System.out.println("enter Const List");
    }

    @Override
    public void exitConstList(pascalParser.ConstListContext ctx) {
        System.out.println("exit Const List");
        System.out.println(ctx.getText());
    }

    @Override
    public void exitExitStatement(pascalParser.ExitStatementContext ctx) {
        //System.out.println("exit exit Statement");
        //System.out.println(ctx.getText());
        ST st = stg.getInstanceOf("exit");
        System.out.println(st.render());// done
    }

    @Override
    public void exitAssignmentStatement(pascalParser.AssignmentStatementContext ctx) {
        ST st = stg.getInstanceOf("instruction"); // DONE
        st.add("v", ctx.getText());
        System.out.println(st.render());
    }

    @Override
    public void exitProcedureStatement(pascalParser.ProcedureStatementContext ctx) {
        ST st = stg.getInstanceOf("instruction"); // DONE
        st.add("v", ctx.getText());
        System.out.println(st.render());
    }

    @Override
    public void exitGotoStatement(pascalParser.GotoStatementContext ctx) {
        //System.out.println("exit goto statment"); // DONE
        ST st = stg.getInstanceOf("goto");
        st.add("v", ctx.getChild(1).getText());
        System.out.println(st.render());
        //System.out.println(ctx.getText());
    }

    @Override
    public void enterIfStatement(pascalParser.IfStatementContext ctx) {
        //System.out.println("enter if statment"); // DONE
        ST st = stg.getInstanceOf("enterif");
        String output = ctx.getChild(1).getText();
        st.add("v", output);
        System.out.println(st.render());
    }

    @Override
    public void exitIfStatement(pascalParser.IfStatementContext ctx) {
        //System.out.println("exit if statment"); // DONE
        ST st = stg.getInstanceOf("exitif");
        System.out.println(st.render());
        //System.out.println(ctx.getText());
    }

    @Override
    public void enterCaseStatement(pascalParser.CaseStatementContext ctx) {
        //System.out.println("enter Case statment"); / almost
        ST st = stg.getInstanceOf("entercase");
        String output = ctx.getChild(1).getText();
        ArrayList<String> valueNames = new ArrayList<String>();

        for (int i = 2; (i < ctx.getChild(i).getChildCount() && !("ELSE".equals(ctx.getChild(i).getText()) || "End".equals(ctx.getChild(i).getText()))); i++) {
            valueNames.add(ctx.getChild(i).getText());
        }
        st.add("v", output);
        st.add("values", valueNames);
        System.out.println(st.render());
    }

    @Override
    public void exitCaseStatement(pascalParser.CaseStatementContext ctx) {
        //System.out.println("exit Case statment"); //DONE
        ST st = stg.getInstanceOf("exitcase");
        System.out.println(st.render());
        //System.out.println(ctx.getText());
    }

    @Override
    public void enterCaseListElement(pascalParser.CaseListElementContext ctx) {
        System.out.println("enter Case List Element");
    }

    @Override
    public void exitCaseListElement(pascalParser.CaseListElementContext ctx) {
        System.out.println("exit Case List Element");
        System.out.println(ctx.getText());
    }

    @Override
    public void enterWhileStatement(pascalParser.WhileStatementContext ctx) {
        //System.out.println("enter while Statement"); // DONE
        ST st = stg.getInstanceOf("enterwhile");
        String output = ctx.getChild(1).getText();
        st.add("v", output);
        System.out.println(st.render());
    }

    @Override
    public void exitWhileStatement(pascalParser.WhileStatementContext ctx) {
        //System.out.println("exit while Statement"); // DONE
        ST st = stg.getInstanceOf("exitwhile");
        System.out.println(st.render());
        //System.out.println(ctx.getText());
    }

    @Override
    public void enterRepeatStatement(pascalParser.RepeatStatementContext ctx) {
        //System.out.println("enter Repeat Statement"); // DONE
        ST st = stg.getInstanceOf("enterrepeat");
        String output = ctx.expression().getText();
        if (output != null) {
            st.add("v", output);
        }
        System.out.println(st.render());

    }

    @Override
    public void exitRepeatStatement(pascalParser.RepeatStatementContext ctx) {
        //System.out.println("exit Repeat Statement"); // DONE
        ST st = stg.getInstanceOf("exitrepeat");
        System.out.println(st.render());
        //System.out.println(ctx.getText());
    }

    @Override
    public void enterForStatement(pascalParser.ForStatementContext ctx) {
        //System.out.println("enter For Statement"); // DONE
        ST st = stg.getInstanceOf("enterfor");
        String output = ctx.getChild(1).getText();
        String max = ctx.getChild(3).getText();
        st.add("v", output);
        st.add("max", max);
        System.out.println(st.render());
    }

    @Override
    public void exitForStatement(pascalParser.ForStatementContext ctx) {
        //System.out.println("exit For Statement"); // DONE
        ST st = stg.getInstanceOf("exitfor");
        System.out.println(st.render());
        //System.out.println(ctx.getText());
    }

    @Override
    public void enterWithStatement(pascalParser.WithStatementContext ctx) {
        //System.out.println("enter With Statement"); // DONE
        ST st = stg.getInstanceOf("enterwith");
        String output = ctx.getChild(1).getText();
        st.add("v", output);
        System.out.println(st.render());
    }

    @Override
    public void exitWithStatement(pascalParser.WithStatementContext ctx) {
        //System.out.println("exit With Statement"); // DONE
        ST st = stg.getInstanceOf("exitwith");
        System.out.println(st.render());
        //System.out.println(ctx.getText());
    }

    @Override
    public void enterRecordVariableList(pascalParser.RecordVariableListContext ctx) {
        System.out.println("enter Record Variable List");
    }

    @Override
    public void exitRecordVariableList(pascalParser.RecordVariableListContext ctx) {
        System.out.println("exit Record Variable List");
        System.out.println(ctx.getText());

    }

    @Override
    public void exitEmptyreadkey(pascalParser.EmptyreadkeyContext ctx) {
        ST st = stg.getInstanceOf("input"); //DONE
        st.add("v", "");
        st.add("line", "false");
        System.out.println(st.render());
    }

    @Override
    public void exitEmptyreadln(pascalParser.EmptyreadlnContext ctx) {
        ST st = stg.getInstanceOf("input"); //DONE
        st.add("v", "");
        st.add("line", "true");
        System.out.println(st.render());
    }

    @Override
    public void exitEmptywrite(pascalParser.EmptywriteContext ctx) {
        ST st = stg.getInstanceOf("output"); //DONE
        st.add("v", "");
        st.add("line", "false");
        System.out.println(st.render());
    }

    @Override
    public void exitEmptywriteln(pascalParser.EmptywritelnContext ctx) {
        ST st = stg.getInstanceOf("output"); //DONE
        st.add("v", "");
        st.add("line", "true");
        System.out.println(st.render());
    }

    @Override
    public void exitReadkeystatment(pascalParser.ReadkeystatmentContext ctx) {
        ST st = stg.getInstanceOf("input"); //DONE
        st.add("v", ctx.getText());
        st.add("line", "false");
        System.out.println(st.render());
    }

    @Override
    public void exitReadlnstatment(pascalParser.ReadlnstatmentContext ctx) {
        ST st = stg.getInstanceOf("input"); //DONE
        st.add("v", ctx.getText());
        st.add("line", "true");
        System.out.println(st.render());
    }

    @Override
    public void exitWritestatment(pascalParser.WritestatmentContext ctx) {
        ST st = stg.getInstanceOf("output"); //DONE
        st.add("v", ctx.getText());
        st.add("line", "false");
        System.out.println(st.render());
    }

    @Override
    public void exitWritelnstatment(pascalParser.WritelnstatmentContext ctx) {
        ST st = stg.getInstanceOf("output"); //DONE
        st.add("v", ctx.getText());
        st.add("line", "true");
        System.out.println(st.render());
    }

} // class myListener


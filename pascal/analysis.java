package pascal;

import java.util.ArrayDeque;
import org.stringtemplate.v4.*;
import java.io.*;
import org.antlr.v4.runtime.tree.*;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import java.util.List;
import java.util.Map;

class analysis extends pascalBaseListener {
private Map<String, varible> assigned;
    @Override
    public void exitConstantDefinition(pascalParser.ConstantDefinitionContext ctx) {// detect varibles

    }

    @Override
    public void exitVariableDeclaration(pascalParser.VariableDeclarationContext ctx) {// detect varibles

    }

    @Override
    public void exitAssignmentStatement(pascalParser.AssignmentStatementContext ctx) {// check usage assignment

    }

    @Override
    public void exitProcedureStatement(pascalParser.ProcedureStatementContext ctx) { // check usage

    }

    @Override
    public void exitReadlnstatment(pascalParser.ReadlnstatmentContext ctx) {// check assignment

    }

    @Override
    public void exitReadkeystatment(pascalParser.ReadkeystatmentContext ctx) {// check assignment

    }

    @Override
    public void exitWritestatment(pascalParser.WritestatmentContext ctx) {// check usage

    }

    @Override
    public void exitWritelnstatment(pascalParser.WritelnstatmentContext ctx) {// check usage

    }

    @Override
    public void enterIfStatement(pascalParser.IfStatementContext ctx) {// check usage

    }
} // class myListener
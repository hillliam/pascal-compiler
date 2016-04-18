package pascal;

import java.util.ArrayDeque;
import org.stringtemplate.v4.*;
import java.io.*;
import org.antlr.v4.runtime.tree.*;
import org.antlr.v4.runtime.*;
import java.util.List;
import java.util.ArrayList;

class easyListener extends pascalBaseListener {

    public int indentation = 0;
    public boolean contence = false;

    public void increase() {
        indentation++;
    }

    public void decrease() {
        indentation--;
    }

    public String getindentation() {
        String a = "";
        for (int i = 0; i != indentation; i++) {
            a = a.concat("\t");
        }
        return a;
    }

    @Override
    public void enterProgram(pascalParser.ProgramContext ctx) {
        increase();
        System.out.println(getindentation() + "enter program");
        if (contence) {
            System.out.println(getindentation() + ctx.getText());
        }
    }

    @Override
    public void exitProgram(pascalParser.ProgramContext ctx) {
        System.out.println(getindentation() + "exit program");
        decrease();
    }

    @Override
    public void enterProgramHeading(pascalParser.ProgramHeadingContext ctx) {
        increase();
        System.out.println(getindentation() + "enter Program Heading");
        if (contence) {
            System.out.println(getindentation() + ctx.getText());
        }
    }

    @Override
    public void exitProgramHeading(pascalParser.ProgramHeadingContext ctx) {
        System.out.println(getindentation() + "exit Program Heading");
        decrease();
    }

    @Override
    public void enterIdentifier(pascalParser.IdentifierContext ctx) {
        increase();
        System.out.println(getindentation() + "enter Identifier");
        if (contence) {
            System.out.println(getindentation() + ctx.getText());
        }
    }

    @Override
    public void exitIdentifier(pascalParser.IdentifierContext ctx) {
        System.out.println(getindentation() + "exit Identifier");
        decrease();
    }

    @Override
    public void enterBlock(pascalParser.BlockContext ctx) {
        increase();
        System.out.println(getindentation() + "enter Block");
        if (contence) {
            System.out.println(getindentation() + ctx.getText());
        }
    }

    @Override
    public void exitBlock(pascalParser.BlockContext ctx) {
        System.out.println(getindentation() + "exit Block");
        decrease();
    }

    @Override
    public void enterUsesUnitsPart(pascalParser.UsesUnitsPartContext ctx) {
        increase();
        System.out.println(getindentation() + "enter Uses Units Part");
        if (contence) {
            System.out.println(getindentation() + ctx.getText());
        }
    }

    @Override
    public void exitUsesUnitsPart(pascalParser.UsesUnitsPartContext ctx) {
        System.out.println(getindentation() + "exit Uses Units Part");
        decrease();
    }

    @Override
    public void enterLabelDeclarationPart(pascalParser.LabelDeclarationPartContext ctx) {
        increase();
        System.out.println(getindentation() + "enter Label Declaration Part");
        if (contence) {
            System.out.println(getindentation() + ctx.getText());
        }
    }

    @Override
    public void exitLabelDeclarationPart(pascalParser.LabelDeclarationPartContext ctx) {
        System.out.println(getindentation() + "exit Label Declaration Part");
        decrease();
    }

    @Override
    public void enterLabel(pascalParser.LabelContext ctx) {
        increase();
        System.out.println(getindentation() + "enter Label");
        if (contence) {
            System.out.println(getindentation() + ctx.getText());
        }
    }

    @Override
    public void exitLabel(pascalParser.LabelContext ctx) {
        System.out.println(getindentation() + "exit Label");
        decrease();
    }

    @Override
    public void enterConstantDefinitionPart(pascalParser.ConstantDefinitionPartContext ctx) {
        increase();
        System.out.println(getindentation() + "enter Constant Definition Part");
        if (contence) {
            System.out.println(getindentation() + ctx.getText());
        }
    }

    @Override
    public void exitConstantDefinitionPart(pascalParser.ConstantDefinitionPartContext ctx) {
        System.out.println(getindentation() + "exit Constant Definition Part");
        decrease();
    }

    @Override
    public void enterConstantDefinition(pascalParser.ConstantDefinitionContext ctx) {
        increase();
        System.out.println(getindentation() + "enter Constant Definition");
        if (contence) {
            System.out.println(getindentation() + ctx.getText());
        }
    }

    @Override
    public void exitConstantDefinition(pascalParser.ConstantDefinitionContext ctx) {
        System.out.println(getindentation() + "exit Constant Definition");
        decrease();
    }

    @Override
    public void enterConstantChr(pascalParser.ConstantChrContext ctx) {
        increase();
        System.out.println(getindentation() + "enter Constant Chr");
        if (contence) {
            System.out.println(getindentation() + ctx.getText());
        }
    }

    @Override
    public void exitConstantChr(pascalParser.ConstantChrContext ctx) {
        System.out.println(getindentation() + "exit Constant Chr");
        decrease();
    }

    @Override
    public void enterConstant(pascalParser.ConstantContext ctx) {
        increase();
        System.out.println(getindentation() + "enter Constant");
        if (contence) {
            System.out.println(getindentation() + ctx.getText());
        }
    }

    @Override
    public void exitConstant(pascalParser.ConstantContext ctx) {
        System.out.println(getindentation() + "exit Constant");
        decrease();
    }

    @Override
    public void enterUnsignedNumber(pascalParser.UnsignedNumberContext ctx) {
        increase();
        System.out.println(getindentation() + "enter Unsigned Number");
        if (contence) {
            System.out.println(getindentation() + ctx.getText());
        }
    }

    @Override
    public void exitUnsignedNumber(pascalParser.UnsignedNumberContext ctx) {
        System.out.println(getindentation() + "exit Unsigned Number");
        decrease();
    }

    @Override
    public void enterUnsignedInteger(pascalParser.UnsignedIntegerContext ctx) {
        increase();
        System.out.println(getindentation() + "enter Unsigned Integer");
        if (contence) {
            System.out.println(getindentation() + ctx.getText());
        }
    }

    @Override
    public void exitUnsignedInteger(pascalParser.UnsignedIntegerContext ctx) {
        System.out.println(getindentation() + "exit Unsigned Integer");
        decrease();
    }

    @Override
    public void enterUnsignedReal(pascalParser.UnsignedRealContext ctx) {
        increase();
        System.out.println(getindentation() + "enter Unsigned Real");
        if (contence) {
            System.out.println(getindentation() + ctx.getText());
        }
    }

    @Override
    public void exitUnsignedReal(pascalParser.UnsignedRealContext ctx) {
        System.out.println(getindentation() + "exit Unsigned Real");
        decrease();
    }

    @Override
    public void enterSign(pascalParser.SignContext ctx) {
        increase();
        System.out.println(getindentation() + "enter Sign");
        if (contence) {
            System.out.println(getindentation() + ctx.getText());
        }
    }

    @Override
    public void exitSign(pascalParser.SignContext ctx) {
        System.out.println(getindentation() + "exit Sign");
        decrease();
    }

    @Override
    public void enterString(pascalParser.StringContext ctx) {
        increase();
        System.out.println(getindentation() + "enter String");
        if (contence) {
            System.out.println(getindentation() + ctx.getText());
        }
    }

    @Override
    public void exitString(pascalParser.StringContext ctx) {
        System.out.println(getindentation() + "exit String");
        decrease();
    }

    @Override
    public void enterTypeDefinitionPart(pascalParser.TypeDefinitionPartContext ctx) {
        increase();
        System.out.println(getindentation() + "enter Type Definition Part");
        if (contence) {
            System.out.println(getindentation() + ctx.getText());
        }
    }

    @Override
    public void exitTypeDefinitionPart(pascalParser.TypeDefinitionPartContext ctx) {
        System.out.println(getindentation() + "exit Type Definition Part");
        decrease();
    }

    @Override
    public void enterTypeDefinition(pascalParser.TypeDefinitionContext ctx) {
        increase();
        System.out.println(getindentation() + "enter Type Definition");
        if (contence) {
            System.out.println(getindentation() + ctx.getText());
        }
    }

    @Override
    public void exitTypeDefinition(pascalParser.TypeDefinitionContext ctx) {
        System.out.println(getindentation() + "exit Type Definition");
        decrease();
    }

    @Override
    public void enterFunctionType(pascalParser.FunctionTypeContext ctx) {
        increase();
        System.out.println(getindentation() + "enter Function Type");
        if (contence) {
            System.out.println(getindentation() + ctx.getText());
        }
    }

    @Override
    public void exitFunctionType(pascalParser.FunctionTypeContext ctx) {
        System.out.println(getindentation() + "exit Function Type");
        decrease();
    }

    @Override
    public void enterProcedureType(pascalParser.ProcedureTypeContext ctx) {
        increase();
        System.out.println(getindentation() + "enter Procedure Type");
        if (contence) {
            System.out.println(getindentation() + ctx.getText());
        }
    }

    @Override
    public void exitProcedureType(pascalParser.ProcedureTypeContext ctx) {
        System.out.println(getindentation() + "exit Procedure Type");
        decrease();
    }

    @Override
    public void enterType(pascalParser.TypeContext ctx) {
        increase();
        System.out.println(getindentation() + "enter Type");
        if (contence) {
            System.out.println(getindentation() + ctx.getText());
        }
    }

    @Override
    public void exitType(pascalParser.TypeContext ctx) {
        System.out.println(getindentation() + "exit Type");
        decrease();
    }

    @Override
    public void enterSimpleType(pascalParser.SimpleTypeContext ctx) {
        increase();
        System.out.println(getindentation() + "enter Simple Type");
        if (contence) {
            System.out.println(getindentation() + ctx.getText());
        }
    }

    @Override
    public void exitSimpleType(pascalParser.SimpleTypeContext ctx) {
        System.out.println(getindentation() + "exit Simple Type");
        decrease();
    }

    @Override
    public void enterScalarType(pascalParser.ScalarTypeContext ctx) {
        increase();
        System.out.println(getindentation() + "enter Scalar Type");
        if (contence) {
            System.out.println(getindentation() + ctx.getText());
        }
    }

    @Override
    public void exitScalarType(pascalParser.ScalarTypeContext ctx) {
        System.out.println(getindentation() + "exit Scalar Type");
        decrease();
    }

    @Override
    public void enterSubrangeType(pascalParser.SubrangeTypeContext ctx) {
        increase();
        System.out.println(getindentation() + "enter Subrange Type");
        if (contence) {
            System.out.println(getindentation() + ctx.getText());
        }
    }

    @Override
    public void exitSubrangeType(pascalParser.SubrangeTypeContext ctx) {
        System.out.println(getindentation() + "exit Subrange Type");
        decrease();
    }

    @Override
    public void enterTypeIdentifier(pascalParser.TypeIdentifierContext ctx) {
        increase();
        System.out.println(getindentation() + "enter Type Identifier");
        if (contence) {
            System.out.println(getindentation() + ctx.getText());
        }
    }

    @Override
    public void exitTypeIdentifier(pascalParser.TypeIdentifierContext ctx) {
        System.out.println(getindentation() + "exit Type Identifier");
        decrease();
    }

    @Override
    public void enterStructuredType(pascalParser.StructuredTypeContext ctx) {
        increase();
        System.out.println(getindentation() + "enter Structured Type");
        if (contence) {
            System.out.println(getindentation() + ctx.getText());
        }
    }

    @Override
    public void exitStructuredType(pascalParser.StructuredTypeContext ctx) {
        System.out.println(getindentation() + "exit Structured Type");
        decrease();
    }

    @Override
    public void enterUnpackedStructuredType(pascalParser.UnpackedStructuredTypeContext ctx) {
        increase();
        System.out.println(getindentation() + "enter Unpacked Structured Type");
        if (contence) {
            System.out.println(getindentation() + ctx.getText());
        }
    }

    @Override
    public void exitUnpackedStructuredType(pascalParser.UnpackedStructuredTypeContext ctx) {
        System.out.println(getindentation() + "exit Unpacked Structured Type");
        decrease();
    }

    @Override
    public void enterStringtype(pascalParser.StringtypeContext ctx) {
        increase();
        System.out.println(getindentation() + "enter String type");
        if (contence) {
            System.out.println(getindentation() + ctx.getText());
        }
    }

    @Override
    public void exitStringtype(pascalParser.StringtypeContext ctx) {
        System.out.println(getindentation() + "exit String type");
        decrease();
    }

    @Override
    public void enterArrayType(pascalParser.ArrayTypeContext ctx) {
        increase();
        System.out.println(getindentation() + "enter Array Type");
        if (contence) {
            System.out.println(getindentation() + ctx.getText());
        }
    }

    @Override
    public void exitArrayType(pascalParser.ArrayTypeContext ctx) {
        System.out.println(getindentation() + "exit Array Type");
        decrease();
    }

    @Override
    public void enterTypeList(pascalParser.TypeListContext ctx) {
        increase();
        System.out.println(getindentation() + "enter Type List");
        if (contence) {
            System.out.println(getindentation() + ctx.getText());
        }
    }

    @Override
    public void exitTypeList(pascalParser.TypeListContext ctx) {
        System.out.println(getindentation() + "exit Type List");
        decrease();
    }

    @Override
    public void enterIndexType(pascalParser.IndexTypeContext ctx) {
        increase();
        System.out.println(getindentation() + "enter Index Type");
        if (contence) {
            System.out.println(getindentation() + ctx.getText());
        }
    }

    @Override
    public void exitIndexType(pascalParser.IndexTypeContext ctx) {
        System.out.println(getindentation() + "exit Index Type");
        decrease();
    }

    @Override
    public void enterComponentType(pascalParser.ComponentTypeContext ctx) {
        increase();
        System.out.println(getindentation() + "enter Component Type");
        if (contence) {
            System.out.println(getindentation() + ctx.getText());
        }
    }

    @Override
    public void exitComponentType(pascalParser.ComponentTypeContext ctx) {
        System.out.println(getindentation() + "exit Component Type");
        decrease();
    }

    @Override
    public void enterRecordType(pascalParser.RecordTypeContext ctx) {
        increase();
        System.out.println(getindentation() + "enter Record Type");
        if (contence) {
            System.out.println(getindentation() + ctx.getText());
        }
    }

    @Override
    public void exitRecordType(pascalParser.RecordTypeContext ctx) {
        System.out.println(getindentation() + "exit Record Type");
        decrease();
    }

    @Override
    public void enterFieldList(pascalParser.FieldListContext ctx) {
        increase();
        System.out.println(getindentation() + "enter Field List");
        if (contence) {
            System.out.println(getindentation() + ctx.getText());
        }
    }

    @Override
    public void exitFieldList(pascalParser.FieldListContext ctx) {
        System.out.println(getindentation() + "exit Field List");
        decrease();
    }

    @Override
    public void enterFixedPart(pascalParser.FixedPartContext ctx) {
        increase();
        System.out.println(getindentation() + "enter Fixed Part");
        if (contence) {
            System.out.println(getindentation() + ctx.getText());
        }
    }

    @Override
    public void exitFixedPart(pascalParser.FixedPartContext ctx) {
        System.out.println(getindentation() + "exit Fixed Part");
        decrease();
    }

    @Override
    public void enterRecordSection(pascalParser.RecordSectionContext ctx) {
        increase();
        System.out.println(getindentation() + "enter Record Section");
        if (contence) {
            System.out.println(getindentation() + ctx.getText());
        }
    }

    @Override
    public void exitRecordSection(pascalParser.RecordSectionContext ctx) {
        System.out.println(getindentation() + "exit Record Section");
        decrease();
    }

    @Override
    public void enterVariantPart(pascalParser.VariantPartContext ctx) {
        increase();
        System.out.println(getindentation() + "enter Variant Part");
        if (contence) {
            System.out.println(getindentation() + ctx.getText());
        }
    }

    @Override
    public void exitVariantPart(pascalParser.VariantPartContext ctx) {
        System.out.println(getindentation() + "exit Variant Part");
        decrease();
    }

    @Override
    public void enterTag(pascalParser.TagContext ctx) {
        increase();
        System.out.println(getindentation() + "enter Tag");
        if (contence) {
            System.out.println(getindentation() + ctx.getText());
        }
    }

    @Override
    public void exitTag(pascalParser.TagContext ctx) {
        System.out.println(getindentation() + "exit Tag");
        decrease();
    }

    @Override
    public void enterVariant(pascalParser.VariantContext ctx) {
        increase();
        System.out.println(getindentation() + "enter Variant");
        if (contence) {
            System.out.println(getindentation() + ctx.getText());
        }
    }

    @Override
    public void exitVariant(pascalParser.VariantContext ctx) {
        System.out.println(getindentation() + "exit Variant");
        decrease();
    }

    @Override
    public void enterSetType(pascalParser.SetTypeContext ctx) {
        increase();
        System.out.println(getindentation() + "enter Set Type");
        if (contence) {
            System.out.println(getindentation() + ctx.getText());
        }
    }

    @Override
    public void exitSetType(pascalParser.SetTypeContext ctx) {
        System.out.println(getindentation() + "exit Set Type");
        decrease();
    }

    @Override
    public void enterInputoutputstatment(pascalParser.InputoutputstatmentContext ctx) {
        increase();
        System.out.println(getindentation() + "enter Input output statment");
        if (contence) {
            System.out.println(getindentation() + ctx.getText());
        }
    }

    @Override
    public void exitInputoutputstatment(pascalParser.InputoutputstatmentContext ctx) {
        System.out.println(getindentation() + "exit Input output statment");
        decrease();
    }

    @Override
    public void enterReadkey(pascalParser.ReadkeyContext ctx) {
        increase();
        System.out.println(getindentation() + "enter Readkey");
        if (contence) {
            System.out.println(getindentation() + ctx.getText());
        }
    }

    @Override
    public void exitReadkey(pascalParser.ReadkeyContext ctx) {
        System.out.println(getindentation() + "exit Readkey");
        decrease();
    }

    @Override
    public void enterReadln(pascalParser.ReadlnContext ctx) {
        increase();
        System.out.println(getindentation() + "enter Readln");
        if (contence) {
            System.out.println(getindentation() + ctx.getText());
        }
    }

    @Override
    public void exitReadln(pascalParser.ReadlnContext ctx) {
        System.out.println(getindentation() + "exit Readln");
        decrease();
    }

    @Override
    public void enterWrite(pascalParser.WriteContext ctx) {
        increase();
        System.out.println(getindentation() + "enter Write");
        if (contence) {
            System.out.println(getindentation() + ctx.getText());
        }
    }

    @Override
    public void exitWrite(pascalParser.WriteContext ctx) {
        System.out.println(getindentation() + "exit Write");
        decrease();
    }

    @Override
    public void enterWriteln(pascalParser.WritelnContext ctx) {
        increase();
        System.out.println(getindentation() + "enter Writeln");
        if (contence) {
            System.out.println(getindentation() + ctx.getText());
        }
    }

    @Override
    public void exitWriteln(pascalParser.WritelnContext ctx) {
        System.out.println(getindentation() + "exit Writeln");
        decrease();
    }

    @Override
    public void enterEmptyreadkey(pascalParser.EmptyreadkeyContext ctx) {
        increase();
        System.out.println(getindentation() + "enter Empty readkey");
        if (contence) {
            System.out.println(getindentation() + ctx.getText());
        }
    }

    @Override
    public void exitEmptyreadkey(pascalParser.EmptyreadkeyContext ctx) {
        System.out.println(getindentation() + "exit Empty readkey");
        decrease();
    }

    @Override
    public void enterEmptyreadln(pascalParser.EmptyreadlnContext ctx) {
        increase();
        System.out.println(getindentation() + "enter Empty readln");
        if (contence) {
            System.out.println(getindentation() + ctx.getText());
        }
    }

    @Override
    public void exitEmptyreadln(pascalParser.EmptyreadlnContext ctx) {
        System.out.println(getindentation() + "exit Empty readln");
        decrease();
    }

    @Override
    public void enterEmptywrite(pascalParser.EmptywriteContext ctx) {
        increase();
        System.out.println(getindentation() + "enter Empty write");
        if (contence) {
            System.out.println(getindentation() + ctx.getText());
        }
    }

    @Override
    public void exitEmptywrite(pascalParser.EmptywriteContext ctx) {
        System.out.println(getindentation() + "exit Empty write");
        decrease();
    }

    @Override
    public void enterEmptywriteln(pascalParser.EmptywritelnContext ctx) {
        increase();
        System.out.println(getindentation() + "enter Empty writeln");
        if (contence) {
            System.out.println(getindentation() + ctx.getText());
        }
    }

    @Override
    public void exitEmptywriteln(pascalParser.EmptywritelnContext ctx) {
        System.out.println(getindentation() + "exit Empty writeln");
        decrease();
    }

    @Override
    public void enterReadkeystatment(pascalParser.ReadkeystatmentContext ctx) {
        increase();
        System.out.println(getindentation() + "enter Readkey statment");
        if (contence) {
            System.out.println(getindentation() + ctx.getText());
        }
    }

    @Override
    public void exitReadkeystatment(pascalParser.ReadkeystatmentContext ctx) {
        System.out.println(getindentation() + "exit Readkey statment");
        decrease();
    }

    @Override
    public void enterReadlnstatment(pascalParser.ReadlnstatmentContext ctx) {
        increase();
        System.out.println(getindentation() + "enter Readln statment");
        if (contence) {
            System.out.println(getindentation() + ctx.getText());
        }
    }

    @Override
    public void exitReadlnstatment(pascalParser.ReadlnstatmentContext ctx) {
        System.out.println(getindentation() + "exit Readln statment");
        decrease();
    }

    @Override
    public void enterWritestatment(pascalParser.WritestatmentContext ctx) {
        increase();
        System.out.println(getindentation() + "enter Write statment");
        if (contence) {
            System.out.println(getindentation() + ctx.getText());
        }
    }

    @Override
    public void exitWritestatment(pascalParser.WritestatmentContext ctx) {
        System.out.println(getindentation() + "exit Write statment");
        decrease();
    }

    @Override
    public void enterWritelnstatment(pascalParser.WritelnstatmentContext ctx) {
        increase();
        System.out.println(getindentation() + "enter Writeln statment");
        if (contence) {
            System.out.println(getindentation() + ctx.getText());
        }
    }

    @Override
    public void exitWritelnstatment(pascalParser.WritelnstatmentContext ctx) {
        System.out.println(getindentation() + "exit Writeln statment");
        decrease();
    }

    @Override
    public void enterVariableDeclarationPart(pascalParser.VariableDeclarationPartContext ctx) {
        increase();
        System.out.println(getindentation() + "enter Variable Declaration Part");
        if (contence) {
            System.out.println(getindentation() + ctx.getText());
        }
    }

    @Override
    public void exitVariableDeclarationPart(pascalParser.VariableDeclarationPartContext ctx) {
        System.out.println(getindentation() + "exit Variable Declaration Part");
        decrease();
    }

    @Override
    public void enterVariableDeclaration(pascalParser.VariableDeclarationContext ctx) {
        increase();
        System.out.println(getindentation() + "enter Variable Declaration");
        if (contence) {
            System.out.println(getindentation() + ctx.getText());
        }
    }

    @Override
    public void exitVariableDeclaration(pascalParser.VariableDeclarationContext ctx) {
        System.out.println(getindentation() + "exit Variable Declaration");
        decrease();
    }

    @Override
    public void enterProcedureAndFunctionDeclarationPart(pascalParser.ProcedureAndFunctionDeclarationPartContext ctx) {
        increase();
        System.out.println(getindentation() + "enter Procedure And Function Declaration Part");
        if (contence) {
            System.out.println(getindentation() + ctx.getText());
        }
    }

    @Override
    public void exitProcedureAndFunctionDeclarationPart(pascalParser.ProcedureAndFunctionDeclarationPartContext ctx) {
        System.out.println(getindentation() + "exit Procedure And Function Declaration Part");
        decrease();
    }

    @Override
    public void enterProcedureOrFunctionDeclaration(pascalParser.ProcedureOrFunctionDeclarationContext ctx) {
        increase();
        System.out.println(getindentation() + "enter Procedure Or Function Declaration");
        if (contence) {
            System.out.println(getindentation() + ctx.getText());
        }
    }

    @Override
    public void exitProcedureOrFunctionDeclaration(pascalParser.ProcedureOrFunctionDeclarationContext ctx) {
        System.out.println(getindentation() + "exit Procedure Or Function Declaration");
        decrease();
    }

    @Override
    public void enterProcedureDeclaration(pascalParser.ProcedureDeclarationContext ctx) {
        increase();
        System.out.println(getindentation() + "enter Procedure Declaration");
        if (contence) {
            System.out.println(getindentation() + ctx.getText());
        }
    }

    @Override
    public void exitProcedureDeclaration(pascalParser.ProcedureDeclarationContext ctx) {
        System.out.println(getindentation() + "exit Procedure Declaration");
        decrease();
    }

    @Override
    public void enterFunctionDeclaration(pascalParser.FunctionDeclarationContext ctx) {
        increase();
        System.out.println(getindentation() + "enter Function Declaration");
        if (contence) {
            System.out.println(getindentation() + ctx.getText());
        }
    }

    @Override
    public void exitFunctionDeclaration(pascalParser.FunctionDeclarationContext ctx) {
        System.out.println(getindentation() + "exit Function Declaration");
        decrease();
    }

    @Override
    public void enterDirective(pascalParser.DirectiveContext ctx) {
        increase();
        System.out.println(getindentation() + "enter Directive");
        if (contence) {
            System.out.println(getindentation() + ctx.getText());
        }
    }

    @Override
    public void exitDirective(pascalParser.DirectiveContext ctx) {
        System.out.println(getindentation() + "exit Directive");
        decrease();
    }

    @Override
    public void enterFormalParameterList(pascalParser.FormalParameterListContext ctx) {
        increase();
        System.out.println(getindentation() + "enter Formal Parameter List");
        if (contence) {
            System.out.println(getindentation() + ctx.getText());
        }
    }

    @Override
    public void exitFormalParameterList(pascalParser.FormalParameterListContext ctx) {
        System.out.println(getindentation() + "exit Formal Parameter List");
        decrease();
    }

    @Override
    public void enterFormalParameterSection(pascalParser.FormalParameterSectionContext ctx) {
        increase();
        System.out.println(getindentation() + "enter Formal Parameter Section");
        if (contence) {
            System.out.println(getindentation() + ctx.getText());
        }
    }

    @Override
    public void exitFormalParameterSection(pascalParser.FormalParameterSectionContext ctx) {
        System.out.println(getindentation() + "exit Formal Parameter Section");
        decrease();
    }

    @Override
    public void enterParameterGroup(pascalParser.ParameterGroupContext ctx) {
        increase();
        System.out.println(getindentation() + "enter Parameter Group");
        if (contence) {
            System.out.println(getindentation() + ctx.getText());
        }
    }

    @Override
    public void exitParameterGroup(pascalParser.ParameterGroupContext ctx) {
        System.out.println(getindentation() + "exit Parameter Group");
        decrease();
    }

    @Override
    public void enterIdentifierList(pascalParser.IdentifierListContext ctx) {
        increase();
        System.out.println(getindentation() + "enter Identifier List");
        if (contence) {
            System.out.println(getindentation() + ctx.getText());
        }
    }

    @Override
    public void exitIdentifierList(pascalParser.IdentifierListContext ctx) {
        System.out.println(getindentation() + "exit Identifier List");
        decrease();
    }

    @Override
    public void enterConstList(pascalParser.ConstListContext ctx) {
        increase();
        System.out.println(getindentation() + "enter Const List");
        if (contence) {
            System.out.println(getindentation() + ctx.getText());
        }
    }

    @Override
    public void exitConstList(pascalParser.ConstListContext ctx) {
        System.out.println(getindentation() + "exit Const List");
        decrease();
    }

    @Override
    public void enterResultType(pascalParser.ResultTypeContext ctx) {
        increase();
        System.out.println(getindentation() + "enter Result Type");
        if (contence) {
            System.out.println(getindentation() + ctx.getText());
        }
    }

    @Override
    public void exitResultType(pascalParser.ResultTypeContext ctx) {
        System.out.println(getindentation() + "exit Result Type");
        decrease();
    }

    @Override
    public void enterStatement(pascalParser.StatementContext ctx) {
        increase();
        System.out.println(getindentation() + "enter Statement");
        if (contence) {
            System.out.println(getindentation() + ctx.getText());
        }
    }

    @Override
    public void exitStatement(pascalParser.StatementContext ctx) {
        System.out.println(getindentation() + "exit Statement");
        decrease();
    }

    @Override
    public void enterUnlabelledStatement(pascalParser.UnlabelledStatementContext ctx) {
        increase();
        System.out.println(getindentation() + "enter Unlabelled Statement");
        if (contence) {
            System.out.println(getindentation() + ctx.getText());
        }
    }

    @Override
    public void exitUnlabelledStatement(pascalParser.UnlabelledStatementContext ctx) {
        System.out.println(getindentation() + "exit Unlabelled Statement");
        decrease();
    }

    @Override
    public void enterExitStatement(pascalParser.ExitStatementContext ctx) {
        increase();
        System.out.println(getindentation() + "enter Exit Statement");
        if (contence) {
            System.out.println(getindentation() + ctx.getText());
        }
    }

    @Override
    public void exitExitStatement(pascalParser.ExitStatementContext ctx) {
        System.out.println(getindentation() + "exit Exit Statement");
        decrease();
    }

    @Override
    public void enterSimpleStatement(pascalParser.SimpleStatementContext ctx) {
        increase();
        System.out.println(getindentation() + "enter Simple Statement");
        if (contence) {
            System.out.println(getindentation() + ctx.getText());
        }
    }

    @Override
    public void exitSimpleStatement(pascalParser.SimpleStatementContext ctx) {
        System.out.println(getindentation() + "exit Simple Statement");
        decrease();
    }

    @Override
    public void enterAssignmentStatement(pascalParser.AssignmentStatementContext ctx) {
        increase();
        System.out.println(getindentation() + "enter Assignment Statement");
        if (contence) {
            System.out.println(getindentation() + ctx.getText());
        }
    }

    @Override
    public void exitAssignmentStatement(pascalParser.AssignmentStatementContext ctx) {
        System.out.println(getindentation() + "exit Assignment Statement");
        decrease();
    }

    @Override
    public void enterVariable(pascalParser.VariableContext ctx) {
        increase();
        System.out.println(getindentation() + "enter Variable");
        if (contence) {
            System.out.println(getindentation() + ctx.getText());
        }
    }

    @Override
    public void exitVariable(pascalParser.VariableContext ctx) {
        System.out.println(getindentation() + "exit Variable");
        decrease();
    }

    @Override
    public void enterExpression(pascalParser.ExpressionContext ctx) {
        increase();
        System.out.println(getindentation() + "enter Expression");
        if (contence) {
            System.out.println(getindentation() + ctx.getText());
        }
    }

    @Override
    public void exitExpression(pascalParser.ExpressionContext ctx) {
        System.out.println(getindentation() + "exit Expression");
        decrease();
    }

    @Override
    public void enterSimpleExpression(pascalParser.SimpleExpressionContext ctx) {
        increase();
        System.out.println(getindentation() + "enter Simple Expression");
        if (contence) {
            System.out.println(getindentation() + ctx.getText());
        }
    }

    @Override
    public void exitSimpleExpression(pascalParser.SimpleExpressionContext ctx) {
        System.out.println(getindentation() + "exit Simple Expression");
        decrease();
    }

    @Override
    public void enterTerm(pascalParser.TermContext ctx) {
        increase();
        System.out.println(getindentation() + "enter Term");
        if (contence) {
            System.out.println(getindentation() + ctx.getText());
        }
    }

    @Override
    public void exitTerm(pascalParser.TermContext ctx) {
        System.out.println(getindentation() + "exit Term");
        decrease();
    }

    @Override
    public void enterSignedFactor(pascalParser.SignedFactorContext ctx) {
        increase();
        System.out.println(getindentation() + "enter Signed Factor");
        if (contence) {
            System.out.println(getindentation() + ctx.getText());
        }
    }

    @Override
    public void exitSignedFactor(pascalParser.SignedFactorContext ctx) {
        System.out.println(getindentation() + "exit Signed Factor");
        decrease();
    }

    @Override
    public void enterFactor(pascalParser.FactorContext ctx) {
        increase();
        System.out.println(getindentation() + "enter Factor");
        if (contence) {
            System.out.println(getindentation() + ctx.getText());
        }
    }

    @Override
    public void exitFactor(pascalParser.FactorContext ctx) {
        System.out.println(getindentation() + "exit Factor");
        decrease();
    }

    @Override
    public void enterUnsignedConstant(pascalParser.UnsignedConstantContext ctx) {
        increase();
        System.out.println(getindentation() + "enter Unsigned Constant");
        if (contence) {
            System.out.println(getindentation() + ctx.getText());
        }
    }

    @Override
    public void exitUnsignedConstant(pascalParser.UnsignedConstantContext ctx) {
        System.out.println(getindentation() + "exit Unsigned Constant");
        decrease();
    }

    @Override
    public void enterFunctionDesignator(pascalParser.FunctionDesignatorContext ctx) {
        increase();
        System.out.println(getindentation() + "enter Function Designator");
        if (contence) {
            System.out.println(getindentation() + ctx.getText());
        }
    }

    @Override
    public void exitFunctionDesignator(pascalParser.FunctionDesignatorContext ctx) {
        System.out.println(getindentation() + "exit Function Designator");
        decrease();
    }

    @Override
    public void enterParameterList(pascalParser.ParameterListContext ctx) {
        increase();
        System.out.println(getindentation() + "enter Parameter List");
        if (contence) {
            System.out.println(getindentation() + ctx.getText());
        }
    }

    @Override
    public void exitParameterList(pascalParser.ParameterListContext ctx) {
        System.out.println(getindentation() + "exit Parameter List");
        decrease();
    }

    @Override
    public void enterSet(pascalParser.SetContext ctx) {
        increase();
        System.out.println(getindentation() + "enter Set");
        if (contence) {
            System.out.println(getindentation() + ctx.getText());
        }
    }

    @Override
    public void exitSet(pascalParser.SetContext ctx) {
        System.out.println(getindentation() + "exit Set");
        decrease();
    }

    @Override
    public void enterElementList(pascalParser.ElementListContext ctx) {
        increase();
        System.out.println(getindentation() + "enter Element List");
        if (contence) {
            System.out.println(getindentation() + ctx.getText());
        }
    }

    @Override
    public void exitElementList(pascalParser.ElementListContext ctx) {
        System.out.println(getindentation() + "exit Element List");
        decrease();
    }

    @Override
    public void enterElement(pascalParser.ElementContext ctx) {
        increase();
        System.out.println(getindentation() + "enter Element");
        if (contence) {
            System.out.println(getindentation() + ctx.getText());
        }
    }

    @Override
    public void exitElement(pascalParser.ElementContext ctx) {
        System.out.println(getindentation() + "exit Element");
        decrease();
    }

    @Override
    public void enterProcedureStatement(pascalParser.ProcedureStatementContext ctx) {
        increase();
        System.out.println(getindentation() + "enter Procedure Statement");
        if (contence) {
            System.out.println(getindentation() + ctx.getText());
        }
    }

    @Override
    public void exitProcedureStatement(pascalParser.ProcedureStatementContext ctx) {
        System.out.println(getindentation() + "exit Procedure Statement");
        decrease();
    }

    @Override
    public void enterActualParameter(pascalParser.ActualParameterContext ctx) {
        increase();
        System.out.println(getindentation() + "enter Actual Parameter");
        if (contence) {
            System.out.println(getindentation() + ctx.getText());
        }
    }

    @Override
    public void exitActualParameter(pascalParser.ActualParameterContext ctx) {
        System.out.println(getindentation() + "exit Actual Parameter");
        decrease();
    }

    @Override
    public void enterGotoStatement(pascalParser.GotoStatementContext ctx) {
        increase();
        System.out.println(getindentation() + "enter Goto Statement");
        if (contence) {
            System.out.println(getindentation() + ctx.getText());
        }
    }

    @Override
    public void exitGotoStatement(pascalParser.GotoStatementContext ctx) {
        System.out.println(getindentation() + "exit Goto Statement");
        decrease();
    }

    @Override
    public void enterEmptyStatement(pascalParser.EmptyStatementContext ctx) {
        increase();
        System.out.println(getindentation() + "enter Empty Statement");
        if (contence) {
            System.out.println(getindentation() + ctx.getText());
        }
    }

    @Override
    public void exitEmptyStatement(pascalParser.EmptyStatementContext ctx) {
        System.out.println(getindentation() + "exit Empty Statement");
        decrease();
    }

    @Override
    public void enterEmpty(pascalParser.EmptyContext ctx) {
        increase();
        System.out.println(getindentation() + "enter Empty");
        if (contence) {
            System.out.println(getindentation() + ctx.getText());
        }
    }

    @Override
    public void exitEmpty(pascalParser.EmptyContext ctx) {
        System.out.println(getindentation() + "exit Empty");
        decrease();
    }

    @Override
    public void enterStructuredStatement(pascalParser.StructuredStatementContext ctx) {
        increase();
        System.out.println(getindentation() + "enter Structured Statement");
        if (contence) {
            System.out.println(getindentation() + ctx.getText());
        }
    }

    @Override
    public void exitStructuredStatement(pascalParser.StructuredStatementContext ctx) {
        System.out.println(getindentation() + "exit Structured Statement");
        decrease();
    }

    @Override
    public void enterCompoundStatement(pascalParser.CompoundStatementContext ctx) {
        increase();
        System.out.println(getindentation() + "enter Compound Statement");
        if (contence) {
            System.out.println(getindentation() + ctx.getText());
        }
    }

    @Override
    public void exitCompoundStatement(pascalParser.CompoundStatementContext ctx) {
        System.out.println(getindentation() + "exit Compound Statement");
        decrease();
    }

    @Override
    public void enterStatements(pascalParser.StatementsContext ctx) {
        increase();
        System.out.println(getindentation() + "enter Statements");
        if (contence) {
            System.out.println(getindentation() + ctx.getText());
        }
    }

    @Override
    public void exitStatements(pascalParser.StatementsContext ctx) {
        System.out.println(getindentation() + "exit Statements");
        decrease();
    }

    @Override
    public void enterConditionalStatement(pascalParser.ConditionalStatementContext ctx) {
        increase();
        System.out.println(getindentation() + "enter Conditional Statement");
        if (contence) {
            System.out.println(getindentation() + ctx.getText());
        }
    }

    @Override
    public void exitConditionalStatement(pascalParser.ConditionalStatementContext ctx) {
        System.out.println(getindentation() + "exit Conditional Statement");
        decrease();
    }

    @Override
    public void enterIfStatement(pascalParser.IfStatementContext ctx) {
        increase();
        System.out.println(getindentation() + "enter If Statement");
        if (contence) {
            System.out.println(getindentation() + ctx.getText());
        }
    }

    @Override
    public void exitIfStatement(pascalParser.IfStatementContext ctx) {
        System.out.println(getindentation() + "exit If Statement");
        decrease();
    }

    @Override
    public void enterCaseStatement(pascalParser.CaseStatementContext ctx) {
        increase();
        System.out.println(getindentation() + "enter Case Statement");
        if (contence) {
            System.out.println(getindentation() + ctx.getText());
        }
    }

    @Override
    public void exitCaseStatement(pascalParser.CaseStatementContext ctx) {
        System.out.println(getindentation() + "exit Case Statement");
        decrease();
    }

    @Override
    public void enterCaseListElement(pascalParser.CaseListElementContext ctx) {
        increase();
        System.out.println(getindentation() + "enter Case List Element");
        if (contence) {
            System.out.println(getindentation() + ctx.getText());
        }
    }

    @Override
    public void exitCaseListElement(pascalParser.CaseListElementContext ctx) {
        System.out.println(getindentation() + "exit Case List Element");
        decrease();
    }

    @Override
    public void enterRepetetiveStatement(pascalParser.RepetetiveStatementContext ctx) {
        increase();
        System.out.println(getindentation() + "enter Repetetive Statement");
        if (contence) {
            System.out.println(getindentation() + ctx.getText());
        }
    }

    @Override
    public void exitRepetetiveStatement(pascalParser.RepetetiveStatementContext ctx) {
        System.out.println(getindentation() + "exit Repetetive Statement");
        decrease();
    }

    @Override
    public void enterWhileStatement(pascalParser.WhileStatementContext ctx) {
        increase();
        System.out.println(getindentation() + "enter While Statement");
        if (contence) {
            System.out.println(getindentation() + ctx.getText());
        }
    }

    @Override
    public void exitWhileStatement(pascalParser.WhileStatementContext ctx) {
        System.out.println(getindentation() + "exit While Statement");
        decrease();
    }

    @Override
    public void enterRepeatStatement(pascalParser.RepeatStatementContext ctx) {
        increase();
        System.out.println(getindentation() + "enter Repeat Statement");
        if (contence) {
            System.out.println(getindentation() + ctx.getText());
        }
    }

    @Override
    public void exitRepeatStatement(pascalParser.RepeatStatementContext ctx) {
        System.out.println(getindentation() + "exit Repeat Statement");
        decrease();
    }

    @Override
    public void enterForStatement(pascalParser.ForStatementContext ctx) {
        increase();
        System.out.println(getindentation() + "enter For Statement");
        if (contence) {
            System.out.println(getindentation() + ctx.getText());
        }
    }

    @Override
    public void exitForStatement(pascalParser.ForStatementContext ctx) {
        System.out.println(getindentation() + "exit For Statement");
        decrease();
    }

    @Override
    public void enterForList(pascalParser.ForListContext ctx) {
        increase();
        System.out.println(getindentation() + "enter For List");
        if (contence) {
            System.out.println(getindentation() + ctx.getText());
        }
    }

    @Override
    public void exitForList(pascalParser.ForListContext ctx) {
        System.out.println(getindentation() + "exit For List");
        decrease();
    }

    @Override
    public void enterInitialValue(pascalParser.InitialValueContext ctx) {
        increase();
        System.out.println(getindentation() + "enter Initial Value");
        if (contence) {
            System.out.println(getindentation() + ctx.getText());
        }
    }

    @Override
    public void exitInitialValue(pascalParser.InitialValueContext ctx) {
        System.out.println(getindentation() + "exit Initial Value");
        decrease();
    }

    @Override
    public void enterFinalValue(pascalParser.FinalValueContext ctx) {
        increase();
        System.out.println(getindentation() + "enter Final Value");
        if (contence) {
            System.out.println(getindentation() + ctx.getText());
        }
    }

    @Override
    public void exitFinalValue(pascalParser.FinalValueContext ctx) {
        System.out.println(getindentation() + "exit Final Value");
        decrease();
    }

    @Override
    public void enterWithStatement(pascalParser.WithStatementContext ctx) {
        increase();
        System.out.println(getindentation() + "enter With Statement");
        if (contence) {
            System.out.println(getindentation() + ctx.getText());
        }
    }

    @Override
    public void exitWithStatement(pascalParser.WithStatementContext ctx) {
        System.out.println(getindentation() + "exit With Statement");
        decrease();
    }

    @Override
    public void enterRecordVariableList(pascalParser.RecordVariableListContext ctx) {
        increase();
        System.out.println(getindentation() + "enter Record Variable List");
        if (contence) {
            System.out.println(getindentation() + ctx.getText());
        }
    }

    @Override
    public void exitRecordVariableList(pascalParser.RecordVariableListContext ctx) {
        System.out.println(getindentation() + "exit Record Variable List");
        decrease();
    }
} // class myListener


grammar pascal;

program
    : programHeading ('INTERFACE')?
      block
      DOT
    ;

programHeading
    : 'PROGRAMProcedureOrFunction' identifier (LPAREN identifierList RPAREN)? SEMI
    | 'UNIT' identifier SEMI
  ;

identifier
    : IDENT
    ;

block
    : ( labelDeclarationPart
      | constantDefinitionPart
      | typeDefinitionPart
      | variableDeclarationPart
      | procedureAndFunctionDeclarationPart
      | usesUnitsPart
      | 'IMPLEMENTATION'
      )*
      compoundStatement
    ;

usesUnitsPart
    : 'USES' identifierList SEMI
    ;

labelDeclarationPart
    : 'LABEL' label ( COMMA label )* SEMI
    ;

label
    : unsignedInteger
    ;

constantDefinitionPart
    : 'CONST' constantDefinition ( SEMI constantDefinition )* SEMI
    ;

constantDefinition
    : identifier EQUAL constant
    ;

constantChr
    : 'CHR' LPAREN (unsignedInteger|identifier) RPAREN
    ;

constant
    : unsignedNumber
    | sign unsignedNumber
    | identifier
    | sign identifier
    | string
    | constantChr
    ;

unsignedNumber
    : unsignedInteger
    | unsignedReal
    ;

unsignedInteger
    : NUM_INT
    ;

unsignedReal
    : NUM_REAL
    ;

sign
    : PLUS | MINUS
    ;

string
    : STRING_LITERAL
    ;

typeDefinitionPart
    : 'TYPE' typeDefinition ( SEMI typeDefinition )* SEMI
    ;

typeDefinition
    : identifier EQUAL
      ( type
      | functionType
      | procedureType
      )
    ;

functionType
    : 'FUNCTION' (formalParameterList)? COLON resultType
    ;

procedureType
    : 'PROCEDURE' (formalParameterList)?
    ;

type
    : simpleType
    | structuredType
    | pointerType
    ;

simpleType
    : scalarType
    | subrangeType
    | typeIdentifier
    | stringtype
    ;

scalarType
    : LPAREN identifierList RPAREN
    ;

subrangeType
    : constant DOTDOT constant
    ;

typeIdentifier
    : identifier
    | 'CHAR'
    | 'BOOLEAN'
    | 'INTEGER'
    | 'REAL'
    | 'STRING'
    ;

structuredType
    : 'PACKED' unpackedStructuredType
   | unpackedStructuredType
    ;

unpackedStructuredType
    : arrayType
    | recordType
    | setType
    | fileType
    | subrangeType
    ;

stringtype
    : 'STRING' LPAREN (identifier|unsignedNumber) RPAREN
    | 'STRING' LBRACK2 (identifier|unsignedNumber) RBRACK2
    ;

arrayType
    : 'ARRAY' LBRACK typeList RBRACK 'OF' componentType
    | 'ARRAY' LBRACK2 typeList RBRACK2 'OF' componentType
  ;

typeList
  : indexType ( COMMA indexType )*
  ;

indexType
    : simpleType
    ;

componentType
    : type
    ;

recordType
    : 'RECORD' fieldList 'END'
    ;

fieldList
    : ( fixedPart ( SEMI variantPart | SEMI )?
      | variantPart
      )
    ;

fixedPart
    : recordSection ( SEMI recordSection )*
    ;

recordSection
    : identifierList COLON type
    ;

variantPart
    : 'CASE' tag 'OF' variant ( SEMI variant | SEMI )*
    ;

tag
    : identifier COLON typeIdentifier
    | typeIdentifier
    ;

variant
    : constList COLON LPAREN fieldList RPAREN
    ;

setType
    : 'SET' 'OF' simpleType
    ;

fileType
    : 'FILE' 'OF'  type
    | 'FILE'
    ;

pointerType
    : 'POINTER' typeIdentifier
    ;

variableDeclarationPart
    : 'VAR'  variableDeclaration ( SEMI variableDeclaration )* SEMI
    ;

variableDeclaration
    : identifierList COLON type
    ;

procedureAndFunctionDeclarationPart
    : procedureOrFunctionDeclaration SEMI
    ;

procedureOrFunctionDeclaration
    : procedureDeclaration
    | functionDeclaration
    ;

procedureDeclaration
    : 'PROCEDURE'  identifier (formalParameterList)? SEMI
      ( block | directive )
    ;

functionDeclaration
    : 'FUNCTION' identifier (formalParameterList)? COLON resultType SEMI
      ( block | directive )
    ;

directive
    : 'FORWARD'
    ;


formalParameterList
    : LPAREN formalParameterSection ( SEMI formalParameterSection )* RPAREN
    ;

formalParameterSection
    : parameterGroup
    | 'VAR' parameterGroup
    | 'FUNCTION' parameterGroup
    | 'PROCEDURE' parameterGroup
    ;

parameterGroup
    : identifierList COLON typeIdentifier
    ;

identifierList
    : identifier ( COMMA identifier )*
    ;

constList
    : constant ( COMMA constant )*
    ;

resultType
    : typeIdentifier
    ;

statement
    : label COLON unlabelledStatement
    | unlabelledStatement
    ;

unlabelledStatement
    : simpleStatement
    | structuredStatement
    ;

exitStatement
    : 'EXIT'
    ;


simpleStatement
    : assignmentStatement
    | procedureStatement
    | exitStatement
    | gotoStatement
    | emptyStatement
    ;

assignmentStatement
    : variable ASSIGN expression
    ;

variable
    : ( 'AT' identifier
      | identifier
      )
      (  LBRACK expression ( COMMA expression)* RBRACK
      | LBRACK2 expression ( COMMA expression)* RBRACK2
      | DOT identifier
      | 'POINTER'
      )*
    ;

expression
    : simpleExpression
    ( (EQUAL | NOT_EQUAL | LT | LE | GE | GT | 'IN') simpleExpression )*
    ;

simpleExpression
    : term ( (PLUS | MINUS | 'OR') term )*
    ;

term
  : signedFactor ( (STAR | SLASH | 'DIV' | 'MOD' | 'AND') signedFactor )*
    ;

signedFactor
    : (PLUS|MINUS)? factor
    ;

factor
    : variable
    | LPAREN expression RPAREN
    | functionDesignator
    | unsignedConstant
    | set
    | 'NOT' factor
    ;

unsignedConstant
    : unsignedNumber
    | constantChr
    | string
    | 'NIL'
    ;

functionDesignator
    : identifier LPAREN parameterList RPAREN
    ;

parameterList
    : actualParameter ( COMMA actualParameter )*
    ;

set
    : LBRACK elementList RBRACK
    | LBRACK2 elementList RBRACK2
    ;

elementList
    : element ( COMMA element )*
    |
    ;

element
    : expression ( DOTDOT expression )?
    ;

procedureStatement
    : identifier ( LPAREN parameterList RPAREN )?
    ;

actualParameter
    : expression (COLON unsignedInteger)?
    ;

gotoStatement
    : 'GOTO' label
    ;

emptyStatement
    :
    ;

empty
    : // nothing
    ;

structuredStatement
    : compoundStatement
    | conditionalStatement
    | repetetiveStatement
    | withStatement
    ;

compoundStatement
    : 'BEGIN'
    statements
      'END'
    ;

statements
    : statement ( SEMI statement )*
    ;

conditionalStatement
    : ifStatement
    | caseStatement
    ;

ifStatement
    : 'IF' expression 'THEN' statement
      (
     'ELSE' statement
    )?
    ;

caseStatement
    : 'CASE' expression 'OF'
        caseListElement ( SEMI caseListElement )* SEMI?
      ( 'ELSE' statements )?
      'END'
    ;

caseListElement
    : constList COLON statement
    ;

repetetiveStatement
    : whileStatement
    | repeatStatement
    | forStatement
    ;

whileStatement
    : 'WHILE' expression 'DO' statement
    ;

repeatStatement
    : 'REPEAT' statements 'UNTIL' expression
    ;

forStatement
    : 'FOR' identifier ASSIGN forList 'DO' statement
    ;

forList
    : initialValue ('TO' | 'DOWNTO') finalValue
    ;

initialValue
    : expression
    ;

finalValue
    : expression
    ;

withStatement
    : 'WITH' recordVariableList 'DO' statement
    ;

recordVariableList
    : variable ( COMMA variable )*
    ;

// Whitespace -- ignored
WS  :   [ \t\r\n]+ -> skip ;

COMMENT_1
        :   LPAREN STAR .*? STAR RPAREN
        ;

COMMENT_2
        :  LCURLY .*? RCURLY
  ;

IDENT  :  ('a'..'z'|'A'..'Z') ('a'..'z'|'A'..'Z'|'0'..'9'|'_')*
  ;

STRING_LITERAL
  : '\'' ('\'\'' | ~('\''))* '\''
  ;

// a numeric literal.  Form is (from Wirth)
//  digits
//  digits . digits
//  digits . digits exponent
//  digits exponent
//
NUM_INT
  : ('0'..'9')+
  ;

NUM_REAL
  : ([0-9])+ DOT [0-9]+ EXPONENT?
  ;

EXPONENT
  :  ('e') ('+'|'-')? ('0'..'9')+
  ;


PLUS            : '+'   ;
MINUS           : '-'   ;
STAR            : '*'   ;
SLASH           : '/'   ;
ASSIGN          : ':='  ;
COMMA           : ','   ;
SEMI            : ';'   ;
COLON           : ':'   ;
EQUAL           : '='   ;
NOT_EQUAL       : '<>'  ;
LT              : '<'   ;
LE              : '<='  ;
GE              : '>='  ;
GT              : '>'   ;
LPAREN          : '('   ;
RPAREN          : ')'   ;
LBRACK          : '['   ;
LBRACK2         : '(.'  ;
RBRACK          : ']'   ;
RBRACK2         : '.)'  ;
POINTER         : '^'   ;
AT              : '@'   ;
DOT             : '.' ;
DOTDOT          : '..';
LCURLY          : '{' ;
RCURLY          : '}' ;
